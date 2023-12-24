package br.com.pointel.arkhing;

import java.io.File;
import javax.swing.JOptionPane;

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
        btnProcessName = new javax.swing.JButton();

        buttonExtract.setText("Extract");
        buttonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExtractActionPerformed(evt);
            }
        });

        btnProcessName.setText("Hard Rename");
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
                .addComponent(buttonExtract)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(btnProcessName)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExtract)
                    .addComponent(btnProcessName))
                .addContainerGap(269, Short.MAX_VALUE))
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
    private javax.swing.JButton buttonExtract;
    // End of variables declaration//GEN-END:variables
}
