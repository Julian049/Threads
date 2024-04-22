package co.edu.uptc.view.dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JButton btnStart;
    private JButton btnStop;
    private Dashboard dashboard;
    private JLabel numberCircleLabel;
    private JTextField numberCircleField;
    private JButton btnAdd;
    private JButton btnCircleUp;
    private JButton btnCircleDown;
    private JButton btnCircleLeft;
    private JButton btnCircleRight;
    private JButton btnImageUp;
    private JButton btnImageDown;
    private JButton btnImageLeft;
    private JButton btnImageRight;


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
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnCircleUp = new JButton("^");
        btnCircleDown = new JButton("v");
        btnCircleLeft = new JButton("<");
        btnCircleRight = new JButton(">");
        btnImageUp = new JButton("^");
        btnImageDown = new JButton("v");
        btnImageLeft = new JButton("<");
        btnImageRight = new JButton(">");
        numberCircleLabel = new JLabel("Number of circles: ");
        numberCircleField = new JTextField();
        numberCircleField.setColumns(5);
        btnAdd = new JButton("Add");
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
        createButtonStart();
        createButtonStop();
        createButtonAdd();
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
        add(numberCircleLabel);
        add(numberCircleField);
        add(btnAdd);
    }

    public JTextField getNumberCircleField() {
        return numberCircleField;
    }

    private void createButtonStart() {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.start();
            }
        });
    }

    private void createButtonStop() {
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.stop();
            }
        });
    }

    private void createButtonAdd() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.presenter.addElements(Integer.parseInt(getNumberCircleField().getText()));
            }
        });
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
}
