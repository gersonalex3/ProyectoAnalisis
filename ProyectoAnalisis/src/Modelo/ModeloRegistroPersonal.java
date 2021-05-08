
package Modelo;

import java.sql.*;


public class ModeloRegistroPersonal {
    
    private int IdPersonal;
    private String Nombre;
    private String Apellido;
    private String Puesto;
    private String Estado;
    private int IdPersonal2;
    private int resulta;

    public int getIdPersonal() {
        return IdPersonal;
    }

    public void setIdPersonal(int IdPersonal) {
        this.IdPersonal = IdPersonal;
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

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public int getResulta() {
        return resulta;
    }

    public void setResulta(int resulta) {
        this.resulta = resulta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdPersonal2() {
        return IdPersonal2;
    }

    public void setIdPersonal2(int IdPersonal2) {
        this.IdPersonal2 = IdPersonal2;
    }
    
    public int UltimoId()
    {
        resulta = 0;
        
        try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            
            String consulta = "SELECT MAX(PPMT_IdPersonal) AS id FROM PRO_PersonalPMT;";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next())
            {
                resulta = (resultado.getInt("id"));
                IdPersonal = (resultado.getInt("id"));
            }
            
        }catch(SQLException ex){
            resulta = 0;
            }
        
        return resulta+1;
    }
    
    public int RegistrarPersonal()
    {
        int insertar = 0;
        try{
            Connection con=Conexion.getConexion();
            CallableStatement cs=con.prepareCall("INSERT INTO PRO_PersonalPMT(PPMT_IdPersonal,PPMT_Nombre, PPMT_Apellido, PPMT_Puesto, PPMT_Estado)VALUES(?,?,?,?,?)");
            cs.setInt(1, IdPersonal);
            cs.setString(2, Nombre);
            cs.setString(3, Apellido);
            cs.setString(4, Puesto);
            cs.setString(5, Estado);

            insertar = cs.executeUpdate();
            if(insertar>0)
                {
                    insertar=1;
                }
        }catch(Exception e){
            insertar = 0 ;
        }
    return insertar;
        
    }
    
    public int BuscarPersona()
    {
        int id = 0;
        try{
            Connection con=Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRO_PersonalPMT WHERE PPMT_IdPersonal=?");
            ps.setInt(1, IdPersonal);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                id = (rs.getInt("PPMT_IdPersonal"));
                Nombre = (rs.getString("PPMT_Nombre"));
                Apellido = (rs.getString("PPMT_Apellido"));
                Puesto = (rs.getString("PPMT_Puesto"));
                Estado = (rs.getString("PPMT_Estado"));
            }
            return id;
            
        }catch(Exception e){
            return  id;
        } 
    }
    
    public int ActualizarRegistro()
    {
        int actualizar = 0;
        
        try{
            
            Connection con=Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE PRO_PersonalPMT SET PPMT_IdPersonal=?, PPMT_Nombre = ?, PPMT_Apellido= ?, PPMT_Puesto = ?, PPMT_Estado = ? WHERE PPMT_IdPersonal=?");
            ps.setInt(1, IdPersonal);
            ps.setString(2, Nombre);
            ps.setString(3, Apellido);
            ps.setString(4, Puesto);
            ps.setString(5, Estado);
            ps.setInt(6, IdPersonal2);
            
           actualizar = ps.executeUpdate();
           if(actualizar>0)
           {
               actualizar = 1;    
           }
            return actualizar;
            
        }catch(Exception e){
            return actualizar;
        }
        
        
        
    }
    
    
    
}
