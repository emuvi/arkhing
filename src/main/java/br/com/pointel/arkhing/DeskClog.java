package br.com.pointel.arkhing;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.TransferHandler;

public class DeskClog extends javax.swing.JPanel {

    private final Desk desk;

    public DeskClog(Desk desk) {
        this.desk = desk;
        setTransferHandler(new FileDropHandler());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("Drop here the files to catalog");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(278, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    final class FileDropHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            for (DataFlavor flavor : support.getDataFlavors()) {
                if (flavor.isFlavorJavaFileListType()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean importData(TransferHandler.TransferSupport support) {
            if (!this.canImport(support)) {
                return false;
            }
            try {
                var files = (List<File>) support.getTransferable()
                        .getTransferData(DataFlavor.javaFileListFlavor);
                new Catalog(desk, files).setVisible(true);
                return true;
            } catch (Exception ex) {
                WizSwing.showError(ex);
                return false;
            }
        }
    }

}
