import javax.swing.*;


public class Dashboard extends JFrame {
    private JPanel Dashboard;
    private JButton miPerfilButton;
    private JButton newsletterButton;
    private JButton misClasesButton;
    private JButton calendarioButton;
    private JButton foroButton;
    private JButton leaderboardButton;

    public Dashboard() {
        setContentPane(Dashboard);
        setTitle("Dashboard");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        misClasesButton.addActionListener(e ->{
            new MisClases();
            setVisible(false);
        });

        calendarioButton.addActionListener(e-> {
            new Calendario();
            setVisible(false);
            dispose();
        });

        miPerfilButton.addActionListener(e -> {
            new Perfil();
            setVisible(false);
            dispose();
        });

        foroButton.addActionListener(e -> {
            new Foro();
            setVisible(false);
            dispose();
        });

        newsletterButton.addActionListener(e -> {
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
