package Views;

import Controllers.PhoneLoaderInterface;
import Controllers.PhoneViewController;
import Models.Phone;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    public static void changeScenes(ActionEvent event, String viewName, String title) throws IOException {

        Parent root = FXMLLoader.load(new Object(){}.getClass().getResource(viewName));
        Scene scene = new Scene(root);

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();

    }//end of changeScenes

    /**
     * This method allows the user to change scenes and pass a Phone object into the new scene
     */
    public static void changeScenes(ActionEvent event, String viewName, String title, Phone phone) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        //access the controller class and load the Phone objects
        PhoneLoaderInterface controller = loader.getController();
        controller.loadPhone(phone);

        //get the Stage and set the scene/show
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Phone View");
        stage.setScene((scene));
        stage.show();
    }

}//end of SceneChanger
