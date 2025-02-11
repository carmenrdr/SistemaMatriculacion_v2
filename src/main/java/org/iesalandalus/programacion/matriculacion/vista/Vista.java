package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;


public class Vista {

    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new IllegalArgumentException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }

    public void comenzar() throws Exception {

        Opcion opcionElegida;

        do {
            Consola.mostrarMenu();
            opcionElegida = Consola.elegirOpcion();
            ejecutarOpcion(opcionElegida);
        } while (opcionElegida != Opcion.SALIR);

        terminar();
    }

    public void terminar() {
        controlador.terminar();
    }

    private void ejecutarOpcion(Opcion opcion) throws Exception {

        switch (opcion) {
            case INSERTAR_ALUMNO:
                try {
                    insertarAlumno();
                } catch (Exception e) {
                    throw new IllegalArgumentException("EEROR: " + e.getMessage());
                }
                break;
            case BUSCAR_ALUMNO:
                try {
                    buscarAlumno();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case BORRAR_ALUMNO:
                try {
                    borrarAlumno();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case MOSTRAR_ALUMNOS:
                try {
                    mostrarAlumnos();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case INSERTAR_ASIGNATURA:
                try {
                    insertarAsignatura();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case BUSCAR_ASIGNATURA:
                try {
                    buscarAsignatura();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case BORRAR_ASIGNATURA:
                try {
                    borrarAsignatura();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case MOSTRAR_ASIGNATURAS:
                try {
                    mostrarAsignaturas();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case INSERTAR_CICLO_FORMATIVO:
                try {
                    insertarCicloFormativo();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case BUSCAR_CICLO_FORMATIVO:
                try {
                    buscarCicloFormativo();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case BORRAR_CICLO_FORMATIVO:
                try {
                    borrarCicloFormativo();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case MOSTRAR_CICLOS_FORMATIVOS:
                try {
                    mostrarCiclosFormativos();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case INSERTAR_MATRICULA:
                try {
                    insertarMatricula();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case BUSCAR_MATRICULA:
                try {
                    buscarMatricula();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case ANULAR_MATRICULA:
                try {
                    anularMatricula();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case MOSTRAR_MATRICULAS:
                try {
                    mostrarMatriculas();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case MOSTRAR_MATRICULAS_ALUMNO:
                try {
                    mostrarMatriculasPorAlumno();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case MOSTRAR_MATRICULAS_CICLO_FORMATIVO:
                try {
                    mostrarMatriculasPorCicloFormativo();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
            case MOSTRAR_MATRICULAS_CURSO_ACADEMICO:
                try {
                    mostrarMatriculasPorCursoAcademico();
                } catch (Exception e) {
                    throw new IllegalArgumentException("ERROR: " + e.getMessage());
                }
                break;
        }
    }

    private void insertarAlumno() throws Exception {
        Alumno alumnoNuevo = new Alumno(Consola.leerAlumno());

        try {
            controlador.insertar(alumnoNuevo);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void buscarAlumno() {
        Alumno alumnoABuscar = new Alumno(Consola.getAlumnoPorDni());
        Alumno alumnoEncontrado = controlador.buscar(alumnoABuscar);

        if (alumnoEncontrado != null) {
            System.out.println(alumnoEncontrado);
        } else {
            System.out.println("No existe ningún/a alumno/a con este DNI.");
        }

    }

    private void borrarAlumno() throws Exception {
        Alumno alumnoABuscar = new Alumno(Consola.getAlumnoPorDni());
        Alumno alumnoEncontrado = controlador.buscar(alumnoABuscar);

        try {
            if (alumnoEncontrado != null) {
                controlador.borrar(alumnoEncontrado);
            } else {
                System.out.println("No existe ningún/a alumno/a con este DNI.");
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    private void mostrarAlumnos() {
        List<Alumno> alumnos = controlador.getAlumnos();

        Comparator<Alumno> comparadorAlumnos = Comparator.comparing(Alumno :: getNombre);

        if (alumnos == null) {
            System.out.println("No hay alumnos/as almacenados.");
        } else {
            System.out.println("Los alumnos y alumnas registradas son:");
            alumnos.sort(comparadorAlumnos);
            alumnos.forEach(System.out :: println);
        }
    }

    private void insertarAsignatura() throws Exception {
        Asignatura asignaturaNueva = new Asignatura(Consola.leerAsignatura());

        try {
            controlador.insertar(asignaturaNueva);
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    private void buscarAsignatura() throws Exception {
        Asignatura asignaturaABuscar = new Asignatura(Consola.getAsignaturaPorCodigo());
        Asignatura asignaturaEncontrada = controlador.buscar(asignaturaABuscar);

        if (asignaturaEncontrada != null) {
            System.out.println(asignaturaEncontrada);
        } else {
            System.out.println("No existe asignatura con este código.");
        }
    }

    private void borrarAsignatura() throws Exception {
        Asignatura asignaturaABuscar = new Asignatura(Consola.getAsignaturaPorCodigo());
        Asignatura asignaturaEncontrada = controlador.buscar(asignaturaABuscar);

        try {
            if (asignaturaEncontrada != null) {
                controlador.borrar(asignaturaEncontrada);
            } else {
                System.out.println("No existe asignatura con este código.");
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    private void mostrarAsignaturas() {
        List<Asignatura> asignaturas = controlador.getAsignaturas();

        Comparator<Asignatura> comparadorAsignaturas = Comparator.comparing(Asignatura :: getNombre);

        if (asignaturas == null) {
            System.out.println("No hay asginaturas almacenadas.");
        } else {
            asignaturas.sort(comparadorAsignaturas);
            Consola.mostrarAsignaturas(asignaturas);
        }
    }

    private void insertarCicloFormativo() throws Exception {
        CicloFormativo cicloFormativoNuevo = new CicloFormativo(Consola.leerCicloFormativo());

        try {
            controlador.insertar(cicloFormativoNuevo);
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    private void buscarCicloFormativo() {
        CicloFormativo cicloFormativoABuscar = new CicloFormativo(Consola.getCicloFormativoPorCodigo());
        CicloFormativo cicloFormativoEncontrado = controlador.buscar(cicloFormativoABuscar);

        if (cicloFormativoEncontrado != null) {
            System.out.println(cicloFormativoEncontrado);
        } else {
            System.out.println("No existe Ciclo Foramtivo con este código.");
        }
    }

    private void borrarCicloFormativo() throws Exception {
        CicloFormativo cicloFormativoABuscar = new CicloFormativo(Consola.getCicloFormativoPorCodigo());
        CicloFormativo cicloFormativoEncontrado = controlador.buscar(cicloFormativoABuscar);

        try {
            if (cicloFormativoEncontrado != null) {
                controlador.borrar(cicloFormativoEncontrado);
            } else {
                System.out.println("No existe Ciclo Foramtivo con este código.");
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    private void mostrarCiclosFormativos() {
        List<CicloFormativo> ciclosFormativos = controlador.getCiclosFormativos();

        Comparator<CicloFormativo> comparadorCiclos = Comparator.comparing(CicloFormativo :: getNombre);

        if (ciclosFormativos == null) {
            System.out.println("No existen Ciclos Formativos registrados.");
        } else {
            ciclosFormativos.sort(comparadorCiclos);
            Consola.mostrarCiclosFormativos(ciclosFormativos);
        }
    }

    private void insertarMatricula() throws Exception {
        Alumno alumno = Consola.leerAlumno();
        List<Asignatura> asignaturas = controlador.getAsignaturas();
        List<Asignatura> asignaturasElegidas = Consola.elegirAsignaturasMatricula(asignaturas);

        Matricula matriculaNueva = Consola.leerMatricula(alumno, asignaturasElegidas);
        controlador.insertar(matriculaNueva);

    }

    private void buscarMatricula() throws Exception {
        Matricula matriculaABuscar = new Matricula(Consola.getMatriculaPorIdentificador());
        Matricula matriculaEncontrada = controlador.buscar(matriculaABuscar);


        if (matriculaEncontrada != null) {
            System.out.println(matriculaEncontrada);
        } else {
            System.out.println("No existe matrícula con este identificador.");
        }
    }

    private void anularMatricula() throws Exception {
        mostrarMatriculas();

        Matricula matriculaABuscar = Consola.getMatriculaPorIdentificador();
        Matricula matriculaEncontrada = controlador.buscar(matriculaABuscar);

        System.out.println("Introduzca la fecha de anulación:");
        String fecha = Entrada.cadena();

        LocalDate fechaAnulacion = Consola.leerFecha(fecha);

        matriculaEncontrada.setFechaAnulacion(fechaAnulacion);

    }

    private void mostrarMatriculas() {
        List<Matricula> matriculas = controlador.getMatriculas();

        Comparator<Alumno> comparadorAlumnos = Comparator.comparing(Alumno :: getNombre);
        Comparator<Matricula> comparadorMatriculas = Comparator.comparing(Matricula :: getFechaMatriculacion).reversed().thenComparing(Matricula :: getAlumno, comparadorAlumnos);

        if (matriculas == null) {
            System.out.println("No hay matrículas registradas.");
        } else {
            System.out.println("Las matrículas registradas son:");
            matriculas.sort(comparadorMatriculas);
            matriculas.forEach(System.out::println);
        }
    }

    private void mostrarMatriculasPorAlumno() throws Exception {
        mostrarAlumnos();
        Alumno alumnoABuscar = new Alumno(Consola.getAlumnoPorDni());
        Alumno alumnoEncontrado = controlador.buscar(alumnoABuscar);

        List<Matricula> matriculasPorAlumno = controlador.getMatriculas(alumnoEncontrado);

        Comparator<Matricula> comparadorMatriculasAlumno = Comparator.comparing(Matricula :: getFechaMatriculacion).reversed();

        if (matriculasPorAlumno.isEmpty()) {
            System.out.println("No hay matrículas de este/a alumno/a.");
        } else {
            System.out.println("Las matrículas de este alumno son:");
            matriculasPorAlumno.sort(comparadorMatriculasAlumno);
            matriculasPorAlumno.forEach(System.out::println);
        }
    }

    private void mostrarMatriculasPorCicloFormativo() throws Exception {
        mostrarCiclosFormativos();
        CicloFormativo cicloABuscar = new CicloFormativo(Consola.getCicloFormativoPorCodigo());
        CicloFormativo cicloEncontrado = controlador.buscar(cicloABuscar);

        List<Matricula> matriculasPorCiclos = controlador.getMatriculas(cicloEncontrado);

        Comparator<Alumno> comparadorAlumnos = Comparator.comparing(Alumno :: getNombre);
        Comparator<Matricula> comparadorMatriculasCiclo = Comparator.comparing(Matricula :: getFechaMatriculacion).reversed().thenComparing(Matricula :: getAlumno, comparadorAlumnos);


        if (matriculasPorCiclos.isEmpty()) {
            System.out.println("No hay matrículas de este Ciclo Formativo.");
        } else {
            System.out.println("Las matrículas de este Ciclo Formativo son:");
            matriculasPorCiclos.sort(comparadorMatriculasCiclo);
            matriculasPorCiclos.forEach(System.out::println);
        }
    }

    private void mostrarMatriculasPorCursoAcademico() throws Exception {
        Curso curso = Consola.leerCurso();
        String cursoElegido = curso.toString();

        List<Matricula> matriculasPorCursos = controlador.getMatriculas(cursoElegido);

        Comparator<Alumno> comparadorAlumnos = Comparator.comparing(Alumno :: getNombre);
        Comparator<Matricula> comparadorMatriculasCursos = Comparator.comparing(Matricula :: getFechaMatriculacion).reversed().thenComparing(Matricula :: getAlumno, comparadorAlumnos);


        if (matriculasPorCursos.isEmpty()) {
            System.out.println("No hay matrículas del curso elegido.");
        } else {
            System.out.println("Las matrículas de este curso son:");
            matriculasPorCursos.sort(comparadorMatriculasCursos);
            matriculasPorCursos.forEach(System.out::println);
        }
    }


}
