/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author ucova
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TrabajadorSalud extends Persona {

    private String cedulaProfesional;
    private String contrasenia;

    @Builder
    public TrabajadorSalud(Integer id, String cedulaProfesional, String contrasenia, String nombre, String curp, Date fechaNacimiento, String huellaDactilar) {
        super(id, nombre, curp, fechaNacimiento, huellaDactilar);
        this.cedulaProfesional = cedulaProfesional;
        this.contrasenia = contrasenia;
    }

}
