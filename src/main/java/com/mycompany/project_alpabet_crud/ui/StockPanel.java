/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.project_alpabet_crud.ui;

import com.mycompany.project_alpabet_crud.model.CheckStock;
import com.mycompany.project_alpabet_crud.model.Material;
import com.mycompany.project_alpabet_crud.model.User;
import com.mycompany.project_alpabet_crud.service.CheckStockService;
import com.mycompany.project_alpabet_crud.service.MaterialService;
import com.mycompany.project_alpabet_crud.service.UserService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author kissa
 */
public class StockPanel extends javax.swing.JPanel {
    private final CheckStockService checkStockService;
    private List<CheckStock> list;
    private CheckStock editedCheckStock;
//    private final MaterialService materialService;
    private List<Material> material;
    private Material editedMaterial;
    private UserService userService = new UserService();
    private User user = userService.getCurrentUser();
    
    
    /**
     * Creates new form StockPanel
     */
    public StockPanel() {
        initComponents();
        CheckStock checkStock = new CheckStock();
        checkStockService = new CheckStockService();
        list = checkStockService.getCheckStocks();
        tblUser.setModel(new AbstractTableModel(){
            @Override
            public int getRowCount() {
                return list.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                CheckStock checkStock = (CheckStock) list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return checkStock.getCheckId();
                    case 1:
                        return checkStock.getCheckDate();
                    case 2:
                        return checkStock.getUser().getName();
                    default:
                        return "Unknown";
                }
            } 
            
            String[] columnNames = {"Id", "Date", "User Name"};
            
            @Override 
            public String getColumnName(int column){
                return columnNames[column];
            }
        });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CheckStockPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        btnCheckStock = new javax.swing.JButton();
        Material = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1054, 600));

        CheckStockPanel.setBackground(new java.awt.Color(255, 255, 255));
        CheckStockPanel.setPreferredSize(new java.awt.Dimension(1055, 600));

        jPanel3.setBackground(new java.awt.Color(231, 212, 187));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUser);

        btnView.setBackground(new java.awt.Color(102, 204, 255));
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setText("Delete");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Inspector");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnDelete))
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(231, 212, 187));

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollpane.setViewportView(tblMaterial);

        btnCheckStock.setBackground(new java.awt.Color(102, 204, 255));
        btnCheckStock.setText("CheckStock");
        btnCheckStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckStockActionPerformed(evt);
            }
        });

        Material.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Material.setForeground(new java.awt.Color(102, 102, 102));
        Material.setText("Material");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Material)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCheckStock)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckStock)
                    .addComponent(Material))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane))
        );

        javax.swing.GroupLayout CheckStockPanelLayout = new javax.swing.GroupLayout(CheckStockPanel);
        CheckStockPanel.setLayout(CheckStockPanelLayout);
        CheckStockPanelLayout.setHorizontalGroup(
            CheckStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(CheckStockPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CheckStockPanelLayout.setVerticalGroup(
            CheckStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(CheckStockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(CheckStockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
      
        
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCheckStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckStockActionPerformed
        // TODO add your handling code here:
        editedCheckStock = new CheckStock(user);
        openDialog();
    }//GEN-LAST:event_btnCheckStockActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CheckStockPanel;
    private javax.swing.JLabel Material;
    private javax.swing.JButton btnCheckStock;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable tblMaterial;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables

    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        StockDialog stockDialog = new StockDialog(frame, editedCheckStock);
        JFrame newFrame = new JFrame("Stock");
        newFrame.add(stockDialog);
        newFrame.pack(); 
        newFrame.setLocationRelativeTo(frame); 
        newFrame.setVisible(true);
        newFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable(); 
            }
        });
    }

    private void refreshTable(){
        
    }

    
    

}
