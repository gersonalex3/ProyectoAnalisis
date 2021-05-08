
package Controlador;

import Modelo.ModeloLogin;
import Vista.Home;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyectoanalisis.ProyectoAnalisis;


public class ControladorHome implements ActionListener{
    private Home view;
    private ModeloLogin model;
    
    
    public ControladorHome (Home view, ModeloLogin model)
    {
        this.view = view;
        this.model = model;
        this.view.jBtnCerrar.addActionListener(this);
        
    }
    
    public void iniciar()
    {
        
        view.setTitle("Home");
        
        view.setLocationRelativeTo(null);
        view.getContentPane().setBackground(Color.white);
        
        String perfil = model.getPerfil();
        if (perfil=="Operario")
        {
            view.jMenuPersonal.setVisible(false);
            view.jMenuAldea.setVisible(false);
            view.jMenuReportes.setVisible(false);
        }
    }
    
    public void actionPerformed (ActionEvent e)
    {
        view.dispose();
        ProyectoAnalisis.Login();

    }
}
