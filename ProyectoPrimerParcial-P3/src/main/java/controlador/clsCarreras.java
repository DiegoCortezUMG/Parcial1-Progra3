/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.List;
import modelo.daoCarreras;
/**
 *
 * @author Usuario
 */
public class clsCarreras {
    private int codigo_carrera;
    private String nombre_carrera;
    //private int codigo_facultad;
    private String estatus_carrera;

    public clsCarreras() {
    }

    public clsCarreras(int codigo_carrera, String nombre_carrera) {
        this.codigo_carrera = codigo_carrera;
        this.nombre_carrera = nombre_carrera;
    }

    public clsCarreras(int codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public int getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(int codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }
/*
    public String getCodigo_facultad() {
        return codigo_facultad;
    }

    public void setCodigo_facultad(String codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }
*/
    public String getEstatus_carrera() {
        return estatus_carrera;
    }

    public void setEstatus_carrera(String estatus_carrera) {
        this.estatus_carrera = estatus_carrera;
    }

    @Override
    public String toString() {
        return "clsCarreras{" + "codigo_carrera=" + codigo_carrera + ", nombre_carrera=" + nombre_carrera + ", estatus_carrera=" + estatus_carrera + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsCarreras getBuscarInformacionCarrerasPorNombre(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.consultaCarrerasPorNombre(carreras);
    }
    public clsCarreras getBuscarInformacionCarrerasPorId(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.consultaCarrerasPorId(carreras);
    }    
    public List<clsCarreras> getListadoCarreras()
    {
        daoCarreras daocarreras = new daoCarreras();
        List<clsCarreras> listadoCarreras = daocarreras.consultaCarreras();
        return listadoCarreras;
    }
    public int setBorrarCarreras(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.borrarCarreras(carreras);
    }          
    public int setIngresarCarreras(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.ingresaCarreras(carreras);
    }              
    public int setModificarCarreras(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.actualizaCarreras(carreras);
    }
}
