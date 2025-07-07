package com.upn.reclutamiento.demo.controller;

import com.upn.reclutamiento.demo.dto.RegistroFormularioDTO;
import com.upn.reclutamiento.demo.model.Usuario;
import com.upn.reclutamiento.demo.repository.UsuarioRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormularioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/formulario-crear")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registro", new RegistroFormularioDTO());
        return "Formulariocrear";
    }


    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute("registro") RegistroFormularioDTO dto) {
        // Validaciones
        if (!dto.getPassword().equals(dto.getRepetirPassword())) {
            return "redirect:/formulario-crear?error=nomatch";
        }

        if (usuarioRepository.findByCorreo(dto.getCorreo()) != null) {
            return "redirect:/formulario-crear?error=correo";
        }

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(dto.getUsuario());
        usuario.setCorreo(dto.getCorreo());
        usuario.setPassword(dto.getPassword());

        usuarioRepository.save(usuario);
        
        System.out.println("Usuario registrado correctamente. Redirigiendo a /proyecto");
        return "redirect:/proyecto";
        
       
    }
    
   




}

