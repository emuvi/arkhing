package br.com.pointel.arkhing;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author emuvi
 */
public class ViewReplacer extends javax.swing.JFrame {

    public ViewReplacer() {
        initComponents();
        initNamedReplacers();
        WizSwing.initPositioner(this);
    }
    
    private void initNamedReplacers() {
        for (var file : new File(".").listFiles()) {
            if (file.getName().endsWith(".rpc")) {
                comboName.addItem(FilenameUtils.getBaseName(file.getName()));
            }
        }
        comboName.setSelectedItem(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollReplacer = new javax.swing.JScrollPane();
        tableReplacer = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonUp = new javax.swing.JButton();
        buttonDown = new javax.swing.JButton();
        comboName = new javax.swing.JComboBox<>();
        buttonLoad = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonForget = new javax.swing.JButton();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Replacer");

        tableReplacer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Make", "Of", "To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableReplacer.getTableHeader().setReorderingAllowed(false);
        scrollReplacer.setViewportView(tableReplacer);
        if (tableReplacer.getColumnModel().getColumnCount() > 0) {
            tableReplacer.getColumnModel().getColumn(0).setMinWidth(80);
            tableReplacer.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableReplacer.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        buttonAdd.setText("+");
        buttonAdd.setToolTipText("Insert");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonDelete.setText("-");
        buttonDelete.setToolTipText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonUp.setMnemonic('U');
        buttonUp.setText("↑");
        buttonUp.setToolTipText("Move Up");
        buttonUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpActionPerformed(evt);
            }
        });

        buttonDown.setMnemonic('D');
        buttonDown.setText("↓");
        buttonDown.setToolTipText("Move Down");
        buttonDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDownActionPerformed(evt);
            }
        });

        comboName.setEditable(true);

        buttonLoad.setText("L");
        buttonLoad.setToolTipText("Load");
        buttonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoadActionPerformed(evt);
            }
        });

        buttonSave.setText("S");
        buttonSave.setToolTipText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonForget.setText("F");
        buttonForget.setToolTipText("Forget");
        buttonForget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonForgetActionPerformed(evt);
            }
        });

        buttonAccept.setText("Accept");
        buttonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcceptActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollReplacer)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDown)
                        .addGap(18, 18, 18)
                        .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonForget)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(buttonAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollReplacer, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonAccept)
                    .addComponent(buttonAdd)
                    .addComponent(buttonDelete)
                    .addComponent(buttonUp)
                    .addComponent(buttonDown)
                    .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLoad)
                    .addComponent(buttonSave)
                    .addComponent(buttonForget))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        var model = (DefaultTableModel) tableReplacer.getModel();
        var selected = tableReplacer.getSelectedRow();
        model.insertRow(selected + 1, new Object[]{false, "", ""});
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        var model = (DefaultTableModel) tableReplacer.getModel();
        var selected = tableReplacer.getSelectedRow();
        if (selected > -1) {
            model.removeRow(tableReplacer.getSelectedRow());
            if (selected > 0) selected--;
            if (selected < model.getRowCount()) {
                tableReplacer.setRowSelectionInterval(selected, selected);
            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpActionPerformed
        var model = (DefaultTableModel) tableReplacer.getModel();
        var selected = tableReplacer.getSelectedRow();
        if (selected > 0) {
            var priorMk = model.getValueAt(selected - 1, 0);
            var priorOf = model.getValueAt(selected - 1, 1);
            var priorTo = model.getValueAt(selected - 1, 2);
            var actualMk = model.getValueAt(selected, 0);
            var actualOf = model.getValueAt(selected, 1);
            var actualTo = model.getValueAt(selected, 2);
            model.setValueAt(actualMk, selected - 1, 0);
            model.setValueAt(actualOf, selected - 1, 1);
            model.setValueAt(actualTo, selected - 1, 2);
            model.setValueAt(priorMk, selected, 0);
            model.setValueAt(priorOf, selected, 1);
            model.setValueAt(priorTo, selected , 2);
            selected--;
            tableReplacer.setRowSelectionInterval(selected, selected);
        }
    }//GEN-LAST:event_buttonUpActionPerformed

    private void buttonDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDownActionPerformed
        var model = (DefaultTableModel) tableReplacer.getModel();
        var selected = tableReplacer.getSelectedRow();
        if (selected < tableReplacer.getRowCount() - 1) {
            var nextMk = model.getValueAt(selected + 1, 0);
            var nextOf = model.getValueAt(selected + 1, 1);
            var nextTo = model.getValueAt(selected + 1, 2);
            var actualMk = model.getValueAt(selected, 0);
            var actualOf = model.getValueAt(selected, 1);
            var actualTo = model.getValueAt(selected, 2);
            model.setValueAt(actualMk, selected + 1, 0);
            model.setValueAt(actualOf, selected + 1, 1);
            model.setValueAt(actualTo, selected + 1, 2);
            model.setValueAt(nextMk, selected, 0);
            model.setValueAt(nextOf, selected, 1);
            model.setValueAt(nextTo, selected , 2);
            selected++;
            tableReplacer.setRowSelectionInterval(selected, selected);
        }
    }//GEN-LAST:event_buttonDownActionPerformed

    private void buttonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadActionPerformed
        try {
            var selected = comboName.getSelectedItem();
            if (selected != null && !selected.toString().isEmpty()) {
                var selectedName = selected.toString();
                var selectedFile = new File(selectedName + ".rpc");
                if (!selectedFile.exists()) {
                    throw new Exception("Could not found.");
                }
                try (
                    var fileReader = new FileReader(selectedFile, StandardCharsets.UTF_8);
                    var csvReader = new CSVParser(fileReader, CSVFormat.DEFAULT);
                ) {
                    var model = (DefaultTableModel) tableReplacer.getModel();
                    model.setRowCount(0);
                    for (var csvRecord : csvReader) {
                        model.addRow(new Object[]{
                            Boolean.valueOf(csvRecord.get(0)),
                            csvRecord.get(1),
                            csvRecord.get(2)
                        });
                    }
                }
                WizSwing.showInfo("Loaded");
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonLoadActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        try {
            var selected = comboName.getSelectedItem();
            if (selected != null && !selected.toString().isEmpty()) {
                var selectedName = selected.toString();
                var selectedFile = new File(selectedName + ".rpc");
                try (
                    var fileWriter = new FileWriter(selectedFile, StandardCharsets.UTF_8);
                    var csvWriter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);
                ) {
                    for (int i = 0; i < tableReplacer.getRowCount(); i++) {
                        csvWriter.printRecord(
                                tableReplacer.getValueAt(i, 0),
                                tableReplacer.getValueAt(i, 1),
                                tableReplacer.getValueAt(i, 2)
                                );
                    }
                    csvWriter.flush();
                }
                WizSwing.showInfo("Saved");
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonForgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonForgetActionPerformed
        var selected = comboName.getSelectedItem();
        if (selected != null && !selected.toString().isEmpty()) {
            var selectedName = selected.toString();
            new File(selectedName + ".rpc").delete();
            comboName.removeItem(selected);
            WizSwing.showInfo("Forgot");
        }
    }//GEN-LAST:event_buttonForgetActionPerformed

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancelActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDown;
    private javax.swing.JButton buttonForget;
    private javax.swing.JButton buttonLoad;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonUp;
    private javax.swing.JComboBox<String> comboName;
    private javax.swing.JScrollPane scrollReplacer;
    private javax.swing.JTable tableReplacer;
    // End of variables declaration//GEN-END:variables
}
