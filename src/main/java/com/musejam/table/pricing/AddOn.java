package com.musejam.table.pricing;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddOn {

    @Id
    Long id;

    @OneToOne(fetch = FetchType.EAGER)  //Lazy and Eager 1-1 mapping
    @JoinColumn    //Map with id
    ItemDetails itemDetails;
}
