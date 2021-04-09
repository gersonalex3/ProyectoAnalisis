
package Controlador;

import Modelo.Conexion;
import Modelo.ModeloReportes;
import Vista.VistaReportes;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class ControladorReportes implements ActionListener{
    
    private VistaReportes view;
    private ModeloReportes model;
    
    public ControladorReportes(VistaReportes view, ModeloReportes model)
    {
        this.view = view;
        this.model = model;
        this.view.BtnGenerar.addActionListener(this);
    }
    
    public void iniciar()
    {
        view.setTitle("Modulo de Reportes");
        view.setLocationRelativeTo(null);
        view.getContentPane().setBackground(Color.white);
        
        view.CAldea.add("");
        view.CAldea.add("Aldea1");
        view.CAldea.add("Aldea2");
    }
    
    public void actionPerformed (ActionEvent e)
    {
        if(view.jAldea.isVisible())
        {
            if(view.CAldea.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Favor seleccionar la aldea", 
                         "Error" ,JOptionPane.ERROR_MESSAGE);   
            }
        }
        try{
            model.setAldea(view.CAldea.getSelectedItem());
            model.setFechaIni(view.jDateIni.getDate());
            model.setFechaFin(view.jDateFin.getDate());
            
            model.GenerarReporte();
            JOptionPane.showMessageDialog(null, model.getResultado());
            
                }catch(Exception ex){
                if(view.jAldea.isVisible() && view.CAldea.getSelectedIndex()!=0){
                        JOptionPane.showMessageDialog(null, "No se encontraron fechas", 
                         "Error" ,JOptionPane.ERROR_MESSAGE);}
        }
    }
}
