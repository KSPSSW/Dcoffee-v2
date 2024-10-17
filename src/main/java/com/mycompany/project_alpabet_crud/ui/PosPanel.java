/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.project_alpabet_crud.ui;

import com.mycompany.project_alpabet_crud.component.BuyProductable;
import com.mycompany.project_alpabet_crud.component.ProductListPanel;
import com.mycompany.project_alpabet_crud.model.Product;
import com.mycompany.project_alpabet_crud.model.Reciept;
import com.mycompany.project_alpabet_crud.model.RecieptDetail;
import com.mycompany.project_alpabet_crud.service.ProductService;
import com.mycompany.project_alpabet_crud.service.RecieptService;
import com.mycompany.project_alpabet_crud.service.UserService;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author informatics
 */
public class PosPanel extends javax.swing.JPanel implements BuyProductable {

    ArrayList<Product> products;
    ProductService productService = new ProductService();
    RecieptService receiptService = new RecieptService();
    
    Reciept receipt;
    private final ProductListPanel productListPanel;

    /**
     * Creates new form PosPanel
     */
    public PosPanel() {
        initComponents();
        initProducttable();
        receipt = new Reciept();

        tblreciept.setModel(new AbstractTableModel() {
            String[] header = {"Name", "Price", "Quantity", "Total"};

            @Override
            public String getColumnName(int column) {
                return header[column];
            }

            @Override
            public int getRowCount() {
                return receipt.getRecieptDetails().size();
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ArrayList<RecieptDetail> receiptDetails = receipt.getRecieptDetails();
                RecieptDetail receiptDetail = receiptDetails.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return receiptDetail.getProductName();
                    case 1:
                        return receiptDetail.getProductPrice();
                    case 2:
                        return receiptDetail.getQty();
                    case 3:
                        return receiptDetail.getTotalPrice();
                    default:
                        return "";
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                ArrayList<RecieptDetail> receiptDetails = receipt.getRecieptDetails();
                RecieptDetail receiptDetail = receiptDetails.get(rowIndex);
                if (columnIndex == 2) {
                    int qty = Integer.parseInt((String) aValue);
                    if (qty < 1) {
                        return;
                    }
                    receiptDetail.setQty(qty);
                    receipt.calculateTotal();
                    refreshReciept();
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 2:
                        return true;
                    default:
                        return false;
                }
            }
        });
        productListPanel = new ProductListPanel();
        productListPanel.addOnByProduct(this);
        jScrollPane3.setViewportView(productListPanel);
    }

    private void initProducttable() {
        products = productService.getProductsOrderByName();
        tblProduct.setModel(new AbstractTableModel() {
            String[] headers = {"Image", "ID", "Name", "Price"};

            @Override
            public int getRowCount() {
                return products.size();
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 ->
                        ImageIcon.class;
                    default ->
                        String.class;
                };
            }

            @Override
            public String getColumnName(int column) {
                return headers[column];
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Product product = products.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        ImageIcon icon = new ImageIcon("./productpic/product" + product.getId() + ",png");
                        Image image = icon.getImage();
                        int width = image.getWidth(null);
                        int height = image.getHeight(null);
                        Image newImage = image.getScaledInstance((int) ((100 * width) / height), 100, Image.SCALE_SMOOTH);
                        icon.setImage(newImage);
                        return icon;
                    case 1:
                        return product.getId();
                    case 2:
                        return product.getName();
                    case 3:
                        return product.getPrice();
                    default:
                        return "";
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                ArrayList<RecieptDetail> receiptDetails = receipt.getRecieptDetails();
                RecieptDetail receiptDetail = receiptDetails.get(rowIndex);
                if (columnIndex == 2) {
                    int qty = Integer.parseInt((String) aValue);
                    if (qty < 1) {
                        return;
                    }
                    receiptDetail.setQty(qty);
                    receipt.calculateTotal();
                    refreshReciept();
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 2:
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void refreshReciept() {
        tblreciept.revalidate();
        tblreciept.repaint();
        lbltotal.setText("" + receipt.getTotal());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblreciept = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblcash = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblchange = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProduct);

        tblreciept.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblreciept);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("CALCULATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Total :");

        lbltotal.setBackground(new java.awt.Color(255, 255, 255));
        lbltotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltotal.setText("00.0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cash :");

        lblcash.setBackground(new java.awt.Color(255, 255, 255));
        lblcash.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblcash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcash.setText("00.0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Change :");

        lblchange.setBackground(new java.awt.Color(255, 255, 255));
        lblchange.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblchange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblchange.setText("00.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblcash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblchange, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotal)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblchange))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(51, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("CASH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("" + receipt);
        receipt.setUser(UserService.getCurrentUser());
        receiptService.addNew(receipt);
        clearReceipt();
        clearText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        openDialog();
        


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int selectedIndex = tblreciept.getSelectedRow();
        if (selectedIndex >= 0) {
            RecieptDetail selectedReceiptDetail = receipt.getRecieptDetails().get(selectedIndex);
            int input = JOptionPane.showConfirmDialog(this, "Do you want to proceed?", "Select an Option...", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (input == 0) {
                receipt.delRecieptDetail(selectedReceiptDetail);
                refreshReciept();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a receipt detail to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnDeleteActionPerformed
    public void clearReceipt() {
        receipt = new Reciept();

        refreshReciept();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblcash;
    private javax.swing.JLabel lblchange;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblreciept;
    // End of variables declaration//GEN-END:variables
    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        CashDialog paymentDialog = new CashDialog((frame), true);
        paymentDialog.setLocationRelativeTo(this);
        paymentDialog.setVisible(true);
        paymentDialog.addWindowListener(new WindowAdapter() {
        });
        Addcash(paymentDialog);
        lblchange.setText(""+(receipt.getCash()-receipt.getTotal()));
    }

    private void Addcash(CashDialog paymentDialog) {
        float cash = paymentDialog.resultNumber;
        receipt.setCash(cash);
        lblcash.setText(""+cash);
    }

    @Override
    public void buy(Product product, int qty) {
        receipt.addRecieptDetail(product, qty);
        refreshReciept();
    }

    private void clearText() {
        lblcash.setText("00.0");
        lblchange.setText("00.0");
        lbltotal.setText("00.0");
    }
}
