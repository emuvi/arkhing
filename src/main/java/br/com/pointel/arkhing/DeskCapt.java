package br.com.pointel.arkhing;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author emuvi
 */
public class DeskCapt extends javax.swing.JPanel {

    private final Desk desk;

    private Rectangle source;

    public DeskCapt(Desk desk) {
        this.desk = desk;
        initComponents();
        for (GraphicsDevice device : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
            comboDisplays.addItem(new Display(device));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboDisplays = new javax.swing.JComboBox<>();
        buttonView = new javax.swing.JButton();
        editDestiny = new javax.swing.JTextField();
        buttonSelect = new javax.swing.JButton();
        editSource = new javax.swing.JTextField();
        buttonStart = new javax.swing.JButton();
        editPages = new javax.swing.JSpinner();
        labelPages = new javax.swing.JLabel();
        labelMethod = new javax.swing.JLabel();
        comboMethod = new javax.swing.JComboBox<>();
        buttonOpen = new javax.swing.JButton();
        editWait = new javax.swing.JSpinner();
        labelWait = new javax.swing.JLabel();
        buttonNew = new javax.swing.JButton();
        buttonMakeDocuments = new javax.swing.JButton();
        checkAutoMakeDocuments = new javax.swing.JCheckBox();
        labelEstrategia = new javax.swing.JLabel();
        editEstrategia = new javax.swing.JTextField();
        buttonEstrategiaStart = new javax.swing.JButton();
        buttonEstrategiaStop = new javax.swing.JButton();
        buttonEstrategiaLogin = new javax.swing.JButton();
        buttonNextHeader = new javax.swing.JButton();
        editHeader = new javax.swing.JSpinner();
        buttonGetLessonMaterials = new javax.swing.JButton();
        buttonEstrategiaClean = new javax.swing.JButton();
        editItem = new javax.swing.JSpinner();
        buttonNextItem = new javax.swing.JButton();
        buttonOpenDownloads = new javax.swing.JButton();
        buttonMakeDownload = new javax.swing.JButton();
        buttonHeaderGrouped = new javax.swing.JButton();
        buttonItemGrouped = new javax.swing.JButton();
        buttonCopyTitle = new javax.swing.JButton();
        buttonTickView = new javax.swing.JButton();
        buttonAutoItems = new javax.swing.JButton();
        editAutoItem = new javax.swing.JSpinner();
        checkWatch = new javax.swing.JCheckBox();

        buttonView.setText("Source");
        buttonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewActionPerformed(evt);
            }
        });

        editDestiny.setEditable(false);
        editDestiny.setText(WizProps.get("DESK_CAPT_DESTINY", ""));

        buttonSelect.setText("Select");
        buttonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectActionPerformed(evt);
            }
        });

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        editPages.setValue(50);

        labelPages.setText("Pages");

        labelMethod.setText("Method");

        comboMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Press Right", "Press Down", "Drag Mouse", "" }));

        buttonOpen.setText("Open");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        editWait.setModel(new javax.swing.SpinnerNumberModel(2.0d, null, null, 0.2d));

        labelWait.setText("Wait");

        buttonNew.setText("New");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        buttonMakeDocuments.setText("Make Documents");
        buttonMakeDocuments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMakeDocumentsActionPerformed(evt);
            }
        });

        checkAutoMakeDocuments.setSelected(true);
        checkAutoMakeDocuments.setText("Auto");

        labelEstrategia.setText("Estratégia");

        editEstrategia.setText("https://www.estrategiaconcursos.com.br/app/dashboard/cursos");

        buttonEstrategiaStart.setText("Start");
        buttonEstrategiaStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEstrategiaStartActionPerformed(evt);
            }
        });

        buttonEstrategiaStop.setText("Stop");
        buttonEstrategiaStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEstrategiaStopActionPerformed(evt);
            }
        });

        buttonEstrategiaLogin.setText("Login");
        buttonEstrategiaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEstrategiaLoginActionPerformed(evt);
            }
        });

        buttonNextHeader.setText("Next Header");
        buttonNextHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextHeaderActionPerformed(evt);
            }
        });

        editHeader.setModel(new javax.swing.SpinnerNumberModel(-1, null, null, 1));

        buttonGetLessonMaterials.setText("Get Lesson Materials");
        buttonGetLessonMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGetLessonMaterialsActionPerformed(evt);
            }
        });

        buttonEstrategiaClean.setText("Clean");
        buttonEstrategiaClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEstrategiaCleanActionPerformed(evt);
            }
        });

        editItem.setModel(new javax.swing.SpinnerNumberModel(-1, null, null, 1));

        buttonNextItem.setText("Next Item");
        buttonNextItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextItemActionPerformed(evt);
            }
        });

        buttonOpenDownloads.setText("Open Downloads");
        buttonOpenDownloads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenDownloadsActionPerformed(evt);
            }
        });

        buttonMakeDownload.setText("Make Download");
        buttonMakeDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMakeDownloadActionPerformed(evt);
            }
        });

        buttonHeaderGrouped.setText("Run Header Line");
        buttonHeaderGrouped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHeaderGroupedActionPerformed(evt);
            }
        });

        buttonItemGrouped.setText("Run Item Line");
        buttonItemGrouped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemGroupedActionPerformed(evt);
            }
        });

        buttonCopyTitle.setText("Copy Title");
        buttonCopyTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCopyTitleActionPerformed(evt);
            }
        });

        buttonTickView.setText("Tick View");
        buttonTickView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTickViewActionPerformed(evt);
            }
        });

        buttonAutoItems.setText("Auto Items");
        buttonAutoItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAutoItemsActionPerformed(evt);
            }
        });

        editAutoItem.setModel(new javax.swing.SpinnerNumberModel(90, null, null, 1));

        checkWatch.setSelected(true);
        checkWatch.setText("Check Watch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboDisplays, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editSource))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editDestiny)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOpen))
                    .addComponent(editEstrategia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEstrategia)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonEstrategiaStart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEstrategiaStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEstrategiaLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEstrategiaClean)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNextHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGetLessonMaterials)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOpenDownloads)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonHeaderGrouped))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNextItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonMakeDownload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCopyTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTickView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonItemGrouped))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMethod)
                                    .addComponent(comboMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelWait)
                                    .addComponent(editWait, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelPages)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(editPages, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(checkAutoMakeDocuments)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonMakeDocuments))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(checkWatch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editAutoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAutoItems)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDisplays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonView)
                    .addComponent(editSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSelect)
                    .addComponent(editDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOpen)
                    .addComponent(buttonNew))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPages)
                    .addComponent(labelMethod)
                    .addComponent(labelWait))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStart)
                    .addComponent(editPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editWait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMakeDocuments)
                    .addComponent(checkAutoMakeDocuments))
                .addGap(18, 18, 18)
                .addComponent(labelEstrategia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEstrategiaStart)
                    .addComponent(buttonEstrategiaStop)
                    .addComponent(buttonEstrategiaLogin)
                    .addComponent(buttonEstrategiaClean))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNextHeader)
                    .addComponent(buttonOpenDownloads)
                    .addComponent(buttonHeaderGrouped)
                    .addComponent(buttonGetLessonMaterials))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNextItem)
                    .addComponent(buttonMakeDownload)
                    .addComponent(buttonItemGrouped)
                    .addComponent(buttonCopyTitle)
                    .addComponent(buttonTickView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAutoItems)
                    .addComponent(editAutoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkWatch))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewActionPerformed
        var selected = (Display) comboDisplays.getSelectedItem();
        if (selected != null) {
            try {
                new ViewDisplay(selected, source, (newSource) -> {
                    source = newSource;
                    editSource.setText(source.toString());
                }).setVisible(true);
            } catch (Exception e) {
                WizSwing.showError(e);
            }
        }
    }//GEN-LAST:event_buttonViewActionPerformed

    private void buttonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectActionPerformed
        try {
            var selected = WizSwing.selectFolder(new File(editDestiny.getText()));
            if (selected != null) {
                editDestiny.setText(selected.getAbsolutePath());
                WizProps.set("DESK_CAPT_DESTINY", editDestiny.getText());
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonSelectActionPerformed

    private volatile boolean making = false;

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        if (!making && !"Start".equals(buttonStart.getText())) {
            WizSwing.showError(new Throwable("Wait the process to stop."));
            return;
        }
        if (making) {
            making = false;
        } else {
            making = true;
            buttonStart.setText("Stop");
            var totalPages = (Integer) editPages.getValue();
            var waitTime = Math.round((Double) editWait.getValue() * 1000);
            var captureSource = source;
            var clickPoint = new Point(source.x + 10, source.y + 10);
            var destinyFolder = new File(editDestiny.getText());
            var dragMouse = "Drag Mouse".equals(comboMethod.getSelectedItem());
            var pressDown = "Press Down".equals(comboMethod.getSelectedItem());
            new Thread() {
                BufferedImage beforeCapture = null;

                private void save(BufferedImage capture) throws Exception {
                    var indexPage = 1;
                    var pageNameSuffix = StringUtils.leftPad(String.valueOf(indexPage), 3, '0');
                    var filePage = new File(destinyFolder, "page-" + pageNameSuffix + ".png");
                    while (filePage.exists()) {
                        indexPage++;
                        pageNameSuffix = StringUtils.leftPad(String.valueOf(indexPage), 3, '0');
                        filePage = new File(destinyFolder, "page-" + pageNameSuffix + ".png");
                    }
                    ImageIO.write(capture, "PNG", filePage);
                }

                @Override
                public void run() {
                    try {
                        var robot = new Robot();
                        var indexMaking = 0;
                        while (making && indexMaking < totalPages) {
                            indexMaking++;
                            BufferedImage thisCapture = robot.createScreenCapture(captureSource);
                            if (beforeCapture == null
                                    || WizImage.isSame(beforeCapture, thisCapture)) {
                                save(thisCapture);
                            } else {
                                save(beforeCapture);
                                save(thisCapture);
                            }
                            robot.mouseMove(clickPoint.x, clickPoint.y);
                            robot.delay(300);
                            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(300);
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(500);
                            if (dragMouse) {
                                var posX = captureSource.x + captureSource.width - 10;
                                var posY = captureSource.y + captureSource.height - 10;
                                var untilY = captureSource.y + 45;
                                robot.mouseMove(posX, posY);
                                robot.delay(300);
                                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                                robot.delay(300);
                                while (posY > untilY) {
                                    posY -= 30;
                                    robot.mouseMove(posX, posY);
                                    robot.delay(30);
                                }
                                robot.delay(300);
                                beforeCapture = robot.createScreenCapture(captureSource);
                                robot.delay(300);
                                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                                robot.delay(300);
                            } else {
                                if (pressDown) {
                                    robot.keyPress(KeyEvent.VK_DOWN);
                                    robot.delay(300);
                                    robot.keyRelease(KeyEvent.VK_DOWN);
                                    robot.delay(300);
                                } else {
                                    robot.keyPress(KeyEvent.VK_RIGHT);
                                    robot.delay(300);
                                    robot.keyRelease(KeyEvent.VK_RIGHT);
                                    robot.delay(300);
                                }
                            }
                            SwingUtilities.invokeLater(() -> buttonStart.requestFocus());
                            SwingUtilities.invokeLater(() -> buttonStart.requestFocusInWindow());
                            robot.delay((int) waitTime);
                        }

                    } catch (Exception e) {
                        WizSwing.showError(e);
                    } finally {
                        making = false;
                        SwingUtilities.invokeLater(() -> {
                            buttonStart.setText("Start");
                            if (checkAutoMakeDocuments.isSelected()) {
                                makeDocuments(destinyFolder);
                            }
                            WizSwing.showInfo("Done Capture");
                        });
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        try {
            WizSwing.open(new File(editDestiny.getText()));
        } catch (Exception ex) {
            WizSwing.showError(ex);
        }
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        try {
            var selected = new File(editDestiny.getText());
            var directory = selected.getParentFile();
            var bigger = 0;
            for (var inside : directory.listFiles()) {
                if (inside.isDirectory()) {
                    bigger = Math.max(bigger, getCaptFolderIndex(inside.getName()));
                }
            }
            var name = "Capt-" + StringUtils.leftPad(++bigger + "", 2, '0');
            var destiny = new File(directory, name);
            Files.createDirectories(destiny.toPath());
            editDestiny.setText(destiny.getAbsolutePath());
        } catch (Exception e) {
            WizSwing.showError(e);
        }

    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonMakeDocumentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMakeDocumentsActionPerformed
        var selected = WizSwing.selectFolder(new File(editDestiny.getText()));
        if (selected != null) {
            makeDocuments(selected);
        }
    }//GEN-LAST:event_buttonMakeDocumentsActionPerformed

    private Estrategia estrategia = null;

    private void buttonEstrategiaStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEstrategiaStartActionPerformed
        try {
            if (estrategia != null) {
                estrategia.stop();
                estrategia = null;
            }
            estrategia = new Estrategia(editEstrategia.getText());
            estrategia.start();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonEstrategiaStartActionPerformed

    private void buttonEstrategiaStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEstrategiaStopActionPerformed
        try {
            if (estrategia != null) {
                estrategia.stop();
                estrategia = null;
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonEstrategiaStopActionPerformed

    private void buttonEstrategiaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEstrategiaLoginActionPerformed
        try {
            estrategia.login();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonEstrategiaLoginActionPerformed

    private void buttonNextHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextHeaderActionPerformed
        try {
            actNextHeader();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNextHeaderActionPerformed

    private void actNextHeader() {
        editHeader.setValue(((int) editHeader.getValue()) + 1);
        estrategia.openHeader((int) editHeader.getValue());
        editItem.setValue(-1);
    }

    private void buttonGetLessonMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGetLessonMaterialsActionPerformed
        try {
            actGetLessonMaterials();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonGetLessonMaterialsActionPerformed

    private void actGetLessonMaterials() {
        estrategia.getLessonMaterials((int) editHeader.getValue());
    }

    private void buttonEstrategiaCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEstrategiaCleanActionPerformed
        try {
            estrategia.clean();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonEstrategiaCleanActionPerformed

    private void buttonNextItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextItemActionPerformed
        try {
            actNextItem();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonNextItemActionPerformed

    private void actNextItem() {
        editItem.setValue(((int) editItem.getValue()) + 1);
        estrategia.openItem((int) editHeader.getValue(), (int) editItem.getValue());
    }

    private void buttonOpenDownloadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenDownloadsActionPerformed
        try {
            actOpenDownloads();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonOpenDownloadsActionPerformed

    private void actOpenDownloads() {
        estrategia.openDownloads((int) editHeader.getValue());
    }

    private void buttonMakeDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMakeDownloadActionPerformed
        try {
            actMakeDownloads();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonMakeDownloadActionPerformed

    private void actMakeDownloads() {
        estrategia.makeDownloads((int) editHeader.getValue());
    }

    private void buttonHeaderGroupedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHeaderGroupedActionPerformed
        try {
            runHeaderLine();
            WizSwing.showInfo("Done!");
            buttonItemGrouped.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonHeaderGroupedActionPerformed

    private void runHeaderLine() {
        actNextHeader();
        WizBase.sleep(1200);
        actGetLessonMaterials();
        WizBase.sleep(1200);
        actOpenDownloads();
    }

    private void buttonItemGroupedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonItemGroupedActionPerformed
        try {
            runItemLine();
            WizSwing.showInfo("Done!");
            buttonItemGrouped.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonItemGroupedActionPerformed

    private void runItemLine() {
        actNextItem();
        WizBase.sleep(1200);
        actMakeDownloads();
        WizBase.sleep(1200);
        actCopyTitle();
        WizBase.sleep(1200);
        actTickView();
    }

    private void buttonCopyTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopyTitleActionPerformed
        try {
            actCopyTitle();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonCopyTitleActionPerformed

    private void buttonTickViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTickViewActionPerformed
        try {
            actTickView();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonTickViewActionPerformed

    private void buttonAutoItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAutoItemsActionPerformed
        try {
            while (((int) editItem.getValue()) <= ((int) editAutoItem.getValue())) {
                runItemLine();
                WizBase.sleep(2700);
                while (checkWatch.isSelected() && desk.deskPack.hasAnyInWatchFolder()) {
                    WizBase.sleep(2700);
                }
            }
            WizSwing.showInfo("Done!");
            buttonItemGrouped.requestFocus();
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonAutoItemsActionPerformed

    private void actCopyTitle() {
        estrategia.copyTitle((int) editHeader.getValue(), (int) editItem.getValue());
    }

    private void actTickView() {
        estrategia.tickView((int) editHeader.getValue());
    }

    private int getCaptFolderIndex(String folderName) {
        if (folderName.startsWith("Capt-")) {
            try {
                return Integer.parseInt(folderName.substring(5));
            } catch (Exception e) {
            }
        }
        return 0;
    }

    private void captureAllScreens() {
        try {
            var index = 1;
            for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
                Rectangle screenRect = gd.getDefaultConfiguration().getBounds();
                BufferedImage capture = new Robot().createScreenCapture(screenRect);
                ImageIO.write(capture, "PNG", new File("screen-" + index + ".png"));
                index++;
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }

    private void makeDocuments(File folder) {
        documentRunner.execute(() -> {
            try {
                var documentFile = new CaptPDF(folder).make();
                if (documentFile != null) {
                    desk.putStatus("Made: " + documentFile.getAbsolutePath());
                }
            } catch (Exception e) {
                WizSwing.showError(e);
            }
        });
        for (var inside : folder.listFiles()) {
            if (inside.isDirectory()) {
                makeDocuments(inside);
            }
        }
    }

    Executor documentRunner = Executors.newSingleThreadExecutor();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAutoItems;
    private javax.swing.JButton buttonCopyTitle;
    private javax.swing.JButton buttonEstrategiaClean;
    private javax.swing.JButton buttonEstrategiaLogin;
    private javax.swing.JButton buttonEstrategiaStart;
    private javax.swing.JButton buttonEstrategiaStop;
    private javax.swing.JButton buttonGetLessonMaterials;
    private javax.swing.JButton buttonHeaderGrouped;
    private javax.swing.JButton buttonItemGrouped;
    private javax.swing.JButton buttonMakeDocuments;
    private javax.swing.JButton buttonMakeDownload;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonNextHeader;
    private javax.swing.JButton buttonNextItem;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonOpenDownloads;
    private javax.swing.JButton buttonSelect;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonTickView;
    private javax.swing.JButton buttonView;
    private javax.swing.JCheckBox checkAutoMakeDocuments;
    private javax.swing.JCheckBox checkWatch;
    private javax.swing.JComboBox<Display> comboDisplays;
    private javax.swing.JComboBox<String> comboMethod;
    private javax.swing.JSpinner editAutoItem;
    private javax.swing.JTextField editDestiny;
    private javax.swing.JTextField editEstrategia;
    private javax.swing.JSpinner editHeader;
    private javax.swing.JSpinner editItem;
    private javax.swing.JSpinner editPages;
    private javax.swing.JTextField editSource;
    private javax.swing.JSpinner editWait;
    private javax.swing.JLabel labelEstrategia;
    private javax.swing.JLabel labelMethod;
    private javax.swing.JLabel labelPages;
    private javax.swing.JLabel labelWait;
    // End of variables declaration//GEN-END:variables

}
