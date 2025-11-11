package com.iglesia.institutobiblico.controller;

import com.iglesia.institutobiblico.entity.Alumno;
import com.iglesia.institutobiblico.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Página principal de alumnos
    @GetMapping
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoRepository.findByActivoTrue();
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("alumno", new Alumno());
        return "lista-alumnos";
    }

    // Guardar nuevo alumno
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {
        alumnoRepository.save(alumno);
        return "redirect:/alumnos";
    }

    // Mostrar formulario de edición (simplificado por ahora)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Alumno alumno = alumnoRepository.findById(id).orElse(new Alumno());
        model.addAttribute("alumno", alumno);
        return "editar-alumno";
    }

    // Eliminar alumno (soft delete)
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if (alumno != null) {
            alumno.setActivo(false);
            alumnoRepository.save(alumno);
        }
        return "redirect:/alumnos";
    }
}