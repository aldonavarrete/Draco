package Presentacion;

import Conexion.Conexion;
import Controlador.Perfiles;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFPerfiles extends javax.swing.JInternalFrame {

    public JIFPerfiles() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtNombreB = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePerfiles = new javax.swing.JTable();
        jBtnSalir = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setClosable(true);
        setTitle("Perfiles");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar ..."));

        jLabel1.setText("Nombre");

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNombreB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jTxtNombreB)
                .addComponent(jBtnBuscar))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Perfiles"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jBtnNuevo.setText("Nuevo");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jTablePerfiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablePerfiles);

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
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnSalir))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        try {
            String nombre=jTxtNombreB.getText();
            Perfiles objPer = new Perfiles(0,  nombre);
            DefaultTableModel model = new DefaultTableModel();
            model=objPer.Buscar();
            jTablePerfiles.setModel(model);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        try {
            DefaultTableModel objTab = (DefaultTableModel)this.jTablePerfiles.getModel();
            int i=jTablePerfiles.getSelectedRow();
            if(i==-1){
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un perfil para eliminarlo");
            }else{
                int msg=JOptionPane.showConfirmDialog(null, "Seguro de eliminar perfil", "Elimina perfil",0);
                if (msg==JOptionPane.YES_OPTION){
                    int IdPer =0;
                    IdPer = Integer.parseInt(String.valueOf(jTablePerfiles.getValueAt(i,0)));
                    Perfiles objPer = new Perfiles( IdPer, "");
                    objPer.Eliminar();
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        try {
            Perfiles.NuevoPerfil=true;
            JIFPerfilesNuevo objNue = new JIFPerfilesNuevo();
            JFrmMain.jDPMain.add(objNue);
            Dimension desktopSize = JFrmMain.jDPMain.getSize();
            Dimension FrameSize = objNue.getSize(); 
            objNue.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            objNue.toFront();
            objNue.setVisible(true);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        try {
            DefaultTableModel objTab = (DefaultTableModel)this.jTablePerfiles.getModel();
            int i=jTablePerfiles.getSelectedRow();
            if(i==-1){
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un perfil para editarlo");
            }else{
                Perfiles.IdPerfil = Integer.parseInt(String.valueOf(jTablePerfiles.getValueAt(i,0)));
                Perfiles.NuevoPerfil=false;
                JIFPerfilesNuevo objPer = new JIFPerfilesNuevo();
                JFrmMain.jDPMain.add(objPer);
                Dimension desktopSize = JFrmMain.jDPMain.getSize();
                Dimension FrameSize = objPer.getSize(); 
                objPer.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                objPer.toFront();
                objPer.setVisible(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePerfiles;
    private javax.swing.JTextField jTxtNombreB;
    // End of variables declaration//GEN-END:variables
}
