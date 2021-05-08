
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ModeloLogin {
    
    private String Usuario;
    private String Contraseña;
    private String Perfil;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }

    
 
    public String IngresoUsuario()
    {
        try{
            
            Connection con=Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT US_Perfil FROM PRO_Usuario WHERE US_Usuario=? AND US_Contraseña=?");
            ps.setString(1, Usuario);
            ps.setString(2, Contraseña);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                Perfil = (rs.getString("US_Perfil"));
            }
            return Perfil;
            
        }catch(SQLException ex){
            Perfil = null;
            }
        
        return Perfil;
    }
    
}
