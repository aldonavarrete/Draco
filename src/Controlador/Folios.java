
package Controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import Conexion.Conexion;

public class Folios {
    private int documento;
    private int folio;
    
    private String FechaEmision;
    private int desde;
    private int hasta;
    private String archivo;

    public Folios() {
    }

    public Folios(int documento, int folio, String FechaEmision, int desde, int hasta, String archivo) {
        this.documento = documento;
        this.folio = folio;
        this.FechaEmision = FechaEmision;
        this.desde = desde;
        this.hasta = hasta;
        this.archivo = archivo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(String FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    public boolean ExisteFolio(){
        boolean ocupado=false;
        try {
            String sql="SELECT id "+
                       "FROM folioD "+
                       "WHERE documento="+documento+" AND folio="+folio;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                ocupado=true;
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error ExisteFolio: "+e);
        }
        return ocupado;
    }
    
    public void DameUnFolio(){
        try {
            String sql="SELECT folio " +
                       "FROM folio a " +
                       "INNER JOIN folioD b ON a.id=b.fol_id " +
                       "WHERE a.documento="+documento+" AND estado='DISPONIBLE' AND date()<fecha_vencimiento " +
                       "ORDER BY folio " +
                       "LIMIT 1";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                folio=Integer.parseInt(rs.getString(1));
            }
            Conexion.desconectar();
            
        } catch (Exception e) {
            System.err.println("Error DameUnFolio: "+e);
        }
    }
    
    public void AgregarFolios(){
        
        try {
            //Cargo parametros de vencimiento de folios
            Main objM = new Main();
            objM.parametos();
            int diasVencimiento = objM.getDiasVencimientoCAF();
            
            //Primero inserto tabla Folios
            String sql="INSERT INTO folio (id,documento,fecha_emision,fecha_vencimiento,desde,hasta,archivo) " +
                       "VALUES (NULL,"+documento+",'"+FechaEmision+"',(date('"+FechaEmision+"','+"+diasVencimiento+" day')),"+desde+","+hasta+",'"+archivo+"');";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            System.out.println(sql);
            sentencia.execute(sql);
            //Consulto Autoincremento
            int idFolio=0;
            sql="SELECT MAX(rowid) as autoincremento " + "FROM folio;";
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            sentencia.clearWarnings();
            
            if (rs.next()){
                idFolio=Integer.parseInt(rs.getString(1));                
            }
            rs.close();// <-- faltaba esto
            
            //Preparo SQL Detalle
            sql="INSERT INTO folioD (id,fol_id,documento,folio,estado) VALUES ";
            for(int i=desde;i<=hasta;i++){
                sql+="(NULL,"+idFolio+","+documento+","+i+",'DISPONIBLE'),";
            }
            sql=sql.substring(0, (sql.length()-1));
            sentencia.execute(sql);
            
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error AgregarFolios: "+e);
        }
    }
    
    public void FolioUsado(){
        try {
            String sql="UPDATE folioD " +
                       "SET estado='USADO' " +
                       "WHERE documento="+documento+" AND folio="+folio;
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            System.out.println(sql);
            sentencia.execute(sql);
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error FolioUsado: "+e);
        }
    }
}
