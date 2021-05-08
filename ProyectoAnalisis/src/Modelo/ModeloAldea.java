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
public class ModeloAldea {

    

    private int IdAldea;
    private String NombreAldea;
    private int IdAldea2;   
    private int resulta;

    public int getIdAldea() {
        return IdAldea;
    }

    public String getNombreAldea() {
        return NombreAldea;
    }
    
    public void setIdAldea2(int IdAldea2) {
        this.IdAldea2 = IdAldea2;
    }
    
    public int getIdAldea2() {
        return IdAldea2;
    }

    public void setIdAldea(int IdAldea) {
        this.IdAldea = IdAldea;
    }

    public void setNombreAldea(String NombreAldea) {
        this.NombreAldea = NombreAldea;
    }

    public int UltimoId() {
        resulta = 0;

        try {
            Statement sql = (Statement) Conexion.getConexion().createStatement();

            String consulta = "SELECT MAX(AL_IdAldea) AS id FROM PRO_Aldea;";
            ResultSet resultado = sql.executeQuery(consulta);

            while (resultado.next()) {
                resulta = (resultado.getInt("id"));
                IdAldea = (resultado.getInt("id"));
            }

        } catch (SQLException ex) {
            resulta = 0;
        }

        return resulta + 1;
    }

    public int RegistrarAldea() {
        int insertar = 0;
        try {
            Connection con = Conexion.getConexion();
            CallableStatement cs = con.prepareCall("INSERT INTO PRO_Aldea(AL_IdAldea,AL_NombreAldea)VALUES(?,?)");
            cs.setInt(1, IdAldea);
            cs.setString(2, NombreAldea);

            insertar = cs.executeUpdate();
            if (insertar > 0) {
                insertar = 1;
            }
        } catch (Exception e) {
            insertar = 0;
        }
        return insertar;

    }

    public int BuscarAldea() {
        int id = 0;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRO_Aldea WHERE AL_IdAldea=?");
            ps.setInt(1, IdAldea);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = (rs.getInt("AL_IdAldea"));
                NombreAldea = (rs.getString("AL_NombreAldea"));
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
            PreparedStatement ps = con.prepareStatement("UPDATE PRO_Aldea SET AL_IdAldea=?, AL_NombreAldea = ? WHERE AL_IdAldea=?");
            ps.setInt(1, IdAldea);
            ps.setString(2, NombreAldea);
            ps.setInt(3, IdAldea2);

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
