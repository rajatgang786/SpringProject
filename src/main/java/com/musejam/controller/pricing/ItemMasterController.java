package com.musejam.controller.pricing;

import com.musejam.table.pricing.ItemDetails;
import com.musejam.service.pricing.ItemMasterUpsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musejam/item_master") //api and endpoint
public class ItemMasterController {
    @Autowired
    ItemMasterUpsertService itemMasterUpsertService;

    //Insert
    @RequestMapping("/upsert")
    @PostMapping
    public void saveItemMaster(@RequestBody ItemDetails itemDetails){
       itemMasterUpsertService.storeItem(itemDetails);
    }

    //Update
    @RequestMapping("/delete")
    @PostMapping
    public void deleteItemMaster(@RequestBody ItemDetails itemDetails){
        itemMasterUpsertService.deleteteItem(itemDetails);
    }

}
