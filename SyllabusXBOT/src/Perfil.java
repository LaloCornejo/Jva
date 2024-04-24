import javax.swing.*;

public class Perfil extends JFrame {
    private JButton button1;
    private JPanel pefilGUI;
    private JPanel Tourneys;
    private JPanel Publications;
    private JPanel Publication;
    private JTextPane Publication1Txt;
    private JLabel Username;

    public Perfil() {
        setVisible(true);
        setSize(1500, 950);
        setContentPane(pefilGUI);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Perfil();
    }
}
