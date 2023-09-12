package br.com.pointel.arkhing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

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

        searchFolder = new javax.swing.JTextField();
        buttonFolderNamer = new javax.swing.JButton();
        buttonFolderReplacer = new javax.swing.JButton();
        splitBody = new javax.swing.JSplitPane();
        scrollFolder = new javax.swing.JScrollPane();
        listFolder = new javax.swing.JList<>();
        scrollAssets = new javax.swing.JScrollPane();
        listAssets = new javax.swing.JList<>();
        searchAssets = new javax.swing.JTextField();
        buttonAssetsNamer = new javax.swing.JButton();
        buttonAssetsReplacer = new javax.swing.JButton();

        buttonFolderNamer.setText("Namer");
        buttonFolderNamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderNamerActionPerformed(evt);
            }
        });

        buttonFolderReplacer.setText("Replacer");
        buttonFolderReplacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderReplacerActionPerformed(evt);
            }
        });

        splitBody.setDividerLocation(200);
        splitBody.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        listFolder.setFont(WizSwing.fontMonospaced());
        listFolder.setModel(modelFolder);
        listFolder.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFolderValueChanged(evt);
            }
        });
        scrollFolder.setViewportView(listFolder);

        splitBody.setTopComponent(scrollFolder);

        listAssets.setFont(WizSwing.fontMonospaced());
        listAssets.setModel(modelAssets);
        scrollAssets.setViewportView(listAssets);

        splitBody.setRightComponent(scrollAssets);

        buttonAssetsNamer.setText("Namer");
        buttonAssetsNamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAssetsNamerActionPerformed(evt);
            }
        });

        buttonAssetsReplacer.setText("Replacer");
        buttonAssetsReplacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAssetsReplacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splitBody, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFolderNamer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFolderReplacer))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchAssets)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAssetsNamer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAssetsReplacer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonFolderNamer)
                    .addComponent(searchFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFolderReplacer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitBody, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAssetsNamer)
                    .addComponent(searchAssets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAssetsReplacer))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private volatile File lastLoadedBase = null; 
    
    public void initUpdater() {
        WizBase.startDaemon(() -> {
            while (desk.isVisible()) {
                WizBase.sleep(500);
                if (desk.arkhBase != null) {
                    if (!Objects.equals(lastLoadedBase, desk.arkhBase.root)) {
                        lastLoadedBase = desk.arkhBase.root;
                        updateFolder(lastLoadedBase);
                    }
                }
            }
        }, "DeskOrgz - Updater");
    }
    
    private void updateFolder(File path) {
        modelFolder.removeAllElements();
        loadFolders(path, 0, new ArrayList<>())
                .stream().forEach((folder) -> modelFolder.addElement(folder));
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
    
    private void buttonFolderNamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderNamerActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, (newName) -> { 
                renameOrgz(selected, newName); 
            }).setVisible(true);
        }
    }//GEN-LAST:event_buttonFolderNamerActionPerformed

    private void buttonFolderReplacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderReplacerActionPerformed
        var allSelected = listFolder.getSelectedValuesList();
        if (allSelected != null && !allSelected.isEmpty()) {
            new ViewReplacer((replacer) -> {
                for (var itemSelected : allSelected) {
                    var oldName = itemSelected.path.getName();
                    var newName = replacer.replace(oldName);
                    renameOrgz(itemSelected, newName); 
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_buttonFolderReplacerActionPerformed

    private void buttonAssetsReplacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAssetsReplacerActionPerformed
        var allSelected = listAssets.getSelectedValuesList();
        if (allSelected != null && !allSelected.isEmpty()) {
            new ViewReplacer((replacer) -> {
                for (var itemSelected : allSelected) {
                    var oldName = itemSelected.path.getName();
                    var newName = replacer.replace(oldName);
                    renameOrgz(itemSelected, newName);
                }
            }).setVisible(true);
        }
    }//GEN-LAST:event_buttonAssetsReplacerActionPerformed

    private void listFolderValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFolderValueChanged
        modelAssets.removeAllElements();
        var allSelected = listFolder.getSelectedValuesList();
        if (allSelected == null || allSelected.isEmpty()) return;
        for (var selected : allSelected) {
            for (var inside : selected.path.listFiles()) {
                modelAssets.addElement(new OrgzAssets(inside));
            }
        }
    }//GEN-LAST:event_listFolderValueChanged

    private void buttonAssetsNamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAssetsNamerActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, (newName) -> { 
                renameOrgz(selected, newName); 
            }).setVisible(true);
        }
    }//GEN-LAST:event_buttonAssetsNamerActionPerformed

    private void renameOrgz(OrgzItem orgz, String newName) {
        if (Objects.equals(newName, orgz.path.getName())) return;
        var destiny = new File(orgz.path.getParentFile(), newName);
        if (orgz.path.renameTo(destiny)) {
            orgz.path = destiny;
        }
        SwingUtilities.updateComponentTreeUI(listFolder);
        SwingUtilities.updateComponentTreeUI(listAssets);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAssetsNamer;
    private javax.swing.JButton buttonAssetsReplacer;
    private javax.swing.JButton buttonFolderNamer;
    private javax.swing.JButton buttonFolderReplacer;
    private javax.swing.JList<OrgzAssets> listAssets;
    private javax.swing.JList<OrgzFolder> listFolder;
    private javax.swing.JScrollPane scrollAssets;
    private javax.swing.JScrollPane scrollFolder;
    private javax.swing.JTextField searchAssets;
    private javax.swing.JTextField searchFolder;
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
            return "- " + path.getName();
        }
        
    }

}
