/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.daoMaestrosP1;
/**
 *
 * @author Usuario
 */
public class clsMaestrosP1 {
    private int IdMaestro;
    private String NombreMaestro;
    private String DirMaestro;
    private String CodMaestro;
    private String EmailMaestro;
    private String EstatusMaestro;

    public clsMaestrosP1() {
    }

    public clsMaestrosP1(int IdMaestro, String NombreMaestro, String DirMaestro, String CodMaestro, String EmailMaestro, String EstatusMaestro) {
        this.IdMaestro = IdMaestro;
        this.NombreMaestro = NombreMaestro;
        this.DirMaestro = DirMaestro;
        this.CodMaestro = CodMaestro;
        this.EmailMaestro = EmailMaestro;
        this.EstatusMaestro = EstatusMaestro;
    }

    public clsMaestrosP1(int IdMaestro) {
        this.IdMaestro = IdMaestro;
    }

    public clsMaestrosP1(String NombreMaestro) {
        this.NombreMaestro = NombreMaestro;
    }

    public int getIdMaestro() {
        return IdMaestro;
    }

    public void setIdMaestro(int IdMaestro) {
        this.IdMaestro = IdMaestro;
    }

    public String getNombreMaestro() {
        return NombreMaestro;
    }

    public void setNombreMaestro(String NombreMaestro) {
        this.NombreMaestro = NombreMaestro;
    }

    public String getDirMaestro() {
        return DirMaestro;
    }

    public void setDirMaestro(String DirMaestro) {
        this.DirMaestro = DirMaestro;
    }

    public String getCodMaestro() {
        return CodMaestro;
    }

    public void setCodMaestro(String CodMaestro) {
        this.CodMaestro = CodMaestro;
    }

    public String getEmailMaestro() {
        return EmailMaestro;
    }

    public void setEmailMaestro(String EmailMaestro) {
        this.EmailMaestro = EmailMaestro;
    }

    public String getEstatusMaestro() {
        return EstatusMaestro;
    }

    public void setEstatusMaestro(String EstatusMaestro) {
        this.EstatusMaestro = EstatusMaestro;
    }

    @Override
    public String toString() {
        return "clsMaestrosP1{" + "IdMaestro=" + IdMaestro + ", NombreMaestro=" + NombreMaestro + ", DirMaestro=" + DirMaestro + ", CodMaestro=" + CodMaestro + ", EmailMaestro=" + EmailMaestro + ", EstatusMaestro=" + EstatusMaestro + '}';
    }
    
    public clsMaestrosP1 getBuscarInformacionMaestroPorNombre(clsMaestrosP1 maestro)
    {
        daoMaestrosP1 daomaestro = new daoMaestrosP1();
        return daomaestro.consultaMaestrosPorNombre(maestro);
    }
    public daoMaestrosP1 getBuscarInformacionMeastrosPorId(daoMaestrosP1 maestro)
    {
        daoMaestrosP1 daomaestro = new daoMaestrosP1();
        return daomaestro.consultaMaestrosPorId(maestro);
    }    
    public List<clsMaestrosP1> getListadoMaestros()
    {
        daoMaestrosP1 daomaestro = new daoMaestrosP1();
        List<clsMaestrosP1> listadoMaestros = daomaestro.consultaMaestros();
        return listadoMaestros;
    }
    public int setBorrarMaestro(clsMaestrosP1 maestro)
    {
        daoMaestrosP1 daomaestro = new daoMaestrosP1();
        return daomaestro.borrarMaestros(maestro);
    }          
    public int setIngresarMaestro(clsMaestrosP1 maestro)
    {
        daoMaestrosP1 daomaestros = new daoMaestrosP1();
        return daomaestros.ingresaMaestros(maestro);
    }              
    public int setModificarMaestro(clsMaestrosP1 maestro)
    {
        daoMaestrosP1 daomaestros = new daoMaestrosP1();
        return daomaestros.actualizaMaestros(maestro);
    }
}
