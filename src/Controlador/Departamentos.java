
package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;


public class Departamentos {
    private int id;
    private String nombre;
    
    public static boolean NuevoDepartamento;
    public static int IdDepartamento;
    public static boolean ExisteDepartamento;

    public Departamentos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Departamentos() {
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
                           "INTO departamentos (id,nombre) "+
                           "VALUES (null,'"+nombre+"')";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(strSql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Departamento grabado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo grabar: "+e);
        }
    }
    
    public void ExisteRegistroNombre(){
        try {
            ExisteDepartamento=false;
            String strSql="SELECT id,nombre "+
                          "FROM departamentos "+
                          "WHERE nombre='"+nombre+"'";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(strSql); 
        
            if (rs.next()){
                ExisteDepartamento=true;
            }
            Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al buscar un cliente "+e);
        }
    }
    
    public void Actualizar(){
        try {
            String strSql="UPDATE departamentos "+
                          "SET nombre='"+nombre+"' "+
                          "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(strSql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Departamento actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo actualizar "+e);
        }
    }
    
    public void BuscarDepartamentoId(){
        try {
            String sql="SELECT id,nombre "+
                       "FROM departamentos "+
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
    
    public DefaultTableModel Buscar(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String sql="SELECT id,nombre "+
                       "FROM departamentos "+
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
    
    private boolean ExistenProductosDepartamentos(){
        boolean Existen=false;
        try {
            String sql="SELECT id "+
                       "FROM productos "+
                       "WHERE dep_id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                Existen=true;
            }
            Conexion.desconectar();
        } catch (Exception e) {
        }
        return Existen;
    }
    
    public void Eliminar(){
        try {
            boolean ExistenProductos =ExistenProductosDepartamentos();
            if (ExistenProductos){
                JOptionPane.showMessageDialog(null, "Imposible eliminar departamento/n"+"Existen productos asocidados", "Eliminar departamentos", 0);
                return;
            }
        
            String strSql="DELETE "+
                          "FROM departamentos "+
                          "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(strSql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Departamento eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo eliminar "+e);
        }
    }
    
    public ArrayList <Departamentos> Combo(){
        ArrayList <Departamentos> ListaDep = new ArrayList<Departamentos>();
        try{
            String strSql="SELECT id,nombre "+
                          "FROM departamentos "+
                          "ORDER BY id";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet objRes = sentencia.executeQuery(strSql);
            //Agrego Todos a Departamentos 
            ListaDep.add(new Departamentos(0 , "Seleccione Departamento"));
            while (objRes.next()){
                ListaDep.add(new Departamentos(Integer.parseInt(objRes.getString(1)), objRes.getString(2)));
            }
            Conexion.desconectar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en el metodo combo "+ex);
        }
        return ListaDep;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}