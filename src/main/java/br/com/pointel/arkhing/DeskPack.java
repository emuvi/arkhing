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
import java.util.concurrent.atomic.AtomicInteger;
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
    private final AtomicBoolean hasWatchChanges = new AtomicBoolean(false);
    private final AtomicBoolean shouldWait = new AtomicBoolean(false);
    private final AtomicInteger watchedWithNoChanges = new AtomicInteger(0);

    private volatile File defaultDestinyFolder = null;

    public DeskPack(Desk desk) {
        this.desk = desk;
        initComponents();
        labelFound.setVisible(false);
    }

    public void initUpdater() {
        WizBase.startDaemon(() -> {
            while (desk.isVisible()) {
                WizBase.sleep(500);
                updateWatch();
            }
        }, "DeskPack - Updater");
    }

    public void setDestinyFolder(File path) {
        defaultDestinyFolder = path;
        editDestinyFolder.setText(path.getAbsolutePath());
    }

    public boolean hasDownloadingInWatchFolder() {
        for (var inside : new File(editWatch.getText()).listFiles()) {
            if (inside.isFile() && inside.getName().toLowerCase().endsWith(".crdownload")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAnyFileInWatchFolder() {
        for (var inside : new File(editWatch.getText()).listFiles()) {
            if (inside.isFile()) {
                return true;
            }
        }
        return false;
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
        labelStatus = new javax.swing.JLabel();
        labelFound = new javax.swing.JLabel();
        labelClipboard = new javax.swing.JLabel();
        editClipboard = new javax.swing.JTextField();
        buttonClazzFolder = new javax.swing.JButton();
        buttonSelectFolder = new javax.swing.JButton();
        buttonSelectOrgz = new javax.swing.JButton();
        buttonFolderOpen = new javax.swing.JButton();
        butttonSuggestName = new javax.swing.JButton();
        checkAutoCopy = new javax.swing.JCheckBox();
        buttonNameCopy = new javax.swing.JButton();
        editDestinyFolder = new javax.swing.JTextField();
        editDestinyName = new javax.swing.JTextField();
        panelProcess = new javax.swing.JPanel();
        buttonSameRootName = new javax.swing.JButton();
        buttonSameFoundName = new javax.swing.JButton();
        buttonMakeAulaName = new javax.swing.JButton();
        buttonMakeAutoName = new javax.swing.JButton();
        buttonSelectDestinyFolder = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        checkAutoSelectDestiny = new javax.swing.JCheckBox();
        checkQuickMake = new javax.swing.JCheckBox();
        spinnerAutoMake = new javax.swing.JSpinner();

        editWatch.setEditable(false);
        editWatch.setFont(WizSwing.fontMonospaced());
        editWatch.setText(WizProps.get("DESK_PACK_WATCH", ""));

        buttonWatch.setText("Select");
        buttonWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWatchActionPerformed(evt);
            }
        });

        checkWatch.setMnemonic('W');
        checkWatch.setText("Watch");
        checkWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWatchActionPerformed(evt);
            }
        });

        splitPack.setDividerLocation(200);
        splitPack.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splitPack.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                splitPackComponentResized(evt);
            }
        });

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

        labelStatus.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(0, 0, 153));
        labelStatus.setText("Size: 0 | Wait: No");

        labelFound.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        labelFound.setForeground(new java.awt.Color(255, 0, 0));
        labelFound.setText("Already Present on Base!!!");

        labelClipboard.setText("Clipboard");

        editClipboard.setFont(WizSwing.fontMonospaced());

        buttonClazzFolder.setMnemonic('F');
        buttonClazzFolder.setText("Clazz Folder");
        buttonClazzFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClazzFolderActionPerformed(evt);
            }
        });

        buttonSelectFolder.setMnemonic('S');
        buttonSelectFolder.setText("Select");
        buttonSelectFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectFolderActionPerformed(evt);
            }
        });

        buttonSelectOrgz.setMnemonic('G');
        buttonSelectOrgz.setText("Orgz");
        buttonSelectOrgz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectOrgzActionPerformed(evt);
            }
        });

        buttonFolderOpen.setMnemonic('O');
        buttonFolderOpen.setText("Open");
        buttonFolderOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderOpenActionPerformed(evt);
            }
        });

        butttonSuggestName.setMnemonic('D');
        butttonSuggestName.setText("Suggest Name");
        butttonSuggestName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butttonSuggestNameActionPerformed(evt);
            }
        });

        checkAutoCopy.setText("Auto");

        buttonNameCopy.setMnemonic('C');
        buttonNameCopy.setText("Copy");
        buttonNameCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNameCopyActionPerformed(evt);
            }
        });

        editDestinyFolder.setEditable(false);
        editDestinyFolder.setFont(WizSwing.fontMonospaced());

        editDestinyName.setFont(WizSwing.fontMonospaced());

        panelProcess.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        buttonSameRootName.setMnemonic('1');
        buttonSameRootName.setText("1 - Same Root Name");
        buttonSameRootName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSameRootNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonSameRootName);

        buttonSameFoundName.setMnemonic('2');
        buttonSameFoundName.setText("2 - Same Found Name");
        buttonSameFoundName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSameFoundNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonSameFoundName);

        buttonMakeAulaName.setMnemonic('3');
        buttonMakeAulaName.setText("3 - Make Aula Name");
        buttonMakeAulaName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMakeAulaNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonMakeAulaName);

        buttonMakeAutoName.setMnemonic('4');
        buttonMakeAutoName.setText("4 - Make Auto Name");
        buttonMakeAutoName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMakeAutoNameActionPerformed(evt);
            }
        });
        panelProcess.add(buttonMakeAutoName);

        buttonSelectDestinyFolder.setText(">");
        buttonSelectDestinyFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectDestinyFolderActionPerformed(evt);
            }
        });

        buttonRemove.setText("Remove");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelWatchLayout = new javax.swing.GroupLayout(panelWatch);
        panelWatch.setLayout(panelWatchLayout);
        panelWatchLayout.setHorizontalGroup(
            panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editClipboard)
                    .addGroup(panelWatchLayout.createSequentialGroup()
                        .addComponent(buttonClazzFolder)
                        .addGap(12, 12, 12)
                        .addComponent(checkAutoSelectDestiny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSelectDestinyFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSelectFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSelectOrgz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFolderOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(buttonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(butttonSuggestName)
                        .addGap(18, 18, 18)
                        .addComponent(checkAutoCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNameCopy))
                    .addGroup(panelWatchLayout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addGap(18, 18, 18)
                        .addComponent(labelFound)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelClipboard))
                    .addComponent(panelProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editDestinyName)
                    .addComponent(editDestinyFolder))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkAutoCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(butttonSuggestName))
                    .addGroup(panelWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSelectFolder)
                        .addComponent(buttonNameCopy)
                        .addComponent(buttonFolderOpen)
                        .addComponent(buttonSelectOrgz)
                        .addComponent(buttonClazzFolder)
                        .addComponent(buttonSelectDestinyFolder)
                        .addComponent(buttonRemove)
                        .addComponent(checkAutoSelectDestiny)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editDestinyFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editDestinyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        splitPack.setRightComponent(panelWatch);

        checkQuickMake.setMnemonic('Q');
        checkQuickMake.setText("Quick Make");

        spinnerAutoMake.setFont(WizSwing.fontMonospaced());
        spinnerAutoMake.setModel(new javax.swing.SpinnerNumberModel(18, null, null, 1));

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
                        .addComponent(checkWatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkQuickMake)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerAutoMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editWatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkWatch)
                    .addComponent(buttonWatch)
                    .addComponent(checkQuickMake)
                    .addComponent(spinnerAutoMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitPack, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateWatch() {
        if (checkWatch.isSelected()) {
            updateClipboard();
            var watchFile = new File(editWatch.getText());
            if (watchFile.exists()) {
                watchPath(watchFile);
                SwingUtilities.invokeLater(() -> {
                    synchronized (hasWatchChanges) {
                        if (hasWatchChanges.get()) {
                            if (defaultDestinyFolder != null) {
                                editDestinyFolder.setText(defaultDestinyFolder.getAbsolutePath());
                            }
                            watchedWithNoChanges.set(0);
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
                                        var destiny = new File(desk.getBase().root, place);
                                        editDestinyFolder.setText(destiny.getParent());
                                        editDestinyName.setText(FilenameUtils.getBaseName(destiny.getName()));
                                        labelFound.setVisible(true);
                                        if (checkAutoSelectDestiny.isSelected()) {
                                            buttonSelectDestinyFolderActionPerformed(null);
                                        }
                                    }
                                }
                            }
                            listWatch.setSelectedValue(selected, true);
                            labelStatus.setText("Size: " + watchFounds.size() + " - Wait: " + (wait ? "Yes" : "No"));
                            shouldWait.set(wait);
                            hasWatchChanges.set(false);
                        } else {
                            var cyclesWithNoChanges = watchedWithNoChanges.incrementAndGet();
                            if (cyclesWithNoChanges >= (Integer) spinnerAutoMake.getValue()) {
                                watchedWithNoChanges.set(0);
                                if (!watchFounds.isEmpty() && checkQuickMake.isSelected()) {
                                    buttonMakeAutoNameActionPerformed(null);
                                }
                            }
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
            var founds = desk.getBase().baseData.getByVerifier(verifier);
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
            synchronized (hasWatchChanges) {
                editWatch.setText(selected.getAbsolutePath());
                modelWatch.removeAllElements();
                watchFounds.clear();
                hasWatchChanges.set(false);
            }
            WizProps.set("DESK_PACK_WATCH", editWatch.getText());
        }
    }//GEN-LAST:event_buttonWatchActionPerformed

    private void buttonSelectFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectFolderActionPerformed
        var selected = WizSwing.selectFolder(defaultDestinyFolder != null ? defaultDestinyFolder : desk.getBase().root);
        if (selected != null) {
            defaultDestinyFolder = selected;
            editDestinyFolder.setText(selected.getAbsolutePath());
        }
    }//GEN-LAST:event_buttonSelectFolderActionPerformed

    private void buttonNameCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNameCopyActionPerformed
        editDestinyName.setText(cleanName(editClipboard.getText()));
    }//GEN-LAST:event_buttonNameCopyActionPerformed

    private String cleanName(String name) {
        return name
                .replace(":", "-")
                .replace("|", "-")
                .replace("/", "-")
                .replace("\\", "-")
                .replace("?", "")
                .replace("\"", "'")
                .replaceAll("\\s+", " ")
                .replaceAll("(\\S)\\-\\s", "$1 - ")
                .trim();
    }

    private void checkIfDownloading() throws Exception {
        var allSelected = getSelectedToProcess();
        for (var selected : allSelected) {
            if (selected.file.getName().toLowerCase().endsWith(".crdownload")
                    || selected.file.getName().toLowerCase().endsWith(".tmp")) {
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
        } catch (Exception e) {
            WizSwing.showError(e);
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
        } catch (Exception e) {
            return;
        }

        try {
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
        desk.getBase().putFile(destiny, verifier);
    }

    private void listWatchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listWatchKeyPressed
        if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_DELETE) {
            removeSeletected();
        }
    }//GEN-LAST:event_listWatchKeyPressed

    private void removeSeletected() {
        for (var selected : listWatch.getSelectedValuesList()) {
            selected.watchFound.file.delete();
        }
    }

    private void buttonFolderOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderOpenActionPerformed
        try {
            var destinyFolder = new File(editDestinyFolder.getText());
            Files.createDirectories(destinyFolder.toPath());
            Desktop.getDesktop().open(destinyFolder);
        } catch (IOException ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonFolderOpenActionPerformed

    private void listWatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWatchMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() >= 2) {
            var selected = listWatch.getSelectedValue();
            if (selected instanceof WatchFoundPlace selectedPlace) {
                var destiny = new File(desk.getBase().root, selectedPlace.place);
                editDestinyFolder.setText(destiny.getParent());
                editDestinyName.setText(FilenameUtils.getBaseName(destiny.getName()));
            }
        }
    }//GEN-LAST:event_listWatchMouseClicked

    private final AtomicBoolean shootPacker = new AtomicBoolean(false);

    private boolean isOnlyPDFs() {
        return watchFounds.stream().allMatch((found) -> found.file.getName().toLowerCase().endsWith(".pdf"));
    }

    private void buttonMakeAutoNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMakeAutoNameActionPerformed
        if (!shootPacker.get()) {
            shootPacker.set(true);
            new Thread() {
                @Override
                public void run() {
                    try {
                        while (shouldWait.get()) {
                            WizBase.sleep(10);
                        }
                        SwingUtilities.invokeLater(() -> {
                            if (isOnlyPDFs()) {
                                buttonSameRootNameActionPerformed(evt);
                            } else if (labelFound.isVisible()) {
                                buttonSameFoundNameActionPerformed(evt);
                            } else {
                                buttonMakeAulaNameActionPerformed(evt);
                            }
                        });
                    } catch (Exception e) {
                        WizSwing.showError(e);
                    } finally {
                        shootPacker.set(false);
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_buttonMakeAutoNameActionPerformed

    private void buttonSelectOrgzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectOrgzActionPerformed
        if (!editDestinyFolder.getText().isEmpty()) {
            desk.deskOrgz.selectFolderAndAsset(new File(editDestinyFolder.getText()));
            desk.showOrgz();
        }
    }//GEN-LAST:event_buttonSelectOrgzActionPerformed

    private void checkWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWatchActionPerformed
        if (checkWatch.isSelected()) {
            checkAutoCopy.setSelected(true);
        }
    }//GEN-LAST:event_checkWatchActionPerformed

    private void butttonSuggestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butttonSuggestNameActionPerformed
        editDestinyName.requestFocus();
    }//GEN-LAST:event_butttonSuggestNameActionPerformed

    private void buttonClazzFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClazzFolderActionPerformed
        editDestinyFolder.requestFocus();
    }//GEN-LAST:event_buttonClazzFolderActionPerformed

    private void splitPackComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_splitPackComponentResized
        splitPack.setDividerLocation(splitPack.getHeight() - (panelWatch.getMinimumSize().height + 30));
    }//GEN-LAST:event_splitPackComponentResized

    private void buttonSelectDestinyFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectDestinyFolderActionPerformed
        defaultDestinyFolder = new File(editDestinyFolder.getText());
    }//GEN-LAST:event_buttonSelectDestinyFolderActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        removeSeletected();
    }//GEN-LAST:event_buttonRemoveActionPerformed

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
    private javax.swing.JButton buttonClazzFolder;
    private javax.swing.JButton buttonFolderOpen;
    private javax.swing.JButton buttonMakeAulaName;
    private javax.swing.JButton buttonMakeAutoName;
    private javax.swing.JButton buttonNameCopy;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonSameFoundName;
    private javax.swing.JButton buttonSameRootName;
    private javax.swing.JButton buttonSelectDestinyFolder;
    private javax.swing.JButton buttonSelectFolder;
    private javax.swing.JButton buttonSelectOrgz;
    private javax.swing.JButton buttonWatch;
    private javax.swing.JButton butttonSuggestName;
    private javax.swing.JCheckBox checkAutoCopy;
    private javax.swing.JCheckBox checkAutoSelectDestiny;
    private javax.swing.JCheckBox checkQuickMake;
    private javax.swing.JCheckBox checkWatch;
    private javax.swing.JTextField editClipboard;
    private javax.swing.JTextField editDestinyFolder;
    private javax.swing.JTextField editDestinyName;
    private javax.swing.JTextField editWatch;
    private javax.swing.JLabel labelClipboard;
    private javax.swing.JLabel labelFound;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JList<WatchFoundDisplay> listWatch;
    private javax.swing.JPanel panelProcess;
    private javax.swing.JPanel panelWatch;
    private javax.swing.JScrollPane scrollWatch;
    private javax.swing.JSpinner spinnerAutoMake;
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
