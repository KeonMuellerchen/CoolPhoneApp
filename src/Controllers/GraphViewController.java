package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphViewController implements Initializable {

    @FXML private BarChart barChart;
    @FXML private CategoryAxis movieGenres;
    @FXML private NumberAxis checkMarks;
    private XYChart.Series moviePreferences;
    private XYChart.Series moviePreferences2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        moviePreferences = new XYChart.Series();
        moviePreferences2 = new XYChart.Series();
        moviePreferences.setName("People that like movies but cant tally");
        moviePreferences2.setName("End of class relief");

        checkMarks.setLabel("# of people");

        //add data to the series
        moviePreferences.getData().add(new XYChart.Data("Comendy", 5));
        moviePreferences.getData().add(new XYChart.Data("Horror", 4));
        moviePreferences.getData().add(new XYChart.Data("Action", 4));
        moviePreferences.getData().add(new XYChart.Data("Romance", 1));

        moviePreferences2.getData().add(new XYChart.Data("Comendy", 8));
        moviePreferences2.getData().add(new XYChart.Data("Horror", 1));
        moviePreferences2.getData().add(new XYChart.Data("Action", 7));
        moviePreferences2.getData().add(new XYChart.Data("Romance", 2));

        barChart.getData().addAll(moviePreferences);
        barChart.getData().addAll(moviePreferences2);
    }
}
