package SchoolPOO.ExamenParcial2;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Entretenimiento {
  public static void main(String[] args) {

    ArrayList<Articulo> articulosLista = new ArrayList<>();
    ArrayList<Subscriptor> suscriptoresLista = new ArrayList<>();
    ArrayList<Renta> rentasLista = new ArrayList<>();

    int op;

    cargarDatos(articulosLista, suscriptoresLista, rentasLista);

    do {
      op = mostrarMenu();
      switch (op) {
        case 1:
          altaPelicula(articulosLista);
          break;
        case 2:
          altaSerie(articulosLista);
          break;
        case 3:
          altaSubscriptor(suscriptoresLista);
          break;
        case 4:
          altaRenta(rentasLista, articulosLista, suscriptoresLista);
          break;
        case 5:
          listarPeliculas(articulosLista);
          break;
        case 6:
          listarSeries(articulosLista);
          break;
        case 7:
          listarSubscriptores(suscriptoresLista);
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
          verDetalleSubscriptor(suscriptoresLista);
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
          eliminarSubscriptor(suscriptoresLista);
          break;
        case 16:
          eliminarRenta(rentasLista);
          break;
        case 17:
          guardarDatos(articulosLista, suscriptoresLista, rentasLista);
          JOptionPane.showMessageDialog(null, "Programa Creado por: LÆLÖ\n Espero pase la rubrica\n Bye :D");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opción no válida");
          break;
      }
    } while (op != 17);
  }

  private static void cargarDatos(ArrayList<Articulo> articulosLista, ArrayList<Subscriptor> suscriptoresLista, ArrayList<Renta> rentasLista) {
    try {
      FileInputStream fileArticulos = new FileInputStream("articulos.dat");
      ObjectInputStream inputArticulos = new ObjectInputStream(fileArticulos);
      articulosLista = (ArrayList<Articulo>) inputArticulos.readObject();
      inputArticulos.close();
      fileArticulos.close();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error al cargar datos de artículos: " + e.getMessage());
    }

    try {
      FileInputStream fileSuscriptores = new FileInputStream("suscriptores.dat");
      ObjectInputStream inputSuscriptores = new ObjectInputStream(fileSuscriptores);
      suscriptoresLista = (ArrayList<Subscriptor>) inputSuscriptores.readObject();
      inputSuscriptores.close();
      fileSuscriptores.close();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error al cargar datos de suscriptores: " + e.getMessage());
    }

    try {
      FileInputStream fileRentas = new FileInputStream("rentas.dat");
      ObjectInputStream inputRentas = new ObjectInputStream(fileRentas);
      rentasLista = (ArrayList<Renta>) inputRentas.readObject();
      inputRentas.close();
      fileRentas.close();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error al cargar datos de rentas: " + e.getMessage());
    }
  }

  private static void guardarDatos(ArrayList<Articulo> articulosLista, ArrayList<Subscriptor> suscriptoresLista, ArrayList<Renta> rentasLista) {
    try {
      FileOutputStream fileArticulos = new FileOutputStream("articulos.dat");
      ObjectOutputStream outputArticulos = new ObjectOutputStream(fileArticulos);
      outputArticulos.writeObject(articulosLista);
      outputArticulos.close();
      fileArticulos.close();
    } catch (IOException e) {
      System.out.println("Error al guardar datos de artículos: " + e.getMessage());
    }

    try {
      FileOutputStream fileSuscriptores = new FileOutputStream("suscriptores.dat");
      ObjectOutputStream outputSuscriptores = new ObjectOutputStream(fileSuscriptores);
      outputSuscriptores.writeObject(suscriptoresLista);
      outputSuscriptores.close();
      fileSuscriptores.close();
    } catch (IOException e) {
      System.out.println("Error al guardar datos de suscriptores: " + e.getMessage());
    }

    try {
      FileOutputStream fileRentas = new FileOutputStream("rentas.dat");
      ObjectOutputStream outputRentas = new ObjectOutputStream(fileRentas);
      outputRentas.writeObject(rentasLista);
      outputRentas.close();
      fileRentas.close();
    } catch (IOException e) {
      System.out.println("Error al guardar datos de rentas: " + e.getMessage());
    }
  }

  private static int mostrarMenu() {
    String menu = """
            ------ Entretenimiento ------
            1) Alta de una película
            2) Alta de una serie
            3) Alta de un suscriptor
            4) Alta de una renta
            5) Listar películas
            6) Listar series
            7) Listar suscriptores
            8) Listar rentas
            9) Ver detalle de una película
            10) Ver detalle de una serie
            11) Ver detalle de un suscriptor
            12) Ver detalle de una renta
            13) Eliminar una película
            14) Eliminar una serie
            15) Eliminar un suscriptor
            16) Eliminar una renta
            17) Salir""";
    try {
      return Integer.parseInt(JOptionPane.showInputDialog(null, menu + "\nIngrese una opción: "));
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
      return -1;
    }
  }

  private static void altaPelicula(ArrayList<Articulo> articulos) {
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
        if(anio < 1950 || anio > 2024){
          JOptionPane.showMessageDialog(null, "Error: Ingrese un año válido");
          anio = -1;
        }
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

  private static void altaSerie(ArrayList<Articulo> articulos) {
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
        if(anio < 1950 || anio > 2024){
          JOptionPane.showMessageDialog(null, "Error: Ingrese un año válido");
          anio = -1;
        }
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

  private static void altaSubscriptor(ArrayList<Subscriptor> subscriptores) {
    String idSubscriptor, nombre, tipo, telefono, correoElectronico;
    int dia = 0;
    int mes = 0;
    int anio = 0;
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
        dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de nacimiento del subscriptor: "));
        mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento del subscriptor: "));
        anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento del subscriptor: "));
        if (fechaNacimiento.fechaCorrecta()) {
          fechaNacimiento.setFecha(dia, mes, anio);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
      }
    } while (!fechaNacimiento.fechaCorrecta());

    Subscriptor subscriptor = new Subscriptor(idSubscriptor, nombre, tipo, telefono, dia, mes, anio, correoElectronico);
    subscriptores.add(subscriptor);
  }

  private static void altaRenta(ArrayList<Renta> rentas, ArrayList<Articulo> articulos, ArrayList<Subscriptor> suscriptores) {
    int idRenta;
    int idArticulo;
    String idSuscriptor;
    Fecha fechaRenta;
    Fecha fechaVencimiento;

    do {
      try {
        idRenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la renta: "));
        if (existeRenta(rentas, idRenta)) {
          JOptionPane.showMessageDialog(null, "El ID de la renta ya existe. Ingrese uno diferente.");
          continue;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idRenta = -1;
        continue;
      }
    } while (idRenta == -1);

    do {
      try {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del artículo: "));
        if (!existeArticulo(articulos, idArticulo)) {
          JOptionPane.showMessageDialog(null, "El ID del artículo no existe. Ingrese uno válido.");
          continue;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico válido");
        idArticulo = -1;
        continue;
      }
    } while (idArticulo == -1);

    do {
      try {
        idSuscriptor = JOptionPane.showInputDialog("Ingrese el ID del suscriptor: ");
        if (!existeSuscriptor(suscriptores, idSuscriptor)) {
          JOptionPane.showMessageDialog(null, "El ID del suscriptor no existe. Ingrese uno válido.");
          continue;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Ingrese un valor válido");
        idSuscriptor = null;
        continue;
      }
    } while (idSuscriptor == null);

    fechaRenta = ingresarFecha("Ingrese la fecha de renta (dd/mm/aaaa): ");
    fechaVencimiento = ingresarFecha("Ingrese la fecha de vencimiento (dd/mm/aaaa): ");

    Articulo articulo = buscarArticulo(articulos, idArticulo);
    Subscriptor suscriptor = buscarSubscriptor(suscriptores, idSuscriptor);

    Renta renta = new Renta(idRenta, articulo, suscriptor, fechaRenta, fechaVencimiento);
    rentas.add(renta);

    JOptionPane.showMessageDialog(null, "Renta realizada con éxito");
  }

  private static void listarPeliculas(ArrayList<Articulo> articulos) {
    String listaPeliculas = "";
    for (Articulo articulo : articulos) {
      if (articulo instanceof Pelicula) {
        listaPeliculas += articulo.getDatos() + "\n";
      }
    }
    JOptionPane.showMessageDialog(null, listaPeliculas);
  }

  private static void listarSeries(ArrayList<Articulo> articulos) {
    String listaSeries = "";
    for (Articulo articulo : articulos) {
      if (articulo instanceof Serie) {
        listaSeries += articulo.getDatos() + "\n";
      }
    }
    JOptionPane.showMessageDialog(null, listaSeries);
  }

  private static void listarSubscriptores(ArrayList<Subscriptor> subscriptores) {
    String listaSubscriptores = "";
    for (Subscriptor subscriptor : subscriptores) {
      listaSubscriptores += subscriptor.getDatos() + "\n";
    }
    JOptionPane.showMessageDialog(null, listaSubscriptores);
  }

  private static void listarRentas(ArrayList<Renta> rentas) {
    String listaRentas = "";
    for (Renta renta : rentas) {
      listaRentas += renta.getDatos() + "\n";
    }
    JOptionPane.showMessageDialog(null, listaRentas);
  }

  private static void verDetallePelicula(ArrayList<Articulo> articulos) {
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

  private static void verDetalleSerie(ArrayList<Articulo> articulos) {
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

  private static void verDetalleSubscriptor(ArrayList<Subscriptor> subscriptores) {
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

  private static void verDetalleRenta(ArrayList<Renta> rentas) {
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

  private static void eliminarPelicula(ArrayList<Articulo> articulos) {
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

  private static void eliminarSerie(ArrayList<Articulo> articulos) {
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

  private static void eliminarSubscriptor(ArrayList<Subscriptor> subscriptores) {
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

  private static void eliminarRenta(ArrayList<Renta> rentas) {
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

  private static boolean existeRenta(ArrayList<Renta> rentas, int idRenta) {
    for (Renta renta : rentas) {
      if (renta.getIdRenta() == idRenta) {
        return true;
      }
    }
    return false;
  }

  private static boolean existeArticulo(ArrayList<Articulo> articulos, int idArticulo) {
    for (Articulo articulo : articulos) {
      if (articulo.getIdArticulo() == idArticulo) {
        return true;
      }
    }
    return false;
  }

  private static boolean existeSuscriptor(ArrayList<Subscriptor> suscriptores, String idSuscriptor) {
    for (Subscriptor suscriptor : suscriptores) {
      if (suscriptor.getIdSubscriptor().equals(idSuscriptor)) {
        return true;
      }
    }
    return false;
  }

  private static Fecha ingresarFecha(String mensaje) {
    String input = JOptionPane.showInputDialog(null, mensaje);
    if (input == null || input.isEmpty()) {
      return null;
    }

    String[] partes = input.split("/");
    if (partes.length != 3) {
      JOptionPane.showMessageDialog(null, "Formato de fecha inválido");
      return null;
    }

    try {
      int dia = Integer.parseInt(partes[0]);
      int mes = Integer.parseInt(partes[1]);
      int anio = Integer.parseInt(partes[2]);
      return new Fecha(dia, mes, anio);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Formato de fecha inválido");
      return null;
    }
  }

  private static Articulo buscarArticulo(ArrayList<Articulo> articulos, int idArticulo) {
    for (Articulo articulo : articulos) {
      if (articulo.getIdArticulo() == idArticulo) {
        return articulo;
      }
    }
    return null;
  }

  private static Subscriptor buscarSubscriptor(ArrayList<Subscriptor> suscriptores, String idSuscriptor) {
    for (Subscriptor suscriptor : suscriptores) {
      if (suscriptor.getIdSubscriptor().equals(idSuscriptor)) {
        return suscriptor;
      }
    }
    return null;
  }
}