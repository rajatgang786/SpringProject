package com.musejam.controller.pricing;

import com.musejam.table.pricing.AddOn;
import com.musejam.service.pricing.AddOnsUpsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/musejam/")
public class AddOnsController {
    @Autowired
    AddOnsUpsertService addOnsUpsertService;

    //Insert
    @RequestMapping("/upsert")
   @PostMapping
    public void saveItem(@RequestBody AddOn addOn){
        addOnsUpsertService.storeItem(addOn);
    }

    //Delete
    @RequestMapping("/delete")
    @PostMapping
    public void delete(@RequestBody AddOn addOn){
        addOnsUpsertService.deleteItem(addOn);
    }
}
