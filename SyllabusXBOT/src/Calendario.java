import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class Calendario extends JFrame {
    private JPanel Calendario;
    private JButton homeButton;
    private JTextPane calendarioText;
    private JTabbedPane semesterCalendar;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a15Button;
    private JButton a20Button;
    private JButton a25Button;
    private JButton a29Button;
    private JPanel Mes1;
    private JPanel Mes2;
    private JPanel Mes3;
    private JPanel Mes4;
    private JPanel Mes5;
    private JButton estadoDeCuentaButton;
    private JTextField searchField;
    private JLabel nombre;
    private JLabel userName;
    String nombreAlumno;
    int idAlumno;

    public Calendario(int id) {
        setContentPane(Calendario);
        setTitle("Calendario");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from personal where idPersonal = '" + id + "'");

            resultSet.next();
            userName.setText(resultSet.getString("user"));
            resultSet.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        searchField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = searchField.getText();
                    Connection connection;
                    if (esNumero(input)) {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(
                                    "select * from clase where idAlumno = '" + input + "'");
                            resultSet.next();
                            idAlumno = resultSet.getInt("idAlumno");
                            resultSet.close();
                            resultSet = statement.executeQuery(
                                    "select * from perfil where idAlumno = '"+ idAlumno +"' ");
                            resultSet.next();
                            nombre.setText(resultSet.getString("nombre"));
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    } else {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(
                                    "select * from alumno where nombre = '" + input + "'");
                            resultSet.next();
                            idAlumno = resultSet.getInt("idAlumno");
                            resultSet.close();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });

        homeButton.addActionListener(e -> {
            setVisible(false);
            new Dashboard(id);
            dispose();
        });

        estadoDeCuentaButton.addActionListener(e-> {
            new EstadoDeCuenta(idAlumno);
        });
    }

    private boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

//    public static void main(String[] args) {
//        new Calendario(id);
//    }
}
