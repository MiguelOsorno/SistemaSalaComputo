/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasaladecomputo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class PanelDevolucion extends javax.swing.JFrame {

    conectar conexion = new conectar();
    Connection conexion2;
    PreparedStatement preparadorSentencia;

    public PanelDevolucion() {
        initComponents();
    }

    public void activarBotonDevolver() {
        jb_devolver.setEnabled(true);
    }

    public void desactivarBotonDevolver() {
        jb_devolver.setEnabled(false);
    }

    public void establecerEstatusDeArticulo() throws Exception {
        try {
            conexion2 = conexion.getConnection();
            int idArticulo = Integer.parseInt(lbl_idArticulo.getText());
            preparadorSentencia = conexion2.prepareStatement("UPDATE articulo SET estatus=? WHERE id=?");
            preparadorSentencia.setString(1, "disponible");
            preparadorSentencia.setInt(2, idArticulo);
            preparadorSentencia.execute();
        } catch (Exception e) {
            throw new Exception("Error al establecer el estatus del articulo");
        }
    }

    public void establecerEstatusDePrestamo() throws Exception {
        try {
            conexion2 = conexion.getConnection();
            int idPrestamo = Integer.parseInt(lbl_idPrestamo.getText());
            preparadorSentencia = conexion2.prepareStatement("UPDATE prestamo SET estatus=? WHERE id=?");
            preparadorSentencia.setString(1, "devuelto");
            preparadorSentencia.setInt(2, idPrestamo);
            preparadorSentencia.execute();
        } catch (Exception e) {
            throw new Exception("Error al establecer el estatus del prestamo");
        }
    }

    public void limpiarLabels() {
        lbl_idArticulo.setText("-----------");
        lbl_idPrestamo.setText("-----------");
        lbl_nombrePrestador.setText("-----------");
        lbl_fechaPrestamo.setText("-----------");
        lbl_fechaEntrega.setText("-----------");
        lbl_estatusDelPrestamo.setText("-----------");
    }

    public void actualizarFormularioDespuesDeDevolver() throws Exception {
        try {
            conexion2 = conexion.getConnection();
            int idPrestamo = Integer.parseInt(lbl_idPrestamo.getText());
            preparadorSentencia = conexion2.prepareStatement("SELECT estatus FROM prestamo WHERE id=?");
            preparadorSentencia.setInt(1, idPrestamo);
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            ResultSet resultado = preparadorSentencia.getResultSet();
            if (resultado.first()) {
                lbl_estatusDelPrestamo.setText(resultado.getString("estatus"));
            } else {
                throw new Exception("no se puedo actualizar el estatus del prestamo despues de devolverlo");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String darFormatoFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = null;
        try {
            date = inputFormat.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(DateCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sdf.format(date);
    }

    public void obtenerRegistroDePrestamo(int id) throws Exception {
        try {
            conexion2 = conexion.getConnection();
            preparadorSentencia = conexion2.prepareStatement("SELECT prestamo.id,prestador.nombre,prestamo.fechaPrestamo,prestamo.fechaEntrega,prestamo.estatus FROM prestamo INNER JOIN prestador ON prestamo.inePrestador=prestador.id WHERE prestamo.claveArticulo=? AND prestamo.estatus=?");
            preparadorSentencia.setInt(1, id);
            preparadorSentencia.setString(2, "prestado");
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            ResultSet resultado = preparadorSentencia.getResultSet();
            if (resultado.first()) {
                lbl_idPrestamo.setText(resultado.getString("prestamo.id"));
                lbl_nombrePrestador.setText(resultado.getString("prestador.nombre"));
                lbl_fechaPrestamo.setText(darFormatoFecha(resultado.getString("prestamo.fechaPrestamo")));
                lbl_fechaEntrega.setText(darFormatoFecha(resultado.getString("prestamo.fechaEntrega")));
                lbl_estatusDelPrestamo.setText(resultado.getString("prestamo.estatus"));
            } else {
                throw new Exception("Este articulo no ha sido prestado");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void obtenerIdDeArticulo() throws Exception {
        try {
            conexion2 = conexion.getConnection();
            String claveArticulo = jtf_claveArticulo.getText();
            preparadorSentencia = conexion2.prepareStatement("SELECT id FROM articulo WHERE clave=?");
            preparadorSentencia.setString(1, claveArticulo);
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            ResultSet resultado = preparadorSentencia.getResultSet();
            if (resultado.first()) {
                lbl_idArticulo.setText(resultado.getString("id"));
            } else {
                throw new Exception("No fue posible encontrar el articulo");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtf_claveArticulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        lbl_idArticulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_nombrePrestador = new javax.swing.JLabel();
        lbl_fechaPrestamo = new javax.swing.JLabel();
        lbl_fechaEntrega = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_estatusDelPrestamo = new javax.swing.JLabel();
        lbl_idPrestamo = new javax.swing.JLabel();
        jb_devolver = new javax.swing.JButton();
        jb_regresarAInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Devolucion");

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jtf_claveArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_claveArticuloActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese la clave de articulo");

        jb_buscar.setText("Buscar");
        jb_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_buscarMouseClicked(evt);
            }
        });
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });

        lbl_idArticulo.setText("id articulo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("id prestamo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prestador:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("fecha prestamo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("fecha entrega");

        lbl_nombrePrestador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_nombrePrestador.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombrePrestador.setText("-----------");

        lbl_fechaPrestamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_fechaPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fechaPrestamo.setText("-----------");

        lbl_fechaEntrega.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_fechaEntrega.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fechaEntrega.setText("-----------");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("estatus");

        lbl_estatusDelPrestamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_estatusDelPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_estatusDelPrestamo.setText("-----------");

        lbl_idPrestamo.setBackground(new java.awt.Color(0, 0, 0));
        lbl_idPrestamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_idPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idPrestamo.setText("-----------");

        jb_devolver.setText("devolver");
        jb_devolver.setEnabled(false);
        jb_devolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_devolverMouseClicked(evt);
            }
        });
        jb_devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_devolverActionPerformed(evt);
            }
        });

        jb_regresarAInicio.setText("Regresar");
        jb_regresarAInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarAInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_regresarAInicio)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_idPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_nombrePrestador)
                                    .addComponent(lbl_fechaPrestamo)
                                    .addComponent(lbl_fechaEntrega)
                                    .addComponent(lbl_estatusDelPrestamo))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtf_claveArticulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jb_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb_devolver))
                            .addComponent(lbl_idArticulo))
                        .addContainerGap(59, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_idArticulo))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jb_buscar)
                    .addComponent(jb_devolver)
                    .addComponent(jtf_claveArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbl_idPrestamo)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(lbl_nombrePrestador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(lbl_fechaPrestamo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(lbl_fechaEntrega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(lbl_estatusDelPrestamo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_regresarAInicio)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_regresarAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarAInicioActionPerformed
        PanelPrincipal principal = new PanelPrincipal();
        principal.setVisible(true);
        conexion.desconectar();
        this.dispose();
    }//GEN-LAST:event_jb_regresarAInicioActionPerformed

    private void jb_devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_devolverActionPerformed
        try {
            establecerEstatusDePrestamo();
            establecerEstatusDeArticulo();
            JOptionPane.showMessageDialog(null, "Se devolvio el articulo exitosamente");
            desactivarBotonDevolver();
            actualizarFormularioDespuesDeDevolver();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jb_devolverActionPerformed

    private void jb_devolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_devolverMouseClicked
        /*try{
            establecerEstatusDePrestamo();
            establecerEstatusDeArticulo();
            JOptionPane.showMessageDialog(null,"Se devolvio el articulo exitosamente");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }//GEN-LAST:event_jb_devolverMouseClicked

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        if (jtf_claveArticulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ingrese la clave del articulo");
        } else {
            try {
                limpiarLabels();
                obtenerIdDeArticulo();
                int idArticulo = Integer.parseInt(lbl_idArticulo.getText());
                obtenerRegistroDePrestamo(idArticulo);
                activarBotonDevolver();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }       
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_buscarMouseClicked
        /*try{
            limpiarLabels();
            obtenerIdDeArticulo();
            int idArticulo= Integer.parseInt(lbl_idArticulo.getText());
            obtenerRegistroDePrestamo(idArticulo);
            activarBotonDevolver();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }//GEN-LAST:event_jb_buscarMouseClicked

    private void jtf_claveArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_claveArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_claveArticuloActionPerformed

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
            java.util.logging.Logger.getLogger(PanelDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelDevolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_devolver;
    private javax.swing.JButton jb_regresarAInicio;
    private javax.swing.JTextField jtf_claveArticulo;
    private javax.swing.JLabel lbl_estatusDelPrestamo;
    private javax.swing.JLabel lbl_fechaEntrega;
    private javax.swing.JLabel lbl_fechaPrestamo;
    private javax.swing.JLabel lbl_idArticulo;
    private javax.swing.JLabel lbl_idPrestamo;
    private javax.swing.JLabel lbl_nombrePrestador;
    // End of variables declaration//GEN-END:variables
}
