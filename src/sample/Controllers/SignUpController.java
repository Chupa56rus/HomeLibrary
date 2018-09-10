package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.PageOpener;

public class SignUpController {

    @FXML
    public Button signUpSignInButton;

    public void signUpSignInButtonAction(ActionEvent actionEvent) {
        signUpSignInButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/sample.fxml");
    }

    public void signUpCancelButtonAction(ActionEvent actionEvent) {
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/exitWindow.fxml", actionEvent);
    }
}
