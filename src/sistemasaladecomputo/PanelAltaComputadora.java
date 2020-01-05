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
public class PanelAltaComputadora extends javax.swing.JFrame {
     conectar conexion;
    Connection conexion2;
    PreparedStatement preparadorSentencia;
    /**
     * Creates new form PanelAltaComputadora
     */
    public PanelAltaComputadora() throws Exception {
        initComponents();
        conexion = new conectar();
        obtenerTodosLasPc();
    }
     public void limpiar()
    {
        jtf_clavePC.setText("");
        jtf_marca.setText("");
        jtf_color.setText("");
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
            String clave= jt_tabla.getValueAt(fila,0).toString();
            String descripcion= jt_tabla.getValueAt(fila,2).toString();            
            String[]partesDeLaDescripcion= descripcion.split("\\|");
            jtf_clavePC.setText(clave);
            jtf_marca.setText(partesDeLaDescripcion[0]);             
            jtf_color.setText(partesDeLaDescripcion[1]);             
        }
    }
    public void obtenerTodosLasPc() {
        try {
            DefaultTableModel tabla = new DefaultTableModel();
            jt_tabla.setModel(tabla);
            conexion2 = conexion.getConnection();
            preparadorSentencia = conexion2.prepareStatement("SELECT clave,estatus,descripcion FROM articulo WHERE idTipoArticulo=?");
            preparadorSentencia.setInt(1, 3);
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
    public void actualizarPc() throws Exception
    {
        try{
        String clave=jtf_clavePC.getText();
        String marca=jtf_marca.getText();
        String color= jtf_color.getText();        
        preparadorSentencia= conexion2.prepareStatement("UPDATE articulo SET descripcion=? WHERE clave=?");
        preparadorSentencia.setString(1,marca+"|"+color+"|");
        preparadorSentencia.setString(2,clave);        
        preparadorSentencia.execute();
        }catch(Exception e)
        {
              throw new Exception("error al actualizar la PC");
        }
       
    }
    public void ingresarNuevaComputadora() throws Exception
    {
          try{
            String clave= jtf_clavePC.getText();
            String marca= jtf_marca.getText();
            String color= jtf_color.getText();
            preparadorSentencia= conexion2.prepareStatement("INSERT INTO articulo(clave,estatus,descripcion,idTipoArticulo) VALUES(?,?,?,?)");
            preparadorSentencia.setString(1,clave);
            preparadorSentencia.setString(2,"disponible");
            preparadorSentencia.setString(3,marca+"|"+color+"|");
            preparadorSentencia.setInt(4,3);
            preparadorSentencia.execute();
            JOptionPane.showMessageDialog(null,"se registro la computadora con exito");
        }catch(Exception e)
        {
            throw new Exception("error al agregar la computadora");
        } 
    }
    public void verificarClaveComputadora() throws Exception
    {
         try{
            conexion2= conexion.getConnection();
            String claveArticulo= jtf_clavePC.getText();
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
        jtf_clavePC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_marca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_color = new javax.swing.JTextField();
        jb_agregar = new javax.swing.JButton();
        jb_regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbl_accion = new javax.swing.JLabel();
        jb_nuevo = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modulo Computadora");

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clave");

        jtf_clavePC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_clavePCKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca");

        jtf_marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_marcaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Color");

        jtf_color.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_colorKeyTyped(evt);
            }
        });

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modo:");

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
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jb_agregar)
                        .addGap(42, 42, 42)
                        .addComponent(jb_regresar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_clavePC)
                            .addComponent(jtf_marca, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jtf_color))
                        .addGap(93, 93, 93)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_accion)
                            .addComponent(jb_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_clavePC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(lbl_accion))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_nuevo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_modificar))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_agregar)
                    .addComponent(jb_regresar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(281, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
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
            if (jtf_clavePC.getText().trim().isEmpty() || jtf_marca.getText().trim().isEmpty() || jtf_color.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "no dejar campos vacios");
            } else {
                try {
                    verificarClaveComputadora();
                    ingresarNuevaComputadora();
                    obtenerTodosLasPc();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        else{
            if (jtf_clavePC.getText().trim().isEmpty() || jtf_marca.getText().trim().isEmpty() || jtf_color.getText().trim().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "no dejar campos vacios");
            }
            else{
                try{
                    actualizarPc();
                    JOptionPane.showMessageDialog(null,"se actualizo la PC correctamente");
                    obtenerTodosLasPc();
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }/* if(jtf_clavePC.getText().isEmpty()|| jtf_marca.getText().isEmpty()|| jtf_color.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"No dejar campos vacios");
        }
        else{
            try{
                verificarClaveComputadora();
                ingresarNuevaComputadora();
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }*/       
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        PanelPrincipal panelPrincipal= new PanelPrincipal();
        panelPrincipal.setVisible(true);
        conexion.desconectar();
        this.dispose();
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jb_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_nuevoActionPerformed
        lbl_accion.setText("Nuevo");
        limpiar();
        jtf_clavePC.setEnabled(true);
    }//GEN-LAST:event_jb_nuevoActionPerformed

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        try{
            ponerDatosEnCajasParaActualizar();
            lbl_accion.setText("Modificar");
            jtf_clavePC.setEnabled(false);
       } catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jtf_clavePCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_clavePCKeyTyped
         char character =evt.getKeyChar();
         if(!Character.isLetter(character) && !Character.isDigit(character) && !(Character.getType(character)==15))
         {
             getToolkit().beep();
             evt.consume();
             JOptionPane.showMessageDialog(null, "Ingrese solo números y letras");
         }
          if(jtf_clavePC.getText().length()>=10)
        {
            getToolkit().beep();  
            evt.consume();
        }
    }//GEN-LAST:event_jtf_clavePCKeyTyped

    private void jtf_marcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_marcaKeyTyped
        char character =evt.getKeyChar();
         if(!Character.isLetter(character) && !(Character.getType(character)==15) && !(Character.getType(character)==12))
         {
             getToolkit().beep();
             evt.consume();
             JOptionPane.showMessageDialog(null, "Ingrese solo letras");
         }
         if(jtf_marca.getText().length()>=20)
        {
            getToolkit().beep();  
            evt.consume();
        }
    }//GEN-LAST:event_jtf_marcaKeyTyped

    private void jtf_colorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_colorKeyTyped
        char character =evt.getKeyChar();
         if(!Character.isLetter(character) && !(Character.getType(character)==15) && !(Character.getType(character)==12) )
         {
             getToolkit().beep();
             evt.consume();
             JOptionPane.showMessageDialog(null, "Ingrese solo letras");
         }
         if(jtf_color.getText().length()>=15)
        {
            getToolkit().beep();  
            evt.consume();
        }
    }//GEN-LAST:event_jtf_colorKeyTyped

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
            java.util.logging.Logger.getLogger(PanelAltaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAltaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAltaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAltaComputadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PanelAltaComputadora().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PanelAltaComputadora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jb_nuevo;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JTable jt_tabla;
    private javax.swing.JTextField jtf_clavePC;
    private javax.swing.JTextField jtf_color;
    private javax.swing.JTextField jtf_marca;
    private javax.swing.JLabel lbl_accion;
    // End of variables declaration//GEN-END:variables
}
