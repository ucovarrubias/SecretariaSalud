/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author ucova
 */
public class TrabajadorSalud  extends Persona {
    private String cedulaProfesional;
    private String contrasenia;

    public TrabajadorSalud() {
    }
    
    public TrabajadorSalud(Integer id, String cedulaProfesional, String contrasenia, String nombre, String curp, Date fechaNacimiento, String huellaDactilar) {
        super(id, nombre, curp, fechaNacimiento, huellaDactilar);
        this.cedulaProfesional = cedulaProfesional;
        this.contrasenia = contrasenia;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "TrabajadorSalud{" + "cedulaProfesional=" + cedulaProfesional + ", contrasenia=" + contrasenia + '}';
    }
}
