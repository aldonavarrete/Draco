
package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Proveedores {
    public int id;
    public String rut;
    public String nombre;
    public String direccion;
    public String ciudad;
    public String comuna;
    public String contacto;
    public String mail;
    public String telefono;
    public String observacion;
    
    public static boolean ExisteRUTProveedor;
    public static boolean ExisteProveedor;
    public static boolean ProveedorNuevo;
    public static int IdProveedor;

    public Proveedores() {
    }

    public Proveedores(int id, String rut, String nombre, String direccion, String ciudad, String comuna, String contacto, String mail, String telefono, String observacion) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.contacto = contacto;
        this.mail = mail;
        this.telefono = telefono;
        this.observacion = observacion;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public void Grabar(){
        try {
            String sql="INSERT INTO proveedores (id,rut,nombre,direccion,ciudad,comuna,contacto,mail,telefono,observacion) "+
                       "VALUES (null,'"+rut+"','"+nombre+"','"+direccion+"','"+ciudad+"','"+comuna+"','"+contacto+"','"+mail+"','"+telefono+"','"+observacion+"')";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Proveedor grabado");
        } catch (Exception e) {
        }
    }
    
    public void Actualizar(){
        try {
            String sql="UPDATE proveedores "+
                       "SET rut='"+rut+"',nombre='"+nombre+"',direccion='"+direccion+"',ciudad='"+ciudad+"',comuna='"+comuna+"',"+
                       "contacto='"+contacto+"',mail='"+mail+"',telefono='"+telefono+"',observacion='"+observacion+"' "+
                       "WHERE id="+id;
            System.out.println(sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Proveedor actualizado");
        } catch (Exception e) {
        }
    }
    
    public void ExisteRutCliente(){
        ExisteRUTProveedor=false;
        try {
            String Sql="SELECT id "+
                       "FROM proveedores "+
                       "WHERE rut='"+rut+"'";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(Sql);
            if (rs.next()){
                ExisteRUTProveedor=true;
            }
            Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al validae si existe rut proveedor: "+e);
        }
    }
    
    public DefaultTableModel Buscar(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String sql="SELECT id,rut,nombre,direccion,ciudad "+
                       "FROM proveedores "+
                       "WHERE nombre like '%"+nombre+"%' AND rut like '%"+rut+"%'";
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
    
    public void BuscaProveedorId(){
        ExisteProveedor=false;
        try {
            String sql="SELECT id,rut,nombre,direccion,ciudad,comuna,contacto,mail,telefono,observacion "+
                       "FROM proveedores "+
                       "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                ExisteProveedor=true;
                id=Integer.parseInt(rs.getString(1));
                rut=rs.getString(2);  
                nombre=rs.getString(3);
                direccion=rs.getString(4);
                ciudad=rs.getString(5);
                comuna=rs.getString(6);
                contacto=rs.getString(7);
                mail=rs.getString(8);
                telefono=rs.getString(9);
                observacion=rs.getString(10);
            }
            Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en modulo buscar proveedor: "+e);
        }
    }
}
