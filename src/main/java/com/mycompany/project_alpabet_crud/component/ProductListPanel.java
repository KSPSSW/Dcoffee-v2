/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.project_alpabet_crud.component;

import com.mycompany.project_alpabet_crud.model.Product;
import com.mycompany.project_alpabet_crud.service.ProductService;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author thana
 */
public class ProductListPanel extends javax.swing.JPanel implements BuyProductable {

    private final ProductService productService;
    private final ArrayList<Product> products;
    private ArrayList<BuyProductable> subscribers = new ArrayList<>();
    private int categoryId;

    /**
     * Creates new form ProductListPanel
     */
    public ProductListPanel(int categoryId) {
        initComponents();
        productService = new ProductService();
        products = productService.getProductsCategoryOrderByName(categoryId);
        int ProductSize = products.size();
        System.out.println(products);
        System.out.println(products.size());

        for (Product p : products) {
            ProductItemPanel pnlProductItem = new ProductItemPanel(p);
            pnlProductItem.addOnByProduct(this);
            pnlProductlist.add(pnlProductItem);

        }
        pnlProductlist.setLayout(new GridLayout((ProductSize / 3) + ((ProductSize % 3 != 0) ? 1 : 0), 3, 0, 0));
    }

    public void addOnByProduct(BuyProductable subscriber) {
        subscribers.add(subscriber);

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
        pnlProductlist = new javax.swing.JPanel();

        setBackground(new java.awt.Color(200, 162, 127));

        javax.swing.GroupLayout pnlProductlistLayout = new javax.swing.GroupLayout(pnlProductlist);
        pnlProductlist.setLayout(pnlProductlistLayout);
        pnlProductlistLayout.setHorizontalGroup(
            pnlProductlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );
        pnlProductlistLayout.setVerticalGroup(
            pnlProductlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlProductlist);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlProductlist;
    // End of variables declaration//GEN-END:variables

    @Override
    public void buy(Product product, int qty, String productSize, String productSweetLevel, String productType) {
        System.out.println(product.getName() + " " + qty);
        for (BuyProductable s : subscribers) {
            s.buy(product, qty, productSize , productSweetLevel , productType );
        }
    }
}
