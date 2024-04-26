package co.edu.uptc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int UI_UPDATE_SPEED = Integer.parseInt(properties.getProperty("UIUpdateSpeed"));
    public static int CIRCLE_SIZE = Integer.parseInt(properties.getProperty("circleSize"));
    public static int IMAGE_HEIGHT = Integer.parseInt(properties.getProperty("imageHeight"));
    public static int IMAGE_WIDTH = Integer.parseInt(properties.getProperty("imageWidth"));
    public static String IMAGE_PATH = properties.getProperty("imagePath");
    public static String IMAGE_PATH_2 = properties.getProperty("imagePath2");
    public static String IMAGE_PATH_3 = properties.getProperty("imagePath3");
    public static String IMAGE_PATH_4 = properties.getProperty("imagePath4");
    public static int MOVING_PIXELS = Integer.parseInt(properties.getProperty("movingPixels"));
    public static int MAX_SPEED = Integer.parseInt(properties.getProperty("maxSpeed"));
    public static int MIN_SPEED = Integer.parseInt(properties.getProperty("minSpeed"));
    public static String TEXT = properties.getProperty("text");
    public static int WIDTH = Integer.parseInt(properties.getProperty("UIWidth"));
    public static int HEIGHT = Integer.parseInt(properties.getProperty("UIHeight"));
    public static int SQUARE_SIZE = Integer.parseInt(properties.getProperty("squareSize"));
    public static int TEXT_SIZE = Integer.parseInt(properties.getProperty("textSize"));

}
