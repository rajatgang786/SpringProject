package com.musejam.service.pricing;

import com.musejam.dao.pricing.ItemMasterDAO;
import com.musejam.table.pricing.ItemDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ItemMasterUpsertService {

    @Autowired
    ItemMasterDAO itemMasterDAO;

    public void storeItem(ItemDetails itemDetails){
        itemMasterDAO.save(itemDetails);
    }


    public void deleteteItem(ItemDetails itemDetails){
        itemMasterDAO.delete(itemDetails);
    }
}
