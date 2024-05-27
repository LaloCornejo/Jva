//Jesus Eduardo Cornejo Clavel
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Modificar extends JFrame {
    private JLabel usernameSpace;
    private JButton updateButton;
    private JButton homeButton;
    private JPanel PersonalForm;
    private JTextField nombrePersonal;
    private JTextField usuarioPersonal;
    private JTextField emailPersonal;
    private JTextField telefonoPersonal;
    private JComboBox comboBox1;
    private JPanel AlumnoForm;
    private JTextField nombreField;
    private JTextField telTutText;
    private JDateChooser JDateChooser1;
    private JPanel modificarGUI;
    private final AdminDashboard instance;
    private String nombre;
    private String telefono;
    private String email;
    private String usuario;
    private Date fechaNac;
    private int nivel;

    Modificar(int idUsuario, int id, int type, AdminDashboard instance) {
        this.instance = instance;
        setContentPane(modificarGUI);
        setTitle("Modificar");
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
                    "select * from personal where idPersonal = '" + idUsuario + "'");
            resultSet.next();
            String user = resultSet.getString("user");
            usernameSpace.setText(user);

            if (type == 1) {
                PersonalForm.setVisible(true);
                AlumnoForm.setVisible(false);
                comboBox1.setVisible(true);
                getData(id, 1);
                nombrePersonal.setText(nombre);
                telefonoPersonal.setText(telefono);
                emailPersonal.setText(email);
                usuarioPersonal.setText(usuario);
                comboBox1.setSelectedIndex(nivel);
            } else {
                PersonalForm.setVisible(false);
                AlumnoForm.setVisible(true);
                comboBox1.setVisible(false);
                getData(id, 2);
                nombreField.setText(nombre);
                telTutText.setText(telefono);
                JDateChooser1.setDate(fechaNac);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        updateButton.addActionListener(e -> updateData(id, type));

        homeButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            instance.setVisible(true);
        });
    }

    private void getData(int id, int type) {
        Connection connection;
        String SQL = switch (type) {
            case 1 -> "select * from personal where idPersonal = '" + id + "'";
            case 2 -> "select * from alumno where idAlumno = '" + id + "'";
            default -> "";
        };
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();

            switch (type) {
                case 2:
                    nombre = resultSet.getString("nombre") + " " + resultSet.getString("appellido");
                    telefono = resultSet.getString("telefonoTutor");
                    if (!esNumero(telefono)) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número de teléfono válido");
                        return;
                    }
                    fechaNac = resultSet.getDate("fechaNac");

                    break;
                case 1:
                    nombre = resultSet.getString("nombre");
                    usuario = resultSet.getString("user");
                    email = resultSet.getString("email");
                    telefono = resultSet.getString("telefono");
                    if (!esNumero(telefono)) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número de teléfono válido");
                        return;
                    }
                    nivel = resultSet.getInt("nivel");
                    break;
            }
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void updateData(int id, int type) {
        String SQL;
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            PreparedStatement PS;
            switch (type) {
                case 1:
                    SQL = "UPDATE personal SET nombre = ?, user = ?, telefono = ?, email = ?, password = ?  WHERE idPersonal = '" + id + "'";
                    PS = connection.prepareStatement(SQL);
                    PS.setString(1, nombrePersonal.getText());
                    PS.setString(2, usuarioPersonal.getText());
                    PS.setString(3, telefonoPersonal.getText());
                    PS.setString(4, emailPersonal.getText());
                    PS.setString(5, "root");
                    break;
                case 2:
                    SQL = "UPDATE alumno SET nombre = ?, telefonoTutor = ?, appellido = ?, fechaNac = ? WHERE idAlumno = '" + id + "'";
                    PS = connection.prepareStatement(SQL);
                    String nombreString = nombreField.getText();
                    String[] nombreArray = nombreString.split(" ");
                    PS.setString(1, nombreArray[0]);
                    PS.setString(2, telTutText.getText());
                    PS.setString(3, nombreArray[1]);
                    PS.setDate(4, new java.sql.Date(JDateChooser1.getDate().getTime()));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + type);
            }
            PS.executeUpdate();
            connection.close();
            instance.listar();
            setVisible(false);
            dispose();
            instance.setVisible(true);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
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
