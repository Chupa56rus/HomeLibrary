package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.PageOpener;

import java.io.IOException;


public class Controller {

    @FXML
    public Button signInSignUpButton;

    public void signInSignUpButtonAction(ActionEvent actionEvent) {

        signInSignUpButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/signUp.fxml");
    }
}

