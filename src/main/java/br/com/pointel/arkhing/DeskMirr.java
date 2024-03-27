package br.com.pointel.arkhing;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DeskMirr extends javax.swing.JPanel {
    
    private final Desk desk;

    public DeskMirr(Desk desk) {
        this.desk = desk;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonExecute = new javax.swing.JButton();
        labelOrigin = new javax.swing.JLabel();
        editOrigin = new javax.swing.JTextField();
        labelDestiny = new javax.swing.JLabel();
        editDestiny = new javax.swing.JTextField();
        buttonOriginSelect = new javax.swing.JButton();
        buttonDestinySelect = new javax.swing.JButton();
        scrollMessages = new javax.swing.JScrollPane();
        textMessages = new javax.swing.JTextArea();
        labelFolderMirror = new javax.swing.JLabel();
        labelSpeed = new javax.swing.JLabel();
        editSpeed = new javax.swing.JSpinner();
        checkClean = new javax.swing.JCheckBox();

        buttonExecute.setText("Execute");
        buttonExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExecuteActionPerformed(evt);
            }
        });

        labelOrigin.setText("Origin:");

        editOrigin.setText(WizProps.get("DESK_MIRR_ORIGIN", ""));

        labelDestiny.setText("Destiny:");

        editDestiny.setText(WizProps.get("DESK_MIRR_DESTINY", ""));

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
        textMessages.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        textMessages.setRows(5);
        scrollMessages.setViewportView(textMessages);

        labelFolderMirror.setText("Folder Mirror");

        labelSpeed.setText("Speed:");

        editSpeed.setModel(new javax.swing.SpinnerNumberModel(4, null, null, 1));

        checkClean.setText("Clean");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollMessages)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFolderMirror)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(checkClean)
                        .addGap(18, 18, 18)
                        .addComponent(labelSpeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExecute))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editOrigin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOriginSelect))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editDestiny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDestinySelect))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOrigin)
                            .addComponent(labelDestiny))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFolderMirror)
                    .addComponent(buttonExecute)
                    .addComponent(editSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSpeed)
                    .addComponent(checkClean))
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
                .addComponent(scrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure?", "Arkhing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != JOptionPane.YES_OPTION) {
            return;
        }
        new FolderMirror(
                new File(editOrigin.getText()), 
                new File(editDestiny.getText()),
                checkClean.isSelected(),
                (Integer) editSpeed.getValue())
        .addObserver((message) -> SwingUtilities.invokeLater(() -> textMessages.append(message + "\n")))
        .start();
    }//GEN-LAST:event_buttonExecuteActionPerformed

    private void buttonOriginSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginSelectActionPerformed
        var selected = WizSwing.selectFolder(new File(editOrigin.getText()));
        if (selected != null) {
            editOrigin.setText(selected.getAbsolutePath());
            WizProps.set("DESK_MIRR_ORIGIN", editOrigin.getText());
        }
    }//GEN-LAST:event_buttonOriginSelectActionPerformed

    private void buttonDestinySelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinySelectActionPerformed
        var selected = WizSwing.selectFolder(new File(editDestiny.getText()));
        if (selected != null) {
            editDestiny.setText(selected.getAbsolutePath());
            WizProps.set("DESK_MIRR_DESTINY", editDestiny.getText());
        }
    }//GEN-LAST:event_buttonDestinySelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDestinySelect;
    private javax.swing.JButton buttonExecute;
    private javax.swing.JButton buttonOriginSelect;
    private javax.swing.JCheckBox checkClean;
    private javax.swing.JTextField editDestiny;
    private javax.swing.JTextField editOrigin;
    private javax.swing.JSpinner editSpeed;
    private javax.swing.JLabel labelDestiny;
    private javax.swing.JLabel labelFolderMirror;
    private javax.swing.JLabel labelOrigin;
    private javax.swing.JLabel labelSpeed;
    private javax.swing.JScrollPane scrollMessages;
    private javax.swing.JTextArea textMessages;
    // End of variables declaration//GEN-END:variables
}
