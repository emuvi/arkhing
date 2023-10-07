package br.com.pointel.arkhing;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

public class Desk extends javax.swing.JFrame {
    
    private final DeskBase deskBase = new DeskBase(this);
    private final DeskPack deskPack = new DeskPack(this);
    private final DeskOrgz deskOrgz = new DeskOrgz(this);
    private final DeskName deskName = new DeskName(this);
    private final DeskDocs deskDocs = new DeskDocs(this);
    private final DeskCapt deskCapt = new DeskCapt(this);
    
    public volatile ArkhBase arkhBase = null;
    
    public Desk() {
        initComponents();
        tabsBody.addTab("Base", deskBase);
        tabsBody.addTab("Pack", deskPack);
        tabsBody.addTab("Orgz", deskOrgz);
        tabsBody.addTab("Name", deskName);
        tabsBody.addTab("Docs", deskDocs);
        tabsBody.addTab("Capt", deskCapt);
        WizSwing.initPositioner(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsBody = new javax.swing.JTabbedPane();
        checkAlwaysOnTop = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arkhing");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        checkAlwaysOnTop.setText("Always on Top");
        checkAlwaysOnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAlwaysOnTopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabsBody, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkAlwaysOnTop)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabsBody, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkAlwaysOnTop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        deskBase.initUpdater();
        deskPack.initUpdater();
        deskOrgz.initUpdater();
    }//GEN-LAST:event_formWindowOpened

    private void checkAlwaysOnTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAlwaysOnTopActionPerformed
        this.setAlwaysOnTop(checkAlwaysOnTop.isSelected());
    }//GEN-LAST:event_checkAlwaysOnTopActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkAlwaysOnTop;
    private javax.swing.JTabbedPane tabsBody;
    // End of variables declaration//GEN-END:variables

    public static void start(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Desk().setVisible(true);
        });
    }
    
}
