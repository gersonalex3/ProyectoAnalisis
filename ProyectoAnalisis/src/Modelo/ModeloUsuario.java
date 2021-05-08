/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Alexander Gonzalez
 */
public class ModeloUsuario {
    public int IdUsuario;
    public String Nombre;
    public String Apellido;
    public String Usuario;
    public String Contraseña;
    public String Perfil;
    private int IdUsuario2;   

    public int getIdUsuario2() {
        return IdUsuario2;
    }

    public void setIdUsuario2(int IdUsuario2) {
        this.IdUsuario2 = IdUsuario2;
    }
    private int resulta;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

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
    
    public int UltimoId() {
        resulta = 0;

        try {
            Statement sql = (Statement) Conexion.getConexion().createStatement();

            String consulta = "SELECT MAX(AL_IdAldea) AS id FROM PRO_Aldea;";
            ResultSet resultado = sql.executeQuery(consulta);

            while (resultado.next()) {
                resulta = (resultado.getInt("id"));
                IdUsuario = (resultado.getInt("id"));
            }

        } catch (SQLException ex) {
            resulta = 0;
        }

        return resulta + 1;
    }
    
    public int RegistrarUsuario() {
        int insertar = 0;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = con.prepareCall("INSERT INTO PRO_Usuario(US_IdUsuario,US_Nombre,US_Apellido,US_Usuario,US_Contraseña,US_Perfil)VALUES(?,?,?,?,?,?)");
            cs.setInt(1, IdUsuario);
            cs.setString(2, Nombre);
            cs.setString(3, Apellido);
            cs.setString(4, Usuario);
            cs.setString(5, Contraseña);
            cs.setString(6, Perfil);

            insertar = cs.executeUpdate();
            if (insertar > 0) {
                insertar = 1;
            }
        } catch (Exception e) {
            insertar = 0;
        }
        return insertar;

    }
    
    public int BuscarUsuario() {
        int id = 0;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRO_Usuario WHERE US_IdUsuario=?");
            ps.setInt(1, IdUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = (rs.getInt("US_IdUsuario"));
                Nombre = (rs.getString("US_Nombre"));
                Apellido = (rs.getString("US_Apellido"));
                Usuario = (rs.getString("US_Usuario"));
                Contraseña = (rs.getString("US_Contraseña"));
                Perfil = (rs.getString("US_Perfil"));
            }
            return id;

        } catch (Exception e) {
            return id;
        }
    }
    
    public int ActualizarRegistro() {
        int actualizar = 0;

        try {

            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE PRO_Usuario SET US_IdUsuario=?, US_Nombre=?, US_Apellid=?, US_Usuario=?, US_Contraseña=?, US_Perfil=? WHERE AL_IdAldea=?");
            ps.setInt(1, IdUsuario);
            ps.setString(2, Nombre);
            ps.setString(3, Apellido);
            ps.setString(4, Usuario);
            ps.setString(5, Contraseña);
            ps.setString(6, Perfil);
            ps.setInt(7, IdUsuario2);

            actualizar = ps.executeUpdate();
            if (actualizar > 0) {
                actualizar = 1;
            }
            return actualizar;

        } catch (Exception e) {
            return actualizar;
        }

    }
}
