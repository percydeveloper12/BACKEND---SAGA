package com.upn.reclutamiento.demo.controller;

import com.upn.reclutamiento.demo.model.Postulacion;
import com.upn.reclutamiento.demo.repository.PostulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private PostulacionRepository postulacionRepository;

    @GetMapping("/dashboard")
    public String mostrarDashboard(Model model) {
        List<Postulacion> postulaciones = postulacionRepository.findAll();

        Map<String, Long> conteo = postulaciones.stream()
            .collect(Collectors.groupingBy(
                p -> p.getVacante().getTitulo(), 
                Collectors.counting()
            ));

        model.addAttribute("postulaciones", postulaciones);
        model.addAttribute("labels", new ArrayList<>(conteo.keySet()));
        model.addAttribute("datos", new ArrayList<>(conteo.values()));

        return "dashboard"; // este es el nombre del HTML: dashboard.html
    }
}
