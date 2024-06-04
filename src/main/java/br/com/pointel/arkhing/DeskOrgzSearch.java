package br.com.pointel.arkhing;

import java.awt.HeadlessException;
import java.io.File;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class DeskOrgzSearch extends javax.swing.JFrame {

    private final DeskOrgz deskOrgz;
    private final File root;
    private final Integer rootPathSize;
    private final Set<String> searchFor;
    private final DefaultListModel<FoundDisplay> foundsModel = new DefaultListModel<>();
    private final AtomicBoolean stop = new AtomicBoolean(false);
    private final AtomicBoolean doneFindOnPath = new AtomicBoolean(false);
    private final AtomicInteger doneFindOnFile = new AtomicInteger(0);
    private final Integer totalFileThreads = 8;

    public DeskOrgzSearch(DeskOrgz deskOrgz, File root, String searchFor) throws HeadlessException {
        this.deskOrgz = deskOrgz;
        this.root = root;
        this.rootPathSize = root.getAbsolutePath().length();
        this.searchFor = WizChars.getKeyWords(searchFor);
        initComponents();
        WizSwing.initPositioner(this);
    }

    private synchronized void addFound(File path) {
        if (!path.isDirectory()) {
            path = path.getParentFile();
        }
        var found = new FoundDisplay(path);
        if (!foundsModel.contains(found)) {
            foundsModel.addElement(found);
        }
    }

    private final Queue<File> prospects = new ConcurrentLinkedQueue<>();

    private void start() {
        new Thread(() -> startFindOnPath(), "DeskOrgzSearch - Find On Path").start();
        for (int i = 1; i <= totalFileThreads; i++) {
            new Thread(() -> startFindOnFile(), "DeskOrgzSearch - Find On File " + i).start();
        }
        new Thread(() -> startStatusUpdater(), "DeskOrgzSearch - Status Updater").start();
    }

    private void startFindOnPath() {
        try {
            findOnPath(root);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            doneFindOnPath.set(true);
        }
    }

    private void startFindOnFile() {
        try {
            while (true) {
                var prospect = prospects.poll();
                if (prospect != null) {
                    findOnFile(root);
                } else if (doneFindOnPath.get()) {
                    return;
                }
                WizBase.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            doneFindOnFile.incrementAndGet();
        }
    }
    
    private void startStatusUpdater() {
        while (doneFindOnFile.get() < totalFileThreads) {
            WizBase.sleep(100);
        }
        SwingUtilities.invokeLater(() -> labelStatus.setText("Done."));
    }

    private void findOnPath(File path) {
        if (shouldStop()) {
            return;
        }
        var pathNameWords = WizChars.getKeyWords(path.getName());
        if (pathNameWords.containsAll(searchFor)) {
            addFound(path);
        }
        if (path.isDirectory()) {
            for (var inside : path.listFiles()) {
                if (shouldStop()) {
                    return;
                }
                findOnPath(inside);
            }
        } else {
            prospects.add(path);
        }
    }

    private void findOnFile(File path) {
        if (DockReader.canRead(path)) {
            try {
                var source = new DockReader(path).read();
                var fileWords = WizChars.getKeyWords(source);
                if (fileWords.containsAll(searchFor)) {
                    addFound(path);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean shouldStop() {
        return !isDisplayable() || stop.get();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCancel = new javax.swing.JButton();
        buttonSelect = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        scrollFounds = new javax.swing.JScrollPane();
        listFounds = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orgz Search");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        buttonCancel.setFont(WizSwing.fontMonospaced());
        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonSelect.setFont(WizSwing.fontMonospaced());
        buttonSelect.setText("Select");
        buttonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectActionPerformed(evt);
            }
        });

        labelStatus.setFont(WizSwing.fontMonospaced());
        labelStatus.setText("Searching...");

        scrollFounds.setFont(WizSwing.fontMonospaced());

        listFounds.setFont(WizSwing.fontMonospaced());
        listFounds.setModel(foundsModel);
        scrollFounds.setViewportView(listFounds);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollFounds, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollFounds, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonSelect)
                    .addComponent(labelStatus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        start();
    }//GEN-LAST:event_formWindowOpened

    private void buttonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectActionPerformed
        stop.set(true);
        var selected = listFounds.getSelectedValue();
        if (selected != null) {
            deskOrgz.selectFolderAndAsset(selected.getFound());
        }
        WizSwing.close(this);
    }//GEN-LAST:event_buttonSelectActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        stop.set(true);
        WizSwing.close(this);
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSelect;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JList<FoundDisplay> listFounds;
    private javax.swing.JScrollPane scrollFounds;
    // End of variables declaration//GEN-END:variables

    private class FoundDisplay {
        
        private final File found;

        public FoundDisplay(File found) {
            this.found = found;
        }

        public File getFound() {
            return found;
        }

        @Override
        public String toString() {
            return found.getAbsolutePath().substring(rootPathSize);
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 23 * hash + Objects.hashCode(this.found);
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
            final FoundDisplay other = (FoundDisplay) obj;
            return Objects.equals(this.found, other.found);
        }
        
    }

}
