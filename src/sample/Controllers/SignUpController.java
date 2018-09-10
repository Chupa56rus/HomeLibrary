package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.PageOpener;

import java.sql.*;

import sample.sql.DataBaseConnection;

public class SignUpController {

    @FXML
    public Button signUpSignInButton;
    public PasswordField signUpPasswordTextField;
    public TextField signUpLoginTextField;
    public TextField signUpNameTextField;
    public TextField signUpLocationTextField;
    public TextField signUpEmailTextField;
    public TextField signUpPhoneNumberTextField;
    public Button signUpSignUpButton;

    public void signUpSignInButtonAction(ActionEvent actionEvent) {
        signUpSignInButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/sample.fxml");
    }

    public void signUpCancelButtonAction(ActionEvent actionEvent) {
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/exitWindow.fxml", actionEvent);
    }

    public void signUpSignUpButtonAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String login = signUpLoginTextField.getText();
        String password = signUpPasswordTextField.getText();
        String name = signUpNameTextField.getText();
        String location = signUpLocationTextField.getText();
        String email = signUpEmailTextField.getText();
        String phonenumber = signUpPhoneNumberTextField.getText();

        DataBaseConnection con = new DataBaseConnection();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(DataBaseConnection.getUrl(), DataBaseConnection.getUsername(), DataBaseConnection.getPassword());
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `homelib`.`t_users` " +
                    "(`f_user_id`,`f_user_username`,`f_user_name`,`f_user_password`,`f_user_location`,`f_user_email`,`f_user_phonenumber`) " +
                    "VALUES " +
                    "(default, '" + login + "', '" + name + "', '" + password + "', '" + location + "', '" + email + "', '" + phonenumber + "');");
        }

        signUpSignUpButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/UserPage.fxml", actionEvent);
    }
}
