package cl.helpcom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropiedadesCreaDTE {
	
/*
 * #Usados en CreaFacturaSinCert
RUTA_BASE = /home/mau/Documentos/DTE/Abaco/BASE/
RUTA_BASE_RESPALDO = /home/mau/Documentos/DTE/Abaco/BASERespaldo
RUTA_TEMPORAL = /home/mau/Documentos/DTE/Abaco/Autorizacion/tmp.txt
RUTA_RESULTADO_DTE = /home/mau/Documentos/DTE/Abaco/documentosDTE
RUTA_CAF = /home/mau/Documentos/DTE/Abaco/Autorizacion/
RUTA_RESULTADO_PDF = /home/mau/Documentos/DTE/Abaco/documentosPDF/
RUTA_RESULTADO_PDF_CEDIBLE = /home/mau/Documentos/DTE/Abaco/documentosPDF/CEDIBLE/
RUTA_TEMPLATE_PDF = /home/mau/Documentos/DTE/Abaco/documentosPDF/
TIPO_IMPRESORA=2

EMPRESA_ID=11
FCH_RESOLUCION=2015-08-07
NRO_RESOLUCION=0*/
	
	private InputStream entrada = null;
	private Properties propiedades = new Properties();
	
	private String rutaBase;
	private String rutaBaseRespaldo;
	private String rutatemporal;
	private String rutaResultadoDTE;
	private String rutaCAF;
	private String rutaResultadoPDF;
	private String rutaResultadoPDFCedible;
	private String rutaTemplatePDF;
	private String img417;
	private String rutaError;
	private Integer tipoImpresora;
	
	private Integer empresaID;
	private String fechaResolucion;
	private Integer numeroResolucion;
	
	public PropiedadesCreaDTE() throws IOException {
		
		entrada = new FileInputStream("/usr/local/F_E/Configuraciones/Propiedades/configuracionCreaDTE.properties");
        // cargamos el archivo de propiedades
        propiedades.load(entrada);

		this.rutaBase = propiedades.getProperty("RUTA_BASE");
		this.rutaBaseRespaldo = propiedades.getProperty("RUTA_BASE_RESPALDO");
		this.rutatemporal = propiedades.getProperty("RUTA_TEMPORAL");
		this.rutaResultadoDTE = propiedades.getProperty("RUTA_RESULTADO_DTE");
		this.rutaCAF = propiedades.getProperty("RUTA_CAF");
		this.rutaResultadoPDF = propiedades.getProperty("RUTA_RESULTADO_PDF");
		this.rutaResultadoPDFCedible = propiedades.getProperty("RUTA_RESULTADO_PDF_CEDIBLE");
		this.rutaTemplatePDF = propiedades.getProperty("RUTA_TEMPLATE_PDF");
		this.tipoImpresora = Integer.valueOf(propiedades.getProperty("TIPO_IMPRESORA"));
		this.empresaID = Integer.valueOf(propiedades.getProperty("EMPRESA_ID"));
		this.fechaResolucion = propiedades.getProperty("FCH_RESOLUCION");
		this.numeroResolucion = Integer.valueOf(propiedades.getProperty("NRO_RESOLUCION"));
		this.rutaError = propiedades.getProperty("RUTA_ERROR");
		this.img417 = propiedades.getProperty("IMG417");
	}
	
	public String getImg417() {
		return img417;
	}

	public void setImg417(String img417) {
		this.img417 = img417;
	}

	public String getRutaBase() {
		return rutaBase;
	}

	public void setRutaBase(String rutaBase) {
		this.rutaBase = rutaBase;
	}

	public String getRutaBaseRespaldo() {
		return rutaBaseRespaldo;
	}

	public void setRutaBaseRespaldo(String rutaBaseRespaldo) {
		this.rutaBaseRespaldo = rutaBaseRespaldo;
	}

	public String getRutatemporal() {
		return rutatemporal;
	}

	public void setRutatemporal(String rutatemporal) {
		this.rutatemporal = rutatemporal;
	}

	public String getRutaResultadoDTE() {
		return rutaResultadoDTE;
	}

	public void setRutaResultadoDTE(String rutaResultadoDTE) {
		this.rutaResultadoDTE = rutaResultadoDTE;
	}

	public String getRutaCAF() {
		return rutaCAF;
	}

	public void setRutaCAF(String rutaCAF) {
		this.rutaCAF = rutaCAF;
	}

	public String getRutaResultadoPDF() {
		return rutaResultadoPDF;
	}

	public void setRutaResultadoPDF(String rutaResultadoPDF) {
		this.rutaResultadoPDF = rutaResultadoPDF;
	}

	public String getRutaResultadoPDFCedible() {
		return rutaResultadoPDFCedible;
	}
	
	public void setRutaResultadoCedible(String rutaResultadoPDFCedible) {
		this.rutaResultadoPDFCedible = rutaResultadoPDFCedible;
	}

	public String getRutaTemplatePDF() {
		return rutaTemplatePDF;
	}

	public void setRutaTemplatePDF(String rutaTemplatePDF) {
		this.rutaTemplatePDF = rutaTemplatePDF;
	}

	public Integer getTipoImpresora() {
		return tipoImpresora;
	}

	public void setTipoImpresora(Integer tipoImpresora) {
		this.tipoImpresora = tipoImpresora;
	}

	public Integer getEmpresaID() {
		return empresaID;
	}

	public void setEmpresaID(Integer empresaID) {
		this.empresaID = empresaID;
	}

	public String getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(String fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public Integer getNumeroResolucion() {
		return numeroResolucion;
	}

	public void setNumeroResolucion(Integer numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	public String getRutaError() {
		return rutaError;
	}

	public void setRutaError(String rutaError) {
		this.rutaError = rutaError;
	}
	
	
	
}
