/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaPedidos;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Pedidos;
import modelo.Producto;
import servicio.PedidoServicio;
import servicio.ProductoServicio;
import vista.Principal;

/**
 *
 * @author PIPE
 */
public class ConsultarPedido extends javax.swing.JFrame {
    
    private DefaultTableModel modeloTabla;
    private List<Pedidos> listaPedidos;
    int id = 0;
    

    public ConsultarPedido() {
        initComponents();
        CargarPedidos();
        cmbMarca.addActionListener((e) -> cargarTablaPedidoSeleccionado());
        getContentPane().setBackground(new Color(255, 223, 186)); 
    }

 public void CargarPedidos() {
    cmbMarca.removeAllItems();
    cmbMarca.addItem("Todos");

    PedidoServicio pedidoServicio = new PedidoServicio();
    listaPedidos = pedidoServicio.ListarPedidos();

    cargarTablaTodosPedidos(listaPedidos);
    cargarComboIdPedidos(listaPedidos);

    cmbMarca.setSelectedItem("Todos");
}

public void cargarComboIdPedidos(List<Pedidos> listaPedidos) {
    for (Pedidos pedido : listaPedidos) {
        cmbMarca.addItem(pedido.getIdPedido() + "-" + pedido.getPedido());
    }
}

public void limpiarTabla() {
    modeloTabla = (DefaultTableModel) tblPedidos.getModel();
    modeloTabla.setRowCount(0);
}


   public void cargarTablaTodosPedidos(List<Pedidos> listaPedidos) {
    limpiarTabla();
    for (Pedidos pedido : listaPedidos) {
        modeloTabla.addRow(new Object[]{
            pedido.getIdPedido(),
            pedido.getPedido(),
            pedido.getProducto(),
            pedido.getCantidad(),
            pedido.getFechaPedido(),
            pedido.getFechaEntrega(),
            pedido.getPrecio(),
            pedido.getTotal(),
            pedido.isPagado()
        });
    }
}


    public void cargarTablaPedidoSeleccionado() {
    limpiarTabla();

    String selectedItem = (String) cmbMarca.getSelectedItem();

    if ("Todos".equalsIgnoreCase(selectedItem)) {
        cargarTablaTodosPedidos(listaPedidos);
    } else {
        try {
            int idPedido = Integer.parseInt(selectedItem.split("-")[0].trim());
            Pedidos pedido = new PedidoServicio().BuscarIdPedido(idPedido);

            if (pedido != null) {
             
                String fechaPedido = formatearFecha(pedido.getFechaPedido());
                String fechaEntrega = formatearFecha(pedido.getFechaEntrega());

                modeloTabla.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getPedido(),
                    pedido.getProducto(),
                    pedido.getCantidad(),
                    fechaPedido,
                    fechaEntrega,
                    pedido.getPrecio(),
                    pedido.getTotal(),
                    pedido.isPagado()
                });
            } else {
                JOptionPane.showMessageDialog(this, "Pedido no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar el ID del pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private String formatearFecha(String fecha) {
    try {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatoEntrada.parse(fecha);
        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy"); 
        return formatoSalida.format(date);
    } catch (ParseException e) {
        e.printStackTrace();  
        return fecha;  
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbMarca = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnInsertarPedidos = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Marca", "Producto", "Cantidad", "Fecha Pedido", "Fecha Entrega", "Precio", "Total", "Pagado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPedidos);

        btnInsertarPedidos.setText("Insertar");
        btnInsertarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarPedidosActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnInsertarPedidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarPedidos)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnSalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarPedidosActionPerformed
        InsertarPerdido insertar = new InsertarPerdido();
        insertar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnInsertarPedidosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       int filaSeleccionada = tblPedidos.getSelectedRow();

if (filaSeleccionada >= 0) {
    int confirmar = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

    if (confirmar == JOptionPane.YES_OPTION) {
        int idPedido = Integer.parseInt(String.valueOf(modeloTabla.getValueAt(filaSeleccionada, 0)));

        if (PedidoServicio.EliminarPedido(idPedido)) {
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            modeloTabla.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
        }
    } else {
      
        tblPedidos.getSelectionModel().clearSelection();
    }
} else {
    JOptionPane.showMessageDialog(null, "Seleccione el registro para eliminar");
}

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         Principal salir = new Principal();
        salir.setVisible(true);
        setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
  int filaSeleccionada = tblPedidos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            
            ModificarPedido modificar = new ModificarPedido();
            modificar.traerID(id);
            modificar.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione registro a modificar");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertarPedidos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables
}
