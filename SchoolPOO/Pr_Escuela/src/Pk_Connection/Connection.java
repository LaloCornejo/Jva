package Pk_Connection;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    java.sql.Connection instance;

    public Connection() {
        instance = null;
    }

    public java.sql.Connection getConnection() {
        instance = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            instance = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "password");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar casting a la clase Connection" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la conexión a la base de datos" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return instance;
    }

}
