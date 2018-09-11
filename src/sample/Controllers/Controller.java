package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.PageOpener;
import sample.sql.DataBaseConnection;

import java.sql.*;


public class Controller {

    @FXML
    public Button signInSignUpButton;
    public Button signInSignInButton;
    public Button signInCancelButton;
    public Label signInErrorMessage;
    public PasswordField signInPasswordField;
    public TextField signInLoginField;

    public void signInSignUpButtonAction(ActionEvent actionEvent) {

        signInSignUpButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/signUp.fxml");
    }

    public void signInSignInButtonAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        signInErrorMessage.setVisible(false);
        String userLogin = signInLoginField.getText();
        String userPassword = signInPasswordField.getText();

        if ((userLogin.isEmpty()) || (userPassword.isEmpty())) {
            signInErrorMessage.setVisible(true);
        } else {
            DataBaseConnection con = new DataBaseConnection();
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(DataBaseConnection.getUrl(), DataBaseConnection.getUsername(), DataBaseConnection.getPassword());
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select f_user_id, f_user_username, f_user_password from homelib.t_users " +
                        "where f_user_username = '" + userLogin + "';");
                resultSet.last();
                if (resultSet.getRow() < 1) {
                    signInErrorMessage.setVisible(true);
                } else if ((resultSet.getString("f_user_username").equals(userLogin))
                        && (resultSet.getString("f_user_password").equals(userPassword))) {
                    signInErrorMessage.setVisible(false);
                    signInSignInButton.getScene().getWindow().hide();
                    PageOpener opener = new PageOpener();
                    opener.openPage("/sample/Interface/userPage.fxml");
                } else {
                    signInErrorMessage.setVisible(true);
                }
            }
        }

    }

    public void signInCancelButtonAction(ActionEvent actionEvent) {
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/exitWindow.fxml", actionEvent);
    }
}

