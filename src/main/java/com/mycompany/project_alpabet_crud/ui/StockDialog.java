/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.project_alpabet_crud.ui;

import com.mycompany.project_alpabet_crud.model.CheckStock;
import com.mycompany.project_alpabet_crud.model.CheckStockDetail;
import com.mycompany.project_alpabet_crud.model.Material;
import com.mycompany.project_alpabet_crud.model.Material;
import com.mycompany.project_alpabet_crud.service.CheckStockService;
import com.mycompany.project_alpabet_crud.service.MaterialService;
import com.mycompany.project_alpabet_crud.service.MaterialService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kissa
 */
public class StockDialog extends javax.swing.JDialog {
    private MaterialService materialService = new MaterialService();
    private Material material;
    private ArrayList<Material> updateMat = new ArrayList<>();
    private ArrayList<CheckStockDetail> list;
    private CheckStockDetail editedCheckStockDetail;
    private CheckStock checkStock;
    private CheckStockService checkStockService;
    
    public StockDialog(java.awt.Frame parent,  CheckStock checkStock, Material material) {
        super(parent, true);
        initComponents();
        this.checkStock = checkStock;
        this.list = checkStock.getCheckStockDetails();
        this.checkStockService = new CheckStockService();
        this.material = new Material();
        this.materialService = new MaterialService();
        enableForm(false);
        
        System.out.println(list);
        
        tblCd.setModel(new AbstractTableModel() {
            String[] colNames = {"Name", "Quantity", "UnitPrice", "Amount"};
            
            public String getcolumnName(int column){
                return colNames[column];
            }
                    
            @Override
            public int getRowCount() {
                return checkStock.getCheckStockDetails().size();
                
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                CheckStockDetail checkStockDetail = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                      return checkStockDetail.getMaterialId();
                    case 1:
                        return checkStockDetail.getName();
                    case 2:
                        return checkStockDetail.getQty();
                    case 3:
                        return checkStockDetail.getUnitPrice();
                        
                    default:
                        return "Unknown";
                        
                        
                }
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMatName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        btnCancle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCd = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(231, 212, 187));

        jLabel1.setText("Name:");

        jLabel2.setText("QTY:");

        jLabel3.setText("Amount:");

        btnSave.setBackground(new java.awt.Color(204, 255, 204));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel4.setText("UnitPrice:");

        btnCancle.setBackground(new java.awt.Color(255, 102, 102));
        btnCancle.setText("Cancle");

        tblCd.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCd);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("ID:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMatName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAmount))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancle, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave)
                    .addComponent(jLabel5)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String ID = txtId.getText();
        setObjectToForm(ID);
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(material != null){
            
            //Loop for check if have same Material
            for (Material m : updateMat) {
                if (material.getId() == m.getId()) {
                    resetForm();
                    JOptionPane.showMessageDialog(this, "this material already checked.");
                    return;
                }
            }
            //Add and Update
            setFormToObject();
            
            //Add unique Material
            updateMat.add(material);
            
            //add checkStockDetail determind by txtfield
            checkStock.addCheckStockDetail(material,Integer.parseInt(txtAmount.getText()));
            
            //Update All list
            list = checkStock.getCheckStockDetails();
            
            

            System.out.println("Material added");
            System.out.println(list);
            System.out.println("-----");
            
            //setup tableModel
            tblCd.setModel(new AbstractTableModel() {
                String[] colNames = {"Name", "Quantity", "UnitPrice", "Amount"};
                @Override
                public int getRowCount() {
                    return list.size();
                }

                @Override
                public int getColumnCount() {
                    return colNames.length;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    CheckStockDetail checkStockDetail = list.get(rowIndex);
                    switch (columnIndex) {

                    case 0:
                      return checkStockDetail.getMaterialId();
                    case 1:
                        return checkStockDetail.getName();
                    case 2:
                        return checkStockDetail.getQty();
                    case 3:
                        return checkStockDetail.getUnitPrice();
                        default:
                        return "Unknown";
                    }
                }
            });

        }else{
            return;
        }
        resetForm();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (checkStock.getCheckStockDetails().isEmpty()) {
            dispose();
            return;
        }

        System.out.println("In btnSave");
        System.out.println(checkStock);
        System.out.println("-----------");

        checkStockService.addNew(checkStock);
        MaterialService rs = new MaterialService();

        for (Material m : updateMat) {
            try {
                rs.update(m);
            } catch (Exception ex) {
                Logger.getLogger(StockDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dispose();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblCd.getSelectedRow();

        if (selectedIndex < 0) {
            return;
        }

        try {
            list.remove(selectedIndex);
            updateMat.remove(selectedIndex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }

        refreshTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCd;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMatName;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables


    private void setFormToObject() {
       if(material.getId() == -1) {
           return;
       }
       
       if (!txtUnitPrice.getText().isEmpty()) {
            material.setPricePerUnit((int) Float.parseFloat(txtUnitPrice.getText()));
   }
   
       if (!txtAmount.getText().isEmpty()) {
            material.setAmount((int) Float.parseFloat(txtAmount.getText()));
   }
    }

    private void setObjectToForm(String itemCode) {
        try {
            material = materialService.getById(Integer.parseInt(itemCode));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Please input ItemCode");
            return;
        }

        if (material == null) {
            resetForm();
            material = new Material();
            JOptionPane.showMessageDialog(this, "Not have this Material");
            return;
        }

        enableForm(true);
        txtId.setText(String.valueOf(material.getId()));
        txtMatName.setText(material.getName());
        txtTotal.setText(String.valueOf(material.getQty()));
        txtUnitPrice.setText(String.valueOf(material.getPricePerUnit()));
        
    }

    private void resetForm() {
        txtAmount.setText("");
        txtMatName.setText("");
        txtTotal.setText("");
        txtUnitPrice.setText("");
        enableForm(false);
    }

    private void enableForm(boolean status) {
        btnAdd.setEnabled(status);
        txtAmount.setEnabled(status);
        txtMatName.setEnabled(status);
        txtTotal.setEnabled(status);
        txtUnitPrice.setEnabled(status);
    }
    
    public StockDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.checkStock = new CheckStock();
        this.checkStockService = new CheckStockService();
        this.material = new Material();
        this.materialService = new MaterialService();
        enableForm(false);
    }

    private void refreshTable() {
        list = checkStock.getCheckStockDetails();
        tblCd.revalidate();
        tblCd.repaint();
    }
}
