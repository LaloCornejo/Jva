import javax.swing.*;

public class modificaCampo extends JFrame {
    public static int valorCampo;
    int campo;
    private JPanel Login;
    private JTextField textField1;
    private JButton modificaButton;
    private JButton logoHome;

    public modificaCampo() {
        setContentPane(Login);
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        modificaButton.addActionListener(e -> {
            valorCampo = Integer.parseInt(textField1.getText());
            if (verificaCampo(valorCampo)) {
                setVisible(false);
                dispose();
            } else {
                valorCampo = -1;
            }
        });

        logoHome.addActionListener(e -> {
            new Dashboard();
            setVisible(false);
            dispose();
        });

    }

    public int getValorCampo() {
        return valorCampo;
    }

    public void setCampo(int campo) {
        this.campo = campo;
    }

    private boolean verificaCampo(int valorCampo) {
        try {
            if (valorCampo < 0 || valorCampo > 100) {
                JOptionPane.showMessageDialog(null, "Error: El valor debe estar entre 0 y 100");
                valorCampo = -1;
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Campo modificado con éxito");
                return true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico");
            valorCampo = -1;
            return false;
        }
    }
}