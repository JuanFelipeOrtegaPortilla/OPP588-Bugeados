/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaProducto;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import servicio.ProductoServicio;
import vistaPerfil.Principal;

/**
 *
 * @author IDC
 */
public class CrudProducto extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    List<Producto> listaProductos = null;
    int id = 0;
    ProductoServicio controlador = new ProductoServicio();

    public CrudProducto() {
        initComponents();
        cargarProductos();
          getContentPane().setBackground(new Color(255, 223, 186));
    }

    public void cargarProductos() {
        cmbProducto.setSelectedItem("Todos");
        listaProductos = ProductoServicio.ListaProductos();
        cargarTablaTodosProductos(listaProductos);
        cargarComboProducto(listaProductos);
    }

    public void cargarComboProducto(List<Producto> listarProductos) {
        for (Producto producto : listarProductos) {
            cmbProducto.addItem(producto.getIdProducto() + " - " + producto.getNombreProducto());
        }
    }

    public void limpiarTabla() {
        modeloTabla = (DefaultTableModel) Tabla.getModel();
        modeloTabla.setRowCount(0);
    }

    public void cargarTablaTodosProductos(List<Producto> listarProductos) {
        limpiarTabla();
        for (Producto producto : listarProductos) {
            modeloTabla.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombreProducto(),
                producto.getMarca(),
                producto.getPrecio(),
                producto.getCantidad()
            });
        }

    }

    public void cargaTablaBusqueda(int idproducto) {
        limpiarTabla();
        Producto producto = controlador.BuscarProductos(idproducto);
        if (producto != null) {
            modeloTabla.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombreProducto(),
                producto.getMarca(),
                producto.getPrecio(),
                producto.getCantidad()
            });
        } else {
            System.out.println("No se encontró ningún producto con el ID: " + idproducto);

        }
    }
    

    public void cerrar() {
        Principal newframe = new Principal();
        newframe.setVisible(true);
        this.dispose();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jbInsertar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tabla de Productos");

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Todos" }));
        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar Producto");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Marca", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jbInsertar.setText("Insertar Nuevo Producto");
        jbInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInsertarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar Producto");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar Producto");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbInsertar)
                            .addGap(34, 34, 34)
                            .addComponent(jbModificar)
                            .addGap(48, 48, 48)
                            .addComponent(jbEliminar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(81, 81, 81)
                            .addComponent(jbBuscar))))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(243, 243, 243))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInsertar)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalir)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (cmbProducto.getSelectedItem() == "Todos") {
            listaProductos = ProductoServicio.ListaProductos();
            cargarTablaTodosProductos(listaProductos);

        } else {
            limpiarTabla();
            String dato = cmbProducto.getSelectedItem().toString();
            String subcadena = dato.substring(0, 3);
            id = Integer.parseInt(subcadena);
            cargaTablaBusqueda(id);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInsertarActionPerformed
        InsertarProducto newframe = new InsertarProducto();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbInsertarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
      int filaSeleccionada = Tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            
            ModificarProducto modificar = new ModificarProducto();
            modificar.traerID(id);
            modificar.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione registro a modificar");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int filaSeleccionada = Tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿seguro de eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

                if (controlador.EliminarProductos(id)) {
                    JOptionPane.showMessageDialog(null, "registro eliminado correctamente!!");
                    modeloTabla.removeRow(filaSeleccionada);
                }
            } else {
                ListSelectionModel seleccionModel = Tabla.getSelectionModel();
                seleccionModel.clearSelection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el registro a eliminar");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        Principal newframe = new Principal();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProductoActionPerformed

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
            java.util.logging.Logger.getLogger(CrudProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbInsertar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
