package br.com.pointel.arkhing;

import java.io.File;
import java.util.function.Consumer;

/**
 *
 * @author emuvi
 */
public class ViewNamer extends javax.swing.JFrame {

    private final File path;
    private final Consumer<String> onAccept;
    
    public ViewNamer(File path, Consumer<String> onAccept) {
        this.path = path;
        this.onAccept = onAccept;
        initComponents();
        textNamer.setText(path.getName());
        getRootPane().setDefaultButton(buttonAccept);
        WizSwing.initPositioner(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTools = new javax.swing.JPopupMenu();
        toolAddParentName = new javax.swing.JMenuItem();
        textNamer = new javax.swing.JTextField();
        buttonTools = new javax.swing.JButton();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        toolAddParentName.setText("Add Parent Name");
        toolAddParentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolAddParentNameActionPerformed(evt);
            }
        });
        menuTools.add(toolAddParentName);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Namer");
        setLocationByPlatform(true);
        setResizable(false);

        buttonTools.setMnemonic('T');
        buttonTools.setText("Tools");
        buttonTools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonToolsActionPerformed(evt);
            }
        });

        buttonAccept.setMnemonic('A');
        buttonAccept.setText("Accept");
        buttonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcceptActionPerformed(evt);
            }
        });

        buttonCancel.setMnemonic('C');
        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNamer)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonTools)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addComponent(buttonAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textNamer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonAccept)
                    .addComponent(buttonTools))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonToolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonToolsActionPerformed
        menuTools.show(buttonTools, 0, buttonTools.getHeight());
    }//GEN-LAST:event_buttonToolsActionPerformed

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        onAccept.accept(textNamer.getText());
        WizSwing.close(this);
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        WizSwing.close(this);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void toolAddParentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolAddParentNameActionPerformed
        addOnName(path.getParentFile().getName());
    }//GEN-LAST:event_toolAddParentNameActionPerformed

    private void addOnName(String text) {
        var oldName = textNamer.getText();
        var prefix = oldName.substring(0, textNamer.getSelectionStart());
        var sufix = oldName.substring(textNamer.getSelectionEnd(), oldName.length());
        textNamer.setText(prefix + text + sufix);
        textNamer.setSelectionStart(prefix.length());
        textNamer.setSelectionEnd(prefix.length() + text.length());
    }
    
    public void close() {
        setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonTools;
    private javax.swing.JPopupMenu menuTools;
    private javax.swing.JTextField textNamer;
    private javax.swing.JMenuItem toolAddParentName;
    // End of variables declaration//GEN-END:variables
}
