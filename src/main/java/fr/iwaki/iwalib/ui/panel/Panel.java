package fr.iwaki.iwalib.ui.panel;

import javafx.animation.FadeTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public abstract class Panel implements IPanel, IMovable, ITakePlace {

    protected GridPane layout = new GridPane();

    @Override
    public GridPane getLayout() {
        return layout;
    }

    @Override
    public void onShow() {
        FadeTransition transition = new FadeTransition(Duration.seconds(1), this.layout);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.setAutoReverse(true);
        transition.play();
    }

    @Override
    public void showElement(int millisDuration, Node node) {
        node.setVisible(true);
        node.setOpacity(0.1);
        FadeTransition showTransition = new FadeTransition(Duration.millis(millisDuration), node);
        showTransition.setFromValue(0);
        showTransition.setToValue(1);
        showTransition.setAutoReverse(true);
        showTransition.setOnFinished(event -> node.setOpacity(1));
        showTransition.play();
    }

    @Override
    public void hideElement(int millisDuration, Node node) {
        FadeTransition hideTransition = new FadeTransition(Duration.millis(millisDuration), node);
        hideTransition.setFromValue(1);
        hideTransition.setToValue(0);
        hideTransition.setAutoReverse(true);
        hideTransition.setOnFinished(event -> node.setOpacity(0));
        hideTransition.play();
    }

    public abstract String getName();

    @Override
    public String getStylesheetPath() {
        return null;
    }

    @Override
    public void setLeft(Node node) {
        GridPane.setHalignment(node, HPos.LEFT);
    }

    @Override
    public void setRight(Node node) {
        GridPane.setHalignment(node, HPos.RIGHT);
    }

    @Override
    public void setTop(Node node) {
        GridPane.setValignment(node, VPos.TOP);
    }

    @Override
    public void setBottom(Node node) {
        GridPane.setValignment(node, VPos.BOTTOM);
    }

    @Override
    public void setBaseLine(Node node) {
        GridPane.setValignment(node, VPos.BASELINE);
    }

    @Override
    public void setCenterH(Node node) {
        GridPane.setHalignment(node, HPos.CENTER);
    }

    @Override
    public void setCenterV(Node node) {
        GridPane.setValignment(node, VPos.CENTER);
    }
}
