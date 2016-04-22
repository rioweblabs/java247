package projectfxml;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TrackVehicleController implements Initializable {
    
    DecimalFormat df = new DecimalFormat("#,###,##0.00");

    @FXML private Button menu_back;
    @FXML private Label net_income;
    
    @FXML private TableView tview;
    @FXML private TableColumn colVin;
    @FXML private TableColumn colMake;
    @FXML private TableColumn colModel;
    @FXML private TableColumn colYear;
    @FXML private TableColumn colType;
    @FXML private TableColumn colStatus;
    @FXML private TableColumn colPrice;
        
    public void showList()
    {
        Vehicle v = new Vehicle();
        ObservableList<Vehicle> vlist = FXCollections.observableArrayList(FileRead.findAll());
        net_income.setText(String.valueOf(df.format(FileRead.getIncome())));
        
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
                
        tview.setItems(vlist);
    }
    /*
    public void showList1(String vin)
    {
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
        ObservableList<Vehicle> svlist = FXCollections.observableArrayList(FileRead.findVin(vin));
        tview.setItems(svlist);
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        showList();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        if(event.getSource()==menu_back)
        {
            stage=(Stage) menu_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        }  else 
        {
            stage=(Stage) menu_back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SearchVin.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}