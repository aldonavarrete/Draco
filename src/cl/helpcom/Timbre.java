package cl.helpcom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import cl.helpcom.PropiedadesCreaDTE;

import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Document;

import Conexion.Conexion;
import cl.helpcom.itext.LeerXML;
import cl.helpcom.ImpresoraTermica;
import cl.nic.dte.VerifyResult;
import cl.nic.dte.examples.SchemaUtil;
import cl.sii.siiDte.AUTORIZACIONDocument;
import cl.sii.siiDte.AutorizacionType;
import cl.sii.siiDte.DTEDocument;
import java.util.Calendar;

public class Timbre {
	public void timbrarDTE(PropiedadesCreaDTE prop,Integer tipoDTE,Long folio,ArrayList<String> arrayEncabezado,ArrayList<ArrayList<String>> arrayDetallePDF,ArrayList<ArrayList<String>> arrayReferencia,ArrayList<ArrayList<String>> arrayDscGlobales,String nomDocPlano) throws IOException{

		//LectorFichero lectorFichero = new LectorFichero();
		String baseRespaldo =  prop.getRutaBaseRespaldo().toString();
		String tipoImpresora = prop.getTipoImpresora().toString();
		String plantilla = prop.getRutaResultadoDTE().toString()+"/sinTimbrar/"+tipoDTE+folio+".xml";
		String archivoCaf = prop.getRutaCAF().toString();
		String dteTimbrado = this.crearFicheroDTE(prop.getRutaResultadoDTE().toString() + "/dte")+"/"+tipoDTE+folio+".xml";
		// Archivos de PDF
		String rutaPDF = prop.getRutaResultadoPDF().toString();
		String rutaPDFCedible = prop.getRutaResultadoPDFCedible().toString();
		rutaPDF = this.crearFicheroDTE(rutaPDF);//Crea Sub carpetas Anio,Mes
		rutaPDFCedible = this.crearFicheroDTE(rutaPDFCedible);
		String resultadoPDF = rutaPDF;
		String resultadoPDFCedible = rutaPDFCedible;
		String templatePDF = prop.getRutaTemplatePDF().toString();

		HashMap<String, String> namespaces = new HashMap<String, String>();
		namespaces.put("", "http://www.sii.cl/SiiDte");
		XmlOptions opts = new XmlOptions();
		opts.setLoadSubstituteNamespaces(namespaces);
		
		
	
		try {
			Conexion conexionSql1 = new Conexion();
                        //METODO PARA CAPTURAR METODO DE NOMBRE DE CAF
                        
                        /**DEBE GENERAR METODO EN LA CONEXION A BD QUE OBTENGA NUMERO DE CAF
                         * EJEMPLO 
                         * public String getNombreArchivoCAF(int tipo, Long folio) throws SQLException {

                                    Statement comando = this.con.createStatement();
                                    ResultSet registro;
                                    String res="NO";

                                    registro = comando.executeQuery("SELECT caf_nombre_archivo FROM dte_caf WHERE doc_tipo="+tipo+" AND "+folio+" BETWEEN caf_minimo AND caf_maximo");
                                    while (registro.next()) {
                                            res=registro.getString("caf_nombre_archivo");
                                    }
                                    return res;
                                }
                        */
                        
			archivoCaf+=conexionSql1.getNombreArchivoCAF(tipoDTE, folio);//Obtiene Nombre del CAF
			cl.sii.siiDte.DTEDocument doc = null;
			try {
				
				AutorizacionType caf = AUTORIZACIONDocument.Factory.parse(new File(archivoCaf), opts).getAUTORIZACION();
				// Construyo DTE a partir de archivo de entrada
				doc = cl.sii.siiDte.DTEDocument.Factory.parse(new File(plantilla), opts);
				doc.getDTE().timbrar(caf.getCAF(), caf.getPrivateKey(null));
	
				opts = new XmlOptions();
				opts.setSaveImplicitNamespaces(namespaces);
				opts.setLoadSubstituteNamespaces(namespaces);
				opts.setCharacterEncoding("ISO-8859-1");
				opts.setSavePrettyPrint();
				opts.setSavePrettyPrintIndent(0);
	
				doc = DTEDocument.Factory.parse(doc.newInputStream(opts), opts);
				doc.save(new File(dteTimbrado),opts);
			
			}catch (Exception e) {
				System.out.println(e);
			}	
//			
			
			//CreaPDFTest1 creaPDF = new CreaPDFTest1();
			ImpresoraTermica impresoraTermica = new ImpresoraTermica();
			/**
			 * 1 = Solo CARTA
			 * 2 = Solo TERMICO
			 * 3 = CARTA y TERMICO
			 ***/
			switch(tipoImpresora) {
					
				case "2":
					/**FORMATO TERMICO**/
					System.out.println("TERMICAS");
					if (tipoDTE==33 || tipoDTE==34){
						impresoraTermica.imprimirTicket(prop,resultadoPDF, arrayEncabezado,arrayDetallePDF, arrayReferencia,arrayDscGlobales,dteTimbrado,arrayDetallePDF.size(),"","");
						impresoraTermica.imprimirTicket(prop,rutaPDFCedible, arrayEncabezado,arrayDetallePDF, arrayReferencia,arrayDscGlobales,dteTimbrado,arrayDetallePDF.size(),"CEDIBLE","");
					}
					else if (tipoDTE==56 || tipoDTE==61){
						impresoraTermica.imprimirTicket(prop,resultadoPDF, arrayEncabezado,arrayDetallePDF, arrayReferencia,arrayDscGlobales,dteTimbrado,arrayDetallePDF.size(),"","");
					}else if (tipoDTE==52){
						impresoraTermica.imprimirTicket(prop,resultadoPDF, arrayEncabezado,arrayDetallePDF, arrayReferencia,arrayDscGlobales,dteTimbrado,arrayDetallePDF.size(),"","");
						impresoraTermica.imprimirTicket(prop,resultadoPDF, arrayEncabezado,arrayDetallePDF, arrayReferencia,arrayDscGlobales,dteTimbrado,arrayDetallePDF.size(),"CUADRUPLICADO COBRO EJECUTIVO-CEDIBLE CON SU FACTURA","");
					}
					break;
				
				
			}
			String salidaPDF = resultadoPDF+"/"+arrayEncabezado.get(0)+arrayEncabezado.get(1)+".pdf";	
			String dirBolSalidaIMG=prop.getImg417()+""+arrayEncabezado.get(0)+arrayEncabezado.get(1)+".png";
				// CRUD BDtu
				try {
					LeerXML getTED = new LeerXML();
                                        
                                        /* DEBE AGREGAR METODO PARA AGREGAR DTE TIMBRADO EN DB
                                        ---EJEMPLO--
                                        public void addDTETimbrado(Integer emp_id, Integer tdo_id, Long folio,String doc_rut, String doc_fecha_emision,String doc_razon_social,Integer doc_monto,String doc_xml_timbrado,String doc_estado,String filenamePDF) throws SQLException, FileNotFoundException {

                                                Statement comando = this.con.createStatement();
                                                String sql = "INSERT INTO dte_emi_documento (emp_id, tdo_id, doc_folio, doc_rut_receptor, doc_fecha_emision,  doc_razon_social, doc_monto,doc_xml_timbrado, doc_estado) VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";
                                                //System.out.println("timbrado \n "+doc_xml_timbrado);
                                                PreparedStatement statement = (PreparedStatement) this.con.prepareStatement(sql);
                                                statement.setInt(1, emp_id);
                                                statement.setInt(2, tdo_id);
                                                statement.setLong(3, folio);
                                                statement.setString(4, doc_rut);
                                                statement.setString(5, doc_fecha_emision);
                                                statement.setString(6, doc_razon_social);
                                                statement.setInt(7, doc_monto);
                                                statement.setString(8, doc_xml_timbrado);
                                                statement.setString(9, doc_estado);

                                                //guardarZIP(filenamePDF, tdo_id,folio);//Guardar documentoPDF Binario BLOB

                                                int rowsInserted = statement.executeUpdate();
                                                if (rowsInserted > 0) {
                                                    System.out.println("Base Datos OK");
                                                }else {
                                                        System.out.println("NO se ha podido insertar el registro correctamente");
                                                        }
                                                }
                                        */
					conexionSql1.addDTETimbrado(Integer.valueOf(prop.getEmpresaID().toString()), Integer.valueOf(arrayEncabezado.get(0)), Long.valueOf(arrayEncabezado.get(1)), arrayEncabezado.get(21), arrayEncabezado.get(2), arrayEncabezado.get(22), Integer.valueOf(arrayEncabezado.get(46)), doc.toString(), "EMITIDO",salidaPDF);
					
					String ted = getTED.obtenerTED(dteTimbrado);
                                        
                                        /**
                                         * SE DEBE AGREGAR TED A BD 
                                         * public void addTED(String ted,Integer tipoDoc,Long folioDoc) throws SQLException, FileNotFoundException{

                                                            String updateSQL = "UPDATE dte_emi_documento SET doc_ted='"+ted+"' WHERE tdo_id='"+tipoDoc+"' AND doc_folio= '"+folioDoc+"'";
                                                            Statement comando = this.con.createStatement();
                                                        comando.executeUpdate(updateSQL);
                                            }
                                         **/
					conexionSql1.addTED(ted, Integer.valueOf(arrayEncabezado.get(0)), Long.valueOf(arrayEncabezado.get(1)));
					
					BarcodeBoleta pdf417 = new BarcodeBoleta();
					pdf417.crearPDF417_png(ted, dirBolSalidaIMG);
					
					conexionSql1.cerrarConexion();
				} catch (Exception e) {
					System.err.println("No hay acceso a la base de datos " + e);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        public String crearFicheroDTE (String rutaFolder){

		 	Calendar fecha = Calendar.getInstance();
			int ano = fecha.get(Calendar.YEAR);
			int mes = fecha.get(Calendar.MONTH) + 1;
			rutaFolder = rutaFolder +"/"+ ano + "/" + mes;

			File folder = new File(rutaFolder);

			if (folder.exists()) {
				//carpeta correcta

			} else {
				// folder.mkdir();
				folder.mkdirs();
				//Se crea una nueva carpeta
			}

		 return rutaFolder;
	 }
}
