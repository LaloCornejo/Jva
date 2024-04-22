import javax.swing.*;

public class Dashboard extends JFrame{
    private JPanel Dashboard;

    public Dashboard() {
        setContentPane(Dashboard);
        setTitle("Dashboard");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Dashboard dash = new Dashboard();
    }
}
