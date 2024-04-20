package co.edu.uptc.model;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.view.dashboard.DirectionEnum;

import java.awt.*;

public class ManagerElement {

    private int speed = 100;
    private DirectionEnum direction = DirectionEnum.LEFT;
    private Element element;
    private Boolean running = false;

    public ManagerElement() {
        this.element = new Element();
        this.element.setCircleX(10);
        this.element.setCircleY(10);
        this.element.setPadding(10);
        this.element.setHeight(30);
        this.element.setWidth(30);
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
        element.setCircleX(element.getCircleX() - 10);
        if (element.getCircleX() <= 1) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightCircle() {
        element.setCircleX(element.getCircleX() + 10);
        if (element.getCircleX() >= 450) {
            direction = DirectionEnum.LEFT;
        }
    }

    public void downCircle() {
        element.setCircleY(element.getCircleY() + 10);
        if (element.getCircleY() >= 450) {
            direction = DirectionEnum.UP;
        }
    }

    public void upCircle() {
        element.setCircleY(element.getCircleY() - 10);
        if (element.getCircleY() <= 1) {
            direction = DirectionEnum.DOWN;
        }
    }

    public void leftImage() {
        element.setImageX(element.getImageX() - 10);
        if (element.getImageX() <= 1) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightImage() {
        element.setImageX(element.getImageX() + 10);
        if (element.getImageX() >= 450) {
            direction = DirectionEnum.LEFT;
        }
    }

    public void downImage() {
        element.setImageY(element.getImageY() + 10);
        if (element.getImageY() >= 450) {
            direction = DirectionEnum.UP;
        }
    }

    public void upImage() {
        element.setImageY(element.getImageY() - 10);
        if (element.getImageY() <= 1) {
            direction = DirectionEnum.DOWN;
        }
    }
}
