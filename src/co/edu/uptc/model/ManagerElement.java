package co.edu.uptc.model;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.dashboard.DirectionEnum;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ManagerElement {

    private int speed = 100;
    private DirectionEnum direction = DirectionEnum.LEFT;
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
                element.setTextSize(Config.TEXT_SIZE);
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
                X = random.nextInt(1000 - Config.CIRCLE_SIZE);
                break;
            case IMAGE:
                X = random.nextInt(1000 - Config.IMAGE_WIDTH);
                break;
            case TEXT:
                X = random.nextInt(1000 - 40);
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
                Y = random.nextInt(600 - 40);
                break;
        }
        return Y;
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
            //leftCircle();
        }
        if (direction == DirectionEnum.RIGHT) {
            //rightCircle();
        }
        if (direction == DirectionEnum.UP) {
            //upCircle();
        }
        if (direction == DirectionEnum.DOWN) {
            //downCircle();
        }
    }

}
