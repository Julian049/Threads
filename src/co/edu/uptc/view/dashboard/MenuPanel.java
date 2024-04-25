package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JButton btnCircleUp;
    private JButton btnCircleDown;
    private JButton btnCircleLeft;
    private JButton btnCircleRight;
    private JButton btnImageUp;
    private JButton btnImageDown;
    private JButton btnImageLeft;
    private JButton btnImageRight;
    private Dashboard dashboard;
    private JButton btnStart;
    private JButton btnStop;
    private JLabel lblAddText;
    private JTextField numberElementsToAdd;
    private JButton btnAdd;

    public MenuPanel() {
        initComponents();
    }

    public void setDashboard(Dashboard dashboard){
        this.dashboard = dashboard;
    }

    private void initComponents() {
        createButtons();
        addButtons();
    }

    private void createButtons() {
        btnCircleUp = new JButton("^");
        btnCircleDown = new JButton("v");
        btnCircleLeft = new JButton("<");
        btnCircleRight = new JButton(">");
        btnImageUp = new JButton("^");
        btnImageDown = new JButton("v");
        btnImageLeft = new JButton("<");
        btnImageRight = new JButton(">");

        createButtonStart();
        createButtonStop();
        createLabelAddText();
        createTextFieldNumberElementsToAdd();
        createButtonAdd();
    }

    private void addButtons() {
        createButtonRightCircle();
        createButtonLeftCircle();
        createButtonUpCircle();
        createButtonDownCircle();
        createButtonDownImage();
        createButtonUpImage();
        createButtonLeftImage();
        createButtonRightImage();
        add(btnCircleUp);
        add(btnCircleDown);
        add(btnCircleLeft);
        add(btnCircleRight);
        add(btnStart);
        add(btnStop);
        add(btnImageUp);
        add(btnImageDown);
        add(btnImageLeft);
        add(btnImageRight);
    }

    private void createButtonStart() {
        btnStart = new JButton();
        btnStart.setText("Start");
        this.add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.start();
            }
        });
    }

    private void createButtonStop() {
        btnStop = new JButton();
        btnStop.setText("Stop");
        this.add(btnStop);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.stop();
            }
        });
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

    public void createButtonRightCircle() {
        btnCircleRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.rightCircle();
            }
        });
    }

    public void createButtonLeftCircle() {
        btnCircleLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.leftCircle();
            }
        });
    }

    public void createButtonUpCircle(){
        btnCircleUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.upCircle();
            }
        });
    }

    public void createButtonDownCircle(){
        btnCircleDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.downCircle();
            }
        });
    }

    public void createButtonDownImage(){
        btnImageDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.downImage();
            }
        });
    }

    public void createButtonUpImage(){
        btnImageUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.upImage();
            }
        });
    }

    public void createButtonLeftImage(){
        btnImageLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.leftImage();
            }
        });
    }

    public void createButtonRightImage(){
        btnImageRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.rightImage();
            }
        });
    }

    public JTextField getNumberElementsToAdd() {
        return numberElementsToAdd;
    }
}
