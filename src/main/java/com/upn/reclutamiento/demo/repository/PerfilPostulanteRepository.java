// PerfilPostulanteRepository.java
package com.upn.reclutamiento.demo.repository;

import com.upn.reclutamiento.demo.model.PerfilPostulante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilPostulanteRepository extends JpaRepository<PerfilPostulante, Integer> {

    // Buscar el perfil postulante según el correo de su usuario relacionado
    PerfilPostulante findByUsuarioCorreo(String correo);
}