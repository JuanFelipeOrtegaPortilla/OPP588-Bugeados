package vistaPerfil;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Perfil;
import modelo.Producto;
import servicio.PerfilServicio;
import servicio.ProductoServicio;
import vistaProducto.ModificarProducto;

public class CrudPerfil extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    List<Perfil> listaPerfiles = null;
    int id = 0;
    PerfilServicio controlador = new PerfilServicio();

    public CrudPerfil() {
        initComponents();
        cargarPerfiles();
          getContentPane().setBackground(new Color(255, 223, 186));
    }

    public void cargarPerfiles() {
        listaPerfiles = PerfilServicio.ListaPerfil();
        cargarTablaTodosPerfiles(listaPerfiles);
    }

    public void limpiarTabla() {
        modeloTabla = (DefaultTableModel) TablaPerfil.getModel();
        modeloTabla.setRowCount(0);
    }

    public void cargarTablaTodosPerfiles(List<Perfil> listarPerfiles) {
        limpiarTabla();
        for (Perfil perfil : listarPerfiles) {
            modeloTabla.addRow(new Object[]{
                perfil.getId_perfil(),
                perfil.getNombrePerfil(),
                (String)perfil.getTipoUsuario(),
                (String)perfil.getDescripcion()
            });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPerfil = new javax.swing.JTable();
        jbInsertar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro de perfiles");

        TablaPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Tipo", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaPerfil);

        jbInsertar.setText("Insertar");
        jbInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInsertarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbInsertar)
                                .addGap(39, 39, 39)
                                .addComponent(jbActualizar)
                                .addGap(41, 41, 41)
                                .addComponent(jbBorrar)))))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInsertar)
                    .addComponent(jbActualizar)
                    .addComponent(jbBorrar))
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInsertarActionPerformed
        InsertarPerfil newframe = new InsertarPerfil();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbInsertarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        int filaSeleccionada =TablaPerfil.getSelectedRow() ;
        if (filaSeleccionada >= 0) {
            id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

            ActualizarPerfil modificar = new ActualizarPerfil ();
            modificar.traerID(id);
            modificar.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione registro a modificar");
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        int filaSeleccionada = TablaPerfil.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿seguro de eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

                if (controlador.EliminarPerfil(id)) {
                    JOptionPane.showMessageDialog(null, "registro eliminado correctamente!!");
                    modeloTabla.removeRow(filaSeleccionada);
                }
            } else {
                ListSelectionModel seleccionModel = TablaPerfil.getSelectionModel();
                seleccionModel.clearSelection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el registro a eliminar");
        }
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        cerrar();
    }//GEN-LAST:event_jbSalirActionPerformed

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
            java.util.logging.Logger.getLogger(CrudPerfil.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudPerfil.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudPerfil.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudPerfil.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbInsertar;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
