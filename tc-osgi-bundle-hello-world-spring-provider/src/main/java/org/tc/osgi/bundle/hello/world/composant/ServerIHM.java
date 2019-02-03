
public class ServerIHM extends javax.swing.JFrame {

    public ServerIHM() {
        initComponents();
    }
    
    private void initComponents() {//GEN-BEGIN:initComponents
        server = new Server();
        jLabel1 = new javax.swing.JLabel();
        delay = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        output = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabel1.setText("delay");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 25, 14);

        delay.setText("100");
        delay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delayActionPerformed(evt);
            }
        });

        getContentPane().add(delay);
        delay.setBounds(200, 20, 29, 19);

        jButton1.setText("Bouton START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1);
        jButton1.setBounds(10, 80, 370, 23);

        jButton2.setText("Bouton STOP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton2);
        jButton2.setBounds(11, 120, 370, 23);

        output.setText("jTextField1");
        output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputActionPerformed(evt);
            }
        });

        getContentPane().add(output);
        output.setBounds(100, 180, 190, 50);

        pack();
    }//GEN-END:initComponents

    private void outputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        server.stop();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        server.setDelay(Long.parseLong(delay.getText()));
        server.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void delayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delayActionPerformed
       //delay.setText((String)server.getDelay());
    }//GEN-LAST:event_delayActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    

    public static void main(String args[]) {
        new ServerIHM().show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField delay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField output;
    private Server server;
    // End of variables declaration//GEN-END:variables
    
}
