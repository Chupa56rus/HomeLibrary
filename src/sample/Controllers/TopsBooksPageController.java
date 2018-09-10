package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.PageOpener;

public class TopsBooksPageController {
    @FXML
    public Button TopsBooksBackButton;

    public void TopsBooksBackButtonAction(ActionEvent actionEvent) {
        TopsBooksBackButton.getScene().getWindow().hide();
        PageOpener opener = new PageOpener();
        opener.openPage("/sample/Interface/userPage.fxml");
    }
}
