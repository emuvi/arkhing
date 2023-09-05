package br.com.pointel.arkhing;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.commons.lang3.tuple.Pair;

public class Desktop extends javax.swing.JFrame {
    
    private volatile ArkhBase arkhBase = null;
    
    public Desktop() {
        initComponents();
        initUpdater();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBody = new javax.swing.JTabbedPane();
        panStatus = new javax.swing.JPanel();
        scrStatus = new javax.swing.JScrollPane();
        texStatus = new javax.swing.JTextArea();
        btnLoad = new javax.swing.JButton();
        edtRoot = new javax.swing.JTextField();

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

        texStatus.setEditable(false);
        texStatus.setColumns(20);
        texStatus.setFont(WizSwing.fontMonospaced());
        texStatus.setRows(5);
        scrStatus.setViewportView(texStatus);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        edtRoot.setEditable(false);

        javax.swing.GroupLayout panStatusLayout = new javax.swing.GroupLayout(panStatus);
        panStatus.setLayout(panStatusLayout);
        panStatusLayout.setHorizontalGroup(
            panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panStatusLayout.createSequentialGroup()
                        .addComponent(edtRoot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoad)))
                .addContainerGap())
        );
        panStatusLayout.setVerticalGroup(
            panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(edtRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );

        panBody.addTab("ArkhBase", panStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panBody)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panBody, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initUpdater() {
        new Thread("Desktop - Updater") {
            @Override
            public void run() {
                while (isDisplayable()) {
                    WizBase.sleep(500);
                    var status = mountStatus();
                    var selectionStart = texStatus.getSelectionStart();
                    var selectionEnd = texStatus.getSelectionEnd();
                    var horizontalPosition = scrStatus.getHorizontalScrollBar().getValue();
                    var verticalPosition = scrStatus.getVerticalScrollBar().getValue();
                    SwingUtilities.invokeLater(() -> {
                        texStatus.setText(status);
                        texStatus.setSelectionStart(selectionStart);
                        texStatus.setSelectionEnd(selectionEnd);
                        scrStatus.getHorizontalScrollBar().setValue(horizontalPosition);
                        scrStatus.getVerticalScrollBar().setValue(verticalPosition);
                    });
                }
            }
            
            private String mountStatus() {
                if (arkhBase == null) {
                    return "ArkhBase not loaded.";
                } else {
                    var grid = new ArrayList<Pair<String, String>>();
                    grid.add(Pair.of("Loading Progress", 
                            arkhBase.arkhLoad.getProgressFormated()));
                    grid.add(Pair.of("Number Of Files", 
                            arkhBase.arkhLoad.statusNumberOfFiles.toString()));
                    grid.add(Pair.of("Number Of Checked", 
                            arkhBase.arkhLoad.statusNumberOfChecked.toString()));
                    grid.add(Pair.of("Number Of Cleaned", 
                            arkhBase.arkhLoad.statusNumberOfCleaned.toString()));
                    grid.add(Pair.of("Number Of Erros", 
                            arkhBase.arkhLoad.statusNumberOfErros.toString()));
                    return WizChars.mountGrid(grid);
                }
            }
        }.start();
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            WizProps.load("arkhing");
            setBounds(
                WizProps.get("left", getBounds().x),
                WizProps.get("top", getBounds().y),
                WizProps.get("width", getBounds().width),
                WizProps.get("height", getBounds().height));
            edtRoot.setText(WizProps.get("root", ""));
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            WizProps.set("left", getBounds().x);
            WizProps.set("top", getBounds().y);
            WizProps.set("width", getBounds().width);
            WizProps.set("height", getBounds().height);
            WizProps.set("root", edtRoot.getText());
            WizProps.save("arkhing");
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        try {
            var selected = WizSwing.selectFolder(new File(edtRoot.getText()));
            if (selected != null) {
                edtRoot.setText(selected.getAbsolutePath());
                if (this.arkhBase != null) {
                    this.arkhBase.close();
                    this.arkhBase = null;
                }
                this.arkhBase = new ArkhBase(selected).load();
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JTextField edtRoot;
    private javax.swing.JTabbedPane panBody;
    private javax.swing.JPanel panStatus;
    private javax.swing.JScrollPane scrStatus;
    private javax.swing.JTextArea texStatus;
    // End of variables declaration//GEN-END:variables

    public static void start(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Desktop().setVisible(true);
        });
    }
    
}
