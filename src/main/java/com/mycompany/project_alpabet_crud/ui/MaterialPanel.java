/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.project_alpabet_crud.ui;

import com.mycompany.project_alpabet_crud.model.Material;
import com.mycompany.project_alpabet_crud.model.MaterialUserImport;
import com.mycompany.project_alpabet_crud.model.User;
import com.mycompany.project_alpabet_crud.service.MaterialService;
import com.mycompany.project_alpabet_crud.service.MaterialUserImportService;
import com.mycompany.project_alpabet_crud.service.UserService;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author teeraphat
 */
public class MaterialPanel extends javax.swing.JPanel {

    private MaterialService mtService;
    private List<Material> list;
    public Material editMaterial;
    public MaterialUserImport editMaterialImport;
    public MaterialUserImport matimp;
    public User currentUser;
    private MaterialService materialService;
    private MaterialUserImportService materialUserImportService;
    private final MaterialUserImportService mtimService;
    private List<MaterialUserImport> listmatimp;
    

    /**
     * Creates new form MaterialPanel
     */
    public MaterialPanel() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)tblPreImport.getModel();
        model.setColumnIdentifiers(new Object[]{"Name", "Qty", "Price", "Shop"});
        materialService = new MaterialService();
        materialUserImportService = new MaterialUserImportService();
        editMaterial = new Material();
        editMaterialImport = new MaterialUserImport();
        
        // tbleployee **********************************************************************************************************************************
        mtimService = new MaterialUserImportService();
        tblEmployee.setRowHeight(100);
        listmatimp = mtimService.getMaterialUserImport();
        tblEmployee.setModel(new AbstractTableModel() {
            String[] columnName = {"ID","Date", "User Id", "User Name", "Material Name"};

            @Override
            public String getColumnName(int column) {
                return columnName[column];
            }
            
            @Override
            public int getRowCount() {
                return listmatimp.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                MaterialUserImport  materialuserimport = listmatimp.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return materialuserimport.getId();
                    case 1:
                        return materialuserimport.getDate();
                    case 2:
                        return materialuserimport.getUserId();
                    case 3:
                        return materialuserimport.getUserName();
                    case 4:
                        return materialuserimport.getMaterialName();
                    default:
                        return "unknown";
                }
            }
        });
    }
    
    private void setFromToObjectuser() {
        editMaterialImport.setUserId(UserService.getCurrentUser().getId());
        editMaterialImport.setUserName(UserService.getCurrentUser().getName());
        editMaterialImport.setMaterialName((String) cmbMaterial.getSelectedItem());
        
        
    }
    private void setFormToObject() {
        // TODO add your handling code here:
        editMaterial.setName((String) cmbMaterial.getSelectedItem());
        try {
            int qty = Integer.parseInt(edtQty.getText().toString());
            editMaterial.setQty(qty);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            int totalprice = Integer.parseInt(edtTotalPrice.getText().toString());
            editMaterial.setTotalPrice(totalprice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int qty = Integer.parseInt(edtQty.getText().toString());
        int totalprice = Integer.parseInt(edtTotalPrice.getText().toString());
        int priceperunit = totalprice/qty;
        editMaterial.setPricePerUnit(priceperunit);
        editMaterial.setShop(edtShop.getText());
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtShop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbMaterial = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        edtQty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edtTotalPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPreImport = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(231, 212, 187));

        jLabel1.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jLabel1.setText("Shop :");

        edtShop.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        edtShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtShopActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jLabel2.setText("Material :");

        cmbMaterial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sugar", "coffee beans" }));

        jLabel4.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jLabel4.setText("Quantity :");

        edtQty.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jLabel5.setText("Total Price :");

        edtTotalPrice.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        edtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTotalPriceActionPerformed(evt);
            }
        });

        jLabel6.setText(".");

        btnClear.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        btnClear.setText("Clear");

        btnSave.setBackground(new java.awt.Color(255, 255, 153));
        btnSave.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("!!! IMPORT 1 TIME PER 1 ITEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtShop, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(edtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(edtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(231, 212, 187));

        tblEmployee.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(tblEmployee);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(231, 212, 187));

        tblPreImport.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        tblPreImport.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPreImport);

        btnCancel.setBackground(new java.awt.Color(255, 153, 153));
        btnCancel.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(153, 255, 153));
        btnImport.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImport))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edtShopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtShopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtShopActionPerformed

    private void edtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTotalPriceActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed

        Material material;
        material = materialService.update(editMaterial);
        MaterialUserImport materialUserImport;
        materialUserImport = materialUserImportService.addNew(editMaterialImport);
        tblEmployee.repaint();
        refreshTable();
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        setFormToObject();
        setFromToObjectuser();
        mtService = new MaterialService();
        tblPreImport.setRowHeight(100);
        list = mtService.getMaterial();
//        System.out.println(list);
        System.out.println(editMaterial);
        System.out.println(editMaterialImport);
        tblPreImport.setModel(new AbstractTableModel() {
            String[] columnName = {"ID","Name", "Qty", "Price", "Shop"};

            @Override
            public String getColumnName(int column) {
                return columnName[column];
            }
            
            @Override
            public int getRowCount() {
                return 1;
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Material user = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return cmbMaterial.getSelectedItem();
                    case 1:
                        return edtQty.getText();
                    case 2:
                        return edtTotalPrice.getText();
                    case 3:
                        return edtShop.getText();
                    default:
                        return "unknown";
                }
            }
        });
        
        
        
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbMaterial;
    private javax.swing.JTextField edtQty;
    private javax.swing.JTextField edtShop;
    private javax.swing.JTextField edtTotalPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblPreImport;
    // End of variables declaration//GEN-END:variables

    private void refreshTable() {
        listmatimp = materialUserImportService.getMaterialUserImport();
        tblEmployee.revalidate();
        tblEmployee.repaint();
    }
    
    
}
