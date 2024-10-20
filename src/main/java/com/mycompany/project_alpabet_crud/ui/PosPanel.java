/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.project_alpabet_crud.ui;

import com.mycompany.project_alpabet_crud.component.BuyProductable;
import com.mycompany.project_alpabet_crud.component.ProductListPanel;
import com.mycompany.project_alpabet_crud.component.ProductSaleDialog;
import com.mycompany.project_alpabet_crud.model.Product;
import com.mycompany.project_alpabet_crud.model.Reciept;
import com.mycompany.project_alpabet_crud.model.RecieptDetail;
import com.mycompany.project_alpabet_crud.model.User;
import com.mycompany.project_alpabet_crud.service.ProductService;
import com.mycompany.project_alpabet_crud.service.RecieptService;
import com.mycompany.project_alpabet_crud.service.UserService;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
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
    private ArrayList<BuyProductable> subscribers = new ArrayList<>();
    private ProductListPanel productListPanel;
    private List<RecieptDetail> list;
    private RecieptDetail editedRecieptDetail;
    private Reciept editedReciept;
    private final ProductListPanel coffeeProductListPanel;
    private final ProductListPanel dessertProductListPanel;
    private final ProductListPanel candyProductListPanel;
    private Product product;

    /**
     * Creates new form PosPanel
     */
    public PosPanel() {
        initComponents();

        receipt = new Reciept();

        tblreciept.setModel(new AbstractTableModel() {
            String[] header = {"Name", "Size", "SweelLevel", "Type", "Price", "Quantity", "Total"};

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
                return 7;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ArrayList<RecieptDetail> receiptDetails = receipt.getRecieptDetails();
                RecieptDetail receiptDetail = receiptDetails.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return receiptDetail.getProductName();

                    case 1:
                        return receiptDetail.getProductSize();
                    case 2:
                        return receiptDetail.getProductSweetLevel();
                    case 3:
                        return receiptDetail.getProductType();
                    case 4:
                        return receiptDetail.getProductPrice();
                    case 5:
                        return receiptDetail.getQty();
                    case 6:
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
                    case 5:
                        return true;
                    default:
                        return false;
                }
            }
        });
        coffeeProductListPanel = new ProductListPanel(1); // หมวดกาแฟ (id = 1)
        dessertProductListPanel = new ProductListPanel(2); // หมวดขนมหวาน (id = 2)
        candyProductListPanel = new ProductListPanel(3); // หมวดลูกกวาด (id = 3)
        coffeeProductListPanel.addOnByProduct(this);
        dessertProductListPanel.addOnByProduct(this);
        candyProductListPanel.addOnByProduct(this);
        coffeeTab.setViewportView(coffeeProductListPanel);
        dessertTab.setViewportView(dessertProductListPanel);
        candyTab.setViewportView(candyProductListPanel);

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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblreciept = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        categoryTab = new javax.swing.JTabbedPane();
        coffeeTab = new javax.swing.JScrollPane();
        dessertTab = new javax.swing.JScrollPane();
        candyTab = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblcash = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblchange = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdited = new javax.swing.JButton();

        setBackground(new java.awt.Color(231, 212, 187));

        tblreciept.setFont(new java.awt.Font("K2D", 0, 14)); // NOI18N
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

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jButton1.setText("CALCULATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        categoryTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                categoryTabMousePressed(evt);
            }
        });
        categoryTab.addTab("Coffee", coffeeTab);
        categoryTab.addTab("Dessert", dessertTab);
        categoryTab.addTab("Candy", candyTab);

        jScrollPane3.setViewportView(categoryTab);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jLabel1.setText("Total :");

        lbltotal.setBackground(new java.awt.Color(255, 255, 255));
        lbltotal.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        lbltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltotal.setText("00.0");

        jLabel2.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jLabel2.setText("Cash :");

        lblcash.setBackground(new java.awt.Color(255, 255, 255));
        lblcash.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        lblcash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcash.setText("00.0");

        jLabel3.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jLabel3.setText("Change :");

        lblchange.setBackground(new java.awt.Color(255, 255, 255));
        lblchange.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(lblchange)))
        );

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        jButton2.setText("CASH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 153, 153));
        btnDelete.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdited.setBackground(new java.awt.Color(255, 255, 204));
        btnEdited.setFont(new java.awt.Font("K2D", 0, 18)); // NOI18N
        btnEdited.setText("Edited");
        btnEdited.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdited, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnEdited))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
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

    private void categoryTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryTabMousePressed
        int selectedIndex = categoryTab.getSelectedIndex();
        coffeeTab.setVisible(false);
        dessertTab.setVisible(false);
        candyTab.setVisible(false);
        switch (selectedIndex) {
            case 0: // Coffee tab
                coffeeTab.setVisible(true);
                break;
            case 1: // Dessert tab
                dessertTab.setVisible(true);
                break;
            case 2: // Candy tab
                candyTab.setVisible(true);
                break;
            default:
                break;
        }
        revalidate();
        repaint();
    }//GEN-LAST:event_categoryTabMousePressed

    private void btnEditedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditedActionPerformed
       
    }//GEN-LAST:event_btnEditedActionPerformed
    public void clearReceipt() {
        receipt = new Reciept();

        refreshReciept();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdited;
    private javax.swing.JScrollPane candyTab;
    private javax.swing.JTabbedPane categoryTab;
    private javax.swing.JScrollPane coffeeTab;
    private javax.swing.JScrollPane dessertTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblcash;
    private javax.swing.JLabel lblchange;
    private javax.swing.JLabel lbltotal;
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
        lblchange.setText("" + (receipt.getCash() - receipt.getTotal()));
    }


    private void Addcash(CashDialog paymentDialog) {
        float cash = paymentDialog.resultNumber;
        receipt.setCash(cash);
        lblcash.setText("" + cash);
    }

    @Override
    public void buy(Product product, int qty, String productSize, String productSweetLevel, String productType) {
        ArrayList<RecieptDetail> receiptDetails = receipt.getRecieptDetails();
        boolean productExists = false;

        for (RecieptDetail detail : receiptDetails) {
            if (detail.getProductId() == product.getId()
                    && detail.getProductSize().equals(productSize)
                    && detail.getProductSweetLevel().equals(productSweetLevel)
                    && detail.getProductType().equals(productType)) {
                detail.setQty(detail.getQty() + qty);
                productExists = true;
                break;
            }
        }
        if (!productExists) {
            receipt.addRecieptDetail(product, qty, productSize, productSweetLevel, productType);
        }
        refreshReciept();
    }

    private void clearText() {
        lblcash.setText("00.0");
        lblchange.setText("00.0");
        lbltotal.setText("00.0");
    }

}
