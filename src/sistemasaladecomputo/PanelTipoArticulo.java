/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasaladecomputo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class PanelTipoArticulo extends javax.swing.JFrame {
    conectar conexion;
    Connection conexion2;
    PreparedStatement preparadorSentencia;

    /**
     * Creates new form PanelTipoArticulo
     */
    public PanelTipoArticulo() throws Exception {
        initComponents();
        conexion = new conectar();
        obtenerTodosLosTipoDeArticulos();
    }
    public void actualizarTipoArticulo() throws Exception
    {
        try{
        String tipo= jtf_tipo.getText();
        String tiempo= jcb_tiempo.getSelectedItem().toString();   
        int cantidad=Integer.parseInt(jtf_cantidad.getText());                             
        preparadorSentencia= conexion2.prepareStatement("UPDATE tipoArticulo SET tiempo=?, cantidad=? WHERE descripcion=?");
        preparadorSentencia.setString(1,tiempo);
        preparadorSentencia.setInt(2,cantidad);
        preparadorSentencia.setString(3, tipo);              
        preparadorSentencia.execute();
        }catch(Exception e)
        {
              throw new Exception("error al actualizar al tipo de articulo");
        }
       
    }
     public void ponerDatosEnCajasParaActualizar() throws Exception{
        int fila = jt_tabla.getSelectedRow();
        if(fila==-1)
        {
           throw  new Exception("seleccione un elemento de la tabla");
        }
        else{            
            String descripcion= jt_tabla.getValueAt(fila,0).toString();
            String tiempo= jt_tabla.getValueAt(fila,1).toString();            
            String cantidad= jt_tabla.getValueAt(fila, 2).toString();
            jtf_tipo.setText(descripcion);
            jtf_cantidad.setText(cantidad); 
            jcb_tiempo.setSelectedItem(tiempo);
        }
    }
     public void obtenerTodosLosTipoDeArticulos() {
        try {
            DefaultTableModel tabla = new DefaultTableModel();
            jt_tabla.setModel(tabla);
            conexion2 = conexion.getConnection();
            preparadorSentencia = conexion2.prepareStatement("SELECT descripcion,tiempo,cantidad FROM tipoArticulo");            
            preparadorSentencia.execute();
            ResultSet resultado = preparadorSentencia.getResultSet();
            ResultSetMetaData datos = resultado.getMetaData();
            int columnas = datos.getColumnCount();
            tabla.addColumn("Tipo");
            tabla.addColumn("Tiempo");
            tabla.addColumn("Cantidad");
            int[] anchoCeldas = {300, 300, 300};
            for (int contador = 0; contador < columnas; contador++) {
                jt_tabla.getColumnModel().getColumn(contador).setPreferredWidth(anchoCeldas[contador]);
            }
            while (resultado.next()) {
                Object[] fila = new Object[columnas];
                for (int contador = 0; contador < columnas; ++contador) {
                    fila[contador] = resultado.getObject(contador + 1);
                }
                tabla.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtf_tipo = new javax.swing.JTextField();
        jcb_tiempo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_cantidad = new javax.swing.JTextField();
        jb_modificar = new javax.swing.JButton();
        jb_guardar = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modulo Tipo Articulo");

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));

        jt_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jt_tabla);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo:");

        jtf_tipo.setEnabled(false);

        jcb_tiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hora", "minuto" }));
        jcb_tiempo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tiempo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");

        jtf_cantidad.setEnabled(false);
        jtf_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_cantidadKeyTyped(evt);
            }
        });

        jb_modificar.setText("Modificar");
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jtf_tipo)
                    .addComponent(jtf_cantidad)
                    .addComponent(jcb_tiempo, 0, 95, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_modificar)
                        .addGap(90, 90, 90))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jb_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jb_modificar)
                    .addComponent(jtf_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jcb_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_guardar)
                    .addComponent(jb_regresar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
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

    private void jtf_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cantidadKeyTyped
        char cantidad =evt.getKeyChar();
        if(Character.isLetter(cantidad)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresa solo numeros");
        }  
    }//GEN-LAST:event_jtf_cantidadKeyTyped

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        try{
            ponerDatosEnCajasParaActualizar();            
            jtf_cantidad.setEnabled(true);
            jcb_tiempo.setEnabled(true);
       } catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
         if (jtf_tipo.getText().isEmpty() || jtf_cantidad.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "no dejar campos vacios");
            }
            else{
                try{
                    actualizarTipoArticulo();
                    JOptionPane.showMessageDialog(null,"se actualizo el articulo correctamente");
                    obtenerTodosLosTipoDeArticulos();
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        PanelPrincipal nuevoPanelPrincipal= new PanelPrincipal();
        nuevoPanelPrincipal.setVisible(true);
        conexion.desconectar();
        this.dispose();
    }//GEN-LAST:event_jb_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(PanelTipoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelTipoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelTipoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelTipoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PanelTipoArticulo().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PanelTipoArticulo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JComboBox<String> jcb_tiempo;
    private javax.swing.JTable jt_tabla;
    private javax.swing.JTextField jtf_cantidad;
    private javax.swing.JTextField jtf_tipo;
    // End of variables declaration//GEN-END:variables
}
