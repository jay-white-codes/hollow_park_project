package com.example.hollowpark;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

import java.sql.*;

public class DBUtility {
    /*
    * utility class just a Java class that contains static methods
    * cannot be instantiated
    * contains a bunch of related methods
    * known as helper class
    * could be used as StringUtils or CollectionUtils
    * */

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String name, String username) {
        Parent root = null;

        if (name != null && username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtility.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setUserInformation(name, username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtility.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void signUpUser(ActionEvent event, String name, String password, String username) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:jdbc:mysql://localhost:3306/hollowpark", "root", "818Shake!");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username.");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT: INTO user (first_name, middle_name, last_name, mobile_num, email_address, passwordHash VALUES (?, ?, ?, ?, ?, ?)");
                psInsert.setString(1, first_name);
                psInsert.setString(2, middle_name);
                psInsert.setString(3, last_name);
                psInsert.setString(4, mobile_num);
                psInsert.setString(5, email_address);
                psInsert.setString(6, passwordHash);
                psInsert.executeUpdate();

                changeScene(event, "logged-in.fxml", "Welcome!", first_name, email_address);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void logInUser (ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:jdbc:mysql://localhost:3306/hollowpark", "root", "818Shake!");
            preparedStatement = connection.prepareStatement("SELECT password, first_name FROM user where")
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
