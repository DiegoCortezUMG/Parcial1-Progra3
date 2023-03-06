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
/*
    public List<clsUsuarioP1> consultaUsuarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsUsuarioP1> usuarios = new ArrayList<>();
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                clsUsuarioP1 usuario = new clsUsuarioP1();
                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(rs);
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }
        return usuarios;
    }

    public int ingresaUsuarios(clsUsuarioP1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasenaUsuario());

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

    public int actualizaUsuarios(clsUsuarioP1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasenaUsuario());
            stmt.setInt(3, usuario.getIdUsuario());

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

    public int borrarUsuarios(clsUsuarioP1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
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

    public clsUsuarioP1 consultaUsuariosPorNombre (clsUsuarioP1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");

                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                System.out.println(" registro consultado: " + usuario);                
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
        return usuario;
    }
    public clsUsuarioP1 consultaUsuariosPorId(clsUsuarioP1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + usuario);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, usuario.getIdUsuario());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");

                usuario.setIdUsuario(id);
                usuario.setNombreUsuario(nombre);
                usuario.setContrasenaUsuario(contrasena);
                System.out.println(" registro consultado: " + usuario);                
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
        return usuario;
    }
*/
}

