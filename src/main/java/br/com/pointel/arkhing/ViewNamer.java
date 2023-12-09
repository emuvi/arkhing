package br.com.pointel.arkhing;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

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
        if (path != null) {
            editNamer.setText(path.getName());
        }
        getRootPane().setDefaultButton(buttonAccept);
        WizSwing.initPositioner(this);
        WizSwing.initEscaper(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTools = new javax.swing.JPopupMenu();
        toolAddIndex = new javax.swing.JMenuItem();
        toolAddParentName = new javax.swing.JMenuItem();
        editNamer = new javax.swing.JTextField();
        buttonTools = new javax.swing.JButton();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        toolAddIndex.setMnemonic('I');
        toolAddIndex.setText("Add Index");
        toolAddIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolAddIndexActionPerformed(evt);
            }
        });
        menuTools.add(toolAddIndex);

        toolAddParentName.setMnemonic('P');
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        editNamer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editNamerKeyPressed(evt);
            }
        });

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
                    .addComponent(editNamer)
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
                .addComponent(editNamer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        onAccept.accept(editNamer.getText());
        WizSwing.close(this);
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        WizSwing.close(this);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void toolAddParentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolAddParentNameActionPerformed
        addOnName(path.getParentFile().getName());
    }//GEN-LAST:event_toolAddParentNameActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        editNamer.setSelectionStart(0);
        editNamer.setSelectionEnd(0);
        editNamer.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void editNamerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editNamerKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
            WizSwing.close(this);
        }
    }//GEN-LAST:event_editNamerKeyPressed

    private void toolAddIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolAddIndexActionPerformed
        try {
            var input = JOptionPane.showInputDialog("Index to add:", "1");
            if (input != null && !input.isBlank()) {
                var addIndex = Integer.valueOf(input);
                if (addIndex == 0) {
                    return;
                }
                var newName = WizChars.getNameWithNewIndex(editNamer.getText(), addIndex);
                editNamer.setText(newName);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_toolAddIndexActionPerformed

    private void addOnName(String text) {
        var oldName = editNamer.getText();
        var prefix = oldName.substring(0, editNamer.getSelectionStart());
        var sufix = oldName.substring(editNamer.getSelectionEnd(), oldName.length());
        editNamer.setText(prefix + text + sufix);
        editNamer.setSelectionStart(prefix.length());
        editNamer.setSelectionEnd(prefix.length() + text.length());
    }
    
    public void close() {
        setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonTools;
    private javax.swing.JTextField editNamer;
    private javax.swing.JPopupMenu menuTools;
    private javax.swing.JMenuItem toolAddIndex;
    private javax.swing.JMenuItem toolAddParentName;
    // End of variables declaration//GEN-END:variables
}
