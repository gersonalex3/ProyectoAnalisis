/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import proyectoanalisis.ProyectoAnalisis;

/**
 *
 * @author alx_g
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNuevo = new javax.swing.JMenu();
        jMenuNota = new javax.swing.JMenuItem();
        jMenuPersonal = new javax.swing.JMenuItem();
        jMenuAldea = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnCerrar.setBackground(new java.awt.Color(236, 211, 4));
        jBtnCerrar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jBtnCerrar.setForeground(new java.awt.Color(6, 5, 195));
        jBtnCerrar.setText("Cerrar Sesión");
        jBtnCerrar.setBorder(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Home.png"))); // NOI18N

        jMenuNuevo.setText("Nuevo");

        jMenuNota.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuNota.setText("Nota de Trabajo");
        jMenuNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNotaActionPerformed(evt);
            }
        });
        jMenuNuevo.add(jMenuNota);

        jMenuPersonal.setText("Personal");
        jMenuPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPersonalActionPerformed(evt);
            }
        });
        jMenuNuevo.add(jMenuPersonal);

        jMenuAldea.setText("Aldea");
        jMenuAldea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAldeaActionPerformed(evt);
            }
        });
        jMenuNuevo.add(jMenuAldea);

        jMenuItem1.setText("Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuNuevo.add(jMenuItem1);

        jMenuBar1.add(jMenuNuevo);

        jMenuReportes.setText("Reportes");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Nuevo Reporte");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItem2);

        jMenuBar1.add(jMenuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(864, 864, 864)
                .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNotaActionPerformed

        ProyectoAnalisis.NuevaNota();
    }//GEN-LAST:event_jMenuNotaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        ProyectoAnalisis.NuevoReporte();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPersonalActionPerformed
        ProyectoAnalisis.NuevoPersonal();
    }//GEN-LAST:event_jMenuPersonalActionPerformed

    private void jMenuAldeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAldeaActionPerformed
        ProyectoAnalisis.NuevaAldea();
    }//GEN-LAST:event_jMenuAldeaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ProyectoAnalisis.NuevoUsuario();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnCerrar;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JMenuItem jMenuAldea;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuNota;
    private javax.swing.JMenu jMenuNuevo;
    public javax.swing.JMenuItem jMenuPersonal;
    public javax.swing.JMenu jMenuReportes;
    // End of variables declaration//GEN-END:variables
}
