package co.edu.uptc.model;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.dashboard.DirectionEnum;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ManagerElement {

    private int speed = 100;
    private DirectionEnum direction = DirectionEnum.LEFT;
    private Element element;
    private Boolean running = false;

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
        int min = 80;
        int max = 1000;
        return random.nextInt((max - min) + 1) + min;
    }

    public ArrayList<Element> addElements(int numberElements) {
        ArrayList<Element> elements = new ArrayList<>();
        Element newElement;
        for (int i = 0; i < numberElements; i++) {
            newElement = new Element();
            newElement.setType(randomType());
            newElement.setHeight(this.setHeight(newElement.getType()));
            newElement.setWidth(this.setWidth(newElement.getType()));
            newElement.setCircleX(randomX(newElement.getType()));
            newElement.setCircleY(randomY(newElement.getType()));
            newElement.setSpeed(randomSpeed());
            newElement.setTypeMovement(randomDirection());
            elements.add(newElement);
        }
        return elements;
    }

    private int setHeight(TypeElementEnum type) {
        int height = 0;
        switch (type) {
            case CIRCLE:
            case SQUARE:
                height = Config.CIRCLE_SIZE;
                break;
            case IMAGE:
                height = Config.IMAGE_HEIGHT;
                break;
            case TEXT:
                height = 80;
                break;
        }
        return height;
    }

    private int setWidth(TypeElementEnum type) {
        int width = 0;
        switch (type) {
            case CIRCLE:
            case SQUARE:
                width = Config.CIRCLE_SIZE;
                break;
            case IMAGE:
                width = Config.IMAGE_WIDTH;
                break;
            case TEXT:
                width = 80;
                break;
        }
        return width;
    }

    private int randomX(TypeElementEnum type) {
        Random random = new Random();
        int X = 0;
        switch (type) {
            case CIRCLE:
            case SQUARE:
                X = random.nextInt(1000 - Config.CIRCLE_SIZE);
                break;
            case IMAGE:
                X = random.nextInt(1000 - Config.IMAGE_WIDTH);
                break;
            case TEXT:
                X = random.nextInt(1000 - 80);
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
                Y = random.nextInt(600 - Config.CIRCLE_SIZE);
                break;
            case IMAGE:
                Y = random.nextInt(600 - Config.IMAGE_HEIGHT);
                break;
            case TEXT:
                Y = random.nextInt(600 - 80);
                break;
        }
        return Y;
    }

    public ArrayList<Element> loadElements(int numberElements) {
        this.setElementsList(addElements(numberElements));
        return elementsList;
    }

    public ArrayList<Element> getElementsList() {
        return elementsList;
    }

    public void setElementsList(ArrayList<Element> elementsList) {
        this.elementsList = elementsList;
    }

    public void stopElement() {
        this.running = false;
    }

    public Element getElement() {
        return element;
    }

    public void setImage(Image image) {
        element.setImage(image);
    }

    public int getCircleX() {
        return element.getCircleX();
    }

    public int getCircleY() {
        return element.getCircleY();
    }

    public int getWidth() {
        return element.getWidth();
    }

    public int getHeight() {
        return element.getHeight();
    }

    public void startElement() {
        this.running = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(speed);
                        move();
                    } catch (InterruptedException e) {

                    }
                }
            }
        });
        thread.start();
    }

    public void move() {
        if (direction == DirectionEnum.LEFT) {
            leftCircle();
        }
        if (direction == DirectionEnum.RIGHT) {
            rightCircle();
        }
        if (direction == DirectionEnum.UP) {
            upCircle();
        }
        if (direction == DirectionEnum.DOWN) {
            downCircle();
        }
    }

    public void leftCircle() {
        element.setCircleX(element.getCircleX() - Config.MOVING_PIXELS);
        if (element.getCircleX() <= 1) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightCircle() {
        element.setCircleX(element.getCircleX() + Config.MOVING_PIXELS);
        if (element.getCircleX() >= Config.WIDTH) {
            direction = DirectionEnum.LEFT;
        }
    }

    public void downCircle() {
        element.setCircleY(element.getCircleY() + Config.MOVING_PIXELS);
        if (element.getCircleY() >= Config.HEIGHT) {
            direction = DirectionEnum.UP;
        }
    }

    public void upCircle() {
        element.setCircleY(element.getCircleY() - Config.MOVING_PIXELS);
        if (element.getCircleY() <= 1) {
            direction = DirectionEnum.DOWN;
        }
    }

    public void leftImage() {
        element.setImageX(element.getImageX() - Config.MOVING_PIXELS);
        if (element.getImageX() <= 1) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightImage() {
        element.setImageX(element.getImageX() + Config.MOVING_PIXELS);
        if (element.getImageX() >= Config.WIDTH) {
            direction = DirectionEnum.LEFT;
        }
    }

    public void downImage() {
        element.setImageY(element.getImageY() + Config.MOVING_PIXELS);
        if (element.getImageY() >= Config.HEIGHT) {
            direction = DirectionEnum.UP;
        }
    }

    public void upImage() {
        element.setImageY(element.getImageY() - Config.MOVING_PIXELS);
        if (element.getImageY() <= 1) {
            direction = DirectionEnum.DOWN;
        }
    }
}
