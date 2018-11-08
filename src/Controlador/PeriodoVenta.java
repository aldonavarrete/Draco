
package Controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import Conexion.Conexion;

public class PeriodoVenta {
    
    private int periodo;
    private int turno;
    private int terminal;
    private String fechaApertura;
    private String fechaCierre;
    private String estado;

    public PeriodoVenta() {
    }

    public PeriodoVenta(int periodo, int turno, int terminal, String fechaApertura, String fechaCierre, String estado) {
        this.periodo = periodo;
        this.turno = turno;
        this.terminal = terminal;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }
    
    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void ConsultaPeriodo(){
        periodo=0;
        try {
            String sql="SELECT id " +
                       "FROM periodo " +
                       "WHERE terminal="+terminal+" AND estado='AB'";
            Conexion.conectar();
            System.out.println(sql);
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(sql);
            if (rs.next()){
                periodo=Integer.parseInt(rs.getString(1));
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error ConcultaPeriodo: "+e);
        }
    }
    
    public void ConsultaTurno(){
        turno=0;
        try {
            ConsultaPeriodo();
            if(periodo!=0){
                String sql="SELECT id " +
                           "FROM turno " +
                           "WHERE terminal="+terminal+" AND per_id="+periodo+" AND estado='AB'";
                Conexion.conectar();
                Statement sentencia = Conexion.conn.createStatement();
                ResultSet rs;
                rs = sentencia.executeQuery(sql);
                if (rs.next()){
                    turno=Integer.parseInt(rs.getString(1));
                }
                Conexion.desconectar();
                
            }
        } catch (Exception e) {
            System.err.println("Error ConsultaTurno: "+e);
        }
    }
    
    public void GrabaPeriodo(){
        try {
            String sql="INSERT INTO periodo (id,terminal,fecha_apertura,fecha_cierre,estado) " +
                       "VALUES (null,"+terminal+",'"+fechaApertura+"','"+fechaCierre+"','AB')";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error GrabaPeriodo: "+e);
        }
        
    }
    
    public void GrabaTurno(){
        ConsultaPeriodo();
        try {
            if(periodo!=0){
                String sql="INSERT INTO turno (id,per_id,terminal,fecha_apertura,fecha_cierre,estado) " +
                           "VALUES (null,"+periodo+","+terminal+",'"+fechaApertura+"','','AB')";
                Conexion.conectar();
                Statement sentencia = Conexion.conn.createStatement();
                sentencia.execute(sql);
                Conexion.desconectar();
            }else{
                turno=0;
            }
        } catch (Exception e) {
            System.err.println("Error GrabaTurno: "+e);
        }
        
    }
}
