/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis;

import Modelo.Conexion;
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
        Vista.Reportes f = new Vista.Reportes();
        f.setVisible(true);
        
        
        /*Connection con = Conexion.getConexion();
        
        System.out.println(con);
        
        try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "SELECT * FROM PRO_Estatus;";
            ResultSet resultado = sql.executeQuery(consulta);
            String cadena = resultado.toString();
            
            System.out.println(cadena);
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }*/

    }
    
}
