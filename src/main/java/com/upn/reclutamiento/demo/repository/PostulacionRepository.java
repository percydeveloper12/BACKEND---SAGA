package com.upn.reclutamiento.demo.repository;

import com.upn.reclutamiento.demo.model.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {
}
