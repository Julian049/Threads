package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private Dashboard dashboard;
    private JButton btnStart;
    private JButton btnStop;
    private JLabel lblAddText;
    private JTextField numberElementsToAdd;
    private JButton btnAdd;

    public MenuPanel() {
        initComponents();
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    private void initComponents() {
        createButtons();
    }

    private void createButtons() {
        createLabelAddText();
        createTextFieldNumberElementsToAdd();
        createButtonAdd();
        createButtonStart();
        createButtonStop();
    }

    private void createButtonStart() {
        btnStart = new JButton();
        btnStart.setText("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.start();
            }
        });
        btnStart.setEnabled(false);
        this.add(btnStart);
    }

    private void createButtonStop() {
        btnStop = new JButton();
        btnStop.setText("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.stop();
            }
        });
        btnStop.setEnabled(false);
        this.add(btnStop);
    }

    private void createButtonAdd() {
        btnAdd = new JButton();
        btnAdd.setText("Add");
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.loadAndPaint();
            }
        });
    }

    private void createLabelAddText() {
        lblAddText = new JLabel();
        lblAddText.setText("Number of elements to add:");
        this.add(lblAddText);
    }

    private void createTextFieldNumberElementsToAdd() {
        numberElementsToAdd = new JTextField();
        numberElementsToAdd.setColumns(10);
        this.add(numberElementsToAdd);
    }

    public JTextField getNumberElementsToAdd() {
        return numberElementsToAdd;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }
}
