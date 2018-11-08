/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Seguridad.Encriptacion;
import Controlador.Usuarios;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author aldo
 */
public class JFrmPassword extends javax.swing.JFrame {

    /**
     * Creates new form JFrmPassword
     */
    public JFrmPassword() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    private void ValidarUser(){
        try {
            String sPassword = new String(jTxtPassword.getPassword()); //Convierto JPassword a string 
            if(this.jTxtUser.getText().isEmpty() || sPassword.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe ingresar datos de usuario");
                jTxtUser.requestFocus();
                return;
            }
            String Enc = Encriptacion.Encriptar(sPassword);
            Usuarios objUsu = new Usuarios(this.jTxtUser.getText(), Enc, "NN", 0, 0,"NN");
            objUsu.ExisteUsusario();
            if(!Usuarios.ExisteElUsuario){
                JOptionPane.showMessageDialog(null, "Usuario o Password incorrecta");
                jTxtUser.requestFocus();
                return;
            }else{
                JFrmMain objMenu = new JFrmMain();
                objMenu.toFront();
                objMenu.setVisible(true);
                Usuarios.UsuarioIniciado=this.jTxtUser.getText();
                this.dispose();
            }
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        jTxtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtPassword = new javax.swing.JPasswordField();
        jBtnAceptar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticación usuario");

        jLabel1.setText("User:");

        jTxtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtUser.setText("admin");
        jTxtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtUserKeyPressed(evt);
            }
        });

        jLabel2.setText("Password:");

        jTxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtPassword.setText("admin");
        jTxtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPasswordActionPerformed(evt);
            }
        });
        jTxtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtPasswordKeyPressed(evt);
            }
        });

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });
        jBtnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnAceptarKeyPressed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTxtUser)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jBtnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAceptar)
                    .addComponent(jBtnCancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPasswordActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
        //Valido que tengan datos
        ValidarUser();
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jTxtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtUserKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jTxtPassword.requestFocus();
        }
    }//GEN-LAST:event_jTxtUserKeyPressed

    private void jTxtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtPasswordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jBtnAceptar.requestFocus();
        }
    }//GEN-LAST:event_jTxtPasswordKeyPressed

    private void jBtnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnAceptarKeyPressed
        // TODO add your handling code here:
        ValidarUser();
    }//GEN-LAST:event_jBtnAceptarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jTxtPassword;
    private javax.swing.JTextField jTxtUser;
    // End of variables declaration//GEN-END:variables
}