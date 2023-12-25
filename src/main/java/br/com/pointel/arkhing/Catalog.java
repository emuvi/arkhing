package br.com.pointel.arkhing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

public class Catalog extends javax.swing.JFrame {

    private final Desk desk;
    private final List<File> files;

    private volatile PDDocument document = null;

    private volatile int loadIndex = -1;
    private volatile int fileIndex = 0;
    private volatile int pageIndex = -1;

    private volatile Image pageImage = null;
    private final DrawPanel drawPanel = new DrawPanel();

    public Catalog(Desk desk, List<File> files) throws Exception {
        this.desk = desk;
        this.files = files;
        WizSwing.initPositioner(this);
        initComponents();
        loadRoot();
        panelPage.add(drawPanel);
    }

    private void loadRoot() {
        for (var inside : desk.arkhBase.root.listFiles()) {
            if (inside.isDirectory()) {
                comboRaiz.addItem(inside.getName());
            }
        }
    }

    private void loadDocument() throws Exception {
        if (loadIndex != fileIndex) {
            document = PDDocument.load(files.get(fileIndex));
            loadIndex = fileIndex;
        }
    }

    private void loadPage() throws Exception {
        loadDocument();
        loadPageImage();
        loadPageText();
        updateStatus();
        textPage.requestFocus();
    }

    private void loadPageImage() throws Exception {
        final var finalDocument = document;
        final var finalFileIndex = fileIndex;
        final var finalPageIndex = pageIndex;
        new Thread() {
            private boolean yetSame() {
                return finalFileIndex == fileIndex && finalPageIndex == pageIndex;
            }

            @Override
            public void run() {
                try {
                    PDFRenderer pdfRenderer = new PDFRenderer(finalDocument);
                    if (!yetSame()) {
                        return;
                    }
                    BufferedImage imageRendered = pdfRenderer.renderImageWithDPI(finalPageIndex, 300, ImageType.RGB);
                    if (!yetSame()) {
                        return;
                    }
                    var scaledDimension = WizImage.getScaledDimension(new Dimension(imageRendered.getWidth(), imageRendered.getHeight()), panelPage.getSize());
                    if (!yetSame()) {
                        return;
                    }
                    var scaledImage = imageRendered.getScaledInstance((int) scaledDimension.getWidth(), (int) scaledDimension.getHeight(), Image.SCALE_SMOOTH);
                    if (!yetSame()) {
                        return;
                    }
                    pageImage = scaledImage;
                    SwingUtilities.invokeLater(() -> panelPage.repaint());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void loadPageText() throws Exception {
        var stripper = new PDFTextStripper();
        stripper.setStartPage(pageIndex + 1);
        stripper.setEndPage(pageIndex + 1);
        textPage.setText(stripper.getText(document));
    }
    
    private void updateStatus() {
        final var status = "Page " + (pageIndex + 1) + " Doc " + (fileIndex + 1);
        SwingUtilities.invokeLater(() -> labelStatus.setText(status));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonClazz = new javax.swing.JButton();
        panelDestiny = new javax.swing.JPanel();
        comboRaiz = new javax.swing.JComboBox<>();
        buttonNew = new javax.swing.JButton();
        panelNaming = new javax.swing.JPanel();
        editTitle = new javax.swing.JTextField();
        editSubtitle = new javax.swing.JTextField();
        editAuthor = new javax.swing.JTextField();
        panelViewer = new javax.swing.JPanel();
        panelPage = new javax.swing.JPanel();
        scrollPage = new javax.swing.JScrollPane();
        textPage = new javax.swing.JTextArea();
        panelActions = new javax.swing.JPanel();
        buttonPrior = new javax.swing.JButton();
        buttonNext = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonTitle = new javax.swing.JButton();
        buttonSubtitle = new javax.swing.JButton();
        buttonAuthor = new javax.swing.JButton();
        buttonCatalog = new javax.swing.JButton();
        buttonJump = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        buttonOpen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arkhing - Catalog");

        buttonClazz.setMnemonic('Z');
        buttonClazz.setText("Clazz");
        buttonClazz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClazzActionPerformed(evt);
            }
        });

        panelDestiny.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        comboRaiz.setFont(WizSwing.fontMonospaced());
        panelDestiny.add(comboRaiz);

        buttonNew.setMnemonic('N');
        buttonNew.setText("New");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        panelNaming.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        editTitle.setFont(WizSwing.fontMonospaced());
        panelNaming.add(editTitle);

        editSubtitle.setFont(WizSwing.fontMonospaced());
        panelNaming.add(editSubtitle);

        editAuthor.setFont(WizSwing.fontMonospaced());
        panelNaming.add(editAuthor);

        panelViewer.setLayout(new java.awt.GridLayout(1, 0));

        panelPage.setLayout(new java.awt.GridLayout(1, 1));
        panelViewer.add(panelPage);

        textPage.setColumns(20);
        textPage.setFont(WizSwing.fontMonospaced());
        textPage.setRows(5);
        scrollPage.setViewportView(textPage);

        panelViewer.add(scrollPage);

        buttonPrior.setMnemonic('R');
        buttonPrior.setText("Prior");
        buttonPrior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPriorActionPerformed(evt);
            }
        });

        buttonNext.setMnemonic('X');
        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        buttonClear.setMnemonic('e');
        buttonClear.setText("Clear");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonTitle.setMnemonic('T');
        buttonTitle.setText("Title");
        buttonTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTitleActionPerformed(evt);
            }
        });

        buttonSubtitle.setMnemonic('S');
        buttonSubtitle.setText("Subtitle");
        buttonSubtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubtitleActionPerformed(evt);
            }
        });

        buttonAuthor.setMnemonic('A');
        buttonAuthor.setText("Author");
        buttonAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAuthorActionPerformed(evt);
            }
        });

        buttonCatalog.setMnemonic('C');
        buttonCatalog.setText("Catalog");
        buttonCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCatalogActionPerformed(evt);
            }
        });

        buttonJump.setMnemonic('J');
        buttonJump.setText("Jump");
        buttonJump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJumpActionPerformed(evt);
            }
        });

        labelStatus.setText("Page 0 Doc 0");

        javax.swing.GroupLayout panelActionsLayout = new javax.swing.GroupLayout(panelActions);
        panelActions.setLayout(panelActionsLayout);
        panelActionsLayout.setHorizontalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActionsLayout.createSequentialGroup()
                .addComponent(buttonPrior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(buttonClear)
                .addGap(18, 18, 18)
                .addComponent(buttonTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAuthor)
                .addGap(18, 18, 18)
                .addComponent(buttonCatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonJump))
        );
        panelActionsLayout.setVerticalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrior)
                    .addComponent(buttonNext)
                    .addComponent(buttonJump)
                    .addComponent(buttonCatalog)
                    .addComponent(buttonTitle)
                    .addComponent(buttonSubtitle)
                    .addComponent(buttonAuthor)
                    .addComponent(labelStatus)
                    .addComponent(buttonClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonOpen.setMnemonic('O');
        buttonOpen.setText("Open");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNaming, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonClazz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOpen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonClazz, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonNew)
                            .addComponent(buttonOpen)))
                    .addComponent(panelDestiny, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNaming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelViewer, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAuthorActionPerformed
        editAuthor.setText(cleanAuthor(composeSelected(editAuthor)));
        textPage.requestFocus();
    }//GEN-LAST:event_buttonAuthorActionPerformed

    private void buttonPriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPriorActionPerformed
        try {
            if (pageIndex > -1) {
                pageIndex--;
                loadPage();
            }
            textPage.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonPriorActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        try {
            pageIndex++;
            loadPage();
            textPage.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNextActionPerformed

    private String cleanName(String name) {
        return name.trim()
                .replace("?", "")
                .replace("\\", "")
                .replace("\"", "")
                .replace("/", "")
                .replace("*", "")
                .replace("<", "")
                .replace(">", "")
                .replace("|", "")
                .replace(":", "~")
                .replaceAll("\\s+", " ")
                .toLowerCase();
    }
    
    private String cleanTitles(String titles) {
        return StringUtils.capitalize(cleanName(titles));
    }

    private String cleanAuthor(String author) {
        var parts = cleanName(author).split("\\s+");
        var result = "";
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                result += " ";
            }
            result += StringUtils.capitalize(parts[i]);
        }
        return result;
    }

    private String composeSelected(JTextField withField) {
        var result = withField.getText().trim();
        var selected = textPage.getSelectedText().trim();
        if (!selected.isBlank()) {
            result = result + " " + selected;
        }
        return result.trim();
    }
    
    private void buttonTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTitleActionPerformed
        editTitle.setText(cleanTitles(composeSelected(editTitle)));
        textPage.requestFocus();
    }//GEN-LAST:event_buttonTitleActionPerformed

    private void buttonSubtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubtitleActionPerformed
        editSubtitle.setText(cleanTitles(composeSelected(editSubtitle)));
        textPage.requestFocus();
    }//GEN-LAST:event_buttonSubtitleActionPerformed

    private void buttonCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCatalogActionPerformed
        try {
            var destinyFolder = new File(desk.arkhBase.root, (String) comboRaiz.getSelectedItem());
            Files.createDirectories(destinyFolder.toPath());
            var destinyName = editTitle.getText().trim();
            if (!editSubtitle.getText().isBlank()) {
                destinyName += " - " + editSubtitle.getText().trim();
            }
            if (!editAuthor.getText().isBlank()) {
                destinyName += " - " + editAuthor.getText().trim();
            }
            destinyName += "." + FilenameUtils.getExtension(files.get(fileIndex).getName());
            var destinyFile = new File(destinyFolder, destinyName);
            if (destinyFile.exists()) {
                throw new Exception("Destiny file already exists.");
            }
            closeDocument();
            Files.move(files.get(fileIndex).toPath(), destinyFile.toPath());
            doJump();
            textPage.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonCatalogActionPerformed

    private void buttonJumpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJumpActionPerformed
        try {
            doJump();
            textPage.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonJumpActionPerformed

    private void closeDocument() throws Exception {
        if (document != null) {
            document.close();
            document = null;
        }
    }
    
    private void doJump() throws Exception {
        if (fileIndex < files.size() - 1) {
            closeDocument();
            fileIndex++;
            pageIndex = 0;
            loadPage();
            editTitle.setText("");
            editSubtitle.setText("");
            editAuthor.setText("");
        } else {
            WizSwing.close(this);
        }
    }

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        try {
            var newClass = WizSwing.showInput("New Class");
            if (newClass != null && !newClass.isBlank()) {
                comboRaiz.addItem(newClass);
                comboRaiz.setSelectedItem(newClass);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonClazzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClazzActionPerformed
        comboRaiz.requestFocus();
    }//GEN-LAST:event_buttonClazzActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        editTitle.setText("");
        editSubtitle.setText("");
        editAuthor.setText("");
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        try {
            var destinyFolder = new File(desk.arkhBase.root, (String) comboRaiz.getSelectedItem());
            WizSwing.open(destinyFolder);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonOpenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAuthor;
    private javax.swing.JButton buttonCatalog;
    private javax.swing.JButton buttonClazz;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonJump;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonPrior;
    private javax.swing.JButton buttonSubtitle;
    private javax.swing.JButton buttonTitle;
    private javax.swing.JComboBox<String> comboRaiz;
    private javax.swing.JTextField editAuthor;
    private javax.swing.JTextField editSubtitle;
    private javax.swing.JTextField editTitle;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JPanel panelActions;
    private javax.swing.JPanel panelDestiny;
    private javax.swing.JPanel panelNaming;
    private javax.swing.JPanel panelPage;
    private javax.swing.JPanel panelViewer;
    private javax.swing.JScrollPane scrollPage;
    private javax.swing.JTextArea textPage;
    // End of variables declaration//GEN-END:variables

    private class DrawPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (pageImage != null) {
                g.drawImage(pageImage, 0, 0, null);
            }
        }

    }

}
