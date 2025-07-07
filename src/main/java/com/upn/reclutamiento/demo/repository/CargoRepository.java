package com.upn.reclutamiento.demo.repository;

import com.upn.reclutamiento.demo.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    Cargo findByNombre(String nombre);
}


