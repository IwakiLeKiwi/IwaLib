package fr.iwaki.iwalib.ui;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class CustomFonts {

    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = CustomFonts.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public Font customFont(String path) {
        Font customFont = loadFont(path, 24f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);
        return customFont;

    }

    private Font loadFont(String path, float size){
        try {
            Font myFont = Font.createFont(Font.TRUETYPE_FONT, getFileFromResourceAsStream(path));
            return myFont.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    // Awt Fonts
    public Font kollektifFont = customFont("fonts/Kollektif.ttf");
    public Font kollektifBoldFont = customFont("fonts/Kollektif-Bold.ttf");
    public Font kollektifBoldItalicFont = customFont("fonts/Kollektif-BoldItalic.ttf");
    public Font kollektifItalicFont = customFont("fonts/Kollektif-Italic.ttf");
    public Font minecraftiaFont = customFont("fonts/Minecraftia-Regular.ttf");

    public Font robotoThinFont = customFont("fonts/Roboto-Thin.ttf");
    public Font robotoThinItalicFont = customFont("fonts/Roboto-ThinItalic.ttf");
    public Font robotoRegularFont = customFont("fonts/Roboto-Regular.ttf");
    public Font robotoItalicFont = customFont("fonts/Roboto-Italic.ttf");
    public Font robotoLightFont = customFont("fonts/Roboto-Light.ttf");
    public Font robotoLightItalicFont = customFont("fonts/Roboto-LightItalic.ttf");
    public Font robotoMediumFont = customFont("fonts/Roboto-Medium.ttf");
    public Font robotoMediumItalicFont = customFont("fonts/Roboto-MediumItalic.ttf");
    public Font robotoBoldFont = customFont("fonts/Roboto-Bold.ttf");
    public Font robotoBoldItalicFont = customFont("fonts/Roboto-BoldItalic.ttf");
    public Font robotoBlackFont = customFont("fonts/Roboto-Black.ttf");
    public Font robotoBlackItalicFont = customFont("fonts/Roboto-BlackItalic.ttf");
}
