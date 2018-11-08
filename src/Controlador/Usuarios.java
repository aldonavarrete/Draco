/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author aldo
 */
public class Usuarios {
    public String User;
    public String Password;
    public String Nombre;
    public int Perfil;
    public int Activo;
    public String Mail;
    
    public static boolean ExisteElUsuario;
    public static String UsuarioIniciado;

    public Usuarios() {
    }

    public Usuarios(String User, String Password, String Nombre, int Perfil, int Activo, String Mail) {
        this.User = User;
        this.Password = Password;
        this.Nombre = Nombre;
        this.Perfil = Perfil;
        this.Activo = Activo;
        this.Mail = Mail;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPerfil() {
        return Perfil;
    }

    public void setPerfil(int Perfil) {
        this.Perfil = Perfil;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }
    
    public void ExisteSoloUsuario(){
        try {
            Usuarios.ExisteElUsuario=false;
            String strSql="SELECT user,nombre,per_id "+
                          "FROM usuarios "+
                          "WHERE user='"+User+"'";
            Conexion.conectar();
            
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(strSql); 
        
            if (rs.next()){
                Usuarios.ExisteElUsuario=true;
            }
            Conexion.desconectar();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al validar usuario "+e);
        }
    }
    
    public void ExisteUsusario(){
        try {
            Usuarios.ExisteElUsuario=false;
            String strSql="SELECT user,nombre,per_id "+
                          "FROM usuarios "+
                          "WHERE user='"+User+"' AND password='"+Password+"' AND activo=1";
            Conexion.conectar();
            
            Statement sentencia = Conexion.conn.createStatement();
            ResultSet rs;
            rs = sentencia.executeQuery(strSql); 
        
            if (rs.next()){
                Usuarios.ExisteElUsuario=true;
                User=rs.getString(1);
                Nombre=rs.getString(2);  
                Perfil=Integer.parseInt(rs.getString(3));
            }
            Conexion.desconectar();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al validar usuario "+e);
        }
    }
    
    public void Grabar(){
        try {
            String strSql = "INSERT INTO usuarios (user,password,nombre,per_id,mail,activo) "+
                            "VALUES ('"+User+"','"+Password+"','"+Nombre+"',"+Perfil+",'"+Mail+"',"+Activo+")";
            Conexion.conectar();
            Statement sentencia = Conexion.conn.createStatement();
            sentencia.execute(strSql);
            Conexion.desconectar();
            JOptionPane.showMessageDialog(null,"Usuario grabado");
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Ocurrio un error mododulo grabar");
        }
    }
    
}
