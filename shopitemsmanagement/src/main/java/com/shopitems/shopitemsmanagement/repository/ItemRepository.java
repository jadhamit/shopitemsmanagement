package com.shopitems.shopitemsmanagement.repository;

import com.shopitems.shopitemsmanagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
