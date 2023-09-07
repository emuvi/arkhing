package br.com.pointel.arkhing;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author emuvi
 */
public class DeskName extends javax.swing.JPanel {

    private final Desk desk;
    
    public DeskName(Desk desk) {
        this.desk = desk;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcessName = new javax.swing.JButton();

        btnProcessName.setText("Process Name");
        btnProcessName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProcessName)
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProcessName)
                .addContainerGap(271, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessNameActionPerformed
        var origin = new File("C:\\Users\\emuvi\\Downloads");
        for (var inside : origin.listFiles()) {
            if (inside.getName().startsWith("Aula ")) {
                continue;
            }
            int i = 1;
            var name = "Aula " + (i < 10 ? "0" + i : i) + ".mp4";
            var destiny = new File(origin, name);
            while (destiny.exists()) {
                i++;
                name = "Aula " + (i < 10 ? "0" + i : i) + ".mp4";
                destiny = new File(origin, name);
            }
            inside.renameTo(destiny);
        }
        JOptionPane.showMessageDialog(null, "Done");
    }//GEN-LAST:event_btnProcessNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessName;
    // End of variables declaration//GEN-END:variables
}
