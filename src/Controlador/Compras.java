
package Controlador;

import Conexion.Conexion;
import static Controlador.Clientes.ExisteRUTCliente;
import java.sql.ResultSet;
import java.sql.Statement;

public class Compras {
    private String documento;
    private int folio;
    private int proveedor;

    public Compras() {
    }

    public Compras(String documento, int folio, int proveedor) {
        this.documento = documento;
        this.folio = folio;
        this.proveedor = proveedor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
    
    public String EstadoCompra(){
        //NE = No existe
        //EC = Existe Cerrado
        //EA = Existe Abierto
        //EE = Error
        String estado="EE";
        try {
            String sql="SELECT de_alta "+
                       "FROM compra "+
                       "WHERE documento='"+documento+"' and folio="+folio+" and prv_id="+proveedor;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                int tipo=Integer.parseInt(rs.getString(1));
                if(tipo==0){estado="EA";}
                if(tipo==1){estado="EC";}
            }else{
                estado="NE";
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error ExisteCompra: "+e);
        }
        return estado;
    }
    
    
}
