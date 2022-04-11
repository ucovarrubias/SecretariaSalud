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
public class Paciente extends Persona {
    private Integer tutor;

    public Paciente() {
    }

    public Paciente(Integer id, String nombre, String curp, Date fechaNacimiento, String huellaDactilar) {
        super(id, nombre, curp, fechaNacimiento, huellaDactilar);
    }

    public Paciente(Integer id, Integer tutor, String nombre, String curp, Date fechaNacimiento, String huellaDactilar) {
        super(id, nombre, curp, fechaNacimiento, huellaDactilar);
        this.tutor = tutor;
    }

    public Integer getTutor() {
        return tutor;
    }

    public void setTutor(Integer tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Paciente{" + "tutor=" + tutor + '}';
    }
}
