/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;


import com.mycompany.project_alpabet_crud.dao.ProductDao;
import com.mycompany.project_alpabet_crud.model.Product;

import java.util.List;

/**
 *
 * @author werapan
 */
public class ProductService {
    public List<Product> getByName(String name){
        ProductDao prodcutDao = new ProductDao();
        return prodcutDao.getAll(" product_name asc");

    }
        public Product getById(int id){
    ProductDao productDao = new ProductDao();
    return productDao.get(id);
    }
    
    public List<Product> getProducts(){
        ProductDao productDao = new ProductDao();
        return productDao.getAll(" product_id asc");
    }

    public Product addNew(Product editedProduct) {
        ProductDao productDao = new ProductDao();
        return productDao.save(editedProduct);
    }

    public Product update(Product editedProduct) {
        ProductDao productDao = new ProductDao();
        return productDao.update(editedProduct);
    }

    public int delete(Product editedProduct) {
        ProductDao productDao = new ProductDao();
        return productDao.delete(editedProduct);
    }
    
}
