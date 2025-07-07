package com.upn.reclutamiento.demo.controller;

import com.upn.reclutamiento.demo.model.Usuario;
import com.upn.reclutamiento.demo.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Muestra la vista login.html
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }
    
    

    // Procesa el formulario de login
    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo,
                                 @RequestParam String password,
                                 HttpSession session) {

        System.out.println("Intentando login con: " + correo);
        Usuario usuario = usuarioRepository.findByCorreo(correo);

        if (usuario != null && usuario.getPassword().equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            System.out.println("Login exitoso. Redirigiendo a /proyecto");
            return "redirect:/proyecto";
        } else {
            System.out.println("Login fallido. Redirigiendo a /login?error=true");
            return "redirect:/login?error=true";
        }
        
        
    }
    
    

    
    
}