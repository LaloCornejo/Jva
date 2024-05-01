import javax.swing.*;

public class Newsletter extends JFrame {
    private JScrollPane Scroll;
    private JPanel NewsletterGUI;
    private JButton button1;
    private JLabel Hero;
    private JButton Home;
    private JPanel Publication;
    private JLabel Username;
    private JTextPane Publication1Txt;
    private JPanel Publication2;
    private JPanel Publication3;


    public Newsletter() {
        setContentPane(Scroll);
        setTitle("Newsletter");
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
        new Newsletter();
    }
}
