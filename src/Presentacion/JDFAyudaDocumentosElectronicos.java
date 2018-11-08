
package Presentacion;

import javax.swing.DefaultListModel;

public class JDFAyudaDocumentosElectronicos extends javax.swing.JDialog {
    
    int documento;
    int codigo;

    public JDFAyudaDocumentosElectronicos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(this);
        CargaDatos();
    }

    public int getDocumento() {
        return documento;
    }

    public int getCodigo() {
        return codigo;
    }
    
    private void CargaDatos(){
        DefaultListModel<String> model = new DefaultListModel<>();
        DefaultListModel<String> model2 = new DefaultListModel<>();
        
        String [] datos ={"030 Factura","032 Factura de ventas y servicios no afectos o excentos de IVA",
                  "033 Factura electrónica","034 Factura no afecta o exenta electrónica","035 Boleta",
                  "038 Boleta exenta","039 Boleta electrónica","040 Liquidación factura","041 Boleta exenta electrónica",
                  "043 Liquidación factura electrónica","045 Factura de compra","046 Factura de compra electrónica",
                  "048 Pago electrónico","050 Guía de despacho","052 Guía de despacho electrónica","055 Nota de débito",
                  "056 Nota de débito electrónica","060 Nota de crédito","061 Nota de crédito electrónica","103 Liquidación",
                  "110 Factura de exportación electrónica","111 Nota de débito de exportación electrónica","112 Nota de crédito de exportación electrónica",
                  "801 Orden de compra","802 Presupuesto","803 Contrato","804 Resolución","805 Proceso ChileCompra",
                  "806 Ficha ChileCompra","807 DUS","808 B/L (conocimiento de embarque)","809 AWB (Air Will Bill)",
                  "810 MIC/DTA","811 Carta de porte","812 Resolución del SNA donde califica servicios de exportación",
                  "813 Pasaporte","814 Certificado de depósito bolsa prod. Chile","815 Vale de prenda bolsa prod. Chile",
                  "914 Declaración de ingreso (DIN)"};
        
        for(int i=0;i<datos.length;i++){
            model.addElement(datos[i]);
        }
        jListAyuda.setModel(model);
        model2.addElement("0 Sin Código de Referencia");
        model2.addElement("1 Anula documento de Referencia");
        model2.addElement("2 Corrige Texto documento de Referencia");
        model2.addElement("3 Corrige Montos documento de Referencia");
        jListCodigos.setModel(model2);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAyuda = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCodigos = new javax.swing.JList<>();
        jBtnAcepta = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DOCUMENTOS CON CODIGO DEL S.I.I.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setViewportView(jListAyuda);

        jScrollPane2.setViewportView(jListCodigos);

        jBtnAcepta.setText("Aceptar");
        jBtnAcepta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptaActionPerformed(evt);
            }
        });

        jBtnSalir.setText("Cancelar");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnAcepta, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jBtnAcepta))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jBtnSalir)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        documento=0;
        codigo=0;
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jBtnAceptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptaActionPerformed
        try {
            String doc="0";
            if(jListAyuda.getSelectedIndex()>-1){
                doc =jListAyuda.getSelectedValue();
            }
            String cod ="0";
            if(jListCodigos.getSelectedIndex()>-1){
                cod =jListCodigos.getSelectedValue();
            }

            doc=doc.substring(0, 3);
            cod=cod.substring(0, 1);
            
            System.out.println("doc"+doc);
            System.out.println("cod"+cod);
            
            documento = Integer.parseInt(doc);
            codigo = Integer.parseInt(cod);
            this.dispose();
        } catch (Exception e) {
            System.out.println("Error jBtnAceptaActionPerformed: "+e);
        }
        
    }//GEN-LAST:event_jBtnAceptaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAcepta;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListAyuda;
    private javax.swing.JList<String> jListCodigos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
