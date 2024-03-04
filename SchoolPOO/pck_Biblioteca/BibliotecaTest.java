package SchoolPOO.pck_Biblioteca;

import javax.swing.JOptionPane;

public class BibliotecaTest {
  public static void main(String args[]) {
    Libro lib = new Libro();
    lib.setReferencia("REF-001");
    lib.setTitulo("El principito");
    lib.setAutor("Antoine de Saint-Exupéry");
    lib.setEditorial("Reynal & Hitchcock");
    lib.setNoPaginas(96);
    lib.setAnioPublication(1943);
    System.out.println(lib.getDatos());
    JOptionPane.showMessageDialog(null, lib.getDatos(), "Libro", JOptionPane.INFORMATION_MESSAGE);

    Libro lib2 = new Libro("REF-002", "El arte de la guerra", "Sun Tzu", "Sunzi Bingfa Publishing", 100, 500);
    System.out.println(lib2.getDatos());
    JOptionPane.showMessageDialog(null, lib2.getDatos(), "Libro", JOptionPane.INFORMATION_MESSAGE);

    Revista rev = new Revista();
    rev.setReferencia("REF-003");
    rev.setTitulo("National Geographic");
    rev.setAnioPublication(2021);
    rev.setNumero(3);
    System.out.println(rev.getDatos());
    JOptionPane.showMessageDialog(null, rev.getDatos(), "Revista", JOptionPane.INFORMATION_MESSAGE);
    
  }
}
