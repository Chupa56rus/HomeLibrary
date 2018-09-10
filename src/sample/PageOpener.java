package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PageOpener {

    public void openPage(String path){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Home Library");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    // create modal window

    public void openPage(String path, ActionEvent actionEvent){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.show();
    }


}
