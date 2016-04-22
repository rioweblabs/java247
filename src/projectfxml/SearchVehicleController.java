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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SearchVehicleController extends Vehicle implements Initializable {
    
    @FXML private Button menu_back;
    @FXML private TextField form_vin_search;
    @FXML ComboBox<String> cmb_status;
   
    @FXML private TableView tview1;
    @FXML private TableColumn colVin;
    @FXML private TableColumn colMake;
    @FXML private TableColumn colModel;
    @FXML private TableColumn colYear;
    @FXML private TableColumn colType;
    @FXML private TableColumn colStatus;
    @FXML private TableColumn colPrice;
    
    public void searchVin()
    {
        ArrayList<Vehicle> svlist = new ArrayList<Vehicle>();
        String vin = form_vin_search.getText();
        
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
        tview1.setItems(vlist);
    }
    
    public void searchStatus()
    {
        ArrayList<Vehicle> svlist = new ArrayList<Vehicle>();
        String status = cmb_status.getValue();
        
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
        ObservableList<Vehicle> vlist = FXCollections.observableArrayList(FileRead.findStatus(status));
        tview1.setItems(vlist);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
                
        Stage stage; 
        Parent root;
        if(event.getSource()==menu_back)
        {                       
            stage=(Stage) menu_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            
        }
        else 
        {
            stage=(Stage) menu_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}