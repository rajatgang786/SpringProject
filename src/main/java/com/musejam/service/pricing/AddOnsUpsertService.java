package com.musejam.service.pricing;

import com.musejam.dao.pricing.AddOnsDAO;
import com.musejam.table.pricing.AddOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AddOnsUpsertService {
    @Autowired
    AddOnsDAO addOnsDAO;

    public void storeItem(AddOn addOn)
    {
        addOnsDAO.save(addOn);
    }
    public void deleteItem(AddOn addOn){
        addOnsDAO.delete(addOn);
    }
}
