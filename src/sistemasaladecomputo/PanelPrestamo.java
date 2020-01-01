package sistemasaladecomputo;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PanelPrestamo extends javax.swing.JFrame {

    conectar conexion = new conectar();
    Connection conexion2;
    PreparedStatement preparadorSentencia;
    Date fecha;

    public PanelPrestamo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtf_inePrestador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtf_claveEncargado = new javax.swing.JTextField();
        jb_agregar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtf_claveArticulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        currentDate = new com.toedter.calendar.JDateChooser();
        dateFinal = new com.toedter.calendar.JDateChooser();
        lbl_idPrestador = new javax.swing.JLabel();
        lbl_idEncargado = new javax.swing.JLabel();
        lbl_idArticulo = new javax.swing.JLabel();
        lbl_estatus = new javax.swing.JLabel();
        lbl_tipoArticulo = new javax.swing.JLabel();
        lbl_tiempo = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro");

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));
        jPanel2.setForeground(new java.awt.Color(0, 51, 153));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("INE Prestador");

        jtf_inePrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_inePrestadorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("clave Encargado");

        jb_agregar.setText("agregar");
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });

        jb_cancelar.setText("regresar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("clave articulo");

        jtf_claveArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_claveArticuloActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("fecha de prestamo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("fecha de entrega");

        currentDate.setDateFormatString("yyyy/MM/dd HH:mm:ss");
        currentDate.setEnabled(false);

        dateFinal.setDateFormatString("yyyy/MM/dd HH:mm:ss");
        dateFinal.setEnabled(false);

        lbl_idPrestador.setText("id prestador");

        lbl_idEncargado.setText("id encargado");

        lbl_idArticulo.setText("id articulo");

        lbl_estatus.setText("estatus");

        lbl_tipoArticulo.setText("tipoArticulo");

        lbl_tiempo.setText("tiempo");

        lbl_cantidad.setText("cantidad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_inePrestador)
                            .addComponent(jtf_claveEncargado)
                            .addComponent(jtf_claveArticulo)
                            .addComponent(currentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_idPrestador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_idEncargado, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lbl_idArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_tiempo)
                                    .addComponent(lbl_tipoArticulo)
                                    .addComponent(lbl_cantidad))
                                .addGap(12, 12, 12))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jb_agregar)
                        .addGap(27, 27, 27)
                        .addComponent(jb_cancelar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_inePrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_idPrestador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_claveEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_idEncargado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtf_claveArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idArticulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(currentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_estatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lbl_tipoArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_agregar)
                    .addComponent(jb_cancelar)
                    .addComponent(lbl_tiempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_cantidad)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void buscarArticulo() throws Exception {
        try {
            PreparedStatement preparadorSentencia;
            Connection conn = conexion.getConnection();
            int ine = Integer.parseInt(jtf_inePrestador.getText());
            System.out.println(ine);
            preparadorSentencia = conn.prepareStatement("SELECT id FROM prestador where ine=?");
            preparadorSentencia.setInt(1, ine);
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            ResultSet result = preparadorSentencia.getResultSet();
            if (result.first()) {
                System.out.println(result.getString("id"));
                lbl_idPrestador.setText(result.getString("id"));
            } else {
                lbl_idPrestador.setText("no existe id prestador");
                throw new Exception("No fue posible encontrar al prestador");
            }
            int claveEncargado = Integer.parseInt(jtf_claveEncargado.getText());
            preparadorSentencia = conn.prepareStatement("SELECT id FROM encargado where clave=?");
            preparadorSentencia.setInt(1, claveEncargado);
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            result = preparadorSentencia.getResultSet();
            if (result.first()) {
                System.out.println(result.getString("id"));
                lbl_idEncargado.setText(result.getString("id"));
            } else {
                lbl_idEncargado.setText("no existe id del encargado");
                throw new Exception("No fue posible encontrar al encargado");
            }
            String claveArticulo = jtf_claveArticulo.getText();
            preparadorSentencia = conn.prepareStatement("SELECT articulo.id, articulo.estatus,articulo.idTipoArticulo,tipoArticulo.tiempo,tipoArticulo.cantidad FROM articulo INNER JOIN tipoArticulo ON articulo.idTipoArticulo=tipoArticulo.id WHERE articulo.clave=?");
            preparadorSentencia.setString(1, claveArticulo);
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            result = preparadorSentencia.getResultSet();
            if (result.first()) {
                lbl_idArticulo.setText(result.getString("articulo.id"));
                lbl_estatus.setText(result.getString("articulo.estatus"));
                lbl_tipoArticulo.setText(result.getString("articulo.idTipoArticulo"));
                lbl_tiempo.setText(result.getString("tipoArticulo.tiempo"));
                lbl_cantidad.setText(result.getString("tipoArticulo.cantidad"));
            } else {
                lbl_idArticulo.setText("no existe id de articulo");
                lbl_estatus.setText("");
                lbl_tipoArticulo.setText("");
                throw new Exception("No fue posible encontrar el articulo");
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void actualizarEstatusDeArticulo(int id) throws Exception
    {
        try{
            conexion2= conexion.getConnection();
            preparadorSentencia=conexion2.prepareStatement("UPDATE articulo SET estatus ='prestado' WHERE id=?");
            preparadorSentencia.setInt(1,id);
            preparadorSentencia.execute();
        }catch (Exception e)
        {
            throw new Exception("error al actualizar estatus del articulo");
        }
    }

    public void insertarTodosLosCampos() {
        try {
            conexion2 = conexion.getConnection();
            preparadorSentencia = conexion2.prepareStatement("INSERT INTO prestamo(inePrestador,claveEncargado,claveArticulo,fechaPrestamo,fechaEntrega,estatus)values(?,?,?,?,?,?)");
            preparadorSentencia.setInt(1, Integer.parseInt(lbl_idPrestador.getText()));
            preparadorSentencia.setInt(2, Integer.parseInt(lbl_idEncargado.getText()));
            preparadorSentencia.setInt(3, Integer.parseInt(lbl_idArticulo.getText()));
            preparadorSentencia.setString(4, ((JTextField) currentDate.getDateEditor().getUiComponent()).getText());
            preparadorSentencia.setString(5, ((JTextField) dateFinal.getDateEditor().getUiComponent()).getText());
            preparadorSentencia.setString(6,"prestado");
            preparadorSentencia.execute();
        } catch (Exception e) {
            System.out.println("erro al insertar los datos" + e);
        }
    }

    public void calcularFechaYHoraActual() {
        fecha = new Date();
        currentDate.setDate(fecha);

    }

    public void obtenerFechaCantidadTipo() {
        int cantidad;
        cantidad = Integer.parseInt(lbl_cantidad.getText());
        String tipo;
        tipo = lbl_tiempo.getText();
        Date fechaEntrega;
        fechaEntrega = calcularFechaYHoraDeEntrega(fecha, cantidad, tipo);
        dateFinal.setDate(fechaEntrega);
    }

    public Date calcularFechaYHoraDeEntrega(Date fechaInicio, int cantidad, String tipo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        switch (tipo) {
            case "hora":
                calendar.add(Calendar.HOUR, cantidad);
                break;
            case "minuto":
                calendar.add(Calendar.MINUTE, cantidad);
                break;
        }
        return calendar.getTime();
    }

    public void obtenerEstatusDeArticulo() throws Exception {
        String estatus=lbl_estatus.getText();
        if(!estatus.equals("disponible"))
        {
            throw new Exception("el articulo no esta disponible");
        }
    }
    private void jtf_inePrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_inePrestadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_inePrestadorActionPerformed

    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
        try{
        calcularFechaYHoraActual();
        buscarArticulo();
        obtenerEstatusDeArticulo();
        obtenerFechaCantidadTipo();
        insertarTodosLosCampos();
        int id= Integer.parseInt(lbl_idArticulo.getText());
        actualizarEstatusDeArticulo(id);
        JOptionPane.showMessageDialog(null,"Se realizo el prestamo exitosamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jtf_claveArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_claveArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_claveArticuloActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        PanelPrincipal principal = new PanelPrincipal();
        principal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jb_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser currentDate;
    private com.toedter.calendar.JDateChooser dateFinal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JTextField jtf_claveArticulo;
    private javax.swing.JTextField jtf_claveEncargado;
    private javax.swing.JTextField jtf_inePrestador;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_estatus;
    private javax.swing.JLabel lbl_idArticulo;
    private javax.swing.JLabel lbl_idEncargado;
    private javax.swing.JLabel lbl_idPrestador;
    private javax.swing.JLabel lbl_tiempo;
    private javax.swing.JLabel lbl_tipoArticulo;
    // End of variables declaration//GEN-END:variables
}
