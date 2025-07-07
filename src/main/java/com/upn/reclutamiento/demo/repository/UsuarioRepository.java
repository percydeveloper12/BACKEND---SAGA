package com.upn.reclutamiento.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.upn.reclutamiento.demo.model.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByCorreo(String correo);
}
