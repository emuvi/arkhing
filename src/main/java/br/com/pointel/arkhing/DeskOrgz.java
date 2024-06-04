package br.com.pointel.arkhing;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author emuvi
 */
public class DeskOrgz extends javax.swing.JPanel {
    
    private final Desk desk;
    
    private final DefaultListModel<OrgzFolder> modelFolder = new DefaultListModel<>();
    private final DefaultListModel<OrgzAssets> modelAssets = new DefaultListModel<>();
    private final DefaultComboBoxModel<OrgzSubFolder> modelSubFolders = new DefaultComboBoxModel<>();
    
    public DeskOrgz(Desk desk) {
        this.desk = desk;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFolder = new javax.swing.JPopupMenu();
        menuFolderUpdate = new javax.swing.JMenuItem();
        menuFolderRandom = new javax.swing.JMenuItem();
        menuFolderSearch = new javax.swing.JMenuItem();
        menuFolderNewChild = new javax.swing.JMenuItem();
        menuFolderNewSibling = new javax.swing.JMenuItem();
        menuFolderOpen = new javax.swing.JMenuItem();
        menuFolderRename = new javax.swing.JMenuItem();
        menuFolderReplace = new javax.swing.JMenuItem();
        menuFolderRemove = new javax.swing.JMenuItem();
        menuFolderAddIndex = new javax.swing.JMenuItem();
        menuFolderDestinyPack = new javax.swing.JMenuItem();
        menuAssets = new javax.swing.JPopupMenu();
        menuAssetsUpdate = new javax.swing.JMenuItem();
        menuAssetsRandom = new javax.swing.JMenuItem();
        menuAssetsSearch = new javax.swing.JMenuItem();
        menuAssetsOpen = new javax.swing.JMenuItem();
        menuAssetsRename = new javax.swing.JMenuItem();
        menuAssetsReplace = new javax.swing.JMenuItem();
        menuAssetsRemove = new javax.swing.JMenuItem();
        menuAssetsAddIndex = new javax.swing.JMenuItem();
        menuAssetsRecortar = new javax.swing.JMenuItem();
        menuAssetsColar = new javax.swing.JMenuItem();
        comboSubFolders = new javax.swing.JComboBox<>();
        editSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        splitBody = new javax.swing.JSplitPane();
        scrollAssets = new javax.swing.JScrollPane();
        listAssets = new javax.swing.JList<>();
        scrollFolder = new javax.swing.JScrollPane();
        listFolder = new javax.swing.JList<>();

        menuFolderUpdate.setMnemonic('U');
        menuFolderUpdate.setText("Update");
        menuFolderUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderUpdateActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderUpdate);

        menuFolderRandom.setMnemonic('M');
        menuFolderRandom.setText("Random");
        menuFolderRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderRandomActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderRandom);

        menuFolderSearch.setMnemonic('S');
        menuFolderSearch.setText("Search");
        menuFolderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderSearchActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderSearch);

        menuFolderNewChild.setMnemonic('C');
        menuFolderNewChild.setText("New Child");
        menuFolderNewChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderNewChildActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderNewChild);

        menuFolderNewSibling.setMnemonic('B');
        menuFolderNewSibling.setText("New Sibling");
        menuFolderNewSibling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderNewSiblingActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderNewSibling);

        menuFolderOpen.setMnemonic('O');
        menuFolderOpen.setText("Open");
        menuFolderOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderOpenActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderOpen);

        menuFolderRename.setMnemonic('N');
        menuFolderRename.setText("Rename");
        menuFolderRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderRenameActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderRename);

        menuFolderReplace.setMnemonic('P');
        menuFolderReplace.setText("Replace");
        menuFolderReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderReplaceActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderReplace);

        menuFolderRemove.setMnemonic('R');
        menuFolderRemove.setText("Remove");
        menuFolderRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderRemoveActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderRemove);

        menuFolderAddIndex.setMnemonic('I');
        menuFolderAddIndex.setText("Add Index");
        menuFolderAddIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderAddIndexActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderAddIndex);

        menuFolderDestinyPack.setMnemonic('D');
        menuFolderDestinyPack.setText("Destiny Pack");
        menuFolderDestinyPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderDestinyPackActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderDestinyPack);

        menuAssetsUpdate.setMnemonic('U');
        menuAssetsUpdate.setText("Update");
        menuAssetsUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsUpdateActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsUpdate);

        menuAssetsRandom.setMnemonic('M');
        menuAssetsRandom.setLabel("Random");
        menuAssetsRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsRandomActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsRandom);

        menuAssetsSearch.setMnemonic('S');
        menuAssetsSearch.setText("Search");
        menuAssetsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsSearchActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsSearch);

        menuAssetsOpen.setMnemonic('O');
        menuAssetsOpen.setText("Open");
        menuAssetsOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsOpenActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsOpen);

        menuAssetsRename.setMnemonic('N');
        menuAssetsRename.setText("Rename");
        menuAssetsRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsRenameActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsRename);

        menuAssetsReplace.setMnemonic('P');
        menuAssetsReplace.setText("Replace");
        menuAssetsReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsReplaceActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsReplace);

        menuAssetsRemove.setMnemonic('R');
        menuAssetsRemove.setText("Remove");
        menuAssetsRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsRemoveActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsRemove);

        menuAssetsAddIndex.setMnemonic('I');
        menuAssetsAddIndex.setText("Add Index");
        menuAssetsAddIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsAddIndexActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsAddIndex);

        menuAssetsRecortar.setMnemonic('C');
        menuAssetsRecortar.setText("Recortar");
        menuAssetsRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsRecortarActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsRecortar);

        menuAssetsColar.setMnemonic('A');
        menuAssetsColar.setText("Colar");
        menuAssetsColar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsColarActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsColar);

        comboSubFolders.setFont(WizSwing.fontMonospaced());
        comboSubFolders.setModel(modelSubFolders);
        comboSubFolders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubFoldersActionPerformed(evt);
            }
        });

        editSearch.setFont(WizSwing.fontMonospaced());
        editSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSearchActionPerformed(evt);
            }
        });

        buttonSearch.setFont(WizSwing.fontMonospaced());
        buttonSearch.setText(">");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        splitBody.setDividerLocation(200);
        splitBody.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        listAssets.setFont(WizSwing.fontMonospaced());
        listAssets.setModel(modelAssets);
        listAssets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAssetsMouseClicked(evt);
            }
        });
        listAssets.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listAssetsKeyPressed(evt);
            }
        });
        scrollAssets.setViewportView(listAssets);

        splitBody.setRightComponent(scrollAssets);

        listFolder.setFont(WizSwing.fontMonospaced());
        listFolder.setModel(modelFolder);
        listFolder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listFolderMouseClicked(evt);
            }
        });
        listFolder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listFolderKeyPressed(evt);
            }
        });
        listFolder.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFolderValueChanged(evt);
            }
        });
        scrollFolder.setViewportView(listFolder);

        splitBody.setLeftComponent(scrollFolder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splitBody, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboSubFolders, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSubFolders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearch)
                    .addComponent(editSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitBody, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private volatile File lastLoadedBase = null;
    
    public void initUpdater() {
        WizBase.startDaemon(() -> {
            while (desk.isVisible()) {
                WizBase.sleep(500);
                if (!Objects.equals(lastLoadedBase, desk.getBase() == null ? null : desk.getBase().root)) {
                    lastLoadedBase = desk.getBase().root;
                    updateFolder(lastLoadedBase);
                }
            }
        }, "DeskOrgz - Updater");
    }
    
    private void updateFolder(File path) {
        var folderSelected = listFolder.getSelectedValue();
        var assetSelected = listAssets.getSelectedValue();
        modelFolder.removeAllElements();
        if (path != null) {
            loadFolders(path, 0, new ArrayList<>())
                    .stream().forEach((folder) -> modelFolder.addElement(folder));
        }
        var anySelected = false;
        if (folderSelected != null) {
            for (int i = 0; i < modelFolder.getSize(); i++) {
                if (Objects.equals(folderSelected, modelFolder.get(i))) {
                    listFolder.setSelectedIndex(i);
                    anySelected = true;
                    break;
                }
            }
        }
        if (assetSelected != null) {
            for (int i = 0; i < modelAssets.getSize(); i++) {
                if (Objects.equals(assetSelected, modelAssets.get(i))) {
                    listAssets.setSelectedIndex(i);
                    anySelected = true;
                    break;
                }
            }
        }
        if (!anySelected && !modelFolder.isEmpty()) {
            listFolder.setSelectedIndex(0);
        }
    }
    
    public void selectFolderAndAsset(File path) {
        if (path == null) {
            return;
        }
        for (int i = 0; i < modelFolder.getSize(); i++) {
            if (Objects.equals(path.getParentFile(), modelFolder.get(i).path)) {
                listFolder.setSelectedValue(modelFolder.get(i), true);
            }
        }
        listFolderValueChanged(null);
        for (int i = 0; i < modelFolder.getSize(); i++) {
            if (Objects.equals(path, modelFolder.get(i).path)) {
                listFolder.setSelectedValue(modelFolder.get(i), true);
            }
        }
        listFolderValueChanged(null);
        for (int i = 0; i < modelAssets.getSize(); i++) {
            if (Objects.equals(path, modelAssets.get(i).path)) {
                listAssets.setSelectedValue(modelAssets.get(i), true);
            }
        }
    }
    
    private List<OrgzFolder> loadFolders(File path, int depth, List<OrgzFolder> list) {
        if (path.isDirectory()) {
            list.add(new OrgzFolder(depth, path));
            for (var inside : path.listFiles()) {
                loadFolders(inside, depth + 1, list);
            }
        }
        return list;
    }

    private void listAssetsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listAssetsKeyPressed
        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_ENTER:
                menuAssetsOpenActionPerformed(null);
                break;
            case KeyEvent.VK_F1:
                menuAssetsSearchActionPerformed(null);
                break;
            case KeyEvent.VK_F2:
                menuAssetsRenameActionPerformed(null);
                break;
            case KeyEvent.VK_F3:
                searchNextAssets();
                break;
            case KeyEvent.VK_F4:
                menuAssetsAddIndexActionPerformed(null);
                break;
            case KeyEvent.VK_F12:
                menuAssets.show(listAssets, 0, 0);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_listAssetsKeyPressed

    private void menuFolderRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderRenameActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, (newName) -> {
                try {
                    renameFolder(selected, newName);
                    updateFolder(lastLoadedBase);
                } catch (Exception e) {
                    WizSwing.showError(e);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuFolderRenameActionPerformed

    private void menuFolderReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderReplaceActionPerformed
        var allSelected = listFolder.getSelectedValuesList();
        if (allSelected != null && !allSelected.isEmpty()) {
            new ViewReplacer((replacer) -> {
                try {
                    for (var itemSelected : allSelected) {
                        var oldName = itemSelected.path.getName();
                        var newName = replacer.replace(oldName);
                        renameFolder(itemSelected, newName);
                    }
                    updateFolder(lastLoadedBase);
                } catch (Exception e) {
                    WizSwing.showError(e);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuFolderReplaceActionPerformed

    private void menuAssetsRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsRenameActionPerformed
        var allSelected = listAssets.getSelectedValuesList();
        if (allSelected != null && !allSelected.isEmpty()) {
            var selectedFirstName = new File(
                    allSelected.get(0).path.getParentFile(),
                    FilenameUtils.getBaseName(allSelected.get(0).path.getName())
            );
            new ViewNamer(selectedFirstName, (newName) -> {
                try {
                    for (var selected : allSelected) {
                        renameAssets(selected, newName + "." + FilenameUtils.getExtension(selected.path.getName()));
                    }
                    listAssets.requestFocus();
                } catch (Exception e) {
                    WizSwing.showError(e);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuAssetsRenameActionPerformed

    private void menuAssetsReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsReplaceActionPerformed
        var allSelected = listAssets.getSelectedValuesList();
        if (allSelected != null && !allSelected.isEmpty()) {
            new ViewReplacer((replacer) -> {
                try {
                    for (var itemSelected : allSelected) {
                        var oldName = itemSelected.path.getName();
                        var newName = replacer.replace(oldName);
                        renameAssets(itemSelected, newName);
                    }
                    listAssets.requestFocus();
                } catch (Exception e) {
                    WizSwing.showError(e);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuAssetsReplaceActionPerformed

    private void listAssetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAssetsMouseClicked
        SwingUtilities.invokeLater(() -> {
            if (evt.getButton() == MouseEvent.BUTTON3
                    || evt.getButton() == MouseEvent.BUTTON1 && evt.isAltDown()) {
                menuAssets.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
    }//GEN-LAST:event_listAssetsMouseClicked

    private void menuFolderOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderOpenActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            try {
                Desktop.getDesktop().open(selected.path);
            } catch (Exception e) {
                WizSwing.showError(e);
            }
        }
    }//GEN-LAST:event_menuFolderOpenActionPerformed

    private void menuAssetsOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsOpenActionPerformed
        var selected = listAssets.getSelectedValue();
        if (selected != null) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Desktop.getDesktop().open(selected.path);
                    } catch (Exception e) {
                        WizSwing.showError(e);
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_menuAssetsOpenActionPerformed

    private void menuAssetsRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsRandomActionPerformed
        var allSelected = listAssets.getSelectedValuesList();
        if (allSelected == null || allSelected.size() <= 1) {
            listAssets.setSelectedIndex(new Random().nextInt(modelAssets.getSize()));
            listAssets.ensureIndexIsVisible(listAssets.getSelectedIndex());
        } else {
            var draw = allSelected.get(new Random().nextInt(allSelected.size()));
            listAssets.setSelectedValue(draw, true);
        }
    }//GEN-LAST:event_menuAssetsRandomActionPerformed

    private void menuFolderRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderRandomActionPerformed
        var allSelected = listFolder.getSelectedValuesList();
        if (allSelected == null || allSelected.size() <= 1) {
            listFolder.setSelectedIndex(new Random().nextInt(modelFolder.getSize()));
            listFolder.ensureIndexIsVisible(listFolder.getSelectedIndex());
        } else {
            var draw = allSelected.get(new Random().nextInt(allSelected.size()));
            listFolder.setSelectedValue(draw, true);
        }
    }//GEN-LAST:event_menuFolderRandomActionPerformed

    private void menuFolderNewSiblingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderNewSiblingActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, "New Sibling", (newName) -> {
                try {
                    var newFolder = new File(selected.path.getParentFile(), newName);
                    Files.createDirectories(newFolder.toPath());
                    updateFolder(lastLoadedBase);
                    selectFolderAndAsset(newFolder);
                } catch (Exception e) {
                    WizSwing.showError(e);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuFolderNewSiblingActionPerformed

    private void menuFolderAddIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderAddIndexActionPerformed
        try {
            var input = JOptionPane.showInputDialog("Index to add:", "1");
            if (input != null && !input.isBlank()) {
                var addIndex = Integer.valueOf(input);
                if (addIndex == 0) {
                    return;
                }
                var allSelected = listFolder.getSelectedValuesList();
                if (allSelected == null) {
                    return;
                }
                if (addIndex < 0) {
                    for (int i = 0; i < allSelected.size(); i++) {
                        makeFolderAddIndex(allSelected, i, addIndex);
                    }
                } else {
                    for (int i = allSelected.size() - 1; i >= 0; i--) {
                        makeFolderAddIndex(allSelected, i, addIndex);
                    }
                }
                updateFolder(lastLoadedBase);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_menuFolderAddIndexActionPerformed
    
    private void makeFolderAddIndex(List<OrgzFolder> allSelected, int i, Integer addIndex) throws Exception {
        var selected = allSelected.get(i);
        var newName = WizChars.getNameWithNewIndex(selected.path.getName(), addIndex);
        renameFolder(selected, newName);
    }

    private void menuAssetsAddIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsAddIndexActionPerformed
        try {
            var input = JOptionPane.showInputDialog("Index to add:", "1");
            if (input != null && !input.isBlank()) {
                var addIndex = Integer.valueOf(input);
                if (addIndex == 0) {
                    return;
                }
                var allSelected = listAssets.getSelectedValuesList();
                if (allSelected == null) {
                    return;
                }
                if (addIndex < 0) {
                    for (int i = 0; i < allSelected.size(); i++) {
                        var selected = allSelected.get(i);
                        var newName = WizChars.getNameWithNewIndex(selected.path.getName(), addIndex);
                        renameAssets(selected, newName);
                    }
                } else {
                    for (int i = allSelected.size() - 1; i >= 0; i--) {
                        var selected = allSelected.get(i);
                        var newName = WizChars.getNameWithNewIndex(selected.path.getName(), addIndex);
                        renameAssets(selected, newName);
                    }
                }
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_menuAssetsAddIndexActionPerformed
    
    private String searchFolder = "";

    private void menuFolderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderSearchActionPerformed
        var input = JOptionPane.showInputDialog("Search Folder:", searchFolder);
        if (input == null || input.isBlank()) {
            return;
        }
        searchFolder = input.trim();
        searchNextFolder();
    }//GEN-LAST:event_menuFolderSearchActionPerformed
    
    private void searchNextFolder() {
        if (searchFolder.isBlank()) {
            return;
        }
        int index = listFolder.getSelectedIndex();
        for (int i = index + 1; i < modelFolder.getSize(); i++) {
            if (modelFolder.get(i).toString().toLowerCase()
                    .contains(searchFolder.toLowerCase())) {
                listFolder.setSelectedValue(modelFolder.get(i), true);
                return;
            }
        }
        for (int i = 0; i < index; i++) {
            if (modelFolder.get(i).toString().toLowerCase()
                    .contains(searchFolder.toLowerCase())) {
                listFolder.setSelectedValue(modelFolder.get(i), true);
                return;
            }
        }
    }
    
    private String searchAssets = "";

    private void menuAssetsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsSearchActionPerformed
        var input = JOptionPane.showInputDialog("Search Assets:", searchAssets);
        if (input == null || input.isBlank()) {
            return;
        }
        searchAssets = input.trim();
        searchNextAssets();
    }//GEN-LAST:event_menuAssetsSearchActionPerformed

    private void menuFolderUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderUpdateActionPerformed
        updateFolder(lastLoadedBase);
    }//GEN-LAST:event_menuFolderUpdateActionPerformed

    private void menuFolderRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderRemoveActionPerformed
        try {
            var allSelected = listFolder.getSelectedValuesList();
            if (allSelected.isEmpty()) {
                return;
            }
            if (JOptionPane.showConfirmDialog(this, "Are you sure to remove all selected?", "Arkhing", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                return;
            }
            for (var selected : allSelected) {
                FileUtils.deleteDirectory(selected.path);
                desk.getBase().delFolder(selected.path);
                modelFolder.removeElement(selected);
            }
            updateFolder(lastLoadedBase);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_menuFolderRemoveActionPerformed

    private void menuAssetsRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsRemoveActionPerformed
        try {
            var allSelected = listAssets.getSelectedValuesList();
            if (allSelected.isEmpty()) {
                return;
            }
            if (JOptionPane.showConfirmDialog(this, "Are you sure to remove all selected?", "Arkhing", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                return;
            }
            for (var selected : allSelected) {
                FileUtils.delete(selected.path);
                desk.getBase().delFile(selected.path);
                modelAssets.removeElement(selected);
            }
            SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(listAssets));
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_menuAssetsRemoveActionPerformed

    private void menuAssetsUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsUpdateActionPerformed
        updateFolder(lastLoadedBase);
    }//GEN-LAST:event_menuAssetsUpdateActionPerformed

    private void menuFolderNewChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderNewChildActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, "New Child", (newName) -> {
                try {
                    var newFolder = new File(selected.path, newName);
                    Files.createDirectories(newFolder.toPath());
                    updateFolder(lastLoadedBase);
                    selectFolderAndAsset(newFolder);
                } catch (Exception e) {
                    WizSwing.showError(e);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuFolderNewChildActionPerformed

    private void comboSubFoldersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubFoldersActionPerformed
        var selected = (OrgzSubFolder) comboSubFolders.getSelectedItem();
        if (selected != null && selected.path != null) {
            selectFolderAndAsset(selected.path);
            listFolder.requestFocus();
        }
    }//GEN-LAST:event_comboSubFoldersActionPerformed

    private void menuFolderDestinyPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderDestinyPackActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            desk.deskPack.setDestinyFolder(selected.path);
            desk.showPack();
        }
    }//GEN-LAST:event_menuFolderDestinyPackActionPerformed
    
    private final List<OrgzAssets> transferArea = new ArrayList<>();

    private void menuAssetsRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsRecortarActionPerformed
        var allSelected = listAssets.getSelectedValuesList();
        transferArea.clear();
        transferArea.addAll(allSelected);
    }//GEN-LAST:event_menuAssetsRecortarActionPerformed

    private void menuAssetsColarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsColarActionPerformed
        try {
            var folderSelected = listFolder.getSelectedValue();
            if (folderSelected == null || folderSelected.path == null) {
                throw new Exception("No folder selected.");
            }
            var destinyFolder = folderSelected.path;
            if (transferArea.isEmpty()) {
                throw new Exception("No file in the transfer area.");
            }
            for (var transfering : transferArea) {
                if (transfering.path == null) {
                    continue;
                }
                var originFile = transfering.path;
                var destinyFile = new File(destinyFolder, originFile.getName());
                Files.move(originFile.toPath(), destinyFile.toPath());
                desk.getBase().moveFile(originFile, destinyFile);
            }
            transferArea.clear();
            updateFolder(lastLoadedBase);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_menuAssetsColarActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        new DeskOrgzSearch(this, desk.getBase().root, editSearch.getText()).setVisible(true);
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void listFolderValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFolderValueChanged
        modelAssets.removeAllElements();
        modelSubFolders.removeAllElements();
        modelSubFolders.addElement(new OrgzSubFolderTitle());
        var allSelected = listFolder.getSelectedValuesList();
        if (allSelected == null || allSelected.isEmpty()) {
            return;
        }
        for (var selected : allSelected) {
            for (var inside : selected.path.listFiles()) {
                if (inside.isFile()) {
                    modelAssets.addElement(new OrgzAssets(inside));
                } else if (inside.isDirectory()) {
                    modelSubFolders.addElement(new OrgzSubFolder(inside));
                }
            }
        }
    }//GEN-LAST:event_listFolderValueChanged

    private void listFolderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listFolderKeyPressed
        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_ENTER:
            menuFolderOpenActionPerformed(null);
            break;
            case KeyEvent.VK_F1:
            menuFolderSearchActionPerformed(null);
            break;
            case KeyEvent.VK_F2:
            menuFolderRenameActionPerformed(null);
            break;
            case KeyEvent.VK_F3:
            searchNextFolder();
            break;
            case KeyEvent.VK_F4:
            menuFolderAddIndexActionPerformed(null);
            break;
            case KeyEvent.VK_F5:
            menuFolderNewSiblingActionPerformed(null);
            break;
            case KeyEvent.VK_F6:
            menuFolderNewChildActionPerformed(null);
            break;
            case KeyEvent.VK_F12:
            menuFolder.show(listFolder, 0, 0);
            break;
            default:
            break;
        }
    }//GEN-LAST:event_listFolderKeyPressed

    private void listFolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listFolderMouseClicked
        SwingUtilities.invokeLater(() -> {
            if (evt.getButton() == MouseEvent.BUTTON3
                || evt.getButton() == MouseEvent.BUTTON1 && evt.isAltDown()) {
                menuFolder.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
    }//GEN-LAST:event_listFolderMouseClicked

    private void editSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSearchActionPerformed
        buttonSearchActionPerformed(evt);
    }//GEN-LAST:event_editSearchActionPerformed
    
    private void searchNextAssets() {
        if (searchAssets.isBlank()) {
            return;
        }
        int index = listAssets.getSelectedIndex();
        for (int i = index + 1; i < modelAssets.getSize(); i++) {
            if (modelAssets.get(i).toString().toLowerCase()
                    .contains(searchFolder.toLowerCase())) {
                listAssets.setSelectedValue(modelAssets.get(i), true);
                return;
            }
        }
        for (int i = 0; i < index; i++) {
            if (modelAssets.get(i).toString().toLowerCase()
                    .contains(searchFolder.toLowerCase())) {
                listAssets.setSelectedValue(modelAssets.get(i), true);
                return;
            }
        }
    }
    
    private File renameFolder(OrgzFolder orgz, String newName) throws Exception {
        if (Objects.equals(newName, orgz.path.getName())) {
            return null;
        }
        var oldName = orgz.path.getName();
        var originFolder = orgz.path;
        var destinyFolder = new File(orgz.path.getParentFile(), newName);
        if (originFolder.renameTo(destinyFolder)) {
            for (var insideOrigin : destinyFolder.listFiles()) {
                if (insideOrigin.getName().startsWith(oldName)) {
                    var suffix = insideOrigin.getName().substring(oldName.length());
                    var newInsideName = newName + suffix;
                    var insideDestiny = new File(insideOrigin.getParentFile(), newInsideName);
                    renameFile(insideOrigin, insideDestiny);
                }
            }
            orgz.path = destinyFolder;
            SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(listFolder));
            desk.getBase().moveFolder(originFolder, destinyFolder);
            return destinyFolder;
        } else {
            throw new Exception("Could not rename folder from: " + originFolder.getAbsolutePath() + " to: " + destinyFolder.getAbsolutePath());
        }
    }
    
    private void renameAssets(OrgzAssets orgz, String newName) throws Exception {
        if (Objects.equals(newName, orgz.path.getName())) {
            return;
        }
        var originFile = orgz.path;
        var destinyFile = new File(orgz.path.getParentFile(), newName);
        renameFile(originFile, destinyFile);
        orgz.path = destinyFile;
        SwingUtilities.invokeLater(() -> SwingUtilities.updateComponentTreeUI(listAssets));
    }
    
    private void renameFile(File origin, File destiny) throws Exception {
        if (!origin.renameTo(destiny)) {
            throw new Exception("Could not rename file from: " + origin.getAbsolutePath() + " to: " + destiny.getAbsolutePath());
        }
        desk.getBase().moveFile(origin, destiny);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSearch;
    private javax.swing.JComboBox<OrgzSubFolder> comboSubFolders;
    private javax.swing.JTextField editSearch;
    private javax.swing.JList<OrgzAssets> listAssets;
    private javax.swing.JList<OrgzFolder> listFolder;
    private javax.swing.JPopupMenu menuAssets;
    private javax.swing.JMenuItem menuAssetsAddIndex;
    private javax.swing.JMenuItem menuAssetsColar;
    private javax.swing.JMenuItem menuAssetsOpen;
    private javax.swing.JMenuItem menuAssetsRandom;
    private javax.swing.JMenuItem menuAssetsRecortar;
    private javax.swing.JMenuItem menuAssetsRemove;
    private javax.swing.JMenuItem menuAssetsRename;
    private javax.swing.JMenuItem menuAssetsReplace;
    private javax.swing.JMenuItem menuAssetsSearch;
    private javax.swing.JMenuItem menuAssetsUpdate;
    private javax.swing.JPopupMenu menuFolder;
    private javax.swing.JMenuItem menuFolderAddIndex;
    private javax.swing.JMenuItem menuFolderDestinyPack;
    private javax.swing.JMenuItem menuFolderNewChild;
    private javax.swing.JMenuItem menuFolderNewSibling;
    private javax.swing.JMenuItem menuFolderOpen;
    private javax.swing.JMenuItem menuFolderRandom;
    private javax.swing.JMenuItem menuFolderRemove;
    private javax.swing.JMenuItem menuFolderRename;
    private javax.swing.JMenuItem menuFolderReplace;
    private javax.swing.JMenuItem menuFolderSearch;
    private javax.swing.JMenuItem menuFolderUpdate;
    private javax.swing.JScrollPane scrollAssets;
    private javax.swing.JScrollPane scrollFolder;
    private javax.swing.JSplitPane splitBody;
    // End of variables declaration//GEN-END:variables

    private class OrgzItem {
        
        public File path;
        
        public OrgzItem(File path) {
            this.path = path;
        }
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 19 * hash + Objects.hashCode(this.path);
            return hash;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final OrgzItem other = (OrgzItem) obj;
            return Objects.equals(this.path, other.path);
        }
        
    }
    
    private class OrgzFolder extends OrgzItem {
        
        public int depth;
        
        public OrgzFolder(int depth, File path) {
            super(path);
            this.depth = depth;
        }
        
        @Override
        public String toString() {
            var result = new StringBuilder("|");
            IntStream.range(1, depth + 1)
                    .forEach((i) -> result.append(i == depth ? "-->" : "---"));
            result.append(" ");
            result.append(path.getName());
            return result.toString();
        }
        
    }
    
    private class OrgzAssets extends OrgzItem {
        
        public OrgzAssets(File path) {
            super(path);
        }
        
        @Override
        public String toString() {
            return "|-> " + path.getName();
        }
        
    }
    
    private class OrgzSubFolder {
        
        public final File path;
        
        public OrgzSubFolder(File path) {
            this.path = path;
        }
        
        @Override
        public String toString() {
            return path.getName();
        }
        
    }
    
    private class OrgzSubFolderTitle extends OrgzSubFolder {
        
        public OrgzSubFolderTitle() {
            super(null);
        }
        
        @Override
        public String toString() {
            return "<-- SubFolders -->";
        }
        
    }
    
}
