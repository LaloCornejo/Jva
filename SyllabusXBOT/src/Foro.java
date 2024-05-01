import javax.swing.*;

public class Foro extends JFrame {
    private JScrollPane Scroll;
    private JPanel ForoGUI;
    private JButton button1;
    private JLabel Hero;
    private JButton Home;
    private JPanel Posts;
    private JPanel Publication;
    private JLabel Username;
    private JTextPane Publication1Txt;
    private JPanel Publication2;
    private JPanel Publication3;
    private JButton foroNameButton;
    private JButton foroNameButton1;
    private JButton foroNameButton2;
    private JPanel NewPost;
    private JTextField PostContent;
    private JButton postButton;

    public Foro() {
        setSize(1500, 950);
        setContentPane(Scroll);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Home.addActionListener(e -> {
            new Dashboard();
            setVisible(false);
            dispose();
        });
    }

    public static void main(String[] args) {
        Foro foro = new Foro();
    }
}
