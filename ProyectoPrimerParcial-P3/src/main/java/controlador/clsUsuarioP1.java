/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.daoUsuarioP1;

/**
 *
 * @author Usuario
 */
public class clsUsuarioP1 {
    private int IdUsuario;
    private String NombreUsuario;
    private String ContrasenaUsuario;

    public clsUsuarioP1() {
    }
    
    public clsUsuarioP1(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }    
    
    public clsUsuarioP1(String NombreUsuario, String ContrasenaUsuario) {
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
    }
    
    public clsUsuarioP1(int IdUsuario, String NombreUsuario, String ContrasenaUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
    }    

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasenaUsuario() {
        return ContrasenaUsuario;
    }

    public void setContrasenaUsuario(String ContrasenaUsuario) {
        this.ContrasenaUsuario = ContrasenaUsuario;
    }
    @Override
    public String toString() {
        return "clsUsuario{" + "IdUsuario=" + IdUsuario + ", NombreUsuario=" + NombreUsuario + ", ContrasenaUsuario=" + ContrasenaUsuario + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsUsuarioP1 getBuscarInformacionUsuarioPorNombre(clsUsuarioP1 usuario)
    {
        daoUsuarioP1 daousuario = new daoUsuarioP1();
        return daousuario.consultaUsuariosPorNombre(usuario);
    }
    public clsUsuarioP1 getBuscarInformacionUsuarioPorId(clsUsuarioP1 usuario)
    {
        daoUsuarioP1 daousuario = new daoUsuarioP1();
        return daousuario.consultaUsuariosPorId(usuario);
    }    
    public List<clsUsuarioP1> getListadoUsuarios()
    {
        daoUsuarioP1 daousuario = new daoUsuarioP1();
        List<clsUsuarioP1> listadoUsuarios = daousuario.consultaUsuarios();
        return listadoUsuarios;
    }
    public int setBorrarUsuario(clsUsuarioP1 usuario)
    {
        daoUsuarioP1 daousuario = new daoUsuarioP1();
        return daousuario.borrarUsuarios(usuario);
    }          
    public int setIngresarUsuario(clsUsuarioP1 usuario)
    {
        daoUsuarioP1 daousuario = new daoUsuarioP1();
        return daousuario.ingresaUsuarios(usuario);
    }              
    public int setModificarUsuario(clsUsuarioP1 usuario)
    {
        daoUsuarioP1 daousuario = new daoUsuarioP1();
        return daousuario.actualizaUsuarios(usuario);
    }
}
