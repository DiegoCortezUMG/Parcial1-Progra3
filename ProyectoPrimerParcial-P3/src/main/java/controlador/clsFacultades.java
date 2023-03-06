/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.List;
import modelo.daoFacultades;

/**
 *
 * @author Inkunzy
 */
public class clsFacultades {
    private int codigo_facultad;
    private String nombre_facultad;
    private String estatus_facultad;

    public clsFacultades() {
    }

    public clsFacultades(int codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    public clsFacultades(int codigo_facultad, String nombre_facultad) {
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
    }

    public clsFacultades(int codigo_facultad, String nombre_facultad, String estatus_facultad) {
        this.codigo_facultad = codigo_facultad;
        this.nombre_facultad = nombre_facultad;
        this.estatus_facultad = estatus_facultad;
    }

    public int getCodigo_facultad() {
        return codigo_facultad;
    }

    public void setCodigo_facultad(int codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    public String getNombre_facultad() {
        return nombre_facultad;
    }

    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    public String getEstatus_facultad() {
        return estatus_facultad;
    }

    public void setEstatus_facultad(String estatus_facultad) {
        this.estatus_facultad = estatus_facultad;
    }

    @Override
    public String toString() {
        return "clsFacultades{" + "codigo_facultad=" + codigo_facultad + ", nombre_facultad=" + nombre_facultad + ", estatus_facultad=" + estatus_facultad + '}';
    }
    //Metodos de acceso a la capa controlador 
    public clsFacultades getBuscarInformacionFacultadesPorNombre(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.consultaFacultadesPorNombre(facultades);
    }
    public clsFacultades getBuscarInformacionFacultadesPorId(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.consultaFacultadesPorId(facultades);
    }    
    public List<clsFacultades> getListadoFacultades()
    {
        daoFacultades daofacultades = new daoFacultades();
        List<clsFacultades> listadoFacultades = daofacultades.consultaFacultades();
        return listadoFacultades;
    }
    public int setBorrarFacultades(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.borrarFacultades(facultades);
    }          
    public int setIngresarFacultades(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.ingresaFacultades(facultades);
    }              
    public int setModificarFacultades(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.actualizaFacultades(facultades);
    }
}
