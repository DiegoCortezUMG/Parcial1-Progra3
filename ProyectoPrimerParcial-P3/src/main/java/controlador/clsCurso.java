/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCurso;
/**
 *
 * @author visitante
 */
public class clsCurso {
    
    private int CodigoCurso;
    private String NombreCurso;
    private String EstatusCurso;

    public int getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(int CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public String getEstatusCurso() {
        return EstatusCurso;
    }

    public void setEstatusCurso(String EstatusCurso) {
        this.EstatusCurso = EstatusCurso;
    }

    public clsCurso(int CodigoCurso, String NombreCurso, String EstatusCurso) {
        this.CodigoCurso = CodigoCurso;
        this.NombreCurso = NombreCurso;
        this.EstatusCurso = EstatusCurso;
    }

    public clsCurso(int CodigoCurso, String NombreCurso) {
        this.CodigoCurso = CodigoCurso;
        this.NombreCurso = NombreCurso;
    }

    public clsCurso(int CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }

    public clsCurso() {
    }    
    
    //Metodos de acceso a la capa controlador

    public clsCurso getBuscarInformacionAplicacionPorNombre(clsCurso aplicacion)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.consultaCursosPorNombre(aplicacion);
    }
    public clsCurso getBuscarInformacionAplicacionPorId(clsCurso aplicacion)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.consultaCursosPorId(aplicacion);
    }    
    public List<clsCurso> getListadoAplicaciones()
    {
        daoCurso daocurso = new daoCurso();
        List<clsCurso> listadosAplicaciones = daocurso.consultaCursos();
        return listadosAplicaciones;
    }
    public int setBorrarAplicacion(clsCurso aplicacion)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.borrarCursos(aplicacion);
    }          
    public int setIngresarAplicacion(clsCurso aplicacion)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.ingresarCursos(aplicacion);
    }              
    public int setModificarAplicacion(clsCurso aplicacion)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.actualizaCursos(aplicacion);
    }   
}

