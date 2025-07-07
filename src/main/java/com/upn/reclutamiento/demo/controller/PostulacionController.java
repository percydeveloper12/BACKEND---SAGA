package com.upn.reclutamiento.demo.controller;

import com.upn.reclutamiento.demo.model.Postulacion;
import com.upn.reclutamiento.demo.model.Usuario;
import com.upn.reclutamiento.demo.model.Vacante;
import com.upn.reclutamiento.demo.repository.PostulacionRepository;
import com.upn.reclutamiento.demo.repository.VacanteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <- ¡Importante!
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PostulacionController {

    @Autowired
    private PostulacionRepository postulacionRepository;

    @Autowired
    private VacanteRepository vacanteRepository;

    @PostMapping("/postular/{vacanteId}")
    public String postularAVacante(@PathVariable Long vacanteId, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null || usuario.getPerfilPostulante() == null) {
            return "redirect:/login";
        }

        Vacante vacante = vacanteRepository.findById(vacanteId).orElse(null);
        if (vacante == null) {
            return "redirect:/proyecto?error=VacanteNoEncontrada";
        }

        Postulacion postulacion = new Postulacion();
        postulacion.setPerfilPostulante(usuario.getPerfilPostulante());
        postulacion.setVacante(vacante);
        postulacion.setFechaPostulacion(LocalDate.now());
        postulacion.setEstado("En proceso");

        postulacionRepository.save(postulacion);

        return "redirect:/proyecto?success=postulacion";
    }

    
    @GetMapping("/postulaciones")
    public String listarPostulaciones(Model model) {
        List<Postulacion> postulaciones = postulacionRepository.findAll();
        model.addAttribute("postulaciones", postulaciones);
        return "postulaciones";
    }
    
    @GetMapping("/postulacion/aprobar/{id}")
    public String aprobarPostulacion(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        postulacionRepository.findById(id).ifPresent(p -> {
            p.setEstado("Aprobado");
            postulacionRepository.save(p);
        });
        redirectAttributes.addFlashAttribute("mensaje", "✅ Postulación aprobada exitosamente.");
        return "redirect:/dashboard";
    }

    @GetMapping("/postulacion/rechazar/{id}")
    public String rechazarPostulacion(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        postulacionRepository.findById(id).ifPresent(postulacionRepository::delete);
        redirectAttributes.addFlashAttribute("mensaje", "❌ Postulación rechazada y eliminada.");
        return "redirect:/dashboard";
    }

}
