package co.edu.uptc.view;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.dashboard.Dashboard;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel {

    private Config config = new Config();
    private Element element = new Element();
    private Dashboard dashboard;

    public WorkPanel(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        threadPaint();
    }

    private void initComponents() {
        setBackground(Color.BLUE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.GREEN);
        g.fillOval(element.getCircleX(), element.getCircleY(), element.getCircleSize(), element.getCircleSize());

//        ImageIcon icon = new ImageIcon(element.getImage());
//        icon = new ImageIcon(icon.getImage().getScaledInstance(element.getImageWidth(), element.getImageHeight(), Image.SCALE_SMOOTH));
//        g2d.drawImage(icon.getImage(), element.getImageX(), element.getImageY(), null);

    }

    public void threadPaint() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(config.getUIUpdateSpeed());
                        element = dashboard.presenter.getElement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        thread.start();
    }

}
