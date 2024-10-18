/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.mycompany.project_alpabet_crud.model.Stock;
import com.mycompany.project_alpabet_crud.service.StockService;

/**
 *
 * @author kissa
 */
public class TestStockService {
    public static void main(String[] args) {
        StockService stockService = new StockService();
        for(Stock stock :stockService.getStock()){
            System.out.println(stock);
        }
        System.out.println(stockService.getById(1));
    }
}
