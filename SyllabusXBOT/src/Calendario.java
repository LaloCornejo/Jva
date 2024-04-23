import javax.swing.*;

public class Calendario extends JFrame {
    private JPanel Calendario;
    private JButton homeButton;
    private JTextPane calendarioText;
    private JTabbedPane semesterCalendar;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a15Button;
    private JButton a20Button;
    private JButton a25Button;
    private JButton a29Button;
    private JPanel Febrero;
    private JPanel Marzo;
    private JPanel Abril;
    private JPanel Mayo;
    private JPanel Junio;

    public Calendario() {
        setContentPane(Calendario);
        setTitle("Calendario");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        homeButton.addActionListener(e -> {
            setVisible(false);
            new Dashboard();
            dispose();
        });
    }

    public static void main(String[] args) {
        new Calendario();
    }
}
