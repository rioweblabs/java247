package projectfxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SellVehicleController implements Initializable {
    
    @FXML private Button menu_back, form_submit;
    @FXML ComboBox<String> cmb_locations;
    @FXML private TextField form_sell_price;

    @FXML private TableView tview2;
    @FXML private TableColumn colVin;
    @FXML private TableColumn colMake;
    @FXML private TableColumn colModel;
    @FXML private TableColumn colYear;
    @FXML private TableColumn colType;
    @FXML private TableColumn colStatus;
    @FXML private TableColumn colPrice;
    
    ArrayList<Vehicle> vlist = new ArrayList<Vehicle>();
        
    public void searchVin()
    {
        ArrayList<Vehicle> svlist = new ArrayList<Vehicle>();
        String vin = cmb_locations.getValue();
        
        colVin.setCellValueFactory(new PropertyValueFactory("vin"));        
        colMake.setCellValueFactory(new PropertyValueFactory("make"));          
        colModel.setCellValueFactory(new PropertyValueFactory("model"));          
        colYear.setCellValueFactory(new PropertyValueFactory("year"));          
        colType.setCellValueFactory(new PropertyValueFactory("type"));
        colStatus.setCellValueFactory(new PropertyValueFactory("status"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        
        colMake.setStyle( "-fx-alignment: CENTER;");
        colModel.setStyle( "-fx-alignment: CENTER;");
        colYear.setStyle( "-fx-alignment: CENTER;");
        colType.setStyle( "-fx-alignment: CENTER;");
        colStatus.setStyle( "-fx-alignment: CENTER;");
        colPrice.setStyle( "-fx-alignment: CENTER-RIGHT; -fx-text-fill: SLATEBLUE;");
        
        
        Vehicle v = new Vehicle();
        ObservableList<Vehicle> vlist = FXCollections.observableArrayList(FileRead.findVin(vin));
        tview2.setItems(vlist);
    }
    
    public void showList(){
        Vehicle v = new Vehicle();
        vlist = FileRead.findStatus("BUY");
        System.out.println(vlist);
        for (int i = 0; i < vlist.size(); i++){
            cmb_locations.getItems().addAll(vlist.get(i).getVin());
        }
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        vlist = FileRead.findAll();
        
        Stage stage; 
        Parent root;
        if(event.getSource()==menu_back)
        {
            stage=(Stage) menu_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        } else if(event.getSource()==form_submit)
        {
            String vin = cmb_locations.getValue();
            double sell_price = Double.parseDouble(form_sell_price.getText());
            double buy_price;
            
            for (int i = 0; i <= vlist.size(); i++){
                if(vlist.get(i).getVin().equalsIgnoreCase(vin)) {
                    buy_price = vlist.get(i).getPrice();
                    vlist.get(i).setStatus("SOLD");
                    vlist.get(i).setPrice(sell_price - buy_price);
                    break;
                }
            }
            
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
        showList();
    }
}