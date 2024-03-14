/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaSegundoPerfilPedidos;

import vistaPedidos.*;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.swing.JOptionPane;
import modelo.Pedidos;
import modelo.Producto;
import servicio.PedidoServicio;

import servicio.ProductoServicio;


public class InsertarPerdidoPerfil2 extends javax.swing.JFrame {

    public InsertarPerdidoPerfil2() {
        initComponents();
        llenarComboProductos();
        cargarDatos();

        Calendar cal = Calendar.getInstance();
        calendario1.setDate(cal.getTime());

        getContentPane().setBackground(new Color(255, 223, 186));
    }

    public void cargarDatos() {
        try {
            String selectedItem = (String) cmbIdProducto.getSelectedItem();

            if (selectedItem != null && !selectedItem.trim().isEmpty()) {
                String[] partes = selectedItem.split("-");
                int idProducto = Integer.parseInt(partes[0].trim());

                ProductoServicio servicio = new ProductoServicio();
                Producto producto = servicio.BuscarProductos(idProducto);

                if (producto != null) {

                    int idPedidoAleatorio = generarIdAleatorio();
                    txtIdPedido.setText(String.valueOf(idPedidoAleatorio));

                    txtProducto.setText(producto.getNombreProducto());
                    txtPrecio.setText(String.valueOf(producto.getPrecio()));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID del producto: " + idProducto);
                }
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + ex.toString());
        }
    }

    private int generarIdAleatorio() {
        return (int) (Math.random() * 100000);
    }

    private void llenarComboProductos() {
        try {
            ProductoServicio servicio = new ProductoServicio();
            List<Producto> listaProductos = servicio.ListaProductos();

            if (listaProductos != null && !listaProductos.isEmpty()) {
                for (Producto producto : listaProductos) {
                    cmbIdProducto.addItem(producto.getIdProducto() + " - " + producto.getNombreProducto());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar la lista de productos: " + ex.toString());
        }

    }

    private void calcularTotal() {
        try {
            String selectedItem = (String) cmbIdProducto.getSelectedItem();

            if (selectedItem != null && !selectedItem.trim().isEmpty()) {
                String[] partes = selectedItem.split("-");
                int idProducto = Integer.parseInt(partes[0].trim());

                ProductoServicio servicio = new ProductoServicio();
                Producto producto = servicio.BuscarProductos(idProducto);

                if (producto != null) {

                    int cantidad = (int) spCantidad.getValue();

                    double total = producto.getPrecio() * cantidad;
                    txtTotal.setText(String.valueOf(total));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID del producto: " + idProducto);
                }
            } else {
                // Puedes mostrar un mensaje o simplemente no hacer nada cuando no hay producto seleccionado
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al calcular el total: " + ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        spCantidad = new javax.swing.JSpinner();
        btnInsertar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbIdProducto = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdPedido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();
        calendario1 = new com.toedter.calendar.JDateChooser();
        calendarioEntrega = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        chPagado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setText("IdProducto");

        jLabel2.setText("Cantidad");

        jLabel3.setText("Producto");

        jLabel4.setText("Precio");

        spCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spCantidadStateChanged(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Insertar Pedido");

        cmbIdProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbIdProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIdProductoItemStateChanged(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha Pedido");

        jLabel7.setText("Fecha Entrega");

        jLabel8.setText("Total");

        jLabel9.setText("IdPedido");

        jLabel10.setText("Proveedor");

        jLabel11.setText("Cancelado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(116, 116, 116)
                                .addComponent(cmbIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                                    .addGap(116, 116, 116)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIdPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calendario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(92, 92, 92)
                                    .addComponent(calendarioEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbIdProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(calendario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(calendarioEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(chPagado))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
       if (!cmbIdProducto.getSelectedItem().toString().trim().isEmpty()
    && !txtProducto.getText().trim().isEmpty()
    && JOptionPane.showConfirmDialog(this, "¿Seguro que quiere guardar los datos?", "Confirmación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {

    try {
        String dato = cmbIdProducto.getSelectedItem().toString();
        String[] producto = dato.split("-");
        int idProducto = Integer.parseInt(producto[0].trim());

        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaPedidoStr = formatoFecha.format(fechaActual);

        Date fechaEntregaDate = calendarioEntrega.getDate();

String fechaEntregaStr = (fechaEntregaDate != null) ? formatoFecha.format(fechaEntregaDate) : "dd/MM/yyyy";

        Random random = new Random();
        int idPedidoAleatorio = random.nextInt(10000) + 1;

        String nombrePedido = txtPedido.getText();

        txtIdPedido.setText(String.valueOf(idPedidoAleatorio));

        // Crear el objeto Pedidos con la fecha de entrega opcional
        Pedidos insertarPedido = new Pedidos(idProducto, txtProducto.getText(), nombrePedido,
                                (int) spCantidad.getValue(), Double.parseDouble(txtPrecio.getText()),
                                Double.parseDouble(txtTotal.getText()), idPedidoAleatorio,
                                fechaPedidoStr, fechaEntregaStr, chPagado.isSelected());

        if (PedidoServicio.InsertarPedido(insertarPedido)) {
            JOptionPane.showMessageDialog(null, "Registro Ingresado Correctamente");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(null, "Complete todos los campos y confirme la operación");
}

    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres cancelar?", "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            limpiar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        ConsultarPedido consultar = new ConsultarPedido();
        consultar.setVisible(true);
        setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cmbIdProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIdProductoItemStateChanged
        cargarDatos();
    }//GEN-LAST:event_cmbIdProductoItemStateChanged

    private void spCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spCantidadStateChanged
        calcularTotal();
    }//GEN-LAST:event_spCantidadStateChanged
    public void limpiar() {
        txtPedido.setText("");
        txtIdPedido.setText("");
        txtPrecio.setText("");
        txtProducto.setText("");
        cmbIdProducto.setSelectedIndex(0);
        spCantidad.setValue(0);
        txtTotal.setText("");

    }

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
            java.util.logging.Logger.getLogger(InsertarPerdidoPerfil2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarPerdidoPerfil2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarPerdidoPerfil2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarPerdidoPerfil2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarPerdidoPerfil2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser calendario1;
    private com.toedter.calendar.JDateChooser calendarioEntrega;
    private javax.swing.JCheckBox chPagado;
    private javax.swing.JComboBox<String> cmbIdProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JTextField txtIdPedido;
    private javax.swing.JTextField txtPedido;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
