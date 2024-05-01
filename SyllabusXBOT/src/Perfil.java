import javax.swing.*;

public class Perfil extends JFrame {
    private JButton button1;
    private JPanel pefilGUI;
    private JPanel Tourneys;
    private JPanel Publications;
    private JPanel Publication;
    private JTextPane Publication1Txt;
    private JLabel Username;
    private JPanel Publication2;
    private JPanel Publication3;
    private JPanel Medallas;
    private JScrollPane Scroll;
    private JButton Home;
    private JLabel Hero;

    public Perfil() {
        Scroll = new JScrollPane(pefilGUI);
        setVisible(true);
        setSize(1500, 950);
        setContentPane(Scroll);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Home.addActionListener(e -> {
            setVisible(false);
            new Dashboard();
            dispose();
        });
    }

    public static void main(String[] args) {
        new Perfil();
    }
}
