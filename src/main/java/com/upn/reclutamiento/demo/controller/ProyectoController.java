package com.upn.reclutamiento.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import com.upn.reclutamiento.demo.model.Usuario;
import com.upn.reclutamiento.demo.model.Vacante;
import com.upn.reclutamiento.demo.repository.VacanteRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProyectoController {

    private final VacanteRepository vacanteRepository;

    public ProyectoController(VacanteRepository vacanteRepository) {
        this.vacanteRepository = vacanteRepository;
    }
    
    
    @GetMapping("/proyecto")
    public String mostrarVacantes(@RequestParam(name = "busqueda", required = false) String busqueda,
                                   Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario != null) {
            model.addAttribute("nombreUsuario", usuario.getNombreUsuario());
        }

        List<Vacante> vacantes;

        if (busqueda != null && !busqueda.isEmpty()) {
            vacantes = vacanteRepository.findByTituloContainingIgnoreCaseOrAreaContainingIgnoreCase(busqueda, busqueda);
        } else {
            vacantes = vacanteRepository.findAll();
        }

        model.addAttribute("vacantes", vacantes);
        return "proyecto";
    }


    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/login"; 
    }
    
    @GetMapping("/perfil")
    public String mostrarPerfil(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario.getNombreUsuario());

        if (usuario.getPerfilPostulante() != null) {
            model.addAttribute("nombre", usuario.getPerfilPostulante().getNombre());
            model.addAttribute("apellido", usuario.getPerfilPostulante().getApellido());
            model.addAttribute("dni", usuario.getPerfilPostulante().getDni());
            model.addAttribute("cv", usuario.getPerfilPostulante().getCv());
        } else {
            model.addAttribute("nombre", "No registrado");
            model.addAttribute("apellido", "No registrado");
            model.addAttribute("dni", "No registrado");
            model.addAttribute("cv", "No registrado");
        }

        return "perfil";
    }
    
    








    
}