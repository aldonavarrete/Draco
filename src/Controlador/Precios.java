
package Controlador;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Precios {
    private int plu;
    private int venta;
    private double ultimo_costo;
    private double costo_pp;
    private double cantidad_comprada;
    //% Margen sobre compras
    private double mcsc_cpp;
    private double mcsc_uc;
    //% Margen sobre ventas
    private double mcsv_cpp;
    private double mcsv_uc;

    public Precios() {
    }

    public Precios(int plu, int venta, double ultimo_costo, double costo_pp, double cantidad_comprada) {
        this.plu = plu;
        this.venta = venta;
        this.ultimo_costo = ultimo_costo;
        this.costo_pp = costo_pp;
        this.cantidad_comprada = cantidad_comprada;
    }

    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public double getUltimo_costo() {
        return ultimo_costo;
    }

    public void setUltimo_costo(double ultimo_costo) {
        this.ultimo_costo = ultimo_costo;
    }

    public double getCosto_pp() {
        return costo_pp;
    }

    public void setCosto_pp(double costo_pp) {
        this.costo_pp = costo_pp;
    }

    public double getCantidad_comprada() {
        return cantidad_comprada;
    }

    public void setCantidad_comprada(double cantidad_comprada) {
        this.cantidad_comprada = cantidad_comprada;
    }

    public double getMcsc_cpp() {
        return mcsc_cpp;
    }

    public double getMcsc_uc() {
        return mcsc_uc;
    }

    public double getMcsv_cpp() {
        return mcsv_cpp;
    }

    public double getMcsv_uc() {
        return mcsv_uc;
    }
    
    public void DamePrecios_Margenes(){
        String sql="SELECT venta,ultimo_costo,costo_pp "+
                   "FROM precios "+
                   "WHERE pro_id="+plu;
        try {
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            venta=0;
            ultimo_costo=0;  
            costo_pp=0;  
            mcsc_cpp=0;
            mcsv_cpp=0;
            mcsc_uc=0;
            mcsv_uc=0;
            if (rs.next()){
                venta=Integer.parseInt(rs.getString(1));
                ultimo_costo= Double.parseDouble(rs.getString(2));  
                costo_pp=Double.parseDouble(rs.getString(3));
                //Calculos de Margen Comercial
                double utilidad_cpp=venta-costo_pp;
                double utilidad_uc=venta-ultimo_costo;
                //Calculando Margen Comercial Sobre la venta (Costo Promedio Ponderado)/(Ultimo Costo)
                if(venta>0){
                    mcsv_cpp=((utilidad_cpp)/venta)*100;
                    mcsv_uc=((utilidad_uc)/venta)*100;
                }
                //Calculando Margen Comercial Sobre la compra (Costo Promedio Ponderado)/(Ultimo Costo)
                if(ultimo_costo>0){
                    mcsc_uc=((utilidad_uc)/ultimo_costo)*100;
                }
                if(costo_pp>0){
                    mcsc_cpp=((utilidad_cpp)/costo_pp)*100;
                }
            }    
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error DamePrecios:"+e);
        }
    }
    
    public void ActualizaCostos(){
        try {
            //Consulto Stock
            Productos objPro = new Productos(plu,0, "", 0, 0,"", "", 0,"");
            objPro.ConsultaProductoId();
            double stock = objPro.getStock();
            //Consulto ultimo costo
            DamePrecios_Margenes();
            //Calculo el costo promedio ponderado
            double nuevo_cpp =0;
            if((stock+cantidad_comprada)!=0){
                nuevo_cpp = ((stock*costo_pp)+(ultimo_costo*cantidad_comprada))/(stock+cantidad_comprada);
            }
            //Actualizo los costos
            String sql="UPDATE precios "+
                       "SET ultimo_costo="+ultimo_costo+",costo_pp="+nuevo_cpp+" "+
                       "WHERE pro_id="+plu;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error ActualizaCostos:"+e);
        }
    }
    
    public void ActualizaPrecio(){
        try {
            InsertaRegistroSiNoExiste();
            
            String sql="UPDATE precios "+
                       "SET venta="+venta+" "+
                       "WHERE pro_id="+plu;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error ActualizaPrecio:"+e);
        }
    }
    
    private void InsertaRegistroSiNoExiste(){
        try {
            String sql="SELECT pro_id "+
                       "FROM precios "+
                       "WHERE pro_id="+plu;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (!rs.next()){
                sql="INSERT INTO precios (pro_id,venta,ultimo_costo,costo_pp) "+
                    "VALUES ("+plu+",0,0,0)";
                sentencia.execute(sql);
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("error InsertaRegistroSiNoExiste: "+e);
        }
    }
}