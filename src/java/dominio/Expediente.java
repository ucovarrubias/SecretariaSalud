/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author ucova
 */
public class Expediente {
    private String imagen;
    private Integer pacienteId;

    public Expediente() {
    }

    public Expediente(String imagen, Integer pacienteId) {
        this.imagen = imagen;
        this.pacienteId = pacienteId;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public String toString() {
        return "Expediente{" + "imagen=" + imagen + ", pacienteId=" + pacienteId + '}';
    }
}
