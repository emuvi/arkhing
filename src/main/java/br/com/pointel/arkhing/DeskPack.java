package br.com.pointel.arkhing;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author emuvi
 */
public class DeskPack extends javax.swing.JPanel {

    private final Desk desk;

    private final DefaultListModel<WatchFoundDisplay> modelWatch = new DefaultListModel<>();
    private final List<WatchFound> watchFounds = new ArrayList<>();
    private final AtomicBoolean hasWatchChanges = new AtomicBoolean(true);
    private final AtomicBoolean shouldWait = new AtomicBoolean(true);

    public DeskPack(Desk desk) {
        this.desk = desk;
        initComponents();
        labelFound.setVisible(false);
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
        labelDestinyFolder = new javax.swing.JLabel();
        editDestinyFolder = new javax.swing.JTextField();
        buttonDestinyFolder = new javax.swing.JButton();
        labelDestinyName = new javax.swing.JLabel();
        editDestinyName = new javax.swing.JTextField();
        buttonNameCopy = new javax.swing.JButton();
        buttonFolderCopy = new javax.swing.JButton();
        panelProcess = new javax.swing.JPanel();
        buttonMakeAutoName = new javax.swing.JButton();
        buttonMakeAulaName = new javax.swing.JButton();
        buttonSameFoundName = new javax.swing.JButton();
        buttonSameRootName = new javax.swing.JButton();
        buttonFolderOpen = new javax.swing.JButton();
        labelFound = new javax.swing.JLabel();
        checkAutoCopy = new javax.swing.JCheckBox();
        labelStatus = new javax.swing.JLabel();

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
        listWatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listWatchMouseClicked(evt);
            }
        });
        listWatch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listWatchKeyPressed(evt);
            }
        });
        scrollWatch.setViewportView(listWatch);

        splitPack.setTopComponent(scrollWatch);

        labelClipboard.setText("Clipboard");

        labelDestinyFolder.setText("Destiny Folder");

        buttonDestinyFolder.setText("Select");
        buttonDestinyFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinyFolderActionPerformed(evt);
            }
        });

        labelDestinyName.setText("Destiny Name");

        buttonNameCopy.setText("Copy");
        buttonNameCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNameCopyActionPerformed(evt);
            }
        });

        buttonFolderCopy.setText("Copy");
        buttonFolderCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderCopyActionPerformed(evt);
            }
        });

        panelProcess.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        buttonMakeAutoName.setText("Make Auto Name");
        buttonMakeAutoName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMakeAutoNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonMakeAutoName);

        buttonMakeAulaName.setText("Make Aula Name");
        buttonMakeAulaName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMakeAulaNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonMakeAulaName);

        buttonSameFoundName.setText("Same Found Name");
        buttonSameFoundName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSameFoundNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonSameFoundName);

        buttonSameRootName.setText("Same Root Name");
        buttonSameRootName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSameRootNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonSameRootName);

        buttonFolderOpen.setText("Open");
        buttonFolderOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderOpenActionPerformed(evt);
            }
        });

        labelFound.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        labelFound.setForeground(new java.awt.Color(255, 0, 0));
        labelFound.setText("Already Present on Base!!!");

        checkAutoCopy.setText("Auto");

        labelStatus.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(0, 0, 153));
        labelStatus.setText("Size: 0 | Wait: No");

        javax.swing.GroupLayout panelWatchLayout = new javax.swing.GroupLayout(panelWatch);
        panelWatch.setLayout(panelWatchLayout);
        panelWatchLayout.setHorizontalGroup(
            panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editClipboard)
                    .addGroup(panelWatchLayout.createSequentialGroup()
                        .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editDestinyFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelWatchLayout.createSequentialGroup()
                                .addComponent(labelDestinyFolder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonFolderOpen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFolderCopy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDestinyFolder)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelWatchLayout.createSequentialGroup()
                                .addComponent(labelDestinyName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(checkAutoCopy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonNameCopy))
                            .addComponent(editDestinyName)))
                    .addGroup(panelWatchLayout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addGap(18, 18, 18)
                        .addComponent(labelFound)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelClipboard))
                    .addComponent(panelProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelWatchLayout.setVerticalGroup(
            panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelClipboard)
                    .addComponent(labelFound)
                    .addComponent(labelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editClipboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkAutoCopy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDestinyFolder)
                        .addComponent(labelDestinyName)
                        .addComponent(buttonDestinyFolder)
                        .addComponent(buttonNameCopy)
                        .addComponent(buttonFolderCopy)
                        .addComponent(buttonFolderOpen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editDestinyFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editDestinyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
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
                            labelFound.setVisible(false);
                            modelWatch.removeAllElements();
                            boolean wait = false;
                            for (var watchFound : watchFounds) {
                                if (watchFound.file.getName().endsWith(".crdownload")) {
                                    wait = true;
                                }
                                modelWatch.addElement(new WatchFoundDisplay(watchFound));
                                if (watchFound.places.isEmpty()) {
                                    modelWatch.addElement(new WatchFoundNone(watchFound));
                                } else {
                                    for (var place : watchFound.places) {
                                        modelWatch.addElement(new WatchFoundPlace(watchFound, place));
                                        var destiny = new File(desk.arkhBase.root, place);
                                        editDestinyFolder.setText(destiny.getParent());
                                        editDestinyName.setText(FilenameUtils.getBaseName(destiny.getName()));
                                        labelFound.setVisible(true);
                                    }
                                }
                            }
                            listWatch.setSelectedValue(selected, true);
                            labelStatus.setText("Size: " + watchFounds.size() + " - Wait: " + (wait ? "Yes" : "No"));
                            shouldWait.set(wait);
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
            SwingUtilities.invokeLater(() -> {
                if (!Objects.equals(editClipboard.getText(), textOnClipboard)) {
                    editClipboard.setText(textOnClipboard);
                    if (!labelFound.isVisible() && checkAutoCopy.isSelected()) {
                        buttonNameCopyActionPerformed(null);
                    }
                }
            });
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
            var watchFound = new WatchFound(file, verifier);
            watchFounds.add(watchFound);
            if (!founds.isEmpty()) {
                for (var found : founds) {
                    watchFound.places.add(found.place);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    private void buttonDestinyFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinyFolderActionPerformed
        var selected = WizSwing.selectFolder(new File(editDestinyFolder.getText()));
        if (selected != null) {
            editDestinyFolder.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonDestinyFolderActionPerformed

    private void buttonNameCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNameCopyActionPerformed
        editDestinyName.setText(cleanName(editClipboard.getText()));
    }//GEN-LAST:event_buttonNameCopyActionPerformed

    private void buttonFolderCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderCopyActionPerformed
        editDestinyFolder.setText(editDestinyFolder.getText() + File.separator + cleanName(editClipboard.getText()));
    }//GEN-LAST:event_buttonFolderCopyActionPerformed

    private String cleanName(String name) {
        return name
                .replace(":", "-")
                .replace("|", "-")
                .replace("/", "-")
                .replace("\\", "-")
                .replace("?", "")
                .replaceAll("\\s+", " ")
                .trim();
    }

    private void checkIfDownloading() throws Exception {
        var allSelected = getSelectedToProcess();
        for (var selected : allSelected) {
            if (selected.file.getName().endsWith(".crdownload")) {
                throw new Exception("Are downloading yet.");
            }
        }
    }

    private void buttonSameRootNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSameRootNameActionPerformed
        try {
            checkIfDownloading();
            var allSelected = getSelectedToProcess();
            var rootFolder = new File(editDestinyFolder.getText());
            for (var selected : allSelected) {
                if (!selected.places.isEmpty()) {
                    selected.file.delete();
                } else {
                    doMove(selected.file, rootFolder, rootFolder.getName(), selected.verifier);
                }
            }
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonSameRootNameActionPerformed

    private void buttonSameFoundNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSameFoundNameActionPerformed
        try {
            checkIfDownloading();
            var allSelected = getSelectedToProcess();
            var rootFolder = new File(editDestinyFolder.getText());
            for (var selected : allSelected) {
                if (!selected.places.isEmpty()) {
                    selected.file.delete();
                } else {
                    doMove(selected.file, rootFolder, editDestinyName.getText(), selected.verifier);
                }
            }
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonSameFoundNameActionPerformed

    private void buttonMakeAulaNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMakeAulaNameActionPerformed
        try {
            checkIfDownloading();
            var allSelected = getSelectedToProcess();
            var rootFolder = new File(editDestinyFolder.getText());

            int biggerAula = 0;
            for (var inside : rootFolder.listFiles()) {
                var test = inside.getName().toLowerCase();
                if (test.startsWith("aula ")) {
                    int end = test.indexOf(" - ");
                    if (end > -1) {
                        try {
                            int number = Integer.parseInt(test.substring(4, end).trim());
                            if (number > biggerAula) {
                                biggerAula = number;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
            biggerAula++;
            String name = "Aula " + StringUtils.leftPad("" + biggerAula, 2, '0')
                    + " - " + editDestinyName.getText();
            for (var selected : allSelected) {
                doMove(selected.file, rootFolder, name, selected.verifier);
            }
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonMakeAulaNameActionPerformed

    private void doMove(File file, File directory, String name, String verifier) throws Exception {
        var extension = "." + FilenameUtils.getExtension(file.getName());
        var destiny = new File(directory, name + extension);
        int attempt = 1;
        while (destiny.exists()) {
            attempt++;
            destiny = new File(directory, name + " (" + attempt + ")" + extension);
        }
        Files.move(file.toPath(), destiny.toPath());
        desk.arkhBase.putFile(destiny, verifier);
    }

    private void listWatchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listWatchKeyPressed
        if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_DELETE) {
            for (var selected : listWatch.getSelectedValuesList()) {
                selected.watchFound.file.delete();
            }
        }
    }//GEN-LAST:event_listWatchKeyPressed

    private void buttonFolderOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderOpenActionPerformed
        try {
            Desktop.getDesktop().open(new File(editDestinyFolder.getText()));
        } catch (IOException ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonFolderOpenActionPerformed

    private void listWatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWatchMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() >= 2) {
            var selected = listWatch.getSelectedValue();
            if (selected instanceof WatchFoundPlace selectedPlace) {
                var destiny = new File(desk.arkhBase.root, selectedPlace.place);
                editDestinyFolder.setText(destiny.getParent());
                editDestinyName.setText(FilenameUtils.getBaseName(destiny.getName()));
            }
        }
    }//GEN-LAST:event_listWatchMouseClicked

    private final AtomicBoolean shootMakeAutoName = new AtomicBoolean(false);

    private void buttonMakeAutoNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMakeAutoNameActionPerformed
        if (!shootMakeAutoName.get()) {
            shootMakeAutoName.set(true);
            new Thread() {
                @Override
                public void run() {
                    try {
                        while (shouldWait.get()) {
                            WizBase.sleep(10);
                        }
                        SwingUtilities.invokeLater(() -> {
                            if (labelFound.isVisible()) {
                                buttonSameFoundNameActionPerformed(evt);
                            } else {
                                buttonMakeAulaNameActionPerformed(evt);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        shootMakeAutoName.set(false);
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_buttonMakeAutoNameActionPerformed

    private Set<WatchFound> getSelectedToProcess() {
        Set<WatchFound> results = new HashSet<>();
        int[] selectAll = new int[modelWatch.size()];
        for (int i = 0; i < selectAll.length; i++) {
            selectAll[i] = i;
        }
        listWatch.setSelectedIndices(selectAll);
        for (var selected : listWatch.getSelectedValuesList()) {
            results.add(selected.watchFound);
        }
        return results;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDestinyFolder;
    private javax.swing.JButton buttonFolderCopy;
    private javax.swing.JButton buttonFolderOpen;
    private javax.swing.JButton buttonMakeAulaName;
    private javax.swing.JButton buttonMakeAutoName;
    private javax.swing.JButton buttonNameCopy;
    private javax.swing.JButton buttonSameFoundName;
    private javax.swing.JButton buttonSameRootName;
    private javax.swing.JButton buttonWatch;
    private javax.swing.JCheckBox checkAutoCopy;
    private javax.swing.JCheckBox checkWatch;
    private javax.swing.JTextField editClipboard;
    private javax.swing.JTextField editDestinyFolder;
    private javax.swing.JTextField editDestinyName;
    private javax.swing.JTextField editWatch;
    private javax.swing.JLabel labelClipboard;
    private javax.swing.JLabel labelDestinyFolder;
    private javax.swing.JLabel labelDestinyName;
    private javax.swing.JLabel labelFound;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JList<WatchFoundDisplay> listWatch;
    private javax.swing.JPanel panelProcess;
    private javax.swing.JPanel panelWatch;
    private javax.swing.JScrollPane scrollWatch;
    private javax.swing.JSplitPane splitPack;
    // End of variables declaration//GEN-END:variables

    private class WatchFound {

        public final File file;
        public final String verifier;
        public final List<String> places;

        public WatchFound(File file, String verifier) {
            this.file = file;
            this.verifier = verifier;
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
