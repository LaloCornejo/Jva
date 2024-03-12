package SchoolPOO.pck_Persona;

import javax.swing.JOptionPane;

public class PersonaTest {
  public static void main(String args[]){
    Persona persona = new Persona();

    persona.setCURP("COCJ021213HHGRLSA4");
    persona.setNombre("Jesus Eduardo");
    persona.setApellidoPaterno("Cornejo");
    persona.setApellidoMaterno("Clavel");
    persona.setFechaNacimiento( 13, 12, 2002 );

    System.out.println("CURP: " + persona.getCURP());
    System.out.println("Nombre: " + persona.getNombre());
    System.out.println("Apellido Paterno: " + persona.getApellidoPaterno());
    System.out.println("Apellido Materno: " + persona.getApellidoMaterno());
    System.out.println("Fecha de Nacimiento: " + persona.getFechaNacimiento());
    System.out.println("Sexo: " + persona.getSexo());

    System.out.println(persona.getDatos());

    JOptionPane.showMessageDialog(null, persona.getDatos(), "Datos de la Persona" , JOptionPane.PLAIN_MESSAGE);

  }
}
