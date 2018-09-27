package Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {   //must add extends application

    public static void main(String[] args)
    {
        launch(args);
    }//end of main

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PhoneCreatorView.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create phone");
        primaryStage.show();
    }//end of start
}//end of Main
