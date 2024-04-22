import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JPanel Dashboard;
    private JButton miPerfilButton;
    private JButton newsletterButton;
    private JButton misClasesButton;
    private JButton calendarioButton;
    private JButton foroButton;
    private JButton leaderboardButton;
    private JTextPane UserNameTextPane;

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
    }

    public static void main(String[] args) {
        Dashboard dash = new Dashboard();
    }
}
