/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsConexionP1;
import controlador.clsCurso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCurso {

    private static final String SQL_SELECT = "SELECT usuid, usunombre, usucontrasena FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(usunombre, usucontrasena) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET usunombre=?, usucontrasena=? WHERE usuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE usuid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT usuid, usunombre, usucontrasena FROM tbl_usuario WHERE usunombre = ?";
    private static final String SQL_SELECT_ID = "SELECT usuid, usunombre, usucontrasena FROM tbl_usuario WHERE usuid = ?";    

    public List<clsCurso> consultaCursos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCurso> cursos = new ArrayList<>();
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");
                clsCurso curso = new clsCurso();
                curso.setCodigoCurso(id);
                curso.setNombreCurso(nombre);
                curso.setEstatusCurso(contrasena);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(rs);
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }
        return cursos;
    }

    public int ingresarCursos(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getEstatusCurso());

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

    public int actualizaCursos(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getEstatusCurso());
            stmt.setInt(3, curso.getCodigoCurso());

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

    public int borrarCursos(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getCodigoCurso());
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

    public clsCurso consultaCursosPorNombre(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + curso);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, curso.getNombreCurso());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");

                //usuario = new clsUsuario();
                curso.setCodigoCurso(id);
                curso.setNombreCurso(nombre);
                curso.setEstatusCurso(contrasena);
                System.out.println(" registro consultado: " + curso);                
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
        return curso;
    }
    public clsCurso consultaCursosPorId(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + curso);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, curso.getCodigoCurso());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String contrasena = rs.getString("usucontrasena");

                //usuario = new clsUsuario();
                curso.setCodigoCurso(id);
                curso.setNombreCurso(nombre);
                curso.setEstatusCurso(contrasena);
                System.out.println(" registro consultado: " + curso);                
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
        return curso;
    }    
}
