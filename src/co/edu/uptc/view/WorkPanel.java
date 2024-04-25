package co.edu.uptc.view;

import co.edu.uptc.model.TypeElementEnum;
import co.edu.uptc.pojo.Element;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.dashboard.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WorkPanel extends JPanel {

    private int speed = Config.UI_UPDATE_SPEED;
    private Element element = new Element();
    private Dashboard dashboard;
    private ArrayList<Element> temp = new ArrayList<>();

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
        g.drawLine(0,600,1000,600);
        g.drawLine(1000,0,1000,600);

        for (int i = 0; i < temp.size(); i++) {
            Element element = temp.get(i);
            if (element.getType().equals(TypeElementEnum.CIRCLE)) {
                g.setColor(Color.RED);
                g.fillOval(element.getCircleX(), element.getCircleY(), element.getWidth(), element.getHeight());
            } else if (element.getType().equals(TypeElementEnum.SQUARE)) {
                g.setColor(Color.GREEN);
                g.fillRect(element.getCircleX(), element.getCircleY(), element.getWidth(), element.getHeight());
            } else if (element.getType().equals(TypeElementEnum.IMAGE)) {
                ImageIcon icon = new ImageIcon(Config.IMAGE_PATH);
                icon = new ImageIcon(icon.getImage().getScaledInstance(Config.IMAGE_WIDTH, Config.IMAGE_HEIGHT, Image.SCALE_SMOOTH));
                g.drawImage(icon.getImage(), element.getCircleX(), element.getCircleY(), null);
            }else if(element.getType().equals(TypeElementEnum.TEXT)){
                g.setColor(Color.BLACK);
                g.drawString(Config.TEXT, element.getCircleX(), element.getCircleY());
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
                        element = dashboard.presenter.getElement();
                    } catch (InterruptedException e) {

                    }
                    repaint();
                }
            }
        });
        thread.start();
    }

    public void setTemp(ArrayList<Element> temp) {
        this.temp = temp;
    }
}
