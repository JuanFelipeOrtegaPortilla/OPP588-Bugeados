/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaPerfil;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import vista.NuevaCompra;
import vistaExtras.ConsutarExtras;
import vistaPedidos.ConsultarPedido;
import vistaProducto.CrudProducto;
import vistaRegistros.RegistroDeUna;
import vistaRegistros.RegistroEfectivo;
import vistaRegistros.RegistroFiado;
import vistaSegundoPerfilPedidos.ConsultarPedidoPerfil2;

/**
 *
 * @author IDC
 */
public class Principal2 extends javax.swing.JFrame {


     public Principal2() {
        initComponents();
        ImageIcon imagenFondo = new ImageIcon("C:\\Users\\PIPE\\OneDrive\\Documentos\\OPP588-Bugeados\\Proyecto_Panaderia\\ProyectoFinalPanaderia\\src\\Imagenes\\Pan.jpg");

        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        panelFondo.setLayout(null);

        JButton boton = new JButton("Nueva Compra");
        boton.setBounds(100, 100, 200, 50);
        boton.setBackground(new Color(255, 255, 102)); // Amarillo suave
        boton.addActionListener(e -> {
            NuevaCompra newframe = new NuevaCompra();
            newframe.setVisible(true);
            dispose();
        });
        panelFondo.add(boton);

        setContentPane(panelFondo);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jbNuevaCompra = new javax.swing.JButton();
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jbNuevaCompra)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jbNuevaCompra)
                .addContainerGap(134, Short.MAX_VALUE))
        );

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
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaCompraActionPerformed
        NuevaCompra newframe = new NuevaCompra();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbNuevaCompraActionPerformed

    private void jbExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExtrasActionPerformed
        ConsultarPedidoPerfil2 newframe = new ConsultarPedidoPerfil2();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbExtrasActionPerformed

    private void jbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidosActionPerformed
        ConsultarPedidoPerfil2 newframe = new ConsultarPedidoPerfil2();
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
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal2().setVisible(true);
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
    // End of variables declaration//GEN-END:variables
}
