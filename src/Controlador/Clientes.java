
package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Clientes {
    public int id;
    public String rut;
    public String nombre;
    public String direccion;
    public String ciudad;
    public String comuna;
    public String giro;
    public int activo;
    
    //Banderas
    public static boolean ExisteRUTCliente;
    public static boolean ClienteNuevo;
    public static int IdCliente;
    
    public Clientes() {
    }

    public Clientes(int id, String rut, String nombre, String direccion, String ciudad, String comuna, String giro, int activo) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.giro = giro;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public void ExisteRutCliente(){
        ExisteRUTCliente=false;
        try {
            String Sql="SELECT id "+
                       "FROM clientes "+
                       "WHERE rut='"+rut+"'";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(Sql);
            if (rs.next()){
                ExisteRUTCliente=true;
            }
            Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al validae si existe rut cliente: "+e);
        }
    }
    
    public void Grabar(){
        try {
            String sql="INSERT INTO clientes (id,rut,nombre,direccion,ciudad,comuna,giro,activo) "+
                       "VALUES (null,'"+rut+"','"+nombre+"','"+direccion+"','"+ciudad+"','"+comuna+"','"+giro+"',1)";
            //System.out.println(sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error modulo grabar cliente: "+e);
        }
    }
    
    public void Actualizar(){
        try {
            String sql="UPDATE clientes "+
                       "SET rut='"+rut+"',nombre='"+nombre+"',direccion='"+direccion+"',ciudad='"+ciudad+"',comuna='"+comuna+"',giro='"+giro+"',activo="+activo+" "+
                       "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Cliente actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error modulo actualizar cliente: "+e);
        }
    }
    
    public DefaultTableModel Buscar(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String sql="SELECT id,rut,nombre,direccion,ciudad "+
                       "FROM clientes "+
                       "WHERE nombre like '%"+nombre+"%' AND rut like '%"+rut+"%' AND activo="+activo;
            System.out.println(sql);
            Conexion.conectar();

            Statement s = Conexion.conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery(sql); 

            ResultSetMetaData rsmd = rs.getMetaData();
            int CanColumns = 5;
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
    
    public void BuscaClienteId(){
        ExisteRUTCliente=false;
        try {
            String sql="SELECT id,rut,nombre,direccion,ciudad,comuna,giro,activo "+
                       "FROM clientes "+
                       "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql); 

            if (rs.next()){
                ExisteRUTCliente=true;
                id=Integer.parseInt(rs.getString(1));
                rut=rs.getString(2);  
                nombre=rs.getString(3);
                direccion=rs.getString(4);
                ciudad=rs.getString(5);
                comuna=rs.getString(6);
                giro=rs.getString(7);
                activo=Integer.parseInt(rs.getString(8));
            }
            Conexion.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en modulo buscar cliente: "+e);
        }
    }
    
    public void IprimeCliente(){
        System.out.println("ID:"+id);
        System.out.println("Rut:"+rut);
        System.out.println("Nombre:"+nombre);
        System.out.println("Direccion:"+direccion);
        System.out.println("Ciudad:"+ciudad);
        System.out.println("Comuna:"+comuna);
        System.out.println("Giro:"+giro);
        System.out.println("Activo:"+activo);
    }
}
