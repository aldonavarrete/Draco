
package Controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;


public class Venta {
    public static int totalventa;
    private int codigoDocumento;
    private int folio;
    private int idCliente;
    private String formaPago;
    private int total;
    private String fecha;
    private DefaultTableModel tablaVenta;
    private DefaultTableModel tablaReferencias;

    private String rutCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String ciudadCliente;
    private String comunaCliente;
    private String giroCliente;
    
    public Venta() {
    }

    public Venta(int codigoDocumento, int folio, int idCliente, String formaPago, int total, DefaultTableModel tablaVenta, DefaultTableModel tablaReferencias) {
        this.codigoDocumento = codigoDocumento;
        this.folio = folio;
        this.idCliente = idCliente;
        this.formaPago = formaPago;
        this.total = total;
        this.tablaVenta = tablaVenta;
        this.tablaReferencias = tablaReferencias;
    }

    public int getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(int codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public DefaultTableModel getTablaVenta() {
        return tablaVenta;
    }

    public void setTablaVenta(DefaultTableModel tablaVenta) {
        this.tablaVenta = tablaVenta;
    }

    public DefaultTableModel getTablaReferencias() {
        return tablaReferencias;
    }

    public void setTablaReferencias(DefaultTableModel tablaReferencias) {
        this.tablaReferencias = tablaReferencias;
    }

    public String getFecha() {
        return fecha;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public String getComunaCliente() {
        return comunaCliente;
    }

    public String getGiroCliente() {
        return giroCliente;
    }
    
    public void GrabaVenta(){
        //Grabo Venta
        int idVenta=0;
        DefaultTableModel tReferencia;
        String sql;
        
        try {
            sql="INSERT INTO venta (id,documento,folio,fecha,cli_id,forma_pago,total) "+
                "VALUES (NULL,"+codigoDocumento+","+folio+",date(),"+idCliente+",'"+formaPago+"',"+total+")";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            //Consulto Autoincremento para grabar en detalle
            sql="SELECT MAX(rowid) "+ 
                "FROM venta";
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                idVenta=Integer.parseInt(rs.getString(1));                
            }
            rs.close();
            //Si tipo es Nota de Credito es Entrada de Stock
            String tipo="S";
            if(codigoDocumento==61){tipo="E";} 
            //Grabo detalle de venta
            sql="INSERT INTO ventaD (id,ven_id,pro_id,cantidad,precio,sub_total) VALUES ";
            for(int i=0;i<tablaVenta.getRowCount();i++){
                sql+="(NULL,"+idVenta+","+tablaVenta.getValueAt(i, 1)+","+tablaVenta.getValueAt(i, 4)+","+
                     tablaVenta.getValueAt(i, 5)+","+tablaVenta.getValueAt(i, 6)+"),";
                //Stock
                Stock objSto = new Stock(Integer.parseInt(tablaVenta.getValueAt(i, 1).toString()), Double.parseDouble(tablaVenta.getValueAt(i, 4).toString()), tipo, ""+codigoDocumento, folio, Double.parseDouble(tablaVenta.getValueAt(i, 5).toString()));
                objSto.Stock();
            }
            sql=sql.substring(0, (sql.length()-1));
            sentencia.execute(sql);
            
            //Grabo referencia
            boolean tieneDatos = false;
            sql="INSERT INTO ventaReferencia (id,ven_id,documento,folio,tipo_anulacion,fecha,observacion) VALUES ";
            for(int j=0;j<tablaReferencias.getRowCount();j++){
                sql+="(NULL,"+idVenta+","+Integer.parseInt(tablaReferencias.getValueAt(j, 0).toString())+","+
                     Integer.parseInt(tablaReferencias.getValueAt(j, 1).toString())+","+
                     Integer.parseInt(tablaReferencias.getValueAt(j, 3).toString())+",'"+
                     tablaReferencias.getValueAt(j, 2).toString()+"','"+tablaReferencias.getValueAt(j, 4).toString()+"'),";
                //System.out.println("Referencia "+j+"-0"+tablaReferencias.getValueAt(j, 0));
                //System.out.println("Referencia "+j+"-1"+tablaReferencias.getValueAt(j, 1));
                tieneDatos=true;
            }
            if(tieneDatos){
                sql=sql.substring(0, (sql.length()-1));
                sentencia.execute(sql);
            }
            Conexion.desconectar();
            
        } catch (Exception e) {
            System.out.println("Error GrabaVenta/Venta: "+e);
            //System.out.println(e.getStackTrace());
        }       
    }   
    
    public void ConsultaVenta(){
        int idVenta=0;
        String sql="SELECT a.id,fecha,cli_id,forma_pago,total,rut,nombre,direccion,ciudad,comuna,giro "+
                   "FROM venta a "+
                   "LEFT JOIN clientes b ON b.id=a.cli_id "+
                   "WHERE a.documento="+codigoDocumento+" AND a.folio="+folio;
        try {
            //System.out.println("sql: "+sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){    
                idVenta=Integer.parseInt(rs.getString(1));
                fecha=rs.getString(2);
                idCliente=Integer.parseInt(rs.getString(3));
                formaPago=rs.getString(4);
                total=Integer.parseInt(rs.getString(5));
                rutCliente=rs.getString(6);
                nombreCliente=rs.getString(7);
                direccionCliente=rs.getString(8);
                ciudadCliente=rs.getString(9);
                comunaCliente=rs.getString(10);
                giroCliente=rs.getString(11);
            }
            rs.close();
            
            //Consulto Detalle de venta
            String nombreColumnas [] ={"PLU","Descripción","Uni.","Cantidad","Precio","SubTotal"};
            String datos [][] ={};
            tablaVenta=new DefaultTableModel(datos, nombreColumnas);
            
            sql="SELECT a.pro_id,nombre,unidad,cantidad,precio,sub_total " +
                "FROM ventaD a " +
                "INNER JOIN productos b on b.id=a.pro_id " +
                "WHERE ven_id="+idVenta;
            //System.out.println("sql: "+sql);
            rs = sentencia.executeQuery(sql);
            while (rs.next()){
                 String matriz[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                 tablaVenta.addRow(matriz);
            }
            rs.close();
            
            //Consulto documentos Referenciados
            String nombreColumnasR [] ={"Doc","Folio","Fecha","Cod","Observación"};
            String datosR [][] ={};
            tablaReferencias=new DefaultTableModel(datosR, nombreColumnasR);
            sql="SELECT documento,folio,fecha,tipo_anulacion,observacion " +
                "FROM ventaReferencia " +
                "WHERE ven_id="+idVenta;
            System.out.println("sql: "+sql);
            rs = sentencia.executeQuery(sql);
            while (rs.next()){
                 String matriz[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                 tablaReferencias.addRow(matriz);
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error CreaXML: "+e);
        }
    }
    
    
}