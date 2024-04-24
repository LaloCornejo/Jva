import javax.swing.*;

public class EstadoDeCuenta extends JFrame {
    private JLabel fechaPago;
    private JLabel SaldoValor;
    private JPanel estadoCuenta;

    public EstadoDeCuenta() {
        String fechaDB  = "15.12.2024";
        double valorDB = 1500.00;
        setContentPane(estadoCuenta);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);

        fechaPago.setText(fechaDB);
        SaldoValor.setText("$"+valorDB);
    }

    public static void main(String[] args) {
        new EstadoDeCuenta();
    }
}
