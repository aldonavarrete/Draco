package Controlador;

import cl.helpcom.dte.method.CreaDTEv4;
import cl.nic.dte.net.ConexionSiiException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Clock;
import java.util.HashMap;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.xml.sax.SAXException;
import sun.font.CreatedFontTracker;

public class XML {
    private int codigoDocumento;
    private int folio;
    private String archivo;
    
    public XML() {
    }

    public XML(int codigoDocumento, int folio,String archivo) {
        this.codigoDocumento = codigoDocumento;
        this.folio = folio;
        this.archivo = archivo;
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
    
    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    public void CreaXML() throws XmlException, IOException, ParseException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, SQLException, UnrecoverableKeyException, ClassNotFoundException, NumberFormatException, CertificateException, KeyStoreException, InvalidAlgorithmParameterException, KeyException, UnsupportedOperationException, MarshalException, XMLSignatureException, SAXException, ParserConfigurationException, SOAPException, ConexionSiiException{
        //Consulto Venta
        Venta objVen = new Venta(codigoDocumento, folio, 0, "", 0, null, null);
        objVen.ConsultaVenta();
        CreaDTEv4 crea=new CreaDTEv4(objVen.getArrayDetalle(), objVen.getArrayReferencia(), objVen.getArrayEncabezado(),archivo);
        crea.crearDTE();
        System.out.println(objVen.getTotal());
    }
}
