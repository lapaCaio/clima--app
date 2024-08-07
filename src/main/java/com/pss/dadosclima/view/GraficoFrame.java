/*
 * Click nbfs:nbhostTemplateslicense-default.txt to change this license
 * Click nbfs:nbhostTemplatesJInternalFrame.java to edit this template
 */
package com.pss.dadosclima.view;

import javax.swing.JPanel;

public class GraficoFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form GraficoFrame
     */
    public GraficoFrame() {
        initComponents();
        setTitle("Máximas e Mínimas");
    }

    public JPanel getChartPanel() {
        return ChartPanel;
    }

    /**
     * Método para definir a posição do JInternalFrame
     */
    public void setPosition(int x, int y) {
        setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        ChartPanel = new javax.swing.JPanel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        ChartPanel.setAutoscrolls(true);

        javax.swing.GroupLayout ChartPanelLayout = new javax.swing.GroupLayout(ChartPanel);
        ChartPanel.setLayout(ChartPanelLayout);
        ChartPanelLayout.setHorizontalGroup(
                ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 679, Short.MAX_VALUE)
        );
        ChartPanelLayout.setVerticalGroup(
                ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 378, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ChartPanel.getAccessibleContext().setAccessibleParent(null);

        pack();
    }

     
    private javax.swing.JPanel ChartPanel;
     
}
