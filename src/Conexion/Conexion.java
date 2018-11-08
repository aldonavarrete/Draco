package Conexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    public static String bd= System.getProperty("user.home")+File.separator +".local"+File.separator+"draco.db";
    public static String conector="jdbc:sqlite:";
    public static String url;
    public static Connection conn;
    /* Banderas */
    public static boolean ExisteNombre;

    public static void conectar(){
        try {
            url= conector+bd;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            if (conn != null){
                System.out.println("Conexión establecida");
            }
        } catch (SQLException e) {
            System.out.println("Hubo un error al conectar a "+url);
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex + "("+url+")");
        }   
    }

    public static void desconectar() throws SQLException{
        conn.close();
    }
    
    
}