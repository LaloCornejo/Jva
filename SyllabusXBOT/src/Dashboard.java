import javax.swing.*;


public class Dashboard extends JFrame {
    private JPanel Dashboard;
    private JButton PerfilButton;
    private JButton anunciosButton;
    private JButton ClasesButton;
    private JButton calendarioButton;
    private JButton leaderboardButton;
    private JLabel nameSpace;

    public Dashboard() {
        setContentPane(Dashboard);
        setTitle("Dashboard");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        ClasesButton.addActionListener(e ->{
            new Clases();
            setVisible(false);
        });

        calendarioButton.addActionListener(e-> {
            new Calendario();
            setVisible(false);
            dispose();
        });

        PerfilButton.addActionListener(e -> {
            new Perfil();
            setVisible(false);
            dispose();
        });

        anunciosButton.addActionListener(e -> {
            new Newsletter();
            setVisible(false);
            dispose();
        });

        leaderboardButton.addActionListener(e -> {
            new Leaderboard();
            setVisible(false);
            dispose();
        });
    }

    public static void main(String[] args) {
        Dashboard dash = new Dashboard();
    }
}
