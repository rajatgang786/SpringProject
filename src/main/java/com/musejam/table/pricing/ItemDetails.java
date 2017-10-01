package com.musejam.table.pricing;

import com.musejam.model.pricing.DiscountDetails;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetails {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Double price = 0D;
    @Transient
    Double sellingPrice = 0D;
    @NotNull
    String hsn;
    @Transient
    DiscountDetails discountDetails = new DiscountDetails();

}
