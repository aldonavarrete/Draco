package Controlador;

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
    
    public void CreaXML(){
        //Consulto Venta
        Venta objVen = new Venta(codigoDocumento, folio, 0, "", 0, null, null);
        objVen.ConsultaVenta();
        
        
            
           
            
            
            
        

        
    }
    
    

}
