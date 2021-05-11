/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.fcys.programacion2.appactivos.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ni.edu.uni.fcys.programacion2.appactivos.core.Activos;

/**
 * FXML Controller class
 *
 * @author Sistemas-12
 */
public class DepreFXMLController implements Initializable {

    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtVActivo;
    @FXML
    public TextField txtVSalvamiento;
    @FXML
    public ComboBox ComBox;
    @FXML
    public Button btnCalcular;
    @FXML
    public TableView<Activos> tblVProducto;
    
    private ObservableList<Activos>activo;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        activo=FXCollections.observableArrayList();
        
        tblCId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tblCDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tblcCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tblCPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        spCantidad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1));
        
        
        
        ComBox.getItems().addAll(
                "Edifico",
                "Vehiculo",
                "Maquinaria",
                "Mobiliario",
                "Equipo de oficina"
        );
      
    }    

    @FXML
    public void btnCalcularAction(ActionEvent event) {
        String nombre=txtNombre.getText();
        String activo=txtVActivo.getText();
        String salvamiento=txtVSalvamiento.getText();
    }
    
}
