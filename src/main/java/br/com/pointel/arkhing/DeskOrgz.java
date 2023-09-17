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
        menuFolderOpen = new javax.swing.JMenuItem();
        menuFolderNamer = new javax.swing.JMenuItem();
        menuFolderReplacer = new javax.swing.JMenuItem();
        menuFolderProcess = new javax.swing.JMenuItem();
        menuAssets = new javax.swing.JPopupMenu();
        menuAssetsOpen = new javax.swing.JMenuItem();
        menuAssetsNamer = new javax.swing.JMenuItem();
        menuAssetsReplacer = new javax.swing.JMenuItem();
        menuAssetsRandom = new javax.swing.JMenuItem();
        splitBody = new javax.swing.JSplitPane();
        scrollFolder = new javax.swing.JScrollPane();
        listFolder = new javax.swing.JList<>();
        scrollAssets = new javax.swing.JScrollPane();
        listAssets = new javax.swing.JList<>();

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

        menuFolderProcess.setText("Process");
        menuFolderProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFolderProcessActionPerformed(evt);
            }
        });
        menuFolder.add(menuFolderProcess);

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

        menuAssetsRandom.setText("Randomer");
        menuAssetsRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssetsRandomActionPerformed(evt);
            }
        });
        menuAssets.add(menuAssetsRandom);

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
                menuFolderReplacerActionPerformed(null);
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
                menuAssetsReplacerActionPerformed(null);
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
        if (allSelected == null || allSelected.isEmpty()) {
            return;
        }
        var extension = JOptionPane.showInputDialog("Extension:").toLowerCase();
        for (int i = 0; i < 100; i++) {
            var random = new Random();
            var attempt = random.nextInt(allSelected.size());
            var draw = allSelected.get(attempt).path;
            if (draw.getName().toLowerCase().endsWith(extension)) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            WizSwing.showInfo("Opening: " + draw.getName());
                            Desktop.getDesktop().open(draw);
                        } catch (Exception e) {
                            WizSwing.showError(e);
                        }
                    }
                }.start();
                break;
            }
        }
    }//GEN-LAST:event_menuAssetsRandomActionPerformed

    private void menuFolderProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFolderProcessActionPerformed
        WizSwing.showConfirm("Nothing to process.");
    }//GEN-LAST:event_menuFolderProcessActionPerformed

    private void renameFolder(OrgzFolder orgz, String newName) {
        if (Objects.equals(newName, orgz.path.getName())) {
            return;
        }
        try {
            var destiny = new File(orgz.path.getParentFile(), newName);
            if (orgz.path.renameTo(destiny)) {
                orgz.path = destiny;
            }
            SwingUtilities.updateComponentTreeUI(listFolder);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
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
    private javax.swing.JMenuItem menuAssetsNamer;
    private javax.swing.JMenuItem menuAssetsOpen;
    private javax.swing.JMenuItem menuAssetsRandom;
    private javax.swing.JMenuItem menuAssetsReplacer;
    private javax.swing.JPopupMenu menuFolder;
    private javax.swing.JMenuItem menuFolderNamer;
    private javax.swing.JMenuItem menuFolderOpen;
    private javax.swing.JMenuItem menuFolderProcess;
    private javax.swing.JMenuItem menuFolderReplacer;
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
