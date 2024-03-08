package SchoolPOO.pck_Biblioteca;

import javax.swing.JOptionPane;

public class MenuBiblioteca {
  public static void main(String args[]) {
    Libro[] Libros = new Libro[10];
    Revista[] Revistas = new Revista[10];
    String ref, titulo, autor, edit;
    int np, op, contL = 0, anio, numero, contR = 0;
    String infoLibros = null, infoRevistas = null;
    String menu = "==- MENU -=== \n " +
        "1. Ingresar libro\n" +
        "2. Ingresar revista\n" +
        "3. Mostrar libros\n" +
        "4. Mostrar revistas\n" +
        "5. Consultar detalle de Libro\n" +
        "6. Consultar detalle de Revista\n" +
        "7. Salir";
    do {
      do {
        try {
          op = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Error: Opción no valida ", "Error", JOptionPane.ERROR_MESSAGE);
          op = 0;
        }
      } while (op == 0);
      switch (op) {
        case 1:
          if (contL < 10) {
            do {
              try {
                ref = JOptionPane.showInputDialog("Ingrese la Referencia del libro");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                ref = null;
              }
            } while (ref == null);
            do {
              try {
                titulo = JOptionPane.showInputDialog("Ingrese el titulo del Libro: ");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                titulo = null;
              }
            } while (titulo == null);
            do {
              try {
                autor = JOptionPane.showInputDialog("Ingrese el autor del Libro: ");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                autor = null;
              }
            } while (autor == null);
            do {
              try {
                edit = JOptionPane.showInputDialog("Ingrese la editorial del Libro: ");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                edit = null;
              }
            } while (edit == null);
            do {
              try {
                np = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de paginas del Libro: "));
                if (np < 20) {
                  JOptionPane.showMessageDialog(null, "Error: No suficientes paginas", "Error",
                      JOptionPane.ERROR_MESSAGE);
                  np = 0;
                }
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ser un valor numérico");
                np = 0;
              }
            } while (np == 0);
            do {
              try {
                anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio de publicación del Libro: "));
                if (anio < 1900 || anio > 2024) {
                  JOptionPane.showMessageDialog(null, "Error: Anio no valido", "Error", JOptionPane.ERROR_MESSAGE);
                  anio = 0;
                }
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ser un valor numérico");
                anio = 0;
              }
            } while (anio == 0);

            Libros[contL] = new Libro(ref, titulo, autor, edit, np, anio);
            contL++;
          } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para mas libros", "Error", JOptionPane.ERROR_MESSAGE);
          }
          break;
        case 2:
          if (contR < 10) {
            do {
              try {
                ref = JOptionPane.showInputDialog("Ingrese la Referencia de la revista");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                ref = null;
              }
            } while (ref == null);
            do {
              try {
                titulo = JOptionPane.showInputDialog("Ingrese el titulo de la revista: ");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                titulo = null;
              }
            } while (titulo == null);
            do {
              try {
                anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio de publicación de la revista: "));
                if (anio < 1900 || anio > 2024) {
                  JOptionPane.showMessageDialog(null, "Error: Anio no valido", "Error", JOptionPane.ERROR_MESSAGE);
                  anio = 0;
                }
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ser numero");
                anio = 0;
              }
            } while (anio == 0);
            do {
              try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la revista: "));
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                numero = -1;
              }
            } while (numero == -1);
            Revistas[contR] = new Revista(ref, titulo, anio, numero);
            contR++;
          } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para mas revistas", "Error", JOptionPane.ERROR_MESSAGE);
          }
          break;
        case 3:
          if (contL <= 0) {
            JOptionPane.showMessageDialog(null, "No hay libros registrados", "Lista de Libros",
                JOptionPane.PLAIN_MESSAGE);
            break;
          } else {
            infoLibros = "Referencia\tTitulo\tAutor\tEditorial\n" +
                "--------------------------------------------------\n";
            for (int i = 0; i < contL; i++) {
              infoLibros = infoLibros + Libros[i].getReferencia() + "\t" + Libros[i].getTitulo() + "\t"
                  + Libros[i].getAutor() + "\t"
                  + Libros[i].getEditorial() + "\n";
            }
            JOptionPane.showMessageDialog(null, infoLibros, "Lista de Libros", JOptionPane.PLAIN_MESSAGE);
          }
          break;
        case 4:
          if (contR <= 0) {
            JOptionPane.showMessageDialog(null, "No hay revistas registradas", "Lista de Revistas",
                JOptionPane.PLAIN_MESSAGE);
            break;
          } else {
            infoRevistas = "Referencia\tTitulo\tAño\tNumero\n" +
                "--------------------------------------------------\n";
            for (int i = 0; i < contR; i++) {
              infoRevistas = infoRevistas + Revistas[i].getReferencia() + "\t" + Revistas[i].getTitulo() + "\t"
                  + Revistas[i].getAnioPublication() + "\t"
                  + Revistas[i].getNumero() + "\n";
            }
            JOptionPane.showMessageDialog(null, infoRevistas, "Lista de Revistas", JOptionPane.PLAIN_MESSAGE);
            break;
          }
        case 5:
          if (contL <= 0) {
            JOptionPane.showMessageDialog(null, "No hay libros registrados", "Lista de Libros",
                JOptionPane.PLAIN_MESSAGE);
          } else {
            do {
              try {
                ref = JOptionPane.showInputDialog("Ingrese la referencia del libro");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                ref = null;
              }
            } while (ref == null);
            for (int i = 0; i < contL; i++) {
              if (Libros[i].getReferencia().equals(ref)) {
                JOptionPane.showMessageDialog(null, Libros[i].getDatos(), "Detalle del libro",
                    JOptionPane.PLAIN_MESSAGE);
                break;
              }else if ( i == contL - 1 ){
                JOptionPane.showMessageDialog(null,"No existe ningún articulo con esa referencia" , "NULL", i);
              }            }
          }
          break;
        case 6:
          if (contR <= 0) {
            JOptionPane.showMessageDialog(null, "No hay revistas registradas", "Lista de Revistas",
                JOptionPane.PLAIN_MESSAGE);
          } else {
            do {
              try {
                ref = JOptionPane.showInputDialog("Ingrese la referencia de la revista");
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error");
                ref = null;
              }
            } while (ref == null);
            for (int i = 0; i < contR; i++) {
              if (Revistas[i].getReferencia().equals(ref)) {
                JOptionPane.showMessageDialog(null, Revistas[i].getDatos(), "Detalle de la revista",
                    JOptionPane.PLAIN_MESSAGE);
                break;
              }else if ( i == contR - 1 ){
                JOptionPane.showMessageDialog(null,"No existe ningún articulo con esa referencia" , "NULL", i);
              }
            }
          }
          break;
        case 7:
          JOptionPane.showMessageDialog(null, "Fin", "Fin", JOptionPane.INFORMATION_MESSAGE);
          break;

        default:
          break;
      }
    } while (op != 7);

  }
}
