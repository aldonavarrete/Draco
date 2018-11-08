package Controlador;

import java.sql.Statement;
import Conexion.Conexion;

public class Stock {
    private int plu;
    private double cantidad;
    private String tipo;   //E=Entrada S=Salida
    private String documento;
    private int numero;
    private double costo;

    public Stock() {
    }

    public Stock(int plu, double cantidad, String tipo, String documento, int numero, double costo) {
        this.plu = plu;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.documento = documento;
        this.numero = numero;
        this.costo = costo;
    }

    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public void Stock(){
        try {
            Productos objPro = new Productos( plu,0, "",0, 0,"","", 0, "");
            objPro.ConsultaProductoId();
            double stock_antes=objPro.getStock();
            
            String signo="+";
            if("E".equals(tipo)){signo="+";}
            if("S".equals(tipo)){signo="-";}
            
            String sql="UPDATE productos "+
                       "SET stock=stock"+signo+cantidad+" "+
                       "WHERE id="+plu;
            System.out.println(sql);
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            
            objPro.ConsultaProductoId();
            double stock_nuevo=objPro.getStock();
            //Grabo Kardex
            sql="INSERT INTO kardex (id,documento,numero,tipo,fecha_movimiento,pro_id,cantidad,saldo_anterior,saldo_actual,costo) "+
                "VALUES (null,'"+documento+"',"+numero+",'"+tipo+"',Date(),"+plu+","+cantidad+","+stock_antes+","+stock_nuevo+","+costo+")";
            sentencia.execute(sql);
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error Stock: "+e);
        }
    }
    
}
