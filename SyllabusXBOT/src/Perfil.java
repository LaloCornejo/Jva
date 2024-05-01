import javax.swing.*;

public class Perfil extends JFrame {
    private JButton button1;
    private JPanel pefilGUI;
    private JPanel Tourneys;
    private JPanel Medallas;
    private JScrollPane Scroll;
    private JButton Home;
    private JLabel Hero;
    private JTextField searchField;
    private JPanel Bio;
    private JLabel bio;
    private JTextPane Descripcion;
    private JLabel nombreCompleto;

    public Perfil() {
        setContentPane(Scroll);
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

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
