import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Clases extends JFrame{
    private int idAlumno;
    private int idClase;
    private JPanel misClases;
    private JButton recursosAdicionalesButton;
    private JButton contactoXCoachButton;
    private JTextPane nombre;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JButton homeButton;
    private JTextField searchField;
    public int P1 = 0, P2 = 0;
    private JButton modificaAvanceC1Button;
    private JButton modificaAvanceC2Button;
    private JLabel campo1Label;
    private JLabel campo2Label;
    private JLabel userName;

    public Clases(int id) {
        setContentPane(misClases);
        setTitle("nombre");
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

        }catch (Exception exception) {
            exception.printStackTrace();
        }

        homeButton.addActionListener(e -> {
            new Dashboard(id);
            setVisible(false);
            dispose();
        });

        searchField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = searchField.getText();
                    if (esNumero(input)) {
                        Connection connection;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(
                                    "select * from alumno where idAlumno = '" + input + "'");

                            resultSet.next();
                            idAlumno = resultSet.getInt("idAlumno");

                            resultSet = statement.executeQuery(
                                    "select * from perfil where idAlumno = '" + idAlumno + "'");
                            resultSet.next();
                            nombre.setText(resultSet.getString("nombre"));

                            resultSet = statement.executeQuery(
                                    "select * from clase where idAlumno = '" + idAlumno + "'");

                            resultSet.next();
                            idClase = resultSet.getInt("idClase");
                            String camposString = resultSet.getString("campos");
                            String[] campo = camposString.split(",");
                            campo1Label.setText(campo[0]);
                            campo2Label.setText(campo[1]);

                            int P1, P2;
                            P1 = resultSet.getInt("valorCampo1");
                            P2 = resultSet.getInt("valorCampo2");
                            System.out.println(P1);
                            System.out.println(P2);
                            progressBar2.setValue(P1);
                            progressBar1.setValue(P2);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    } else {
                        Connection connection;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(
                                    "select * from alumno where nombre = '" + input + "'");

                            resultSet.next();
                            int idAlumno = resultSet.getInt("idAlumno");

                            resultSet = statement.executeQuery(
                                    "select * from perfil where idAlumno = '" + idAlumno + "'");
                            resultSet.next();
                            nombre.setText(resultSet.getString("nombre"));

                            resultSet = statement.executeQuery(
                                    "select * from clase where idAlumno = '" + idAlumno + "'");

                            resultSet.next();
                            idClase = resultSet.getInt("idClase");
                            String camposString = resultSet.getString("campos");
                            String[] campo = camposString.split(",");
                            campo1Label.setText(campo[0]);
                            campo2Label.setText(campo[1]);

                            int P1, P2;
                            P1 = resultSet.getInt("valorCampo1");
                            P2 = resultSet.getInt("valorCampo2");
                            System.out.println(P1);
                            System.out.println(P2);
                            progressBar2.setValue(P1);
                            progressBar1.setValue(P2);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });
        modificaAvanceC1Button.addActionListener(e -> setModificaAvanceC1Button());

        modificaAvanceC2Button.addActionListener(e -> setModificaAvanceC2Button());
    }

    private void setModificaAvanceC1Button() {
        new modificaCampo(idClase, 1, this);

    }

    private void setModificaAvanceC2Button() {
        new modificaCampo(idClase, 2, this);
    }

    public  void update(int idClase) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from clase where idClase = '" + idClase + "'");

            resultSet.next();

            P1 = resultSet.getInt("valorCampo1");
            P2 = resultSet.getInt("valorCampo2");
            System.out.println(P1);
            System.out.println(P2);
            progressBar2.setValue(P1);
            progressBar1.setValue(P2);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
//        Clases mC = new Clases();
//    }
}
