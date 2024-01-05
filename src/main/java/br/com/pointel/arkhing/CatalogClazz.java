package br.com.pointel.arkhing;

import java.util.List;
import java.util.function.Consumer;
import javax.swing.DefaultListModel;

/**
 *
 * @author emuvi
 */
public class CatalogClazz extends javax.swing.JFrame {

    private final Consumer<String> onSelect;
    private final DefaultListModel<String> suggestionsModel = new DefaultListModel<>();

    public CatalogClazz(List<String> suggestions, Consumer<String> onSelect) {
        this.onSelect = onSelect;
        initComponents();
        for (var suggestion : suggestions) {
            suggestionsModel.addElement(suggestion);
        }
        listSuggestions.setModel(suggestionsModel);
        if (!suggestions.isEmpty()) {
            listSuggestions.setSelectedIndex(0);
        }
        getRootPane().setDefaultButton(buttonConfirm);
        WizSwing.initPositioner(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollSuggestions = new javax.swing.JScrollPane();
        listSuggestions = new javax.swing.JList<>();
        buttonConfirm = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Catalog Clazz");

        listSuggestions.setFont(WizSwing.fontMonospaced());
        listSuggestions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollSuggestions.setViewportView(listSuggestions);

        buttonConfirm.setMnemonic('C');
        buttonConfirm.setText("Confirm");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        buttonCancel.setMnemonic('A');
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
                    .addComponent(scrollSuggestions, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSuggestions, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonConfirm))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        onSelect.accept(listSuggestions.getSelectedValue());
        WizSwing.close(this);
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        WizSwing.close(this);
    }//GEN-LAST:event_buttonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JList<String> listSuggestions;
    private javax.swing.JScrollPane scrollSuggestions;
    // End of variables declaration//GEN-END:variables
}
