package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Productos {
    
    private int id;
    private int dep_id;
    private String nombre;
    private double stock;
    private int afecto;
    private String unidad;
    private String tipo;
    private int activo;
    private String ean;
    private String departamento_nombre;
    
    //Banderas
    public static boolean ProductoNuevo;
    public static int IdProducto;
    public static boolean ProductoExiste;
    
    public Productos() {
    }

    public Productos(int id, int dep_id, String nombre, double stock, int afecto, String unidad, String tipo, int activo,String ean) {
        this.id = id;
        this.dep_id = dep_id;
        this.nombre = nombre;
        this.stock = stock;
        this.afecto = afecto;
        this.unidad = unidad;
        this.tipo = tipo;
        this.activo = activo;
        this.ean = ean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public int getAfecto() {
        return afecto;
    }

    public void setAfecto(int afecto) {
        this.afecto = afecto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getDepartamento_nombre() {
        return departamento_nombre;
    }
    
    
    
    public void Grabar(){
        try {
            String sql="INSERT INTO productos (id,dep_id,nombre,stock,afecto,unidad,tipo,activo) "+
                       "VALUES (null,"+dep_id+",'"+nombre+"',"+stock+","+afecto+",'"+unidad+"','"+tipo+"',"+activo+")";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Producto grabado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo grabar: "+e);
        }
    }
    
    public void Actualizar(){
        try {
            String sql="UPDATE productos "+
                       "SET dep_id="+dep_id+",nombre='"+nombre+"',afecto="+afecto+",unidad='"+unidad+"',tipo='"+tipo+"',activo="+activo+" "+
                       "WHERE id="+id;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Producto grabado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo grabar: "+e);
        }
    }
    
    public void ConsultaProductoId(){
        ProductoExiste=false;
        try {
            String sql="SELECT a.id,dep_id,a.nombre,stock,afecto,unidad,tipo,activo,b.nombre "+
                       "FROM productos a "+
                       "INNER JOIN departamentos b ON a.dep_id=b.id "+
                       "WHERE a.id="+id;
            System.out.println(sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                ProductoExiste=true;
                id=Integer.parseInt(rs.getString(1));
                dep_id=Integer.parseInt(rs.getString(2));
                nombre=rs.getString(3);
                stock=Double.parseDouble(rs.getString(4));
                afecto=Integer.parseInt(rs.getString(5));
                unidad=rs.getString(6);
                tipo=rs.getString(7);
                activo=Integer.parseInt(rs.getString(8));
                departamento_nombre=rs.getString(9);
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("error ConsultaProductoId: "+e);
        }
    }
    
    public void ConsultaProductoIdCodigoBarra(){
        ProductoExiste=false;
        try {
            if(id>0){
                String sql="SELECT a.id,dep_id,a.nombre,stock,afecto,unidad,tipo,activo,b.nombre "+
                           "FROM productos a "+
                           "INNER JOIN departamentos b ON a.dep_id=b.id "+
                           "WHERE a.id="+id;
                System.out.println(sql);
                Conexion.conectar();
                Statement sentencia = Conexion.conn.createStatement();
                ResultSet rs;
                rs = sentencia.executeQuery(sql);
                if (rs.next()){
                    ProductoExiste=true;
                    id=Integer.parseInt(rs.getString(1));
                    dep_id=Integer.parseInt(rs.getString(2));
                    nombre=rs.getString(3);
                    stock=Double.parseDouble(rs.getString(4));
                    afecto=Integer.parseInt(rs.getString(5));
                    unidad=rs.getString(6);
                    tipo=rs.getString(7);
                    activo=Integer.parseInt(rs.getString(8));
                    departamento_nombre=rs.getString(9);
                }
            }else{
                //BUSCO AHORA POR CODIGO DE BARRA
                String sql="SELECT a.id,dep_id,a.nombre,stock,afecto,unidad,tipo,activo,b.nombre " +
                           "FROM productos a " +
                           "INNER JOIN departamentos b ON a.dep_id=b.id " +
                           "INNER JOIN ean c ON a.id=c.pro_id " +
                           "WHERE c.ean='"+ean+"'";
                System.out.println(sql);
                Conexion.conectar();
                Statement sentencia = Conexion.conn.createStatement();
                ResultSet rs;
                rs = sentencia.executeQuery(sql);
                if (rs.next()){
                    ProductoExiste=true;
                    id=Integer.parseInt(rs.getString(1));
                    dep_id=Integer.parseInt(rs.getString(2));
                    nombre=rs.getString(3);
                    stock=Double.parseDouble(rs.getString(4));
                    afecto=Integer.parseInt(rs.getString(5));
                    unidad=rs.getString(6);
                    tipo=rs.getString(7);
                    activo=Integer.parseInt(rs.getString(8));
                    departamento_nombre=rs.getString(9);
                }
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("error ConsultaProductoIdCodigoBarra: "+e);
        }
    }
    
    public void ConsultaProductoCodigoBarra(){
        ProductoExiste=false;
        try {
            String sql="SELECT a.id,nombre,afecto,unidad,tipo,stock " +
                       "FROM productos a " +
                       "INNER JOIN ean b ON a.id=b.pro_id " +
                       "WHERE b.ean='"+ean+"' AND a.activo=1";
            System.out.println("sql: "+sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                ProductoExiste=true;
                id=Integer.parseInt(rs.getString(1));
                nombre=rs.getString(2);
                afecto=Integer.parseInt(rs.getString(3));
                unidad=rs.getString(4);
                tipo=rs.getString(5);
                stock=Double.parseDouble(rs.getString(6));
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("error ConsultaProductoCodigoBarra: "+e);
        }
    }
    
    public void ConsultaProductoNombre(){
        ProductoExiste=false;
        try {
            String sql="SELECT id "+
                       "FROM productos "+
                       "WHERE nombre='"+nombre+"'";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                ProductoExiste=true;
            }
            Conexion.desconectar();
        } catch (Exception e) {
        }
    }
    
    
    public DefaultTableModel  BuscaProducto(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String Condicion="";
            if (id!=0) {Condicion+="a.id="+id+" AND ";}
            if (!nombre.isEmpty()) {Condicion+="a.nombre like '%"+nombre+"%' AND ";}
            if (dep_id!=0) {Condicion+="a.dep_id="+dep_id+" AND ";}
            if (!ean.isEmpty()) {Condicion+="c.ean="+ean+" AND ";}
            Condicion+="a.activo="+activo;
            
            String sql="SELECT a.id,a.nombre,b.nombre as departamento,stock,unidad,tipo "+
                       "FROM productos a "+
                       "INNER JOIN departamentos b ON a.dep_id=b.id "+
                       "LEFT JOIN ean c ON a.id=c.pro_id "+
                       "WHERE "+Condicion+" "+
                       "GROUP BY a.id";
            System.out.println(sql);
            Conexion.conectar();
            Statement s = Conexion.conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery(sql); 
            ResultSetMetaData rsmd = rs.getMetaData();
            int CanColumns = 6;
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
                          "FROM departamentos "+
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
    
    private boolean MovimientoProducto(){
        boolean TieneMovimiento=false;
        
        return TieneMovimiento;
    }
    
    public String [][] Ayuda(){
        String [][] tabla = new String [20][2];
        try {
            String sql="SELECT id,nombre "+
                       "FROM productos "+
                       "WHERE nombre LIKE '%"+nombre+"%' AND activo=1";
            System.err.println(sql);
            
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet objRes = sentencia.executeQuery(sql);
            int i=0;
            while (objRes.next()){
                tabla[i][0] = objRes.getString(1);
                tabla[i][1] = objRes.getString(2);
                i++;
            }
            Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en modulo Ayuda: "+e);
        }
        return tabla;
    }
}

