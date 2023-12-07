package org.openjfx;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label label1 = new Label("Hello, World!");
        Scene scene1 = new Scene(label1, 200, 100);

        Label label2 = new Label("Goodbye, World!");
        Scene scene2 = new Scene(label2, 200, 100);

        stage.setScene(scene1);
        stage.show();

        // Switch to the second scene after some time
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> stage.setScene(scene2));
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}