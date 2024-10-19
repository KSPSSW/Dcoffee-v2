/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project_alpabet_crud.component;

import com.mycompany.project_alpabet_crud.model.Product;

/**
 *
 * @author thana
 */
public interface BuyProductable {
    public void  buy(Product product, int qty , String productSize , String productSweetLevel , String productType);
}
