import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class modificaCampo extends JFrame {
    int valorCampo;
    private JPanel Login;
    private JTextField textField1;
    private JButton modificaButton;
    private JButton logoHome;
    public static boolean status = false;
    private Clases clasesInstance;

    public modificaCampo(int idClase, int campoModificar, Clases clasesInstance) {
        this.clasesInstance = clasesInstance;
        setContentPane(Login);
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        modificaButton.addActionListener(e -> {
            valorCampo = Integer.parseInt(textField1.getText());
            if (verificaCampo(valorCampo)) {
                Connection connection;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(
                            "select * from clase where idClase = '" + idClase + "'");
                    resultSet.next();
                  int rowsUpdated;
                  if (campoModificar == 1) {
                    rowsUpdated = statement.executeUpdate(
                            "UPDATE clase SET valorCampo1 = '" + valorCampo + "' WHERE idClase = '" + idClase + "'");
                  } else {
                    rowsUpdated = statement.executeUpdate(
                            "UPDATE clase SET valorCampo2 = '" + valorCampo + "' WHERE idClase = '" + idClase + "'");
                  }
                  if( rowsUpdated > 0){
                      System.out.println("upadted");
                      this.clasesInstance.update(idClase);
                  }else {
                      System.out.println("Error");
                      status = false;
                  }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                setVisible(false);
                dispose();
            } else {
                valorCampo = 0;
            }
            dispose();
        });

        textField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    valorCampo = Integer.parseInt(textField1.getText());
                    if (verificaCampo(valorCampo)) {
                        Connection connection;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(
                                    "select * from clase where idClase = '" + idClase + "'");
                            resultSet.next();
                            final modificaCampo self = modificaCampo.this;
                            if (campoModificar == 1) {
                                int rowsUpdated = statement.executeUpdate(
                                        "UPDATE clase SET valorCampo1 = '" + valorCampo + "' WHERE idClase = '" + idClase + "'");
                                if( rowsUpdated > 0){
                                    System.out.println("updated");
                                    self.clasesInstance.update(idClase);
                                }else {
                                    System.out.println("Error");
                                    status = false;
                                }
                            } else {
                                int rowsUpdated = statement.executeUpdate(
                                        "UPDATE clase SET valorCampo2 = '" + valorCampo + "' WHERE idClase = '" + idClase + "'");
                                if( rowsUpdated > 0){
                                    System.out.println("updated");
                                    self.clasesInstance.update(idClase);
                                }else {
                                    System.out.println("Error");
                                    status = false;
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        setVisible(false);
                        dispose();
                    } else {
                        valorCampo = 0;
                    }
                    dispose();
                }
            }
        });

        logoHome.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
    }

    private boolean verificaCampo(int valorCampo) {
        try {
            if (valorCampo < 0 || valorCampo > 100) {
                JOptionPane.showMessageDialog(null, "Error: El valor debe estar entre 0 y 100");
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Campo modificado con éxito");
                return true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un valor numérico");
            return false;
        }
    }
}