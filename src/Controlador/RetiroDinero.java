
package Controlador;

import java.sql.Statement;
import Conexion.Conexion;
        

public class RetiroDinero {
    
    private int numeroPeriodo;
    private int numeroTurno;
    private int monto;
    private int numeroTerminal;

    public RetiroDinero() {
    }

    public RetiroDinero(int numeroPeriodo, int numeroTurno, int monto, int numeroTerminal) {
        this.numeroPeriodo = numeroPeriodo;
        this.numeroTurno = numeroTurno;
        this.monto = monto;
        this.numeroTerminal = numeroTerminal;

    }

    public int getNumeroPeriodo() {
        return numeroPeriodo;
    }

    public void setNumeroPeriodo(int numeroPeriodo) {
        this.numeroPeriodo = numeroPeriodo;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getNumeroTerminal() {
        return numeroTerminal;
    }

    public void setNumeroTerminal(int numeroTerminal) {
        this.numeroTerminal = numeroTerminal;
    }

    public void GrabaRetiro(){
        try {
            String sql="INSERT INTO retiroDinero (id,per_id,tur_id,terminal,fecha,usuario,monto) "+
                       "VALUES (null,"+numeroPeriodo+","+numeroTurno+","+numeroTerminal+",Date(),'"+Usuarios.UsuarioIniciado+"',"+monto+")";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(sql);
            Conexion.desconectar();
        } catch (Exception e) {
            System.err.println("Error GrabaRetiro: "+e);
        }
    }
    
}
