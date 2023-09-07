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

        buttonProcessDocs = new javax.swing.JButton();

        buttonProcessDocs.setText("Process Docs");
        buttonProcessDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcessDocsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonProcessDocs)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonProcessDocs)
                .addContainerGap(271, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonProcessDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcessDocsActionPerformed
        new ArkhDocs(new File("C:\\Users\\emuvi\\Downloads\\Teste.docx")).print();
    }//GEN-LAST:event_buttonProcessDocsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonProcessDocs;
    // End of variables declaration//GEN-END:variables
}
