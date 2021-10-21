package com.sparta.ml.northwindrest.repositories;

import com.sparta.ml.northwindrest.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer> {
}