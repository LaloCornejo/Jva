import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class Login extends JFrame {
    private JTextField textField1;
    private JPanel Login;
    private JPasswordField passwordField1;
    private JButton registerButton;
    private JButton loginButton;
    private JTextPane textPane1;
    private JButton logoHome;

    public Login() {

        setContentPane(Login);
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        logoHome.addActionListener(e -> {
            new Landing();
            setVisible(false);
            dispose();
        });

        loginButton.addActionListener(e -> {
            login();
        });

        textField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordField1.grabFocus();
                }
            }
        });

        passwordField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    public boolean passswordCheck(char[] password, char[] correctPassword) {
        System.out.println("checking password");
        System.out.println("Password: " + Arrays.toString(password));
        System.out.println("Correct Password: " + Arrays.toString(correctPassword));
        int i = 0;
        if (password.length != correctPassword.length) {
            return false;
        }
        for (char ch : password) {
            if (ch != correctPassword[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public void login() {
        String usuario = textField1.getText();
        char[] password = passwordField1.getPassword();

        System.out.println("Usuario: " + usuario);
        System.out.println("Password: " + Arrays.toString(password));

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from personal where user = '" + usuario + "'");

            resultSet.next();
            String user = resultSet.getString("user");
            char[] pass = resultSet.getString("password").toCharArray();
            int id = resultSet.getInt("idPersonal");
            int lvl = resultSet.getInt("nivel");

            System.out.println("User: " + user);
            System.out.println("Corr Password: " + Arrays.toString(pass));
            System.out.println("ID: " + id);

            if (usuario.equals(user) && passswordCheck(password, pass)) {
                if(lvl != 1){
                    new Dashboard(id);
                }else {
                    new AdminDashboard(id);
                }
                setVisible(false);
                dispose();
            } else {
                textPane1.setForeground(Color.red);
                textPane1.setText("Error: Usuario o contraseña invalido");
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}