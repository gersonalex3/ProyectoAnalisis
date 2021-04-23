/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis;

import Controlador.ControladorReportes;
import Modelo.Conexion;
import Modelo.ModeloReportes;
import Vista.VistaReportes;
import java.sql.*;
/**
 *
 * @author alx_g
 */
public class ProyectoAnalisis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        
        ModeloReportes mod = new ModeloReportes();
        VistaReportes view = new VistaReportes();
        
        ControladorReportes ctrl = new ControladorReportes(view, mod);
        ctrl.iniciar();
        view.setVisible(true);

    }
    
}
