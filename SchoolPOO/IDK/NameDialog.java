package SchoolPOO.IDK;
import javax.swing.JOptionPane;

public class NameDialog {
    public static void main( String[] srgs ){

        String name = JOptionPane.showInputDialog("Whats ur name");

        String message = String.format("Welcome, %s, to Java Programming!", name);

        JOptionPane.showMessageDialog(null, message);
    }
}
