
package Presentacion;

import Controlador.Main;
import Controlador.PeriodoVenta;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class JDFTurno extends javax.swing.JDialog {
    int numeroTerminal;
    String hoy;

    public JDFTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        Parametros();
        Periodo();
    }
    
    private void Periodo(){
        int periodo=0;
        PeriodoVenta objPV = new PeriodoVenta(0, 0, numeroTerminal, "", "", "");
        objPV.ConsultaPeriodo();
        periodo=objPV.getPeriodo();
        System.out.println("Periodo:"+periodo);
        if(periodo!=0){
            jTextPeriodo.setText(""+periodo);
        }else{
            jTextPeriodo.setText("0");
            jBtnAbrir.setEnabled(false);
        }
    }
    
    private void Parametros(){
        try {
            Main objPar = new Main();
            objPar.parametos();
            numeroTerminal=objPar.getNumeroTerminal();
            hoy=objPar.getFecha();
            jLabelTerminal.setText("Nro. Terminal: " +numeroTerminal+"  Fecha: "+hoy);
            
            //Sumando horas
            //Instancia a calendar
            Calendar fecha = Calendar.getInstance();
            
            String ano = "0000"+fecha.get(Calendar.YEAR);
            String mes = "00"+fecha.get(Calendar.MONTH);
            String dia = "00"+fecha.get(Calendar.DAY_OF_MONTH);
            String hora = "00"+fecha.get(Calendar.HOUR_OF_DAY);
            String minuto = "00"+fecha.get(Calendar.MINUTE);
            String segundo = "00"+fecha.get(Calendar.SECOND);
            dia=dia.substring(dia.length()-2);
            mes=mes.substring(mes.length()-2);
            ano=ano.substring(ano.length()-4);
            hora=hora.substring(hora.length()-2);
            minuto=minuto.substring(minuto.length()-2);
            segundo=segundo.substring(segundo.length()-2);
            
            jTextFechaApertura.setText(dia+"-"+mes+"-"+ano+" "+hora+":"+minuto+":"+segundo);            
        } catch (Exception e) {
            System.err.println("Error LeeParametros: "+e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTerminal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFechaApertura = new javax.swing.JTextField();
        jBtnAbrir = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextPeriodo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFondo = new javax.swing.JTextField();

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

        jLabel1.setText("Fecha apertura:");

        jTextFechaApertura.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFechaApertura.setEnabled(false);

        jBtnAbrir.setText("Abrir Turno");
        jBtnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAbrirActionPerformed(evt);
            }
        });

        jBtnCerrar.setText("Cerrar");
        jBtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCerrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Periodo:");

        jTextPeriodo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextPeriodo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextPeriodo.setEnabled(false);

        jLabel4.setText("Monto Fondo:");

        jTextFondo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFondoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFechaApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFechaApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAbrirActionPerformed
        try {
            if(!jTextFondo.getText().isEmpty()){
                PeriodoVenta objPV = new PeriodoVenta(0, 0, numeroTerminal, jTextFechaApertura.getText(), "", "AB");
                objPV.GrabaTurno();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Falta un dato requerido !!!");
                jTextFondo.requestFocus();
            }
                
        } catch (Exception e) {
            System.err.println("Error jBtnAbrirActionPerformed: "+e);
        }
    }//GEN-LAST:event_jBtnAbrirActionPerformed

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jTextFondoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFondoKeyTyped
        char car = evt.getKeyChar();
        if (((car < '0') || (car > '9'))) evt.consume();
    }//GEN-LAST:event_jTextFondoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAbrir;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTerminal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFechaApertura;
    private javax.swing.JTextField jTextFondo;
    private javax.swing.JTextField jTextPeriodo;
    // End of variables declaration//GEN-END:variables
}
