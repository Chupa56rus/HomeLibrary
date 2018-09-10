package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.PageOpener;


public class Controller {

    @FXML
    public Button signInSignUpButton;
    public Button signInSignInButton;
    public Button signInCancelButton;

    public void signInSignUpButtonAction(ActionEvent actionEvent) {

        signInSignUpButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/signUp.fxml");
    }

    public void signInSignInButtonAction(ActionEvent actionEvent) {

        signInSignInButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/userPage.fxml");
    }

    public void signInCancelButtonAction(ActionEvent actionEvent) {
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/exitWindow.fxml", actionEvent);
    }
}

