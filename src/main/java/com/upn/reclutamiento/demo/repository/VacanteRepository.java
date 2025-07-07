package com.upn.reclutamiento.demo.repository;

import com.upn.reclutamiento.demo.model.Vacante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanteRepository extends JpaRepository<Vacante, Long> {


    // Buscar por área
    List<Vacante> findByAreaContainingIgnoreCase(String area);

    // 🔴 Agrega este método también:
    List<Vacante> findByTituloContainingIgnoreCaseOrAreaContainingIgnoreCase(String titulo, String area);
    
    
}

