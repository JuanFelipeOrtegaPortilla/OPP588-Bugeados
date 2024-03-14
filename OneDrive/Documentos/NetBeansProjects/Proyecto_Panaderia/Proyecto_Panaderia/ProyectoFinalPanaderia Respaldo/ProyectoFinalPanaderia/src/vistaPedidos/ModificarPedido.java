/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaPedidos;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Extras;
import modelo.Pedidos;
import modelo.Producto;
import servicio.PedidoServicio;
import servicio.ProductoServicio;

/**
 *
 * @author PIPE
 */
public class ModificarPedido extends javax.swing.JFrame {

    public ModificarPedido() {
        initComponents();
        llenarComboProductos();
        cargarDatosModificar();
    
        

        Calendar cal = Calendar.getInstance();
        calendarioEntrega.setDate(cal.getTime());

        getContentPane().setBackground(new Color(255, 223, 186));
    }

    public void cargarDatosModificar() {
        try {
            String selectedItem = (String) cmbIdProducto.getSelectedItem();

            if (selectedItem != null && !selectedItem.trim().isEmpty()) {
                String[] partes = selectedItem.split("-");
                int idPedido = Integer.parseInt(partes[0].trim());

                PedidoServicio servicio = new PedidoServicio();
                Pedidos pedido = servicio.BuscarIdPedido(idPedido);

                if (pedido != null) {
                    txtMarca.setText(pedido.getPedido()); 
                    txtProducto.setText(pedido.getProducto());
                    spCantidad.setValue(pedido.getCantidad());
                    txtPrecio.setText(String.valueOf(pedido.getPrecio()));
                    txtTotal.setText(String.valueOf(pedido.getTotal()));

                } else {
                    limpiar();
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID del pedido: " + idPedido,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                limpiar();
                JOptionPane.showMessageDialog(null, "Seleccione un ID de pedido válido", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            limpiar();
            JOptionPane.showMessageDialog(null, "Seleccione un ID de pedido válido", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + ex.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboProductos() {
        try {
            PedidoServicio servicio = new PedidoServicio();
            List<Pedidos> listaPedidos = servicio.ListarPedidos();

            if (listaPedidos != null && !listaPedidos.isEmpty()) {
                for (Pedidos pedido : listaPedidos) {
                    cmbIdProducto.addItem(pedido.getIdPedido() + " - " + pedido.getPedido());
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

                System.out.println("ID del producto seleccionado: " + idProducto);  // Agregar esta línea

                ProductoServicio servicio = new ProductoServicio();
                Producto producto = servicio.BuscarProductos(idProducto);

                if (producto != null) {
                    double total = producto.getPrecio() * producto.getCantidad();
                    System.out.println("Total calculado: " + total);  // Agregar esta línea
                    txtTotal.setText(String.valueOf(total));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID del producto: " + idProducto);
                }
            } else {
               
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al calcular el total: " + ex.toString());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbIdProducto = new javax.swing.JComboBox<>();
        txtTotal = new javax.swing.JTextField();
        calendario1 = new com.toedter.calendar.JDateChooser();
        calendarioEntrega = new com.toedter.calendar.JDateChooser();
        spCantidad = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        chPagado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("IdPedido");

        jLabel2.setText("Cantidad");

        jLabel9.setText("Marca");

        jLabel3.setText("Producto");

        jLabel4.setText("Precio");

        jLabel6.setText("Fecha Pedido");

        jLabel7.setText("Fecha Entrega");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Modificar Pedido");

        jLabel8.setText("Total");

        cmbIdProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIdProductoItemStateChanged(evt);
            }
        });

        jLabel10.setText("Pagado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(btnActualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRegresar)
                                        .addGap(68, 68, 68))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(cmbIdProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(chPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(calendario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(calendarioEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(chPagado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(calendario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(calendarioEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnRegresar))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
try {
    int idProducto = Integer.parseInt(cmbIdProducto.getSelectedItem().toString());
   
    Date fechaSeleccionada = calendarioEntrega.getDate();

    if (fechaSeleccionada != null) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaSeleccionadaStr = formatoFecha.format(fechaSeleccionada);

        Pedidos pedidosActualizados = new Pedidos(idProducto,
                fechaSeleccionadaStr, 
                chPagado.isSelected());
S
        JOptionPane.showMessageDialog(null, pedidosActualizados.toString());

        if (chPagado.isSelected()) {
            if (PedidoServicio.ActualizarPedidos(pedidosActualizados)) {
                ConsultarPedido newframe = new ConsultarPedido();
                newframe.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, marque la casilla de pago");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha");
    }
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Error de formato en el id del producto");
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
}

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        ConsultarPedido consultar = new ConsultarPedido();
        consultar.setVisible(true);
        setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmbIdProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIdProductoItemStateChanged
        cargarDatosModificar();
    }//GEN-LAST:event_cmbIdProductoItemStateChanged
    public void regresarConsultaPedidos() {

        ConsultarPedido consultaPedidos = new ConsultarPedido();
        consultaPedidos.setVisible(true);
        this.dispose();
    }

    public void limpiar() {
        txtMarca.setText("");
        spCantidad.setValue(0);
        txtPrecio.setText("");
        txtProducto.setText("");
        txtTotal.setText("");
        cmbIdProducto.setSelectedItem(0);
        calendario1.setDate(null);
        calendarioEntrega.setDate(null);
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
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnRegresar;
    private com.toedter.calendar.JDateChooser calendario1;
    private com.toedter.calendar.JDateChooser calendarioEntrega;
    private javax.swing.JCheckBox chPagado;
    private javax.swing.JComboBox<String> cmbIdProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
