import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Newsletter extends JFrame {
    private JScrollPane Scroll;
    private JPanel NewsletterGUI;
    private JButton button1;
    private JLabel Hero;
    private JButton Home;
    private JPanel Publication1;
  private JLabel F1;
    private JTextPane Publication1Txt;
    private JPanel Publication2;
    private JPanel Publication3;
  private JLabel UNPersonal;
  private JLabel F2;
  private JTextPane Publication2Txt;
  private JTextPane Publication3Txt;
  private JLabel F3;
  private JLabel F4;
  private JTextPane Publication4Txt;
  private JLabel F5;
  private JTextPane Publication5Txt;
  private JLabel T1;
  private JLabel T2;
  private JLabel T3;
  private JLabel T4;
  private JLabel T5;
  private JPanel Publication4;
  private JPanel Publication5;


  public Newsletter(int id) {
        setContentPane(Scroll);
        setTitle("Anuncios");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    for(int i = 0; i < 5; i++) {
      switch(i) {
        case 0:
          Publication1.setVisible(false);
          break;
        case 1:
          Publication2.setVisible(false);
          break;
        case 2:
          Publication3.setVisible(false);
          break;
        case 3:
          Publication4.setVisible(false);
          break;
        case 4:
          Publication5.setVisible(false);
          break;
      }
    }

    Connection connection;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(
              "select * from personal where idPersonal = '" + id + "'");
      resultSet.next();
      UNPersonal.setText(resultSet.getString("user"));
      resultSet.close();

      resultSet = statement.executeQuery(
              "select * from anuncio order by fechaPublicacion limit 5");
      int i = 0;
      while(resultSet.next()){
        if(i == 0) {
          Publication1.setVisible(true);
          T1.setText(resultSet.getString("titulo"));
          F1.setText(resultSet.getString("fechaPublicacion"));
          Publication1Txt.setText(resultSet.getString("contenido"));
        } else if(i == 1) {
          Publication2.setVisible(true);
          T2.setText(resultSet.getString("titulo"));
          F2.setText(resultSet.getString("fechaPublicacion"));
          Publication2Txt.setText(resultSet.getString("contenido"));
        } else if(i == 2) {
          Publication3.setVisible(true);
          T3.setText(resultSet.getString("titulo"));
          F3.setText(resultSet.getString("fechaPublicacion"));
          Publication3Txt.setText(resultSet.getString("contenido"));
        } else if(i == 3) {
          Publication4.setVisible(true);
          T4.setText(resultSet.getString("titulo"));
          F4.setText(resultSet.getString("fechaPublicacion"));
          Publication4Txt.setText(resultSet.getString("contenido"));
        } else if(i == 4) {
          Publication5.setVisible(true);
          T5.setText(resultSet.getString("titulo"));
          F5.setText(resultSet.getString("fechaPublicacion"));
          Publication5Txt.setText(resultSet.getString("contenido"));
        }
        i++;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

        Home.addActionListener(e -> {
            new Dashboard(id);
            setVisible(false);
            dispose();
        });
    }

//    public static void main(String[] args) {
//        new Newsletter(1);
//    }
}
