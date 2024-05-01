import javax.swing.*;

public class Clases extends JFrame{
    private JPanel misClases;
    private JButton recursosAdicionalesButton;
    private JButton contactoXCoachButton;
    private JTextPane nombre;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JButton homeButton;
    private JTextField searchField;

    public Clases(){
        setContentPane(misClases);
        setTitle("nombre");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        int[] prog = new int[2];
        prog[0] = 90;
        prog[1] = 47;

        homeButton.addActionListener(e -> {
            new Dashboard();
            setVisible(false);
            dispose();
        });

        progressBar1.setValue(prog[0]);
        progressBar1.setStringPainted(true);
        progressBar2.setValue(prog[1]);
        progressBar2.setStringPainted(true);
    }

    public static void main(String[] args) {
        Clases mC = new Clases();
    }

}
