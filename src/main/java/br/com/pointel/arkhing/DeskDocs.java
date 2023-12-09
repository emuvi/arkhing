package br.com.pointel.arkhing;

import java.io.File;
import javax.swing.JOptionPane;
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
        buttonExecute = new javax.swing.JButton();
        labelFolderMirror = new javax.swing.JLabel();
        labelOrigin = new javax.swing.JLabel();
        editOrigin = new javax.swing.JTextField();
        labelDestiny = new javax.swing.JLabel();
        editDestiny = new javax.swing.JTextField();
        buttonOriginSelect = new javax.swing.JButton();
        buttonDestinySelect = new javax.swing.JButton();
        scrollMessages = new javax.swing.JScrollPane();
        textMessages = new javax.swing.JTextArea();

        buttonExtract.setText("Extract");
        buttonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExtractActionPerformed(evt);
            }
        });

        buttonExecute.setText("Execute");
        buttonExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExecuteActionPerformed(evt);
            }
        });

        labelFolderMirror.setText("Folder Mirror");

        labelOrigin.setText("Origin:");

        editOrigin.setText(WizProps.get("DESK_DOCS_ORIGIN", ""));

        labelDestiny.setText("Destiny:");

        editDestiny.setText(WizProps.get("DESK_DOCS_DESTINY", ""));

        buttonOriginSelect.setText("Select");
        buttonOriginSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginSelectActionPerformed(evt);
            }
        });

        buttonDestinySelect.setText("Select");
        buttonDestinySelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinySelectActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editDestiny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDestinySelect))
                    .addComponent(scrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonExtract)
                            .addComponent(labelOrigin)
                            .addComponent(labelDestiny))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editOrigin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginSelect))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFolderMirror)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonExecute)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonExtract)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFolderMirror)
                    .addComponent(buttonExecute))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelOrigin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOriginSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDestiny)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDestinySelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
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

    private void buttonExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure?", "Arkhing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != JOptionPane.YES_OPTION) {
            return;
        }
        new FolderMirror(
                new File(editOrigin.getText()),
                new File(editDestiny.getText()))
                .addObserver((message)
                        -> SwingUtilities.invokeLater(() -> textMessages.append(message + "\n")))
                .start();
    }//GEN-LAST:event_buttonExecuteActionPerformed

    private void buttonOriginSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginSelectActionPerformed
        var selected = WizSwing.selectFolder(new File(editOrigin.getText()));
        if (selected != null) {
            editOrigin.setText(selected.getAbsolutePath());
            WizProps.set("DESK_DOCS_ORIGIN", editOrigin.getText());
        }
    }//GEN-LAST:event_buttonOriginSelectActionPerformed

    private void buttonDestinySelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinySelectActionPerformed
        var selected = WizSwing.selectFolder(new File(editDestiny.getText()));
        if (selected != null) {
            editDestiny.setText(selected.getAbsolutePath());
            WizProps.set("DESK_DOCS_DESTINY", editDestiny.getText());
        }
    }//GEN-LAST:event_buttonDestinySelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDestinySelect;
    private javax.swing.JButton buttonExecute;
    private javax.swing.JButton buttonExtract;
    private javax.swing.JButton buttonOriginSelect;
    private javax.swing.JTextField editDestiny;
    private javax.swing.JTextField editOrigin;
    private javax.swing.JLabel labelDestiny;
    private javax.swing.JLabel labelFolderMirror;
    private javax.swing.JLabel labelOrigin;
    private javax.swing.JScrollPane scrollMessages;
    private javax.swing.JTextArea textMessages;
    // End of variables declaration//GEN-END:variables
}
