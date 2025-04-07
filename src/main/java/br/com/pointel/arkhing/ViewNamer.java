package br.com.pointel.arkhing;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author emuvi
 */
public class ViewNamer extends javax.swing.JFrame {

    private final File path;
    private final Consumer<String> onAccept;
    
    public ViewNamer(File path, Consumer<String> onAccept) {
        this(path, null, onAccept);
    }
    
    public ViewNamer(File path, String subtitle, Consumer<String> onAccept) {
        this.path = path;
        this.onAccept = onAccept;
        initComponents();
        if (path != null) {
            editNamer.setText(path.getName());
        }
        if (subtitle != null) {
            setTitle(getTitle() + " - " + subtitle);
        }
        getRootPane().setDefaultButton(buttonAccept);
        WizSwing.initFrame(this);
        WizSwing.initEscaper(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTools = new javax.swing.JPopupMenu();
        menuAddIndex = new javax.swing.JMenuItem();
        menuAddParentName = new javax.swing.JMenuItem();
        menuChangeExtension = new javax.swing.JMenuItem();
        editNamer = new javax.swing.JTextField();
        buttonTools = new javax.swing.JButton();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        menuAddIndex.setMnemonic('I');
        menuAddIndex.setText("Add Index");
        menuAddIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddIndexActionPerformed(evt);
            }
        });
        menuTools.add(menuAddIndex);

        menuAddParentName.setMnemonic('P');
        menuAddParentName.setText("Add Parent Name");
        menuAddParentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddParentNameActionPerformed(evt);
            }
        });
        menuTools.add(menuAddParentName);

        menuChangeExtension.setMnemonic('E');
        menuChangeExtension.setText("Change Extension");
        menuChangeExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChangeExtensionActionPerformed(evt);
            }
        });
        menuTools.add(menuChangeExtension);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonAccept)
                    .addComponent(buttonTools))
                .addContainerGap())
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

    private void menuAddParentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddParentNameActionPerformed
        addOnName(path.getParentFile().getName());
        editNamer.requestFocus();
    }//GEN-LAST:event_menuAddParentNameActionPerformed

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

    private void menuAddIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddIndexActionPerformed
        try {
            var input = JOptionPane.showInputDialog("Index to add:", "1");
            if (input != null && !input.isBlank()) {
                var addIndex = Integer.valueOf(input);
                if (addIndex == 0) {
                    return;
                }
                var newName = WizChars.getNameWithNewIndex(editNamer.getText(), addIndex);
                editNamer.setText(newName);
                editNamer.requestFocus();
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_menuAddIndexActionPerformed

    private static String lastExtension = "";
    
    private void menuChangeExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChangeExtensionActionPerformed
        var extension = WizSwing.showInput("New Extension", lastExtension);
        if (extension != null && !extension.isBlank()) {
            var baseName = FilenameUtils.getBaseName(editNamer.getText());
            editNamer.setText(baseName + "." + extension);
            lastExtension = extension;
        }
    }//GEN-LAST:event_menuChangeExtensionActionPerformed

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
    private javax.swing.JMenuItem menuAddIndex;
    private javax.swing.JMenuItem menuAddParentName;
    private javax.swing.JMenuItem menuChangeExtension;
    private javax.swing.JPopupMenu menuTools;
    // End of variables declaration//GEN-END:variables
}
