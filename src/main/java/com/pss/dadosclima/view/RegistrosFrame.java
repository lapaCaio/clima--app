package com.pss.dadosclima.view;

import javax.swing.*;

public class RegistrosFrame extends javax.swing.JInternalFrame {

    public RegistrosFrame() {
        initComponents();
    }

    public JButton getRemoverButton() {
        return RemoverButton;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    // Método para definir a posição do JInternalFrame
    public void setPosition(int x, int y) {
        setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RemoverButton = new javax.swing.JButton();

        setIconifiable(true);
        setResizable(true);
        setTitle("Registros");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "", "", "", ""
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        RemoverButton.setText("Remover");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RemoverButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RemoverButton)
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }

    private javax.swing.JButton RemoverButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
