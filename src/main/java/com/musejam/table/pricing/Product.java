package com.musejam.table.pricing;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product  {
    @Id
    @GeneratedValue
    Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  //Eager and Lazy
    @JoinColumn(name="item_master")
    ItemDetails itemDetails;


}
