package SchoolPOO.pck_estudiante;

import java.util.Scanner;

public class EstudiantTest {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int noCuenta, semestre, grupo;
            String nombre, programaEducativo;
            float promedioGeneral;

            Estuciante estudiante = new Estuciante();
            noCuenta = input.nextInt();
            estudiante.setNoCuenta(noCuenta);
            nombre = input.next();
            estudiante.setNombre(nombre);
            semestre = input.nextInt();
            estudiante.setSemestre(semestre);
            grupo = input.nextInt();
            estudiante.setGrupo(grupo);
            programaEducativo = input.next();
            estudiante.setProgrmaEducativo(programaEducativo);
            promedioGeneral = input.nextFloat();
            estudiante.setPromedioGeneral(promedioGeneral);
            

            System.out.printf("\n\n***** ESTUDIANTE *****\n" +
                "\nNo. Cuenta: %d\n" +
                "Nombre: %s\n" +
                "Semestre: %d\n" +
                "Grupo: %d\n" +
                "Programa Educativo: %s\n" +
                "Promedio General: %.2f\n\n",
                estudiante.getNoCuenta(),
                estudiante.getNombre(),
                estudiante.getSemestre(),
                estudiante.getGrupo(),
                estudiante.getProgramaEducativo(),
                estudiante.getPromedioGeneral()
            );

            System.out.println("Usando el método getDatos():");
            System.out.println(estudiante.getDatos());
        }
    }
}

//Jesus Eduardo Cornejo Clavel 3ro 1
