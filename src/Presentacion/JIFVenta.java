
package Presentacion;

import Controlador.Folios;
import Controlador.Main;
import Controlador.PeriodoVenta;
import Controlador.Precios;
import Controlador.Productos;
import Controlador.Usuarios;
import Controlador.Venta;
import Controlador.XML;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class JIFVenta extends javax.swing.JInternalFrame {
    
    private String fecha;
    private int numeroTerminal;
    private int numeroPeriodo;
    private int numeroTurno;
    private String nombreEmpresa;
    private String rutEmpresa;
    private String nombreFantasiaEmpresa;
    
    private DefaultTableModel tabla;
    private final String nombreColumnas [] ={"C.Barra","PLU","Descripción","Uni.","Cantidad","Precio","SubTotal"};
    private final String datos [][] ={};
    private DefaultTableCellRenderer tcr;
    
    public JIFVenta() {
        initComponents();
        LeeParametros();
        ConstruyeTabla();
        ConsultaPeriodo();
        ConsultaTurno();
        ValidoInicio();
    }
    
    private void ValidoInicio(){
        if(numeroPeriodo==0 || numeroTurno==0){
            jTextCodigo.setEnabled(false);
            jBtnLiquidar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Error apertura de Periodo de ventas !!!/nDebe reiniciar ventas");
        }else{
            jLabelTerminal.setText("Terminal:" +numeroTerminal+" Tur:"+numeroTurno+" Per:"+numeroPeriodo+" Fecha:"+fecha+" Cajero:"+Usuarios.UsuarioIniciado+" Empresa:"+nombreFantasiaEmpresa+" RUT: "+rutEmpresa);
        }
    }
    
    private void ConstruyeTabla(){
        tabla=new DefaultTableModel(datos, nombreColumnas);
        jTableProductos.setModel(tabla);
        //Ancho de columna
        TableColumnModel columnModel = jTableProductos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(300);
        columnModel.getColumn(3).setPreferredWidth(40);
        //Alineacion de columna
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        //Indico las columnas para alinear
        jTableProductos.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jTableProductos.getColumnModel().getColumn(1).setCellRenderer(tcr);
        jTableProductos.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jTableProductos.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jTableProductos.getColumnModel().getColumn(6).setCellRenderer(tcr);
    }
    
    private void LeeParametros(){
        try {
            Main objPar = new Main();
            objPar.parametos();
            numeroTerminal=objPar.getNumeroTerminal();
            fecha=objPar.getFecha();
            nombreFantasiaEmpresa=objPar.getNombreFantasiaEmpresa();
            nombreEmpresa=objPar.getNombreEmpresa();
            rutEmpresa=objPar.getRutEmpresa();

        } catch (Exception e) {
            System.err.println("Error LeeParametros: "+e);
        }
    }
    
    private void Totaliza(){
        int Total;
        Total=0;
        try {
            for (int i=0;i<jTableProductos.getRowCount();i++){
                Total+=Integer.parseInt(jTableProductos.getValueAt(i, 6).toString());
            }
        } catch (Exception e) {
            System.err.println("Error Totaliza: "+e);
        }
        jTextTotal.setText(""+Total);
    }
    
    private void ConsultaPeriodo(){
        numeroPeriodo=0;
        try {
            PeriodoVenta objPV = new PeriodoVenta(0, 0, numeroTerminal,"","","");
            objPV.ConsultaPeriodo();
            numeroPeriodo=objPV.getPeriodo();
            if(numeroPeriodo==0){
                JOptionPane.showMessageDialog(null, "Periodo cerrado, debe abrir uno !!!");
                JDFPeriodo objPro =new JDFPeriodo(null,true);
                objPro.setVisible(true);
            }
        } catch (Exception e) {
            System.err.println("Error ConsultaPeriodo: "+e);
        }
    }
    
    private void ConsultaTurno(){
        numeroTurno=0;
        try {
            PeriodoVenta objPV = new PeriodoVenta(0, 0, numeroTerminal,"","","");
            objPV.ConsultaTurno();
            numeroTurno = objPV.getTurno();
            if(numeroTurno==0){
                JOptionPane.showMessageDialog(null, "Turno cerrado, debe abrir uno !!!");
                JDFTurno objTur =new JDFTurno(null,true);
                objTur.setVisible(true);
            }
        } catch (Exception e) {
            System.err.println("Error ConsultaTurno: "+e);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTerminal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextCodigo = new javax.swing.JTextField();
        jTextDescripcion = new javax.swing.JTextField();
        jTextUnitario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTextTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtnEliminaLinea = new javax.swing.JButton();
        jRadioEfectivo = new javax.swing.JRadioButton();
        jRadioCredito = new javax.swing.JRadioButton();
        jRadioTarjeta = new javax.swing.JRadioButton();
        jBtnConsultaPrecio = new javax.swing.JButton();
        jBtnLiquidar = new javax.swing.JButton();
        jBtnLiquidar1 = new javax.swing.JButton();
        jBtnEliminaLinea1 = new javax.swing.JButton();
        jBtnConsultaPrecio1 = new javax.swing.JButton();

        setClosable(true);

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
                .addGap(0, 689, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTerminal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextCodigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextCodigoFocusLost(evt);
            }
        });
        jTextCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodigoActionPerformed(evt);
            }
        });
        jTextCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCodigoKeyTyped(evt);
            }
        });

        jTextDescripcion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextDescripcion.setEnabled(false);
        jTextDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDescripcionActionPerformed(evt);
            }
        });

        jTextUnitario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextUnitario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextUnitario.setEnabled(false);
        jTextUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUnitarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextUnitario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setAlignmentX(0.0F);

        jTableProductos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setAlignmentX(0.0F);

        jTextTotal.setBackground(new java.awt.Color(204, 204, 255));
        jTextTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextTotal.setEnabled(false);
        jTextTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTotalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Total: $");

        jBtnEliminaLinea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnEliminaLinea.setText("Elimina Línea");
        jBtnEliminaLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminaLineaActionPerformed(evt);
            }
        });

        jRadioEfectivo.setBackground(new java.awt.Color(204, 204, 255));
        jRadioEfectivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioEfectivo.setSelected(true);
        jRadioEfectivo.setText("Efectivo");
        jRadioEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioEfectivoActionPerformed(evt);
            }
        });

        jRadioCredito.setBackground(new java.awt.Color(204, 204, 255));
        jRadioCredito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioCredito.setText("Crédito");
        jRadioCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCreditoActionPerformed(evt);
            }
        });

        jRadioTarjeta.setBackground(new java.awt.Color(204, 204, 255));
        jRadioTarjeta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioTarjeta.setText("Tarjeta");
        jRadioTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTarjetaActionPerformed(evt);
            }
        });

        jBtnConsultaPrecio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnConsultaPrecio.setText("Consulta Precio");
        jBtnConsultaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultaPrecioActionPerformed(evt);
            }
        });

        jBtnLiquidar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnLiquidar.setText("Liquidar");
        jBtnLiquidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLiquidarActionPerformed(evt);
            }
        });

        jBtnLiquidar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnLiquidar1.setText("Retiro Dinero");
        jBtnLiquidar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLiquidar1ActionPerformed(evt);
            }
        });

        jBtnEliminaLinea1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnEliminaLinea1.setText("Informes (X Z)");
        jBtnEliminaLinea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminaLinea1ActionPerformed(evt);
            }
        });

        jBtnConsultaPrecio1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtnConsultaPrecio1.setText("Salir");
        jBtnConsultaPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultaPrecio1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtnLiquidar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEliminaLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConsultaPrecio))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtnLiquidar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEliminaLinea1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConsultaPrecio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(86, 86, 86)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextTotal))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jRadioTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jRadioCredito)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnLiquidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEliminaLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnConsultaPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnEliminaLinea1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(jBtnConsultaPrecio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jBtnLiquidar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioEfectivo)
                        .addComponent(jRadioCredito)
                        .addComponent(jRadioTarjeta)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 800, 469);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodigoActionPerformed
        try {
            String ean;
            int plu;
            if(!jTextCodigo.getText().isEmpty()){
                ean=jTextCodigo.getText();
                
                Productos objPro = new Productos(0, 0, "", 0, 0, "", "", 0,ean);
                objPro.ConsultaProductoCodigoBarra();
                if(Productos.ProductoExiste){
                    jTextDescripcion.setText(objPro.getNombre());
                    plu=objPro.getId();
                    //Precio
                    Precios objPre = new Precios(plu, 0, 0, 0, 0);
                    objPre.DamePrecios_Margenes();
                    jTextUnitario.setText(""+ objPre.getVenta());
                    if(objPre.getVenta()==0){
                        JOptionPane.showMessageDialog(null, "Falta definir precio de venta !!!");
                        jTextUnitario.setText(null);
                        jTextDescripcion.setText(null);
                        jTextCodigo.setText(null);
                        jTextCodigo.requestFocus();
                    }else{
                        //CARGO DATOS EN LA TABLA
                        //Busco si el dato ya esta ingresado en la tabla
                        boolean existe =false;
                        int filaExiste=0;
                        for(int i=0;i<jTableProductos.getRowCount();i++){
                            if(jTextCodigo.getText().equals(jTableProductos.getValueAt(i, 0))){
                                existe=true;
                                filaExiste=i;
                            }
                        }    
                        
                        if(!existe){
                            String codigoBarra=jTextCodigo.getText();
                            String codigoPlu= ""+objPro.getId();
                            String nombre=jTextDescripcion.getText();
                            String unidad=""+objPro.getUnidad();
                            String cantidad="1";
                            String precio=jTextUnitario.getText();
                            String subTotal = jTextUnitario.getText();
                            String matriz[]={codigoBarra,codigoPlu,nombre,unidad,cantidad,precio,subTotal};
                            tabla.addRow(matriz);
                        }else{
                            //Sumo uno a la cantidad y Recalculo el subTotal
                            int cant= Integer.parseInt(jTableProductos.getValueAt(filaExiste, 4).toString())+1;
                            jTableProductos.setValueAt(cant, filaExiste, 4);
                            int subTotal = Integer.parseInt(jTableProductos.getValueAt(filaExiste, 4).toString())*Integer.parseInt(jTableProductos.getValueAt(filaExiste, 5).toString());
                            //Agrego los nuevos valores
                            jTableProductos.setValueAt(cant, filaExiste, 4);
                            jTableProductos.setValueAt(subTotal, filaExiste, 6);
                        }
                        jTextCodigo.setText(null);
                        jTextCodigo.requestFocus();
                        Totaliza();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Producto ingresado no existe !!!");
                    jTextCodigo.setText(null);
                    jTextCodigo.requestFocus();
                }
            }    
        } catch (Exception e) {
            System.err.println("Error jTextCodigoActionPerformed:"+e);
        }
    }//GEN-LAST:event_jTextCodigoActionPerformed

    private void jTextDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDescripcionActionPerformed

    private void jTextUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUnitarioActionPerformed

    private void jTextCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextCodigoFocusLost
    
    }//GEN-LAST:event_jTextCodigoFocusLost

    private void jTextTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTotalActionPerformed

    private void jBtnEliminaLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminaLineaActionPerformed
        try {
            int i=jTableProductos.getSelectedRow();
            if(i==-1){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para editarlo");
            }else{
                tabla.removeRow(i);
                Totaliza();
            }
            jTextCodigo.setText(null);
            jTextDescripcion.setText(null);
            jTextUnitario.setText(null);
            jTextCodigo.requestFocus();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnEliminaLineaActionPerformed

    private void jRadioCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCreditoActionPerformed
        jRadioEfectivo.setSelected(false);
        jRadioTarjeta.setSelected(false);
        jRadioCredito.setSelected(true);
        jTextCodigo.requestFocus();
    }//GEN-LAST:event_jRadioCreditoActionPerformed

    private void jRadioEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioEfectivoActionPerformed
        jRadioEfectivo.setSelected(true);
        jRadioTarjeta.setSelected(false);
        jRadioCredito.setSelected(false);
        jTextCodigo.requestFocus();
    }//GEN-LAST:event_jRadioEfectivoActionPerformed

    private void jRadioTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTarjetaActionPerformed
        jRadioEfectivo.setSelected(false);
        jRadioTarjeta.setSelected(true);
        jRadioCredito.setSelected(false);
        jTextCodigo.requestFocus();
    }//GEN-LAST:event_jRadioTarjetaActionPerformed

    private void jBtnConsultaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultaPrecioActionPerformed
        try {
            JIFConsultaPrecio objCon =new JIFConsultaPrecio();
            JFrmMain.jDPMain.add(objCon);
            Dimension desktopSize = JFrmMain.jDPMain.getSize();
            Dimension FrameSize = objCon.getSize(); 
            objCon.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            objCon.toFront();
            objCon.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnConsultaPrecioActionPerformed

    private void jTextCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCodigoKeyTyped
        char car = evt.getKeyChar();
        if (((car < '0') || (car > '9'))) evt.consume();
    }//GEN-LAST:event_jTextCodigoKeyTyped

    private void jBtnEliminaLinea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminaLinea1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEliminaLinea1ActionPerformed

    private void jBtnConsultaPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultaPrecio1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnConsultaPrecio1ActionPerformed

    private void jBtnLiquidar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLiquidar1ActionPerformed
        try {
            JIFRetiroDinero objRet =new JIFRetiroDinero();
            JFrmMain.jDPMain.add(objRet);
            Dimension desktopSize = JFrmMain.jDPMain.getSize();
            Dimension FrameSize = objRet.getSize(); 
            objRet.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            objRet.toFront();
            objRet.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBtnLiquidar1ActionPerformed

    private void jBtnLiquidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLiquidarActionPerformed
        try {
            if(jTextTotal.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Venta sin total");
                return;
            }
            if(jTableProductos.getRowCount()<1){
                JOptionPane.showMessageDialog(null, "Venta sin productos");
                return;
            }
            String formaPago="";
            if(jRadioCredito.isSelected()){
                formaPago="CREDITO";
            }
            if(jRadioEfectivo.isSelected()){
                formaPago="EFECTIVO";
            }
            if(jRadioTarjeta.isSelected()){
                formaPago="TARJETA";
            }
            if(formaPago.equals("")){
                JOptionPane.showMessageDialog(null, "No esta definida la forma de pago !!!");
                return;
            }
            Venta.totalventa=Integer.parseInt(jTextTotal.getText());
            
            JDFLiquidaVenta objLV =new JDFLiquidaVenta(null,true);
            objLV.setVisible(true);
            
          
            boolean continua=objLV.isLiquida();
            if(!continua){
                jTextCodigo.requestFocus();
            }else{
                int CodigoDocumento=objLV.getCodigoDocumento();
                int idCliente=objLV.getIdCliente();
               // DefaultTableModel tablaReferencia = new DefaultTableModel(objLV.getTablaReferencia());
                
                
                
                Folios objFol = new Folios(CodigoDocumento, 0, "", 0,0, "");
                objFol.DameUnFolio();
                int folio=objFol.getFolio();
                if(folio==0){
                    JOptionPane.showMessageDialog(null, "No hay folios disponibles para este documento !!!");
                    return;
                }
                
                //Grabo la Venta
                Venta objVen = new Venta(CodigoDocumento, folio, idCliente, formaPago, Integer.parseInt(jTextTotal.getText()),  tabla, objLV.getTablaReferencia());
                objVen.GrabaVenta();
                
                //Actualizo Folio
                Folios objNFol = new Folios(CodigoDocumento, folio,  "", 0, 0, "");
                objNFol.FolioUsado();
            
                //Genero XML
                XML objXml = new XML(CodigoDocumento, folio);
                objXml.CreaXML();
                
                
                //Limpio Pantalla
                jTextCodigo.setText(null);
                jTextDescripcion.setText(null);
                jTextUnitario.setText(null);
                jTextTotal.setText(null);
                
                while(tabla.getRowCount()>0)tabla.removeRow(0);
            }
            
            jTextCodigo.requestFocus();
            
        } catch (Exception e) {
            System.out.println("Error jBtnLiquidarActionPerformed: "+e);
        }
        
    }//GEN-LAST:event_jBtnLiquidarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnConsultaPrecio;
    private javax.swing.JButton jBtnConsultaPrecio1;
    private javax.swing.JButton jBtnEliminaLinea;
    private javax.swing.JButton jBtnEliminaLinea1;
    private javax.swing.JButton jBtnLiquidar;
    private javax.swing.JButton jBtnLiquidar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTerminal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioCredito;
    private javax.swing.JRadioButton jRadioEfectivo;
    private javax.swing.JRadioButton jRadioTarjeta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextDescripcion;
    private javax.swing.JTextField jTextTotal;
    private javax.swing.JTextField jTextUnitario;
    // End of variables declaration//GEN-END:variables
}
