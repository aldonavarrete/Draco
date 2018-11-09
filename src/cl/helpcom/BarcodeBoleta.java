package cl.helpcom;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.itextpdf.text.pdf.BarcodePDF417;

public class BarcodeBoleta {

/**
 * Genera Codigo PDF417 cumpliendo con normativa de SII
 * 
 * @param ted Parametro de entrada TED
 * @param out ruta de salida
 * @throws IOException
 */
public void crearPDF417_png(String ted,String out) throws IOException {
	
	BarcodePDF417 barcode = new BarcodePDF417();
   	barcode.setCodeRows(5);
   	barcode.setCodeColumns(18);
   	barcode.setErrorLevel(5);
   	barcode.setLenCodewords(999);
   	barcode.setOptions(BarcodePDF417.PDF417_FORCE_BINARY);
   	barcode.setText(ted.getBytes("ISO-8859-1"));
    java.awt.Image img = barcode.createAwtImage(Color.BLACK, Color.WHITE);
    img.getScaledInstance(184, 172,0);
    BufferedImage outImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
    outImage.getGraphics().drawImage(img, 0, 0, null);
    ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
    ImageIO.write(outImage, "png", bytesOut);
    bytesOut.flush();
    byte[] pngImageData = bytesOut.toByteArray();
    FileOutputStream fos = new FileOutputStream(out);
    fos.write(pngImageData);
    fos.flush();
    fos.close();
	
}


}
