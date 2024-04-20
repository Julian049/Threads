package co.edu.uptc.view.dashboard;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.view.WorkPanel;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame implements ContractPlay.View {

    public MenuPanel menuPanel;
    protected WorkPanel workPanel;
    public ContractPlay.Presenter presenter;

    public Dashboard() {
        initComponents();
    }

    private Dashboard getInstance(){
        return this;
    }

    private void initComponents() {
        setBounds(1, 1, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        menuPanel = new MenuPanel();
        menuPanel.setDashboard(getInstance());
        this.add(menuPanel, BorderLayout.NORTH);

        workPanel = new WorkPanel(this);
        this.add(workPanel, BorderLayout.CENTER);
    }

    @Override
    public void run() {
        workPanel.moveBall();
        setVisible(true);
    }

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }
}
