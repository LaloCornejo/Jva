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
    public int P1 = 0, P2 = 0;
    private JButton modificaAvanceC1Button;
    private JButton modificaAvanceC2Button;
    private JLabel campo1Button;
    private JLabel campo2Button;

    public Clases(){
        setContentPane(misClases);
        setTitle("nombre");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        actualizarCampos();

        homeButton.addActionListener(e -> {
            new Dashboard();
            setVisible(false);
            dispose();
        });

        modificaAvanceC1Button.addActionListener(e -> {
            setModificaAvanceC1Button();
        });

        modificaAvanceC2Button.addActionListener(e -> {
            setModificaAvanceC2Button();
        });
    }

    public void setModificaAvanceC1Button() {
        new modificaCampo();
        actualizarCampos();
    }

    public void setModificaAvanceC2Button() {
        new modificaCampo();
        P2 = modificaCampo.valorCampo;
        System.out.println(P1);
        System.out.println(P2);
        actualizarCampos();
    }

    public void actualizarCampos() {
        progressBar2.setValue(P1);
        progressBar1.setValue(P2);
    }

    public static void main(String[] args) {
        Clases mC = new Clases();
    }

}
