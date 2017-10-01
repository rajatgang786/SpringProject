package com.musejam.dao.pricing;

import com.musejam.table.pricing.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ItemMasterDAO extends JpaRepository<ItemDetails,Long> {

}
