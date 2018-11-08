/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Controlador.Compras;
import Controlador.Precios;
import Controlador.Productos;
import Controlador.Proveedores;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author aldo
 */
public class JIFCompras extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFCompras
     */
    public JIFCompras() {
        initComponents();
        DeshabilitaDetalle();
        HabilitaEncabezado();
    }
    
    private void HabilitaEncabezado(){
        jComboDocumento.setEnabled(true);
        jTxtFolio.setEnabled(true);
        jDate.setEnabled(true);
        jComboValor.setEnabled(true);
        jTxtId.setEnabled(true);
        jBtnAyudaProveedor.setEnabled(true);
        jBtnValidar.setEnabled(true);
    }
    
    private void DeshabilitaEncabezado(){
        jComboDocumento.setEnabled(false);
        jTxtFolio.setEnabled(false);
        jDate.setEnabled(false);
        jComboValor.setEnabled(false);
        jTxtId.setEnabled(false);
        jBtnAyudaProveedor.setEnabled(false);
        jBtnValidar.setEnabled(false);
    }
    
    private void HabilitaDetalle(){
        jTxtPlu.setEnabled(true);
        jTxtDescripcion.setEnabled(true);
        jTxtCantidad.setEnabled(true);
        jTxtCosto.setEnabled(true);
        jBtnAlta.setEnabled(true);
        jBtnGrabar.setEnabled(true);
        jBtnAyudaProductos.setEnabled(true);
    }
    
    private void DeshabilitaDetalle(){
        jTxtPlu.setEnabled(false);
        jTxtDescripcion.setEnabled(false);
        jTxtCantidad.setEnabled(false);
        jTxtCosto.setEnabled(false);
        jBtnAlta.setEnabled(false);
        jBtnGrabar.setEnabled(false);
        jBtnAyudaProductos.setEnabled(false);
    }
    
    private void LimpiaEncabezado(){
        jComboDocumento.setSelectedIndex(0);
        jTxtFolio.setText(null);
        jDate.setDate(null);
        jComboValor.setSelectedIndex(0);
        jTxtId.setText(null);
        jTxtNombre.setText(null);
        jTxtRUT.setText(null);
    }
    
    private void LimpiaDetalle(){
        jTxtPlu.setText(null);
        jTxtDescripcion.setText(null);
        jTxtCantidad.setText(null);
        jTxtCosto.setText(null);
        jTxtTotal.setText(null);
    }
    
    private void SubTotal(){
        double cant = 0;
        double cost = 0;
        jTxtTotal.setText("0");
        
        try {
            cant=Double.parseDouble(jTxtCantidad.getText());
            cost=Double.parseDouble(jTxtCosto.getText());
            double subTotal= cant*cost;
            jTxtTotal.setText(""+subTotal);
        } catch (Exception e) {
            System.err.println("Error SubTotal: "+e);
        }
    }
    
    private void BuscaProveedor(){
        try {
            Proveedores objPro = new Proveedores(Integer.parseInt(jTxtId.getText()),"","", "", "", "", "", "", "", "");
            objPro.BuscaProveedorId();
            if(!Proveedores.ExisteProveedor){
                JOptionPane.showMessageDialog(null, "Proveedor no existe !!!");
                jTxtNombre.setText(null);
                jTxtRUT.setText(null);
                jTxtId.requestFocus();
            }else{
                jTxtNombre.setText(objPro.getNombre());
                jTxtRUT.setText(objPro.getRut());
                jTxtPlu.requestFocus();
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.err.println("Error BuscaPproducto: "+e);
        }
    }
    
    private void BuscaProducto(){
        try {
            int plu=0;
            String ean="";
            if(jTxtPlu.getText().length()>7){
                ean=jTxtPlu.getText();
            }else{
                plu=Integer.parseInt(jTxtPlu.getText());
            }
               
            Productos objPro = new Productos(plu, 0, "", 0, 0, "", "", 0, ean);
            objPro.ConsultaProductoIdCodigoBarra();
            
            if(!Productos.ProductoExiste){
                JOptionPane.showMessageDialog(null, "Producto no existe !!!");
                
                jTxtDescripcion.setText(null);
                jTxtCantidad.setText(null);
                jTxtCosto.setText(null);
                jTxtTotal.setText(null);
                jTxtPlu.requestFocus();
            }else{
                jTxtPlu.setText(""+objPro.getId());
                jTxtDescripcion.setText(objPro.getNombre());
                Precios objPre = new Precios(Integer.parseInt(jTxtPlu.getText()), 0, 0, 0, 0);
                objPre.DamePrecios_Margenes();
                jTxtCosto.setText(""+objPre.getUltimo_costo());
                jTxtCantidad.setText("1");
                jTxtTotal.setText(jTxtCosto.getText());
                jTxtCantidad.requestFocus();
            }
        } catch (NumberFormatException e) {
            System.err.println("Error BuscaProducto: "+e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboDocumento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTxtFolio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtId = new javax.swing.JTextField();
        jBtnAyudaProveedor = new javax.swing.JButton();
        jTxtNombre = new javax.swing.JTextField();
        jTxtRUT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboValor = new javax.swing.JComboBox<>();
        jBtnValidar = new javax.swing.JButton();
        jDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTxtPlu = new javax.swing.JTextField();
        jTxtDescripcion = new javax.swing.JTextField();
        jTxtCantidad = new javax.swing.JTextField();
        jTxtCosto = new javax.swing.JTextField();
        jTxtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jBtnGrabar = new javax.swing.JButton();
        jBtnAlta = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jBtnAyudaProductos = new javax.swing.JButton();

        setClosable(true);
        setTitle("Compras");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setText("Documento");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(12, 11, 70, 15);

        jComboDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEL", "FEE", "FAC", "FAC", "NCE", "NCR" }));
        jPanel2.add(jComboDocumento);
        jComboDocumento.setBounds(90, 10, 56, 24);

        jLabel2.setText("Folio");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(140, 11, 30, 15);

        jTxtFolio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtFolio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFolioFocusLost(evt);
            }
        });
        jTxtFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFolioActionPerformed(evt);
            }
        });
        jTxtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFolioKeyTyped(evt);
            }
        });
        jPanel2.add(jTxtFolio);
        jTxtFolio.setBounds(170, 10, 76, 19);

        jLabel3.setText("Fecha");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(250, 11, 40, 15);

        jLabel4.setText("Proveedor");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(12, 40, 70, 15);

        jTxtId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtIdFocusLost(evt);
            }
        });
        jTxtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtIdKeyTyped(evt);
            }
        });
        jPanel2.add(jTxtId);
        jTxtId.setBounds(90, 40, 44, 19);

        jBtnAyudaProveedor.setText("jButton1");
        jBtnAyudaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAyudaProveedorActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnAyudaProveedor);
        jBtnAyudaProveedor.setBounds(140, 39, 28, 25);

        jTxtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtNombre.setEnabled(false);
        jPanel2.add(jTxtNombre);
        jTxtNombre.setBounds(270, 40, 170, 19);

        jTxtRUT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtRUT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTxtRUT.setEnabled(false);
        jPanel2.add(jTxtRUT);
        jTxtRUT.setBounds(170, 40, 90, 19);

        jLabel10.setText("V.Neto");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(410, 11, 40, 15);

        jComboValor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jComboValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboValorActionPerformed(evt);
            }
        });
        jPanel2.add(jComboValor);
        jComboValor.setBounds(460, 10, 49, 24);

        jBtnValidar.setText("Validar");
        jBtnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnValidarActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnValidar);
        jBtnValidar.setBounds(450, 39, 80, 25);
        jPanel2.add(jDate);
        jDate.setBounds(300, 10, 90, 19);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 540, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setEnabled(false);
        jPanel3.setLayout(null);

        jLabel5.setText("PLU");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(12, 5, 40, 15);

        jLabel6.setText("Descripción");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(73, 5, 80, 15);

        jLabel7.setText("Cantidad");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(317, 5, 50, 15);

        jLabel8.setText("Costo");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(377, 5, 40, 15);

        jLabel9.setText("Total");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(470, 5, 40, 15);

        jTxtPlu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtPlu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtPluFocusLost(evt);
            }
        });
        jTxtPlu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtPluKeyTyped(evt);
            }
        });
        jPanel3.add(jTxtPlu);
        jTxtPlu.setBounds(12, 22, 55, 19);
        jPanel3.add(jTxtDescripcion);
        jTxtDescripcion.setBounds(100, 22, 230, 19);

        jTxtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCantidadFocusLost(evt);
            }
        });
        jPanel3.add(jTxtCantidad);
        jTxtCantidad.setBounds(334, 22, 54, 19);

        jTxtCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtCosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCostoFocusLost(evt);
            }
        });
        jPanel3.add(jTxtCosto);
        jTxtCosto.setBounds(392, 22, 72, 19);

        jTxtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtTotal.setEnabled(false);
        jPanel3.add(jTxtTotal);
        jTxtTotal.setBounds(470, 22, 63, 19);

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProductos);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(12, 48, 520, 126);

        jBtnGrabar.setText("Grabar");
        jPanel3.add(jBtnGrabar);
        jBtnGrabar.setBounds(12, 180, 103, 25);

        jBtnAlta.setText("Dar Alta");
        jPanel3.add(jBtnAlta);
        jBtnAlta.setBounds(121, 180, 103, 25);

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnSalir);
        jBtnSalir.setBounds(339, 180, 103, 25);

        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnLimpiar);
        jBtnLimpiar.setBounds(230, 180, 103, 25);

        jBtnAyudaProductos.setText("jButton1");
        jBtnAyudaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAyudaProductosActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnAyudaProductos);
        jBtnAyudaProductos.setBounds(70, 20, 25, 25);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, 542, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 588, 374);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFolioActionPerformed

    private void jBtnAyudaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAyudaProveedorActionPerformed
        try {
            JDFAyudaProveedores objAyu =new JDFAyudaProveedores(null,true);
            objAyu.setVisible(true);
            
            int id=objAyu.getIdProveedor();
            System.out.println(id);
            if(id!=0){
                jTxtId.setText(""+id);
                BuscaProveedor();
            }else{
                jTxtId.setText(null);
                jTxtId.requestFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnAyudaProveedorActionPerformed

    private void jTxtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtIdFocusLost
        if(!jTxtId.getText().isEmpty()){
            BuscaProveedor();
        }
    }//GEN-LAST:event_jTxtIdFocusLost

    private void jTxtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtIdKeyTyped
        char car = evt.getKeyChar();
        if (((car < '0') || (car > '9'))) evt.consume();
    }//GEN-LAST:event_jTxtIdKeyTyped

    private void jTxtFolioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFolioKeyTyped
        char car = evt.getKeyChar();
        if (((car < '0') || (car > '9'))) evt.consume();
    }//GEN-LAST:event_jTxtFolioKeyTyped

    private void jTxtFolioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFolioFocusLost
        if(jTxtFolio.getText().isEmpty() || Integer.parseInt(jTxtFolio.getText())==0){
            JOptionPane.showMessageDialog(null, "Debe ingresar folio !!!");
        }
    }//GEN-LAST:event_jTxtFolioFocusLost

    private void jComboValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboValorActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jBtnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnValidarActionPerformed
        // Pregunto que tenga todos los datos ingresaados
        if(jTxtFolio.getText().isEmpty() || Integer.parseInt(jTxtFolio.getText())==0 || jTxtId.getText().isEmpty() || jTxtRUT.getText().isEmpty() || jTxtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Faltan datos requeridos !!!");
            jComboDocumento.requestFocus();
            return;
        }
        
        //BUSCO SI EL DOCUMENTO ESTA INGRESADO
        Compras objCom = new Compras(jComboDocumento.getSelectedItem().toString(), Integer.parseInt(jTxtFolio.getText()), Integer.parseInt(jTxtId.getText()));
        String estado=objCom.EstadoCompra();
        //NE = No existe
        //EC = Existe Cerrado
        //EA = Existe Abierto
        //EE = Error
        
        if("EE".equals(estado)){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al consultar !!!");
            jComboDocumento.requestFocus();
            return;
        }
        if("NE".equals(estado)){
            int opt = JOptionPane.showConfirmDialog(null, "Factura de compra no existe\nDesea ingresarla", "Compra", 0);
            System.out.println("opt: "+opt);
            if(opt==1){ //NO
                jComboDocumento.requestFocus();
                return;
            }
            if(opt==0){ //SI
                HabilitaDetalle();
                jTxtPlu.requestFocus();
                DeshabilitaEncabezado();
                //VALIDO
            }
        }
        if("EC".equals(estado)){
            JOptionPane.showMessageDialog(null, "Documento ya ingresado y dado de alta !!!");
            jComboDocumento.requestFocus();
            return;
        }
        if("EA".equals(estado)){
            JOptionPane.showMessageDialog(null, "Documento ingresado, listo para edición !!!");
            HabilitaDetalle();
            DeshabilitaEncabezado();
            jTxtPlu.requestFocus();
        }
    }//GEN-LAST:event_jBtnValidarActionPerformed

    private void jBtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Seguro de limpiar datos ingresados", "Limpiar", 0);
        System.out.println("opt: "+opt);
        if(opt==1){ //NO
            return;
        }
        HabilitaEncabezado();
        DeshabilitaDetalle();
        LimpiaEncabezado();
        LimpiaDetalle();
    }//GEN-LAST:event_jBtnLimpiarActionPerformed

    private void jTxtPluFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtPluFocusLost
        if(!jTxtPlu.getText().isEmpty()){
            BuscaProducto();
        }
    }//GEN-LAST:event_jTxtPluFocusLost

    private void jTxtPluKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtPluKeyTyped
        char car = evt.getKeyChar();
        if (((car < '0') || (car > '9'))) evt.consume();
    }//GEN-LAST:event_jTxtPluKeyTyped

    private void jBtnAyudaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAyudaProductosActionPerformed
        try {
            JDFAyudaProductos objPro =new JDFAyudaProductos(null,true);
            objPro.setVisible(true);
            
            int id=objPro.getIdProducto();
            System.out.println(id);
            if(id!=0){
                jTxtPlu.setText(""+id);
                BuscaProducto();
            }else{
                jTxtPlu.setText(null);
                jTxtPlu.requestFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnAyudaProductosActionPerformed

    private void jTxtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCantidadFocusLost
        SubTotal();
    }//GEN-LAST:event_jTxtCantidadFocusLost

    private void jTxtCostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCostoFocusLost
        SubTotal();
    }//GEN-LAST:event_jTxtCostoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlta;
    private javax.swing.JButton jBtnAyudaProductos;
    private javax.swing.JButton jBtnAyudaProveedor;
    private javax.swing.JButton jBtnGrabar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JButton jBtnValidar;
    private javax.swing.JComboBox<String> jComboDocumento;
    private javax.swing.JComboBox<String> jComboValor;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTxtCantidad;
    private javax.swing.JTextField jTxtCosto;
    private javax.swing.JTextField jTxtDescripcion;
    private javax.swing.JTextField jTxtFolio;
    private javax.swing.JTextField jTxtId;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtPlu;
    private javax.swing.JTextField jTxtRUT;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
