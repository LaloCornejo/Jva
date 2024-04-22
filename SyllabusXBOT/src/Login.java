import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JTextField textField1;
    private JPanel Login;
    private JPasswordField passwordField1;
    private JButton registerButton;
    private JButton loginButton;
    private JTextPane textPane1;

    public Login() {
        setContentPane(Login);
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        loginButton.addActionListener(e -> {
            String usuario = textField1.getText();
            char[] password = passwordField1.getPassword();

            if (usuario.equals("root") && passswordCheck(password)) {
                Dashboard dash = new Dashboard();
                setVisible(false);
                dispose();
            }else {
                textPane1.setText("Error: Usuario o contrasena invalido");
                textPane1.setForeground(Color.red);
            }
            System.out.println("Login");
            System.out.println(usuario);
            System.out.println(password);
        });
    }

    public static void main(String[] args) {
        Login login = new Login();
    }


    public boolean passswordCheck(char[] password) {
        String master = "root";
        int i = 0;
        for (char ch : password) {
            if (ch != password[i]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
