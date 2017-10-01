package com.musejam.table.taxation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class GST {

    @Id
    @GeneratedValue
    Long id;
    @NotNull
    String hsn;

    Double cgstPercentage= 0D;
    Double utgstPercentage= 0D;
    Double igstPercentage= 0D;
    Double sgstPercentage= 0D;

    @Transient
    Double CGST =0D;
    @Transient
    Double SGST = 0D;
    @Transient
    Double IGST = 0D;
    @Transient
    Double UTGST = 0D;
    @Transient
    Double total = 0D;
}
