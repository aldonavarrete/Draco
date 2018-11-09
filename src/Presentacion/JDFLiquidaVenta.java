
package Presentacion;

import Controlador.Clientes;
import Controlador.Main;
import Controlador.Venta;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class JDFLiquidaVenta extends javax.swing.JDialog {
    
    private boolean liquida=false;
    
    private int codigoDocumento;
    private int idCliente;
    private DefaultTableModel tablaReferencia;
    
    private DefaultTableModel tabla;
    private final String nombreColumnas [] ={"Doc","Folio","Fecha","Cod","Observación"};
    private final String datos [][] ={};
    private DefaultTableCellRenderer tcr;
    
    
    public JDFLiquidaVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        Configura();
        ArmaTabla();
    }

    public boolean isLiquida() {
        return liquida;
    }

    public int getCodigoDocumento() {
        return codigoDocumento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public DefaultTableModel getTablaReferencia() {
        return tablaReferencia;
    }
    
    private void Configura(){
        try {
            String fecha;
            Main objPar = new Main();
            objPar.parametos();
            fecha=objPar.getFecha();
            jTextFecha.setText(fecha);
            jTextTotal.setText(""+Venta.totalventa);
            
            jDate.setDate(objPar.ParseFecha(fecha));
            
        } catch (Exception e) {
            System.err.println("Error Configura: "+e);
        }        
    }
    
    private void ArmaTabla(){
        tabla=new DefaultTableModel(datos, nombreColumnas);
        jTableReferencia.setModel(tabla);
        //Ancho de columna
        TableColumnModel columnModel = jTableReferencia.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(35);
        columnModel.getColumn(1).setPreferredWidth(60);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(25);
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jTableReferencia.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jTableReferencia.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jTableReferencia.getColumnModel().getColumn(3).setCellRenderer(tcr);    
    }
    
    private void BuscaCliente(){
        //JOptionPane.showMessageDialog(null, "Buscando");
        if(!jTextId.getText().isEmpty()){
            Clientes objCli = new Clientes(Integer.parseInt(jTextId.getText()), "", "", "", "", "", "", 1);
            objCli.BuscaClienteId();
            if(!Clientes.ExisteRUTCliente){
                JOptionPane.showMessageDialog(null, "cliente no existe !!!");
                jTextNombre.setText(null);
                jTextRUT.setText(null);
                jTextId.requestFocus();
            }else{
                int estado=objCli.getActivo();
                jTextNombre.setText(objCli.getNombre());
                jTextRUT.setText(objCli.getRut());
                if(estado==0){
                    JOptionPane.showMessageDialog(null, "Cliente esta bloqueado !!!");
                    jTextId.requestFocus();
                }else{
                    jTextDocumento.requestFocus();
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelTerminal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboDocumento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextRUT = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBtnAyudaCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextDocumento = new javax.swing.JTextField();
        jTextFolio = new javax.swing.JTextField();
        jTextCodigo = new javax.swing.JTextField();
        jTextObservacion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReferencia = new javax.swing.JTable();
        jBtnOk = new javax.swing.JButton();
        jBtnAyuda = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jBtnGenerar = new javax.swing.JButton();
        jBtnVolver = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTerminal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTerminal.setText("Nro.Terminal:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelTerminal)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTerminal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Documento:");

        jComboDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "39 Boleta Electrónica", "33 Factura Electrónica", "61 Nota de Crédito Electrónica", "56 Nota de Debito" }));

        jLabel2.setText("Fecha:");

        jTextFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFecha.setEnabled(false);

        jLabel3.setText("Total:");

        jTextTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Cód. Cliente:");

        jTextId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextIdFocusLost(evt);
            }
        });
        jTextId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdActionPerformed(evt);
            }
        });

        jLabel5.setText("RUT Cliente:");

        jTextRUT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextRUT.setEnabled(false);

        jTextNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextNombre.setEnabled(false);

        jLabel6.setText("Razón Social:");

        jBtnAyudaCliente.setText("...");
        jBtnAyudaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAyudaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(jTextNombre))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAyudaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextRUT, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAyudaCliente)
                    .addComponent(jLabel5)
                    .addComponent(jTextRUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextDocumentoFocusLost(evt);
            }
        });

        jTableReferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableReferencia);

        jBtnOk.setText("Ok");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        jBtnAyuda.setText("Ayuda");
        jBtnAyuda.setEnabled(false);
        jBtnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAyudaActionPerformed(evt);
            }
        });

        jLabel10.setText("Doc    Folio        Fecha                Cd   Observación              OK   ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jBtnAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(114, 114, 114)
                            .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)))
                    .addComponent(jLabel10))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAyuda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFolio.getAccessibleContext().setAccessibleName("");

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnGenerar.setText("Generar");
        jBtnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGenerarActionPerformed(evt);
            }
        });

        jBtnVolver.setText("Volver");
        jBtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtnGenerar)
                .addComponent(jBtnVolver))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVolverActionPerformed
        liquida=false;
        this.dispose();
    }//GEN-LAST:event_jBtnVolverActionPerformed

    private void jBtnAyudaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAyudaClienteActionPerformed
        JDFAyudaClientes objAyu =new JDFAyudaClientes(null,true);
        objAyu.setVisible(true);

        int id=objAyu.getIdCliente();
        System.out.println(id);
        if(id!=0){
            jTextId.setText(""+id);
            BuscaCliente();
        }else{
            jTextId.setText(null);
            jTextId.requestFocus();
        }
    }//GEN-LAST:event_jBtnAyudaClienteActionPerformed

    private void jTextIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdActionPerformed
        if(!jTextId.getText().isEmpty()){
            BuscaCliente();
        }
    }//GEN-LAST:event_jTextIdActionPerformed

    private void jTextIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextIdFocusLost
        if(!jTextId.getText().isEmpty()){
            BuscaCliente();
        }
    }//GEN-LAST:event_jTextIdFocusLost

    private void jTextDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextDocumentoFocusGained
        jBtnAyuda.setEnabled(true);
    }//GEN-LAST:event_jTextDocumentoFocusGained

    private void jBtnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAyudaActionPerformed
        try {
            JDFAyudaDocumentosElectronicos objAyu = new JDFAyudaDocumentosElectronicos(null, true);
            objAyu.setVisible(true);
            int doc = objAyu.getDocumento();
            int cod = objAyu.getCodigo();
            if(doc>0){
                jTextDocumento.setText(""+doc);
            }
            if(cod>0){
                jTextCodigo.setText(""+cod);
            }
            jTextDocumento.requestFocus();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jBtnAyudaActionPerformed

    private void jTextDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextDocumentoFocusLost
        //jBtnAyuda.setEnabled(false);
    }//GEN-LAST:event_jTextDocumentoFocusLost

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        try {
            if(jTextDocumento.getText().isEmpty() || jTextFolio.getText().isEmpty() || jTextCodigo.getText().isEmpty() || jTextObservacion.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Faltan datos requeridos !!!");
                jTextDocumento.requestFocus();
            }else{
                //{"Doc","Folio","Fecha","Cod","Observación"};
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

                String Fecha= formato.format(jDate.getDate());


                String matriz[]={jTextDocumento.getText(),jTextFolio.getText(),Fecha,jTextCodigo.getText(),jTextObservacion.getText()};
                tabla.addRow(matriz);

                jTextDocumento.setText(null);
                jTextFolio.setText(null);
                jTextCodigo.setText(null);
                jTextObservacion.setText(null);
                jTextDocumento.requestFocus();
            }
        } catch (Exception e) {
            System.err.println("Error jBtnOkActionPerformed: "+e);
        }
        
    }//GEN-LAST:event_jBtnOkActionPerformed

    private void jBtnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGenerarActionPerformed
        // Valido
        // 39 No requiere nada
        // 33 Requiere ciente
        // 61 y 56 Requiere cliente y Referencia
        boolean Sigue=true;
        
        try {
            String IdDocumento = jComboDocumento.getSelectedItem().toString().substring(0, 2);
            if(IdDocumento.equals("33")){
                //Factura electronica
                if(jTextId.getText().isEmpty() || jTextNombre.getText().isEmpty() || jTextRUT.getText().isEmpty()){
                    Sigue=false;
                }
            }
            if(IdDocumento.equals("61") || IdDocumento.equals("56") ){
                //Nota de credit
                if(jTextId.getText().isEmpty() || jTextNombre.getText().isEmpty() || jTextRUT.getText().isEmpty()){
                    Sigue=false;
                }
                if(jTableReferencia.getRowCount()==0){
                    Sigue=false;
                }
            }
            System.out.println("Colum:"+jTableReferencia.getRowCount());

            if(!Sigue){
                JOptionPane.showMessageDialog(null, "Faltan Datos requeridos !!!");
                jTextId.requestFocus();
            }else{
                //Traspaso datos a variables
                codigoDocumento=Integer.parseInt(IdDocumento);
                idCliente=0;
                if(!jTextId.getText().isEmpty()){idCliente=Integer.parseInt(jTextId.getText());}
                
                //tablaVenta.addTableModelListener(jTableReferencia);
                
                tablaReferencia = (DefaultTableModel) jTableReferencia.getModel();
                
                liquida=true;
                this.dispose();
            }
        } catch (Exception e) {
            System.err.println("Error jBtnGenerarActionPerformed: "+e);
        }
        
        
        
        
    }//GEN-LAST:event_jBtnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAyuda;
    private javax.swing.JButton jBtnAyudaCliente;
    private javax.swing.JButton jBtnGenerar;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JButton jBtnVolver;
    private javax.swing.JComboBox<String> jComboDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTerminal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableReferencia;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextDocumento;
    private javax.swing.JTextField jTextFecha;
    private javax.swing.JTextField jTextFolio;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextObservacion;
    private javax.swing.JTextField jTextRUT;
    private javax.swing.JTextField jTextTotal;
    // End of variables declaration//GEN-END:variables
}
