package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerModel;
import co.edu.uptc.pojo.Element;
import co.edu.uptc.view.dashboard.Dashboard;

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
    public Element getElement() {
        return model.getElements();
    }

    @Override
    public void start() {
        model.start();
    }

    @Override
    public void stop() {
        model.stop();
    }

    @Override
    public void addElements(int numberElements) {
        model.addElements(numberElements);
    }

    @Override
    public void rightCircle() {
        model.rightCircle();
    }

    @Override
    public void leftCircle() {
        model.leftCircle();
    }

    @Override
    public void upCircle() {
        model.upCircle();
    }

    @Override
    public void downCircle() {
        model.downCircle();
    }

    @Override
    public void rightImage() {
        model.rightImage();
    }

    @Override
    public void leftImage() {
        model.leftImage();
    }

    @Override
    public void upImage() {
        model.upImage();
    }

    @Override
    public void downImage() {
        model.downImage();
    }


}
