package fr.iwaki.iwalib.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {

    protected static Color staticTrackColor = new Color(49, 49, 49);
    protected static Color staticTrackHighlightColor = new Color(30, 30, 30);
    protected static Color staticThumbColor = new Color(30, 30, 30);
    protected static Color staticThumbDarkShadowColor = new Color(54, 54, 54);
    protected static Color staticThumbLightShadowColor = new Color(30, 30, 30);
    protected static Color staticThumbHighlightColor = new Color(30, 30, 30);
    protected static Color staticButtonBackgroundColor = new Color(30,30,30);
    protected static Color staticButtonShadowColor = Color.WHITE.darker();
    protected static Color staticButtonDarkShadowColor = Color.WHITE;
    protected static Color staticButtonHighlightColor = new Color(30,30,30).brighter();

    @Override
    protected void configureScrollBarColors() {
        this.trackColor = staticTrackColor;
        this.trackHighlightColor = staticTrackHighlightColor;
        this.thumbColor = staticThumbColor;
        this.thumbDarkShadowColor = staticThumbDarkShadowColor;
        this.thumbLightShadowColor = staticThumbLightShadowColor;
        this.thumbHighlightColor = staticThumbHighlightColor;
    }

    public void recolor() {
        configureScrollBarColors();

        switch (scrollbar.getOrientation()) {
            case JScrollBar.VERTICAL:
                incrButton = createIncreaseButton(SOUTH);
                decrButton = createDecreaseButton(NORTH);
                break;

            case JScrollBar.HORIZONTAL:
                if (scrollbar.getComponentOrientation().isLeftToRight()) {
                    incrButton = createIncreaseButton(EAST);
                    decrButton = createDecreaseButton(WEST);
                } else {
                    incrButton = createIncreaseButton(WEST);
                    decrButton = createDecreaseButton(EAST);
                }
                break;
        }
    }

    public void recolor(Color trackColor,
                        Color elementColor,
                        Color mainColor) {
        this.recolor(trackColor, elementColor, elementColor, elementColor, elementColor, elementColor, elementColor, mainColor.darker(), mainColor, elementColor.brighter());
    }

    public void recolor(Color trackColor,
                        Color trackHighlightColor,
                        Color thumbColor,
                        Color thumbDarkShadowColor,
                        Color thumbLightShadowColor,
                        Color thumbHighlightColor,
                        Color buttonBackgroundColor,
                        Color buttonShadowColor,
                        Color buttonDarkShadowColor,
                        Color buttonHighlightColor) {

        if (trackColor != null) {
            this.trackColor = trackColor;
        }
        if (trackHighlightColor != null) {
            this.trackHighlightColor = trackHighlightColor;
        }
        if (thumbColor != null) {
            this.thumbColor = thumbColor;
        }
        if (thumbDarkShadowColor != null) {
            this.thumbDarkShadowColor = thumbDarkShadowColor;
        }
        if (thumbLightShadowColor != null) {
            this.thumbLightShadowColor = thumbLightShadowColor;
        }
        if (thumbHighlightColor != null) {
            this.thumbHighlightColor = thumbHighlightColor;
        }

        switch (scrollbar.getOrientation()) {
            case JScrollBar.VERTICAL:
                incrButton = new BasicArrowButton(SOUTH,
                        buttonBackgroundColor,
                        buttonShadowColor,
                        buttonDarkShadowColor,
                        buttonHighlightColor);
                decrButton = new BasicArrowButton(NORTH,
                        buttonBackgroundColor,
                        buttonShadowColor,
                        buttonDarkShadowColor,
                        buttonHighlightColor);
                break;

            case JScrollBar.HORIZONTAL:
                if (scrollbar.getComponentOrientation().isLeftToRight()) {
                    incrButton = new BasicArrowButton(EAST,
                            buttonBackgroundColor,
                            buttonShadowColor,
                            buttonDarkShadowColor,
                            buttonHighlightColor);
                    decrButton = new BasicArrowButton(WEST,
                            buttonBackgroundColor,
                            buttonShadowColor,
                            buttonDarkShadowColor,
                            buttonHighlightColor);
                } else {
                    incrButton = new BasicArrowButton(WEST,
                            buttonBackgroundColor,
                            buttonShadowColor,
                            buttonDarkShadowColor,
                            buttonHighlightColor);
                    decrButton = new BasicArrowButton(EAST,
                            buttonBackgroundColor,
                            buttonShadowColor,
                            buttonDarkShadowColor,
                            buttonHighlightColor);
                }
                break;
        }
    }

    public static void staticRecolor(Color trackColor,
                                     Color elementColor,
                                     Color mainColor) {
        staticRecolor(trackColor, elementColor, elementColor, elementColor, elementColor, elementColor, elementColor, mainColor.darker(), mainColor, elementColor.brighter());
    }

    public static void staticRecolor(Color trackColor,
                                     Color trackHighlightColor,
                                     Color thumbColor,
                                     Color thumbDarkShadowColor,
                                     Color thumbLightShadowColor,
                                     Color thumbHighlightColor,
                                     Color buttonBackgroundColor,
                                     Color buttonShadowColor,
                                     Color buttonDarkShadowColor,
                                     Color buttonHighlightColor) {

        if (trackColor != null) {
            staticTrackColor = trackColor;
        }
        if (trackHighlightColor != null) {
            staticTrackHighlightColor = trackHighlightColor;
        }
        if (thumbColor != null) {
            staticThumbColor = thumbColor;
        }
        if (thumbDarkShadowColor != null) {
            staticThumbDarkShadowColor = thumbDarkShadowColor;
        }
        if (thumbLightShadowColor != null) {
            staticThumbLightShadowColor = thumbLightShadowColor;
        }
        if (thumbHighlightColor != null) {
            staticThumbHighlightColor = thumbHighlightColor;
        }
        if (buttonBackgroundColor != null) {
            staticButtonBackgroundColor = buttonBackgroundColor;
        }
        if (buttonShadowColor != null) {
            staticButtonShadowColor = buttonShadowColor;
        }
        if (buttonDarkShadowColor != null) {
            staticButtonDarkShadowColor = buttonDarkShadowColor;
        }
        if (buttonHighlightColor != null) {
            staticButtonHighlightColor = buttonHighlightColor;
        }
    }

    protected JButton createZeroButton() {
        JButton button = new JButton("");
        Dimension zeroDim = new Dimension(0,0);
        button.setPreferredSize(zeroDim);
        button.setMinimumSize(zeroDim);
        button.setMaximumSize(zeroDim);
        return button;
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new BasicArrowButton(orientation,
                staticButtonBackgroundColor,
                staticButtonShadowColor,
                staticButtonDarkShadowColor,
                staticButtonHighlightColor);
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new BasicArrowButton(orientation,
                staticButtonBackgroundColor,
                staticButtonShadowColor,
                staticButtonDarkShadowColor,
                staticButtonHighlightColor);
    }
}
