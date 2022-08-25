package main.hollowParkOnline;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button button_sign_up;
    @FXML
    private Button button_log_in;

    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_first_name;
    @FXML
    private TextField tf_mid_name;
    @FXML
    private TextField tf_last_name;
    @FXML
    private TextField tf_mobile_num;
    @FXML
    private TextField tf_email_add;
    @FXML
    private PasswordField pf_password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (!tf_username.getText().trim().isEmpty() && !pf_password.getText().trim().isEmpty()) {
                    DBUtils.signUpUser(actionEvent,
                            tf_username.getText(),
                            tf_first_name.getText(),
                            tf_mid_name.getText(),
                            tf_last_name.getText(),
                            tf_mobile_num.getText(),
                            tf_email_add.getText(),
                            pf_password.getText());
                } else {
                    System.out.println("Please fill in all information.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to complete sign up!");
                    alert.show();
                }
            }
        });

        button_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent, "sample.fxml", "Log In", null, null);
            }

        });
    }
}


