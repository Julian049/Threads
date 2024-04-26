package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.pojo.Element;
import co.edu.uptc.view.dashboard.Dashboard;

import java.util.ArrayList;

public class ManagerPresenter implements ContractPlay.Presenter {

    private ContractPlay.View view;
    private ContractPlay.Model model;

    @Override
    public void setView(ContractPlay.View view) {
        this.view = view;
    }

    @Override
    public void setModel(ContractPlay.Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        makeMVP();
        view.run();
    }

    public void makeMVP() {
        ManagerModel managerModel = new ManagerModel();
        managerModel.setPresenter(this);

        Dashboard dashboard = new Dashboard();
        dashboard.setPresenter(this);

        setModel(managerModel);
        setView(dashboard);
    }

    @Override
    public void start() {
        model.start();
        view.moveElements();
        view.manageAddButtonState(false);
        view.manageStartButtonState(false);
        view.manageStopButtonState(true);
    }

    @Override
    public void stop() {
        model.stop();
        view.manageAddButtonState(true);
        view.manageStartButtonState(true);
        view.manageStopButtonState(false);
    }

    @Override
    public void loadAndPaint() {
        model.setPanelHeight(view.getWorkPanelHeight());
        model.setPanelWidth(view.getWorkPanelWidth());
        ArrayList<Element> elements = model.loadElements(view.getNumberElements());
        view.setElements(elements);
        view.paintElements();
        view.manageStartButtonState(true);
        view.manageStopButtonState(true);
    }

    @Override
    public int getPanelWidth() {
        return view.getWorkPanelWidth();
    }

    @Override
    public int getPanelHeight() {
        return view.getWorkPanelHeight();
    }

}
