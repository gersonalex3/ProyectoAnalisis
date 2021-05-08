/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis;

import Controlador.*;

import Modelo.*;

import Vista.*;
/**
 *
 * @author alx_g
 */
public class ProyectoAnalisis {


    public static void main(String[] args){
        
        Login();

    }
    
    public static void Login()
    {
        Login view = new Login();
        ModeloLogin mod = new ModeloLogin();
        ControladorLogin controlaC= new ControladorLogin(view, mod);
        
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        controlaC.iniciar();
    }
    
    public static void Home()
    {
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
    
        public static void NuevoPersonal()
    {
        ModeloRegistroPersonal mod = new ModeloRegistroPersonal();
        VistaRegistroPersonal view = new VistaRegistroPersonal();
        
        ControladorRegistroPersonal ctrl = new ControladorRegistroPersonal(view, mod);
        ctrl.iniciar();
        view.setVisible(true); 
    }
        
    public static void NuevaAldea()
    {
        ModeloAldea mod = new ModeloAldea();
        VistaRegistroAldea view = new VistaRegistroAldea();
        
        ControladorAldea ctrl = new ControladorAldea(view, mod);
        ctrl.iniciar();
        view.setVisible(true); 
    }
    
}
