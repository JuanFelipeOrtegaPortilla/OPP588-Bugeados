package vistaProducto;

import javax.swing.JOptionPane;
import modelo.Producto;
import servicio.ProductoServicio;
import vistaPerfil.Principal;

/**
 *
 * @author IDC
 */
public class ModificarProducto extends javax.swing.JFrame {

    Producto producto = null;
    ProductoServicio controlador = new ProductoServicio();
    int idProducto = 0;

    public void traerID(int id) {
        idProducto = id;
        txtId.setText(String.valueOf(idProducto));
        cargarDatos(idProducto);
    }

    public ModificarProducto() {
        initComponents();
        txtId.setEditable(false);
    }

    public void cargarDatos(int id) {
        producto = controlador.BuscarProductos(id);
        if (this.producto != null) {
            txtNombreProducto.setText(producto.getNombreProducto());
            txtMarca.setText(producto.getMarca());
            spnCantidad.setValue(producto.getCantidad());
            spnPrecio.setValue(producto.getPrecio());
        } else {
            System.out.println("No se puede cargar datos.");

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        txtNombreProducto = new javax.swing.JTextField();
        spnPrecio = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Cantidad");

        jLabel5.setText("Precio");

        jLabel1.setText("Modificacion de producto");

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        spnPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel2.setText("Nombre");

        jLabel3.setText("Marca");

        jLabel6.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(spnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(jbAceptar)
                            .addGap(27, 27, 27)
                            .addComponent(jbCancelar))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spnPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAceptar)
                            .addComponent(jbCancelar))
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        Producto productoModificado = new Producto(Integer.valueOf(txtId.getText()),
                txtNombreProducto.getText(),
                txtMarca.getText(),
                (double) spnPrecio.getValue(),
                (int) spnCantidad.getValue());
        //JOptionPane.showMessageDialog(null, productoModificado.toString());

        if (txtNombreProducto.getText().length() > 0 && txtMarca.getText().length() > 0 && (double) spnPrecio.getValue() > 0) {
            if (controlador.ActualizarProductos(productoModificado)) {
                CrudProducto newframe = new CrudProducto();
                newframe.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "error al actualizar");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campos faltantes");
        }
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        CrudProducto newframe = new CrudProducto();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnPrecio;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
