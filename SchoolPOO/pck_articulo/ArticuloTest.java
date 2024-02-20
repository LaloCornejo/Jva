package SchoolPOO.pck_articulo;

import java.util.Scanner;

public class ArticuloTest {
    public static void main(String args[]) {
        try (Scanner input = new Scanner(System.in)) {

            int id;
            String desc, conte, status;
            float precio;

            Articulo art1 = new Articulo();
            id = input.nextInt();
            desc = input.next();
            conte = input.next();
            precio = input.nextFloat();
            status = input.next();

            art1.setIdArticulo(id);
            art1.setDescripcion(desc);
            art1.setContenido(conte);
            art1.setPrecio(precio);
            art1.setStatus(status);

            System.out.printf("\n\n***** ARTICULO *****\n" +
                "\nidArtculo: %d\n" +
                "Descripcion: %s\n" +
                "Contenido: %s\n" +
                "Precio: %.2f\n" +
                "Status: %s\n\n",
                art1.getIdArticulo(),
                art1.getDescripcion(),
                art1.getContenido(),
                art1.getPrecio(),
                art1.getStatus());

            System.out.println("Usando getDatos()");
            System.out.println(art1.getDatos());
        }
    }
}
