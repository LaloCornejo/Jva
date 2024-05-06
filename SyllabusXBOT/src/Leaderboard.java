import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Leaderboard extends JFrame {
    private JPanel ForoGUI;
    private JButton button1;
    private JButton Home;
    private JScrollPane ScrollLeaderbaord;
    private JPanel Users;
  private JLabel P;
  private JLabel UN;
  private JLabel E;
    private JPanel User;
    private JPanel User1;
    private JPanel User2;
    private JPanel User3;
    private JPanel User4;
    private JPanel User5;
    private JPanel User6;
    private JPanel User7;
    private JPanel User8;
    private JPanel User9;
  private JLabel UN1;
  private JLabel P1;
  private JLabel E1;
  private JLabel UN2;
  private JLabel P2;
  private JLabel E2;
  private JLabel UN3;
  private JLabel P3;
  private JLabel UN4;
  private JLabel E4;
  private JLabel E3;
  private JLabel UN5;
  private JLabel E5;
  private JLabel UN6;
  private JLabel UN7;
  private JLabel E7;
  private JLabel UN8;
  private JLabel E8;
  private JLabel UN9;
  private JLabel E9;
  private JLabel userNamePersonal;
  private JLabel E6;

  public Leaderboard(int id) {
        setContentPane(ForoGUI);
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    calcPuntajes();

    Connection connection;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select* from personal where idPersonal = '" + id + "'");
      resultSet.next();
      userNamePersonal.setText(resultSet.getString("user"));
      resultSet.close();

      resultSet = statement.executeQuery(
              "SELECT alumno.nombre, leaderboard.puntaje " +
                      "FROM leaderboard " +
                      "JOIN alumno ON leaderboard.idAlumno = alumno.idAlumno " +
                      "ORDER BY leaderboard.puntaje DESC " +
                      "LIMIT 10"
      );

      int i = 0;
      while (resultSet.next()) {
        String nombre = resultSet.getString("nombre");
        int puntaje = resultSet.getInt("puntaje");
        if (i == 0) {
          UN9.setText(nombre);
          E9.setText(String.valueOf(puntaje));
        } else if (i == 1) {
          UN8.setText(nombre);
          E8.setText(String.valueOf(puntaje));
        } else if (i == 2) {
          UN7.setText(nombre);
          E7.setText(String.valueOf(puntaje));
        } else if (i == 3) {
          UN6.setText(nombre);
          E6.setText(String.valueOf(puntaje));
        } else if (i == 4) {
          UN5.setText(nombre);
          E5.setText(String.valueOf(puntaje));
        } else if (i == 5) {
          UN4.setText(nombre);
          E4.setText(String.valueOf(puntaje));
        } else if (i == 6) {
          UN3.setText(nombre);
          E3.setText(String.valueOf(puntaje));
        } else if (i == 7) {
          UN2.setText(nombre);
          E2.setText(String.valueOf(puntaje));
        } else if (i == 8) {
          UN1.setText(nombre);
          E1.setText(String.valueOf(puntaje));
        } else if (i == 9) {
          UN.setText(nombre);
          E.setText(String.valueOf(puntaje));
        }
        i++;
      }
      resultSet.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

        Home.addActionListener(e -> {
          new Dashboard(id);
            setVisible(false);
            dispose();
        });
    }

  private void calcPuntajes() {
    Connection connection;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from clase");

      ArrayList<Integer> V1 = new ArrayList<>();
      ArrayList<Integer> V2 = new ArrayList<>();
      ArrayList<Integer> idAlumno = new ArrayList<>();
      while (resultSet.next()) {
        V1.add(resultSet.getInt("valorCampo1"));
        V2.add(resultSet.getInt("valorCampo2"));
        idAlumno.add(resultSet.getInt("idAlumno"));
      }
      resultSet.close();

      ArrayList<Integer> puntajes = new ArrayList<>();
      for (int i = 0; i < V1.size(); i++) {
        int puntaje = 0;
        if (V1.get(i) > 0) {
          puntaje += V1.get(i) * 5;
        }
        if (V2.get(i) > 0) {
          puntaje += V2.get(i) * 8;
        }
        puntajes.add(puntaje);

        int rowsUpdated = statement.executeUpdate("UPDATE leaderboard SET puntaje = " + puntaje + " WHERE idAlumno = " + idAlumno.get(i));
        if (rowsUpdated > 0) {
          System.out.println("Puntaje actualizado para el alumno con id " + idAlumno.get(i) + " a " + puntaje);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

//  public static void main(String[] args) {
//    new Leaderboard(1);
//  }
}
