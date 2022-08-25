package main.hollowParkOnline;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button button_log_out;

    @FXML
    private Label label_welcome;
    @FXML
    private Label label_logged_in_as;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_log_out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "sample.fxml", "Log In", null, null);
            }
        });

    }

    public void setUserInformation(String first_name, String username) {
        label_welcome.setText("Welcome " + first_name + "!");
        label_logged_in_as.setText("You are logged in as " + username + ".");
    }
}
