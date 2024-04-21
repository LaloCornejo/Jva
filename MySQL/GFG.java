import java.sql.*;

public class GFG {
    public static void main(String arg[]) {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tienda?useSSL=false",
                    "root", "password");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from venta");
            int folio;
            int fecha;
            int status;
            int caja;
            int numCliente;
            char tipoPago;
            String vendedor;
            while (resultSet.next()) {
                folio = resultSet.getInt("folio");
                fecha = resultSet.getInt("fecha");
                status = resultSet.getInt("estado");
                caja = resultSet.getInt("caja");
                numCliente = resultSet.getInt("numCliente");
                tipoPago = resultSet.getString("tipoPago").charAt(0);
                vendedor = resultSet.getString("vendedor").trim();
                System.out.println("Folio : " + folio
                        + " Fecha : " + fecha
                        + " Estado : " + status
                        + " Caja : " + caja
                        + " NumCliente : " + numCliente
                        + " TipoPago : " + tipoPago
                        + " Vendedor : " + vendedor);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    } // function ends
} // class ends