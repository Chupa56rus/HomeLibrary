package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.sql.DataBaseConnection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DataBaseConnection db = new DataBaseConnection();
        db.createTables();

        Parent root = FXMLLoader.load(getClass().getResource("Interface/sample.fxml"));
        primaryStage.setTitle("Home Library");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, 700, 400);
        scene.getStylesheets().add(0, "sample/Styles/MyStyle.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
