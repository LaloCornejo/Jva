import javax.swing.*;

public class Leaderboard extends JFrame {
    private JPanel ForoGUI;
    private JButton button1;
    private JButton Home;
    private JScrollPane ScrollLeaderbaord;
    private JPanel Users;
    private JLabel Place;
    private JLabel userName;
    private JLabel Elo;
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

    public Leaderboard(){
        setContentPane(ForoGUI);
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Home.addActionListener(e -> {
            new Dashboard();
            setVisible(false);
            dispose();
        });
    }

    public static void main(String[] args) {
        new Leaderboard();
    }
}
