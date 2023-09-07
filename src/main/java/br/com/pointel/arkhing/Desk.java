package br.com.pointel.arkhing;

import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.UIManager;

public class Desk extends javax.swing.JFrame {
    
    private final DeskBase deskBase = new DeskBase(this);
    private final DeskPack deskPack = new DeskPack(this);
    private final DeskName deskName = new DeskName(this);
    private final DeskDocs deskDocs = new DeskDocs(this);
    
    public volatile ArkhBase arkhBase = null;
    
    public Desk() {
        initComponents();
        tabsBody.addTab("ArkhBase", deskBase);
        tabsBody.addTab("ArkhPack", deskPack);
        tabsBody.addTab("ArkhName", deskName);
        tabsBody.addTab("ArkhDocs", deskDocs);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsBody = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arkhing");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabsBody)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabsBody)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setBounds(
            WizProps.get("DESK_LEFT", getBounds().x),
            WizProps.get("DESK_TOP", getBounds().y),
            WizProps.get("DESK_WIDTH", getBounds().width),
            WizProps.get("DESK_HEIGHT", getBounds().height));
        deskBase.initUpdater();
        deskPack.initUpdater();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        WizProps.set("DESK_LEFT", getBounds().x);
        WizProps.set("DESK_TOP", getBounds().y);
        WizProps.set("DESK_WIDTH", getBounds().width);
        WizProps.set("DESK_HEIGHT", getBounds().height);
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabsBody;
    // End of variables declaration//GEN-END:variables

    public static void start(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Desk().setVisible(true);
        });
    }
    
}
