package SchoolPOO.pck_Tienda;

public class Tienda {
  public static void main(String args[]) {
    int d = 31, m = 12 , a = 2021;

    Articulo[] articulos = new Articulo[2];

    articulos[0] = new Articulo();
    articulos[0].setIdArticulo(1);
    articulos[0].setDescription("Leche");
    articulos[0].setMarca("Lala");
    articulos[0].setFechaCaducidad(d, m, a);
    articulos[0].setPrecio(20.5f);
    articulos[0].setContenido("Leche entera");
    articulos[0].setCategoria("Lacteos");
    articulos[0].setStatus("Disponible");

    articulos[1] = new Articulo();
    articulos[1].setIdArticulo(2);
    articulos[1].setDescription("Pan");
    articulos[1].setMarca("Bimbo");
    articulos[1].setFechaCaducidad(1, 1, 2025);
    articulos[1].setPrecio(10.5f);
    articulos[1].setContenido("Pan de caja");
    articulos[1].setCategoria("Panaderia");
    articulos[1].setStatus("Disponible");

    processArticulos(articulos, d, m, a);
  }

  private static void processArticulos(Articulo[] articulos, int d, int m, int a) {
    for (Articulo articulo : articulos) {
      boolean perecedero = articulo.Caducado();

      if (perecedero) {
        Perecedero perecederoObj = new Perecedero();
        perecederoObj.setIdArticulo(articulo.getIdArticulo());
        perecederoObj.setDescription(articulo.getDescription());
        perecederoObj.setMarca(articulo.getMarca());
        perecederoObj.setFechaCaducidad(d, m, a);
        perecederoObj.setPrecio(articulo.getPrecio());
        perecederoObj.setContenido(articulo.getContenido());
        perecederoObj.setCategoria(articulo.getCategoria());
        perecederoObj.setStatus(articulo.getStatus());
        System.out.println(perecederoObj.getDatos());
        articulo.remove();
      } else {
        System.out.println(articulo.getDatos());
      }
    }
  }
}
