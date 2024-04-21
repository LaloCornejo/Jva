package SchoolPOO.pck_Casa;
import javax.swing.JOptionPane;
public class CasaTest {
  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, Casa.getAreasVerdes());
    
    Casa casa1 = new Casa(4, 1, 2.5f);
    Casa casa2 = new Casa(3, 2, 3.5f);

    JOptionPane.showMessageDialog(null, casa1.getDatos());
    JOptionPane.showMessageDialog(null, casa1.getAreasVerdes());
    JOptionPane.showMessageDialog(null, casa2.getDatos());
    JOptionPane.showMessageDialog(null, casa2.getAreasVerdes());
    
    Casa.setAreasVerdes(6);
    JOptionPane.showMessageDialog(null, Casa.getAreasVerdes());
    JOptionPane.showMessageDialog(null, casa2.getAreasVerdes());
  }
}
