/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author ucova
 */
public class Cita {
    private Integer id;
    private String horaCita;
    private Boolean accesoExpediente;
    private String nombrePaciente;
    private Integer trabajadorSaludId;

    public Cita() {
    }

    public Cita(Integer id, String horaCita, Boolean accesoExpediente, String nombrePaciente, Integer trabajadorSaludId) {
        this.id = id;
        this.horaCita = horaCita;
        this.accesoExpediente = accesoExpediente;
        this.nombrePaciente = nombrePaciente;
        this.trabajadorSaludId = trabajadorSaludId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public Boolean getAccesoExpediente() {
        return accesoExpediente;
    }

    public void setAccesoExpediente(Boolean accesoExpediente) {
        this.accesoExpediente = accesoExpediente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Integer getTrabajadorSaludId() {
        return trabajadorSaludId;
    }

    public void setTrabajadorSaludId(Integer trabajadorSaludId) {
        this.trabajadorSaludId = trabajadorSaludId;
    }

    @Override
    public String toString() {
        return "Cita{" + "horaCita=" + horaCita + ", accesoExpediente=" + accesoExpediente + ", pacienteId=" + nombrePaciente + ", trabajadorSaludId=" + trabajadorSaludId + '}';
    }
}
