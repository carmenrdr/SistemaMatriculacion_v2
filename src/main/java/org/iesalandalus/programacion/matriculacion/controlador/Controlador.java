package org.iesalandalus.programacion.matriculacion.controlador;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.modelo.Modelo;
import org.iesalandalus.programacion.matriculacion.vista.Vista;

import java.util.List;

public class Controlador {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Modelo modelo, Vista vista) {
        if (modelo == null) {
            throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
        }

        if (vista == null) {
            throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");
        }

        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void comenzar() throws Exception {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Le damos la bienvenida al sistema de matriculación del instituto IES Al-Ándalus.");
        System.out.println("--------------------------------------------------------------------------------");

        vista.comenzar();
    }

    public void terminar() {
        modelo.terminar();
    }

    public void insertar(Alumno alumno) throws Exception {
        modelo.insertar(alumno);
    }

    public Alumno buscar(Alumno alumno) {
        return modelo.buscar(alumno);
    }

    public void borrar(Alumno alumno) throws Exception {
        modelo.borrar(alumno);
    }

    public List<Alumno> getAlumnos() {
        return modelo.getAlumnos();
    }

    public void insertar(Asignatura asignatura) throws Exception {
        modelo.insertar(asignatura);
    }

    public Asignatura buscar(Asignatura asignatura) {
        return modelo.buscar(asignatura);
    }

    public void borrar(Asignatura asignatura) throws Exception {
        modelo.borrar(asignatura);
    }

    public List<Asignatura> getAsignaturas() {
        return modelo.getAsignaturas();
    }

    public void insertar(CicloFormativo cicloFormativo) throws Exception {
        modelo.insertar(cicloFormativo);
    }

    public CicloFormativo buscar(CicloFormativo cicloFormativo) {
        return modelo.buscar(cicloFormativo);
    }

    public void borrar(CicloFormativo cicloFormativo) throws Exception {
        modelo.borrar(cicloFormativo);
    }

    public List<CicloFormativo> getCiclosFormativos() {
        return modelo.getCiclosFormativos();
    }

    public void insertar(Matricula matricula) throws Exception {
        modelo.insertar(matricula);
    }

    public Matricula buscar(Matricula matricula) {
        return modelo.buscar(matricula);
    }

    public void borrar(Matricula matricula) throws Exception {
        modelo.borrar(matricula);
    }

    public List<Matricula> getMatriculas() {
        return modelo.getMatriculas();
    }

    public List<Matricula> getMatriculas(Alumno alumno) throws Exception {
        return modelo.getMatriculas(alumno);
    }

    public List<Matricula> getMatriculas(CicloFormativo cicloFormativo) throws Exception {
        return modelo.getMatriculas(cicloFormativo);
    }

    public List<Matricula> getMatriculas(String cursoAcademico) throws Exception {
        return modelo.getMatriculas(cursoAcademico);
    }

}
