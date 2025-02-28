package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import javax.naming.OperationNotSupportedException;

public enum EspecialidadProfesorado {

    INFORMATICA("Informática"),
    SISTEMAS("Sistemas y Aplicaciones informáticas"),
    FOL("Formación y Orientación Laboral");
    private final String cadenaAMostrar;

    private EspecialidadProfesorado(String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    public String imprimir() throws OperationNotSupportedException {
        if (this == INFORMATICA) {
            return "0.-"+this.cadenaAMostrar;
        } else if (this == SISTEMAS) {
            return "1.-"+this.cadenaAMostrar;
        } else if (this == FOL) {
            return "2.-"+this.cadenaAMostrar;
        } else {
            throw new OperationNotSupportedException("ERROR: La especialidad del profesorado no es válida.");
        }
    }

    @Override
    public String toString() {
        return this.cadenaAMostrar;
    }
}
