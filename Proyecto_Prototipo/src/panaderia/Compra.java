package panaderia;


import com.mongodb.DB;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static java.lang.Character.toUpperCase;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author IDC
 */
public class Compra extends javax.swing.JFrame {

    Conexion conn = new Conexion();
    MongoDatabase database;
    DB db;
    private Object vicantidad;
    private DefaultTableModel dtm = new DefaultTableModel();
    private double precio = 0;
    private String FechaPago;

    public Compra() {
        if (conn != null) {
            conn = conn.crearConexion();
            database = conn.getDataB();
        }
        initComponents();
        vicantidad = spnCantidad.getValue();
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        txtNombre.setVisible(false);
        txtNombre.setText("");
        txtTelefono.setVisible(false);
        txtTelefono.setText("");
        txtCuenta.setVisible(false);
        txtTotal.setText("");
        txtCuenta.setText("");
        jcFecha.setDate(new Date());
        jcFecha.setEnabled(false);
        dtm.addColumn("Producto");
        dtm.addColumn("Cantidad");
        dtm.addColumn("Precio");
        this.Tabla.setModel(dtm);
    }

    /* public void limpiar() {
        cmbProducto.setSelectedIndex(0);
        spnCantidad.setValue(vicantidad);
        cmbCliente.setSelectedIndex(0);
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }*/
    public double calcularTotal() {
        double total = 0.0;
        for (int row = 0; row < dtm.getRowCount(); row++) {
            Double precio = (Double) dtm.getValueAt(row, 2);
            total = total + precio;
        }
        return total;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCliente = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jbQuitar = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jcFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione metodo de pago", "Efectivo", "De Una", "Fiado" }));
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel1.setText("nombre");

        jLabel2.setText("telefono");

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel3.setText("no. Cuenta");

        txtCuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCuentaFocusLost(evt);
            }
        });
        txtCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaKeyTyped(evt);
            }
        });

        jLabel4.setText("Producto");

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "huevo", "cafe", "leche", "jamon", "pan", "dona", "pastel", " " }));
        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad");

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabla);

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbQuitar.setText("Quitar");
        jbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitarActionPerformed(evt);
            }
        });

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jLabel6.setText("total");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jbAgregar)
                                                .addGap(39, 39, 39)
                                                .addComponent(jbQuitar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(81, 81, 81)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jbAceptar)))
                                .addGap(18, 18, 18)
                                .addComponent(jbCancelar)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3))
                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45))
                            .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbQuitar)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbAceptar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed
        String seleccion = (String) cmbProducto.getSelectedItem();
        if (seleccion.equals("huevo")) {
            precio = 0.15;
        } else if (seleccion.equals("leche")) {
            precio = 0.90;
        } else if (seleccion.equals("cafe")) {
            precio = 0.35;
        } else if (seleccion.equals("jamon")) {
            precio = 0.80;
        } else if (seleccion.equals("pan")) {
            precio = 0.15;
        } else if (seleccion.equals("dona")) {
            precio = 0.50;
        } else if (seleccion.equals("pastel")) {
            precio = 5.00;
        }


    }//GEN-LAST:event_cmbProductoActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        String seleccion = (String) cmbCliente.getSelectedItem();
        if (seleccion.equals("Efectivo")) {
            jLabel1.setVisible(false);
            txtNombre.setVisible(false);
            jLabel2.setVisible(false);
            txtTelefono.setVisible(false);
            jLabel3.setVisible(false);
            txtCuenta.setVisible(false);
            FechaPago = jcFecha.getDateFormatString();
        } else if (seleccion.equals("De Una")) {
            jLabel1.setVisible(true);
            txtNombre.setVisible(true);
            jLabel2.setVisible(false);
            txtTelefono.setVisible(false);
            jLabel3.setVisible(true);
            txtCuenta.setVisible(true);
            FechaPago = jcFecha.getDateFormatString();
        } else if (seleccion.equals("Fiado")) {
            jLabel1.setVisible(true);
            txtNombre.setVisible(true);
            jLabel2.setVisible(true);
            txtTelefono.setVisible(true);
            jLabel3.setVisible(false);
            txtCuenta.setVisible(false);
            FechaPago = "no cancelado";
        }
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

        if (cmbProducto.getSelectedItem() != "...") {
            Double valor = precio * ((Integer) spnCantidad.getValue()).doubleValue();

            dtm.addRow(new Object[]{cmbProducto.getSelectedItem(), spnCantidad.getValue(), valor});
            txtTotal.setText(String.valueOf(calcularTotal()));
        } else {
            JOptionPane.showMessageDialog(null, "falta ingresar un producto");
        }

    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarActionPerformed
        int fila = Tabla.getSelectedRow();
        if (fila >= 0) {
            dtm.removeRow(fila);
            txtTotal.setText(String.valueOf(calcularTotal()));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_jbQuitarActionPerformed

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        MongoCollection coleccion = database.getCollection("ventas");
        //crear documento productos
        Document Productos = new Document();
        for (int row = 0; row < dtm.getRowCount(); row++) {
            String columnName = dtm.getColumnName(0);
            String cellValue = String.valueOf(dtm.getValueAt(row, 0));
            Productos.append(columnName + (row + 1), cellValue);
        }
        String seleccion = (String) cmbCliente.getSelectedItem();
        if (seleccion.equals("Efectivo")) {
            //crear documento a guardar en la coleccion
            Document documento = new Document("nombre", null)
                    .append("Telefono", null)
                    .append("Cuenta", null)
                    .append("Productos", Productos)
                    .append("Total", txtTotal.getText())
                    .append("Cliente", cmbCliente.getSelectedItem())
                    .append("fechaCompra", jcFecha.getDate())
                    .append("FechaPago", jcFecha.getDate());
            coleccion.insertOne(documento);
            JOptionPane.showMessageDialog(null, "Compra exitosa");
            Principal newframe = new Principal();
            newframe.setVisible(true);
            this.dispose();
        } else if (seleccion.equals("De Una")) {
            if (txtNombre.getText().length()>0 && txtCuenta.getText().length()>0) {
                //crear documento a guardar en la coleccion
                Document documento = new Document("nombre", txtNombre.getText())
                        .append("Telefono", null)
                        .append("Cuenta", txtCuenta.getText())
                        .append("Productos", Productos)
                        .append("Total", txtTotal.getText())
                        .append("Cliente", cmbCliente.getSelectedItem())
                        .append("fechaCompra", jcFecha.getDate())
                        .append("FechaPago", jcFecha.getDate());
                coleccion.insertOne(documento);
                JOptionPane.showMessageDialog(null, "Compra exitosa");
                Principal newframe = new Principal();
                newframe.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Campos faltantes");
            }

        } else if (seleccion.equals("Fiado")) {
            if (txtNombre.getText().length()>0 && txtTelefono.getText().length()>0) {
                //crear documento a guardar en la coleccion
                Document documento = new Document("nombre", txtNombre.getText())
                        .append("Telefono", txtTelefono.getText())
                        .append("Cuenta", null)
                        .append("Productos", Productos)
                        .append("Total", txtTotal.getText())
                        .append("Cliente", cmbCliente.getSelectedItem())
                        .append("fechaCompra", jcFecha.getDate())
                        .append("FechaPago", FechaPago);
                coleccion.insertOne(documento);
                JOptionPane.showMessageDialog(null, "Compra exitosa");
                Principal newframe = new Principal();
                newframe.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Campos faltantes");
            }
        } else {
            JOptionPane.showMessageDialog(null, "tipo de pago no seleccionado");
        }
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        String botones[] = {"si", "no"};
        int eleccion = JOptionPane.showOptionDialog(this, "Desea cancelar la compra?", "Titulo", 0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            Principal newframe = new Principal();
            newframe.setVisible(true);
            this.dispose();
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }


    }//GEN-LAST:event_jbCancelarActionPerformed

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        txtNombre.setText(toUpperCase(txtNombre.getText().charAt(0)) + txtNombre.getText().substring(1));
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "imprimir solo letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isLetter(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "imprimir solo numeros");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isLetter(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "imprimir solo numeros");
        }
    }//GEN-LAST:event_txtCuentaKeyTyped

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        while (txtTelefono.getText().length() < 10) {
            JOptionPane.showMessageDialog(null, "telefono incompleto");
            txtTelefono.setText("");
            break;
        }
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtCuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCuentaFocusLost
        while (txtCuenta.getText().length() < 10) {
            JOptionPane.showMessageDialog(null, "telefono incompleto");
            txtTelefono.setText("");
            break;
        }
    }//GEN-LAST:event_txtCuentaFocusLost

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
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbQuitar;
    private com.toedter.calendar.JDateChooser jcFecha;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
