/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author ucova
 */
@Data
@AllArgsConstructor
public abstract class Persona {

    private Integer id;
    private String nombre;
    private String curp;
    private Date fechaNacimiento;
    private String huellaDactilar;

}
