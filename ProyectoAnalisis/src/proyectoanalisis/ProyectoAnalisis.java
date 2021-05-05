/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis;

import Controlador.ControladorRegistro;
import Controlador.ControladorReportes;
import Modelo.Conexion;
import Modelo.ModeloRegistro;
import Modelo.ModeloReportes;
import Vista.*;
import java.sql.*;
/**
 *
 * @author alx_g
 */
public class ProyectoAnalisis {


    public static void main(String[] args){
        
        Home view = new Home();
        view.setVisible(true);
        view.setLocationRelativeTo(null);

    }
    
    public static void NuevaNota()
    {
        VistaRegistro view= new VistaRegistro();
        ModeloRegistro mod= new ModeloRegistro();
        ControladorRegistro controlaC= new ControladorRegistro(view, mod);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        controlaC.Iniciar();
    }
    
    public static void NuevoReporte()
    {
        ModeloReportes mod = new ModeloReportes();
        VistaReportes view = new VistaReportes();
        
        ControladorReportes ctrl = new ControladorReportes(view, mod);
        ctrl.iniciar();
        view.setVisible(true); 
    }
    
}
