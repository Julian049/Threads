package co.edu.uptc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties properties = new Properties();

    public Config() {
        loadProperties();
    }

    private void loadProperties() {
        try {
            properties.load(new FileInputStream("src/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getUIUpdateSpeed() {
        return Integer.parseInt(properties.getProperty("UIUpdateSpeed"));
    }

    public int getCircleSize() {
        return Integer.parseInt(properties.getProperty("circleSize"));
    }

    public int getImageHeight() {
        return Integer.parseInt(properties.getProperty("imageHeight"));
    }

    public int getImageWidth() {
        return Integer.parseInt(properties.getProperty("imageWidth"));
    }

    public String getImagePath() {
        return properties.getProperty("imagePath");
    }

    public int getUIWidth() {
        return Integer.parseInt(properties.getProperty("UIWidth"));
    }

    public int getUIHeight() {
        return Integer.parseInt(properties.getProperty("UIHeight"));
    }

    public int getCircleSpeed() {
        return Integer.parseInt(properties.getProperty("circleSpeed"));
    }

    public int getCircleX() {
        return Integer.parseInt(properties.getProperty("circleCoordinateX"));
    }

    public int getCircleY() {
        return Integer.parseInt(properties.getProperty("circleCoordinateY"));
    }

    public int getImageX() {
        return Integer.parseInt(properties.getProperty("imageCoordinateX"));
    }

    public int getImageY() {
        return Integer.parseInt(properties.getProperty("imageCoordinateY"));
    }

    public int getMovingPixels() {
        return Integer.parseInt(properties.getProperty("movingPixels"));
    }
    public int getMinSpeed() {
        return Integer.parseInt(properties.getProperty("minSpeed"));
    }

    public int getMaxSpeed() {
        return Integer.parseInt(properties.getProperty("maxSpeed"));
    }
}
