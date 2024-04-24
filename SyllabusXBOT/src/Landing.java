import javax.swing.*;

public class Landing extends JFrame{
    private JButton conocenosButton;
    private JButton misionButton;
    private JButton visionButton;
    private JButton loginButton;
    private JPanel LandingPage;

    public Landing() {
        setContentPane(LandingPage);
        setTitle("Landing");
        setSize(1500, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        loginButton.addActionListener( e -> {
            setVisible(false);
            new Login();
            dispose();
        });
    }

    public static void main(String[] args) {
        Landing landing = new Landing();
    }
}
