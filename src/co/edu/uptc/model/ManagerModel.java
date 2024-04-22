package co.edu.uptc.model;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.presenter.ContractPlay;

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
    public void addElements(int numberElements) {
        elementModel.addElements(numberElements);
    }

    public void rightCircle() {
        elementModel.rightCircle();
    }

    public void leftCircle() {
        elementModel.leftCircle();
    }

    public void upCircle() {
        elementModel.upCircle();
    }

    public void downCircle() {
        elementModel.downCircle();
    }

    public void rightImage() {
        elementModel.rightImage();
    }

    public void leftImage() {
        elementModel.leftImage();
    }

    public void upImage() {
        elementModel.upImage();
    }

    public void downImage() {
        elementModel.downImage();
    }

    @Override
    public Element getElements() {
        Element element = elementModel.getElement();
        return element;
    }

    public ManagerModel() {
        createElement();
    }

    public void createElement() {
        elementModel = new ManagerElement();
    }

}
