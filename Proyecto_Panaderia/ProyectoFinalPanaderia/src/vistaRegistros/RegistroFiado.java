package vistaRegistros;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import servicio.ClienteServicio;
import vistaPerfil.Principal;

public class RegistroFiado extends javax.swing.JFrame {

    int mes = 0;
    private DefaultTableModel modeloTabla;
    ClienteServicio controlador = new ClienteServicio();

    public RegistroFiado() {
        initComponents();
        jcFecha.setDate(new Date());
        jcFecha.setEnabled(false);
          getContentPane().setBackground(new Color(255, 223, 186));
    }

    public void limpiarTabla() {
        modeloTabla = (DefaultTableModel) Tabla.getModel();
        modeloTabla.setRowCount(0);
    }

    public void cargarTablaTodosClintes(List<Clientes> listarCliente) {
        limpiarTabla();
        for (Clientes Cliente : listarCliente) {
            modeloTabla.addRow(new Object[]{
                Cliente.getId(),
                Cliente.getNombre(),
                Cliente.getTelefono(),
                Cliente.getTotalCompra(),
                Cliente.getFechaCompra(),
                Cliente.isCancelado(),
                Cliente.getFechaPago()
            });
        }
    }

    public List<Clientes> obtenerClientesDesdeTabla() {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        List<Clientes> listaClientes = new ArrayList<>();
        Date fechaPago=null;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int id = (int) modelo.getValueAt(i, 0);
            String nombre = (String) modelo.getValueAt(i, 1);
            String telefono = (String) modelo.getValueAt(i, 2);
            double totalCompra = (double) modelo.getValueAt(i, 3);
            Date fechaCompra = (Date) modelo.getValueAt(i, 4);
            boolean cancelado= (boolean) modelo.getValueAt(i, 5);
            if (cancelado==true){
                fechaPago=jcFecha.getDate();
            }
            Clientes cliente = new Clientes(id, nombre,"",telefono,fechaPago,fechaCompra,"Fiado",cancelado,totalCompra);
            listaClientes.add(cliente);
        }

        return listaClientes;
    }
    public void cerrar() {
        Principal newframe = new Principal();
        newframe.setVisible(true);
        this.dispose();

    }

    public void mesSelecionado() {
        String Seleccion = (String) cmbMes.getSelectedItem();
        if (Seleccion == "Enero") {
            mes = 1;
        } else if (Seleccion == "Febrero") {
            mes = 2;
        } else if (Seleccion == "Marzo") {
            mes = 3;
        } else if (Seleccion == "Abril") {
            mes = 4;
        } else if (Seleccion == "Mayo") {
            mes = 5;
        } else if (Seleccion == "Junio") {
            mes = 6;
        } else if (Seleccion == "Julio") {
            mes = 7;
        } else if (Seleccion == "Agosto") {
            mes = 8;
        } else if (Seleccion == "Septiembre") {
            mes = 9;
        } else if (Seleccion == "Octubre") {
            mes = 10;
        } else if (Seleccion == "Noviembre") {
            mes = 11;
        } else if (Seleccion == "Diciembre") {
            mes = 12;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jcFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro Fiados");

        jLabel2.setText("Escoja un mes");

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Telefono", "Total Compra", "Fecha Compra", "Cancelado", "Fecha Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addGap(159, 159, 159)
                        .addComponent(jbCancelar)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(113, 113, 113)
                        .addComponent(jcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbGuardar))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        mesSelecionado();
        System.out.println(mes);
        List<Clientes> clientes = controlador.ListaClientePorMes(ClienteServicio.ListaCliente(), mes, "Fiado");
        System.out.println("Clientes obtenidos: " + clientes.size()); // Verifica la cantidad de clientes obtenidos
        cargarTablaTodosClintes(clientes);

    }//GEN-LAST:event_cmbMesActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        cerrar();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        List<Clientes>listaModificar=obtenerClientesDesdeTabla();
        
        for(Clientes cliente: listaModificar){
            System.out.println(cliente.toString());
            controlador.ActualizarClientes(cliente);
        }
        List<Clientes> clientes = controlador.ListaClientePorMes(ClienteServicio.ListaCliente(), mes, "Fiado");
        cargarTablaTodosClintes(clientes);
    }//GEN-LAST:event_jbGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroFiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroFiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroFiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroFiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroFiado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private com.toedter.calendar.JDateChooser jcFecha;
    // End of variables declaration//GEN-END:variables
}
