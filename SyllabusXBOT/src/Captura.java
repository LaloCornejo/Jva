//Jesus Eduardo Cornejo Clavel
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.sql.*;


public class Captura extends JFrame {
    private JLabel usernameSpace;
    private JPanel CapturaGUI;
    private JTabbedPane tabbedPane1;
    private JPanel AlumnoForm;
    private JPanel PersonalForm;
    private JTextField nombreField;
    private JTextField telTutText;
    private JTextField nombrePersonal;
    private JTextField usuarioPersonal;
    private JTextField emailPersonal;
    private JTextField telefonoPersonal;
    private JButton agregarPersonalButton;
    private JButton agregarAlumnoButton;
    private JComboBox comboBox1;
    private JButton homeButton;
    private JDateChooser JDateChooser1;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String usuario;
    private java.sql.Date fechaNacimiento;
    private int nivel;


    private final AdminDashboard instance;

    Captura(int id, AdminDashboard instance) {
        this.instance = instance;
        setContentPane(CapturaGUI);
        setTitle("Captura de datos");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from personal where idPersonal = '" + id + "'");
            resultSet.next();
            String user = resultSet.getString("user");
            usernameSpace.setText(user);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        homeButton.addActionListener(e -> {
            new AdminDashboard(id);
            setVisible(false);
            dispose();
        });

        agregarAlumnoButton.addActionListener(e -> {
            String nombreCompleto = nombreField.getText();
            String[] nombreSeg = nombreCompleto.split(" ");
            if (nombreSeg.length < 2) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese nombre y apellidos");
                return;
            } else if (nombreSeg.length > 2) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese solo un nombre y un apellido");
                return;
            }
            nombre = nombreSeg[0];
            apellido = nombreSeg[1];
            telefono = telTutText.getText();
            if (!esNumero(telefono)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número de teléfono válido");
                return;
            }
            fechaNacimiento = new java.sql.Date(JDateChooser1.getDate().getTime());

            insertDataAlumno(nombre, apellido, telefono, fechaNacimiento);
        });

        agregarPersonalButton.addActionListener(e -> {
            nombre = nombrePersonal.getText();
            usuario = usuarioPersonal.getText();
            email = emailPersonal.getText();
            telefono = telefonoPersonal.getText();
            if (!esNumero(telefono)) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número de teléfono válido");
                return;
            }
            nivel = comboBox1.getSelectedIndex();

            insertDataPersonal(nombre, usuario, email, telefono, nivel);
        });
    }

    private void insertDataPersonal(String nombre, String usuario, String email, String telefono, int nivel) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password")) {
        PreparedStatement PS = connection.prepareStatement("INSERT INTO personal (user, password, nombre, email, telefono, nivel) VALUES(?,?,?,?,?,?)");
        PS.setString(1, usuario);
        PS.setString(2, "root");
        PS.setString(3, nombre);
        PS.setString(4, email);
        PS.setString(5, telefono);
        PS.setInt(6, nivel);
        PS.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
        this.instance.listar();
        setVisible(false);
        dispose();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        System.out.println(e.getMessage());
    }
}

private void insertDataAlumno(String nombre, String apellido, String TelefonoT, Date fechaNacimiento) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password")) {
        PreparedStatement PS;
        PS = connection.prepareStatement("INSERT INTO alumno (nombre, appellido, telefonoTutor, fechaNac) VALUES(?, ?, ?, ?)");
        PS.setString(1, nombre);
        System.out.println(nombre);
        PS.setString(2, apellido);
        System.out.println(apellido);
        PS.setString(3, TelefonoT);
        System.out.println(TelefonoT);
        PS.setDate(4, fechaNacimiento);
        System.out.println(fechaNacimiento);
        PS.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
        this.instance.listar();
        setVisible(false);
        dispose();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        System.out.println(e.getMessage());
    }
}
    private boolean esNumero(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void createUIComponents() {
        JDateChooser1 = new JDateChooser();
    }
}
