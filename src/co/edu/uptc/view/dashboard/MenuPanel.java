package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JButton btnStart;
    private JButton btnStop;

    private JButton btnUp;
    private JButton btnDown;
    private JButton btnLeft;
    private JButton btnRight;

    private Dashboard dashboard;

    public MenuPanel() {
        initComponents();
    }

    public void setDashboard(Dashboard dashboard){
        this.dashboard = dashboard;
    }

    private void initComponents() {
        setBounds(1, 1, 450, 50);
        createButtons();
        addButtons();
    }

    private void createButtons() {
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnUp = new JButton("^");
        btnDown = new JButton("v");
        btnLeft = new JButton("<");
        btnRight = new JButton(">");
    }

    private void addButtons() {
        createButtonRight();
        createButtonLeft();
        createButtonUp();
        createButtonDown();
        add(btnStart);
        add(btnStop);
        add(btnUp);
        add(btnDown);
        add(btnLeft);
        add(btnRight);
    }

    public void createButtonRight() {
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.workPanel.right();
            }
        });
    }

    public void createButtonLeft() {
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.workPanel.left();
            }
        });
    }

    public void createButtonUp(){
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.workPanel.up();
            }
        });
    }

    public void createButtonDown(){
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.workPanel.down();
            }
        });
    }
}
