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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class PanelAltaPrestador extends javax.swing.JFrame {
     conectar conexion = new conectar();
    Connection conexion2;
    PreparedStatement preparadorSentencia;
    /**
     * Creates new form PanelAltaPrestador
     */
    public PanelAltaPrestador() {
        initComponents();
        obtenerTodosLosPrestadores();
    }
        public void limpiar()
    {
        jtf_InePrestador.setText("");
        jtf_nombre.setText("");
        jtf_apellido.setText("");
        jtf_direccion.setText("");
        jtf_telefono.setText("");
    }
    public Boolean obtenerAccionARealizar() {
        boolean accion = lbl_accion.getText().equals("Nuevo");

        return accion;
    }

    public void ponerDatosEnCajasParaActualizar() throws Exception{
        int fila = jt_tabla.getSelectedRow();
        if(fila==-1)
        {
           throw  new Exception("seleccione un elemento de la tabla");
        }
        else{            
            String ine= jt_tabla.getValueAt(fila,0).toString();
            String nombre= jt_tabla.getValueAt(fila,1).toString();            
            String apellido= jt_tabla.getValueAt(fila,2).toString();
            String tipo= jt_tabla.getValueAt(fila, 3).toString();
            String direccion= jt_tabla.getValueAt(fila, 4).toString();
            String telefono= jt_tabla.getValueAt(fila, 5).toString();
            jtf_InePrestador.setText(ine);
            jtf_nombre.setText(nombre);             
            jtf_apellido.setText(apellido);
            jcb_tipo.setSelectedItem(tipo);
            jtf_direccion.setText(direccion);
            jtf_telefono.setText(telefono);
        }
    }

    public void obtenerTodosLosPrestadores() {
        try {
            DefaultTableModel tabla = new DefaultTableModel();
            jt_tabla.setModel(tabla);
            conexion2 = conexion.getConnection();
            preparadorSentencia = conexion2.prepareStatement("SELECT ine,nombre,apellido,tipo,direccion,telefono FROM prestador ");           
            preparadorSentencia.execute();
            ResultSet resultado = preparadorSentencia.getResultSet();
            ResultSetMetaData datos = resultado.getMetaData();
            int columnas = datos.getColumnCount();
            tabla.addColumn("INE");
            tabla.addColumn("Nombre");
            tabla.addColumn("Apellido");
            tabla.addColumn("Tipo");
            tabla.addColumn("Direccion");
            tabla.addColumn("Telefono");
            int[] anchoCeldas = {100, 250, 250,250,600,600};
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
    public void actualizarPrestador() throws Exception
    {
        try{
        int ine=Integer.parseInt(jtf_InePrestador.getText());
        String nombre= jtf_nombre.getText();
        String apellido= jtf_apellido.getText();
        String tipo= jcb_tipo.getSelectedItem().toString();
        String direccion= jtf_direccion.getText();
        String telefono= jtf_telefono.getText();
        preparadorSentencia= conexion2.prepareStatement("UPDATE prestador SET nombre=?, apellido=?, tipo=?,direccion=?,telefono=? WHERE ine=?");
        preparadorSentencia.setString(1,nombre);
        preparadorSentencia.setString(2,apellido);
        preparadorSentencia.setString(3, tipo);
        preparadorSentencia.setString(4,direccion);
        preparadorSentencia.setString(5, telefono);
        preparadorSentencia.setInt(6,ine);
        preparadorSentencia.execute();
        }catch(Exception e)
        {
              throw new Exception("error al actualizar al prestador");
        }
       
    }
    public void ingresarNuevoPrestador() throws Exception
    {
         try{
            int ine = Integer.parseInt(jtf_InePrestador.getText());
            String nombre= jtf_nombre.getText();
            String apellido= jtf_apellido.getText();
            String tipo= jcb_tipo.getSelectedItem().toString();
            String direccion = jtf_direccion.getText();
            String telefono = jtf_telefono.getText();
            preparadorSentencia= conexion2.prepareStatement("INSERT INTO prestador(ine,nombre,apellido,tipo,direccion,telefono) VALUES(?,?,?,?,?,?)");
            preparadorSentencia.setInt(1,ine);
            preparadorSentencia.setString(2,nombre);
            preparadorSentencia.setString(3,apellido);
            preparadorSentencia.setString(4,tipo);
            preparadorSentencia.setString(5,direccion);
            preparadorSentencia.setString(6,telefono);
            preparadorSentencia.execute();
            JOptionPane.showMessageDialog(null,"se registro al prestador con exito");
        }catch(Exception e)
        {
            throw new Exception("error al agregar al prestador");
        } 
    }
    public void verificarInePrestador() throws Exception
    {
        try{
            conexion2= conexion.getConnection();
            int inePrestador= Integer.parseInt(jtf_InePrestador.getText());
            preparadorSentencia= conexion2.prepareStatement("SELECT * FROM prestador WHERE ine=?");
            preparadorSentencia.setInt(1,inePrestador);
            preparadorSentencia.setMaxRows(1);
            preparadorSentencia.execute();
            ResultSet resultado= preparadorSentencia.getResultSet();
            if(resultado.first())
            {
                throw new Exception("ya exite un prestador con ese INE");
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
        jtf_InePrestador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcb_tipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtf_direccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtf_telefono = new javax.swing.JTextField();
        jb_agregar = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_tabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lbl_accion = new javax.swing.JLabel();
        jb_nuevo = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Prestador");

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INE Prestador");

        jtf_InePrestador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_InePrestadorKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo");

        jcb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "alumno", "maestro" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("direccion");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("telefono");

        jb_agregar.setText("agregar");
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });

        jb_regresar.setText("regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Modo:");

        lbl_accion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_accion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accion.setText("Nuevo");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcb_tipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtf_InePrestador, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_apellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addGap(122, 122, 122)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_accion)
                                    .addComponent(jb_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jb_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jb_agregar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                    .addComponent(jb_regresar))
                                .addComponent(jtf_direccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtf_telefono, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jtf_InePrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbl_accion)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jb_nuevo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jb_modificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_agregar)
                    .addComponent(jb_regresar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(261, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            if (jtf_InePrestador.getText().isEmpty() || jtf_nombre.getText().isEmpty() || jtf_apellido.getText().isEmpty() || jtf_direccion.getText().isEmpty() || jtf_telefono.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "no dejar campos vacios");
            } else {
                try {
                    verificarInePrestador();
                    ingresarNuevoPrestador();
                    obtenerTodosLosPrestadores();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        else{
            if (jtf_InePrestador.getText().isEmpty() || jtf_nombre.getText().isEmpty() || jtf_apellido.getText().isEmpty() || jtf_direccion.getText().isEmpty() || jtf_telefono.getText().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "no dejar campos vacios");
            }
            else{
                try{
                    actualizarPrestador();
                    JOptionPane.showMessageDialog(null,"se actualizo al prestador correctamente");
                    obtenerTodosLosPrestadores();
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        /*if(jtf_InePrestador.getText().isEmpty() || jtf_nombre.getText().isEmpty() || jtf_apellido.getText().isEmpty() || jtf_direccion.getText().isEmpty() || jtf_telefono.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"No dejar campos vacios");
        }
        else{
             try{
                verificarInePrestador();
                ingresarNuevoPrestador();
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } */       
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        PanelPrincipal panelPrincipal= new PanelPrincipal();
        panelPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jtf_InePrestadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_InePrestadorKeyTyped
         char ine =evt.getKeyChar();
        if(Character.isLetter(ine)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresa solo numeros");
        }  
    }//GEN-LAST:event_jtf_InePrestadorKeyTyped

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
         lbl_accion.setText("Nuevo");
        limpiar();
        jtf_InePrestador.setEnabled(true);
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
         try{
            ponerDatosEnCajasParaActualizar();
            lbl_accion.setText("Modificar");
            jtf_InePrestador.setEnabled(false);
       } catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }//GEN-LAST:event_jb_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAltaPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAltaPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAltaPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAltaPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAltaPrestador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JComboBox<String> jcb_tipo;
    private javax.swing.JTable jt_tabla;
    private javax.swing.JTextField jtf_InePrestador;
    private javax.swing.JTextField jtf_apellido;
    private javax.swing.JTextField jtf_direccion;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_telefono;
    private javax.swing.JLabel lbl_accion;
    // End of variables declaration//GEN-END:variables
}
