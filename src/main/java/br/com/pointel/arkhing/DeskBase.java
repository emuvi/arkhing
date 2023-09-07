package br.com.pointel.arkhing;

import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.tuple.Pair;

public class DeskBase extends javax.swing.JPanel {

    private final Desk desk;

    private File lastSelectedCheck = null;

    public DeskBase(Desk desk) {
        this.desk = desk;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editRoot = new javax.swing.JTextField();
        scrollStatus = new javax.swing.JScrollPane();
        textStatus = new javax.swing.JTextArea();
        buttonLoad = new javax.swing.JButton();
        buttonCheck = new javax.swing.JButton();

        editRoot.setEditable(false);
        editRoot.setText(WizProps.get("DESK_BASE_ROOT", ""));

        textStatus.setEditable(false);
        textStatus.setColumns(20);
        textStatus.setFont(WizSwing.fontMonospaced());
        textStatus.setRows(5);
        scrollStatus.setViewportView(textStatus);

        buttonLoad.setText("Load");
        buttonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadActionPerformed(evt);
            }
        });

        buttonCheck.setText("Check");
        buttonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollStatus)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCheck)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLoad)
                    .addComponent(editRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void initUpdater() {
        WizBase.startDaemon(() -> {
            while (desk.isVisible()) {
                WizBase.sleep(500);
                updateStatus();
            }
        }, "DeskBase - Updater");
    }
    
    private void updateStatus() {
        var status = mountStatus();
        var selectionStart = textStatus.getSelectionStart();
        var selectionEnd = textStatus.getSelectionEnd();
        var horizontalPosition = scrollStatus.getHorizontalScrollBar().getValue();
        var verticalPosition = scrollStatus.getVerticalScrollBar().getValue();
        SwingUtilities.invokeLater(() -> {
            textStatus.setText(status);
            textStatus.setSelectionStart(selectionStart);
            textStatus.setSelectionEnd(selectionEnd);
            scrollStatus.getHorizontalScrollBar().setValue(horizontalPosition);
            scrollStatus.getVerticalScrollBar().setValue(verticalPosition);
        });
    }

    private String mountStatus() {
        if (desk.arkhBase == null) {
            return "ArkhBase not loaded.";
        } else {
            var grid = new ArrayList<Pair<String, String>>();
            grid.add(Pair.of("Loading Progress",
                    desk.arkhBase.baseLoad.getProgressFormated()));
            grid.add(Pair.of("Number Of Files",
                    desk.arkhBase.baseLoad.statusNumberOfFiles.toString()));
            grid.add(Pair.of("Number Of Checked",
                    desk.arkhBase.baseLoad.statusNumberOfChecked.toString()));
            grid.add(Pair.of("Number Of Cleaned",
                    desk.arkhBase.baseLoad.statusNumberOfCleaned.toString()));
            grid.add(Pair.of("Number Of Erros",
                    desk.arkhBase.baseLoad.statusNumberOfErros.toString()));
            return WizChars.mountGrid(grid);
        }
    }
    
    private void buttonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadActionPerformed
        try {
            var selected = WizSwing.selectFolder(new File(editRoot.getText()));
            if (selected != null) {
                editRoot.setText(selected.getAbsolutePath());
                WizProps.set("DESK_BASE_ROOT", editRoot.getText());
                if (desk.arkhBase != null) {
                    desk.arkhBase.close();
                    desk.arkhBase = null;
                }
                desk.arkhBase = new ArkhBase(selected).load();
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonLoadActionPerformed

    private void buttonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCheckActionPerformed
        try {
            var selected = WizSwing.select(lastSelectedCheck);
            if (selected != null) {
                lastSelectedCheck = selected;
                new ViewReport(desk.arkhBase.makeCheck(selected)).setVisible(true);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCheck;
    private javax.swing.JButton buttonLoad;
    private javax.swing.JTextField editRoot;
    private javax.swing.JScrollPane scrollStatus;
    private javax.swing.JTextArea textStatus;
    // End of variables declaration//GEN-END:variables
}
