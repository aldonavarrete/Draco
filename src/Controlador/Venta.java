
package Controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;
import java.io.IOException;
import java.util.ArrayList;


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
    
    private ArrayList<String> arrayEncabezado;
    private ArrayList<ArrayList<String>> arrayDetalle;
    private ArrayList<ArrayList<String>> arrayReferencia;
    
    public Venta() {
    }

    public Venta(int codigoDocumento, int folio, int idCliente, String formaPago, int total, DefaultTableModel tablaVenta, DefaultTableModel tablaReferencias) {
        this.codigoDocumento = codigoDocumento;
        System.out.println("folio "+folio);
        this.folio = folio;
        System.out.println("folio atri "+this.folio);
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

    public ArrayList<String> getArrayEncabezado() {
        return arrayEncabezado;
    }

    public void setArrayEncabezado(ArrayList<String> arrayEncabezado) {
        this.arrayEncabezado = arrayEncabezado;
    }

    public ArrayList<ArrayList<String>> getArrayDetalle() {
        return arrayDetalle;
    }

    public void setArrayDetalle(ArrayList<ArrayList<String>> arrayDetalle) {
        this.arrayDetalle = arrayDetalle;
    }

    public ArrayList<ArrayList<String>> getArrayReferencia() {
        return arrayReferencia;
    }

    public void setArrayReferencia(ArrayList<ArrayList<String>> arrayReferencia) {
        this.arrayReferencia = arrayReferencia;
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
    
    public void ConsultaVenta() throws IOException{
        int idVenta=0;
        arrayEncabezado = new ArrayList<>();
        arrayDetalle = new ArrayList<>();
        arrayReferencia = new ArrayList<>();
        
        Main objPar = new Main();
        objPar.parametos();
                
        arrayEncabezado.add(codigoDocumento+"");
        arrayEncabezado.add(folio+"");
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
                
                arrayEncabezado.add(rs.getString(2));//Fecha
                arrayEncabezado.add(rs.getString(4));//FmaPago
                arrayEncabezado.add(rs.getString(6));//RutReceptor
                arrayEncabezado.add(rs.getString(7));//NombreReceptor
                arrayEncabezado.add(rs.getString(11));//GiroReceptor
                arrayEncabezado.add(rs.getString(8));//DirecciònReceptor
                arrayEncabezado.add(rs.getString(10));//ComunaReceptor
                arrayEncabezado.add(rs.getString(9));//CiudadReceptor
                
                arrayEncabezado.add(objPar.getRutEmpresa());//Rut emisor
                arrayEncabezado.add(objPar.getNombreEmpresa());//Rzon social emisor
                arrayEncabezado.add(objPar.getGiroEmpresa());//giro emisor
                arrayEncabezado.add("0");//contacto emisor
                arrayEncabezado.add("0");//correo emisor
                arrayEncabezado.add(objPar.getDireccionEmpresa());//direccion emisor
                arrayEncabezado.add(objPar.getComunaEmpresa());//comuna emisor
                arrayEncabezado.add(objPar.getCiudadEmpresa());//ciudad emisor
                arrayEncabezado.add(Integer.parseInt(rs.getString(5))+"");//Monto Total
            }
            rs.close();
            
            arrayEncabezado.add("");//Vlr pagar
            arrayEncabezado.add(objPar.getActeco());//Acteco
            
            //Consulto Detalle de venta
            String nombreColumnas [] ={"PLU","Descripción","Uni.","Cantidad","Precio","SubTotal"};
            String datos [][] ={};
            tablaVenta=new DefaultTableModel(datos, nombreColumnas);
            
            sql="SELECT a.pro_id,b.nombre,b.unidad,a.cantidad,a.precio,a.sub_total,b.afecto " +
                "FROM ventaD a " +
                "INNER JOIN productos b on b.id=a.pro_id " +
                "WHERE ven_id="+idVenta;
            //System.out.println("sql: "+sql);
            rs = sentencia.executeQuery(sql);
            int linea=1;
            while (rs.next()){
                 ArrayList<String> lineas= new ArrayList<>();
                 lineas.add(linea+"");
                 lineas.add(rs.getString(1));//codigoProducto
                 lineas.add(rs.getString(1));//codigoBarra
                 lineas.add(rs.getString(2));//NombreItem
                 lineas.add(rs.getString(7));//0=exento 1=afecto
                 lineas.add(rs.getString(4));//Cantidad
                 lineas.add(rs.getString(3));//NombreUnidad
                 lineas.add(rs.getString(5));//Prec Unidad  
                 lineas.add("0"); // Porcent Descto Unid
                 lineas.add("0"); // Mnt Descto Unidad
                 lineas.add("0"); // monto imp
                 lineas.add("0"); // cod imp
                 lineas.add(rs.getString(6)); //Mnt Total
                 System.out.println("sub total "+rs.getString(6));
                 
                 arrayDetalle.add(lineas);
                 
                 String matriz[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                 tablaVenta.addRow(matriz);
                 
                 linea++;
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
            int linea_ref=1;
            while (rs.next()){
                ArrayList<String> lineas= new ArrayList<>();
                lineas.add(linea_ref+"");//NroLinRef
                lineas.add(rs.getString(1));//TpoDocRef
                lineas.add("0");//IndGlobal
                lineas.add(rs.getString(2));//FolioRef
                lineas.add("0");//RUTOtr
                lineas.add(rs.getString(3));//FchRef
                lineas.add(rs.getString(4));//CodRef
                lineas.add(rs.getString(5));//RazonRef 
                 
                 arrayReferencia.add(lineas);
                 String matriz[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                 tablaReferencias.addRow(matriz);
                 linea_ref++;
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error CreaXML: "+e);
        }
    }
    
    
}