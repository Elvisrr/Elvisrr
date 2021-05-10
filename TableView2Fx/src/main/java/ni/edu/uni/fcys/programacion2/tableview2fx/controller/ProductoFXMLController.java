/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.fcys.programacion2.tableview2fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ni.edu.uni.fcys.programacion2.tableview2fx.pojo.Producto;

/**
 * FXML Controller class
 *
 * @author Sistemas-12
 */
public class ProductoFXMLController implements Initializable {

    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtDescription;
    @FXML
    public TextField txtPrecio;
    @FXML
    public TextField txtImagen;
    @FXML
    public Spinner<Integer> spCantidad;
    @FXML
    public Button btnBuscar;
    @FXML
    public Button btnAgregar;
    @FXML
    public Button btnEliminar;
    @FXML
    public TableView<Producto> tblVProducto;
    @FXML
    public TableColumn<Producto, String> tblCId;
    @FXML
    public TableColumn<Producto, String> tblCNombre;
    @FXML
    public TableColumn<Producto, String> tblCDescripcion;
    @FXML
    public TableColumn<Producto, String> tblcCantidad;
    @FXML
    public TableColumn<Producto, String> tblCPrecio;
    
    private ObservableList<Producto>productos;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productos=FXCollections.observableArrayList();
        productos.add(new Producto(1,"Coca cola","Vitamina",6,13,""));
        tblCId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tblCDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tblcCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tblCPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        spCantidad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1));
        
        
        tblVProducto.setItems(productos);
    }    

    @FXML
    public void btnBuscarAction(ActionEvent event) {
    }

    @FXML
    public void btnAgregarAction(ActionEvent event) {
        String nombre=txtNombre.getText();
        String descripcon=txtDescription.getText();
        int cantidad = Integer.parseInt(spCantidad.getValue().toString());
        float precio= Float.parseFloat(txtPrecio.getText());
        int id =0;
        Producto last= productos.get(productos.size()-1);
        if(last== null){
            id=1;            
        }
        Producto p = new Producto(last.getId()+1, nombre, descripcon, cantidad, precio,"");
        productos.add(p);
    }

    @FXML
    public void btnEliminarAction(ActionEvent event) {
    }
    
}
