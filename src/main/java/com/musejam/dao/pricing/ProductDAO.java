package com.musejam.dao.pricing;

import com.musejam.table.pricing.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product,Long> {
}
