package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Perfiles {
    private int id;
    private String nombre;
    
    public static boolean NuevoPerfil;
    public static int IdPerfil;
    public static boolean ExisteNombrePerfil;

    public Perfiles() {
    }

    public Perfiles(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void Grabar(){
        try {
            String strSql ="INSERT "+
                           "INTO perfiles (id,nombre) "+
                           "VALUES (null,'"+nombre+"')";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(strSql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Perfil grabado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo grabar: "+e);
        }
    }
    
    public void ExisteRegistroNombre(){
        try {
            ExisteNombrePerfil=false;
            String strSql="SELECT id,nombre "+
                          "FROM perfiles "+
                          "WHERE nombre='"+nombre+"'";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(strSql);
            if (rs.next()){
                ExisteNombrePerfil=true;
            }
            Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al buscar "+e);
        }
    }
    
    public void BuscarPerfilId(){
        try {
            String sql="SELECT id,nombre "+
                       "FROM perfiles "+
                       "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                id=Integer.parseInt(rs.getString(1));
                nombre=rs.getString(2);  
            }
            Conexion.desconectar();
        } catch (Exception e) {
        }
    }
    
    public void Actualizar(){
        try {
            String strSql="UPDATE perfiles "+
                          "SET nombre='"+nombre+"' "+
                          "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(strSql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Perfil actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo actualizar "+e);
        }
    }
    
    private boolean ExistenUsuariosPerfil(){
        boolean ExistenUsuarios=false;
        try {
            String sql="SELECT user " +
                       "FROM usuarios " +
                       "WHERE per_id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet objRes = sentencia.executeQuery(sql);
            if (objRes.next()){
                ExistenUsuarios=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en procedimiento: ExistenUsuariosPerfil: "+e);
        }
        return ExistenUsuarios;
    }
    
    public void Eliminar(){
        try {
            boolean ExistenUsuarios=this.ExistenUsuariosPerfil();
            if(ExistenUsuarios){
                JOptionPane.showMessageDialog(null, "Imposible eliminar perfil\n"+"Existen usuarios asociados !!!", "Eliminar perfil", 0);
                return;
            }
            String strSql="DELETE "+
                          "FROM perfiles "+
                          "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(strSql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Perfil eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo eliminar "+e);
        }
    }
    
    public DefaultTableModel Buscar(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String sql="SELECT id,nombre "+
                       "FROM perfiles "+
                       "WHERE nombre like '%"+nombre+"%'";
            Conexion.conectar();
            Statement s = Conexion.conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery(sql); 
            ResultSetMetaData rsmd = rs.getMetaData();
            int CanColumns = 2;
            for(int i=1;i<=CanColumns;i++){
                modelo.addColumn(rsmd.getColumnLabel(i));
            }
            while (rs.next()){
                Object[] fila=new Object[CanColumns];            

                for(int i=0;i<CanColumns;i++){
                    fila[i] = rs.getObject(i+1);
                }  
                modelo.addRow(fila);
            }
           Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el modulo buscar: "+e);
        }
        return modelo;
    }
    
    public ArrayList <Perfiles> Combo(){
        ArrayList <Perfiles> ListaPerfil = new ArrayList<Perfiles>();
        try{
            String strSql="SELECT id,nombre "+
                          "FROM perfiles "+
                          "ORDER BY id";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet objRes = sentencia.executeQuery(strSql);
            while (objRes.next()){
                ListaPerfil.add(new Perfiles(Integer.parseInt(objRes.getString(1)), objRes.getString(2)));
            }
            Conexion.desconectar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en el metodo combo "+ex);
        }
        return ListaPerfil;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}
