package br.com.pointel.arkhing;

public class DeskDock extends javax.swing.JPanel {

    private final Desk desk;

    public DeskDock(Desk desk) {
        this.desk = desk;
        initComponents();
        checkIndexBase.setSelected(WizProps.get("DESK_DOCK_INDEX", false));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkIndexBase = new javax.swing.JCheckBox();

        checkIndexBase.setText("Index Base");
        checkIndexBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIndexBaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkIndexBase)
                .addContainerGap(332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkIndexBase)
                .addContainerGap(272, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkIndexBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIndexBaseActionPerformed
        WizProps.set("DESK_DOCK_INDEX", checkIndexBase.isSelected());
    }//GEN-LAST:event_checkIndexBaseActionPerformed

    public boolean isToIndexTheBase() {
        return checkIndexBase.isSelected();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkIndexBase;
    // End of variables declaration//GEN-END:variables
}
