package br.com.pointel.arkhing;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author emuvi
 */
public class DeskPack extends javax.swing.JPanel {

    private final Desk desk;

    private final DefaultListModel<WatchFoundDisplay> modelWatch = new DefaultListModel<>();
    private final List<WatchFound> watchFounds = new ArrayList<>();
    private final AtomicBoolean hasWatchChanges = new AtomicBoolean(true);

    public DeskPack(Desk desk) {
        this.desk = desk;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editWatch = new javax.swing.JTextField();
        buttonWatch = new javax.swing.JButton();
        checkWatch = new javax.swing.JCheckBox();
        splitPack = new javax.swing.JSplitPane();
        scrollWatch = new javax.swing.JScrollPane();
        listWatch = new javax.swing.JList<>();
        panelWatch = new javax.swing.JPanel();
        labelClipboard = new javax.swing.JLabel();
        editClipboard = new javax.swing.JTextField();
        buttonProcess = new javax.swing.JButton();
        labelDestinyFolder = new javax.swing.JLabel();
        editDestinyFolder = new javax.swing.JTextField();
        buttonDestinyFolder = new javax.swing.JButton();
        labelDestinyName = new javax.swing.JLabel();
        editDestinyName = new javax.swing.JTextField();
        buttonCopy = new javax.swing.JButton();

        editWatch.setEditable(false);
        editWatch.setText(WizProps.get("DESK_PACK_WATCH", ""));

        buttonWatch.setText("&");
        buttonWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWatchActionPerformed(evt);
            }
        });

        checkWatch.setText("Watch");

        splitPack.setDividerLocation(200);
        splitPack.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        listWatch.setFont(WizSwing.fontMonospaced());
        listWatch.setModel(modelWatch);
        scrollWatch.setViewportView(listWatch);

        splitPack.setTopComponent(scrollWatch);

        labelClipboard.setText("Clipboard");

        buttonProcess.setText("Process");
        buttonProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcessActionPerformed(evt);
            }
        });

        labelDestinyFolder.setText("Destiny Folder");

        buttonDestinyFolder.setText("Select");
        buttonDestinyFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinyFolderActionPerformed(evt);
            }
        });

        labelDestinyName.setText("Destiny Name");

        buttonCopy.setText("Copy");
        buttonCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCopyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelWatchLayout = new javax.swing.GroupLayout(panelWatch);
        panelWatch.setLayout(panelWatchLayout);
        panelWatchLayout.setHorizontalGroup(
            panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editClipboard, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(panelWatchLayout.createSequentialGroup()
                        .addComponent(labelClipboard)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelWatchLayout.createSequentialGroup()
                        .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editDestinyFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelWatchLayout.createSequentialGroup()
                                .addComponent(labelDestinyFolder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDestinyFolder)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelWatchLayout.createSequentialGroup()
                                .addComponent(labelDestinyName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonCopy))
                            .addComponent(editDestinyName))))
                .addContainerGap())
        );
        panelWatchLayout.setVerticalGroup(
            panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWatchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelClipboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editClipboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDestinyFolder)
                    .addComponent(labelDestinyName)
                    .addComponent(buttonDestinyFolder)
                    .addComponent(buttonCopy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editDestinyFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editDestinyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        splitPack.setRightComponent(panelWatch);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splitPack)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editWatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkWatch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editWatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkWatch)
                    .addComponent(buttonWatch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitPack, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void initUpdater() {
        WizBase.startDaemon(() -> {
            while (desk.isVisible()) {
                WizBase.sleep(500);
                updateWatch();
            }
        }, "DeskPack - Updater");
    }

    private void updateWatch() {
        if (checkWatch.isSelected()) {
            updateClipboard();
            var watchFile = new File(editWatch.getText());
            if (watchFile.exists()) {
                watchPath(watchFile);
                SwingUtilities.invokeLater(() -> {
                    synchronized (hasWatchChanges) {
                        if (hasWatchChanges.get()) {
                            var selected = listWatch.getSelectedValue();
                            modelWatch.removeAllElements();
                            for (var watchFound : watchFounds) {
                                modelWatch.addElement(new WatchFoundDisplay(watchFound));
                                if (watchFound.places.isEmpty()) {
                                    modelWatch.addElement(new WatchFoundNone(watchFound));
                                } else {
                                    for (var place : watchFound.places) {
                                        modelWatch.addElement(new WatchFoundPlace(watchFound, place));
                                        var destiny = new File(desk.arkhBase.root, place);
                                        editDestinyFolder.setText(destiny.getParent());
                                        editDestinyName.setText(FilenameUtils.getBaseName(destiny.getName()));
                                    }
                                }
                            }
                            listWatch.setSelectedValue(selected, true);
                            hasWatchChanges.set(false);
                        }
                    }
                });
            }
        }
    }

    private void updateClipboard() {
        try {
            var textOnClipboard = WizSwing.getStringOnClipboard();
            if (!Objects.equals(editClipboard.getText(), textOnClipboard)) {
                SwingUtilities.invokeLater(() -> editClipboard.setText(textOnClipboard));
            }
        } catch (Exception e) {
        }
    }

    private void watchPath(File path) {
        synchronized (hasWatchChanges) {
            List<File> foundsOnThisRound = new ArrayList<>();
            if (path.isDirectory()) {
                watchDirectory(path, foundsOnThisRound);
            } else {
                watchFile(path, foundsOnThisRound);
            }
            var removed = watchFounds.removeIf((watchFound) -> !foundsOnThisRound.contains(watchFound.file));
            if (removed) {
                hasWatchChanges.set(true);
            }
        }
    }

    private void watchDirectory(File path, List<File> foundsOnThisRound) {
        for (var inside : path.listFiles()) {
            if (inside.isDirectory()) {
                watchDirectory(inside, foundsOnThisRound);
            } else {
                watchFile(inside, foundsOnThisRound);
            }
        }
    }
    
    private void watchFile(File file, List<File> foundsOnThisRound) {
        foundsOnThisRound.add(file);
        if (hasBeenFound(file)) {
            return;
        }
        hasWatchChanges.set(true);
        try (var input = new FileInputStream(file)) {
            var verifier = DigestUtils.sha256Hex(input);
            var founds = desk.arkhBase.baseData.getByVerifier(verifier);
            var watchFound = new WatchFound(file);
            watchFounds.add(watchFound);
            if (!founds.isEmpty()) {
                for (var found : founds) {
                    watchFound.places.add(found.place);
                }
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }

    private boolean hasBeenFound(File file) {
        for (var watched : watchFounds) {
            if (Objects.equals(watched.file, file)) {
                return true;
            }
        }
        return false;
    }

    private void buttonWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWatchActionPerformed
        var selected = WizSwing.selectFolder(new File(editWatch.getText()));
        if (selected != null) {
            editWatch.setText(selected.getAbsolutePath());
            WizProps.set("DESK_PACK_WATCH", editWatch.getText());
        }
    }//GEN-LAST:event_buttonWatchActionPerformed

    private void buttonProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcessActionPerformed
        
    }//GEN-LAST:event_buttonProcessActionPerformed

    private void buttonDestinyFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinyFolderActionPerformed
        var selected = WizSwing.selectFolder(new File(editDestinyFolder.getText()));
        if (selected != null) {
            editDestinyFolder.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonDestinyFolderActionPerformed

    private void buttonCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopyActionPerformed
        editDestinyName.setText(editClipboard.getText());
    }//GEN-LAST:event_buttonCopyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCopy;
    private javax.swing.JButton buttonDestinyFolder;
    private javax.swing.JButton buttonProcess;
    private javax.swing.JButton buttonWatch;
    private javax.swing.JCheckBox checkWatch;
    private javax.swing.JTextField editClipboard;
    private javax.swing.JTextField editDestinyFolder;
    private javax.swing.JTextField editDestinyName;
    private javax.swing.JTextField editWatch;
    private javax.swing.JLabel labelClipboard;
    private javax.swing.JLabel labelDestinyFolder;
    private javax.swing.JLabel labelDestinyName;
    private javax.swing.JList<WatchFoundDisplay> listWatch;
    private javax.swing.JPanel panelWatch;
    private javax.swing.JScrollPane scrollWatch;
    private javax.swing.JSplitPane splitPack;
    // End of variables declaration//GEN-END:variables

    private class WatchFound {

        public final File file;
        public final List<String> places;

        public WatchFound(File file) {
            this.file = file;
            this.places = new ArrayList<>();
        }

        @Override
        public String toString() {
            return file.getName();
        }

    }

    private class WatchFoundDisplay {

        public WatchFound watchFound;

        public WatchFoundDisplay(WatchFound watchFound) {
            this.watchFound = watchFound;
        }

        @Override
        public String toString() {
            return "* " + this.watchFound.file.getName();
        }

    }

    private class WatchFoundPlace extends WatchFoundDisplay {

        private final String place;

        public WatchFoundPlace(WatchFound watchFound, String place) {
            super(watchFound);
            this.place = place;
        }

        @Override
        public String toString() {
            return "--> " + place;
        }

    }

    private class WatchFoundNone extends WatchFoundDisplay {

        public WatchFoundNone(WatchFound watchFound) {
            super(watchFound);
        }

        @Override
        public String toString() {
            return "--> Is not present on the base.";
        }

    }

}
