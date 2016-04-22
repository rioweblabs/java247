package projectfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuyVehicleController extends Vehicle implements Initializable {
    
    @FXML private Button menu_back;
    @FXML private TextField form_vin;
    @FXML private TextField form_make;
    @FXML private TextField form_model;
    @FXML private TextField form_year;
    @FXML private TextField form_price;
    @FXML private Button form_submit;
    @FXML ComboBox<String> cmb_type;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
        vlist = FileRead.findAll();
        
        Stage stage; 
        Parent root;
        if(event.getSource()==menu_back)
        {
            stage=(Stage) menu_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        } else if(event.getSource()==form_submit)
        {
            String vin = form_vin.getText();
            String make = form_make.getText();
            String model = form_model.getText();
            int year = Integer.parseInt(form_year.getText());
            String type = cmb_type.getValue();
            double price = Double.parseDouble(form_price.getText());
            Vehicle c1 = new Vehicle(vin, make, model, year, type,"BUY", price);                        
            vlist.add(c1);
            FileWrite.writeAppendSingle((ArrayList<Vehicle>) vlist);
                        
            stage=(Stage) form_submit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TrackVehicle.fxml"));
        } else 
        {
            stage=(Stage) menu_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("BuyVehicle.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}