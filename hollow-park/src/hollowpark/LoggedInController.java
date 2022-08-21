package com.example.hollowpark;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {
    /*
    above code allows controller initialization
    method to override is initialize()
    intialize() called after all @FXML annotated members have been injected
    can work with components, containers, etc. in the initialize() method
    */

    @FXML
    private Button button_log_out;

    @FXML
    private Label label_welcome;
    @FXML
    private Label label_account;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        button_log_out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtility.changeScene(event, "main-start.fxml", "Log in",null, null);
            }
        });
    }


    public void setUserInformation(String name, String username) {
        label_welcome.setText("Welcome " + name + "!");
        label_account.setText("Signed in as " + username);
    }
}
