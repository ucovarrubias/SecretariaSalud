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
public abstract class Persona {
    private Integer id;
    private String nombre;
    private String curp;
    private Date fechaNacimiento;
    private String huellaDactilar;

    public Persona() {
    }
    
    public Persona(Integer id, String nombre, String curp, Date fechaNacimiento, String huellaDactilar) {
        this.id = id;
        this.nombre = nombre;
        this.curp = curp;
        this.fechaNacimiento = fechaNacimiento;
        this.huellaDactilar = huellaDactilar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getHuellaDactilar() {
        return huellaDactilar;
    }

    public void setHuellaDactilar(String huellaDactilar) {
        this.huellaDactilar = huellaDactilar;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", curp=" + curp + ", fechaNacimiento=" + fechaNacimiento + ", huellaDactilar=" + huellaDactilar + '}';
    }
}
