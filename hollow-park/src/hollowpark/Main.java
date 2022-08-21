package com.example.hollowpark;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    // #412854 - Russian Violet (Purple)
    // #050305 - Rich Black FORGA 39
    // #120A3D - Russian Violet (Blue)
    // #4CC35B - Mantis
    // #68DA23 - Sheen Green

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("src/hollowpark/main-start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}