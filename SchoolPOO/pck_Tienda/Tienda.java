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

    articulos[1] = new Articulo();
    articulos[1].setIdArticulo(2);
    articulos[1].setDescription("Pan");
    articulos[1].setMarca("Bimbo");
    articulos[1].setFechaCaducidad(1, 1, 2025);

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
        System.out.println(perecederoObj.getDatos());
        articulo.remove();
      } else {
        System.out.println(articulo.getDatos());
      }
    }
  }
}
