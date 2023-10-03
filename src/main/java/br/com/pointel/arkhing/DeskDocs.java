package br.com.pointel.arkhing;

import java.io.File;
import javax.swing.SwingUtilities;

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
        buttonFolderMirror = new javax.swing.JButton();
        scrollMessages = new javax.swing.JScrollPane();
        textMessages = new javax.swing.JTextArea();

        buttonExtract.setText("Extract");
        buttonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExtractActionPerformed(evt);
            }
        });

        buttonFolderMirror.setText("FolderMirror");
        buttonFolderMirror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderMirrorActionPerformed(evt);
            }
        });

        textMessages.setColumns(20);
        textMessages.setRows(5);
        scrollMessages.setViewportView(textMessages);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonExtract)
                            .addComponent(buttonFolderMirror))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonExtract)
                .addGap(18, 18, 18)
                .addComponent(buttonFolderMirror)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
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

    private void buttonFolderMirrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderMirrorActionPerformed
        var origin = WizSwing.selectFolder(null);
        if (origin == null) return;
        var destiny = WizSwing.selectFolder(null);
        if (destiny == null) return;
        new FolderMirror(origin, destiny)
                .addObserver((message) -> 
                        SwingUtilities.invokeLater(() -> textMessages.append(message + "\n")))
                .start();
    }//GEN-LAST:event_buttonFolderMirrorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExtract;
    private javax.swing.JButton buttonFolderMirror;
    private javax.swing.JScrollPane scrollMessages;
    private javax.swing.JTextArea textMessages;
    // End of variables declaration//GEN-END:variables
}
