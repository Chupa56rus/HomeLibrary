package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.PageOpener;
import sample.sql.DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import sample.sql.DataBaseConnection;

public class SignUpController {

    @FXML
    public Button signUpSignInButton;
    public PasswordField signUpPasswordTextField;
    public TextField signUpLoginTextField;

    public void signUpSignInButtonAction(ActionEvent actionEvent) {
        signUpSignInButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/sample.fxml");
    }


    public void signUpSignUpButtonAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String login = signUpLoginTextField.getText();
        String password = signUpPasswordTextField.getText();

        DataBaseConnection con = new DataBaseConnection();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(DataBaseConnection.getUrl(), DataBaseConnection.getUsername(), DataBaseConnection.getPassword());
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO lib.t_users" +
                    "(`idt_user_id`,`f_user_username`,`f_user_password`)" +
                    "VALUES " +
                    "(default, '" + login + "', '" + password + "');");
        }
    }
}
