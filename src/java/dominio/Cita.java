/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author ucova
 */
@Data
@AllArgsConstructor
public class Cita {

    private Integer id;
    private String horaCita;
    private Boolean accesoExpediente;
    private Integer pacienteId;
    private Integer trabajadorSaludId;

}
