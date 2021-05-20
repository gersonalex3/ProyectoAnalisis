/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raul1
 */
public class ModeloRegistroNota {
    
    
    
        int idNota;
        Date fecha;
        String direccion;
        int idAldea;
        String InformacionApoyo;
        int tipo_apoyo;
        String expediente;
        int idVecino;
        int calidad;
        int idusuario;
        
        int idEncargado;
        int idPersonal;
        int idResponsable;
        
        String responsable;
        String encargado;
        String nombre;
        String telefono;
        String email;
        String observacion;
        String rim;
        String dpi; 

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdAldea() {
        return idAldea;
    }

    public void setIdAldea(int idAldea) {
        this.idAldea = idAldea;
    }

    public String getInformacionApoyo() {
        return InformacionApoyo;
    }

    public void setInformacionApoyo(String InformacionApoyo) {
        this.InformacionApoyo = InformacionApoyo;
    }

    public int getTipo_apoyo() {
        return tipo_apoyo;
    }

    public void setTipo_apoyo(int tipo_apoyo) {
        this.tipo_apoyo = tipo_apoyo;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public int getIdVecino() {
        return idVecino;
    }

    public void setIdVecino(int idVecino) {
        this.idVecino = idVecino;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRim() {
        return rim;
    }

    public void setRim(String rim) {
        this.rim = rim;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
        
    public int UltimoId() {

        try {
            Statement sql = (Statement) Conexion.getConexion().createStatement();

            String consulta = "SELECT MAX(AC_IdActividad) AS id FROM PRO_ACTIVIDAD;";
            ResultSet resultado = sql.executeQuery(consulta);

            while (resultado.next()) {
                idNota = (resultado.getInt("id"))+1;
            }

        } catch (SQLException ex) {
            idNota = 0;
        }

        return idNota;
    }
    
        public int UltimoIdEncargado() {

        try {
            Statement sql = (Statement) Conexion.getConexion().createStatement();

            String consulta = "SELECT MAX(ENC_IdEncargado) AS id FROM PRO_Encargado;";
            ResultSet resultado = sql.executeQuery(consulta);

            while (resultado.next()) {
                idEncargado = (resultado.getInt("id"))+1;
            }

        } catch (SQLException ex) {
            idEncargado = 0;
        }

        return idEncargado;
    }

   public String RegistroNota(){
    long fecha_prueba=fecha.getTime();
    java.sql.Date fechaF = new java.sql.Date(fecha_prueba);
    String insertar = null;
    
   try{
        Connection con=Conexion.getConexion();
        PreparedStatement cs=con.prepareCall("INSERT INTO PRO_Actividad(AC_IdActividad, AC_FechaHora, AC_Direccion, AL_IdAldea, AC_InformacionDeApoyo, AP_IdApoyo, AC_NumeroExpediente, VEC_IdVecino, CS_IdCalidadServicio, US_IdUsuario)VALUES(?,?,?,?,?,?,?,?,?,?)");
       
        cs.setInt(1, idNota);
        cs.setDate(2, fechaF);
        cs.setString(3, direccion);
        cs.setInt(4, idAldea);
        cs.setString(5, InformacionApoyo);
        cs.setInt(6, tipo_apoyo);
        cs.setString(7, expediente);
        cs.setInt(8, idVecino);
        cs.setInt(9, calidad);
        cs.setInt(10, 1);

        int columnasA = cs.executeUpdate();
            if(columnasA>0)
            {
                insertar="Registro Exitoso";
            }
        } catch(Exception e){
            insertar="Error al registrar";
        }
   return insertar;

   }
   
   public int RegistroEncargado(){
       
       try{
            Connection con=Conexion.getConexion();
            PreparedStatement cs=con.prepareCall("INSERT INTO PRO_Encargado(ENC_IdEncargado, PPMT_IdPersonal, RL_IdRol, AC_IdActividad)VALUES(?,?,?,?)");
            
            cs.setInt(1, idEncargado);
            cs.setInt(2, idPersonal);
            cs.setInt(3, 1);
            cs.setInt(4, idNota);
            
            int entero = cs.executeUpdate();
            
            return idEncargado;
            
       }catch(Exception e){
           return 0;
       }


   }
   
      public int RegistroResponsable(){
       
       try{
            Connection con=Conexion.getConexion();
            PreparedStatement cs=con.prepareCall("INSERT INTO PRO_Encargado(ENC_IdEncargado, PPMT_IdPersonal, RL_IdRol, AC_IdActividad)VALUES(?,?,?,?)");

            cs.setInt(1, idEncargado+1);
            cs.setInt(2, idResponsable);
            cs.setInt(3, 2);
            cs.setInt(4, idNota);
            
            int entero = cs.executeUpdate();
            
            return idEncargado;
            
       }catch(Exception e){
           return 0;
       }

   }
   
        
   
   
   
   /*
     public String BuscarVecino() throws SQLException{
         Statement sql = (Statement) ClaseConexion.getConexion().createStatement();
         String consulta = "SELECT VEC_Nombre, VEC_Telefono, VEC_RIM, VEC_CorreoElectronicoVecino FROM PRO_Vecino WHERE VEC_DPIVecino=TxtDPI;"; 
         ResultSet resultado = sql.executeQuery(consulta);
         return consulta;
     }
     */
   
    public String BuscarPersona()
    {
        try{
            Connection con=Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRO_VECINO WHERE VEC_DPIVecino=?");
            ps.setString(1, dpi);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                idVecino = (rs.getInt("VEC_IdVecino")); 
                dpi = (rs.getString("VEC_DPIVecino"));
                nombre = (rs.getString("VEC_NombreVecino"));
                telefono = (rs.getString("VEC_TelefonoVecino"));
                rim = (rs.getString("VEC_RIMVecino"));
                email = (rs.getString("VEC_CorreoElectronicoVecino"));
            }
            return dpi;
            
        }catch(Exception e){
            return  dpi;
        } 
    }      
       
       
    public ArrayList GenerarEncargado()
    {
       ArrayList<String> encargado = new ArrayList<String>();
      try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "SELECT PPMT_Nombre FROM PRO_PersonalPMT;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next())
            {
                encargado.add(resultado.getString("PPMT_Nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            }
      return encargado;
      
    } 
 
     
     public ArrayList GenerarAldea()
    {
       ArrayList<String> g_aldea = new ArrayList<String>();
      try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "SELECT AL_NombreAldea FROM PRO_Aldea;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next())
            {
                g_aldea.add(resultado.getString("AL_NombreAldea"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            }
      return g_aldea;
      
    }
     
     
     public ArrayList GenerarApoyo()
    {
       ArrayList<String> apoyo = new ArrayList<String>();
      try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "SELECT Ap_Nombre FROM PRO_Apoyo;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next())
            {
                apoyo.add(resultado.getString("Ap_Nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            }
      return apoyo;
      
    }   
     
     
     
   
    
  public ArrayList GenerarCalidad()
    {
       ArrayList<String> Lista = new ArrayList<String>();
      try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "SELECT CS_Nombre FROM PRO_CalidadServicio;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next())
            {
                Lista.add(resultado.getString("CS_Nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
            }
      return Lista;
      
    }   
    
}