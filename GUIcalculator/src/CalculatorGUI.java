import javax.swing.*;

public class CalculatorGUI extends JFrame {
    private JTextField num1TextField;
    private JTextField num2TextField;
    private JButton Suma;
    private JButton Division;
    private JButton Multiplicacion;
    private JButton Resta;
    private JButton Modulo;
    private JButton Limpiar;
    private JTextArea textArea;
    private JPanel mainPanel;

    private double num1 = 0, num2 = 0;

    public CalculatorGUI() {
        setContentPane(mainPanel);
        setTitle("Calculadora");
        setSize(1000, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Suma.addActionListener(e -> {
            try{
                num1 = Double.parseDouble(num1TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num1");
                num1 = 0;
            }
            try{
                num2 = Double.parseDouble(num2TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num2");
                num2 = 0;
            }
            double resultado = num1 + num2;
            textArea.setText(String.valueOf(resultado));
            System.out.println(resultado);
        });

        Resta.addActionListener(e -> {
            try{
                 num1 = Double.parseDouble(num1TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num1");
                 num1 = 0;
            }
            try{
                 num2 = Double.parseDouble(num2TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num2");
                 num2 = 0;
            }
            double resultado = num1 - num2;
            textArea.setText(String.valueOf(resultado));
            System.out.println(resultado);
        });

        Multiplicacion.addActionListener(e -> {
            try{
                num1 = Double.parseDouble(num1TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num1");
                num1 = 0;
            }
            try{
                num2 = Double.parseDouble(num2TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num2");
                num2 = 0;
            }
            double resultado = num1 * num2;
            textArea.setText(String.valueOf(resultado));
            System.out.println(resultado);
        });

        Division.addActionListener(e -> {
            try{
                num1 = Double.parseDouble(num1TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num1");
                num1 = 0;
            }
            try{
                num2 = Double.parseDouble(num2TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num2");
                num2 = 0;
            }
            if (num2 == 0.0) {
                textArea.setText("Error: División entre zero");
            } else {
                double resultado = num1 / num2;
                textArea.setText(String.valueOf(resultado));
                System.out.println(resultado);
            }
        });

        Modulo.addActionListener(e -> {
            try{
                num1 = Double.parseDouble(num1TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num1");
                num1 = 0;
            }
            try{
                num2 = Double.parseDouble(num2TextField.getText());
            }catch( NumberFormatException error) {
                textArea.setText("Error: Input Num2");
                num2 = 0;
            }
            if (num2 == 0.0) {
                textArea.setText("Error: Módulo con base 0");
            } else {
                double resultado = num1 % num2;
                textArea.setText(String.valueOf(resultado));
                System.out.println(resultado);
            }
        });

        Limpiar.addActionListener(e -> {
            num1TextField.setText("");
            num2TextField.setText("");
            textArea.setText("");
        });
    }

    public static void main(String[] args) {
        CalculatorGUI myCalculator = new CalculatorGUI();
    }
}


