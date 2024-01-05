package br.com.pointel.arkhing;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Desk extends javax.swing.JFrame {

    public final DeskBase deskBase;
    public final DeskPack deskPack;
    public final DeskOrgz deskOrgz;
    public final DeskDock deskDocs;
    public final DeskCapt deskCapt;
    public final DeskClog deskClog;
    public final DeskMirr deskMirr;

    public Desk() {
        initComponents();
        initShortcuts();
        WizSwing.initPositioner(this);
        deskBase = new DeskBase(this);
        deskPack = new DeskPack(this);
        deskOrgz = new DeskOrgz(this);
        deskDocs = new DeskDock(this);
        deskCapt = new DeskCapt(this);
        deskClog = new DeskClog(this);
        deskMirr = new DeskMirr(this);
        tabsBody.addTab("Base", deskBase);
        tabsBody.addTab("Pack", deskPack);
        tabsBody.addTab("Orgz", deskOrgz);
        tabsBody.addTab("Dock", deskDocs);
        tabsBody.addTab("Capt", deskCapt);
        tabsBody.addTab("Clog", deskClog);
        tabsBody.addTab("Mirr", deskMirr);

    }

    private volatile ArkhBase arkhBase = null;
    private final Object arkhBaseLocker = new Object();

    public void openBase(File root) throws Exception {
        synchronized (arkhBaseLocker) {
            if (arkhBase != null) {
                arkhBase.close();
                arkhBase = null;
            }
            arkhBase = new ArkhBase(root);
            arkhBase.addListener((message) -> putStatus(message));
            arkhBase.load();
        }
    }

    public ArkhBase getBase() {
        synchronized (arkhBaseLocker) {
            return arkhBase;
        }
    }

    public void showBase() {
        tabsBody.setSelectedIndex(0);
    }

    public void showPack() {
        tabsBody.setSelectedIndex(1);
    }

    public void showOrgz() {
        tabsBody.setSelectedIndex(2);
    }

    public void putStatus(String status) {
        if (SwingUtilities.isEventDispatchThread()) {
            editStatus.setText(status);
        } else {
            SwingUtilities.invokeLater(() -> editStatus.setText(status));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsBody = new javax.swing.JTabbedPane();
        checkAlwaysOnTop = new javax.swing.JCheckBox();
        editStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arkhing");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        checkAlwaysOnTop.setText("OnTop");
        checkAlwaysOnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAlwaysOnTopActionPerformed(evt);
            }
        });

        editStatus.setEditable(false);
        editStatus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editStatus.setText("Status");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editStatus)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabsBody, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkAlwaysOnTop)
                    .addComponent(editStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initShortcuts() {
        getRootPane().registerKeyboardAction((e) -> swingToLeft(), KeyStroke.getKeyStroke("alt LEFT"), JComponent.WHEN_IN_FOCUSED_WINDOW);
        getRootPane().registerKeyboardAction((e) -> swingToRight(), KeyStroke.getKeyStroke("alt RIGHT"), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    private void swingToLeft() {
        if (tabsBody.getSelectedIndex() > 0) {
            tabsBody.setSelectedIndex(tabsBody.getSelectedIndex() - 1);
        } else {
            tabsBody.setSelectedIndex(tabsBody.getTabCount() - 1);
        }
    }

    private void swingToRight() {
        if (tabsBody.getSelectedIndex() < tabsBody.getTabCount() - 1) {
            tabsBody.setSelectedIndex(tabsBody.getSelectedIndex() + 1);
        } else {
            tabsBody.setSelectedIndex(0);
        }
    }

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
    private javax.swing.JTextField editStatus;
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
