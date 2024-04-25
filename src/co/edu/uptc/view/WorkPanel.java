package co.edu.uptc.view;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.dashboard.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WorkPanel extends JPanel {

    private final int speed = Config.UI_UPDATE_SPEED;
    private Dashboard dashboard;
    private ArrayList<Element> elements = new ArrayList<>();

    public WorkPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
    }

    private void initComponents() {
        setBackground(Color.BLUE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.drawLine(0, 600, 1000, 600);
        g.drawLine(1000, 0, 1000, 600);

        for (Element element : elements) {
            switch (element.getType()) {
                case CIRCLE:
                    g.setColor(Color.RED);
                    g.fillOval(element.getXCoordinate(), element.getYCoordinate(), element.getCircleSize(), element.getCircleSize());
                    break;
                case SQUARE:
                    g.setColor(Color.GREEN);
                    g.fillRect(element.getXCoordinate(), element.getYCoordinate(), element.getSquareSize(), element.getSquareSize());
                    break;
                case IMAGE:
                    g.drawImage(element.getImage().getImage(), element.getXCoordinate(), element.getYCoordinate(), null);
                    break;
                case TEXT:
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Arial", Font.BOLD, element.getTextSize()));
                    g.drawString(Config.TEXT, element.getXCoordinate(), element.getYCoordinate());
                    break;
            }
        }
    }

    public void UIUpdate() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        thread.start();
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
}
