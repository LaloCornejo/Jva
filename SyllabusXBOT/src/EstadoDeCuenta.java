import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EstadoDeCuenta extends JFrame {
    private JLabel fechaPago;
    private JLabel SaldoValor;
    private JPanel estadoCuenta;
    String fechainicioDB;
    String fechafinDB;
    int idEstPago;
    double mensualidadDB;
    double valorDB;
    boolean statusSesion = false;
    private JButton Pago;
    private JLabel fechaActual;
    private JButton eSesion;
    private JLabel nombreAlumno;

    public EstadoDeCuenta(int idAlumno) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from estadoPago where idAlumno = '" + idAlumno + "'");

            resultSet.next();
            mensualidadDB = resultSet.getDouble("mensualidad");
            valorDB = resultSet.getDouble("saldoValor");
            fechainicioDB = resultSet.getString("fechaInicial");
            fechafinDB = resultSet.getString("fechaFin");
            idEstPago = resultSet.getInt("idEstPago");
            resultSet.close();

            resultSet = statement.executeQuery(
                    "select * from perfil where idAlumno = '" + idAlumno + "'");
            resultSet.next();
            nombreAlumno.setText(resultSet.getString("nombre"));
            resultSet.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        setContentPane(estadoCuenta);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);

        esFechaPago(fechafinDB, idEstPago);

        fechaActual.setText(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));

        Pago.addActionListener(e -> {
            pagoWOO(idEstPago);
        });

        eSesion.addActionListener(e -> {
            if (!statusSesion) {
                setRango(fechaActual.getText());
                restarMensualidad(idEstPago);
                statusSesion = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ya hay sesion iniciada");
            }
        });
        fechaPago.setText(fechainicioDB + " - " + fechafinDB);
        SaldoValor.setText("$" + valorDB);
    }

    public void restarMensualidad(int idEstPago) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from estadoPago where idEstPago = '" + idEstPago + "'");
            resultSet.next();
            double saldo = resultSet.getDouble("saldoValor");
            double mensualidad = resultSet.getDouble("mensualidad");
            double saldoNuevo = saldo - mensualidad;
            statement.executeUpdate(
                    "UPDATE estadoPago SET saldoValor = '" + saldoNuevo + "' WHERE idEstPago = '" + idEstPago + "'");
            SaldoValor.setText("$" + saldoNuevo);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void esFechaPago(String fecha, int idEstPago) {
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
                    restarMensualidad(idEstPago);
                    statusSesion = false;
                    fechaPago.setText("? - ?");
                }
            }
        }
    }

    public void pagoWOO(int idEstPago) {
        getValorDB();
        if (valorDB >= 0) {
            JOptionPane.showMessageDialog(null, "No hay saldo pendiente");
            return;
        }
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from estadoPago where idEstPago = '" + idEstPago + "'");
            resultSet.next();
            double saldo = resultSet.getDouble("saldoValor");
            double saldoNuevo = saldo + mensualidadDB;
            statement.executeUpdate(
                    "UPDATE estadoPago SET saldoValor = '" + saldoNuevo + "' WHERE idAlumno = '" + 1 + "'");
            SaldoValor.setText("$" + saldoNuevo);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void getValorDB() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from estadoPago where idEstPago = '" + idEstPago + "'");
            resultSet.next();
            valorDB = resultSet.getDouble("saldoValor");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setRango(String sysDate) {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from estadoPago where idEstPago = '" + idEstPago + "'");
            resultSet.next();
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
            statement.executeUpdate(
                    "UPDATE `estadoPago` SET fechaInicial = '" + sysDate + "', fechaFin = '" + fechafinDB + "' WHERE idEstPago = '" + idEstPago + "'");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        new EstadoDeCuenta(1);
//    }
}
