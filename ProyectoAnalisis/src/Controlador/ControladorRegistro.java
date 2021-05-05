/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.ModeloRegistro;
import Modelo.*;

import Vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JOptionPane;
import java.util.Date;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author raul1
 */
public class ControladorRegistro implements ActionListener{
    
   private VistaRegistro view;
   private ModeloRegistro model;
    public ControladorRegistro(VistaRegistro view, ModeloRegistro model)
    {
        this.view = view;
        this.model = model;
        this.view.jButton1.addActionListener(this);
    }
    
    public void Iniciar(){
    
       ArrayList<String> Lista = new ArrayList<String>();
       Lista = model.GenerarCalidad();
        view.C_Calidad.add("");
        for(int i=0;i<Lista.size();i++)
        {
            view.C_Calidad.add(Lista.get(i));
        }

        
        
    }
    
    public void actionPerformed(ActionEvent e){
      
        model.setId(view.JTextID.getText());
        model.setFecha(view.jDateChooser1.getDate());
        model.setResponsable(view.JTextResponsable.getText());
        model.setUbicacion(view.JTextUbicacion.getText());
        model.setAldea(view.JTextAldea.getText());
        model.setTipo_apoyo(view.JTextTipoApoyo.getText());
        model.setEncargado(view.JTextEncargado.getText());
        model.setExpediente(view.JTextExpediente.getText());
        model.setNombre(view.JTextNombre.getText());
        model.setDpi(view.JTextDPI.getText());
        model.setRim(view.JTextRIM.getText());
        model.setTelefono(view.JTextTelefono.getText());
        model.setEmail(view.JTextEMAIL.getText());
        model.setInfo_apoyo(view.JTextINFO_APOYO.getText());
        model.setObservacion(view.JTextObservaciones.getText());
        model.setCalidad(view.C_Calidad.getSelectedItem());
        String resultado=model.Registrodatos();
        
                if (resultado!=null){
            JOptionPane.showMessageDialog(null, resultado);
        }else
        {
            JOptionPane.showMessageDialog(null, "Error al insertar"); 
        }
        
    
    }
}
