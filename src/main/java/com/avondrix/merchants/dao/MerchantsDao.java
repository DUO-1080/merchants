package com.avondrix.merchants.dao;

import com.avondrix.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantsDao extends JpaRepository<Merchants, Integer> {
    Optional<Merchants> findById(Integer id);

    Merchants findByName(String name);
}
