package com.upn.reclutamiento.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AreaController {

    @GetMapping("/area/{nombre}")
    public String verDetalleArea(@PathVariable String nombre, Model model) {
        switch (nombre.toLowerCase()) {
            case "rrhh":
                model.addAttribute("titulo", "Convocatoria: PRAC N° 004-2025 – UGEL 3");
                model.addAttribute("puesto", "Practicante profesional para el área de Recursos Humanos");
                model.addAttribute("vacantes", 2);
                model.addAttribute("modalidad", "Prácticas profesionales");
                model.addAttribute("ubicacion", "Av. Iquitos N° 918, La Victoria");
                model.addAttribute("subvencion", "S/. 1,130.00 soles mensuales");
                model.addAttribute("fechaLimite", "07 de julio de 2025");
                model.addAttribute("requisitos", List.of(
                        "Ser egresado de la carrera de Derecho",
                        "Tener interés en la gestión pública y desarrollo de capacidades"
                ));
                model.addAttribute("actividades", List.of(
                        "Apoyo en la coordinación de asistencias técnicas",
                        "Registro y sistematización de datos sobre modalidades formativas",
                        "Generación de insumos para la mejora continua",
                        "Difusión de actividades del área",
                        "Otras funciones asignadas por el equipo de capacitación"
                ));
                model.addAttribute("vacanteId", 1L); // 👈 ID real de la vacante en la base de datos
                break;

            case "marketing":
                model.addAttribute("titulo", "Convocatoria: MKT N° 009-2025 – Campaña Digital");
                model.addAttribute("puesto", "Analista de Marketing Digital");
                model.addAttribute("vacantes", 1);
                model.addAttribute("modalidad", "Contratación temporal");
                model.addAttribute("ubicacion", "Sede Central – San Isidro");
                model.addAttribute("subvencion", "S/. 3,200.00 soles mensuales");
                model.addAttribute("fechaLimite", "10 de julio de 2025");
                model.addAttribute("requisitos", List.of(
                        "Egresado o bachiller en Marketing, Publicidad o Comunicación",
                        "Conocimientos en campañas de Google Ads y Meta Business",
                        "Manejo de herramientas de análisis como Google Analytics"
                ));
                model.addAttribute("actividades", List.of(
                        "Planificación de campañas digitales en redes sociales",
                        "Análisis de métricas y optimización de estrategias",
                        "Redacción de contenido para blogs y anuncios",
                        "Apoyo en lanzamientos de productos",
                        "Coordinación con agencias externas"
                ));
                model.addAttribute("vacanteId", 2L); // 👈 ID real de la vacante en la base de datos
                break;

            case "sistemas":
                model.addAttribute("titulo", "Convocatoria: SYS N° 015-2025 – TI Corporativa");
                model.addAttribute("puesto", "Desarrollador Backend Java");
                model.addAttribute("vacantes", 3);
                model.addAttribute("modalidad", "Tiempo completo");
                model.addAttribute("ubicacion", "Remoto o híbrido desde Lima");
                model.addAttribute("subvencion", "S/. 4,500.00 soles mensuales");
                model.addAttribute("fechaLimite", "15 de julio de 2025");
                model.addAttribute("requisitos", List.of(
                        "Egresado de Ingeniería de Sistemas o afines",
                        "Experiencia con Java y Spring Boot",
                        "Conocimiento en bases de datos SQL y APIs REST"
                ));
                model.addAttribute("actividades", List.of(
                        "Desarrollo de funcionalidades en el backend",
                        "Mantenimiento y refactorización de código existente",
                        "Integración de servicios externos vía API",
                        "Control de versiones con Git",
                        "Soporte técnico a usuarios internos"
                ));
                model.addAttribute("vacanteId", 3L); // 👈 ID real de la vacante en la base de datos
                break;

            case "logística":
                model.addAttribute("titulo", "Convocatoria: LOG N° 021-2025 – Operaciones");
                model.addAttribute("puesto", "Asistente de Logística y Almacén");
                model.addAttribute("vacantes", 2);
                model.addAttribute("modalidad", "Tiempo completo");
                model.addAttribute("ubicacion", "Centro de Distribución – Lurín");
                model.addAttribute("subvencion", "S/. 2,100.00 soles mensuales");
                model.addAttribute("fechaLimite", "12 de julio de 2025");
                model.addAttribute("requisitos", List.of(
                        "Egresado en Ingeniería Industrial, Administración o Logística",
                        "Manejo de Excel y sistemas ERP",
                        "Capacidad para trabajo bajo presión"
                ));
                model.addAttribute("actividades", List.of(
                        "Registro de ingreso y salida de productos",
                        "Apoyo en inventarios físicos y digitales",
                        "Coordinación con proveedores y transporte",
                        "Revisión de guías y facturas",
                        "Mejora continua de procesos logísticos"
                ));
                model.addAttribute("vacanteId", 4L); // 👈 ID real de la vacante en la base de datos
                break;

            default:
                return "area-no-encontrada";
        }

        return "detalle-area";
    }
}
