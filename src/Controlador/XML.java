package Controlador;

import cl.helpcom.AgregarCamposDTE;
import cl.helpcom.PropiedadesCreaDTE;
import cl.helpcom.Timbre;
import cl.sii.siiDte.DTEDocument;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;

public class XML {
    private int codigoDocumento;
    private int folio;
    
    public XML() {
    }

    public XML(int codigoDocumento, int folio) {
        this.codigoDocumento = codigoDocumento;
        this.folio = folio;
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
    
    public void CreaXML() throws XmlException, IOException{
        //Consulto Venta
        Venta objVen = new Venta(codigoDocumento, folio, 0, "", 0, null, null);
        objVen.ConsultaVenta();
        
        
        PropiedadesCreaDTE prop=new PropiedadesCreaDTE();
        
        AgregarCamposDTE addCampos = new AgregarCamposDTE();
        
        DTEDocument doc;
        doc = DTEDocument.Factory.newInstance();
	doc.addNewDTE();
	doc.getDTE().setVersion(new BigDecimal("1.0"));
	doc.getDTE().addNewDocumento();
	doc.getDTE().getDocumento().addNewEncabezado();

	/** Agregar EMISOR **/
	doc.getDTE().getDocumento().getEncabezado().setEmisor(addCampos.addEmisor(arrayEncabezado));
	/** Agregar IDDOC **/
	addCampos.addIdDoc(doc, arrayEncabezado);
	/** Agregar RECEPTOR **/
	addCampos.addReceptor(doc, arrayEncabezado);
	/** Agregar TOTALES **/
	addCampos.addTotales(doc, arrayEncabezado);
        
        /** Agregar DTE 33,34,52 **/
		if (Double.valueOf(arrayEncabezado.get(0)) == 33 || Double.valueOf(arrayEncabezado.get(0)) == 34 || Double.valueOf(arrayEncabezado.get(0)) == 52) {
			doc.getDTE().getDocumento().setDetalleArray(addCampos.addDTE33(doc, arrayEncabezado,arrayDetalle)); // Agrega Detalles
			doc.getDTE().getDocumento().setDscRcgGlobalArray(addCampos.addDscRecGlobal(arrayDescRecGlob));// Agrega
			doc.getDTE().getDocumento().setReferenciaArray(addCampos.addReferencia(arrayReferencia));// Agrega
		}/** Agregar DTE 61 **/
		else if (Double.valueOf(arrayEncabezado.get(0)) == 61) {
			doc.getDTE().getDocumento().setDetalleArray(addCampos.addDTE61(arrayEncabezado, arrayDetalle)); // Agrega
			doc.getDTE().getDocumento().setDscRcgGlobalArray(addCampos.addDscRecGlobal(arrayDescRecGlob));// Agrega
			doc.getDTE().getDocumento().setReferenciaArray(addCampos.addReferencia(arrayReferencia));// Agrega
		}/** Agregar DTE 56 **/
		else if (Double.valueOf(arrayEncabezado.get(0)) == 56) {
			doc.getDTE().getDocumento().setDetalleArray(addCampos.addDTE56(arrayEncabezado, arrayDetalle)); // Agrega																				// Detalles
			doc.getDTE().getDocumento().setDscRcgGlobalArray(addCampos.addDscRecGlobal(arrayDescRecGlob));// Agrega
			doc.getDTE().getDocumento().setReferenciaArray(addCampos.addReferencia(arrayReferencia));// Agrega
		}
		// Leo la autorizacion y timbro
		// Debo meter el namespace porque SII no lo genera
		
                HashMap<String, String> namespaces = new HashMap<String, String>();
		namespaces.put("", "http://www.sii.cl/SiiDte");
		XmlOptions opts = new XmlOptions();
		opts.setLoadSubstituteNamespaces(namespaces);

		opts = new XmlOptions();
		opts.setSaveImplicitNamespaces(namespaces);
		opts.setLoadSubstituteNamespaces(namespaces);
		opts.setSavePrettyPrint();
		opts.setSavePrettyPrintIndent(0);

		doc = DTEDocument.Factory.parse(doc.newInputStream(opts), opts);

		opts = new XmlOptions();
		opts.setCharacterEncoding("ISO-8859-1");
		opts.setSaveImplicitNamespaces(namespaces);

		try {
			// CARPETA AUXILIAR DTE XML SIN TIMBRE
                        //arrayEncabezado.get(0)=TIPO DOC
                        //arrayEncabezado.get(1)=FOLIO
			doc.save(new File(resultS + "/sinTimbrar/" + arrayEncabezado.get(0) + arrayEncabezado.get(1) + ".xml"), opts);
		} catch (Exception e) {
			System.err.print("Ha surgido un error al Guardar el documento DTE \nNo se ha guardado el documento");
		}
		/**Validar DTE antes de enviar a Helpcom**/
	
		Timbre tim = new Timbre();
		tim.timbrarDTE(prop,Integer.valueOf(arrayEncabezado.get(0)),Long.valueOf(arrayEncabezado.get(1)), arrayEncabezado,arrayDetalle, arrayReferencia, arrayDescRecGlob, nombreDocPlano);
		// Borra fichero temporal		
		
		//ficheroBase.borrarTemporal(prop.getRutatemporal());
            
            
        

        
    }
    
    

}
