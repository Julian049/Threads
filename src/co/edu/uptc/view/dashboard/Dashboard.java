package co.edu.uptc.view.dashboard;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.WorkPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        setSize(Config.WIDTH, Config.HEIGHT);
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
        setVisible(true);
    }

    @Override
    public void moveElements() {
        workPanel.UIUpdate();
    }

    @Override
    public int getNumberElements() {
        if (!menuPanel.getNumberElementsToAdd().getText().isEmpty()) {
            return Integer.parseInt(menuPanel.getNumberElementsToAdd().getText());
        } else {
            return 0;
        }
    }

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void paintElements() {
        workPanel.repaint();
    }

    @Override
    public void setElements(ArrayList<Element> elements) {
        workPanel.setTemp(elements);
    }
}
