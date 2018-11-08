package Presentacion;

import Controlador.Departamentos;
import Controlador.Ean;
import Controlador.Productos;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFProductos extends javax.swing.JInternalFrame {

    public JIFProductos() {
        initComponents();
        
        //Lleno combo departamentos
        try {
            Departamentos objDep = new Departamentos();
            ArrayList<Departamentos> objLis = new ArrayList<Departamentos>();
            objLis = objDep.Combo();
            for(int i=0; i<objLis.size() ;i++)
                jComboDepartamento.addItem(
                                   new Departamentos(
                                   objLis.get(i).getId(),
                                   objLis.get(i).getNombre()));            
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboDepartamento = new javax.swing.JComboBox<>();
        jCheckActivo = new javax.swing.JCheckBox();
        jBtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jBtnNuevo = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnExportar = new javax.swing.JButton();
        jBtnEan = new javax.swing.JButton();

        setClosable(true);
        setTitle("Productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        jLabel1.setText("Id");

        jLabel2.setText("Nombre");

        jLabel3.setText("Departamento");

        jCheckActivo.setSelected(true);
        jCheckActivo.setText("Activo");

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckActivo)
                    .addComponent(jBtnBuscar))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProductos);

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

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnExportar.setText("Exportar");

        jBtnEan.setText("Asocia EAN");
        jBtnEan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnSalir)
                    .addComponent(jBtnExportar)
                    .addComponent(jBtnEan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        try {
            int id=0;
            if(!jTxtId.getText().isEmpty()){id=Integer.parseInt(jTxtId.getText());}
            
            String nombre=jTxtNombre.getText();
            int dep_id=0;
            if(jComboDepartamento.getSelectedIndex()>0){dep_id=jComboDepartamento.getItemAt(jComboDepartamento.getSelectedIndex()).getId();}
            int activo=0;
            if(jCheckActivo.isSelected()){activo=1;}
            Productos objPro = new Productos(id, dep_id, nombre, 0, 0, "", "",activo,"");
            DefaultTableModel model = new DefaultTableModel();
            model=objPro.BuscaProducto();
            jTableProductos.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        try {
            Productos.ProductoNuevo=true;
            JIFProductosNuevo objPro = new JIFProductosNuevo();
            JFrmMain.jDPMain.add(objPro);
            Dimension desktopSize = JFrmMain.jDPMain.getSize();
            Dimension FrameSize = objPro.getSize(); 
            objPro.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            objPro.toFront();
            objPro.setVisible(true);            
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel objTab = (DefaultTableModel)this.jTableProductos.getModel();
            int i=jTableProductos.getSelectedRow();
            if(i==-1){
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto para editarlo");
            }else{
                Productos.IdProducto= Integer.parseInt(String.valueOf(jTableProductos.getValueAt(i,0)));
                Productos.ProductoNuevo=false;

                JIFProductosNuevo objPro =new JIFProductosNuevo();
                JFrmMain.jDPMain.add(objPro);

                Dimension desktopSize = JFrmMain.jDPMain.getSize();
                Dimension FrameSize = objPro.getSize(); 
                objPro.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                objPro.toFront();
                objPro.setVisible(true);
            }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnEanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEanActionPerformed
        try {
            //DefaultTableModel objTEan = (DefaultTableModel)this.jTableProductos.getModel();
            int i=jTableProductos.getSelectedRow();
            if(i==-1){
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto para asociar Ean");
            }else{
                Productos.IdProducto= Integer.parseInt(String.valueOf(jTableProductos.getValueAt(i,0)));
                //Productos.ProductoNuevo=false;

                JIFProductosEan objEan = new JIFProductosEan();
                JFrmMain.jDPMain.add(objEan);

                Dimension desktopSize = JFrmMain.jDPMain.getSize();
                Dimension FrameSize = objEan.getSize(); 
                objEan.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                objEan.toFront();
                objEan.setVisible(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnEanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEan;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExportar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JCheckBox jCheckActivo;
    private javax.swing.JComboBox<Departamentos> jComboDepartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTxtId;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
