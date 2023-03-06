/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.clsConexionP1;
import controlador.clsFacultades;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import controlador.clsFacultades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoFacultades {

    private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades";
    private static final String SQL_INSERT = "INSERT INTO facultades(nombre_facultad, estatus_facultad) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE facultades SET nombre_facultad=?, estatus_facultad=? WHERE codigo_facultad = ?";
    private static final String SQL_DELETE = "DELETE FROM facultades WHERE codigo_facultad=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades WHERE nombre_facultad = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades WHERE codigo_facultad = ?";    

    public List<clsFacultades> consultaFacultades() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsFacultades> facultades = new ArrayList<>();
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");
                clsFacultades facultad = new clsFacultades();
                facultad.setCodigo_facultad(codigo);
                facultad.setNombre_facultad(nombre);
                facultad.setEstatus_facultad(estatus);
                facultades.add(facultad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(rs);
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }
        return facultades;
    }

    public int ingresaFacultades(clsFacultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, facultad.getNombre_facultad());
            stmt.setString(2, facultad.getEstatus_facultad());

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

    public int actualizaFacultades(clsFacultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, facultad.getNombre_facultad());
            stmt.setString(2, facultad.getEstatus_facultad());
            stmt.setInt(3, facultad.getCodigo_facultad());

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

    public int borrarFacultades(clsFacultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, facultad.getCodigo_facultad());
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

    public clsFacultades consultaFacultadesPorNombre(clsFacultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + facultad);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, facultad.getNombre_facultad());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");

                //usuario = new clsUsuario();
                facultad.setCodigo_facultad(codigo);
                facultad.setNombre_facultad(nombre);
                facultad.setEstatus_facultad(estatus);
                System.out.println(" registro consultado: " + facultad);                
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
        return facultad;
    }
    public clsFacultades consultaFacultadesPorId(clsFacultades facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + facultad);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, facultad.getNombre_facultad());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");

                //usuario = new clsUsuario();
                facultad.setCodigo_facultad(codigo);
                facultad.setNombre_facultad(nombre);
                facultad.setEstatus_facultad(estatus);
                System.out.println(" registro consultado: " + facultad);                
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
        return facultad;
    }    
}
