/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal extends JFrame implements ActionListener, ChangeListener{
    
    private Container contenedor;
    private JLabel lblTitulo;
    private JLabel etiqueta;
    private JLabel etiquetaButton;
    private JLabel etiquetaToggleButton;
    private JLabel etiquetaCheckBox;
    private JLabel etiquetaRadioButton;
    private JLabel etiquetaCombo;
    private JLabel etiquetaSeparator;
    private JLabel etiquetaSpinner;
    private JLabel etiquetaDeslizador;
    private JLabel etiquetaBarra;
    private JButton boton;
    private JCheckBox checkbox1, checkbox2;
    private ButtonGroup grupoRadios;
    private JRadioButton radio1, radio2;
    private JToggleButton toggleButton;
    private JComboBox combo;
    private JSeparator separadorVertical, separadorHorizontal;
    private JSpinner spinner;
    private JSlider deslizador;
    private JProgressBar barra;
    
    



public VentanaPrincipal () {

iniciarComponentes();

setTitle("Jframe componentes Atomicos");

setSize("630,250");

setLocationRelativeto(null);

setResizeble(false);
    
    
}

private void iniciarComponentes(){
    contenedor = new Container();
    contenedor.setLayout(null);
    lblTitulo = new JLabel();
     lblTitulo.setText("Componente Atomico");
     lblTitulo.setFont(new Font("Tahoma",1,20));

}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setSize(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLocationRelativeto(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setResizeble(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
