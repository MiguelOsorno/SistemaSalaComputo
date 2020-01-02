/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasaladecomputo;

/**
 *
 * @author Miguel
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class PanelAltaCanon extends javax.swing.JFrame {
    conectar conexion;
    Connection conexion2;
    PreparedStatement preparadorSentencia;
    /**
     * Creates new form PanelAltaCañon
     */
    public PanelAltaCanon() throws Exception {
        initComponents();
        conexion = new conectar();
        obtenerTodosLosCanones();
    }
     public void limpiar()
    {
        jtf_claveCanon.setText("");
        jtf_color.setText("");        
    }
     public void ponerDatosEnCajasParaActualizar() throws Exception{
        int fila = jt_tabla.getSelectedRow();
        if(fila==-1)
        {
           throw  new Exception("seleccione un elemento de la tabla");
        }
        else{            
            String clave= jt_tabla.getValueAt(fila,0).toString();
            String descripcion= jt_tabla.getValueAt(fila,2).toString();            
            String[]partesDeLaDescripcion= descripcion.split("\\|");
            jtf_claveCanon.setText(clave);
            jtf_color.setText(partesDeLaDescripcion[0]);                                      
        }
    }
    public void actualizarCanon() throws Exception
    {
        try{
        String clave=jtf_claveCanon.getText();
        String color= jtf_color.getText();        
        preparadorSentencia= conexion2.prepareStatement("UPDATE articulo SET descripcion=? WHERE clave=?");
        preparadorSentencia.setString(1,color+"|");
        preparadorSentencia.setString(2,clave);        
        preparadorSentencia.execute();
        }catch(Exception e)
        {
              throw new Exception("error al actualizar el proyector");
        }
       
    }
    public Boolean obtenerAccionARealizar() {
        boolean accion = lbl_accion.getText().equals("Nuevo");

        return accion;
    }
    public void obtenerTodosLosCanones() {
        try {
            DefaultTableModel tabla = new DefaultTableModel();
            jt_tabla.setModel(tabla);
            conexion2 = conexion.getConnection();
            preparadorSentencia = conexion2.prepareStatement("SELECT clave,estatus,descripcion FROM articulo WHERE idTipoArticulo=?");
            preparadorSentencia.setInt(1, 2);
            preparadorSentencia.execute();
            ResultSet resultado = preparadorSentencia.getResultSet();
            ResultSetMetaData datos = resultado.getMetaData();
            int columnas = datos.getColumnCount();
            tabla.addColumn("clave");
            tabla.addColumn("estatus");
            tabla.addColumn("descripcion");
            int[] anchoCeldas = {300, 300, 800};
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
    public void ingresarNuevoCanon() throws Exception
    {
         try{
            String clave= jtf_claveCanon.getText();
            String color= jtf_color.getText();
            preparadorSentencia= conexion2.prepareStatement("INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo) VALUES(?,?,?,?)");
            preparadorSentencia.setString(1,clave);
            preparadorSentencia.setString(2,"disponible");
            preparadorSentencia.setString(3,color+"|");
            preparadorSentencia.setInt(4,2);
            preparadorSentencia.execute();
            JOptionPane.showMessageDialog(null,"se registro el proyector con exito");
        }catch(Exception e)
        {
            throw new Exception("error al agregar el proyector");
        }    
    }
    public void verificarClaveCanon() throws Exception
    {
         try{
            conexion2= conexion.getConnection();
            String claveArticulo= jtf_claveCanon.getText();
            preparadorSentencia= conexion2.prepareStatement("SELECT * FROM articulo WHERE clave=?");
            preparadorSentencia.setString(1,claveArticulo);
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            ResultSet resultado= preparadorSentencia.getResultSet();
            if(resultado.first())
            {
                throw new Exception("ya exite un articulo con esa clave");
            }           
        }catch(Exception e)
        {
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
        jLabel2 = new javax.swing.JLabel();
        jtf_color = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_claveCanon = new javax.swing.JTextField();
        jb_agregar = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_accion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modulo Proyector");

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Color");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Clave");

        jb_agregar.setText("Guardar");
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });

        jb_nuevo.setText("Nuevo");
        jb_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_nuevoActionPerformed(evt);
            }
        });

        jb_modificar.setText("Modificar");
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modo:");

        lbl_accion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_accion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accion.setText("Nuevo");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_claveCanon))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_color, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_accion))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jb_agregar)
                                .addGap(18, 18, 18)
                                .addComponent(jb_regresar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtf_claveCanon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtf_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_accion)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addComponent(jb_nuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_modificar)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jb_agregar)
                    .addComponent(jb_regresar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
        if (obtenerAccionARealizar()) {
            if (jtf_claveCanon.getText().isEmpty() || jtf_color.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "no dejar campos vacios");
            } else {
                try {
                    verificarClaveCanon();
                    ingresarNuevoCanon();
                    obtenerTodosLosCanones();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        else{
            if (jtf_claveCanon.getText().isEmpty() || jtf_color.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "no dejar campos vacios");
            }
            else{
                try{
                    actualizarCanon();
                    JOptionPane.showMessageDialog(null,"se actualizo el proyector correctamente");
                    obtenerTodosLosCanones();
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        /*if(jtf_claveCanon.getText().isEmpty()|| jtf_color.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"No dejar campos vacios");
        }
        else{
             try{
                verificarClaveCanon();
                ingresarNuevoCanon();
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } */      
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        PanelPrincipal panelPrincipal= new PanelPrincipal();
        panelPrincipal.setVisible(true);
        conexion.desconectar();
        this.dispose();
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
         try{
            ponerDatosEnCajasParaActualizar();
            lbl_accion.setText("Modificar");
            jtf_claveCanon.setEnabled(false);
       } catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        lbl_accion.setText("Nuevo");
        limpiar();
        jtf_claveCanon.setEnabled(true);
    }//GEN-LAST:event_jb_nuevoActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAltaCanon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAltaCanon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAltaCanon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAltaCanon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PanelAltaCanon().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PanelAltaCanon.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JTable jt_tabla;
    private javax.swing.JTextField jtf_claveCanon;
    private javax.swing.JTextField jtf_color;
    private javax.swing.JLabel lbl_accion;
    // End of variables declaration//GEN-END:variables
}
