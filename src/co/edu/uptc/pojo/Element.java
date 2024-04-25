package co.edu.uptc.pojo;

import co.edu.uptc.model.TypeElementEnum;
import co.edu.uptc.model.TypeMovement;

import java.awt.*;

public class Element {
    private int circleX;
    private int circleY;
    private int imageX;
    private int imageY;
    private int height;
    private int width;
    public Image image=null;
    public TypeElementEnum type;
    public int speed;
    public TypeMovement typeMovement;

    public TypeMovement getTypeMovement() {
        return typeMovement;
    }

    public void setTypeMovement(TypeMovement typeMovement) {
        this.typeMovement = typeMovement;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public TypeElementEnum getType() {
        return type;
    }

    public void setType(TypeElementEnum type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getCircleX() {
        return circleX;
    }

    public void setCircleX(int circleX) {
        this.circleX = circleX;
    }

    public int getCircleY() {
        return circleY;
    }

    public void setCircleY(int circleY) {
        this.circleY = circleY;
    }

    public int getImageX() {
        return imageX;
    }

    public void setImageX(int imageX) {
        this.imageX = imageX;
    }

    public int getImageY() {
        return imageY;
    }

    public void setImageY(int imageY) {
        this.imageY = imageY;
    }
}
