package br.com.pointel.arkhing;

import java.awt.HeadlessException;
import java.io.File;
import java.util.List;

public class Catalog extends javax.swing.JFrame {

    private final Desk desk;
    private final List<File> files;

    public Catalog(Desk desk, List<File> files) throws HeadlessException {
        this.desk = desk;
        this.files = files;
        WizSwing.initPositioner(this);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        buttonTitle = new javax.swing.JButton();
        buttonSubtitle = new javax.swing.JButton();
        buttonAuthor = new javax.swing.JButton();
        buttonCatalog = new javax.swing.JButton();
        buttonJump = new javax.swing.JButton();
        buttonTerminate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arkhing - Catalog");

        panelDestiny.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        comboRaiz.setFont(WizSwing.fontMonospaced());
        panelDestiny.add(comboRaiz);

        buttonNew.setMnemonic('N');
        buttonNew.setText("New");

        panelNaming.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        editTitle.setFont(WizSwing.fontMonospaced());
        panelNaming.add(editTitle);

        editSubtitle.setFont(WizSwing.fontMonospaced());
        panelNaming.add(editSubtitle);

        editAuthor.setFont(WizSwing.fontMonospaced());
        panelNaming.add(editAuthor);

        panelViewer.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout panelPageLayout = new javax.swing.GroupLayout(panelPage);
        panelPage.setLayout(panelPageLayout);
        panelPageLayout.setHorizontalGroup(
            panelPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        panelPageLayout.setVerticalGroup(
            panelPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        panelViewer.add(panelPage);

        textPage.setColumns(20);
        textPage.setFont(WizSwing.fontMonospaced());
        textPage.setRows(5);
        scrollPage.setViewportView(textPage);

        panelViewer.add(scrollPage);

        buttonPrior.setMnemonic('R');
        buttonPrior.setText("Prior");

        buttonNext.setMnemonic('X');
        buttonNext.setText("Next");

        buttonTitle.setMnemonic('T');
        buttonTitle.setText("Title");

        buttonSubtitle.setMnemonic('S');
        buttonSubtitle.setText("Subtitle");

        buttonAuthor.setMnemonic('A');
        buttonAuthor.setText("Author");
        buttonAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAuthorActionPerformed(evt);
            }
        });

        buttonCatalog.setMnemonic('C');
        buttonCatalog.setText("Catalog");

        buttonJump.setMnemonic('J');
        buttonJump.setText("Jump");

        buttonTerminate.setMnemonic('M');
        buttonTerminate.setText("Terminate");

        javax.swing.GroupLayout panelActionsLayout = new javax.swing.GroupLayout(panelActions);
        panelActions.setLayout(panelActionsLayout);
        panelActionsLayout.setHorizontalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActionsLayout.createSequentialGroup()
                .addComponent(buttonPrior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAuthor)
                .addGap(18, 18, 18)
                .addComponent(buttonCatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonJump)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTerminate))
        );
        panelActionsLayout.setVerticalGroup(
            panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTerminate)
                    .addComponent(buttonPrior)
                    .addComponent(buttonNext)
                    .addComponent(buttonJump)
                    .addComponent(buttonCatalog)
                    .addComponent(buttonTitle)
                    .addComponent(buttonSubtitle)
                    .addComponent(buttonAuthor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addComponent(panelDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNew)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNaming, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAuthorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAuthor;
    private javax.swing.JButton buttonCatalog;
    private javax.swing.JButton buttonJump;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonPrior;
    private javax.swing.JButton buttonSubtitle;
    private javax.swing.JButton buttonTerminate;
    private javax.swing.JButton buttonTitle;
    private javax.swing.JComboBox<String> comboRaiz;
    private javax.swing.JTextField editAuthor;
    private javax.swing.JTextField editSubtitle;
    private javax.swing.JTextField editTitle;
    private javax.swing.JPanel panelActions;
    private javax.swing.JPanel panelDestiny;
    private javax.swing.JPanel panelNaming;
    private javax.swing.JPanel panelPage;
    private javax.swing.JPanel panelViewer;
    private javax.swing.JScrollPane scrollPage;
    private javax.swing.JTextArea textPage;
    // End of variables declaration//GEN-END:variables
}
