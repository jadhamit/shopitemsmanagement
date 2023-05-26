package com.shopitems.shopitemsmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private BigDecimal price;

}
