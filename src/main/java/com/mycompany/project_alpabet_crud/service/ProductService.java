/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;


import com.mycompany.project_alpabet_crud.dao.ProductDao;
import com.mycompany.project_alpabet_crud.model.Product;

import java.util.ArrayList;

/**
 *
 * @author werapan
 */
public class ProductService {
    private ProductDao prodcutDao = new ProductDao();
    
    public ArrayList<Product> getProductsOrderByName(){
        return (ArrayList<Product>) prodcutDao.getAll("product_name ASC");

    }
    
}
