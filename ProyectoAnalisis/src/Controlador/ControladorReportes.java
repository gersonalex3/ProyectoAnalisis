
package Controlador;

import Modelo.ModeloReportes;
import Vista.VistaReportes;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
        ArrayList<String> Lista = new ArrayList<String>();
        
        view.setTitle("Modulo de Reportes");
        view.setLocationRelativeTo(null);
        view.getContentPane().setBackground(Color.white);
        
        view.CAldea.add("");
        
        Lista = model.GenerarAldeas();
        
        for(int i=0;i<Lista.size();i++)
        {
            view.CAldea.add(Lista.get(i));
        }

    }
    
    public void actionPerformed (ActionEvent e)
    {
        Connection con = Modelo.Conexion.getConexion();
        
        model.setAldea(view.CAldea.getSelectedItem());

        java.lang.String Aldea = model.getAldea();
    
        if(view.jAldea.isVisible())
        {
            if(view.CAldea.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(null, "Favor seleccionar la aldea", 
                         "Error" ,JOptionPane.ERROR_MESSAGE);   
            }
        }
        
        try{
            
        model.setFechaIni(view.jDateIni.getDate());
        model.setFechaFin(view.jDateFin.getDate());
        
        long FechaInicio = model.getFechaIni().getTime();
        long FechaFin  = model.getFechaFin().getTime();
        
        java.sql.Date Inicial = new java.sql.Date(FechaInicio);
        java.sql.Date Final = new java.sql.Date(FechaFin);
            
            if((model.getFechaFin()).before(model.getFechaIni()))
            {
                JOptionPane.showMessageDialog(null, "Fecha Fin antes de Inicio ", 
                         "Error" ,JOptionPane.ERROR_MESSAGE);
            }else if(view.jAldea.isVisible() && view.CAldea.getSelectedIndex()!=0)
                {
                    try{
                            JasperReport reporte = null;
            
                            String path = "src\\Reportes\\ReporteAldea.jasper";
                            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
                            Map parametros2 = new HashMap();
                            parametros2.put("FechaIni",Inicial);
                            parametros2.put("FechaFin",Final);
                            parametros2.put("Aldea",Aldea);

                            JasperPrint informe = JasperFillManager.fillReport(reporte, parametros2,con);
                            JasperViewer view = new JasperViewer(informe,false);
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);

                        }catch(HeadlessException | JRException ex){
                             JOptionPane.showMessageDialog(null, "Error al generar reporte" + ex, 
                                    "Error",JOptionPane.ERROR_MESSAGE);
                        }
                
                }else if(view.jAldea.isVisible()==false)
                {
                    
                    try{
                            JasperReport reporte = null;
            
                            String path = "src\\Reportes\\ReporteFecha.jasper";
                            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
                            Map parametros = new HashMap();
                            parametros.put("FechaIni",Inicial);
                            parametros.put("FechaFin",Final);

                            JasperPrint informe = JasperFillManager.fillReport(reporte, parametros,con);
                            JasperViewer view = new JasperViewer(informe,false);
                            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            view.setVisible(true);

                        }catch(HeadlessException | JRException ex){
                             JOptionPane.showMessageDialog(null, "Error al generar reporte", 
                                    "Error" ,JOptionPane.ERROR_MESSAGE);
                        }
                }
                
            }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Fecha vacía", 
                    "Error" ,JOptionPane.ERROR_MESSAGE);

            }

    }
    
}
