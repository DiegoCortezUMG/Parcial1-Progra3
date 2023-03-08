/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.clsMaestrosP1;
import controlador.clsConexionP1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */

/**
 *
 * @author Inkunzy
 */
public class daoMaestrosP1 {

    private static final String SQL_SELECT = "SELECT codigo_maestro, nombre_maestros, direccion_maestros, telefono_maetro, email_maestros, estatus_maestros FROM maestros";
    private static final String SQL_INSERT = "INSERT INTO maestros(codigo_maestro, nombre_maestros, direccion_maestros, telefono_maetro, email_maestros, estatus_maestros) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE maestros SET codigo_maestro=?, nombre_maestros=?, direccion_maestros=?, telefono_maetro=?, email_maestros=?, estatus_maestros=? WHERE codigo_maestro = ?";
    private static final String SQL_DELETE = "DELETE FROM maestros WHERE codigo_maestro=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_maestro, nombre_maestros, direccion_maestros, telefono_maetro, email_maestros, estatus_maestros FROM maestros WHERE nombre_maestro = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_maestro, nombre_maestros, direccion_maestros, telefono_maetro, email_maestros, estatus_maestros FROM maestro WHERE codigo_maestro = ?";    
///*
    public List<clsMaestrosP1> consultaMaestros() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMaestrosP1> maestros = new ArrayList<>();
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_maestro");
                String nombre = rs.getString("nombre_maestro");
                String dir = rs.getString("direccion_maestro");
                String tel = rs.getString("telefono_maetro");
                String email = rs.getString("usunombre");
                String estatus = rs.getString("usucontrasena");
                clsMaestrosP1 maestro = new clsMaestrosP1();
                maestro.setIdMaestro(id);
                maestro.setNombreMaestro(nombre);
                maestro.setDirMaestro(dir);
                maestro.setCodMaestro(tel);
                maestro.setEmailMaestro(email);
                maestro.setDirMaestro(estatus);
                maestros.add(maestro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(rs);
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }
        return maestros;
    }

    public int ingresaMaestros(clsMaestrosP1 maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, maestro.getNombreMaestro());
            stmt.setString(2, maestro.getDirMaestro());
            stmt.setString(3, maestro.getCodMaestro());
            stmt.setString(4, maestro.getEmailMaestro());
            stmt.setString(5, maestro.getEstatusMaestro());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }

        return rows;
    }

    public int actualizaMaestros(clsMaestrosP1 maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, maestro.getNombreMaestro());
            stmt.setString(2, maestro.getDirMaestro());
            stmt.setString(3, maestro.getCodMaestro());
            stmt.setString(4, maestro.getEmailMaestro());
            stmt.setString(5, maestro.getEstatusMaestro());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }

        return rows;
    }

    public int borrarMaestros(clsMaestrosP1 maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, maestro.getIdMaestro());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }

        return rows;
    }

    public clsMaestrosP1 consultaMaestrosPorNombre (clsMaestrosP1 maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + maestro);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, maestro.getNombreMaestro());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                System.out.println(" registro consultado: " + maestro);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(rs);
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return maestro;
    }
    public clsMaestrosP1 consultaMaestrosPorId(clsMaestrosP1 maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + maestro);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, maestro.getIdMaestro());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codigo_maestro");
                String nombre = rs.getString("nombre_maestro");
                String dir = rs.getString("direccion_maestro");
                String tel = rs.getString("telefono_maetro");
                String email = rs.getString("usunombre");
                String estatus = rs.getString("usucontrasena");
                
                maestro.setIdMaestro(id);
                maestro.setNombreMaestro(nombre);
                maestro.setDirMaestro(dir);
                maestro.setCodMaestro(tel);
                maestro.setEmailMaestro(email);
                maestro.setDirMaestro(estatus);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(rs);
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return maestro;
    }
}

