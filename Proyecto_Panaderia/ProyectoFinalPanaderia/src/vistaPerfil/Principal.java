/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaPerfil;

import vista.NuevaCompra;
import vistaExtras.ConsutarExtras;
import vistaPedidos.ConsultarPedido;
import vistaProducto.CrudProducto;
import vistaRegistros.RegistroDeUna;
import vistaRegistros.RegistroEfectivo;
import vistaRegistros.RegistroFiado;

/**
 *
 * @author IDC
 */
public class Principal extends javax.swing.JFrame {


    public Principal() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jbNuevaCompra = new javax.swing.JButton();
        jbProductos = new javax.swing.JButton();
        jbPerfiles = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jbPedidos = new javax.swing.JMenuItem();
        jbExtras = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jbDeUna = new javax.swing.JMenuItem();
        jbEfectivo = new javax.swing.JMenuItem();
        jbFiado = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbNuevaCompra.setText("Nueva Compra");
        jbNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jbNuevaCompra)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jbNuevaCompra)
                .addGap(115, 115, 115))
        );

        jbProductos.setText("Productos");
        jbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductosActionPerformed(evt);
            }
        });

        jbPerfiles.setText("Perfiles");
        jbPerfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPerfilesActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        jbPedidos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jbPedidos.setText("Pedidos");
        jbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidosActionPerformed(evt);
            }
        });
        jMenu1.add(jbPedidos);

        jbExtras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jbExtras.setText("Extras");
        jbExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExtrasActionPerformed(evt);
            }
        });
        jMenu1.add(jbExtras);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registros");

        jbDeUna.setText("Registro De Una");
        jbDeUna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeUnaActionPerformed(evt);
            }
        });
        jMenu2.add(jbDeUna);

        jbEfectivo.setText("Registro Efectivo");
        jbEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEfectivoActionPerformed(evt);
            }
        });
        jMenu2.add(jbEfectivo);

        jbFiado.setText("Registro Fiado");
        jbFiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiadoActionPerformed(evt);
            }
        });
        jMenu2.add(jbFiado);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbProductos)
                    .addComponent(jbPerfiles))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPerfiles)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaCompraActionPerformed
        NuevaCompra newframe = new NuevaCompra();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbNuevaCompraActionPerformed

    private void jbExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExtrasActionPerformed
        ConsutarExtras newframe = new ConsutarExtras();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbExtrasActionPerformed

    private void jbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidosActionPerformed
        ConsultarPedido newframe = new ConsultarPedido();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbPedidosActionPerformed

    private void jbFiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiadoActionPerformed
        RegistroFiado newframe = new RegistroFiado();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbFiadoActionPerformed

    private void jbDeUnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeUnaActionPerformed
        RegistroDeUna newframe = new RegistroDeUna();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbDeUnaActionPerformed

    private void jbEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEfectivoActionPerformed
        RegistroEfectivo newframe = new RegistroEfectivo();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbEfectivoActionPerformed

    private void jbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductosActionPerformed
        CrudProducto newframe = new CrudProducto();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbProductosActionPerformed

    private void jbPerfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPerfilesActionPerformed
        CrudPerfil newframe = new CrudPerfil();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbPerfilesActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jbDeUna;
    private javax.swing.JMenuItem jbEfectivo;
    private javax.swing.JMenuItem jbExtras;
    private javax.swing.JMenuItem jbFiado;
    private javax.swing.JButton jbNuevaCompra;
    private javax.swing.JMenuItem jbPedidos;
    private javax.swing.JButton jbPerfiles;
    private javax.swing.JButton jbProductos;
    // End of variables declaration//GEN-END:variables
}