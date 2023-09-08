package br.com.pointel.arkhing;

import java.io.File;

/**
 *
 * @author emuvi
 */
public class DeskDocs extends javax.swing.JPanel {

    private final Desk desk;
    
    public DeskDocs(Desk desk) {
        this.desk = desk;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonExtract = new javax.swing.JButton();

        buttonExtract.setText("Extract");
        buttonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExtractActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonExtract)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonExtract)
                .addContainerGap(271, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private File lastSelectedCheck = null;

    private void buttonExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExtractActionPerformed
        try {
            var selected = WizSwing.select(lastSelectedCheck);
            if (selected != null) {
                lastSelectedCheck = selected;
                new ViewReport(new ArkhDocs(selected).extractText()).setVisible(true);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonExtractActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExtract;
    // End of variables declaration//GEN-END:variables
}
