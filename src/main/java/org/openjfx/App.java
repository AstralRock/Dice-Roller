package org.openjfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Create a GridPane for the buttons
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Add some buttons to the grid
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Button button = new Button("Button " + (i * 5 + j + 1));
                GridPane.setConstraints(button, j, i);
                grid.getChildren().add(button);
            }
        }

        // Create a TextArea for the terminal output
        TextArea terminal = new TextArea();
        terminal.setEditable(false); // Make it read-only

        // Create a SplitPane to hold the grid and the terminal
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(grid, terminal);

        // Set the SplitPane as the scene of the stage
        Scene scene = new Scene(splitPane, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}