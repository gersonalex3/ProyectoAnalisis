
package Modelo;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ModeloReportes {
    
    private String Aldea;
    private Date FechaIni;
    private Date FechaFin;

    public String getAldea() {
        return Aldea;
    }

    public void setAldea(String Aldea) {
        this.Aldea = Aldea;
    }

    public Date getFechaIni() {
        return FechaIni;
    }

    public void setFechaIni(Date FechaIni) {
        this.FechaIni = FechaIni;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }
    
    public void GenerarReporte()
    {
        long FechaInicio  = this.FechaIni.getTime();
        long FechaFin  = this.FechaFin.getTime();
        
        java.sql.Date Inicial = new java.sql.Date(FechaInicio);
        java.sql.Date Final = new java.sql.Date(FechaFin);
        
      try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "Consulta;";
            ResultSet resultado = sql.executeQuery(consulta);
            String cadena = resultado.toString();
            
            System.out.println(cadena);
        }catch(SQLException ex){
            System.out.println(ex.toString());
            }

    }
    
}
