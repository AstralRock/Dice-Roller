package org.openjfx;

import javafx.scene.paint.Color;

public class Console {
    public static void output(String output) {
        Controller.getTerminal().appendText(output + "\n");
    }
        public static void warn(String warning) {
            Controller.getWarnings().setText(warning);
            Controller.getWarnings().setTextFill(Color.ORANGE);
        }

        public static void flag(String flag) {
            Controller.getWarnings().setText(flag);
            Controller.getWarnings().setTextFill(Color.GREEN);
        }

        public static void error(String error) {
            Controller.getWarnings().setText(error);
            Controller.getWarnings().setTextFill(Color.RED);
        }
}
