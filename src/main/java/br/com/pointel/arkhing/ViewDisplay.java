package br.com.pointel.arkhing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author emuvi
 */
public class ViewDisplay extends javax.swing.JFrame {

    private final Display display;
    private final Consumer<Rectangle> onAccept;
    private final BufferedImage captured;
    private final Editor editor;

    public ViewDisplay(Display display, Consumer<Rectangle> onAccept) throws Exception {
        this.display = display;
        this.onAccept = onAccept;
        this.captured = display.capture();
        this.editor = new Editor();
        initComponents();
        scrollDisplay.setViewportView(editor);
        setTitle(display.toString());
        WizSwing.initPositioner(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollDisplay = new javax.swing.JScrollPane();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Display");
        setLocationByPlatform(true);

        buttonAccept.setMnemonic('A');
        buttonAccept.setText("Accept");
        buttonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcceptActionPerformed(evt);
            }
        });

        buttonCancel.setMnemonic('C');
        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 438, Short.MAX_VALUE)
                        .addComponent(buttonAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel))
                    .addComponent(scrollDisplay))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonAccept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        onAccept.accept(editor.getSelected());
        WizSwing.close(this);
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        WizSwing.close(this);
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JScrollPane scrollDisplay;
    // End of variables declaration//GEN-END:variables

    private class Editor extends JPanel {

        private Point pointTopLeft = null;
        private Point pointBottomRight = null;

        public Editor() {
            var dimension = new Dimension(captured.getWidth(), captured.getHeight());
            setPreferredSize(dimension);
            setMinimumSize(dimension);
            setMaximumSize(dimension);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        if (e.isControlDown()) {
                            pointTopLeft = e.getPoint();
                        } else if (e.isAltDown()) {
                            pointBottomRight = e.getPoint();
                        }
                        SwingUtilities.updateComponentTreeUI(scrollDisplay);
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(captured, 0, 0, null);
            if (pointTopLeft != null) {
                g.setColor(Color.GREEN);
                g.fillRoundRect(pointTopLeft.x - 3, pointTopLeft.y - 3, 6, 6, 4, 4);
                g.setColor(Color.BLACK);
                g.drawRoundRect(pointTopLeft.x - 3, pointTopLeft.y - 3, 6, 6, 4, 4);
            }
            if (pointBottomRight != null) {
                g.setColor(Color.RED);
                g.fillRoundRect(pointBottomRight.x - 3, pointBottomRight.y - 3, 6, 6, 4, 4);
                g.setColor(Color.BLACK);
                g.drawRoundRect(pointBottomRight.x - 3, pointBottomRight.y - 3, 6, 6, 4, 4);
            }
        }

        public Rectangle getSelected() {
            return new Rectangle(
                    display.getBounds().x + pointTopLeft.x,
                    display.getBounds().y + pointTopLeft.y,
                    pointBottomRight.x - pointTopLeft.x,
                    pointBottomRight.y - pointTopLeft.y
            );
        }

    }

}