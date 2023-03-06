/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.clsCarreras;
import controlador.clsConexionP1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCarreras {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, estatus_carrera FROM carreras";
    private static final String SQL_INSERT = "INSERT INTO carreras(nombre_carrera, estatus_carrera) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, estatus_carrera=? WHERE codigo_carrera=?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_carrera, nombre_carrera, estatus_carrera FROM carreras WHERE nombre_carrera=?";
    private static final String SQL_SELECT_ID = "SELECT codigo_carrera, nombre_carrera, estatus_carrera FROM carreras WHERE codigo_carrera=?";    

    public List<clsCarreras> consultaCarreras() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCarreras> carreras = new ArrayList<>();
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                //String codigof = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                clsCarreras carrera = new clsCarreras();
                carrera.setCodigo_carrera(codigo);
                carrera.setNombre_carrera(nombre);
                //carrera.setCodigo_facultad(codigof);
                carrera.setEstatus_carrera(estatus);
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexionP1.close(rs);
            clsConexionP1.close(stmt);
            clsConexionP1.close(conn);
        }
        return carreras;
    }

    public int ingresaCarreras(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carrera.getNombre_carrera());
            //stmt.setString(2, carrera.getCodigo_facultad());
            stmt.setString(2, carrera.getEstatus_carrera());

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

    public int actualizaCarreras(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, carrera.getNombre_carrera());
            //stmt.setString(2, carrera.getCodigo_facultad());
            stmt.setString(3, carrera.getEstatus_carrera());
            stmt.setInt(2, carrera.getCodigo_carrera());

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

    public int borrarCarreras(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, carrera.getCodigo_carrera());
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

    public clsCarreras consultaCarrerasPorNombre(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carrera);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, carrera.getNombre_carrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                //String codigof = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                //clsCarreras carrera = new clsCarreras();
                carrera.setCodigo_carrera(codigo);
                carrera.setNombre_carrera(nombre);
                //carrera.setCodigo_facultad(codigof);
                carrera.setEstatus_carrera(estatus);
                System.out.println(" registro consultado: " + carrera);                            
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
        return carrera;
    }
    public clsCarreras consultaCarrerasPorId(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexionP1.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carrera);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, carrera.getCodigo_carrera());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                //String codigof = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                //clsCarreras carrera = new clsCarreras();
                carrera.setCodigo_carrera(codigo);
                carrera.setNombre_carrera(nombre);
                //carrera.setCodigo_facultad(codigof);
                carrera.setEstatus_carrera(estatus);
                System.out.println(" registro consultado: " + carrera);                
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
        return carrera;
    }    
    
}
