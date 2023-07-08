package fr.iwaki.iwalib.files;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {

    public String getResourceFilePath(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String filePath = classLoader.getResource(fileName).getFile();
        if (filePath == null) {
            throw new IllegalArgumentException("Can't load the given resource (" + fileName + ") : ");
        } else {
            return filePath;
        }
    }

    public InputStream getResourceAsStream(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new NullPointerException("Can't load the given resource (" + fileName + ") : ");
        } else {
            return inputStream;
        }
    }

    public Image loadDefaultImage(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("Can't load the given image (" + fileName + ")");
        } else {
            return ImageIO.read(inputStream);
        }
    }

    public BufferedImage loadDefaultBufferedImage(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IOException("Can't load the given image (" + fileName + ")");
        } else {
            return ImageIO.read(inputStream);
        }
    }
}