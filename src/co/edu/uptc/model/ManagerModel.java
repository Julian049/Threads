package co.edu.uptc.model;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.presenter.ContractPlay;

import java.util.ArrayList;

public class ManagerModel implements ContractPlay.Model {

    private ManagerElement elementModel = new ManagerElement();
    private ContractPlay.Presenter presenter;

    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        elementModel.startElement();
    }

    @Override
    public void stop() {
        elementModel.stopElement();
    }

    @Override
    public ArrayList<Element> loadElements(int numberElements) {
        return elementModel.loadElements(numberElements);
    }

    public ManagerModel() {
        createElement();
    }

    public void createElement() {
        elementModel = new ManagerElement();
    }

}
