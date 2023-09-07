package br.com.pointel.arkhing;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.commons.codec.digest.DigestUtils;
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

        tabsBody = new javax.swing.JTabbedPane();
        panelArkhBase = new javax.swing.JPanel();
        scrollStatus = new javax.swing.JScrollPane();
        textStatus = new javax.swing.JTextArea();
        buttonLoad = new javax.swing.JButton();
        editRoot = new javax.swing.JTextField();
        buttonCheck = new javax.swing.JButton();
        panelArkhPack = new javax.swing.JPanel();
        editPack = new javax.swing.JTextField();
        buttonPack = new javax.swing.JButton();
        checkPack = new javax.swing.JCheckBox();
        splitPack = new javax.swing.JSplitPane();
        scrollWatched = new javax.swing.JScrollPane();
        textWatched = new javax.swing.JTextArea();
        panelStructure = new javax.swing.JPanel();
        editClipboard = new javax.swing.JTextField();
        panArkhName = new javax.swing.JPanel();
        btnProcess = new javax.swing.JButton();
        panArkhDocs = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

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

        editRoot.setEditable(false);

        buttonCheck.setText("Check");
        buttonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelArkhBaseLayout = new javax.swing.GroupLayout(panelArkhBase);
        panelArkhBase.setLayout(panelArkhBaseLayout);
        panelArkhBaseLayout.setHorizontalGroup(
            panelArkhBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArkhBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArkhBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollStatus)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArkhBaseLayout.createSequentialGroup()
                        .addComponent(editRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCheck)))
                .addContainerGap())
        );
        panelArkhBaseLayout.setVerticalGroup(
            panelArkhBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArkhBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArkhBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLoad)
                    .addComponent(editRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabsBody.addTab("ArkhBase", panelArkhBase);

        editPack.setEditable(false);

        buttonPack.setText("Pack");
        buttonPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackActionPerformed(evt);
            }
        });

        checkPack.setText("Watch");

        splitPack.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        textWatched.setColumns(20);
        textWatched.setRows(5);
        scrollWatched.setViewportView(textWatched);

        splitPack.setTopComponent(scrollWatched);

        javax.swing.GroupLayout panelStructureLayout = new javax.swing.GroupLayout(panelStructure);
        panelStructure.setLayout(panelStructureLayout);
        panelStructureLayout.setHorizontalGroup(
            panelStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        panelStructureLayout.setVerticalGroup(
            panelStructureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );

        splitPack.setRightComponent(panelStructure);

        javax.swing.GroupLayout panelArkhPackLayout = new javax.swing.GroupLayout(panelArkhPack);
        panelArkhPack.setLayout(panelArkhPackLayout);
        panelArkhPackLayout.setHorizontalGroup(
            panelArkhPackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArkhPackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArkhPackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splitPack)
                    .addGroup(panelArkhPackLayout.createSequentialGroup()
                        .addComponent(editPack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkPack))
                    .addGroup(panelArkhPackLayout.createSequentialGroup()
                        .addComponent(editClipboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelArkhPackLayout.setVerticalGroup(
            panelArkhPackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArkhPackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArkhPackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPack)
                    .addComponent(buttonPack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editClipboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(splitPack, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabsBody.addTab("ArkhPack", panelArkhPack);

        btnProcess.setText("Process Name");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panArkhNameLayout = new javax.swing.GroupLayout(panArkhName);
        panArkhName.setLayout(panArkhNameLayout);
        panArkhNameLayout.setHorizontalGroup(
            panArkhNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArkhNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProcess)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        panArkhNameLayout.setVerticalGroup(
            panArkhNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArkhNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProcess)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        tabsBody.addTab("ArkhName", panArkhName);

        jButton1.setText("Process Docs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panArkhDocsLayout = new javax.swing.GroupLayout(panArkhDocs);
        panArkhDocs.setLayout(panArkhDocsLayout);
        panArkhDocsLayout.setHorizontalGroup(
            panArkhDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArkhDocsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        panArkhDocsLayout.setVerticalGroup(
            panArkhDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArkhDocsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        tabsBody.addTab("ArkhDocs", panArkhDocs);

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

    private void initUpdater() {
        new Thread("Desktop - Updater") {
            @Override
            public void run() {
                while (isDisplayable()) {
                    WizBase.sleep(500);
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
            }
            
            private String mountStatus() {
                if (arkhBase == null) {
                    return "ArkhBase not loaded.";
                } else {
                    var grid = new ArrayList<Pair<String, String>>();
                    grid.add(Pair.of("Loading Progress", 
                            arkhBase.baseLoad.getProgressFormated()));
                    grid.add(Pair.of("Number Of Files", 
                            arkhBase.baseLoad.statusNumberOfFiles.toString()));
                    grid.add(Pair.of("Number Of Checked", 
                            arkhBase.baseLoad.statusNumberOfChecked.toString()));
                    grid.add(Pair.of("Number Of Cleaned", 
                            arkhBase.baseLoad.statusNumberOfCleaned.toString()));
                    grid.add(Pair.of("Number Of Erros", 
                            arkhBase.baseLoad.statusNumberOfErros.toString()));
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
            editRoot.setText(WizProps.get("root", ""));
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
            WizProps.set("root", editRoot.getText());
            WizProps.save("arkhing");
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoadActionPerformed
        try {
            var selected = WizSwing.selectFolder(new File(editRoot.getText()));
            if (selected != null) {
                editRoot.setText(selected.getAbsolutePath());
                if (this.arkhBase != null) {
                    this.arkhBase.close();
                    this.arkhBase = null;
                }
                this.arkhBase = new ArkhBase(selected).load();
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonLoadActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        var origin = new File("C:\\Users\\emuvi\\Downloads");
        for (var inside : origin.listFiles()) {
            if (inside.getName().startsWith("Aula ")) {
                continue;
            }
            int i = 1;
            var name = "Aula " + (i < 10 ? "0" + i : i) + ".mp4";
            var destiny = new File(origin, name);
            while (destiny.exists()) {
                i++;
                name = "Aula " + (i < 10 ? "0" + i : i) + ".mp4";
                destiny = new File(origin, name);
            }
            inside.renameTo(destiny);
        }
        JOptionPane.showMessageDialog(rootPane, "Done");
    }//GEN-LAST:event_btnProcessActionPerformed

    private File lastSelectedCheck = null;
    
    private void buttonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCheckActionPerformed
        try {
            var selected = WizSwing.select(lastSelectedCheck);
            if (selected != null) {
                lastSelectedCheck = selected;
                new DesktopReport(arkhBase.makeCheck(selected)).setVisible(true);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonCheckActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ArkhDocs(new File("C:\\Users\\emuvi\\Downloads\\Teste.docx")).print();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton buttonCheck;
    private javax.swing.JButton buttonLoad;
    private javax.swing.JButton buttonPack;
    private javax.swing.JCheckBox checkPack;
    private javax.swing.JTextField editClipboard;
    private javax.swing.JTextField editPack;
    private javax.swing.JTextField editRoot;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panArkhDocs;
    private javax.swing.JPanel panArkhName;
    private javax.swing.JPanel panelArkhBase;
    private javax.swing.JPanel panelArkhPack;
    private javax.swing.JPanel panelStructure;
    private javax.swing.JScrollPane scrollStatus;
    private javax.swing.JScrollPane scrollWatched;
    private javax.swing.JSplitPane splitPack;
    private javax.swing.JTabbedPane tabsBody;
    private javax.swing.JTextArea textStatus;
    private javax.swing.JTextArea textWatched;
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
