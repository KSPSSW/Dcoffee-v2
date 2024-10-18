/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.MaterialDao;
import com.mycompany.project_alpabet_crud.model.Material;
import java.util.List;

/**
 *
 * @author kissa
 */
public class MaterialService {
     public List<Material> getMaterial(){
        MaterialDao materialDao = new MaterialDao();
        return materialDao.getAll(" material_id asc");
    }
    
    public Material getUserImport(String name){
        MaterialDao materialDao = new MaterialDao();
        return materialDao.getByUserImport(name);
    }

    public Material addNew(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.save(editedMaterial);
    }

    public Material update(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.update(editedMaterial);
    }

    public int delete(Material  editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.delete(editedMaterial);
    }
}
