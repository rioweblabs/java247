package projectfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {
    
    @FXML
    private Button buy_vehicle, sell_vehicle, search_vehicle, track_vehicle;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        if(event.getSource()==buy_vehicle){
            //get reference to the button's stage         
            stage=(Stage) buy_vehicle.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("BuyVehicle.fxml"));
        } else if (event.getSource()==sell_vehicle){
             //get reference to the button's stage         
            stage=(Stage) sell_vehicle.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("SellVehicle.fxml"));
        } else if (event.getSource()==search_vehicle){
             //get reference to the button's stage         
            stage=(Stage) search_vehicle.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("SearchVehicle.fxml"));
        } else if (event.getSource()==track_vehicle){
             //get reference to the button's stage         
            stage=(Stage) track_vehicle.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("TrackVehicle.fxml"));
        } else {
            stage=(Stage) search_vehicle.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}