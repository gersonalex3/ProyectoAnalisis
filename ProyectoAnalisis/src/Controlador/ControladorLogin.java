
package Controlador;

import Modelo.ModeloLogin;
import Vista.Login;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyectoanalisis.ProyectoAnalisis;


public class ControladorLogin implements ActionListener{
    private Login view;
    private ModeloLogin model;
    
    public ControladorLogin (Login view, ModeloLogin model)
    {
        this.view = view;
        this.model = model;
        this.view.jBtnLogin.addActionListener(this);
    }
    
    public void iniciar()
    {
        view.setTitle("INGRESAR AL SISTEMA");
        
        view.setLocationRelativeTo(null);
        view.getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        String variable = (String.valueOf(view.jTextContraseña.getPassword()));
        if(view.jTextUsuario.getText().length()==0 | variable.length()==0)
        {
            JOptionPane.showMessageDialog(null, "Valor Requerido", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);
        }else {
            model.setUsuario(view.jTextUsuario.getText());
            model.setContraseña(variable);
            String Perfil = model.IngresoUsuario();
            if(Perfil == null)
            {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);
            }else{
                view.dispose();
                ProyectoAnalisis.Home();
            }
            
        }
    }
    
}
