/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.MaterialUserImportDao;
import com.mycompany.project_alpabet_crud.model.MaterialUserImport;
import java.util.List;

/**
 *
 * @author teeraphat
 */
public class MaterialUserImportService {
    public List<MaterialUserImport> getMaterial(){
        MaterialUserImportDao materialUserImportDao = new MaterialUserImportDao();
        return materialUserImportDao.getAll(" material_import_id desc");
    }

    public MaterialUserImport addNew(MaterialUserImport editedMaterial) {
        MaterialUserImportDao materialUserImportDao = new MaterialUserImportDao();
        return materialUserImportDao.save(editedMaterial);
    }

}
