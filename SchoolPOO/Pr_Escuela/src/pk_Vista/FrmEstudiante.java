package pk_Vista;

import com.toedter.calendar.JDateChooser;
import pk_Modelo.Cs_Estudiante;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrmEstudiante extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox Sem;
    private JComboBox Grupo;
    private JTextField textField3;
    private JComboBox Lice;
    private JRadioButton regularRadioButton;
    private JRadioButton irregularRadioButton;
    private JCheckBox saludCheckBox;
    private JCheckBox arteCheckBox;
    private JComboBox comboBox3;
    private JTextField textField5;
    private JButton buscarButton;
    private JTable table1;
    private JButton altaButton;
    private JButton bajaButton;
    private JDateChooser jdcFechaI;
    private JDateChooser jdcFechaE;
    private JButton actualizarButton;
    private JPanel Form;
    private final Cs_Estudiante estudiante;
    private void createUIComponents() {
        jdcFechaI = new JDateChooser();
        jdcFechaE = new JDateChooser();
    }



    public FrmEstudiante() {
        estudiante = new Cs_Estudiante();
        listar();
        setContentPane(Form);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setTitle("Estudiantes");
        setLocationRelativeTo(null);

        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                altaButtonActionPerformed(e);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarButtonActionPerformed(e);
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table1.getSelectedRow();
                textField1.setText(table1.getValueAt(row, 0).toString());
                textField2.setText(table1.getValueAt(row, 1).toString());
                Sem.setSelectedItem(table1.getValueAt(row, 2).toString());
                Grupo.setSelectedItem(table1.getValueAt(row, 3).toString());
                Lice.setSelectedItem(table1.getValueAt(row, 4).toString());
                textField3.setText(table1.getValueAt(row, 5).toString());
                if (table1.getValueAt(row, 6).toString().equals("Regular")) {
                    regularRadioButton.setSelected(true);
                } else if (table1.getValueAt(row, 6).toString().equals("Irregular")) {
                    irregularRadioButton.setSelected(true);
                }
                if (table1.getValueAt(row, 7).toString().equals("Sí")) {
                    saludCheckBox.setSelected(true);
                } else {
                    saludCheckBox.setSelected(false);
                }
                if (table1.getValueAt(row, 8).toString().equals("Sí")) {
                    arteCheckBox.setSelected(true);
                } else {
                    arteCheckBox.setSelected(false);
                }
                comboBox3.setSelectedIndex(0);
                textField5.setText("");
                jdcFechaI.setDate((Date) table1.getValueAt(row, 9));
                jdcFechaE.setDate((Date) table1.getValueAt(row, 10));
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateButtonActionPerformed(e);
            }
        });

        bajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });
    }

    private void listar() {
        table1.setModel(estudiante.getData());
    }

    public void clean() {
        textField1.setText("");
        textField2.setText("");
        Sem.setSelectedIndex(0);
        Grupo.setSelectedIndex(0);
        textField3.setText("");
        Lice.setSelectedIndex(0);
        regularRadioButton.setSelected(true);
        saludCheckBox.setSelected(false);
        arteCheckBox.setSelected(false);
        comboBox3.setSelectedIndex(0);
        textField5.setText("");
        jdcFechaI.setDate(null);
        jdcFechaE.setDate(null);
    }

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        table1.setModel(estudiante.buscarDato(comboBox3.getSelectedIndex(), textField5.getText()));
    }

    private void altaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int nc = Integer.parseInt(textField1.getText());
        String nom = textField2.getText();
        int sem = Integer.parseInt(Sem.getSelectedItem().toString());
        int gpo = Integer.parseInt(Grupo.getSelectedItem().toString());
        String lic = Lice.getSelectedItem().toString();
        float prom = Float.parseFloat(textField3.getText());
        String est = null;
        if (regularRadioButton.isSelected()) {
            est = "Regular";
        } else if (irregularRadioButton.isSelected()) {
            est = "Irregular";
        }
        String tSalud = saludCheckBox.isSelected() ? "Sí" : "No";
        String tArte = arteCheckBox.isSelected() ? "Sí" : "No";

        Date dateI = jdcFechaI.getDate();
        long dI = dateI.getTime();
        java.sql.Date fechaI = new java.sql.Date(dI);

        java.sql.Date fechaE;
        Date dateE = jdcFechaE.getDate();

        if (dateE != null) {
            long dE = dateE.getTime();
            fechaE = new java.sql.Date(dE);
        } else {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.format(date);
            jdcFechaE.setDate(date);
            long dE = date.getTime();
            fechaE = new java.sql.Date(dE);
        }

        if (estudiante.insertData(nc, nom, sem, gpo, lic, prom, est, tSalud, tArte, fechaI, fechaE) > 0) {
            listar();
            JOptionPane.showMessageDialog(null, "Inserción exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            clean();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la inserción", "Error", JOptionPane.ERROR_MESSAGE);
            clean();
        }
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt ){
        int nc = Integer.parseInt(textField1.getText());
        String nom = textField2.getText();
        int sem = Integer.parseInt(Sem.getSelectedItem().toString());
        int gpo = Integer.parseInt(Grupo.getSelectedItem().toString());
        String lic = Lice.getSelectedItem().toString();
        float prom = Float.parseFloat(textField3.getText());
        String est = null;
        if (regularRadioButton.isSelected()) {
            est = "Regular";
        } else if (irregularRadioButton.isSelected()) {
            est = "Irregular";
        }
        String tSalud = saludCheckBox.isSelected() ? "Sí" : "No";
        String tArte = arteCheckBox.isSelected() ? "Sí" : "No";

        Date dateI = jdcFechaI.getDate();
        long dI = dateI.getTime();
        java.sql.Date fechaI = new java.sql.Date(dI);

        java.sql.Date fechaE;
        Date dateE = jdcFechaE.getDate();

        if (dateE != null) {
            long dE = dateE.getTime();
            fechaE = new java.sql.Date(dE);
        } else {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.format(date);
            jdcFechaE.setDate(date);
            long dE = date.getTime();
            fechaE = new java.sql.Date(dE);
        }

        if (estudiante.updateData(nc, nom, sem, gpo, lic, prom, est, tSalud, tArte, fechaI, fechaE) > 0) {
            listar();
            JOptionPane.showMessageDialog(null, "Actualización exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            clean();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización", "Error", JOptionPane.ERROR_MESSAGE);
            clean();
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int nc = Integer.parseInt(textField1.getText());
        if (estudiante.deleteRegistro(nc) > 0) {
            listar();
            JOptionPane.showMessageDialog(null, "Eliminación exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            clean();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación", "Error", JOptionPane.ERROR_MESSAGE);
            clean();
        }
    }
}
