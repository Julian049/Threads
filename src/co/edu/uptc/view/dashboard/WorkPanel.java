package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel {

    private int x = 200;
    private int y = 100;

    public WorkPanel() {
        initComponents();
    }

    private void initComponents() {
        setBounds(100, 100, 450, 300);
        setBackground(Color.BLUE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.GREEN);
        g.fillOval(x, y, 200, 200);

    }

    public void left() {
        x = x - 10;
        repaint();
    }

    public void right() {
        x = x + 10;
        repaint();
    }

    public void down() {
        y = y + 10;
        repaint();
    }

    public void up() {
        y = y - 10;
        repaint();
    }
}
