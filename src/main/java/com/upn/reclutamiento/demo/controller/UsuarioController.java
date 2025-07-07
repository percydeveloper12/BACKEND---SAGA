package com.upn.reclutamiento.demo.controller;

import com.upn.reclutamiento.demo.dto.UsuarioPostulantedto;
import com.upn.reclutamiento.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfil_postulante")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioPostulantedto> listarPostulantes() {
        return usuarioService.obtenerPostulantes();
    }
}
