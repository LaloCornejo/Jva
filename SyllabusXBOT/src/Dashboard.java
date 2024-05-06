import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dashboard extends JFrame {
    private JPanel Dashboard;
    private JButton PerfilButton;
    private JButton anunciosButton;
    private JButton ClasesButton;
    private JButton calendarioButton;
    private JButton leaderboardButton;
    private JLabel nameSpace;
    private JLabel usernameSpace;

    public Dashboard(int id) {
        setContentPane(Dashboard);
        setTitle("Dashboard");
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
            String name = resultSet.getString("nombre");
            String user = resultSet.getString("user");

            nameSpace.setText("Hello " + name);
            usernameSpace.setText(user);

        } catch (Exception e) {
            e.printStackTrace();
        }


        ClasesButton.addActionListener(e -> {
            new Clases(id);
            setVisible(false);
        });

        calendarioButton.addActionListener(e -> {
            new Calendario(id);
            setVisible(false);
            dispose();
        });

        PerfilButton.addActionListener(e -> {
            new Perfil(id);
            setVisible(false);
            dispose();
        });

        anunciosButton.addActionListener(e -> {
            new Newsletter(id);
            setVisible(false);
            dispose();
        });

        leaderboardButton.addActionListener(e -> {
            new Leaderboard(id);
            setVisible(false);
            dispose();
        });
    }
}
