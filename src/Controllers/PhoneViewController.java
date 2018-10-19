package Controllers;

import Models.Phone;
import Views.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PhoneViewController implements Initializable, PhoneLoaderInterface {

    @FXML private Label makeLabel;
    @FXML private Label modelLabel;
    @FXML private Label osLabel;
    @FXML private Label memoryLabel;

    Phone activePhone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadPhone(Phone phone) {
        activePhone = phone;
        updateView();
    }

    public void updateView() {
        makeLabel.setText(activePhone.getMake());
        modelLabel.setText(activePhone.getModel());
        osLabel.setText(activePhone.getOs());
        memoryLabel.setText(String.format("%.0f", activePhone.getMemory()));
    }

    @FXML
    public void backToPhoneTable (ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "PhoneTableView.fxml", "Phone Table");
    }//end

}
