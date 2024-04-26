package co.edu.uptc.model;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.dashboard.DirectionEnum;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ManagerElement {

    private Boolean running = false;
    private int panelWidth;
    private int panelHeight;
    private ArrayList<Element> elementsList = new ArrayList<>();

    public TypeMovement randomDirection() {
        Random random = new Random();
        TypeMovement newTypeMovement = null;
        int option = random.nextInt(2);
        switch (option) {
            case 0:
                newTypeMovement = TypeMovement.HORIZONTAL;
                break;
            case 1:
                newTypeMovement = TypeMovement.VERTICAL;
                break;
        }
        return newTypeMovement;
    }

    public TypeElementEnum randomType() {
        Random random = new Random();
        TypeElementEnum newType = null;
        int option = random.nextInt(4);
        switch (option) {
            case 0:
                newType = TypeElementEnum.CIRCLE;
                break;
            case 1:
                newType = TypeElementEnum.IMAGE;
                break;
            case 2:
                newType = TypeElementEnum.SQUARE;
                break;
            case 3:
                newType = TypeElementEnum.TEXT;
                break;
        }
        return newType;
    }

    public int randomSpeed() {
        Random random = new Random();
        int min = Config.MIN_SPEED;
        int max = Config.MAX_SPEED;
        return random.nextInt((max - min) + 1) + min;
    }

    public ArrayList<Element> addElements(int numberElements) {
        ArrayList<Element> elements = new ArrayList<>();
        Element newElement;
        for (int i = 0; i < numberElements; i++) {
            newElement = new Element();
            newElement.setType(randomType());
            this.setSize(newElement);
            this.setImage(newElement, newElement.getImageWidth(), newElement.getImageHeight());
            newElement.setXCoordinate(randomX(newElement.getType()));
            newElement.setYCoordinate(randomY(newElement.getType()));
            newElement.setSpeed(randomSpeed());
            newElement.setTypeMovement(randomDirection());
            this.setDirection(newElement);
            this.initText(newElement);
            elements.add(newElement);
        }
        return elements;
    }

    private void setSize(Element element) {
        switch (element.getType()) {
            case CIRCLE:
                element.setCircleSize(Config.CIRCLE_SIZE);
                break;
            case SQUARE:
                element.setSquareSize(Config.SQUARE_SIZE);
                break;
            case IMAGE:
                element.setImageHeight(Config.IMAGE_HEIGHT);
                element.setImageWidth(Config.IMAGE_WIDTH);
                break;
            case TEXT:
                element.setTextFontSize(Config.TEXT_SIZE);
                break;
        }
    }

    private void setImage(Element element, int width, int height) {
        if (element.getType().equals(TypeElementEnum.IMAGE)) {
            ImageIcon image = new ImageIcon(Config.IMAGE_PATH);
            image = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            element.setImage(image);
        }
    }

    private int randomX(TypeElementEnum type) {
        Random random = new Random();
        int X = 0;
        switch (type) {
            case CIRCLE:
            case SQUARE:
                X = random.nextInt(getPanelWidth() - Config.CIRCLE_SIZE);
                break;
            case IMAGE:
                X = random.nextInt(getPanelWidth() - Config.IMAGE_WIDTH);
                break;
            case TEXT:
                X = random.nextInt(getPanelWidth() - Config.TEXT_SIZE);
                break;
        }
        return X;
    }

    private int randomY(TypeElementEnum type) {
        Random random = new Random();
        int Y = 0;
        switch (type) {
            case CIRCLE:
            case SQUARE:
                Y = random.nextInt(getPanelHeight() - Config.CIRCLE_SIZE);
                break;
            case IMAGE:
                Y = random.nextInt(getPanelHeight() - Config.IMAGE_HEIGHT);
                break;
            case TEXT:
                Y = random.nextInt(getPanelHeight() - Config.TEXT_SIZE);
                break;
        }
        return Y;
    }

    private void initText(Element element) {
        if (element.getType().equals(TypeElementEnum.TEXT)) {
            element.setTextFontSize(Config.TEXT_SIZE);
            Font font = new Font("Arial", Font.BOLD, element.getTextFontSize());
            element.setFont(font);
            element.setText(Config.TEXT);
        }
    }

    private void setDirection(Element element) {
        if (element.getTypeMovement().equals(TypeMovement.HORIZONTAL)) {
            int option = new Random().nextInt(2);
            switch (option) {
                case 0:
                    element.setDirection(DirectionEnum.LEFT);
                    break;
                case 1:
                    element.setDirection(DirectionEnum.RIGHT);
                    break;
            }
        } else {
            int option = new Random().nextInt(2);
            switch (option) {
                case 0:
                    element.setDirection(DirectionEnum.UP);
                    break;
                case 1:
                    element.setDirection(DirectionEnum.DOWN);
                    break;
            }
        }
    }

    public ArrayList<Element> loadElements(int numberElements) {
        this.setElementsList(addElements(numberElements));
        return elementsList;
    }

    public void setElementsList(ArrayList<Element> elementsList) {
        this.elementsList = elementsList;
    }

    public void stopElement() {
        this.running = false;
    }

    public void startElement() {
        this.running = true;

        for (Element element : getElementsList()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running) {
                        try {
                            Thread.sleep(element.getSpeed());
                            move(element);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }
    
    public void move(Element element) {
        if (element.getDirection() == DirectionEnum.LEFT) {
            left(element);
        }
        if (element.getDirection() == DirectionEnum.RIGHT) {
            right(element);
        }
        if (element.getDirection() == DirectionEnum.UP) {
            up(element);
        }
        if (element.getDirection() == DirectionEnum.DOWN) {
            down(element);
        }
    }

    public void left(Element element) {
        element.setXCoordinate(element.getXCoordinate() - Config.MOVING_PIXELS);
        if (element.getXCoordinate() < 0) {
            element.setDirection(DirectionEnum.RIGHT);
        }
    }

    public void right(Element element) {
        element.setXCoordinate(element.getXCoordinate() + Config.MOVING_PIXELS);
        switch (element.getType()) {
            case CIRCLE:
                if (element.getXCoordinate() >= (getPanelWidth() - element.getCircleSize())) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
            case SQUARE:
                if (element.getXCoordinate() >= (getPanelWidth() - element.getSquareSize())) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
            case IMAGE:
                if (element.getXCoordinate() >= (getPanelWidth() - (element.getImageWidth()))) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
            case TEXT:
                if (element.getXCoordinate() >= (getPanelWidth() - element.getTextWidth())) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
        }

    }

    public void down(Element element) {
        element.setYCoordinate(element.getYCoordinate() + Config.MOVING_PIXELS);
        switch (element.getType()) {
            case CIRCLE:
                if (element.getYCoordinate() >= (getPanelHeight() - element.getCircleSize())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
            case SQUARE:
                if (element.getYCoordinate() >= (getPanelHeight() - element.getSquareSize())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
            case IMAGE:
                if (element.getYCoordinate() >= (getPanelHeight() - element.getImageHeight())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
            case TEXT:
                if (element.getYCoordinate() >= (getPanelHeight())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
        }
    }

    public void up(Element element) {
        element.setYCoordinate(element.getYCoordinate() - Config.MOVING_PIXELS);
        if (!element.getType().equals(TypeElementEnum.TEXT)) {
            if (element.getYCoordinate() < 0) {
                element.setDirection(DirectionEnum.DOWN);
            }
        } else {
            if (element.getYCoordinate() <= element.getTextHeight()) {
                element.setDirection(DirectionEnum.DOWN);
            }
        }
    }

    public ArrayList<Element> getElementsList() {
        return elementsList;
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
    }

}
