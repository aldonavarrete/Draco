
package Controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import Conexion.Conexion;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ean {
    private int pro_id;
    private String ean;
    
    public Ean() {
    }

    public Ean(int pro_id, String ean) {
        this.pro_id = pro_id;
        this.ean = ean;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
    
    public void Grabar(){
        try {
            String sql="INSERT INTO ean (pro_id,ean) "+
                       "VALUES ("+pro_id+",'"+ean+"')";
            System.err.println(sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Ean grabado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error modulo Grabar->Ean: "+ e);
        }
    }
    
    public void Eliminar(){
        try {
            String sql="DELETE "+
                       "FROM ean "+
                       "WHERE ean='"+ean+"'";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Ean eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error modulo Eliminar->Ean: "+ e);
        }
    }
    
    public int ExisteEan(){
        int n =0;
        try {
            String sql="SELECT pro_id,ean "+
                       "FROM ean "+
                       "WHERE ean='"+ean+"'";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql); 
            if (rs.next()){
                n=1;
                pro_id=Integer.parseInt(rs.getString(1));
                ean=rs.getString(2);
            }
            Conexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error modulo ExisteEan->Ean: "+ e);
        }
        return n;
    }
    
    public DefaultTableModel Buscar(){
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String sql="SELECT pro_id as Plu,ean as Ean "+
                       "FROM ean "+
                       "WHERE pro_id="+pro_id;
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
            JOptionPane.showMessageDialog(null, "Error en el modulo Buscar->Ean: "+e);
        }
        return modelo;
    }
}