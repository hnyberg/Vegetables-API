package com.hannesnyberg.vegetableAPI.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetableDAO extends JpaRepository <Vegetable, Long> {
}
