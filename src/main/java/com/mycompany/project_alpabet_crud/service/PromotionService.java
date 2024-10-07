/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.PromotionDao;
import com.mycompany.project_alpabet_crud.model.Promotion;
import java.util.List;

/**
 *
 * @author werapan
 */
public class PromotionService {
    
    public Promotion getByName(String name) {
        PromotionDao promotionDao = new PromotionDao();
        Promotion promotion = promotionDao.getByName(name);
        return promotion;
    }
    
    public List<Promotion> getPromotions(){
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.getAll(" promotion_id asc");
    }

    public Promotion addNew(Promotion editedPromotion) {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.save(editedPromotion);
    }

    public Promotion update(Promotion editedPromotion) {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.update(editedPromotion);
    }

    public int delete(Promotion editedPromotion) {
        PromotionDao promotionDao = new PromotionDao();
        return promotionDao.delete(editedPromotion);
    }
  
}
