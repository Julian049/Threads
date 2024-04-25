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
        ArrayList<Element> elements = elementModel.loadElements(numberElements);
        return elements;
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
    public Element getElement() {
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
