package com.musejam.dao.pricing;

import com.musejam.table.pricing.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddOnsDAO extends JpaRepository<AddOn,Long> {
}
