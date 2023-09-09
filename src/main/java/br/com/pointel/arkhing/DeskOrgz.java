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
    
    private void listFolderValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFolderValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listFolderValueChanged

    private void buttonFolderNamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderNamerActionPerformed
        var selected = listFolder.getSelectedValue();
        if (selected != null) {
            new ViewNamer(selected.path, (name) -> renameFolder(selected, name))
                    .setVisible(true);
        }
    }//GEN-LAST:event_buttonFolderNamerActionPerformed

    private void buttonFolderReplacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderReplacerActionPerformed
        new ViewReplacer().setVisible(true);
    }//GEN-LAST:event_buttonFolderReplacerActionPerformed

    private void buttonAssetsReplacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAssetsReplacerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAssetsReplacerActionPerformed

    private void renameFolder(OrgzFolder orgzFolder, String name) {
        var destiny = new File(orgzFolder.path.getParentFile(), name);
        if (orgzFolder.path.renameTo(destiny)) {
            orgzFolder.path = destiny;
        }
        SwingUtilities.updateComponentTreeUI(listFolder);
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

    private class OrgzFolder {
        
        public int depth;
        public File path;

        public OrgzFolder(int depth, File path) {
            this.depth = depth;
            this.path = path;
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
    
    private class OrgzAssets {}

}
