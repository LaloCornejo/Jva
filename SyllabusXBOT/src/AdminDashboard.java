//Jesus Eduardo Cornejo Clavel
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class AdminDashboard extends JFrame {
    private JLabel usernameSpace;
    private JLabel nameSpace;
    private JPanel AdminDashboard;
    private JTable tablePersonal;
    private JButton agregarButton;
    private JTabbedPane tabbedPane1;
    private JTable tableAlumnos;
    private JButton modificarButton;
    private JButton borrarButton;
    private JTextField searchField;
    private JComboBox comboBox1;
    private JTable tableBusqueda;
    private JScrollPane P;
    private JScrollPane A;
    private JScrollPane B;
    private DefaultTableModel DTM = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    AdminDashboard(int id) {
        B.setVisible(false);
        setContentPane(AdminDashboard);
        setTitle("Admin Dashboard");
        setSize(1500, 950);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        modificarButton.setVisible(false);
        borrarButton.setVisible(false);

        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from personal where idPersonal = '" + id + "'");

            resultSet.next();
            String name = resultSet.getString("nombre");
            String user = resultSet.getString("user");

            nameSpace.setText("Hola Mr." + name);
            usernameSpace.setText(user);
            listar();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        agregarButton.addActionListener(e -> new Captura(id, this));

        searchField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = searchField.getText();
                    String selected = (String) comboBox1.getSelectedItem();
                    B.grabFocus();
                    B.setVisible(true);
                    assert selected != null;
                    tableBusqueda.setModel(Objects.requireNonNull(buscar(input, selected)));
                    clearSearchBar();
                }
            }
        });

        tablePersonal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (tabbedPane1.getSelectedComponent().equals(P)) {
                    System.out.println("aquiPersonal");
                    int row = tablePersonal.rowAtPoint(evt.getPoint());
                    int idPersona;
                    idPersona = (int) tablePersonal.getValueAt(row, 0);
                    System.out.println(idPersona);
                    modificarButton.setVisible(true);
                    borrarButton.setVisible(true);

                    for (ActionListener al : modificarButton.getActionListeners()) {
                        modificarButton.removeActionListener(al);
                    }
                    for (ActionListener al : borrarButton.getActionListeners()) {
                        borrarButton.removeActionListener(al);
                    }

                    modificarButton.addActionListener(e -> updateData(id, idPersona, 2));
                    borrarButton.addActionListener(e -> errase(idPersona, 2));
                }
            }
        });

        tableAlumnos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (tabbedPane1.getSelectedComponent().equals(A)) {
                    System.out.println("aquiAlumno");
                    int row = tableAlumnos.rowAtPoint(evt.getPoint());
                    int idPersona;
                    idPersona = (int) tableAlumnos.getValueAt(row, 0);
                    System.out.println(idPersona);
                    modificarButton.setVisible(true);
                    borrarButton.setVisible(true);

                    for (ActionListener al : modificarButton.getActionListeners()) {
                        modificarButton.removeActionListener(al);
                    }
                    for (ActionListener al : borrarButton.getActionListeners()) {
                        borrarButton.removeActionListener(al);
                    }

                    modificarButton.addActionListener(e -> updateData(id, idPersona, 1));
                    borrarButton.addActionListener(e -> errase(idPersona, 1));
                }
            }
        });

        tableBusqueda.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (tabbedPane1.getSelectedComponent().equals(B)) {
                    int row = tableBusqueda.rowAtPoint(evt.getPoint());
                    int idPersona;
                    idPersona = (int) tableBusqueda.getValueAt(row, 0);
                    System.out.println(idPersona);
                    modificarButton.setVisible(true);
                    borrarButton.setVisible(true);

                    for (ActionListener al : modificarButton.getActionListeners()) {
                        modificarButton.removeActionListener(al);
                    }
                    for (ActionListener al : borrarButton.getActionListeners()) {
                        borrarButton.removeActionListener(al);
                    }

                    modificarButton.addActionListener(e -> updateData(id, idPersona, comboBox1.getSelectedIndex() + 1));
                    borrarButton.addActionListener(e -> errase(idPersona, comboBox1.getSelectedIndex() + 1));
                }
            }
        });
    }

    private DefaultTableModel setTitulos(int tipo) {
        DTM = new DefaultTableModel();
        if (tipo == 1) {
            DTM = new DefaultTableModel();
            DTM.addColumn("ID");
            DTM.addColumn("Nombre");
            DTM.addColumn("Usuario");
            DTM.addColumn("Email");
            DTM.addColumn("Telefono");
        } else {
            DTM = new DefaultTableModel();
            DTM.addColumn("ID");
            DTM.addColumn("Nombre");
            DTM.addColumn("Apellido");
            DTM.addColumn("Telefono Tutor");
            DTM.addColumn("Fecha Nacimiento");
        }
        return DTM;
    }

    private DefaultTableModel getDataPersonal() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            PreparedStatement PS;
            ResultSet resultSet;
            PS = connection.prepareStatement("SELECT * FROM personal");
            resultSet = PS.executeQuery();
            Object[] row = new Object[6];
            setTitulos(1);
            while (resultSet.next()) {
                dataRowsPersonal(resultSet, row);
                DTM.addRow(row);
            }
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return DTM;
    }

    private void dataRowsPersonal(ResultSet resultSet, Object[] row) throws SQLException {
        row[0] = resultSet.getInt("idPersonal");
        row[1] = resultSet.getString("user");
        row[2] = resultSet.getString("nombre");
        row[3] = resultSet.getString("email");
        row[4] = resultSet.getString("telefono");
        row[5] = resultSet.getInt("nivel");
    }

    private DefaultTableModel getDataAlumno() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            PreparedStatement PS;
            ResultSet resultSet;
            PS = connection.prepareStatement("SELECT * FROM alumno");
            resultSet = PS.executeQuery();
            Object[] row = new Object[5];
            setTitulos(2);
            while (resultSet.next()) {
                row[0] = resultSet.getInt("idAlumno");
                row[1] = resultSet.getString("nombre");
                row[2] = resultSet.getString("appellido");
                row[3] = resultSet.getString("telefonoTutor");
                row[4] = resultSet.getDate("fechaNac");
                DTM.addRow(row);
            }
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return DTM;
    }

    private void errase(int id, int type) {
        int resul;
        String SQL = switch (type) {
            case 1 -> "DELETE FROM alumno WHERE idAlumno = '" + id + "'";
            case 2 -> "DELETE from personal WHERE idPersonal = '" + id + "' ";
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
            PreparedStatement PS;
            PS = connection.prepareStatement(SQL);
            resul = PS.executeUpdate();
            if (resul > 0)
                JOptionPane.showMessageDialog(null, ":)");
            else
                JOptionPane.showMessageDialog(null, ":(");

            listar();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void listar() {
        tableAlumnos.setModel(getDataAlumno());
        tablePersonal.setModel(getDataPersonal());
    }

    private void updateData(int idUsuario, int id, int type) {
        System.out.println("aqui: " + id + " " + type + " " + idUsuario);
        new Modificar(idUsuario, id, type, this);
    }

    private DefaultTableModel buscar(String input, String selected) {
        switch (selected) {
            case "Personal":
                if (esNumero(input)) {
                    Connection connection;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(
                                "select * from personal where idPersonal = '" + input + "'");
                        return modelPersonal(resultSet);
                    } catch (SQLException | ClassNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                } else {
                    Connection connection;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT * FROM personal WHERE user LIKE '"+input+"%' OR nombre LIKE '" + input + "%'");
                        return modelPersonal(resultSet);
                    } catch (SQLException | ClassNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                }
                break;
            case "Alumno":
                if (esNumero(input)) {
                    Connection connection;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(
                                "select * from alumno where idAlumno = '" + input + "'");
                        return modelAlumno(resultSet);
                    } catch (SQLException | ClassNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                } else {
                    Connection connection;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/syllabus", "root", "password");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(
                                "select * from alumno where nombre like '" + input + "%'");
                        return modelAlumno(resultSet);
                    } catch (SQLException | ClassNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                }
                break;
        }
        return null;
    }

    private DefaultTableModel modelPersonal(ResultSet resultSet) throws SQLException {
        DefaultTableModel model;
        Object[] row = new Object[6];
        model = setTitulos(1);
        while (resultSet.next()) {
            dataRowsPersonal(resultSet, row);
            model.addRow(row);
        }
        return model;
    }

    private DefaultTableModel modelAlumno(ResultSet resultSet) throws SQLException {
        DefaultTableModel model;
        Object[] row = new Object[5];
        model = setTitulos(2);
        while (resultSet.next()) {
            row[0] = resultSet.getInt("idAlumno");
            row[1] = resultSet.getString("nombre");
            row[2] = resultSet.getString("appellido");
            row[3] = resultSet.getString("telefonoTutor");
            row[4] = resultSet.getDate("fechaNac");
            model.addRow(row);
        }
        return model;
    }

    private void clearSearchBar() {
        searchField.setText("");
    }

    private boolean esNumero(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new AdminDashboard(2);
    }
}
