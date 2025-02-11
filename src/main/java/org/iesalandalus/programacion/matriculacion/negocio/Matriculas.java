package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;
import java.util.ArrayList;
import java.util.List;

public class Matriculas {

    private final List<Matricula> coleccionMatriculas;

    public Matriculas(){
        this.coleccionMatriculas = new ArrayList<>();
    }

    public List<Matricula> get(){
        return copiaProfundaMatricula(coleccionMatriculas);
    }

    private static List<Matricula> copiaProfundaMatricula(List<Matricula> coleccionMatriculas){
        List<Matricula> coleccionAux = new ArrayList<>();

        for (Matricula matricula : coleccionMatriculas) {
            coleccionAux.add(new Matricula(matricula));
        }

        return coleccionAux;
    }

    public int getTamano(){
        return coleccionMatriculas.size();
    }

    public void insertar(Matricula matricula) throws Exception {
        if (matricula == null){
            throw new IllegalArgumentException("ERROR: No se puede insertar una matricula nula.");
        } else if (buscar(matricula) != null) {
            throw new IllegalArgumentException("ERROR: Ya existe una matrícula con ese identificador.");
        } else {
            coleccionMatriculas.add(matricula);
        }
    }

    public Matricula buscar(Matricula matricula){
        int indice = -1;
        boolean encontrado = false;

        for (int i=0; i < coleccionMatriculas.size() && !encontrado; i++) {
            if (coleccionMatriculas.get(i) != null && coleccionMatriculas.get(i).equals(matricula)) {
                indice = i;
                encontrado = true;
            }
        }

        if (!encontrado) {
            throw new IllegalArgumentException("ERROR: No existe esta matrícula");
        } else {
            return new Matricula(coleccionMatriculas.get(indice));
        }
    }

    public void borrar(Matricula matricula) throws Exception {
        if (matricula == null){
            throw new IllegalArgumentException("ERROR: No se puede borrar una matrícula nula.");
        }

        if(!coleccionMatriculas.remove(matricula)) {
            throw new IllegalArgumentException("ERROR: La matricula a borrar no existe.");
        }
    }

    public List<Matricula> get(Alumno alumno) throws Exception {
        if (alumno==null){
            throw new IllegalArgumentException("ERROR: El alumno no puede ser nulo.");
        }

        List<Matricula> resultado = new ArrayList<>();

        for (Matricula matricula : coleccionMatriculas) {
            if (matricula.getAlumno().equals(alumno)) {
                resultado.add(matricula);
            }
        }

        return resultado;
    }

    public List<Matricula> get(String cursoAcademico) throws Exception {
        if (cursoAcademico==null){
            throw new IllegalArgumentException("ERROR: El curso académico no puede ser nulo.");
        }

        List<Matricula> resultado = new ArrayList<>();

        for (Matricula matricula : coleccionMatriculas) {
            if (matricula.getCursoAcademico().equals(cursoAcademico)) {
                resultado.add(matricula);
            }
        }

        return resultado;
    }

    public List<Matricula> get(CicloFormativo cicloFormativo) throws Exception {
        if (cicloFormativo==null) {
            throw new IllegalArgumentException("ERROR: El ciclo formativo no puede ser nulo.");
        }

        List<Matricula> resultado = new ArrayList<>();

        for (Matricula matricula : coleccionMatriculas) {
            boolean matriculasAsociadas = false;

            for (Asignatura asignatura : matricula.getColeccionAsignaturas()) {
                if (asignatura.getCicloFormativo().equals(cicloFormativo)) {
                    matriculasAsociadas = true;
                    break;
                }
            }

            if (matriculasAsociadas) {
                resultado.add(matricula);
            }
        }

        return resultado;
    }

}
