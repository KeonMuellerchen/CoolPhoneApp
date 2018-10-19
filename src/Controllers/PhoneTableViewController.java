package Controllers;

import Models.DBConnect;
import Models.Phone;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PhoneTableViewController implements Initializable {

    @FXML
    private TableView<Phone> tableView;
    @FXML
    private TableColumn<Phone, String> makeColumn;
    @FXML
    private TableColumn<Phone, String> modelColumn;
    @FXML
    private TableColumn<Phone, String> osColumn;
    @FXML
    private TableColumn<Phone, Double> screenSizeColumn;
    @FXML
    private TableColumn<Phone, Double> memoryColumn;
    @FXML
    private TableColumn<Phone, Double> rearCameraResColumn;
    @FXML
    private TableColumn<Phone, Double> frontCarmeraResColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //configure the TableColumns to integrate with the Phone class
        makeColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("model"));
        osColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("os"));
        screenSizeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Double>("screenSize"));
        memoryColumn.setCellValueFactory(new PropertyValueFactory<Phone, Double>("memory"));
        rearCameraResColumn.setCellValueFactory(new PropertyValueFactory<Phone, Double>("rearCameraRes"));
        frontCarmeraResColumn.setCellValueFactory(new PropertyValueFactory<Phone, Double>("frontCameraRes"));

        try {
            tableView.getItems().addAll(DBConnect.getPhones());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//end of initialize
}
