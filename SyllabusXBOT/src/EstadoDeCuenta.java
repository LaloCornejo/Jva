import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EstadoDeCuenta extends JFrame {
    private JLabel fechaPago;
    private JLabel SaldoValor;
    private JPanel estadoCuenta;
    String fechainicioDB = "15.12.2024";
    String fechafinDB = "02.05.2024";
    double mensualidadDB = 1500.00;
    double valorDB = 1500.00;
    boolean statusSesion = false;
    private JButton Pago;
    private JLabel fechaActual;
    private JButton eSesion;

    public EstadoDeCuenta() {
        setContentPane(estadoCuenta);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);

        esFechaPago(fechafinDB);

        fechaActual.setText(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));

        Pago.addActionListener(e -> {
            pagoWOO();
        });

        eSesion.addActionListener(e -> {
            if (!statusSesion) {
                setRango(fechaActual.getText());
                restarMensualidad(mensualidadDB);
                statusSesion = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ya hay sesion iniciada");
            }
        });

        fechaPago.setText(fechainicioDB + " - " + fechafinDB);
        SaldoValor.setText("$" + valorDB);
    }

    public void restarMensualidad(double mensualidad) {
        valorDB -= mensualidad;
        SaldoValor.setText("$"+valorDB);
    }

    public void esFechaPago(String fecha) {
        int dia = Integer.parseInt(fecha.substring(0, 2));
        int mes = Integer.parseInt(fecha.substring(3, 5));
        int anio = Integer.parseInt(fecha.substring(6));

        String sysDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        int sysdia = Integer.parseInt(sysDate.substring(0, 2));
        int sysmes = Integer.parseInt(sysDate.substring(3, 5));
        int sysanio = Integer.parseInt(sysDate.substring(6));

        if (sysanio >= anio) {
            if (sysmes >= mes) {
                if (sysdia >= dia) {
                    restarMensualidad(mensualidadDB);
                    statusSesion = false;
                    fechaPago.setText("? - ?");
                }
            }
        }
    }

    public void pagoWOO() {
        if (valorDB >= 0) {
            JOptionPane.showMessageDialog(null, "No hay saldo pendiente");
            return;
        }
        valorDB += mensualidadDB;
        SaldoValor.setText("$" + valorDB);
    }

    public void setRango(String sysDate) {
        fechainicioDB = sysDate;
        int dia = Integer.parseInt(sysDate.substring(0, 2));
        int mes = Integer.parseInt(sysDate.substring(3, 5));
        int anio = Integer.parseInt(sysDate.substring(6));

        if (mes == 12) {
            mes = 1;
            anio += 1;
            fechafinDB = dia + "." + mes + "." + anio;
        } else {
            mes += 1;
            String Sdia = null;
            if (dia < 10) {
                Sdia = "0" + dia;
            }
            String Smes = null;
            if (mes < 10) {
                Smes = "0" + mes;
            }
            fechafinDB = Sdia + "." + Smes + "." + anio;
        }

        fechaPago.setText(fechainicioDB + " - " + fechafinDB);
    }

    public static void main(String[] args) {
        new EstadoDeCuenta();
    }
}
