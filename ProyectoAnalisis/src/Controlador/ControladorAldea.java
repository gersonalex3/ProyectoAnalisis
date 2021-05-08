/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import proyectoanalisis.ProyectoAnalisis;
import Modelo.ModeloAldea;
import Vista.VistaRegistroAldea;

/**
 *
 * @author Alexander Gonzalez
 */
public class ControladorAldea implements ActionListener {

    private VistaRegistroAldea view;
    private ModeloAldea model;

    public ControladorAldea(VistaRegistroAldea view, ModeloAldea model) {
        this.view = view;
        this.model = model;
        this.view.jBtnIngresar.addActionListener(this);
        this.view.jBtnBuscar.addActionListener(this);
        this.view.jBtnModificar.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("Nueva Aldea");
        view.setLocationRelativeTo(null);
        view.getContentPane().setBackground(Color.white);
        view.jTextCodigo.setText(String.valueOf(model.UltimoId()));
    }
    
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        if(source.getText()=="Ingresar")
            {
                if(view.jTextNombreAldea.getText().length()==0 )
                {
                    JOptionPane.showMessageDialog(null, "Valor Requerido", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);

                }else
                    {

                    model.setIdAldea(Integer.parseInt(view.jTextCodigo.getText()));
                    model.setNombreAldea(view.jTextNombreAldea.getText());

                    if (model.RegistrarAldea()==1)
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
                    model.setIdAldea(Integer.parseInt(view.jTextCodigo.getText()));
                    int resultado = model.BuscarAldea();
                     if(resultado > 0 ){
                            model.setIdAldea2(resultado);
                            view.jTextNombreAldea.setText(model.getNombreAldea());
                            
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
                if(view.jTextNombreAldea.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null, "Valor Requerido", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);

                }else{
                    model.setIdAldea(Integer.parseInt(view.jTextCodigo.getText()));
                    int resultado = model.BuscarAldea();
                    if(resultado > 0 && model.getIdAldea() == model.getIdAldea2() | resultado == 0 ){

                        model.setNombreAldea(view.jTextNombreAldea.getText());

                        int actualizar = model.ActualizarRegistro();
                        if(actualizar>0)
                        {
                            JOptionPane.showMessageDialog(null, "Registro Actualizado");
                            view.dispose();
                            ProyectoAnalisis.NuevoPersonal();
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
