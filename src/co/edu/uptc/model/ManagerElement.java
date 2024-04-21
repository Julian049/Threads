package co.edu.uptc.model;

import co.edu.uptc.pojo.Element;
import co.edu.uptc.utils.Config;
import co.edu.uptc.view.dashboard.DirectionEnum;

import javax.swing.*;
import java.awt.*;

public class ManagerElement {

    private Config config = new Config();
    private DirectionEnum direction = DirectionEnum.LEFT;
    private Element element;
    private Boolean running = false;

    public ManagerElement() {
        this.element = new Element();
        this.element.setCircleX(config.getCircleX());
        this.element.setCircleY(config.getCircleY());
        this.element.setPadding(10);
        this.element.setHeight(config.getUIHeight());
        this.element.setWidth(config.getUIWidth());
        this.element.setCircleSize(config.getCircleSize());
        this.element.setImageX(config.getImageX());
        this.element.setImageY(config.getImageY());
        this.element.setImageWidth(config.getImageWidth());
        this.element.setImageHeight(config.getImageHeight());
        this.element.setImage(new ImageIcon(config.getImagePath()).getImage());
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
                        Thread.sleep(config.getCircleSpeed());
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
        element.setCircleX(element.getCircleX() - config.getMovingPixels());
        if (element.getCircleX() <= 1) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightCircle() {
        element.setCircleX(element.getCircleX() + config.getMovingPixels());
        if (element.getCircleX() > element.getWidth() - element.getCircleSize()){
            direction = DirectionEnum.LEFT;
        }
    }

    public void downCircle() {
        element.setCircleY(element.getCircleY() + config.getMovingPixels());
        if (element.getCircleY() > element.getHeight() - element.getCircleSize()) {
            direction = DirectionEnum.UP;
        }
    }

    public void upCircle() {
        element.setCircleY(element.getCircleY() - config.getMovingPixels());
        if (element.getCircleY() <= 1) {
            direction = DirectionEnum.DOWN;
        }
    }

    public void leftImage() {
        element.setImageX(element.getImageX() - config.getMovingPixels());
        if (element.getImageX() <= 1) {
            direction = DirectionEnum.RIGHT;
        }
    }

    public void rightImage() {
        element.setImageX(element.getImageX() + config.getMovingPixels());
        if (element.getImageX() >= element.getWidth() - 1){
            direction = DirectionEnum.LEFT;
        }
    }

    public void downImage() {
        element.setImageY(element.getImageY() + config.getMovingPixels());
        if (element.getImageY() >= element.getHeight() - 1){
            direction = DirectionEnum.UP;
        }
    }

    public void upImage() {
        element.setImageY(element.getImageY() - config.getMovingPixels());
        if (element.getImageY() <= 1) {
            direction = DirectionEnum.DOWN;
        }
    }
}
