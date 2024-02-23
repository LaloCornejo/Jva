package SchoolPOO.pck_estudiante;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class EstudiantTest {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int noCuenta, semestre, grupo;
            String nombre, programaEducativo;
            float promedioGeneral;

            Estudiante estudiante = new Estudiante();
            noCuenta = input.nextInt();
            estudiante.setNoCuenta(noCuenta);
            nombre = input.next();
            estudiante.setNombre(nombre);
            semestre = input.nextInt();
            estudiante.setSemestre(semestre);
            grupo = input.nextInt();
            estudiante.setGrupo(grupo);
            programaEducativo = input.next();
            estudiante.setProgramaEducativo(programaEducativo);
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

            Estudiante estu2 = new Estudiante();

            estu2.setNoCuenta(Integer.parseInt(JOptionPane.showInputDialog("ID: ", "3000")));
            estu2.setNombre(JOptionPane.showInputDialog("Nombre: ", "Juanito"));
            estu2.setSemestre(Integer.parseInt(JOptionPane.showInputDialog("Semestre: ", "3")));
            estu2.setGrupo(Integer.parseInt(JOptionPane.showInputDialog("Grupo: ", "1")));
            estu2.setProgramaEducativo(JOptionPane.showInputDialog("Programa Educativo: ", "Ingeniería en Sistemas Computacionales"));
            estu2.setPromedioGeneral(Float.parseFloat(JOptionPane.showInputDialog("Promedio General: ", "9.5")));

            String info = String.format("Nombre: %s\nNum. Cuenta: %d\nSemestre: %d\nGrupo: %d\nPrograma: %s\nPromedio: %f", estudiante.getNombre(), estudiante.getNoCuenta(), estudiante.getSemestre(), estudiante.getGrupo(), estudiante.getProgramaEducativo(), estudiante.getPromedioGeneral());

            JOptionPane.showMessageDialog(null, info, "info", JOptionPane.PLAIN_MESSAGE);

            JOptionPane.showMessageDialog(null, estudiante.getDatos());

            System.out.println("Usando el método getDatos():");
            System.out.println(info);
            System.out.println(estudiante.getDatos());
        }
    }
}

//Jesus Eduardo Cornejo Clavel 3ro 1
