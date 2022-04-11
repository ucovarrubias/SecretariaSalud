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
public class Paciente extends Persona {

    private Integer tutor;

    @Builder
    public Paciente(Integer id, String cedulaProfesional, String contrasenia, String nombre, String curp, Date fechaNacimiento, String huellaDactilar, Integer tutor) {
        super(id, nombre, curp, fechaNacimiento, huellaDactilar);
        this.tutor = tutor;
    }

}
