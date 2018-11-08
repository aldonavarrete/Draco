
package Controlador;

import Conexion.Conexion;
import Seguridad.Encriptacion;
import java.sql.ResultSet;
import java.sql.Statement;


public class BaseDatos {
    
    public void crearTablaPerfiles(){
        String sql = "CREATE TABLE IF NOT EXISTS perfiles "+
                     "(id integer PRIMARY KEY, "+
                     "nombre VARCHAR NOT NULL);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla perfiles creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla perfiles no creada: "+e);
        }
    }
    
    public void crearTablaUsuarios(){
        String sql = "CREATE TABLE IF NOT EXISTS usuarios " +
                     "(user VARCHAR(15) NOT NULL PRIMARY KEY," +
                     "password VARCHAR NOT NULL, " +
                     "nombre VARCHAR NOT NULL, " +
                     "per_id INT NOT NULL, " +
                     "mail VARCHAR, " +
                     "activo TINYINT DEFAULT 1);";
        try {
            Conexion.conectar(); 
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla usuarios creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla usuarios no creada: "+e);
        }
    }
    
    public void crearTablaDepartamentos(){
        String sql = "CREATE TABLE IF NOT EXISTS departamentos "+
                     "(id integer PRIMARY KEY, "+
                     "nombre VARCHAR NOT NULL);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla departamentos creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla departamentos no creada: "+e);
        }
    }
    
    public void crearTablaClientes(){
        String sql = "CREATE TABLE IF NOT EXISTS clientes "+
                     "(id integer PRIMARY KEY, "+
                     "rut VARCHAR NOT NULL, "+
                     "nombre VARCHAR NOT NULL, "+
                     "direccion VARCHAR NOT NULL, "+
                     "ciudad VARCHAR NOT NULL, "+
                     "comuna VARCHAR NOT NULL, "+
                     "giro VARCHAR NOT NULL, "+
                     "activo TINYINT NOT NULL DEFAULT 1);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla clientes creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla clientes no creada: "+e);
        }
    }
    
    public void crearTablaProveedores(){
        String sql="CREATE TABLE IF NOT EXISTS  proveedores " +
                   "(id integer PRIMARY KEY, "+
                   "rut VARCHAR NOT NULL, " +
                   "nombre VARCHAR NOT NULL, " +
                   "direccion VARCHAR NOT NULL, " +
                   "ciudad VARCHAR NOT NULL, " +
                   "comuna VARCHAR NOT NULL, " +
                   "contacto VARCHAR NOT NULL, " +
                   "mail VARCHAR NOT NULL, " +
                   "telefono VARCHAR NOT NULL, " +
                   "observacion VARCHAR NOT NULL);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla proveedores creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla proveedores no creada: "+e);
        }
    }
    
    public void crearTablaProductos(){
        String sql = "CREATE TABLE IF NOT EXISTS productos "+
                     "(id integer PRIMARY KEY, "+
                     "dep_id integer NOT NULL, "+
                     "nombre VARCHAR NOT NULL, "+
                     "stock DOUBLE NOT NULL, "+
                     "afecto TINYINT NOT NULL DEFAULT 1, "+
                     "unidad CHAR(3) NOT NULL, "+
                     "tipo VARCHAR NOT NULL DEFAULT 'Unitario',"+
                     "activo TINYINT NOT NULL DEFAULT 1);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla productos creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla productos no creada: "+e);
        }
    }
    
    public void crearTablaEAN(){
        String sql = "CREATE TABLE IF NOT EXISTS ean (" +
                     "pro_id INTEGER," +
                     "ean CHAR (18)," +
                     "PRIMARY KEY (pro_id,ean));";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla ean creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla ean no creada: "+e);
        }
    }
    
    public void crearTablaPrecios(){
        String sql = "CREATE TABLE IF NOT EXISTS precios (" +
                     "pro_id integer PRIMARY KEY," +
                     "venta INTEGER," +
                     "ultimo_costo DOUBLE," +
                     "costo_pp DOUBLE);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla Precios creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla Precios no creada: "+e);
        }
    }
    
    public void crearTablaMerma(){
        String sql = "CREATE TABLE IF NOT EXISTS merma (" +
                     "id integer PRIMARY KEY," +
                     "fecha DATE," +
                     "observacion DOUBLE," +
                     "user VARCHAR(15));";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla Merma creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla Merma no creada: "+e);
        }
    }
    
    public void crearTablaMermaD(){
        String sql = "CREATE TABLE IF NOT EXISTS mermaD (" +
                     "id integer PRIMARY KEY," +
                     "mer_id integer," +
                     "pro_id integer ," +
                     "cantidad DOUBLE," +
                     "costo DOUBLE);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla MermaD creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla MermaD no creada: "+e);
        }
    }
    
    public void crearTablaKardex(){
        String sql = "CREATE TABLE IF NOT EXISTS kardex (" +
                     "id integer PRIMARY KEY," +
                     "documento VARCHAR(20)," +
                     "numero integer ," +
                     "tipo CHAR(1)," +
                     "fecha_movimiento DATE,"+
                     "pro_id integer,"+
                     "cantidad double,"+
                     "saldo_anterior double,"+
                     "saldo_actual double,"+
                     "costo double);";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla kardex creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla kardex no creada: "+e);
        }
    }
    
    public void crearTablaCompra(){
        String sql = "CREATE TABLE IF NOT EXISTS compra (" +
                     "id integer PRIMARY KEY," +
                     "documento VARCHAR(20)," +
                     "folio integer," +
                     "prv_id integer,"+
                     "fecha DATE,"+
                     "es_neto TINYINT NOT NULL DEFAULT 1,"+
                     "de_alta TINYINT NOT NULL DEFAULT 0)";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla compra creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla compra no creada: "+e);
        }
    }
    
    public void crearTablaCompraD(){
        String sql = "CREATE TABLE IF NOT EXISTS compraD (" +
                     "id integer PRIMARY KEY," +
                     "com_id integer," +
                     "pro_id integer," +
                     "cantidad double,"+
                     "unitario double)";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla compraD creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla compraD no creada: "+e);
        }
    }
    
    public void crearTablaPeriodo(){
        String sql = "CREATE TABLE IF NOT EXISTS periodo (" +
                     "id integer PRIMARY KEY," +
                     "terminal integer," +
                     "fecha_apertura varchar," +
                     "fecha_cierre varchar,"+
                     "estado CHAR(2) DEFAULT 'AB')";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla periodo creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla periodo no creada: "+e);
        }
    }
    
    public void crearTablaTurno(){
        String sql = "CREATE TABLE IF NOT EXISTS turno (" +
                     "id integer PRIMARY KEY," +
                     "per_id integer," +
                     "terminal integer," +
                     "fecha_apertura varchar," +
                     "fecha_cierre varchar,"+
                     "estado CHAR(2) DEFAULT 'AB')";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla turno creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla turno no creada: "+e);
        }
    }
    
    public void crearTablaRetiroDinero(){
        String sql = "CREATE TABLE IF NOT EXISTS retiroDinero (" +
                     "id integer PRIMARY KEY," +
                     "per_id integer," +
                     "tur_id integer," +
                     "terminal integer," +
                     "fecha varchar," +
                     "usuario varchar,"+
                     "monto integer)";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla retiro dinero creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla retiro dinero no creada: "+e);
        }
    }
    
    public void crearTablaFolios(){
        String sql = "CREATE TABLE IF NOT EXISTS folio (" +
                     "id integer PRIMARY KEY," +
                     "documento integer," +
                     "fecha_emision date," +
                     "fecha_vencimiento date," +
                     "desde integer," +
                     "hasta integer,"+
                     "archivo varchar)";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla retiro dinero creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla retiro dinero no creada: "+e);
        }
    }
    
    public void crearTablaFoliosD(){
        String sql = "CREATE TABLE IF NOT EXISTS folioD (" +
                     "id integer PRIMARY KEY," +
                     "fol_id integer," +
                     "documento integer," +
                     "folio integer," +
                     "estado char(10) DEFAULT 'DISPONIBLE')";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla retiro dinero creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla retiro dinero no creada: "+e);
        }
    }
    
    public void crearTablaVenta(){
        String sql = "CREATE TABLE IF NOT EXISTS venta (" +
                     "id integer PRIMARY KEY," +
                     "documento integer," +
                     "folio integer," +
                     "fecha date,"+
                     "cli_id integer,"+
                     "forma_pago varchar,"+
                     "total integer)";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla retiro dinero creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla retiro dinero no creada: "+e);
        }
    }
    
    public void crearTablaVentaD(){
        String sql = "CREATE TABLE IF NOT EXISTS ventaD (" +
                     "id integer PRIMARY KEY," +
                     "ven_id integer," +
                     "pro_id integer," +
                     "cantidad double,"+
                     "precio integer,"+
                     "sub_total integer)";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla retiro dinero creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla retiro dinero no creada: "+e);
        }
    }
    
    public void crearTablaVentaReferencia(){
        String sql = "CREATE TABLE IF NOT EXISTS ventaReferencia (" +
                     "id integer PRIMARY KEY," +
                     "ven_id integer," +
                     "documento integer," +
                     "folio integer,"+
                     "tipo_anulacion integer,"+
                     "fecha date,"+
                     "observacion varchar)";
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            System.out.println("Tabla retiro dinero creada");
            //JOptionPane.showMessageDialog(null,"Cliente grabado");
        } catch (Exception e) {
            System.out.println("Tabla retiro dinero no creada: "+e);
        }
    }
    
    
    //Otras validaciones
    
    public void creaPerfiles(){
        try {
            String sql="SELECT id "+
                       "FROM perfiles";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql); 
            if (!rs.next()){
                //NO EXISTE NINGUN PERFIL, CREO UNO
                Perfiles objPer = new Perfiles(1, "Administrador de sistema");
                objPer.Grabar();
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar perfil: "+e);
        }
    }
    
    public void creaUsuarios(){
        try {
            String sql="SELECT user "+
                       "FROM usuarios";
            System.out.println(sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql); 
            if (!rs.next()){
                //NO EXISTE NINGUN USUARIO, CREO UNO
                String Enc = Encriptacion.Encriptar("admin");
                Usuarios objUsu = new Usuarios("admin", Enc, "Administrador helpcom", 1,1, "soporte@helpcom.cl");
                objUsu.Grabar();
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar perfil: "+e);
        }
    }
    
    
}
