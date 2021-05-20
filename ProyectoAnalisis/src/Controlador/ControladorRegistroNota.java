/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import Modelo.*;
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
import javax.swing.JButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author raul1
 */
public class ControladorRegistroNota implements ActionListener{
    
   private VistaRegistroNota view;
   private ModeloRegistroNota model;
    public ControladorRegistroNota(VistaRegistroNota view, ModeloRegistroNota model)
    {
        this.view = view;
        this.model = model;
        this.view.jButton2.addActionListener(this);
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
        
         ArrayList<String> respo = new ArrayList<String>();
        respo = model.GenerarEncargado();
        view.C_Encargado.add("");
        view.C_Responsable.add("");
        for(int i=0;i<respo.size();i++)
        {
            view.C_Responsable.add(respo.get(i));
            view.C_Encargado.add(respo.get(i));
        }
        
        ArrayList<String> g_aldea = new ArrayList<String>();
       g_aldea = model.GenerarAldea();
        view.C_Aldea.add("");
        for(int i=0;i<g_aldea.size();i++)
        {
            view.C_Aldea.add(g_aldea.get(i));
        }
        
           ArrayList<String> apoyo = new ArrayList<String>();
       apoyo = model.GenerarApoyo();
        view.C_Apoyo.add("");
        for(int i=0;i<apoyo.size();i++)
        {
            view.C_Apoyo.add(apoyo.get(i));
        

        }    
    }
    
    public void actionPerformed(ActionEvent e){
      
        JButton source = (JButton) e.getSource();

        if(source.getText()=="INGRESAR"){
            
        int ultimoId = model.UltimoId();
        int ultimoIdEncargado = model.UltimoIdEncargado();
         if(view.JTextNombre.getText().length()==0 | view.JTextRIM.getText().length()==0 
            | view.JTextTelefono.getText().length()==0)
         {
            JOptionPane.showMessageDialog(null, "Valor Requerido", 
            "Error" ,JOptionPane.ERROR_MESSAGE);   
         }else if(ultimoId==0)
                {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar", 
                    "Error" ,JOptionPane.ERROR_MESSAGE); 
                }else
                    {
            
                    model.setFecha(view.jDateChooser1.getDate());
                    model.setDireccion(view.JTextUbicacion.getText());
                    model.setIdAldea(view.C_Aldea.getSelectedIndex());
                    model.setInformacionApoyo(view.JTextINFO_APOYO.getText());
                    model.setTipo_apoyo(view.C_Apoyo.getSelectedIndex());
                    model.setExpediente(view.JTextExpediente.getText());
                    model.setCalidad(view.C_Calidad.getSelectedIndex());
                    
                    model.setIdResponsable(view.C_Responsable.getSelectedIndex());
                    model.setIdPersonal(view.C_Encargado.getSelectedIndex());
                    
                    model.setNombre(view.JTextNombre.getText());
                    model.setDpi(view.JTextDPI.getText());
                    model.setRim(view.JTextRIM.getText());
                    model.setTelefono(view.JTextTelefono.getText());
                    model.setEmail(view.JTextEMAIL.getText());
                    
                    model.setObservacion(view.JTextObservaciones.getText());
                    
                    String resultado=model.RegistroNota();
                    int encargado1 = model.RegistroEncargado();
                    int encargado2 = model.RegistroResponsable();

                    if (resultado!=null){
                        JOptionPane.showMessageDialog(null, resultado);
                    }else if( encargado1==0 | encargado2 ==0)
                        {
                            JOptionPane.showMessageDialog(null, "Error al insertar"); 
                        }

                    }
    }
        
           if(source.getText()=="BUSCAR")
            {
                if(view.JTextDPI.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Favor Ingrese un Código Correcto", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);
                }else{
                    model.setDpi(view.JTextDPI.getText());
                    String resultado = model.BuscarPersona();
                     if(resultado!= null ){
                            model.setDpi(resultado);
                            view.JTextNombre.setText(model.getNombre());
                            view.JTextTelefono.setText(model.getTelefono());
                            view.JTextRIM.setText(model.getRim());
                            view.JTextEMAIL.setText(model.getEmail());
                            
                            
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "Dato Ingresado no es Válido", 
                            "Error" ,JOptionPane.ERROR_MESSAGE);
                        }  
                }
            }
        
        
        
        
        
    }







}
