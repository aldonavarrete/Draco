
package cl.helpcom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import javax.print.PrintException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodePDF417;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PDFTermica {
	private Properties propiedades = new Properties();
	private InputStream entrada = null;

	public void creaPDF(String archivoSalida, ArrayList<String> arrayEncabezado,
			ArrayList<ArrayList<String>> arrayDetalle, ArrayList<ArrayList<String>> arrayReferencia,
			ArrayList<ArrayList<String>> arrayDscGlobal, String rutaDTE, int cItem, String cedible)
			throws IOException, DocumentException, PrintException {
		// cargamos el archivo de propiedades
		entrada = new FileInputStream("/usr/local/F_E/Configuraciones/Propiedades/configuracionCreaDTE.properties");
		propiedades.load(entrada);
		/** PRUEBA **/
	    String rutaLogo = "/usr/local/F_E/logo.png";
		DecimalFormat formato = new DecimalFormat("#,###.##");
		String rutE = arrayEncabezado.get(11);
		String[] rutEmisor = rutE.split("-");
		String tipoDTE = this.setTipoDocumento(arrayEncabezado.get(0));// TIPO DTE

		float left = 0;
		float right = 0;
		float top = 0;
		float bottom = 0;

		Document document = new Document(PageSize.A4, left, right, top, bottom);

		try {
			PdfWriter.getInstance(document, new FileOutputStream(archivoSalida));
			document.open();

			PdfPTable table = new PdfPTable(1);
			float[] f = new float[1];
			float[] fTop = new float[1];
			float[] f2 = new float[4];
			float[] fILA = new float[8];
			float[] f3 = new float[3];
			f[0] = 195;
			table.setTotalWidth(f);
			table.setLockedWidth(true);

			Font font = new Font(FontFamily.HELVETICA, 11, Font.BOLD);
			Font font2 = new Font(FontFamily.HELVETICA, 7, Font.BOLD);
			Font font3 = new Font(FontFamily.HELVETICA, 7);
			Font font4 = new Font(FontFamily.HELVETICA, 7, Font.BOLD);// MONTOS
			Font font5 = new Font(FontFamily.UNDEFINED, 5);

			/** CUADRO **/
			Paragraph wrong = new Paragraph("R.U.T.: " + formato.format(Double.parseDouble(rutEmisor[0])) + "- "
					+ rutEmisor[1] + "\n\n" + tipoDTE + "\n\nN� " + arrayEncabezado.get(1), font);
			PdfPCell celdaFinal = new PdfPCell(new Paragraph(wrong));
			celdaFinal.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinal.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celdaFinal.setBorderWidth(2F);
			celdaFinal.setUseBorderPadding(true);
			table.setHorizontalAlignment(0);
			celdaFinal.setColspan(1);
			table.addCell(celdaFinal);
			document.add(table);

			PdfPTable table2 = new PdfPTable(1);// Datos Emisor
			PdfPTable table3 = new PdfPTable(1);// Datos Receptor
			PdfPTable table3_1 = new PdfPTable(1);// Datos Referencia
			PdfPTable table4 = new PdfPTable(4);
			PdfPTable table5 = new PdfPTable(3);
			PdfPTable table5_1 = new PdfPTable(1);
			PdfPTable table5_ILA = new PdfPTable(8);// Datos ILA
			PdfPTable table6 = new PdfPTable(1);
			PdfPTable table7 = new PdfPTable(1);

			fTop[0] = 197; // ancho table
			f[0] = 197; // ancho table
			f2[0] = 0.3f;
			f2[1] = 0.6f;
			f2[2] = 0.4f; // ancho table
			f2[3] = 1.8f; // ancho table
			f3[0] = 0.5f;
			f3[1] = 0.8f;
			f3[2] = 1.85f; // ancho table
			fILA[0] = .12f;// ancho table
			fILA[1] = .12f;// ancho table
			fILA[2] = .12f;// ancho table
			fILA[3] = .12f;// ancho table
			fILA[4] = .12f;// ancho table
			fILA[5] = .12f;// ancho table
			fILA[6] = .12f;// ancho table
			fILA[7] = 1.2f;// ancho table ILA en blanco

			table2.setTotalWidth(fTop);
			table2.setLockedWidth(true);
			table3.setTotalWidth(f);
			table3.setLockedWidth(true);
			table3_1.setTotalWidth(f);
			table3_1.setLockedWidth(true);
			table4.setTotalWidth(f2);
			table4.setLockedWidth(false);
			table5.setTotalWidth(f3);
			table5.setLockedWidth(false);
			table5_1.setTotalWidth(f);
			table5_1.setLockedWidth(true);
			table6.setTotalWidth(f);
			table6.setLockedWidth(true);
			table7.setTotalWidth(f);
			table7.setLockedWidth(true);

			table5_ILA.setTotalWidth(fILA);
			table5_ILA.setLockedWidth(false);
			table4.setLockedWidth(false);

			Paragraph wrong2;
			String sucursales = "";
			if (arrayEncabezado.get(11).equals("83943200-3")) {// PALMA E HIJOS
				wrong2 = new Paragraph("S.I.I - VICTORIA", font);
			} else if (arrayEncabezado.get(11).equals("76024703-0")) {// VETERINARIA CAMPOS
				wrong2 = new Paragraph("S.I.I - TEMUCO", font);
			} else if (arrayEncabezado.get(11).equals("77349320-0")) {// TREBOL
				wrong2 = new Paragraph("S.I.I - TEMUCO", font);
				sucursales = "SUCURSALES:\n\n"
						+ "1.  LAUTARO 206 - CARAHUE                15. CAMPO DE MARTE 061 - ANGOL\n"
						+ "2.  B. O'HIGGINS 922 - LAUTARO           16. V. ALEGRE 774 - P. LAS CASAS\n"
						+ "3.  SANTA CRUZ 824 - TRAIGUEN          17. BARROS ARANA 06561 - TCO \n"
						+ "4.  SANTA MARIA 321 - CUNCO              18. A. PRAT 54 - PANGUIPULLI\n"
						+ "5.  LORD COCHRANE 32O - GORBEA    19. ALDUNATE 485 - TCO\n"
						+ "6.  3 PON./1 NORTE - LABRANZA            20. V. MACKENNA 450 - TCO  \n"
						+ "7.  AV. M. RECABARREN 01515 - TCO    21. LAUTARO 206 - CARAHUE\n"
						+ "8.  CRUZ 298 - COLLIPULLI                      22. V. MACKENNA - LAUTARO\n"
						+ "9.  BAQUEDANO 319 - N. IMPERIAL        23. MANUEL BULNES 13 - TCO\n"
						+ "10. M. BULNES 201 - LONCOCHE           24. P. DE VALVIVIA 266 - PANGUIPULLI\n"
						+ "11. C. SUIZA 1267 - VICTORIA                 25. AV. ORIENTE 1231 -  LOS ANGELES\n"
						+ "12. LIBERTAD 134 - LANCO                     26. AV. SIMPSON 499 - VALDIVIA\n"
						+ "13. FCO. BILBAO 333 - PITRUFQUEN     27. RENE SCHENIDER 3722 - VALVIDIA\n"
						+ "14. BARROS ARANA 01750 - TCO\n";
			} else {
				wrong2 = new Paragraph("S.I.I - " + arrayEncabezado.get(19), font);
			}

			/** EMISOR **/
			Image imagen = Image.getInstance(rutaLogo);
			Paragraph wrong4 = new Paragraph(new String(arrayEncabezado.get(12).getBytes(), "UTF-8"),
					font2);/** Razon Social Emisor **/
			Paragraph wrong5 = new Paragraph("Giro: " + new String(arrayEncabezado.get(13).getBytes(), "UTF-8"),
					font3);/** Giro Emisor **/
			Paragraph wrong6 = new Paragraph("Direcci�n: " + new String(arrayEncabezado.get(17).getBytes(), "UTF-8"),
					font3);
			Paragraph wrong7 = new Paragraph("Ciudad: " + new String(arrayEncabezado.get(18).getBytes(), "UTF-8")
					+ "     Comuna: " + arrayEncabezado.get(19) + "\n", font3);
			Paragraph wrong8 = new Paragraph(sucursales, font5);

			PdfPCell celdaFinal2 = new PdfPCell(new Paragraph(wrong2));
			PdfPCell celdaFinal3 = new PdfPCell();
			PdfPCell celdaFinal4 = new PdfPCell(new Paragraph(wrong4));
			PdfPCell celdaFinal5 = new PdfPCell(new Paragraph(wrong5));
			PdfPCell celdaFinal6 = new PdfPCell(new Paragraph(wrong6));
			PdfPCell celdaFinal7 = new PdfPCell(new Paragraph(wrong7));
			PdfPCell celdaFinal8 = new PdfPCell(new Paragraph(wrong8));
			imagen.scaleAbsolute(160, 160); // dimension de logo fijo
			imagen.setAlignment(Image.ALIGN_CENTER);
			celdaFinal3.addElement(imagen);

			celdaFinal2.setBorder(Rectangle.NO_BORDER);
			celdaFinal3.setBorder(Rectangle.NO_BORDER);
			celdaFinal4.setBorder(Rectangle.NO_BORDER);
			celdaFinal5.setBorder(Rectangle.NO_BORDER);
			celdaFinal6.setBorder(Rectangle.NO_BORDER);
			celdaFinal7.setBorder(Rectangle.NO_BORDER);
			celdaFinal8.setBorder(Rectangle.NO_BORDER);

			celdaFinal2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celdaFinal2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celdaFinal3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			celdaFinal4.setHorizontalAlignment(Element.ALIGN_LEFT);

			table2.setHorizontalAlignment(0);
			table3.setHorizontalAlignment(0);
			table3_1.setHorizontalAlignment(0);
			table4.setHorizontalAlignment(0);
			table5.setHorizontalAlignment(0);
			table5_1.setHorizontalAlignment(0);
			table6.setHorizontalAlignment(0);
			table7.setHorizontalAlignment(0);
			table5_ILA.setHorizontalAlignment(0);

			table2.addCell(celdaFinal2);
			table2.addCell(celdaFinal3);
			table2.addCell(celdaFinal4);
			table2.addCell(celdaFinal5);
			table2.addCell(celdaFinal6);
			table2.addCell(celdaFinal7);
			table2.addCell(celdaFinal8);

			document.add(table2);

			/** RECEPTOR **/
			Paragraph wrong9 = new Paragraph("\nSe�or (es): " + arrayEncabezado.get(22),
					font3);/** Razon Social Receptor **/
			Paragraph wrong10 = new Paragraph("Giro: " + arrayEncabezado.get(23), font3);/** Giro Receptor **/
			Paragraph wrong14 = new Paragraph("Rut: " + arrayEncabezado.get(21), font3);/** Rut Receptor **/
			Paragraph wrong11 = new Paragraph("Direcci�n: " + arrayEncabezado.get(26), font3);/** Direccion **/
			Paragraph wrong12 = new Paragraph("Ciudad: " + arrayEncabezado.get(27), font3);/** Comuna **/
			Paragraph wrong13 = new Paragraph("Comuna: " + arrayEncabezado.get(28), font3);/** Ciudad **/
			Paragraph wrong14_1 = new Paragraph("", font3);/** BLANCO **/
			Paragraph wrong14_2 = new Paragraph("Fecha de Emisi�n: " + arrayEncabezado.get(2),
					font4);/** Fecha Emision **/

			PdfPCell celdaFinal9 = new PdfPCell(new Paragraph(wrong9));
			PdfPCell celdaFinal10 = new PdfPCell(new Paragraph(wrong10));
			PdfPCell celdaFinal11 = new PdfPCell(new Paragraph(wrong11));
			PdfPCell celdaFinal12 = new PdfPCell(new Paragraph(wrong12));
			PdfPCell celdaFinal13 = new PdfPCell(new Paragraph(wrong13));
			PdfPCell celdaFinal14 = new PdfPCell(new Paragraph(wrong14));
			PdfPCell celdaFinal14_1 = new PdfPCell(new Paragraph(wrong14_1));
			PdfPCell celdaFinal14_2 = new PdfPCell(new Paragraph(wrong14_2));

			celdaFinal9.setBorder(Rectangle.NO_BORDER);
			celdaFinal10.setBorder(Rectangle.NO_BORDER);
			celdaFinal11.setBorder(Rectangle.NO_BORDER);
			celdaFinal12.setBorder(Rectangle.NO_BORDER);
			celdaFinal13.setBorder(Rectangle.NO_BORDER);
			celdaFinal14.setBorder(Rectangle.NO_BORDER);
			celdaFinal14_1.setBorder(Rectangle.NO_BORDER);
			celdaFinal14_2.setBorder(Rectangle.NO_BORDER);

			celdaFinal9.setHorizontalAlignment(Element.ALIGN_LEFT);//
			celdaFinal10.setHorizontalAlignment(Element.ALIGN_LEFT);//
			celdaFinal11.setHorizontalAlignment(Element.ALIGN_LEFT);//
			celdaFinal12.setHorizontalAlignment(Element.ALIGN_LEFT);//
			celdaFinal13.setHorizontalAlignment(Element.ALIGN_LEFT);//
			celdaFinal14.setHorizontalAlignment(Element.ALIGN_LEFT);//
			celdaFinal14_2.setHorizontalAlignment(Element.ALIGN_LEFT);//
			table3.addCell(celdaFinal9);
			table3.addCell(celdaFinal10);
			table3.addCell(celdaFinal14);
			table3.addCell(celdaFinal11);
			table3.addCell(celdaFinal12);
			table3.addCell(celdaFinal13);
			table3.addCell(celdaFinal14_1);
			table3.addCell(celdaFinal14_2);

			document.add(table3);
			document.add(new Paragraph(" "));

			if (arrayReferencia.size() > 0) {
				Paragraph wrong_ref = new Paragraph("Documentos de Referencia\n.", font4);
				document.add(wrong_ref);
				document.add(new LineSeparator());

				Paragraph wrong_ref_1 = new Paragraph("Tipo Documento: " + arrayReferencia.get(0).get(1), font3);
				Paragraph wrong_ref_2 = new Paragraph(
						"Folio: " + arrayReferencia.get(0).get(3) + "         Fecha: " + arrayReferencia.get(0).get(5),
						font3);
				Paragraph wrong_ref_4 = new Paragraph("Razon: " + arrayReferencia.get(0).get(7), font3);

				PdfPCell celdaRef_1 = new PdfPCell(new Paragraph(wrong_ref_1));
				PdfPCell celdaRef_2 = new PdfPCell(new Paragraph(wrong_ref_2));
				PdfPCell celdaRef_4 = new PdfPCell(new Paragraph(wrong_ref_4));

				celdaRef_1.setBorder(Rectangle.NO_BORDER);
				celdaRef_2.setBorder(Rectangle.NO_BORDER);
				celdaRef_4.setBorder(Rectangle.NO_BORDER);

				table3_1.addCell(celdaRef_1);
				table3_1.addCell(celdaRef_2);
				table3_1.addCell(celdaRef_4);

				document.add(table3_1);
			}
			document.add(new LineSeparator());

			/** DETALLES **/
			int cGrilla = 1;
			double totalDescuento = 0;
			;
			int tamTextDet = 77;
			Paragraph wrong15_1_1 = new Paragraph("CANT.", font3);/** CANT **/
			Paragraph wrong15_1_2 = new Paragraph("P. UNIT", font3);/** P UNIT **/
			Paragraph wrong15_1_3 = new Paragraph("TOTAL", font3);/** TOTAL **/
			Paragraph wrong15_1_4 = new Paragraph(" ", font3);/** EN BLANCO **/
			Paragraph wrong15_1_5 = new Paragraph("PLU", font3);/** PLU **/
			Paragraph wrong15_1_6 = new Paragraph("DESCRIPCION", font3);/** DETALLE **/
			PdfPCell celdaFinal15_1_1 = new PdfPCell(new Paragraph(wrong15_1_1));
			PdfPCell celdaFinal15_1_2 = new PdfPCell(new Paragraph(wrong15_1_2));
			PdfPCell celdaFinal15_1_3 = new PdfPCell(new Paragraph(wrong15_1_3));
			PdfPCell celdaFinal15_1_4 = new PdfPCell(new Paragraph(wrong15_1_4));
			PdfPCell celdaFinal15_1_5 = new PdfPCell(new Paragraph(wrong15_1_5));
			PdfPCell celdaFinal15_1_6 = new PdfPCell(new Paragraph(wrong15_1_6));

			celdaFinal15_1_6.setColspan(3);

			celdaFinal15_1_1.setBorder(Rectangle.NO_BORDER);
			celdaFinal15_1_2.setBorder(Rectangle.NO_BORDER);
			celdaFinal15_1_3.setBorder(Rectangle.NO_BORDER);
			celdaFinal15_1_4.setBorder(Rectangle.NO_BORDER);
			celdaFinal15_1_5.setBorder(Rectangle.NO_BORDER);
			celdaFinal15_1_6.setBorder(Rectangle.NO_BORDER);
			celdaFinal15_1_3.setHorizontalAlignment(Element.ALIGN_RIGHT);//
			table4.addCell(celdaFinal15_1_1);
			table4.addCell(celdaFinal15_1_2);
			table4.addCell(celdaFinal15_1_3);
			table4.addCell(celdaFinal15_1_4);
			table4.addCell(celdaFinal15_1_5);
			table4.addCell(celdaFinal15_1_6);

			document.add(table4);
			document.add(new LineSeparator());
			document.add(new Paragraph(" "));

			table4 = new PdfPTable(4);
			table4.setTotalWidth(f2);
			table4.setLockedWidth(false);
			table4.setHorizontalAlignment(0);

			for (int c = 0; c < arrayDetalle.size(); c++) {
				Paragraph wrong15_1 = new Paragraph(formato.format(Double.parseDouble(arrayDetalle.get(c).get(5))),
						font3);/** CANT **/
				Paragraph wrong15_2 = new Paragraph(
						"$ " + formato.format(Double.parseDouble(arrayDetalle.get(c).get(7))), font3);/** P UNIT **/
				Paragraph wrong15_3 = new Paragraph(
						"$ " + formato.format(Double.parseDouble(arrayDetalle.get(c).get(12))), font3);/** TOTAL **/
				Paragraph wrong15_4 = new Paragraph("", font3);/** EN BLANCO **/
				Paragraph wrong15_5 = new Paragraph(arrayDetalle.get(c).get(1), font3);/** PLU **/
				Paragraph wrong15_6 = new Paragraph(arrayDetalle.get(c).get(3), font3);/** DETALLE **/
				Paragraph wrong15_7 = new Paragraph("", font3);/** EN BLANCO **/
				Paragraph wrong15_8 = new Paragraph("", font3);/** EN BLANCO **/

				PdfPCell celdaFinal15_1 = new PdfPCell(new Paragraph(wrong15_1));
				PdfPCell celdaFinal15_2 = new PdfPCell(new Paragraph(wrong15_2));
				PdfPCell celdaFinal15_3 = new PdfPCell(new Paragraph(wrong15_3));
				PdfPCell celdaFinal15_4 = new PdfPCell(new Paragraph(wrong15_4));
				PdfPCell celdaFinal15_5 = new PdfPCell(new Paragraph(wrong15_5));
				PdfPCell celdaFinal15_6 = new PdfPCell(new Paragraph(wrong15_6));
				celdaFinal15_6.setColspan(3);

				celdaFinal15_1.setBorder(Rectangle.NO_BORDER);
				celdaFinal15_2.setBorder(Rectangle.NO_BORDER);
				celdaFinal15_3.setBorder(Rectangle.NO_BORDER);
				celdaFinal15_4.setBorder(Rectangle.NO_BORDER);
				celdaFinal15_5.setBorder(Rectangle.NO_BORDER);
				celdaFinal15_6.setBorder(Rectangle.NO_BORDER);
				celdaFinal15_3.setHorizontalAlignment(Element.ALIGN_RIGHT);//
				table4.addCell(celdaFinal15_1);
				table4.addCell(celdaFinal15_2);
				table4.addCell(celdaFinal15_3);
				table4.addCell(celdaFinal15_4);
				table4.addCell(celdaFinal15_5);
				table4.addCell(celdaFinal15_6);

			}

			document.add(table4);
			document.add(new LineSeparator());

			/** ILAS **/
			Boolean ilasSwitch = Boolean.FALSE;
			Paragraph wrongILA1 = null;
			Paragraph wrongILA2 = null;
			Paragraph wrongILA3 = null;
			Paragraph wrongILA4 = null;
			Paragraph wrongILA5 = null;
			Paragraph wrongILA6 = null;
			Paragraph wrongILA7 = null;

			if ((arrayEncabezado.get(48).trim().equals("-1"))) {
				wrongILA1 = new Paragraph("5 IVA%\n(Carne)\n0", font5);
			} else {
				String ilaSAzucar = arrayEncabezado.get(48);
				String arrayILA[] = ilaSAzucar.split(";");
				wrongILA1 = new Paragraph("5 IVA%\n(Carne)\n$" + formato.format(Double.parseDouble(arrayILA[0])),
						font5);
				ilasSwitch = Boolean.TRUE;
			}
			if ((arrayEncabezado.get(49).trim().equals("-1"))) {
				wrongILA2 = new Paragraph("12 IVA%\n(Harina)\n0", font5);
			} else {
				String ilaSAzucar = arrayEncabezado.get(49);
				String arrayILA[] = ilaSAzucar.split(";");
				wrongILA2 = new Paragraph("12 IVA%\n(Harina)\n$" + formato.format(Double.parseDouble(arrayILA[0])),
						font5);
				ilasSwitch = Boolean.TRUE;
			}
			if ((arrayEncabezado.get(50).trim().equals("-1"))) {
				wrongILA3 = new Paragraph("31,5% ILA\n(Licor)\n0", font5);
			} else {
				String ilaSAzucar = arrayEncabezado.get(50);
				String arrayILA[] = ilaSAzucar.split(";");
				wrongILA3 = new Paragraph("31,5% ILA\n(Licor)\n$" + formato.format(Double.parseDouble(arrayILA[0])),
						font5);
				ilasSwitch = Boolean.TRUE;
			}
			if ((arrayEncabezado.get(51).trim().equals("-1"))) {
				wrongILA4 = new Paragraph("20,5% ILA\n(Vino)\n0", font5);
			} else {
				String ilaSAzucar = arrayEncabezado.get(51);
				String arrayILA[] = ilaSAzucar.split(";");
				wrongILA4 = new Paragraph("20,5% ILA\n(Vino)\n$" + formato.format(Double.parseDouble(arrayILA[0])),
						font5);
				ilasSwitch = Boolean.TRUE;
			}
			if ((arrayEncabezado.get(51).trim().equals("-1"))) {
				wrongILA5 = new Paragraph("20,5 ILA%\n(Cerveza)\n0", font5);
			} else {
				String ilaSAzucar = arrayEncabezado.get(51);
				String arrayILA[] = ilaSAzucar.split(";");
				wrongILA5 = new Paragraph("20,5 ILA%\n(Cerveza)\n$" + formato.format(Double.parseDouble(arrayILA[0])),
						font5);
				ilasSwitch = Boolean.TRUE;
			}

			if ((arrayEncabezado.get(52).trim().equals("-1"))) {
				wrongILA6 = new Paragraph("10 ILA%\n(S/Azucar)\n0", font5);
			} else {
				String ilaSAzucar = arrayEncabezado.get(52);
				String arrayILA[] = ilaSAzucar.split(";");
				wrongILA6 = new Paragraph("10 ILA%\n(S/Azucar)\n$" + formato.format(Double.parseDouble(arrayILA[0])),
						font5);
				ilasSwitch = Boolean.TRUE;
			}
			if ((arrayEncabezado.get(53).trim().equals("-1"))) {
				wrongILA7 = new Paragraph("18 ILA%\n(C/Azucar)\n0", font5);
			} else {
				String ilaSAzucar = arrayEncabezado.get(53);
				String arrayILA[] = ilaSAzucar.split(";");
				wrongILA7 = new Paragraph("18 ILA%\n(C/Azucar)\n$" + formato.format(Double.parseDouble(arrayILA[0])),
						font5);
				ilasSwitch = Boolean.TRUE;
			}

			Paragraph wrongILA8 = new Paragraph("", font5);

			PdfPCell celdaFinalILA1 = new PdfPCell(new Paragraph(wrongILA1));
			PdfPCell celdaFinalILA2 = new PdfPCell(new Paragraph(wrongILA2));
			PdfPCell celdaFinalILA3 = new PdfPCell(new Paragraph(wrongILA3));
			PdfPCell celdaFinalILA4 = new PdfPCell(new Paragraph(wrongILA4));
			PdfPCell celdaFinalILA5 = new PdfPCell(new Paragraph(wrongILA5));
			PdfPCell celdaFinalILA6 = new PdfPCell(new Paragraph(wrongILA6));
			PdfPCell celdaFinalILA7 = new PdfPCell(new Paragraph(wrongILA7));
			PdfPCell celdaFinalILA8 = new PdfPCell(new Paragraph(wrongILA8));
			celdaFinalILA8.setBorder(Rectangle.NO_BORDER);

			celdaFinalILA1.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinalILA2.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinalILA3.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinalILA4.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinalILA5.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinalILA6.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinalILA7.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinalILA8.setHorizontalAlignment(Element.ALIGN_CENTER);//
			table5_ILA.addCell(celdaFinalILA1);
			table5_ILA.addCell(celdaFinalILA2);
			table5_ILA.addCell(celdaFinalILA3);
			table5_ILA.addCell(celdaFinalILA4);
			table5_ILA.addCell(celdaFinalILA5);
			table5_ILA.addCell(celdaFinalILA6);
			table5_ILA.addCell(celdaFinalILA7);
			table5_ILA.addCell(celdaFinalILA8);

			System.out.println(ilasSwitch);

			if (ilasSwitch.equals(Boolean.TRUE)) {
				document.add(table5_ILA);// Si tiene ILAS <> -1 lo agrega al Document
			}
			document.add(new Paragraph(" "));

			/** TOTALES **/
			// RECARGO
			
			PdfPCell celdaFinal16_1_R = null;
			PdfPCell celdaFinal16_2_R = null;
			PdfPCell celdaFinal16_3_R = null;
			
			PdfPCell celdaFinal16_1_D = null;
			PdfPCell celdaFinal16_2_D = null;
			PdfPCell celdaFinal16_3_D = null;
			
			Integer recargo = 0;
			Integer descuento = 0;
			
			if (!arrayDscGlobal.isEmpty()) {
				for (int c = 0; c < arrayDscGlobal.size(); c++) {
					if (arrayDscGlobal.get(c).get(1).equals("R") && Double.parseDouble(arrayDscGlobal.get(c).get(4)) > 0) {
						recargo = Integer.valueOf(arrayDscGlobal.get(c).get(4));
						Paragraph wrong16_1_R = new Paragraph("RECARGO", font4);
						Paragraph wrong16_2_R = new Paragraph("$ " + formato.format(Double.parseDouble(arrayDscGlobal.get(c).get(4))), font4);
						Paragraph wrong16_3_R = new Paragraph("", font4);
	
						celdaFinal16_1_R = new PdfPCell(new Paragraph(wrong16_1_R));
						celdaFinal16_2_R = new PdfPCell(new Paragraph(wrong16_2_R));
						celdaFinal16_3_R = new PdfPCell(new Paragraph(wrong16_3_R));
	
						celdaFinal16_2_R.setHorizontalAlignment(Element.ALIGN_RIGHT);//
	
						// RECARGO
						celdaFinal16_1_R.setBorder(Rectangle.NO_BORDER);
						celdaFinal16_2_R.setBorder(Rectangle.NO_BORDER);
						celdaFinal16_3_R.setBorder(Rectangle.NO_BORDER);
						
					}
					if (arrayDscGlobal.get(c).get(1).equals("D") && Double.parseDouble(arrayDscGlobal.get(c).get(4)) > 0) {
						descuento = Integer.valueOf(arrayDscGlobal.get(c).get(4));
						Paragraph wrong16_1_D = new Paragraph("DESCUENTO", font4);
						Paragraph wrong16_2_D = new Paragraph("$ " + formato.format(Double.parseDouble(arrayDscGlobal.get(c).get(4))), font4);
						Paragraph wrong16_3_D = new Paragraph("", font4);
	
						celdaFinal16_1_D = new PdfPCell(new Paragraph(wrong16_1_D));
						celdaFinal16_2_D = new PdfPCell(new Paragraph(wrong16_2_D));
						celdaFinal16_3_D = new PdfPCell(new Paragraph(wrong16_3_D));
	
						celdaFinal16_2_D.setHorizontalAlignment(Element.ALIGN_RIGHT);//
	
						// RECARGO
						celdaFinal16_1_D.setBorder(Rectangle.NO_BORDER);
						celdaFinal16_2_D.setBorder(Rectangle.NO_BORDER);
						celdaFinal16_3_D.setBorder(Rectangle.NO_BORDER);

	
					}
				}
			}

			Paragraph wrong16_1 = new Paragraph("NETO", font4);
			Paragraph wrong16_2 = new Paragraph("$ " + formato.format(Double.parseDouble(arrayEncabezado.get(36))),
					font4);
			Paragraph wrong16_3 = new Paragraph("", font4);
			Paragraph wrong16_1_1 = new Paragraph("EXENTO", font4);
			Paragraph wrong16_2_1 = new Paragraph("$ " + formato.format(Double.parseDouble(arrayEncabezado.get(37))),
					font4);
			Paragraph wrong16_3_1 = new Paragraph("", font4);
			Paragraph wrong16_4 = new Paragraph("IVA (19%)", font4);
			Paragraph wrong16_5 = new Paragraph("$ " + formato.format(Double.parseDouble(arrayEncabezado.get(39))),
					font4);
			Paragraph wrong16_6 = new Paragraph("", font4);
			Paragraph wrong16_7 = new Paragraph("ESPECIFICO", font4);
			Paragraph wrong16_8 = new Paragraph("$ " + formato.format(Double.parseDouble(arrayEncabezado.get(44))),
					font4);
			Paragraph wrong16_9 = new Paragraph("", font4);
			Paragraph wrong16_10 = new Paragraph("MONTO TOTAL", font4);
			Paragraph wrong16_11 = new Paragraph("$ " + formato.format(Double.parseDouble(arrayEncabezado.get(46))),
					font4);
			Paragraph wrong16_12 = new Paragraph("", font4);

			PdfPCell celdaFinal16_1 = new PdfPCell(new Paragraph(wrong16_1));
			PdfPCell celdaFinal16_2 = new PdfPCell(new Paragraph(wrong16_2));
			PdfPCell celdaFinal16_3 = new PdfPCell(new Paragraph(wrong16_3));

			PdfPCell celdaFinal16_1_1 = new PdfPCell(new Paragraph(wrong16_1_1));
			PdfPCell celdaFinal16_2_1 = new PdfPCell(new Paragraph(wrong16_2_1));
			PdfPCell celdaFinal16_3_1 = new PdfPCell(new Paragraph(wrong16_3_1));

			PdfPCell celdaFinal16_4 = new PdfPCell(new Paragraph(wrong16_4));
			PdfPCell celdaFinal16_5 = new PdfPCell(new Paragraph(wrong16_5));
			PdfPCell celdaFinal16_6 = new PdfPCell(new Paragraph(wrong16_6));

			PdfPCell celdaFinal16_7 = new PdfPCell(new Paragraph(wrong16_7));
			PdfPCell celdaFinal16_8 = new PdfPCell(new Paragraph(wrong16_8));
			PdfPCell celdaFinal16_9 = new PdfPCell(new Paragraph(wrong16_9));

			PdfPCell celdaFinal16_10 = new PdfPCell(new Paragraph(wrong16_10));
			PdfPCell celdaFinal16_11 = new PdfPCell(new Paragraph(wrong16_11));
			PdfPCell celdaFinal16_12 = new PdfPCell(new Paragraph(wrong16_12));

			celdaFinal16_2.setHorizontalAlignment(Element.ALIGN_RIGHT);//
			celdaFinal16_2_1.setHorizontalAlignment(Element.ALIGN_RIGHT);//
			celdaFinal16_5.setHorizontalAlignment(Element.ALIGN_RIGHT);//
			celdaFinal16_8.setHorizontalAlignment(Element.ALIGN_RIGHT);//
			celdaFinal16_11.setHorizontalAlignment(Element.ALIGN_RIGHT);//

			celdaFinal16_1.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_2.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_1_1.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_2_1.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_3_1.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_3.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_4.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_5.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_6.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_7.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_8.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_9.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_10.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_11.setBorder(Rectangle.NO_BORDER);
			celdaFinal16_12.setBorder(Rectangle.NO_BORDER);

			int neto = Integer.valueOf(arrayEncabezado.get(36));
			if (neto > 0) {
				table5.addCell(celdaFinal16_1);
				table5.addCell(celdaFinal16_2);
				table5.addCell(celdaFinal16_3);
			}
			int exento = Integer.valueOf(arrayEncabezado.get(37));
			if (exento > 0) {
				table5.addCell(celdaFinal16_1_1);
				table5.addCell(celdaFinal16_2_1);
				table5.addCell(celdaFinal16_3_1);
			}

			table5.addCell(celdaFinal16_4);
			table5.addCell(celdaFinal16_5);// IVA
			table5.addCell(celdaFinal16_6);

			int especifico = Integer.valueOf(arrayEncabezado.get(44));
			if (especifico > 0) {
				table5.addCell(celdaFinal16_7);
				table5.addCell(celdaFinal16_8);
				table5.addCell(celdaFinal16_9);
			}
			
			if (recargo > 0) {
				table5.addCell(celdaFinal16_1_R);
				table5.addCell(celdaFinal16_2_R);
				table5.addCell(celdaFinal16_3_R);
			}
			
			if (descuento > 0) {
				table5.addCell(celdaFinal16_1_D);
				table5.addCell(celdaFinal16_2_D);
				table5.addCell(celdaFinal16_3_D);
			}

			table5.addCell(celdaFinal16_10);
			table5.addCell(celdaFinal16_11);
			table5.addCell(celdaFinal16_12);

			document.add(table5);

			Paragraph wrong17_1 = new Paragraph("\n" + arrayEncabezado.get(47) + " PESOS", font3);
			PdfPCell celdaFinal17_1 = new PdfPCell(new Paragraph(wrong17_1));
			celdaFinal17_1.setBorder(Rectangle.NO_BORDER);
			table5_1.addCell(celdaFinal17_1);

			document.add(table5_1);

			/** CUADRO CEDIBLE **/
			Paragraph wrong23 = new Paragraph(
					"Nombre: _________________________________________ \n\nR.U.T: __________________ Firma: __________________ \n\nFecha: _________________ Recinto: _________________\n.",
					font3);
			Paragraph wrong24 = new Paragraph(
					"El acuse de recibo que se declara en este acto, de acuerdo a lo dispuesto en la letra b) del Art. 4�, y la letra c) del Art. 5� de la Ley 19.983, acredita que la entrega de mercader�as o servicio (s) prestado (s) ha (n) sido recibido (s)",
					font3);
			PdfPCell celdaFinal23 = new PdfPCell(new Paragraph(wrong23));
			PdfPCell celdaFinal24 = new PdfPCell(new Paragraph(wrong24));
			table7.addCell(celdaFinal23);
			table7.addCell(celdaFinal24);

			// escribe tabla cedible
			if (cedible.length() > 0) {
				document.add(table7);
			}

			LeerXML getTED = new LeerXML();

			BarcodePDF417 pdf417 = new BarcodePDF417();
			pdf417.setCodeRows(5);
			pdf417.setCodeColumns(18);
			pdf417.setErrorLevel(5);
			pdf417.setLenCodewords(999);
			pdf417.setOptions(BarcodePDF417.PDF417_FORCE_BINARY);
			pdf417.setText(getTED.obtenerTED(rutaDTE).getBytes("ISO-8859-1"));
			com.itextpdf.text.Image img = pdf417.getImage();
			img.scaleAbsolute(195, 78);

			document.add(img);

			Paragraph wrong19 = new Paragraph("\nTimbre Electr�nico SII", font3);
			Paragraph wrong20 = new Paragraph("Res. Nro " + /* propiedades.getProperty("NRO_RESOLUCION") */0 + " de "
					+ 2017/* propiedades.getProperty("FCH_RESOLUCION").substring(0, 4) */, font3);
			Paragraph wrong21 = new Paragraph("Verifique su documento en www.sii.cl", font3);
			Paragraph wrong22 = new Paragraph("\n", font4);

			if (cedible.length() > 0) {
				wrong22 = new Paragraph("\n" + cedible, font4);
			}

			PdfPCell celdaFinal19 = new PdfPCell(new Paragraph(wrong19));
			PdfPCell celdaFinal20 = new PdfPCell(new Paragraph(wrong20));
			PdfPCell celdaFinal21 = new PdfPCell(new Paragraph(wrong21));
			PdfPCell celdaFinal22 = new PdfPCell(new Paragraph(wrong22));
			celdaFinal19.setBorder(Rectangle.NO_BORDER);
			celdaFinal20.setBorder(Rectangle.NO_BORDER);
			celdaFinal21.setBorder(Rectangle.NO_BORDER);
			celdaFinal22.setBorder(Rectangle.NO_BORDER);
			celdaFinal19.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinal20.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinal21.setHorizontalAlignment(Element.ALIGN_CENTER);//
			celdaFinal22.setHorizontalAlignment(Element.ALIGN_RIGHT);//

			table6.addCell(celdaFinal19);
			table6.addCell(celdaFinal20);
			table6.addCell(celdaFinal21);
			table6.addCell(celdaFinal22);

			document.add(table6);
			document.close();

		} catch (Exception e) {
			System.err.println("Ocurrio un error al crear el archivo " + e);
			System.exit(-1);
		}

		/** PRUEBA **/

	}

	public String setTipoDocumento(String tipoDTE) throws UnsupportedEncodingException {

		String tipo = "";

		if (tipoDTE.equals("33")) {
			tipo = new String("FACTURA ELECTR�NICA".getBytes(), "ISO-8859-1");
		} else if (tipoDTE.equals("56")) {
			tipo = new String("NOTA DE D�BITO ELECTR�NICA".getBytes(), "ISO-8859-1");
		} else if (tipoDTE.equals("61")) {
			tipo = new String("NOTA DE CR�DITO ELECTR�NICA".getBytes(), "ISO-8859-1");
		} else if (tipoDTE.equals("34")) {
			tipo = new String("FACTURA NO AFECTA O EXENTA ELECTR�NICA".getBytes(), "ISO-8859-1");
		} else if (tipoDTE.equals("52")) {
			tipo = new String("GU�A DE DESPACHO ELECTR�NICA".getBytes(), "ISO-8859-1");
		}

		return tipo;
	}
        public String tipoDocumentoTexto(String inTpoDoc){
		String out="SET";
		int [] tpo = {33,34,52,56,61,30,32,45,50,55,60,110,111,112,101,104,106,39,41,46,35,38,103,40,43,801,802,803,804,805,806,808,809,810,811,812,813,814,815,901};
		String[] tpoText={"Factura Electrónica",
				"Factura No Afecta o Exenta Electrónica",
				"Guía de Despacho Electrónica",
				"Nota de Débito Electrónica",
				"Nota de Crédito Electrónica",
				"Factura",
				"Factura de venta bienes y servicios no afectos o exentos de IVA",
				"Factura de Compra",
				"Guía de Despacho",
				"Nota de Débito",
				"Nota de Crédito",
				"Factura de Exportación Electrónica",
				"Nota de Débito de Exportación Electrónica",
				"Nota de Crédito de Exportación Electrónica",
				"Factura de Exportación",
				"Nota de Débito de Exportación",
				"Nota de Crédito de Exportación",
				"Boleta Electrónica",
				"Boleta Exenta Electrónica",
				"Factura de Compra Electrónica",
				"Boleta",
				"Boleta exenta",
				"Liquidación",
				"Liquidación Factura",
				"Liquidación-Factura Electrónica",
				"Orden de Compra",
				"Nota de pedido",
				"Contrato",
				"Resolución",
				"Proceso ChileCompra",
				"Ficha ChileCompra",
				"DUS",
				"B/L (Conocimiento de embarque)",
				"AWB (Air Will Bill)",
				"MIC/DTA",
				"Carta de Porte",
				"Resolución del SNA donde califica Servicios de Exportación",
				"Pasaporte",
				"Certificado de Depósito Bolsa Prod. Chile",
				"Vale de Prenda Bolsa Prod. Chile",
				"Factura de ventas a empresas del territorio preferencial ( Res. Ex. N° 1057, del 25.04.85)"};

			for (int i = 0; i < tpo.length; i++) {
				if (inTpoDoc.equals(String.valueOf(tpo[i]))){
					out= tpoText[i];
				}
			}

		return out;
	}

}