/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.project_alpabet_crud.ui;

import com.mycompany.project_alpabet_crud.model.Product;
import com.mycompany.project_alpabet_crud.model.User;
import com.mycompany.project_alpabet_crud.service.ProductService;
import com.mycompany.project_alpabet_crud.service.UserService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author os
 */
public class ProductDialog extends javax.swing.JDialog {

    private final ProductService productService;
    private Product editedProduct;
    private String path;

    /**
     * Creates new form ProductDialog
     */
    public ProductDialog(java.awt.Frame parent, Product editedProduct) {
        super(parent, true);
        initComponents();
        this.editedProduct = editedProduct;
        setObjectToForm();
        productService = new ProductService();
        loadImage();
    }

    private void loadImage() {
        if (editedProduct.getId() > 0) {
            ImageIcon icon = new ImageIcon("./product" + editedProduct.getId() + ".png");
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icon.setImage(newImage);
            lblPhoto.setIcon(icon);
        }
    }

    private void loadImage(String path) {
        if (editedProduct.getId() > 0) {
            ImageIcon icon = new ImageIcon(path);
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icon.setImage(newImage);
            lblPhoto.setIcon(icon);
        }
    }

    public void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "png", "jpg", "jpeg");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());
            loadImage(file.getAbsolutePath());
            path = file.getAbsolutePath();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        edtPrice = new javax.swing.JTextField();
        lblSize = new javax.swing.JLabel();
        edtName = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        lblCategoryId = new javax.swing.JLabel();
        cmbCategoryId = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        lblSweetLevel = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        edtSize = new javax.swing.JTextField();
        edtType = new javax.swing.JTextField();
        edtSweetLevel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblId.setText("ID: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setText("Name:");

        edtPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edtPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblSize.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSize.setText("Size:");

        edtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPrice.setText("Price:");

        lblCategoryId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCategoryId.setText("Category ID:");

        cmbCategoryId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbCategoryId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblPhoto.setOpaque(true);
        lblPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhotoMouseClicked(evt);
            }
        });

        lblSweetLevel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSweetLevel.setText("SweetLevel:");

        lblType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblType.setText("Type:");

        edtSize.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        edtType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTypeActionPerformed(evt);
            }
        });

        edtSweetLevel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edtSweetLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSweetLevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategoryId)
                    .addComponent(lblName)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice)
                    .addComponent(lblSize)
                    .addComponent(lblSweetLevel)
                    .addComponent(lblType))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtSweetLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave)))
                        .addGap(116, 116, 116))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrice)
                            .addComponent(edtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSize)
                            .addComponent(edtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSweetLevel)
                            .addComponent(edtSweetLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblType)
                            .addComponent(edtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoryId)
                            .addComponent(cmbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnSave))))
                .addGap(33, 45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Product product;
        if (editedProduct.getId() < 0) //Add New
        {
            setFormToObject();

            product = productService.addNew(editedProduct);

        } else {
            setFormToObject();

            product = productService.update(editedProduct);

        }
        saveImage(product);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void saveImage(Product product) {
        if (path == null || path.isEmpty()) {
            return;
        }
        try {
            BufferedImage image = ImageIO.read(new File(path));
            ImageIO.write(image, "png", new File("./product" + product.getId() + ".png"));
        } catch (IOException ex) {
            Logger.getLogger(ProductDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void lblPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoMouseClicked
        chooseImage();
    }//GEN-LAST:event_lblPhotoMouseClicked

    private void edtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTypeActionPerformed

    private void edtSweetLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSweetLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSweetLevelActionPerformed

    /**
     * @param args the command line arguments
     */
    private void setFormToObject() {
        editedProduct.setName(edtName.getText());
        editedProduct.setPrice(Float.parseFloat(edtPrice.getText().toString())); //แปลง String เป็น Float
        editedProduct.setSize(edtSize.getText());
        editedProduct.setSweetLevel(edtSweetLevel.getText());
        editedProduct.setType(edtType.getText());
        editedProduct.setCategoryId(cmbCategoryId.getSelectedIndex());
    }

    private void setObjectToForm() {
        edtName.setText(editedProduct.getName());
        edtPrice.setText(String.valueOf(editedProduct.getPrice())); //แปลง Float เป็น String
        edtSize.setText(editedProduct.getSize());
        edtType.setText(editedProduct.getSweetLevel());
        edtType.setText(editedProduct.getType());
        cmbCategoryId.setSelectedIndex(editedProduct.getCategoryId());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCategoryId;
    private javax.swing.JTextField edtName;
    private javax.swing.JTextField edtPrice;
    private javax.swing.JTextField edtSize;
    private javax.swing.JTextField edtSweetLevel;
    private javax.swing.JTextField edtType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoryId;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblSweetLevel;
    private javax.swing.JLabel lblType;
    // End of variables declaration//GEN-END:variables
}
