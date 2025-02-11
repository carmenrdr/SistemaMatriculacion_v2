package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import java.util.ArrayList;
import java.util.List;

public class Alumnos {

    private List<Alumno> coleccionAlumnos = new ArrayList<>();

    public Alumnos(){
        this.coleccionAlumnos = new ArrayList<>();
    }

    public List<Alumno> get(){
        return copiaProfundaAlumnos(coleccionAlumnos);
    }

    private static List<Alumno> copiaProfundaAlumnos(List<Alumno> coleccionAlumnos){
        List<Alumno> coleccionAux = new ArrayList<>();

        for (Alumno alumno : coleccionAlumnos) {
            coleccionAux.add(new Alumno(alumno));
        }

        return coleccionAux;
    }

    public int getTamano(){
        return coleccionAlumnos.size();
    }

    public void insertar(Alumno alumno) throws Exception {
        if (alumno == null){
            throw new IllegalArgumentException("ERROR: No se puede insertar un alumno nulo.");
        } else if (buscar(alumno) != null) {
            throw new IllegalArgumentException("ERROR: Ya existe un alumno con ese dni.");
        } else {
            coleccionAlumnos.add(alumno);
        }
    }

    public Alumno buscar(Alumno alumno){
        int indice = -1;
        boolean encontrado = false;

        for (int i=0; i < coleccionAlumnos.size() && !encontrado; i++) {
            if (coleccionAlumnos.get(i) != null && coleccionAlumnos.get(i).equals(alumno)) {
                indice = i;
                encontrado = true;
            }
        }
        return new Alumno(coleccionAlumnos.get(indice));
    }

    public void borrar(Alumno alumno) throws Exception {
        if (alumno == null){
            throw new IllegalArgumentException("ERROR: No se puede borrar un alumno nulo.");
        }

        if (!coleccionAlumnos.remove(alumno)) {
            throw new IllegalArgumentException("ERROR: El alumno no existe.");
        }
    }

}
