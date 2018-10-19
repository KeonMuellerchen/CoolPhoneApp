package Controllers;

import Models.DBConnect;
import Models.Phone;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PhoneCreatorViewController implements Initializable { //must add implements Initializable

    @FXML private ChoiceBox<String> makeChoiceBox;
    @FXML private TextField modelTextField;
    @FXML private ChoiceBox<String> osChoiceBox;
    @FXML private TextField screenSizeTextField;
    @FXML private TextField memoryTextField;
    @FXML private TextField frontCameraTextField;
    @FXML private TextField rearCameraTextField;
    @FXML private TextField priceTextField;
    @FXML private Button saveButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            makeChoiceBox.getItems().addAll(DBConnect.getPhoneManufacturers());
            osChoiceBox.getItems().addAll(DBConnect.getOSs());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        makeChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                //this is our custom listener code
                (observable, oldValue, newValue) -> {
                    osChoiceBox.setValue(DBConnect.getOSForManufacturer(newValue));
                }
        );

    }//end of initialize

    @FXML
    public void createPhoneButtonPushed() {

        Phone newPhone = new Phone(makeChoiceBox.getValue(), modelTextField.getText(), osChoiceBox.getValue(),
                            Double.parseDouble(screenSizeTextField.getText()),
                            Double.parseDouble(memoryTextField.getText()),
                            Double.parseDouble(frontCameraTextField.getText()),
                            Double.parseDouble(rearCameraTextField.getText()));

        System.out.printf("New Phone: %s%n", newPhone);
        try {
            DBConnect.insertPhoneIntoDB(newPhone);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//end of createPhoneButtonPushed()
}//end of PhoneCreatorViewController class
