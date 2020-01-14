
package Controlador;
import Presentacion.JFrmPassword;
import Conexion.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;


public class Main {
    private String tipoCosto="U";
    private String rutEmpresa="";
    private String direccionEmpresa="";
    private String ciudadEmpresa="";
    private String comunaEmpresa="";
    private String giroEmpresa="";
    private String nombreEmpresa="";
    private String nombreFantasiaEmpresa="";
    private int numeroTerminal=0;
    private String fechaHoy="";
    private int diasVencimientoCAF=0;
    private String acteco="";

    public String getTipoCosto() {
        return tipoCosto;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    public String getComunaEmpresa() {
        return comunaEmpresa;
    }

    public String getGiroEmpresa() {
        return giroEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombreFantasiaEmpresa() {
        return nombreFantasiaEmpresa;
    }

    public int getNumeroTerminal() {
        return numeroTerminal;
    }

    public void setNumeroTerminal(int numeroTerminal) {
        this.numeroTerminal = numeroTerminal;
    }

    public String getFecha() {
        return fechaHoy;
    }

    public void setFecha(String fechaHoy) {
        this.fechaHoy = fechaHoy;
    }

    public int getDiasVencimientoCAF() {
        return diasVencimientoCAF;
    }
    
    public String getActeco() {
        return acteco;
    }

    public void setActeco(String acteco) {
        this.acteco = acteco;
    }

    public static void main(String[] args){

        //Creo estructuras de tablas
        BaseDatos objdb = new BaseDatos();
        objdb.crearTablaClientes();
        objdb.crearTablaDepartamentos();
        objdb.crearTablaPerfiles();
        objdb.crearTablaUsuarios();
        objdb.crearTablaProveedores();
        objdb.crearTablaProductos();
        objdb.crearTablaEAN();
        objdb.crearTablaPrecios();
        objdb.crearTablaMerma();
        objdb.crearTablaMermaD();
        objdb.crearTablaKardex();
        objdb.crearTablaCompra();
        objdb.crearTablaCompraD();
        objdb.crearTablaPeriodo();
        objdb.crearTablaTurno();
        objdb.crearTablaRetiroDinero();
        objdb.crearTablaFolios();
        objdb.crearTablaFoliosD();
        objdb.crearTablaVenta();
        objdb.crearTablaVentaD();
        objdb.crearTablaVentaReferencia();
        
        //Reviso si tiene registro e inserto
        objdb.creaPerfiles();
        objdb.creaUsuarios();
        //Reviso version de mi aplicacion
        
        //Inicia con autenticacion
        JFrmPassword objPas = new JFrmPassword();
        objPas.toFront();
        objPas.setVisible(true);
        //Revisar Directorios DTE
        
        Main objDTE = new Main();
        objDTE.DirectoriosDTE();
    }
    
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    private void DirectoriosDTE(){
        File CarpetaCAF = new File(System.getProperty("user.home")+File.separator+".local"+File.separator+"caf");
        File CarpetaCertificado = new File(System.getProperty("user.home")+File.separator+".local"+File.separator+"certificado");
        File CarpetaXML = new File(System.getProperty("user.home")+File.separator+".local"+File.separator+"xml");
        //No Existe, Lo creo
        if(!CarpetaCAF.exists()){CarpetaCAF.mkdir();}
        //No Existe, Lo creo
        if(!CarpetaCertificado.exists()){CarpetaCertificado.mkdir();}
        //No Existe, Lo creo
        if(!CarpetaXML.exists()){CarpetaXML.mkdir();}
    }
    
    public void parametos() throws FileNotFoundException, IOException{
        try {
            Properties propiedades = new Properties();
            InputStream entrada = null;
            //entrada = new FileInputStream("C:\\Users\\DELL\\Desktop\\configuracionMysql.properties");
            entrada = new FileInputStream(System.getProperty("user.home")+File.separator +".local"+File.separator+"configuracionDRACO.properties");
            //System.getProperty("user.home")+File.separator +".local"+File.separator+"draco.db";
            propiedades.load(entrada);
            tipoCosto = propiedades.getProperty("TipoCosto");
            nombreEmpresa = propiedades.getProperty("Nombre");
            nombreFantasiaEmpresa = propiedades.getProperty("Nombre_Fantasia");
            rutEmpresa = propiedades.getProperty("RUT");
            direccionEmpresa = propiedades.getProperty("Direccion");
            ciudadEmpresa = propiedades.getProperty("Ciudad");
            comunaEmpresa = propiedades.getProperty("Comuna");
            giroEmpresa = propiedades.getProperty("Giro");
            numeroTerminal = Integer.parseInt(propiedades.getProperty("NumeroTerminal")); 
            diasVencimientoCAF=Integer.parseInt(propiedades.getProperty("DiasVencimientoCAF")); 
            acteco = propiedades.getProperty("Acteco");

            //Fecha de Hoy
            Calendar fecha = new GregorianCalendar();
            String elMes=""+fecha.get(Calendar.MONTH);
            int iMes=Integer.parseInt(elMes);
            iMes++;
            String dia="00"+fecha.get(Calendar.DAY_OF_MONTH);
            //String mes="00"+fecha.get(Calendar.MONTH);
            String mes="00"+iMes;
            String ano="0000"+fecha.get(Calendar.YEAR);
            System.err.println("dia:"+dia+" mes:"+mes+" año:"+ano);
            dia=dia.substring(dia.length()-2);
            mes=mes.substring(mes.length()-2);
            ano=ano.substring(ano.length()-4);
            fechaHoy = dia+"-"+mes+"-"+ano;            
        } catch (IOException e) {
            System.err.println("Error Parametos: "+e);
        }
    }    
    
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
}