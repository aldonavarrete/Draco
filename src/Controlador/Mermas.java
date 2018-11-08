
package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mermas {
    private int numero;
    private String fecha;
    private String usuario;
    private String observacion;
    private DefaultTableModel tabla;

    public Mermas() {
    }

    public Mermas(int numero, String fecha, String usuario, String observacion, DefaultTableModel tabla) {
        this.numero = numero;
        this.fecha = fecha;
        this.usuario = usuario;
        this.observacion = observacion;
        this.tabla = tabla;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }
    
    public void Grabar(){
        try {
            String sql="INSERT INTO merma (id,fecha,observacion,user) "+
                       "VALUES (null,Date(),'"+observacion+"','"+usuario+"')";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            
            //Consulto el autoincremento
            int Autoincremento=0;
            sql="SELECT max(rowid) FROM merma";
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            while (rs.next()){
                Autoincremento=Integer.parseInt(rs.getString(1));
            }
            
            //sql="INSERT INTO mermaD (id,mer_id,pro_id,cantidad,costo) VALUES ";
            
            if(tabla.getRowCount()>0){
                for(int i=0;i<tabla.getRowCount();i++){
                    int plu=Integer.parseInt(tabla.getValueAt(i, 0).toString());
                    double costo=Double.parseDouble(tabla.getValueAt(i, 3).toString());
                    double cantidad=Double.parseDouble(tabla.getValueAt(i, 4).toString());
                    String sqlD="INSERT INTO mermaD (id,mer_id,pro_id,cantidad,costo) VALUES "+
                                "(null,"+Autoincremento+",+"+plu+","+cantidad+","+costo+")";
                    sentencia.execute(sqlD);
                    
                    //Actulizo Stock y Kardex
                    Stock objSto = new Stock(plu, cantidad, "S", "Merma",Autoincremento,costo);
                    objSto.Stock();
                    //sql+="(null,"+Autoincremento+","+plu+","+cantidad+","+costo+"),";
                }
            }
            //sql = sql.substring(0, sql.length()-1);
            // System.out.println(sql);
            //sentencia.execute(sql);
            Conexion.desconectar();
            
        } catch (SQLException | NumberFormatException e) {
            System.err.println("Error Grabar: "+e);
        }
    }
    public void Consultar(){
        
    }
}
