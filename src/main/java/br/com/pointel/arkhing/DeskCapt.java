package br.com.pointel.arkhing;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;

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
        buttonDestiny = new javax.swing.JButton();
        editSource = new javax.swing.JTextField();
        buttonStart = new javax.swing.JButton();
        editPages = new javax.swing.JSpinner();

        buttonView.setText("Source");
        buttonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewActionPerformed(evt);
            }
        });

        editDestiny.setEditable(false);
        editDestiny.setText(WizProps.get("DESK_CAPT_DESTINY", ""));

        buttonDestiny.setText("Destiny");
        buttonDestiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinyActionPerformed(evt);
            }
        });

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        editPages.setValue(50);

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
                        .addComponent(editDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDestiny))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editPages, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(buttonDestiny)
                    .addComponent(editDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStart)
                    .addComponent(editPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewActionPerformed
        var selected = (Display) comboDisplays.getSelectedItem();
        if (selected != null) {
            try {
                new ViewDisplay(selected, (rect) -> {
                    source = rect;
                    editSource.setText(source.toString());
                }).setVisible(true);
            } catch (Exception e) {
                WizSwing.showError(e);
            }
        }
    }//GEN-LAST:event_buttonViewActionPerformed

    private void buttonDestinyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinyActionPerformed
        try {
            var selected = WizSwing.selectFolder(new File(editDestiny.getText()));
            if (selected != null) {
                editDestiny.setText(selected.getAbsolutePath());
                WizProps.set("DESK_CAPT_DESTINY", editDestiny.getText());
            }
        } catch (Exception e) {
            WizSwing.showError(e);
        }
    }//GEN-LAST:event_buttonDestinyActionPerformed

    private volatile boolean making = false;

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        if (!making) {
            making = true;
            buttonStart.setText("Stop");
            var totalPages = (Integer) editPages.getValue();
            var captureSource = source;
            var middlePoint = new Point(source.x + (source.width / 2), source.y + (source.height / 2));
            var destinyFolder = new File(editDestiny.getText());
            new Thread() {
                @Override
                public void run() {
                    var indexPage = 0;
                    while (making && indexPage < totalPages) {
                        try {
                            indexPage++;
                            var robot = new Robot();
                            var pageNameSuffix = StringUtils.leftPad(String.valueOf(indexPage), 3, '0');
                            BufferedImage capture = robot.createScreenCapture(captureSource);
                            ImageIO.write(capture, "PNG", new File(destinyFolder, "page-" + pageNameSuffix + ".png"));
                            robot.delay(700);
                            robot.mouseMove(middlePoint.x, middlePoint.y);
                            robot.delay(700);
                            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(700);
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(700);
                            robot.keyPress(KeyEvent.VK_RIGHT);
                            robot.delay(700);
                            robot.keyRelease(KeyEvent.VK_RIGHT);
                            robot.delay(700);
                        } catch (Exception e) {
                            WizSwing.showError(e);
                        }
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_buttonStartActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDestiny;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonView;
    private javax.swing.JComboBox<Display> comboDisplays;
    private javax.swing.JTextField editDestiny;
    private javax.swing.JSpinner editPages;
    private javax.swing.JTextField editSource;
    // End of variables declaration//GEN-END:variables

}
