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

//    public TypeMovement randomDirection() {
//        Random random = new Random();
//        TypeMovement newTypeMovement = null;
//        int option = random.nextInt(3);
//        switch (option) {
//            case 0:
//                newTypeMovement = TypeMovement.HORIZONTAL;
//                break;
//            case 1:
//                newTypeMovement = TypeMovement.VERTICAL;
//                break;
//            case 2:
//                newTypeMovement = TypeMovement.DIAGONAL;
//                break;
//        }
//        return newTypeMovement;
//    }

    public TypeMovement randomDirection() {
        return TypeMovement.DIAGONAL;
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
            newElement.setPoint(randomPoint(newElement.getType()));
            newElement.setSpeed(randomSpeed());
            newElement.setTypeMovement(randomDirection());
            this.setDirection(newElement);
            this.initText(newElement);
            this.randomAngle(newElement);
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
            ImageIcon image = randomImage();
            image = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            element.setImage(image);
        }
    }

    private ImageIcon randomImage() {
        Random random = new Random();
        int option = random.nextInt(4);
        ImageIcon image = null;
        switch (option) {
            case 0:
                image = new ImageIcon(Config.IMAGE_PATH);
                break;
            case 1:
                image = new ImageIcon(Config.IMAGE_PATH_2);
                break;
            case 2:
                image = new ImageIcon(Config.IMAGE_PATH_3);
                break;
            case 3:
                image = new ImageIcon(Config.IMAGE_PATH_4);
                break;
        }
        return image;
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

    private Point randomPoint(TypeElementEnum type) {
        Random random = new Random();
        int X = 0;
        int Y = 0;
        switch (type) {
            case CIRCLE:
            case SQUARE:
                X = random.nextInt(getPanelWidth() - Config.CIRCLE_SIZE);
                Y = random.nextInt(getPanelHeight() - Config.CIRCLE_SIZE);
                break;
            case IMAGE:
                X = random.nextInt(getPanelWidth() - Config.IMAGE_WIDTH);
                Y = random.nextInt(getPanelHeight() - Config.IMAGE_HEIGHT);
                break;
            case TEXT:
                X = random.nextInt(getPanelWidth() - Config.TEXT_SIZE);
                Y = random.nextInt(getPanelHeight() - Config.TEXT_SIZE);
                break;
        }
        return new Point(X, Y);
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
        } else if (element.getTypeMovement().equals(TypeMovement.VERTICAL)) {
            int option = new Random().nextInt(2);
            switch (option) {
                case 0:
                    element.setDirection(DirectionEnum.UP);
                    break;
                case 1:
                    element.setDirection(DirectionEnum.DOWN);
                    break;
            }
        } else {
            int option = new Random().nextInt(4);
            switch (option) {
                case 0:
                    element.setDirection(DirectionEnum.DIAGONAL_UP_LEFT);
                    break;
                case 1:
                    element.setDirection(DirectionEnum.DIAGONAL_UP_RIGHT);
                    break;
                case 2:
                    element.setDirection(DirectionEnum.DIAGONAL_DOWN_LEFT);
                    break;
                case 3:
                    element.setDirection(DirectionEnum.DIAGONAL_DOWN_RIGHT);
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

        Thread thread = new Thread(() -> {
            System.out.println(running);
            while (running) {
                for (Element element : elementsList) {
                    moveDiagonal(element);
                    move(element);
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    private void moveDiagonal(Element element) {
        if (element.getTypeMovement() == TypeMovement.DIAGONAL) {
            initDiagonalMovement(element);
        }
    }

    private void randomAngle(Element element) {
        Random random = new Random();
        int angle = random.nextInt(360);
        element.setAngle(angle);
    }

    private void initDiagonalMovement(Element element) {
        double angleInRadians = Math.toRadians(element.getAngle());
        double speedX = element.getSpeed() * Math.cos(angleInRadians);
        double speedY = element.getSpeed() * Math.sin(angleInRadians);

        switch (element.getType()) {
            case CIRCLE:
                if (element.getPoint().x < 0 || element.getPoint().x + element.getCircleSize() > getPanelWidth()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                if (element.getPoint().y < 0 || element.getPoint().y + element.getCircleSize() > getPanelHeight()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                break;
            case SQUARE:
                if (element.getPoint().x < 0 || element.getPoint().x + element.getSquareSize() > getPanelWidth()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                if (element.getPoint().y < 0 || element.getPoint().y + element.getSquareSize() > getPanelHeight()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                break;
            case IMAGE:
                if (element.getPoint().x < 0 || element.getPoint().x + element.getImageWidth() > getPanelWidth()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                if (element.getPoint().y < 0 || element.getPoint().y + element.getImageHeight() > getPanelHeight()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                break;
            case TEXT:
                if (element.getPoint().x < 0 || element.getPoint().x + element.getTextWidth() > getPanelWidth()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                if (element.getPoint().y < 0 || element.getPoint().y + element.getTextHeight() > getPanelHeight()) {
                    element.setAngle(new Random().nextInt(360));
                    angleInRadians = Math.toRadians(element.getAngle());
                    speedX = element.getSpeed() * Math.cos(angleInRadians);
                    speedY = element.getSpeed() * Math.sin(angleInRadians);
                }
                break;
        }


        int newX = (int) (element.getPoint().x + speedX);
        int newY = (int) (element.getPoint().y + speedY);
        element.setPoint(new Point(newX, newY));
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
        element.setPoint(new Point(element.getPoint().x - element.getSpeed(), element.getPoint().y));
        if (element.getPoint().x < 0) {
            element.setDirection(DirectionEnum.RIGHT);
        }
    }

    public void right(Element element) {
        element.setPoint(new Point(element.getPoint().x + element.getSpeed(), element.getPoint().y));
        switch (element.getType()) {
            case CIRCLE:
                if (element.getPoint().x >= (getPanelWidth() - element.getCircleSize())) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
            case SQUARE:
                if (element.getPoint().x >= (getPanelWidth() - element.getSquareSize())) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
            case IMAGE:
                if (element.getPoint().x >= (getPanelWidth() - (element.getImageWidth()))) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
            case TEXT:
                if (element.getPoint().x >= (getPanelWidth() - element.getTextWidth())) {
                    element.setDirection(DirectionEnum.LEFT);
                }
                break;
        }

    }

    public void down(Element element) {
        element.setPoint(new Point(element.getPoint().x, element.getPoint().y + element.getSpeed()));
        switch (element.getType()) {
            case CIRCLE:
                if (element.getPoint().y >= (getPanelHeight() - element.getCircleSize())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
            case SQUARE:
                if (element.getPoint().y >= (getPanelHeight() - element.getSquareSize())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
            case IMAGE:
                if (element.getPoint().y >= (getPanelHeight() - element.getImageHeight())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
            case TEXT:
                if (element.getPoint().y >= (getPanelHeight())) {
                    element.setDirection(DirectionEnum.UP);
                }
                break;
        }
    }

    public void up(Element element) {
        element.setPoint(new Point(element.getPoint().x, element.getPoint().y - element.getSpeed()));
        if (!element.getType().equals(TypeElementEnum.TEXT)) {
            if (element.getPoint().y < 0) {
                element.setDirection(DirectionEnum.DOWN);
            }
        } else {
            if (element.getPoint().y <= element.getTextHeight()) {
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
