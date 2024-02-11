package br.com.pointel.arkhing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

public class Catalog extends javax.swing.JFrame {

    private final Desk desk;
    private final List<File> files;

    private final List<JComboBox> combosPath;

    private volatile File lastSelectedPath = null;

    private volatile PDDocument document = null;

    private volatile int loadIndex = -1;
    private volatile int fileIndex = 0;
    private volatile int pageIndex = -1;

    private volatile Image pageImage = null;
    private final DrawPanel drawPanel = new DrawPanel();

    private JTextField lastSelectedField = null;

    private boolean doneAutoClazz = false;

    public Catalog(Desk desk, List<File> files) throws Exception {
        this.desk = desk;
        this.files = files;
        WizSwing.initPositioner(this);
        initComponents();
        loadRoot();
        combosPath = new ArrayList<>();
        combosPath.add(comboRaiz);
        panelPage.add(drawPanel);
    }

    private void loadRoot() {
        comboRaiz.removeAllItems();
        comboRaiz.addItem("");
        for (var inside : desk.getBase().root.listFiles()) {
            if (inside.isDirectory()) {
                comboRaiz.addItem(inside.getName());
            }
        }
    }

    private void loadDocument() throws Exception {
        if (loadIndex != fileIndex) {
            closeDocument();
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
        if (!doneAutoClazz) {
            doneAutoClazz = true;
            buttonClazzActionPerformed(null);
        }
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
        final var status = "Page " + (pageIndex + 1) + "/" + document.getNumberOfPages()
                + " of Doc " + (fileIndex + 1) + "/" + files.size()
                + " ( -" + (files.size() - fileIndex) + " )";
        SwingUtilities.invokeLater(() -> labelStatus.setText(status));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonClazz = new javax.swing.JButton();
        panelDestiny = new javax.swing.JPanel();
        comboRaiz = new javax.swing.JComboBox<>();
        buttonNew = new javax.swing.JButton();
        panelNaming = new javax.swing.JPanel();
        editSerie = new javax.swing.JTextField();
        editVolume = new javax.swing.JTextField();
        editTitle = new javax.swing.JTextField();
        editEdition = new javax.swing.JTextField();
        editSubtitle = new javax.swing.JTextField();
        editAuthor = new javax.swing.JTextField();
        panelViewer = new javax.swing.JPanel();
        panelPage = new javax.swing.JPanel();
        scrollPage = new javax.swing.JScrollPane();
        textPage = new javax.swing.JTextArea();
        panelActions = new javax.swing.JPanel();
        buttonPrior = new javax.swing.JButton();
        buttonNext = new javax.swing.JButton();
        buttonFirst = new javax.swing.JButton();
        buttonLast = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        buttonOCR = new javax.swing.JButton();
        buttonSerie = new javax.swing.JButton();
        buttonSerieAdd = new javax.swing.JButton();
        buttonSerieEquals = new javax.swing.JButton();
        buttonVolume = new javax.swing.JButton();
        buttonTitle = new javax.swing.JButton();
        buttonTitleAdd = new javax.swing.JButton();
        buttonTitleEquals = new javax.swing.JButton();
        butttonEdition = new javax.swing.JButton();
        buttonSubtitle = new javax.swing.JButton();
        buttonSubtitleAdd = new javax.swing.JButton();
        buttonSubtitleEquals = new javax.swing.JButton();
        buttonAuthor = new javax.swing.JButton();
        buttonAuthorAdd = new javax.swing.JButton();
        buttonAuthorEquals = new javax.swing.JButton();
        buttonSuggest = new javax.swing.JButton();
        checkReCase = new javax.swing.JCheckBox();
        buttonCatalog = new javax.swing.JButton();
        buttonJump = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        buttonOpen = new javax.swing.JButton();
        buttonNameSearch = new javax.swing.JButton();
        buttonNameCopy = new javax.swing.JButton();
        buttonReClazz = new javax.swing.JButton();
        buttonSwitchCase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arkhing - Catalog");

        buttonClazz.setMnemonic('Z');
        buttonClazz.setText("Clazz");
        buttonClazz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClazzActionPerformed(evt);
            }
        });

        panelDestiny.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        comboRaiz.setFont(WizSwing.fontMonospaced());
        comboRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPathActionPerformed(evt);
            }
        });
        panelDestiny.add(comboRaiz);

        buttonNew.setMnemonic('N');
        buttonNew.setText("New");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        panelNaming.setLayout(new java.awt.GridBagLayout());

        editSerie.setFont(WizSwing.fontMonospaced());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelNaming.add(editSerie, gridBagConstraints);

        editVolume.setFont(WizSwing.fontMonospaced());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelNaming.add(editVolume, gridBagConstraints);

        editTitle.setFont(WizSwing.fontMonospaced());
        editTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editTitleFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelNaming.add(editTitle, gridBagConstraints);

        editEdition.setFont(WizSwing.fontMonospaced());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelNaming.add(editEdition, gridBagConstraints);

        editSubtitle.setFont(WizSwing.fontMonospaced());
        editSubtitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editSubtitleFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.8;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelNaming.add(editSubtitle, gridBagConstraints);

        editAuthor.setFont(WizSwing.fontMonospaced());
        editAuthor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editAuthorFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelNaming.add(editAuthor, gridBagConstraints);

        panelViewer.setLayout(new java.awt.GridLayout(1, 0));

        panelPage.setLayout(new java.awt.GridLayout(1, 1));
        panelViewer.add(panelPage);

        textPage.setColumns(20);
        textPage.setFont(WizSwing.fontMonospaced());
        textPage.setRows(5);
        scrollPage.setViewportView(textPage);

        panelViewer.add(scrollPage);

        buttonPrior.setMnemonic('P');
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

        buttonFirst.setMnemonic('F');
        buttonFirst.setText("<");
        buttonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFirstActionPerformed(evt);
            }
        });

        buttonLast.setMnemonic('L');
        buttonLast.setText(">");
        buttonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLastActionPerformed(evt);
            }
        });

        labelStatus.setText("...");

        buttonOCR.setMnemonic('O');
        buttonOCR.setText("OCR");
        buttonOCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOCRActionPerformed(evt);
            }
        });

        buttonSerie.setMnemonic('I');
        buttonSerie.setText("Serie");
        buttonSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSerieActionPerformed(evt);
            }
        });

        buttonSerieAdd.setText("+");
        buttonSerieAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSerieAddActionPerformed(evt);
            }
        });

        buttonSerieEquals.setText("=");
        buttonSerieEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSerieEqualsActionPerformed(evt);
            }
        });

        buttonVolume.setMnemonic('V');
        buttonVolume.setText("v.");
        buttonVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolumeActionPerformed(evt);
            }
        });

        buttonTitle.setMnemonic('T');
        buttonTitle.setText("Title");
        buttonTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTitleActionPerformed(evt);
            }
        });

        buttonTitleAdd.setText("+");
        buttonTitleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTitleAddActionPerformed(evt);
            }
        });

        buttonTitleEquals.setText("=");
        buttonTitleEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTitleEqualsActionPerformed(evt);
            }
        });

        butttonEdition.setText("e.");
        butttonEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butttonEditionActionPerformed(evt);
            }
        });

        buttonSubtitle.setMnemonic('B');
        buttonSubtitle.setText("Subtitle");
        buttonSubtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubtitleActionPerformed(evt);
            }
        });

        buttonSubtitleAdd.setText("+");
        buttonSubtitleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubtitleAddActionPerformed(evt);
            }
        });

        buttonSubtitleEquals.setText("=");
        buttonSubtitleEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubtitleEqualsActionPerformed(evt);
            }
        });

        buttonAuthor.setMnemonic('A');
        buttonAuthor.setText("Author");
        buttonAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAuthorActionPerformed(evt);
            }
        });

        buttonAuthorAdd.setText("+");
        buttonAuthorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAuthorAddActionPerformed(evt);
            }
        });

        buttonAuthorEquals.setText("=");
        buttonAuthorEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAuthorEqualsActionPerformed(evt);
            }
        });

        buttonSuggest.setMnemonic('S');
        buttonSuggest.setText("Suggest");
        buttonSuggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuggestActionPerformed(evt);
            }
        });

        checkReCase.setText("ReCase");

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

        buttonRemove.setMnemonic('M');
        buttonRemove.setText("Remove");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelActionsLayout = new javax.swing.GroupLayout(panelActions);
        panelActions.setLayout(panelActionsLayout);
        panelActionsLayout.setHorizontalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActionsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelActionsLayout.createSequentialGroup()
                        .addComponent(buttonPrior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLast)
                        .addGap(18, 18, 18)
                        .addComponent(buttonOCR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelActionsLayout.createSequentialGroup()
                        .addComponent(buttonSerie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSerieAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSerieEquals)
                        .addGap(12, 12, 12)
                        .addComponent(buttonVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTitleAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTitleEquals)
                        .addGap(12, 12, 12)
                        .addComponent(butttonEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buttonSubtitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSubtitleAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSubtitleEquals)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAuthorAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAuthorEquals))
                    .addGroup(panelActionsLayout.createSequentialGroup()
                        .addComponent(buttonSuggest, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkReCase)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCatalog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonJump)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelActionsLayout.setVerticalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActionsLayout.createSequentialGroup()
                        .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonPrior)
                                .addComponent(buttonNext)
                                .addComponent(buttonFirst)
                                .addComponent(buttonLast)
                                .addComponent(buttonOCR))
                            .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonTitle)
                                .addComponent(buttonSubtitle)
                                .addComponent(buttonAuthor)
                                .addComponent(buttonAuthorAdd)
                                .addComponent(buttonSubtitleAdd)
                                .addComponent(buttonTitleAdd)
                                .addComponent(buttonTitleEquals)
                                .addComponent(buttonSubtitleEquals)
                                .addComponent(buttonAuthorEquals)
                                .addComponent(buttonVolume)
                                .addComponent(buttonSerie)
                                .addComponent(buttonSerieAdd)
                                .addComponent(buttonSerieEquals)
                                .addComponent(butttonEdition)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonJump)
                            .addComponent(buttonCatalog)
                            .addComponent(buttonRemove)
                            .addComponent(checkReCase)
                            .addComponent(labelStatus)))
                    .addComponent(buttonSuggest, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        buttonOpen.setMnemonic('O');
        buttonOpen.setText("Open");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonNameSearch.setMnemonic('H');
        buttonNameSearch.setText("Search");
        buttonNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNameSearchActionPerformed(evt);
            }
        });

        buttonNameCopy.setMnemonic('Y');
        buttonNameCopy.setText("Copy");
        buttonNameCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNameCopyActionPerformed(evt);
            }
        });

        buttonReClazz.setMnemonic('R');
        buttonReClazz.setText("Re");
        buttonReClazz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReClazzActionPerformed(evt);
            }
        });

        buttonSwitchCase.setMnemonic('5');
        buttonSwitchCase.setText("%");
        buttonSwitchCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSwitchCaseActionPerformed(evt);
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
                    .addComponent(panelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonReClazz, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonClazz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOpen))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(panelNaming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSwitchCase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNameCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClazz)
                        .addComponent(buttonReClazz))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonNew)
                        .addComponent(buttonOpen)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelNaming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonNameSearch)
                        .addComponent(buttonNameCopy)
                        .addComponent(buttonSwitchCase)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelViewer, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAuthorActionPerformed
        makeAuthor(false, false);
    }//GEN-LAST:event_buttonAuthorActionPerformed

    private void makeAuthor(boolean add, boolean equals) {
        var cleaned = cleanAuthor(equals ? textPage.getSelectedText()
                : composeSelected(editAuthor, add ? " + " : " "));
        if (checkReCase.isSelected()) {
            var result = "";
            var parts = cleaned.toLowerCase().split("\\s+");
            for (int i = 0; i < parts.length; i++) {
                if (i > 0) {
                    result += " ";
                }
                if (parts[i].length() > 2 || parts[i].contains(".")) {
                    parts[i] = StringUtils.capitalize(parts[i]);
                }
                result += parts[i];
            }
            cleaned = result;
        }
        editAuthor.setText(cleaned);
        textPage.requestFocus();
    }

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
            loadDocument();
            if (pageIndex < document.getNumberOfPages() - 1) {
                pageIndex++;
                loadPage();
                textPage.requestFocus();
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNextActionPerformed

    private String cleanName(String name) {
        return name.trim()
                .replace("?", "")
                .replace("*", "")
                .replace("<", "")
                .replace(">", "")
                .replace("|", "")
                .replace(":", "~")
                .replace("\"", "`")
                .replaceAll("\\s*\\\\\\s*", "-")
                .replaceAll("\\s*/\\s*", "-")
                .replaceAll("\\-+", "-")
                .replaceAll("\\s+", " ");
    }

    private String cleanTitles(String titles) {
        return cleanName(titles);
    }

    private String cleanAuthor(String author) {
        return cleanName(author);
    }

    private String composeSelected(JTextField withField, String adder) {
        var result = withField.getText().trim();
        var selected = textPage.getSelectedText().trim();
        if (!selected.isBlank()) {
            result = result + adder + selected;
        }
        return result.trim();
    }

    private void buttonTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTitleActionPerformed
        makeTitle(false, false);
    }//GEN-LAST:event_buttonTitleActionPerformed

    private void makeTitle(boolean adds, boolean equals) {
        var cleaned = cleanTitles(equals ? textPage.getSelectedText().trim()
                : composeSelected(editTitle, adds ? " + " : " "));
        if (checkReCase.isSelected()) {
            cleaned = StringUtils.capitalize(cleaned.toLowerCase());
        }
        editTitle.setText(cleaned);
        textPage.requestFocus();
    }

    private void buttonSubtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubtitleActionPerformed
        makeSubtitle(false, false);
    }//GEN-LAST:event_buttonSubtitleActionPerformed

    private void makeSubtitle(boolean adds, boolean equals) {
        var cleaned = cleanTitles(equals ? textPage.getSelectedText().trim()
                : composeSelected(editSubtitle, adds ? " + " : " "));
        if (checkReCase.isSelected()) {
            cleaned = cleaned.toLowerCase();
        }
        editSubtitle.setText(cleaned);
        textPage.requestFocus();
    }

    private void buttonCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCatalogActionPerformed
        try {
            File destinyFolder = getSelectedPath();
            Files.createDirectories(destinyFolder.toPath());
            String destinyName = getNomination();
            destinyName += "." + FilenameUtils.getExtension(files.get(fileIndex).getName());
            final var originFile = files.get(fileIndex);
            final var destinyFile = new File(destinyFolder, destinyName);
            if (destinyFile.exists()) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            WizSwing.open(destinyFile);
                        } catch (Exception e) {
                            WizSwing.showError(e);
                        }
                    }
                }.start();
                throw new Exception("Destiny file already exists.");
            }
            closeDocument();
            lastSelectedPath = destinyFolder;
            doJump();
            textPage.requestFocus();
            new Thread() {
                @Override
                public void run() {
                    try {
                        Files.move(originFile.toPath(), destinyFile.toPath());
                        String verifier = getVerifier();
                        desk.getBase().putFile(destinyFile, verifier);
                        desk.getBase().arkhDocs.addToVerify(destinyFile);
                    } catch (Exception e) {
                        WizSwing.showError(e);
                    }
                }

                private String getVerifier() throws IOException {
                    try (var input = new FileInputStream(destinyFile)) {
                        return DigestUtils.sha256Hex(input);
                    }
                }
            }.start();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonCatalogActionPerformed

    private String getNomination() throws Exception {
        var destinyName = editTitle.getText().trim();
        if (destinyName.isBlank()) {
            throw new Exception("You must input a title.");
        }
        if (editSerie.getText().isBlank() && !editVolume.getText().isBlank()) {
            throw new Exception("You must input a serie.");
        }
        if (!editSerie.getText().isBlank()) {
            destinyName = editSerie.getText().trim()
                    + (editVolume.getText().isBlank() ? "" : " [ " + editVolume.getText().trim() + " v. ] ")
                    + " ~ " + destinyName;
        }
        if (!editEdition.getText().isBlank()) {
            destinyName = destinyName + " [ " + editEdition.getText().trim() + " e. ] ";
        }
        if (!editSubtitle.getText().isBlank()) {
            destinyName = destinyName + " - " + editSubtitle.getText().trim();
        }
        if (!editAuthor.getText().isBlank()) {
            destinyName = destinyName + " - " + editAuthor.getText().trim();
        } else {
            switch ((String) comboRaiz.getSelectedItem()) {
                case "Auf Deutsch" ->
                    destinyName += " - Undefiniert";
                case "Em Español" ->
                    destinyName += " - Indefinido";
                case "Em Português" ->
                    destinyName += " - Indefinido";
                case "En Français" ->
                    destinyName += " - Indéfini";
                case "In English" ->
                    destinyName += " - Undefined";
                default ->
                    throw new Exception("You must select the language.");
            }
        }
        return destinyName;
    }

    private void setSelectedPath(File path) throws Exception {
        if (path == null) {
            comboRaiz.setSelectedItem("");
            return;
        }
        String clazzPath = getClazzPath(path);
        loadRoot();
        var parts = clazzPath.split("\\" + File.separator);
        for (int i = 0; i < parts.length; i++) {
            combosPath.get(i).setSelectedItem(parts[i]);
            comboPathActionPerformed(new ActionEvent(combosPath.get(i), 0, "SELECTED"));
        }
    }

    private String getClazzPath(File path) throws Exception {
        var selectedPath = path.getAbsolutePath();
        var rootPath = desk.getBase().root.getAbsolutePath();
        if (!selectedPath.startsWith(rootPath)) {
            throw new Exception("The selected path must be inside the root base.");
        }
        selectedPath = selectedPath.substring(rootPath.length() + 1);
        return selectedPath;
    }

    private File makeFromClazzPath(String clazzPath) throws Exception {
        return new File(desk.getBase().root, clazzPath);
    }

    private File getSelectedPath() {
        return getSelectedPath(combosPath.size() - 1);
    }

    private File getSelectedPath(int untilIndex) {
        var result = desk.getBase().root;
        for (int i = 0; i <= untilIndex; i++) {
            var part = (String) combosPath.get(i).getSelectedItem();
            if (part == null || part.isBlank()) {
                break;
            }
            result = new File(result, part);
        }
        return result;
    }

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
        doneAutoClazz = false;
    }

    private void doJump() throws Exception {
        if (fileIndex < files.size() - 1) {
            closeDocument();
            fileIndex++;
            pageIndex = 0;
            loadPage();
            editSerie.setText("");
            editVolume.setText("");
            editTitle.setText("");
            editSubtitle.setText("");
            editAuthor.setText("");
            setSelectedPath(null);
        } else {
            WizSwing.close(this);
        }
    }

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        try {
            var newClazz = WizSwing.showInput("New Clazz");
            if (newClazz != null && !newClazz.isBlank()) {
                var selectPath = getSelectedPath();
                var newPath = new File(selectPath, newClazz);
                Files.createDirectories(newPath.toPath());
                setSelectedPath(newPath);
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonClazzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClazzActionPerformed
        if (!buttonClazz.isEnabled()) {
            return;
        }
        final var initialDocument = document;
        buttonClazz.setEnabled(false);

        new Thread() {
            @Override
            public void run() {
                try {
                    List<String> suggestions = new ArrayList<>();
                    var stripper = new PDFTextStripper();
                    stripper.setStartPage(1);
                    stripper.setEndPage(initialDocument.getNumberOfPages());
                    var source = stripper.getText(initialDocument);
                    var sourceWords = WizChars.getWords(source);
                    if (shouldStop()) {
                        return;
                    }
                    var allDockData = desk.getBase().arkhDocs.getAllDockData();
                    var scoredDockData = new ArrayList<Pair<Integer, ArkhDockData>>();
                    for (var dockData : allDockData) {
                        var dockDataWords = dockData.getAllWords();
                        dockDataWords.retainAll(sourceWords);
                        scoredDockData.add(Pair.of(dockDataWords.size(), dockData));
                        if (shouldStop()) {
                            return;
                        }
                    }
                    scoredDockData.sort((e1, e2) -> e2.getKey().compareTo(e1.getLeft()));
                    for (var scored : scoredDockData) {
                        suggestions.add(getClazzPath((scored.getValue().getFolder())));
                    }
                    if (shouldStop()) {
                        return;
                    }
                    SwingUtilities.invokeLater(() -> {
                        new CatalogClazz(suggestions, (selected) -> {
                            try {
                                setSelectedPath(makeFromClazzPath(selected));
                                combosPath.get(combosPath.size() - 1).requestFocus();
                            } catch (Exception ex) {
                                WizSwing.showError(ex);
                            }
                        }).setVisible(true);
                    });
                } catch (Exception ex) {
                    WizSwing.showError(ex);
                } finally {
                    SwingUtilities.invokeLater(() -> buttonClazz.setEnabled(true));
                }
            }

            public boolean shouldStop() {
                return (initialDocument != document);
            }
        }.start();
    }//GEN-LAST:event_buttonClazzActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        try {
            File destinyFolder = getSelectedPath();
            WizSwing.open(destinyFolder);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void buttonSuggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuggestActionPerformed
        textPage.requestFocus();
    }//GEN-LAST:event_buttonSuggestActionPerformed

    private void buttonTitleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTitleAddActionPerformed
        makeTitle(true, false);
    }//GEN-LAST:event_buttonTitleAddActionPerformed

    private void buttonSubtitleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubtitleAddActionPerformed
        makeSubtitle(true, false);
    }//GEN-LAST:event_buttonSubtitleAddActionPerformed

    private void buttonAuthorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAuthorAddActionPerformed
        makeAuthor(true, false);
    }//GEN-LAST:event_buttonAuthorAddActionPerformed

    private void buttonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFirstActionPerformed
        try {
            if (pageIndex != 0) {
                pageIndex = 0;
                loadPage();
            }
            textPage.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonFirstActionPerformed

    private void buttonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLastActionPerformed
        try {
            if (pageIndex != document.getNumberOfPages() - 1) {
                pageIndex = document.getNumberOfPages() - 1;
                loadPage();
                textPage.requestFocus();
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonLastActionPerformed

    private void comboPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPathActionPerformed
        if (combosPath == null) {
            return;
        }
        int index = combosPath.indexOf(evt.getSource());
        for (int i = combosPath.size() - 1; i > index; i--) {
            panelDestiny.remove(combosPath.get(i));
            combosPath.remove(i);
        }
        var untilSelected = getSelectedPath(index - 1);
        var actualSelected = (String) combosPath.get(index).getSelectedItem();
        if (actualSelected == null || actualSelected.isBlank()) {
            SwingUtilities.updateComponentTreeUI(panelDestiny);
            return;
        }
        var selected = new File(untilSelected, actualSelected);
        var hasSubFolders = false;
        if (selected.isDirectory()) {
            for (var inside : selected.listFiles()) {
                if (inside.isDirectory()) {
                    hasSubFolders = true;
                    break;
                }
            }
        }
        if (hasSubFolders) {
            var subCombo = new JComboBox<>();
            subCombo.setFont(WizSwing.fontMonospaced());
            subCombo.addItem("");
            for (var inside : selected.listFiles()) {
                if (inside.isDirectory()) {
                    subCombo.addItem(inside.getName());
                }
            }
            subCombo.addActionListener((ActionEvent e) -> comboPathActionPerformed(e));
            combosPath.add(subCombo);
            panelDestiny.add(subCombo);
        }
        SwingUtilities.updateComponentTreeUI(panelDestiny);
    }//GEN-LAST:event_comboPathActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        try {
            var file = files.get(fileIndex);
            doJump();
            textPage.requestFocus();
            file.delete();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonOCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOCRActionPerformed
        try {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage imageRendered = pdfRenderer.renderImageWithDPI(pageIndex, 300, ImageType.RGB);
            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Tesseract\\tessdata");
            switch ((String) comboRaiz.getSelectedItem()) {
                case "Auf Deutsch" ->
                    tesseract.setLanguage("deu");
                case "Em Español" ->
                    tesseract.setLanguage("spa");
                case "Em Português" ->
                    tesseract.setLanguage("por");
                case "En Français" ->
                    tesseract.setLanguage("fra");
                case "In English" ->
                    tesseract.setLanguage("eng");
                default ->
                    throw new Exception("You must select the language.");
            }
            String result = tesseract.doOCR(imageRendered);
            textPage.setText(result);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonOCRActionPerformed

    private void buttonTitleEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTitleEqualsActionPerformed
        makeTitle(false, true);
    }//GEN-LAST:event_buttonTitleEqualsActionPerformed

    private void buttonSubtitleEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubtitleEqualsActionPerformed
        makeSubtitle(false, true);
    }//GEN-LAST:event_buttonSubtitleEqualsActionPerformed

    private void buttonAuthorEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAuthorEqualsActionPerformed
        makeAuthor(false, true);
    }//GEN-LAST:event_buttonAuthorEqualsActionPerformed

    private void buttonNameCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNameCopyActionPerformed
        try {
            WizSwing.putStringOnClipboard(getNomination());
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNameCopyActionPerformed

    private void buttonNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNameSearchActionPerformed
        try {
            var search = editTitle.getText() + " " + editSubtitle.getText() + " " + editAuthor.getText();
            var query = search.trim()
                    .replace(" - ", "+")
                    .replaceAll("\\s+", "+")
                    .toLowerCase();
            var address = "https://www.google.com/search?q=" + query;
            WizSwing.navigate(address);
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNameSearchActionPerformed

    private void buttonReClazzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReClazzActionPerformed
        try {
            setSelectedPath(lastSelectedPath);
            combosPath.get(combosPath.size() - 1).requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonReClazzActionPerformed

    private void buttonSwitchCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSwitchCaseActionPerformed
        if (lastSelectedField != null) {
            var start = lastSelectedField.getSelectionStart();
            var end = lastSelectedField.getSelectionEnd();
            var selected = lastSelectedField.getSelectedText();
            if (start > -1 && end > -1 && !selected.isEmpty()) {
                var switched = WizChars.switchCase(selected);
                var complete = lastSelectedField.getText();
                lastSelectedField.setText(
                        complete.substring(0, start)
                        + switched
                        + complete.substring(end)
                );
                lastSelectedField.setSelectionStart(start);
                lastSelectedField.setSelectionEnd(end);
            }
            lastSelectedField.requestFocus();
        }
    }//GEN-LAST:event_buttonSwitchCaseActionPerformed

    private void editTitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editTitleFocusGained
        lastSelectedField = editTitle;
    }//GEN-LAST:event_editTitleFocusGained

    private void editSubtitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editSubtitleFocusGained
        lastSelectedField = editSubtitle;
    }//GEN-LAST:event_editSubtitleFocusGained

    private void editAuthorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editAuthorFocusGained
        lastSelectedField = editAuthor;
    }//GEN-LAST:event_editAuthorFocusGained

    private void buttonVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolumeActionPerformed
        editVolume.setText(textPage.getText().trim().toUpperCase());
        textPage.requestFocus();
    }//GEN-LAST:event_buttonVolumeActionPerformed

    private void buttonSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSerieActionPerformed
        makeSerie(false, false);
    }//GEN-LAST:event_buttonSerieActionPerformed

    private void buttonSerieAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSerieAddActionPerformed
        makeSerie(true, false);
    }//GEN-LAST:event_buttonSerieAddActionPerformed

    private void buttonSerieEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSerieEqualsActionPerformed
        makeSerie(false, true);
    }//GEN-LAST:event_buttonSerieEqualsActionPerformed

    private void butttonEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butttonEditionActionPerformed
        editVolume.setText(textPage.getText().trim().toUpperCase());
        textPage.requestFocus();
    }//GEN-LAST:event_butttonEditionActionPerformed

    private void makeSerie(boolean adds, boolean equals) {
        var cleaned = cleanTitles(equals ? textPage.getSelectedText().trim()
                : composeSelected(editSerie, adds ? " + " : " "));
        if (checkReCase.isSelected()) {
            cleaned = StringUtils.capitalize(cleaned.toLowerCase());
        }
        editSerie.setText(cleaned);
        textPage.requestFocus();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAuthor;
    private javax.swing.JButton buttonAuthorAdd;
    private javax.swing.JButton buttonAuthorEquals;
    private javax.swing.JButton buttonCatalog;
    private javax.swing.JButton buttonClazz;
    private javax.swing.JButton buttonFirst;
    private javax.swing.JButton buttonJump;
    private javax.swing.JButton buttonLast;
    private javax.swing.JButton buttonNameCopy;
    private javax.swing.JButton buttonNameSearch;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonOCR;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonPrior;
    private javax.swing.JButton buttonReClazz;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonSerie;
    private javax.swing.JButton buttonSerieAdd;
    private javax.swing.JButton buttonSerieEquals;
    private javax.swing.JButton buttonSubtitle;
    private javax.swing.JButton buttonSubtitleAdd;
    private javax.swing.JButton buttonSubtitleEquals;
    private javax.swing.JButton buttonSuggest;
    private javax.swing.JButton buttonSwitchCase;
    private javax.swing.JButton buttonTitle;
    private javax.swing.JButton buttonTitleAdd;
    private javax.swing.JButton buttonTitleEquals;
    private javax.swing.JButton buttonVolume;
    private javax.swing.JButton butttonEdition;
    private javax.swing.JCheckBox checkReCase;
    private javax.swing.JComboBox<String> comboRaiz;
    private javax.swing.JTextField editAuthor;
    private javax.swing.JTextField editEdition;
    private javax.swing.JTextField editSerie;
    private javax.swing.JTextField editSubtitle;
    private javax.swing.JTextField editTitle;
    private javax.swing.JTextField editVolume;
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
