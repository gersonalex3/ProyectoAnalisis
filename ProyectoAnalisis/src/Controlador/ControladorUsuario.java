/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuario;
import Vista.VistaRegistroUsuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import proyectoanalisis.ProyectoAnalisis;

/**
 *
 * @author Alexander Gonzalez
 */
public class ControladorUsuario implements ActionListener {
    private VistaRegistroUsuario view;
    private ModeloUsuario model;
    
    public ControladorUsuario(VistaRegistroUsuario view, ModeloUsuario model) {
        this.view = view;
        this.model = model;
        this.view.jBtnIngresar.addActionListener(this);
        this.view.jBtnBuscar.addActionListener(this);
        this.view.jBtnModificar.addActionListener(this);
    }
    
    public void iniciar() {
        view.setTitle("Nuevo Usuario");
        view.setLocationRelativeTo(null);
        view.getContentPane().setBackground(Color.white);
        view.jTextCodigo.setText(String.valueOf(model.UltimoId()));
    }
    
        public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        if(source.getText()=="Ingresar")
            {
                if(view.jTextNombre.getText().length()==0 )
                {
                    JOptionPane.showMessageDialog(null, "Valor Requerido", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);

                }else
                    {

                    model.setIdUsuario(Integer.parseInt(view.jTextCodigo.getText()));
                    model.setNombre(view.jTextNombre.getText());
                    model.setApellido(view.jTextApellido.getText());
                    model.setUsuario(view.jTextUsuario.getText());
                    model.setContraseña(view.jTextContraseña.getText());
                    model.setPerfil(view.jTextPerfil.getText());

                    if (model.RegistrarUsuario()==1)
                    {
                        JOptionPane.showMessageDialog(null, "Registro Ingresado");
                        view.dispose();
                        ProyectoAnalisis.NuevoPersonal();
                    }else{
                        JOptionPane.showMessageDialog(null, "Dato Ingresado no es Válido", 
                                 "Error" ,JOptionPane.ERROR_MESSAGE);
                         }
                    } 
            }
        if(source.getText()=="Buscar")
            {
                if(view.jTextCodigo.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Favor Ingrese un Código Correcto", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);
                }else{
                    model.setIdUsuario(Integer.parseInt(view.jTextCodigo.getText()));
                    int resultado = model.BuscarUsuario();
                     if(resultado > 0 ){
                            model.setIdUsuario2(resultado);
                            view.jTextNombre.setText(model.getNombre());
                            view.jTextApellido.setText(model.getApellido());
                            view.jTextUsuario.setText(model.getUsuario());
                            view.jTextContraseña.setText(model.getContraseña());
                            view.jTextPerfil.setText(model.getPerfil());
                            
                            model.UltimoId();
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "Dato Ingresado no es Válido", 
                            "Error" ,JOptionPane.ERROR_MESSAGE);
                        }  
                }
            }
        if(source.getText()=="Modificar")
            {
                if(view.jTextNombre.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Valor Requerido", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);

                }else{
                    model.setIdUsuario(Integer.parseInt(view.jTextCodigo.getText()));
                    int resultado = model.BuscarUsuario();
                    if(resultado > 0 && model.getIdUsuario() == model.getIdUsuario2() | resultado == 0 ){

                        model.setNombre(view.jTextNombre.getText());
                        model.setApellido(view.jTextApellido.getText());
                        model.setUsuario(view.jTextUsuario.getText());
                        model.setContraseña(view.jTextContraseña.getText());
                        model.setPerfil(view.jTextPerfil.getText());

                        int actualizar = model.ActualizarRegistro();
                        if(actualizar>0)
                        {
                            JOptionPane.showMessageDialog(null, "Registro Actualizado");
                            view.dispose();
                            ProyectoAnalisis.NuevoUsuario();
                        }else{
                            JOptionPane.showMessageDialog(null, "Error al actualizar", 
                            "Error" ,JOptionPane.ERROR_MESSAGE);
                            }

                    }else{
                        
                        JOptionPane.showMessageDialog(null, "Código Ya Existe", 
                        "Error" ,JOptionPane.ERROR_MESSAGE);
                        
                    }
                }
            }
 
    }
    
}
