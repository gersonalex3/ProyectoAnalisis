
package Controlador;

import Modelo.ModeloRegistroPersonal;
import Vista.VistaRegistroPersonal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import proyectoanalisis.ProyectoAnalisis;

public class ControladorRegistroPersonal implements ActionListener{

    private VistaRegistroPersonal view;
    private ModeloRegistroPersonal model;

    
    public ControladorRegistroPersonal(VistaRegistroPersonal view, ModeloRegistroPersonal model)
    {
        this.view = view;
        this.model = model;
        this.view.jBtnIngresar.addActionListener(this);
        this.view.jBtnBuscar.addActionListener(this);
        this.view.jBtnModificar.addActionListener(this);
    }
    
    
    public void iniciar()
    {
        view.setTitle("Nuevo Personal");
        
        view.setLocationRelativeTo(null);
        view.getContentPane().setBackground(Color.white);

        view.jTextCodigo.setText(String.valueOf(model.UltimoId()));

    }
    
    
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();
        if(source.getText()=="Ingresar")
            {
                if(view.jTextNombre.getText().length()==0 | view.jTextApellido.getText().length()==0 
                        | view.jTextEstado.getText().length()==0 | view.jTextCodigo.getText().length()==0 )
                {
                    JOptionPane.showMessageDialog(null, "Valor Requerido", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);

                }else
                    {

                    model.setIdPersonal(Integer.parseInt(view.jTextCodigo.getText()));
                    model.setNombre(view.jTextNombre.getText());
                    model.setApellido(view.jTextApellido.getText());
                    model.setPuesto(view.jTextPuesto.getText());
                    model.setEstado(view.jTextEstado.getText());

                    if (model.RegistrarPersonal()==1)
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
                    model.setIdPersonal(Integer.parseInt(view.jTextCodigo.getText()));
                    int resultado = model.BuscarPersona();
                     if(resultado > 0 ){
                            model.setIdPersonal2(resultado);
                            view.jTextNombre.setText(model.getNombre());
                            view.jTextApellido.setText(model.getApellido());
                            view.jTextPuesto.setText(model.getPuesto());
                            view.jTextEstado.setText(model.getEstado());
                            
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
                if(view.jTextNombre.getText().length()==0 | view.jTextApellido.getText().length()==0 
                        | view.jTextEstado.getText().length()==0 | view.jTextCodigo.getText().length()==0 )
                {
                    JOptionPane.showMessageDialog(null, "Valor Requerido", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);

                }else{
                    model.setIdPersonal(Integer.parseInt(view.jTextCodigo.getText()));
                    int resultado = model.BuscarPersona();
                    if(resultado > 0 && model.getIdPersonal() == model.getIdPersonal2() | resultado == 0 ){

                        model.setNombre(view.jTextNombre.getText());
                        model.setApellido(view.jTextApellido.getText());
                        model.setPuesto(view.jTextPuesto.getText());
                        model.setEstado(view.jTextEstado.getText());

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