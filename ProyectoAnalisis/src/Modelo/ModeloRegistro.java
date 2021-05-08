/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author raul1
 */
public class ModeloRegistro {
        String id;
        String responsable;
        String aldea;
        String ubicacion;
        String tipo_apoyo;
        String encargado;
        String nombre;
        String telefono;
        String email;
        String info_apoyo;
        String observacion;
        String expediente;
        String rim;
        String dpi; 
        Date fecha;
        String insertar;
        String calidad;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo_apoyo() {
        return tipo_apoyo;
    }

    public void setTipo_apoyo(String tipo_apoyo) {
        this.tipo_apoyo = tipo_apoyo;
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

    public String getInfo_apoyo() {
        return info_apoyo;
    }

    public void setInfo_apoyo(String info_apoyo) {
        this.info_apoyo = info_apoyo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getInsertar() {
        return insertar;
    }

    public void setInsertar(String insertar) {
        this.insertar = insertar;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }


    

   public String Registrodatos(){
    long fecha_prueba=fecha.getTime();
    java.sql.Date fechaF = new java.sql.Date(fecha_prueba);
   try{
        Connection con=Conexion.getConexion();
        CallableStatement cs=con.prepareCall("INSERT INTO PRO_Actividad(id,responsable, ubicacion, aldea, tipo_apoyo, encargado, expediente, nombre, dpi, rim, telefono, email, info_apoyo, observacion, fecha,calidad)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        cs.setString(1, id);
        cs.setString(2, responsable);
        cs.setString(3, ubicacion);
        cs.setString(4, aldea);
        cs.setString(5, tipo_apoyo);
        cs.setString(6, encargado);
        cs.setString(7, expediente);
        cs.setString(8, nombre);
        cs.setString(9, dpi);
        cs.setString(10, rim);
        cs.setString(11, telefono);
        cs.setString(12, email);
        cs.setString(13, info_apoyo);
        cs.setString(14, observacion);
        cs.setDate(15, fechaF);
        cs.setString(16, calidad);
        
        int columnasA = cs.executeUpdate();
        if(columnasA>0){
        this.insertar="Registro Exitoso";
        }
        } catch(Exception e){
        }
   return insertar;

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