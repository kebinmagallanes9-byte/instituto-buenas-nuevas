package com.iglesia.institutobiblico.repository;

import com.iglesia.institutobiblico.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    // Buscar alumno por cédula
    Optional<Alumno> findByCedula(String cedula);

    // Buscar alumnos activos
    List<Alumno> findByActivoTrue();

    // Buscar alumnos por nombre o apellido
    List<Alumno> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    // Verificar si existe un alumno con la cédula
    boolean existsByCedula(String cedula);
}