
package Presentacion;

import Controlador.Main;
import Controlador.PeriodoVenta;
import java.util.Calendar;

public class JDFPeriodo extends javax.swing.JDialog {
    int numeroTerminal=0;
    String hoy="";

    public JDFPeriodo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        Parametros();
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
            
            //System.out.println(String.format("Fecha antes de la suuma de horas : %1$tY-%1$tm-%1$td",fecha.getTime()));
            jTextFechaApertura.setText(dia+"-"+mes+"-"+ano+" "+hora+":"+minuto+":"+segundo);
            fecha.add(Calendar.HOUR, 24);
            
            ano = "0000"+fecha.get(Calendar.YEAR);
            mes = "00"+fecha.get(Calendar.MONTH);
            dia = "00"+fecha.get(Calendar.DAY_OF_MONTH);
            hora = "00"+fecha.get(Calendar.HOUR_OF_DAY);
            minuto = "00"+fecha.get(Calendar.MINUTE);
            segundo = "00"+fecha.get(Calendar.SECOND);
            dia=dia.substring(dia.length()-2);
            mes=mes.substring(mes.length()-2);
            ano=ano.substring(ano.length()-4);
            hora=hora.substring(hora.length()-2);
            minuto=minuto.substring(minuto.length()-2);
            segundo=segundo.substring(segundo.length()-2);
            //System.out.println(String.format("He sumado 1200 horas y ahora tengo : %1$tY-%1$tm-%1$td",fecha.getTime()));
            jTextFechaCierre.setText(dia+"-"+mes+"-"+ano+" "+hora+":"+minuto+":"+segundo);
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
        jLabel2 = new javax.swing.JLabel();
        jTextFechaCierre = new javax.swing.JTextField();
        jBtnAbrir = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();

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

        jLabel2.setText("Fecha cierre:");

        jTextFechaCierre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFechaCierre.setEnabled(false);

        jBtnAbrir.setText("Abrir periodo");
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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
                    .addComponent(jLabel2)
                    .addComponent(jTextFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAbrirActionPerformed
        PeriodoVenta objPV = new PeriodoVenta(0, 0, numeroTerminal, jTextFechaApertura.getText(), jTextFechaCierre.getText(), "AB");
        objPV.GrabaPeriodo();
        this.dispose();
    }//GEN-LAST:event_jBtnAbrirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAbrir;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTerminal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFechaApertura;
    private javax.swing.JTextField jTextFechaCierre;
    // End of variables declaration//GEN-END:variables
}
