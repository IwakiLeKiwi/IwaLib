package fr.iwaki.iwalib.ui.panel;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public interface IPanel {

    GridPane getLayout();
    void onShow();
    void showElement(int duration, Node node);
    void hideElement(int duration, Node node);
    String getName();
    String getStylesheetPath();
}
