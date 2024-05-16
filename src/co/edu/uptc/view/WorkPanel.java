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
        for (Element element : elements) {
            switch (element.getType()) {
                case CIRCLE:
                    g.setColor(Color.RED);
                    g.fillOval(element.getPoint().x, element.getPoint().y, element.getCircleSize(), element.getCircleSize());
                    break;
                case SQUARE:
                    g.setColor(Color.GREEN);
                    g.fillRect(element.getPoint().x, element.getPoint().y, element.getSquareSize(), element.getSquareSize());
                    break;
                case IMAGE:
                    g.drawImage(element.getImage().getImage(), element.getPoint().x, element.getPoint().y, null);
                    break;
                case TEXT:
                    g.setColor(Color.BLACK);
                    Font font = element.getFont();
                    g.setFont(font);
                    g.drawString(element.getText(), element.getPoint().x, element.getPoint().y);
                    FontMetrics metrics = g.getFontMetrics(font);
                    element.setTextWidth(metrics.stringWidth(Config.TEXT));
                    element.setTextHeight(metrics.getHeight());
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
