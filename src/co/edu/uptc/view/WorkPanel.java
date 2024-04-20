package co.edu.uptc.view;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.view.dashboard.Dashboard;
import co.edu.uptc.view.dashboard.DirectionEnum;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel {

    private int speed = 80;
    private Element element = new Element();
    private Dashboard dashboard;

    public WorkPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        moveBall();
    }

    private void initComponents() {
        setBounds(100, 100, 450, 300);
        setBackground(Color.BLUE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.GREEN);
        g.fillOval(element.getCircleX(), element.getCircleY(), 200, 200);

        ImageIcon icon = new ImageIcon("resources/image.jpg");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH));
        g2d.drawImage(icon.getImage(), element.getImageX(), element.getImageY(), null);

    }

    public void moveBall() {
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

}
