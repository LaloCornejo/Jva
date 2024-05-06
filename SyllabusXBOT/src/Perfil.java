import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Perfil extends JFrame {
    private JButton button1;
    private JPanel pefilGUI;
    private JPanel Tourneys;
    private JPanel Medallas;
    private JScrollPane Scroll;
    private JButton Home;
    private JLabel Hero;
    private JTextField searchField;
    private JPanel Bio;
    private JLabel bio;
    private JTextPane Descripcion;
    private JLabel nombreCompleto;
    private JLabel userName;
    private JLabel M1;
    private JLabel M2;
    private JLabel M3;
    private JLabel M4;
    private JLabel M5;
    private JLabel M6;
    private JLabel M7;
    private JLabel M8;
    private JLabel T1;
    private JLabel T2;
    private JLabel T3;
    private JLabel T4;
    private JLabel T5;
    private JLabel T6;
    private JLabel T7;
    private JLabel T8;

    public Perfil(int id) {
        setContentPane(Scroll);
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
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        searchField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = searchField.getText();
                    cleanFields();
                    if (esNumero(input)) {
                        Connection connection;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(
                                    "select * from perfil where idPerfil = '" + input + "'");

                            resultSet.next();
                            nombreCompleto.setText(resultSet.getString("nombre"));
                            Descripcion.setText(resultSet.getString("descripcion"));
                            String premiosString = resultSet.getString("premios");

                            int conta = 0;
                            if (premiosString != null) {
                                String[] indiPremios = premiosString.split(",");
                                conta = 0;
                                for (String premio : indiPremios) {
                                    switch (conta) {
                                        case 0:
                                            M1.setText(premio);
                                            M1.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 1:
                                            M2.setText(premio);
                                            M2.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 2:
                                            M3.setText(premio);
                                            M3.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 3:
                                            M4.setText(premio);
                                            M4.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 4:
                                            M5.setText(premio);
                                            M5.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 5:
                                            M6.setText(premio);
                                            M6.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 6:
                                            M7.setText(premio);
                                            M7.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 7:
                                            M8.setText(premio);
                                            M8.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                    }
                                    conta++;
                                }
                            }
                            String torneosString = resultSet.getString("concursos");
                            if (torneosString != null) {
                                String[] indiTorneos = torneosString.split(",");
                                conta = 0;
                                for (String concursos : indiTorneos) {
                                    switch (conta) {
                                        case 0:
                                            T1.setText(concursos);
                                            break;
                                        case 1:
                                            T2.setText(concursos);
                                            break;
                                        case 2:
                                            T3.setText(concursos);
                                            break;
                                        case 3:
                                            T4.setText(concursos);
                                            break;
                                        case 4:
                                            T5.setText(concursos);
                                            break;
                                        case 5:
                                            T6.setText(concursos);
                                            break;
                                        case 6:
                                            T7.setText(concursos);
                                            break;
                                        case 7:
                                            T8.setText(concursos);
                                            break;
                                    }
                                    conta++;
                                }
                            }
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
                            nombreCompleto.setText(resultSet.getString("nombre"));
                            Descripcion.setText(resultSet.getString("descripcion"));
                            String premiosString = resultSet.getString("premios");
                            int conta = 0;
                            if (premiosString != null) {
                                String[] indiPremios = premiosString.split(",");
                                conta = 0;
                                for (String premio : indiPremios) {
                                    switch (conta) {
                                        case 0:
                                            M1.setText(premio);
                                            M1.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 1:
                                            M2.setText(premio);
                                            M2.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 2:
                                            M3.setText(premio);
                                            M3.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 3:
                                            M4.setText(premio);
                                            M4.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 4:
                                            M5.setText(premio);
                                            M5.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 5:
                                            M6.setText(premio);
                                            M6.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 6:
                                            M7.setText(premio);
                                            M7.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                        case 7:
                                            M8.setText(premio);
                                            M8.setIcon(new ImageIcon("src/imgs/medalla120.png"));
                                            break;
                                    }
                                    conta++;
                                }
                            }
                            String torneosString = resultSet.getString("concursos");
                            if (torneosString != null) {
                                String[] indiTorneos = torneosString.split(",");
                                conta = 0;
                                for (String concursos : indiTorneos) {
                                    switch (conta) {
                                        case 0:
                                            T1.setText(concursos);
                                            break;
                                        case 1:
                                            T2.setText(concursos);
                                            break;
                                        case 2:
                                            T3.setText(concursos);
                                            break;
                                        case 3:
                                            T4.setText(concursos);
                                            break;
                                        case 4:
                                            T5.setText(concursos);
                                            break;
                                        case 5:
                                            T6.setText(concursos);
                                            break;
                                        case 6:
                                            T7.setText(concursos);
                                            break;
                                        case 7:
                                            T8.setText(concursos);
                                            break;
                                    }
                                    conta++;
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });

        Home.addActionListener(e -> {
            setVisible(false);
            new Dashboard(id);
            dispose();
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

    private void cleanFields() {
        nombreCompleto.setText("");
        Descripcion.setText("");
        M1.setText("");
        M2.setText("");
        M3.setText("");
        M4.setText("");
        M5.setText("");
        M6.setText("");
        M7.setText("");
        M8.setText("");
        T1.setText("");
        T2.setText("");
        T3.setText("");
        T4.setText("");
        T5.setText("");
        T6.setText("");
        T7.setText("");
        T8.setText("");
    }

//    public static void main(String[] args) {
//        new Perfil(1);
//    }
}
