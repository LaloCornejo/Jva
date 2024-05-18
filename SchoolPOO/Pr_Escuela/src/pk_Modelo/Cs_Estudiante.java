package pk_Modelo;

import Pk_Connection.Connection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cs_Estudiante {
    private PreparedStatement PS;
    private DefaultTableModel DTM;
    private final Connection connection;
    private ResultSet RS;

    public Cs_Estudiante() {
        this.PS = null;
        this.connection = new Connection();
    }

    private DefaultTableModel setTitulos() {
        DTM = new DefaultTableModel();
        DTM.addColumn("No. Cuenta");
        DTM.addColumn("Nombre");
        DTM.addColumn("Semestre");
        DTM.addColumn("Grupo");
        DTM.addColumn("Licenciatura");
        DTM.addColumn("Promedio");
        DTM.addColumn("Estatus");
        DTM.addColumn("Salud");
        DTM.addColumn("Arte");
        DTM.addColumn("Fecha Ingreso");
        DTM.addColumn("Fecha Egreso");
        return DTM;
    }

    public int insertData(int nc, String nom, int sem, int gpo, String lic, float prom, String est, String tSalud, String tArte, Date fechaI, Date fechaE) {
        int result = 0;
        try {
            String sqlInsert = "INSERT INTO estudiante VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PS = connection.getConnection().prepareStatement(sqlInsert);
            PS.setInt(1, nc);
            PS.setString(2, nom);
            PS.setInt(3, sem);
            PS.setInt(4, gpo);
            PS.setString(5, lic);
            PS.setFloat(6, prom);
            PS.setString(7, est);
            PS.setString(8, tSalud);
            PS.setString(9, tArte);
            PS.setDate(10, fechaI);
            PS.setDate(11, fechaE);
            result = PS.executeUpdate();
//            if (result > 0) {
//                JOptionPane.showMessageDialog(null, "Inserción exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "No se pudo realizar la inserción", "Error", JOptionPane.ERROR_MESSAGE);
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la inserción de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                PS = null;
                connection.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }

    public DefaultTableModel getData() {
        try {
            String sqlSelect = "SELECT * FROM estudiante";
            PS = connection.getConnection().prepareStatement(sqlSelect);
            RS = PS.executeQuery();
            Object[] row = new Object[11];
            setTitulos();
            while (RS.next()) {
                row[0] = RS.getInt(1);
                row[1] = RS.getString(2);
                row[2] = RS.getInt(3);
                row[3] = RS.getInt(4);
                row[4] = RS.getString(5);
                row[5] = RS.getFloat(6);
                row[6] = RS.getString(7);
                row[7] = RS.getString(8);
                row[8] = RS.getString(9);
                row[9] = RS.getDate(10);
                row[10] = RS.getDate(11);
                DTM.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        } finally {
            try {
                PS = null;
                RS = null;
                connection.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return DTM;
    }

    public DefaultTableModel buscarDato(int crit, String param) {
        String SQL = switch (crit) {
            case 0 -> "SELECT * FROM estudiante WHERE noCuenta = '" + param + "'";
            case 1 -> "SELECT * FROM estudiante WHERE nombre like '" + param + "%'";
            default -> null;
        };
        try {
            PS = connection.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] row = new Object[11];
            setTitulos();
            while (RS.next()) {
                row[0] = RS.getInt(1);
                row[1] = RS.getString(2);
                row[2] = RS.getInt(3);
                row[3] = RS.getInt(4);
                row[4] = RS.getString(5);
                row[5] = RS.getFloat(6);
                row[6] = RS.getString(7);
                row[7] = RS.getString(8);
                row[8] = RS.getString(9);
                row[9] = RS.getDate(10);
                row[10] = RS.getDate(11);
                DTM.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        } finally {
            try {
                PS = null;
                RS = null;
                connection.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return DTM;
    }

    public int updateData(int nc, String nom, int sem, int gpo, String lic, float prom, String est, String tSalud, String tArte, Date fechaI, Date fechaE) {
        int result = 0;
        try {
            String sqlUpdate = "UPDATE estudiante SET nombre = ?, semestre = ?, grupo = ?, licenciatura = ?, promeadio = ?, status = ?, tallerSalud = ?, tallerArtes = ?, fechaIngreso = ?, fechaEgreso = ? WHERE noCuenta = ?";
            PS = connection.getConnection().prepareStatement(sqlUpdate);
            PS.setString(1, nom);
            PS.setInt(2, sem);
            PS.setInt(3, gpo);
            PS.setString(4, lic);
            PS.setFloat(5, prom);
            PS.setString(6, est);
            PS.setString(7, tSalud);
            PS.setString(8, tArte);
            PS.setDate(9, fechaI);
            PS.setDate(10, fechaE);
            PS.setInt(11, nc);
            result = PS.executeUpdate();
//            if (result > 0) {
//                JOptionPane.showMessageDialog(null, "Actualización exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización", "Error", JOptionPane.ERROR_MESSAGE);
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la actualización de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                PS = null;
                connection.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }

    public int deleteRegistro(int nc){
        int result = 0;
        try {
            String sqlDelete = "DELETE FROM estudiante WHERE noCuenta = ?";
            PS = connection.getConnection().prepareStatement(sqlDelete);
            PS.setString(1, String.valueOf(nc));
            result = PS.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                PS = null;
                connection.getConnection().close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }
}
