package SchoolPOO.ExamenParcial2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Entretenimiento {
  public static void main(String[] args) {

    ArrayList<Articulo> articulosLista = new ArrayList<Articulo>();
    ArrayList<Suscriptor> suscriptoresLista = new ArrayList<Subscriptor>();
    ArrayList<Renta> rentasLista = new ArrayList<Renta>();

    int op;

    String menu = "------ Entretenimiento ------\n" +
    "1) Alta de una película\n" +
    "2) Alta de una serie\n" +
    "3) Alta de un suscriptor\n" +
    "4) Alta de una renta\n" +
    "5) Listar películas\n" +
    "6) Listar series\n" +
    "7) Listar suscriptores\n" +
    "8) Listar rentas\n" +
    "9) Ver detalle de una película\n" +
    "10) Ver detalle de una serie\n" +
    "11) Ver detalle de un suscriptor\n" +
    "12) Ver detalle de una renta\n" +
    "13) Eliminar una película\n" +
    "14) Eliminar una serie\n" +
    "15) Eliminar un suscriptor\n" +
    "16) Eliminar una renta\n" +
    "17) Salir\n" +
    "Ingrese una opción:";

    // JOptionPane.showMessageDialog(null, menu);
    do {
      op = mostrarMenu();
      switch (op) {
        case 1:
          agregarPeliciula(articulosLista);
          break;
        case 2:
          agregarSerie(articulosLista);
          break;
        case 3:
          agregarSubscriptor(subscriptoresLista);
          break;
        case 4:
          agregarRenta(rentasLista, articulosLista, subscriptoresLista);
          break;
        case 5:
          listarPeliculas(articulosLista);
          break;
        case 6:
          listarSeries(articulosLista);
          break;
        case 7:
          listarSubscriptores(subscriptoresLista);
          break;
        case 8:
          listarRentas(rentasLista);
          break;
        case 9:
          verDetallePelicula(articulosLista);
          break;
        case 10:
          verDetalleSerie(articulosLista);
          break;
        case 11:
          verDetalleSubscriptor(subscriptoresLista);
          break;
        case 12:
          verDetalleRenta(rentasLista);
          break;
        case 13:
          eliminarPelicula(articulosLista);
          break;
        case 14:
          eliminarSerie(articulosLista);
          break;
        case 15:
          eliminarSubscriptor(subscriptoresLista);
          break;
        case 16:
          eliminarRenta(rentasLista);
          break;
        case 17:
          JOptionPane.showMessageDialog(null, "Programa Creado por: LÆLÖ\n Espero pase la rubrica\n Bye :D");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opción no válida");
          break;
      }
    } while (op != 17);
  }

  private int mostrarMenu() {
    try {
      return Integer.parseInt(JOptionPane.showInputDialog(null, menu + "\nIngrese una opción: "));
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
      return -1;
    }
  }

  private void altaPelicula(ArrayList<Articulo> articulos) {
    int idArticulo, anio, duracion;
    String titulo, productor, genero, director, pais;
    double costo;
    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del artículo: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
      }
    } while (idArticulo == -1);

    do {
      try {
        titulo = JOptionPane.showInputDialog("Ingrese el título de la película: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        titulo = null;
      }
    } while (titulo == null);

    do {
      try {
        productor = JOptionPane.showInputDialog("Ingrese el productor de la película: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        productor = null;
      }
    } while (productor == null);

    do {
      try {
        anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de estreno de la película: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        anio = -1;
      }
    } while (anio == -1);

    do {
      try {
        duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración de la película: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        duracion = -1;
      }
    } while (duracion == -1);

    do {
      try {
        costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de la película: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        costo = -1;
      }
    } while (costo == -1);

    do {
      try {
        genero = JOptionPane.showInputDialog("Ingrese el género de la película: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        genero = null;
      }
    } while (genero == null);

    do {
      try {
        director = JOptionPane.showInputDialog("Ingrese el director de la película: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        director = null;
      }
    } while (director == null);

    do {
      try {
        pais = JOptionPane.showInputDialog("Ingrese el país de origen de la película: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        pais = null;
      }
    } while (pais == null);

    Pelicula pelicula = new Pelicula(idArticulo, titulo, productor, anio, duracion, costo, genero, director, pais);
    articulos.add(pelicula);
  }

  private void altaSerie(ArrayList<Articulo> articulos) {
    int idArticulo, anio, duracion, temporada, noCapitulos;
    String titulo, productor, categoria;
    double costo;
    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del artículo: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
      }
    } while (idArticulo == -1);

    do {
      try {
        titulo = JOptionPane.showInputDialog("Ingrese el título de la serie: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        titulo = null;
      }
    } while (titulo == null);

    do {
      try {
        productor = JOptionPane.showInputDialog("Ingrese el productor de la serie: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        productor = null;
      }
    } while (productor == null);

    do {
      try {
        anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de estreno de la serie: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        anio = -1;
      }
    } while (anio == -1);

    do {
      try {
        duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración de la serie: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        duracion = -1;
      }
    } while (duracion == -1);

    do {
      try {
        costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de la serie: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        costo = -1;
      }
    } while (costo == -1);

    do {
      try {
        categoria = JOptionPane.showInputDialog("Ingrese la categoría de la serie: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        categoria = null;
      }
    } while (categoria == null);

    do {
      try {
        temporada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la temporada de la serie: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        temporada = -1;
      }
    } while (temporada == -1);

    do {
      try {
        noCapitulos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de capítulos de la serie: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        noCapitulos = -1;
      }
    } while (noCapitulos == -1);

    Serie serie = new Serie(idArticulo, titulo, productor, anio, duracion, costo, categoria, temporada, noCapitulos);
    articulos.add(serie);
  }

  private void altaSubscriptor(ArrayList<Subscriptor> subscriptores) {
    String idSubscriptor, nombre, tipo, telefono, correoElectronico;
    Fecha fechaNacimiento = new Fecha();

    do {
      try {
        idSubscriptor = JOptionPane.showInputDialog("Ingrese el ID del subscriptor: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        idSubscriptor = null;
      }
    } while (idSubscriptor == null);

    do {
      try {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del subscriptor: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        nombre = null;
      }
    } while (nombre == null);

    do {
      try {
        tipo = JOptionPane.showInputDialog("Ingrese el tipo de subscriptor: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        tipo = null;
      }
    } while (tipo == null);

    do {
      try {
        telefono = JOptionPane.showInputDialog("Ingrese el teléfono del subscriptor: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        telefono = null;
      }
    } while (telefono == null);

    do {
      try {
        correoElectronico = JOptionPane.showInputDialog("Ingrese el correo electrónico del subscriptor: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        correoElectronico = null;
      }
    } while (correoElectronico == null);

    do {
      try {
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de nacimiento del subscriptor: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento del subscriptor: "));
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento del subscriptor: "));
        if (fechaNacimiento.fechaCorrecta()) {
          fechaNacimiento.setFecha(dia, mes, anio);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
      }
    } while (!fechaNacimiento.fechaCorrecta());

    Subscriptor subscriptor = new Subscriptor(idSubscriptor, nombre, direccion, telefono);
    subscriptores.add(subscriptor);
  }

  private void altaRenta(ArrayList<Renta> rentas, ArrayList<Articulo> articulos,
      ArrayList<Subscriptor> subscriptores) {
    int idRenta, idArticulo, idSubscriptor;
    Fecha fechaRenta = new Fecha();
    Fecha fechaVencimiento = new Fecha();

    do {
      try {
        idRenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la renta: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idRenta = -1;
      }
    } while (idRenta == -1);

    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del artículo: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
      }
    } while (idArticulo == -1);

    do {
      try {
        idSubscriptor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del subscriptor: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idSubscriptor = -1;
      }
    } while (idSubscriptor == -1);

    do {
      try {
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de renta: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de renta: "));
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de renta: "));
        if (fechaRenta.fechaCorrecta()) {
          fechaRenta.setFecha(dia, mes, anio);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
      }
    } while (!fechaRenta.fechaCorrecta());

    do {
      try {
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de vencimiento: "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de vencimiento: "));
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de vencimiento: "));
        if (fechaVencimiento.fechaCorrecta()) {
          fechaVencimiento.setFecha(dia, mes, anio);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
      }
    } while (!fechaVencimiento.fechaCorrecta());

    Renta renta = new Renta(idRenta, idArticulo, idSubscriptor, fechaRenta, fechaVencimiento);
    rentas.add(renta);

    for (Articulo articulo : articulos) {
      if (articulo.getIdArticulo() == idArticulo) {
        articulo.setRentado(true);
      }
    }

    for (Subscriptor subscriptor : subscriptores) {
      if (subscriptor.getIdSubscriptor() == idSubscriptor) {
        subscriptor.setRentado(true);
      }
    }

    JOptionPane.showMessageDialog(null, "Renta realizada con éxito");
  }

  private void listarPeliculas(ArrayList<Articulo> articulos) {
    String listaPeliculas = "";
    for (Articulo articulo : articulos) {
      if (articulo instanceof Pelicula) {
        listaPeliculas += articulo.getDatos() + "\n";
      }
    }
    JOptionPane.showMessageDialog(null, listaPeliculas);
  }

  private void listarSeries(ArrayList<Articulo> articulos) {
    String listaSeries = "";
    for (Articulo articulo : articulos) {
      if (articulo instanceof Serie) {
        listaSeries += articulo.getDatos() + "\n";
      }
    }
    JOptionPane.showMessageDialog(null, listaSeries);
  }

  private void listarSubscriptores(ArrayList<Subscriptor> subscriptores) {
    String listaSubscriptores = "";
    for (Subscriptor subscriptor : subscriptores) {
      listaSubscriptores += subscriptor.getDatos() + "\n";
    }
    JOptionPane.showMessageDialog(null, listaSubscriptores);
  }

  private void listarRentas(ArrayList<Renta> rentas) {
    String listaRentas = "";
    for (Renta renta : rentas) {
      listaRentas += renta.getDatos() + "\n";
    }
    JOptionPane.showMessageDialog(null, listaRentas);
  }

  private void verDetallePelicula(ArrayList<Articulo> articulos) {
    int idArticulo;
    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la película: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
      }
    } while (idArticulo == -1);

    for (Articulo articulo : articulos) {
      if (articulo instanceof Pelicula && articulo.getIdArticulo() == idArticulo) {
        JOptionPane.showMessageDialog(null, articulo.getDatos());
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró la película con el ID: " + idArticulo);
  }

  private void verDetalleSerie(ArrayList<Articulo> articulos) {
    int idArticulo;
    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la serie: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
      }
    } while (idArticulo == -1);

    for (Articulo articulo : articulos) {
      if (articulo instanceof Serie && articulo.getIdArticulo() == idArticulo) {
        JOptionPane.showMessageDialog(null, articulo.getDatos());
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró la serie con el ID: " + idArticulo);
  }

  private void verDetalleSubscriptor(ArrayList<Subscriptor> subscriptores) {
    String idSubscriptor;
    do {
      try {
        idSubscriptor = JOptionPane.showInputDialog("Ingrese el ID del subscriptor: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        idSubscriptor = null;
      }
    } while (idSubscriptor == null);

    for (Subscriptor subscriptor : subscriptores) {
      if (subscriptor.getIdSubscriptor().equals(idSubscriptor)) {
        JOptionPane.showMessageDialog(null, subscriptor.getDatos());
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró el subscriptor con el ID: " + idSubscriptor);
  }

  private void verDetalleRenta(ArrayList<Renta> rentas) {
    int idRenta;
    do {
      try {
        idRenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la renta: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idRenta = -1;
      }
    } while (idRenta == -1);

    for (Renta renta : rentas) {
      if (renta.getIdRenta() == idRenta) {
        JOptionPane.showMessageDialog(null, renta.getDatos());
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró la renta con el ID: " + idRenta);
  }

  private void eliminarPelicula(ArrayList<Articulo> articulos) {
    int idArticulo;
    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la película a eliminar: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
      }
    } while (idArticulo == -1);

    for (Articulo articulo : articulos) {
      if (articulo instanceof Pelicula && articulo.getIdArticulo() == idArticulo) {
        articulos.remove(articulo);
        JOptionPane.showMessageDialog(null, "Película eliminada con éxito");
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró la película con el ID: " + idArticulo);
  }

  private void eliminarSeries(ArrayList<Articulo> articulos) {
    int idArticulo;
    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la serie a eliminar: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
      }
    } while (idArticulo == -1);

    for (Articulo articulo : articulos) {
      if (articulo instanceof Serie && articulo.getIdArticulo() == idArticulo) {
        articulos.remove(articulo);
        JOptionPane.showMessageDialog(null, "Serie eliminada con éxito");
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró la serie con el ID: " + idArticulo);
  }

  private void eliminarSubscriptor(ArrayList<Subscriptor> subscriptores) {
    String idSubscriptor;
    do {
      try {
        idSubscriptor = JOptionPane.showInputDialog("Ingrese el ID del subscriptor a eliminar: ");
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        idSubscriptor = null;
      }
    } while (idSubscriptor == null);

    for (Subscriptor subscriptor : subscriptores) {
      if (subscriptor.getIdSubscriptor().equals(idSubscriptor)) {
        subscriptores.remove(subscriptor);
        JOptionPane.showMessageDialog(null, "Subscriptor eliminado con éxito");
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró el subscriptor con el ID: " + idSubscriptor);
  }

  private void eliminarRenta(ArrayList<Renta> rentas) {
    int idRenta;
    do {
      try {
        idRenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la renta a eliminar: "));
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idRenta = -1;
      }
    } while (idRenta == -1);

    for (Renta renta : rentas) {
      if (renta.getIdRenta() == idRenta) {
        rentas.remove(renta);
        JOptionPane.showMessageDialog(null, "Renta eliminada con éxito");
        return;
      }
    }

    JOptionPane.showMessageDialog(null, "No se encontró la renta con el ID: " + idRenta);
  }
}