package br.com.pointel.arkhing;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author emuvi
 */
public class DeskOrgz extends javax.swing.JPanel {

    private final Desk desk;

    private final DefaultListModel<OrgzFolder> modelFolder = new DefaultListModel<>();
    private final DefaultListModel<OrgzAssets> modelAssets = new DefaultListModel<>();

    public DeskOrgz(Desk desk) {
        this.desk = desk;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFolder = new javax.swing.JPopupMenu();
        menuFolderSearch = new javax.swing.JMenuItem();
        menuFolderNew = new javax.swing.JMenuItem();
        menuFolderOpen = new javax.swing.JMenuItem();
        menuFolderNamer = new javax.swing.JMenuItem();
        menuFolderReplacer = new javax.swing.JMenuItem();
        menuFolderAddIndex = new javax.swing.JMenuItem();
        menuFolderRandom = new javax.swing.JMenuItem();
        menuFolderGroovy = new javax.swing.JMenuItem();
        menuAssets = new javax.swing.JPopupMenu();
        menuAssetsSearch = new javax.swing.JMenuItem();
        menuAssetsNew = new javax.swing.JMenuItem();
        menuAssetsOpen = new javax.swing.JMenuItem();
        menuAssetsNamer = new javax.swing.JMenuItem();
        menuAssetsReplacer = new javax.swing.JMenuItem();
        menuAssetsAddIndex = new javax.swing.JMenuItem();
        menuAssetsRandom = new javax.swing.JMenuItem();
        menuAssetsGroovy = new javax.swing.JMenuItem();
        splitBody = new javax.swing.JSplitPane();
        scrollFolder = new javax.swing.JScrollPane();
        listFolder = new javax.swing.JList<>();
        scrollAssets = new javax.swing.JScrollPane();
        listAssets = new javax.swing.JList<>();

        menuFolderSearch.setText("Search");
        menuFolderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderSearchActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderSearch);

        menuFolderNew.setText("New");
        menuFolderNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderNewActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderNew);

        menuFolderOpen.setText("Open");
        menuFolderOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderOpenActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderOpen);

        menuFolderNamer.setText("Namer");
        menuFolderNamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderNamerActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderNamer);

        menuFolderReplacer.setText("Replacer");
        menuFolderReplacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderReplacerActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderReplacer);

        menuFolderAddIndex.setText("Add Index");
        menuFolderAddIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderAddIndexActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderAddIndex);

        menuFolderRandom.setText("Random");
        menuFolderRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderRandomActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderRandom);

        menuFolderGroovy.setText("Groovy");
        menuFolder.add(menuFolderGroovy);

        menuAssetsSearch.setText("Search");
        menuAssetsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsSearchActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsSearch);

        menuAssetsNew.setText("New");
        menuAssetsNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsNewActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsNew);

        menuAssetsOpen.setText("Open");
        menuAssetsOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsOpenActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsOpen);

        menuAssetsNamer.setText("Namer");
        menuAssetsNamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsNamerActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsNamer);

        menuAssetsReplacer.setText("Replacer");
        menuAssetsReplacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsReplacerActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsReplacer);

        menuAssetsAddIndex.setText("Add Index");
        menuAssetsAddIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsAddIndexActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsAddIndex);

        menuAssetsRandom.setLabel("Random");
        menuAssetsRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsRandomActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsRandom);

        menuAssetsGroovy.setText("Groovy");
        menuAssets.add(menuAssetsGroovy);

        splitBody.setDividerLocation(200);
        splitBody.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

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

        splitBody.setTopComponent(scrollFolder);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitBody, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitBody, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private volatile File lastLoadedBase = null;

    public void initUpdater() {
        WizBase.startDaemon(() -> {
            while (desk.isVisible()) {
                WizBase.sleep(500);
                if (!Objects.equals(lastLoadedBase, desk.arkhBase == null ? null : desk.arkhBase.root)) {
                    lastLoadedBase = desk.arkhBase.root;
                    updateFolder(lastLoadedBase);
                }
            }
        }, "DeskOrgz - Updater");
    }

    private void updateFolder(File path) {
        modelFolder.removeAllElements();
        if (path != null) {
            loadFolders(path, 0, new ArrayList<>())
                    .stream().forEach((folder) -> modelFolder.addElement(folder));
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

    private void listFolderValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFolderValueChanged
        modelAssets.removeAllElements();
        var allSelected = listFolder.getSelectedValuesList();
        if (allSelected == null || allSelected.isEmpty()) {
            return;
        }
        for (var selected : allSelected) {
            for (var inside : selected.path.listFiles()) {
                if (inside.isFile()) {
                    modelAssets.addElement(new OrgzAssets(inside));
                }
            }
        }
    }//GEN-LAST:event_listFolderValueChanged

    private void listFolderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listFolderKeyPressed
        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_ENTER:
                menuFolderOpenActionPerformed(null);
                break;
            case KeyEvent.VK_F2:
                menuFolderNamerActionPerformed(null);
                break;
            case KeyEvent.VK_F3:
                searchNextFolder();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_listFolderKeyPressed

    private void listAssetsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listAssetsKeyPressed
        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_ENTER:
                menuAssetsOpenActionPerformed(null);
                break;
            case KeyEvent.VK_F2:
                menuAssetsNamerActionPerformed(null);
                break;
            case KeyEvent.VK_F3:
                searchNextAssets();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_listAssetsKeyPressed

    private void menuFolderNamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderNamerActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, (newName) -> {
                renameFolder(selected, newName);
                listFolder.requestFocus();
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuFolderNamerActionPerformed

    private void menuFolderReplacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderReplacerActionPerformed
        var allSelected = listFolder.getSelectedValuesList();
        if (allSelected != null && !allSelected.isEmpty()) {
            new ViewReplacer((replacer) -> {
                for (var itemSelected : allSelected) {
                    var oldName = itemSelected.path.getName();
                    var newName = replacer.replace(oldName);
                    renameFolder(itemSelected, newName);
                }
                listFolder.requestFocus();
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuFolderReplacerActionPerformed

    private void menuAssetsNamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsNamerActionPerformed
        var selected = listAssets.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, (newName) -> {
                renameAssets(selected, newName);
                listAssets.requestFocus();
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuAssetsNamerActionPerformed

    private void menuAssetsReplacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsReplacerActionPerformed
        var allSelected = listAssets.getSelectedValuesList();
        if (allSelected != null && !allSelected.isEmpty()) {
            new ViewReplacer((replacer) -> {
                for (var itemSelected : allSelected) {
                    var oldName = itemSelected.path.getName();
                    var newName = replacer.replace(oldName);
                    renameAssets(itemSelected, newName);
                }
                listAssets.requestFocus();
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuAssetsReplacerActionPerformed

    private void listFolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listFolderMouseClicked
        SwingUtilities.invokeLater(() -> {
            if (evt.getButton() == MouseEvent.BUTTON3
                    || evt.getButton() == MouseEvent.BUTTON1 && evt.isAltDown()) {
                menuFolder.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
    }//GEN-LAST:event_listFolderMouseClicked

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

    private void menuFolderNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderNewActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, (newName) -> {
                try {
                    var newFolder = new File(selected.path.getParentFile(), newName);
                    if (newFolder.mkdir()) {
                        var index = modelFolder.indexOf(selected);
                        modelFolder.insertElementAt(new OrgzFolder(selected.depth, newFolder), index + 1);
                        listFolder.setSelectedIndex(index + 1);
                        listFolder.ensureIndexIsVisible(index + 1);
                    }
                } catch (Exception e) {
                    WizSwing.showError(e);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_menuFolderNewActionPerformed

    private void menuAssetsNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsNewActionPerformed
        File baseFolder = null;
        File targetFile = null;
        int baseIndex = -1;
        var selectedAsset = listAssets.getSelectedValue();
        if (selectedAsset != null) {
            baseFolder = selectedAsset.path.getParentFile();
            targetFile = selectedAsset.path;
            baseIndex = modelAssets.indexOf(selectedAsset);
        } else {
            var selectedFolder = listFolder.getSelectedValue();
            if (selectedFolder != null) {
                baseFolder = selectedFolder.path;
                targetFile = selectedFolder.path;
            } else {
                baseFolder = desk.arkhBase.root;
                targetFile = desk.arkhBase.root;
            }
        }
        var finalBaseFolder = baseFolder;
        var finalBaseIndex = baseIndex;
        new ViewNamer(targetFile, (newName) -> {
            try {
                var newAsset = new File(finalBaseFolder, newName);
                if (newAsset.createNewFile()) {
                    modelAssets.insertElementAt(new OrgzAssets(newAsset), finalBaseIndex + 1);
                    listAssets.setSelectedIndex(finalBaseIndex + 1);
                    listAssets.ensureIndexIsVisible(finalBaseIndex + 1);
                } else {
                    throw new Exception("Could not create the new file.");
                }
            } catch (Exception e) {
                WizSwing.showError(e);
            }
        }).setVisible(true);
    }//GEN-LAST:event_menuAssetsNewActionPerformed

    private void menuFolderAddIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderAddIndexActionPerformed
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
        }
    }//GEN-LAST:event_menuFolderAddIndexActionPerformed

    private void makeFolderAddIndex(List<OrgzFolder> allSelected, int i, Integer addIndex) {
        var selected = allSelected.get(i);
        var oldName = selected.path.getName();
        var newName = getNameWithNewIndex(selected.path.getName(), addIndex);
        var destiny = renameFolder(selected, newName);
        if (destiny != null) {
            for (var inside : destiny.listFiles()) {
                if (inside.getName().startsWith(oldName)) {
                    var suffix = inside.getName().substring(oldName.length());
                    var newInsideName = newName + suffix;
                    var destinyInside = new File(inside.getParentFile(), newInsideName);
                    inside.renameTo(destinyInside);
                }
            }
        }
    }

    private void menuAssetsAddIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssetsAddIndexActionPerformed
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
                    var newName = getNameWithNewIndex(selected.path.getName(), addIndex);
                    renameAssets(selected, newName);
                }
            } else {
                for (int i = allSelected.size() - 1; i >= 0; i--) {
                    var selected = allSelected.get(i);
                    var newName = getNameWithNewIndex(selected.path.getName(), addIndex);
                    renameAssets(selected, newName);
                }
            }
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
    
    private String getNameWithNewIndex(String name, int addIndex) {
        int begin = -1;
        int end = name.length();
        for (int i = 0; i < name.length(); i++) {
            var charAt = name.charAt(i);
            if (begin == -1) {
                if (Character.isDigit(charAt)) {
                    begin = i;
                }
            } else {
                if (!Character.isDigit(charAt)) {
                    end = i;
                    break;
                }
            }
        }
        if (begin == -1) {
            return name;
        }
        var number = Integer.parseInt(name.substring(begin, end));
        var newNumber = number + addIndex;
        var newNameNumber = StringUtils.leftPad(newNumber + "", end - begin, '0');
        return name.substring(0, begin) + newNameNumber + name.substring(end);
    }

    private File renameFolder(OrgzFolder orgz, String newName) {
        if (Objects.equals(newName, orgz.path.getName())) {
            return null;
        }
        var destiny = new File(orgz.path.getParentFile(), newName);
        if (orgz.path.renameTo(destiny)) {
            orgz.path = destiny;
            SwingUtilities.updateComponentTreeUI(listFolder);
            return destiny;
        }
        return null;
    }

    private void renameAssets(OrgzAssets orgz, String newName) {
        if (Objects.equals(newName, orgz.path.getName())) {
            return;
        }
        try {
            String oldPlace = desk.arkhBase.getPlace(orgz.path);
            var destiny = new File(orgz.path.getParentFile(), newName);
            var oldBased = desk.arkhBase.baseData.getByPlace(oldPlace);
            var newPlace = desk.arkhBase.getPlace(destiny);
            if (orgz.path.renameTo(destiny)) {
                if (oldBased != null) {
                    desk.arkhBase.baseData.delFile(oldPlace);
                    desk.arkhBase.baseData.putFile(newPlace, destiny.lastModified(), oldBased.verifier);
                }
                orgz.path = destiny;
            }
            SwingUtilities.updateComponentTreeUI(listAssets);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<OrgzAssets> listAssets;
    private javax.swing.JList<OrgzFolder> listFolder;
    private javax.swing.JPopupMenu menuAssets;
    private javax.swing.JMenuItem menuAssetsAddIndex;
    private javax.swing.JMenuItem menuAssetsGroovy;
    private javax.swing.JMenuItem menuAssetsNamer;
    private javax.swing.JMenuItem menuAssetsNew;
    private javax.swing.JMenuItem menuAssetsOpen;
    private javax.swing.JMenuItem menuAssetsRandom;
    private javax.swing.JMenuItem menuAssetsReplacer;
    private javax.swing.JMenuItem menuAssetsSearch;
    private javax.swing.JPopupMenu menuFolder;
    private javax.swing.JMenuItem menuFolderAddIndex;
    private javax.swing.JMenuItem menuFolderGroovy;
    private javax.swing.JMenuItem menuFolderNamer;
    private javax.swing.JMenuItem menuFolderNew;
    private javax.swing.JMenuItem menuFolderOpen;
    private javax.swing.JMenuItem menuFolderRandom;
    private javax.swing.JMenuItem menuFolderReplacer;
    private javax.swing.JMenuItem menuFolderSearch;
    private javax.swing.JScrollPane scrollAssets;
    private javax.swing.JScrollPane scrollFolder;
    private javax.swing.JSplitPane splitBody;
    // End of variables declaration//GEN-END:variables

    private class OrgzItem {

        public File path;

        public OrgzItem(File path) {
            this.path = path;
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

}
