package de.arindy.sharv.gui;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;

public class JavaFXUtil {

    public static int extractInteger(final InputMethodEvent inputMethodEvent) {
        int result;
        try {
            result = Integer.parseInt(extractText(inputMethodEvent));
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    public static String extractText(final InputMethodEvent inputMethodEvent) {
        return inputMethodEvent.getComposed().iterator().next().getText();
    }

    public static <T> T getSelectedItem(final ComboBox<T> source) {
        return source.getSelectionModel().getSelectedItem();
    }

    public static void highlight(final Label label, final boolean highlight) {
        if (highlight) {
            label.getStyleClass().add("value-label");
        } else {
            label.getStyleClass().removeAll("value-label");
        }
    }
}
