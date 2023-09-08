package br.com.pointel.arkhing;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author emuvi
 */
public class DeskPack extends javax.swing.JPanel {

    private final Desk desk;

    private final DefaultListModel<WatchFound> modelWatch = new DefaultListModel<>();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splitPack)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editWatch, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
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
                .addComponent(splitPack, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
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
            var watchFile = new File(editWatch.getText());
            if (watchFile.exists()) {
                var founds = new ArrayList<WatchFound>();
                watchPath(watchFile, founds);
                var selected = listWatch.getSelectedValue();
                SwingUtilities.invokeLater(() -> {
                    modelWatch.removeAllElements();
                    modelWatch.addAll(founds);
                    listWatch.setSelectedValue(selected, true);
                });
            }
        }
    }

    private void watchPath(File path, List<WatchFound> founds) {
        if (path.isDirectory()) {
            for (var inside : path.listFiles()) {
                watchFile(inside, founds);
            }
        } else {
            watchFile(path, founds);
        }
    }

    private void watchFile(File file, List<WatchFound> founds) {
        founds.addAll(findWatched(file));
    }

    private final Map<File, List<WatchFound>> watchCached = new HashMap<>();

    private List<WatchFound> findWatched(File file) {
        if (watchCached.containsKey(file)) {
            return watchCached.get(file);
        }
        var results = new ArrayList<WatchFound>();
        try (var input = new FileInputStream(file)) {
            var verifier = DigestUtils.sha256Hex(input);
            var founds = desk.arkhBase.baseData.getByVerifier(verifier);
            results.add(new WatchFoundFile(file));
            if (founds.isEmpty()) {
                results.add(new WatchFoundNone());
            } else {
                for (var found : founds) {
                    results.add(new WatchFoundPlace(found.place));
                }
            }
            watchCached.put(file, results);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    private void buttonWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWatchActionPerformed
        var selected = WizSwing.selectFolder(new File(editWatch.getText()));
        if (selected != null) {
            editWatch.setText(selected.getAbsolutePath());
            WizProps.set("DESK_PACK_WATCH", editWatch.getText());
        }
    }//GEN-LAST:event_buttonWatchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonWatch;
    private javax.swing.JCheckBox checkWatch;
    private javax.swing.JTextField editWatch;
    private javax.swing.JList<WatchFound> listWatch;
    private javax.swing.JScrollPane scrollWatch;
    private javax.swing.JSplitPane splitPack;
    // End of variables declaration//GEN-END:variables

    private abstract class WatchFound {
    }

    private class WatchFoundFile extends WatchFound {

        public File file;

        public WatchFoundFile(File file) {
            this.file = file;
        }

        @Override
        public String toString() {
            return file.getName();
        }

    }

    private class WatchFoundPlace extends WatchFound {

        public String place;

        public WatchFoundPlace(String place) {
            this.place = place;
        }

        @Override
        public String toString() {
            return "-> " + place;
        }

    }

    private class WatchFoundNone extends WatchFound {

        @Override
        public String toString() {
            return "-> Is not present on the base.";
        }

    }

}
