
package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeeCAF {
    
    private String rutEmpresa;
    private String XML;
    
    private String fecha;
    private int rInicial;
    private int rFinal;
    private int tipo;
    private String razonSocial;
    private String rut;

    public LeeCAF() {
    }

    public LeeCAF(String rutEmpresa, String XML) {
        this.rutEmpresa = rutEmpresa;
        this.XML = XML;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public int getrInicial() {
        return rInicial;
    }

    public int getrFinal() {
        return rFinal;
    }

    public int getTipo() {
        return tipo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getRut() {
        return rut;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
    
    public void LeeXML() throws SAXException, IOException, ParserConfigurationException{
        
        fecha="";
        rInicial=0;
        rFinal=0;
        tipo=0;
        razonSocial="";
        rut="";

        XML= System.getProperty("user.home")+File.separator+".local"+File.separator+"caf"+File.separator+XML;
        File file = new File(XML);

        DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder db2 = dbf2.newDocumentBuilder();
        Document doc2 = db2.parse(file);
        doc2.getDocumentElement().normalize();

        //AQUI SE GUARDA EL PEDAZO DEL TAGS
        NodeList nodeLst2 = doc2.getElementsByTagName("CAF");

        //SE CREA UN ARRAYLIST PARA GUARDAR DATOS DEL CAF EN TU CASO
        ArrayList<String> arrayIdDoc = new ArrayList<String>();

        try {

            int i = 0;
            Element doc = (Element) nodeLst2.item(i);

            //AQUI SE ACCEDE A LOS NODOS INTERNOS EN TU CASO RE,TD,RNG, ETC
            try {
                //NODO DE RUT EMPRESA
                NodeList REmElmntLst = doc.getElementsByTagName("RE");
                Element REmElmnt = (Element) REmElmntLst.item(0);
                NodeList NodeRE = REmElmnt.getChildNodes();
                arrayIdDoc.add(((org.w3c.dom.Node) NodeRE.item(0)).getNodeValue());

                //NODO DE RAZON SOCIAL
                NodeList RSmElmntLst = doc2.getElementsByTagName("RS");
                Element RSmElmnt = (Element) RSmElmntLst.item(0);
                NodeList RS = RSmElmnt.getChildNodes();
                arrayIdDoc.add(((org.w3c.dom.Node) RS.item(0)).getNodeValue());

                //NODO DE TIPO DE DOCUMENTO
                NodeList TDmElmntLst = doc.getElementsByTagName("TD");
                Element TDmElmnt = (Element) TDmElmntLst.item(0);
                NodeList TD = TDmElmnt.getChildNodes();
                arrayIdDoc.add(((org.w3c.dom.Node) TD.item(0)).getNodeValue());

                //NODO DEL RANGO INICIAL DEL FOLIO
                NodeList DmElmntLst = doc.getElementsByTagName("D");
                Element DmElmnt = (Element) DmElmntLst.item(0);
                NodeList D = DmElmnt.getChildNodes();
                arrayIdDoc.add(((org.w3c.dom.Node) D.item(0)).getNodeValue());

                //NODO DEL RANGO FINAL DEL FOLIO
                NodeList HmElmntLst = doc.getElementsByTagName("H");
                Element HmElmnt = (Element) HmElmntLst.item(0);
                NodeList H = HmElmnt.getChildNodes();
                arrayIdDoc.add(((org.w3c.dom.Node) H.item(0)).getNodeValue());

                //NODO DE LA FECHA
                NodeList FAmElmntLst = doc.getElementsByTagName("FA");
                Element FAmElmnt = (Element) FAmElmntLst.item(0);
                NodeList FA = FAmElmnt.getChildNodes();
                arrayIdDoc.add(((org.w3c.dom.Node) FA.item(0)).getNodeValue());

                System.out.println("Fecha:" + FA.item(i).getNodeValue());
                System.out.println("Rango final :" + H.item(i).getNodeValue());
                System.out.println("Rango Inicial:" + D.item(i).getNodeValue());
                System.out.println("TIPO DE DOCUMENTE:" + TD.item(i).getNodeValue());
                System.out.println("RAZON SOCIAL:" + RS.item(i).getNodeValue());
                System.out.println("RUT:" + NodeRE.item(i).getNodeValue());

                if(!rutEmpresa.equals(NodeRE.item(i).getNodeValue())){
                    JOptionPane.showMessageDialog(null, "CAF corresponde a otro contribuyente !!!");
                }else{
                    fecha=FA.item(i).getNodeValue();
                    rInicial=Integer.parseInt(D.item(i).getNodeValue());
                    rFinal=Integer.parseInt(H.item(i).getNodeValue());
                    tipo=Integer.parseInt(TD.item(i).getNodeValue());
                    razonSocial=RS.item(i).getNodeValue();
                    rut=NodeRE.item(i).getNodeValue();
                }

            } catch (Exception E) {
                arrayIdDoc.add("SDF");
            }

        } catch (Exception e) {
            System.out.println("Se leyó Mal algun archivo del XML: " + e.getMessage());
        }

        
          
    }
    
}
