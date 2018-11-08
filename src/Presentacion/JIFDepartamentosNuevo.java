package Presentacion;

import Controlador.Departamentos;
import Conexion.Conexion;
import javax.swing.JOptionPane;

public class JIFDepartamentosNuevo extends javax.swing.JInternalFrame {

    public JIFDepartamentosNuevo() {
        initComponents();
        try {
            if(Departamentos.NuevoDepartamento==false){
                Departamentos objDep = new Departamentos(Departamentos.IdDepartamento, "");
                objDep.BuscarDepartamentoId();
                jTxtId.setText(""+objDep.getId());
                jTxtNombre.setText(""+objDep.getNombre());
            }else{
                jTxtId.setText("Automatico");
            }       
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtId = new javax.swing.JTextField();
        jBtnGrabar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Nuevo departamento");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel2.setText("Nombre:");

        jLabel1.setText("Id:");

        jTxtId.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jBtnGrabar.setText("Grabar");
        jBtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGrabarActionPerformed(evt);
            }
        });

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGrabar)
                    .addComponent(jBtnSalir))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGrabarActionPerformed
        // TODO add your handling code here:
        try {
            if(jTxtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe ingresar nombre del departamento");
            }else{
                int idDep=0;
                if(!Departamentos.NuevoDepartamento){
                    idDep=Integer.parseInt(jTxtId.getText());
                }
                //Valido que ne exista nombre repetido
                Departamentos objDep = new Departamentos(idDep, jTxtNombre.getText());
                if(Departamentos.NuevoDepartamento){
                    objDep.ExisteRegistroNombre();
                    if(Departamentos.ExisteDepartamento){
                        JOptionPane.showMessageDialog(null, "Nombre del departamento ya existe");
                        return;
                    }
                }
                //Grabo/Actualizo
                if(Departamentos.NuevoDepartamento){
                    objDep.Grabar();
                    jTxtNombre.setText(null);
                    jTxtNombre.requestFocus();
                }else{
                    objDep.Actualizar();
                    this.dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al grabar"+e);
        }
    }//GEN-LAST:event_jBtnGrabarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnGrabar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtId;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
