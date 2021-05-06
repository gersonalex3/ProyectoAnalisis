
package Modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ModeloReportes {
    
    private String Aldea;
    private Date FechaIni;
    private Date FechaFin;
    private String Resultado;

    public String getAldea() {
        return Aldea;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
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
    
    public ArrayList GenerarAldeas()
    {
       ArrayList<String> Lista = new ArrayList<String>();
      try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "SELECT AL_NombreAldea FROM PRO_Aldea;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next())
            {
                Lista.add(resultado.getString("AL_NombreAldea"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            }
      return Lista;
      
    }
}
