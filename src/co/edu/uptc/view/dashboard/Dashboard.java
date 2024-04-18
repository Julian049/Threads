package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public MenuPanel menuPanel;
    protected WorkPanel workPanel;

    public Dashboard() {
        initComponents();
    }

    private Dashboard getInstance(){
        return this;
    }

    private void initComponents() {
        setBounds(1, 1, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        menuPanel = new MenuPanel();
        menuPanel.setDashboard(getInstance());
        this.add(menuPanel, BorderLayout.NORTH);

        workPanel = new WorkPanel();
        this.add(workPanel, BorderLayout.CENTER);
    }

    public void run() {
        setVisible(true);
    }
}
