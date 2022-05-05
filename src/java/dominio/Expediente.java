/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.File;

/**
 *
 * @author ucova
 */
public class Expediente {
    private File archivo;
    private String tipoDocumento;
    private String descripcion;
    private Integer pacienteId;

    public Expediente() {
    }

    public Expediente(File archivo, String tipoDocumento, String descripcion, Integer pacienteId) {
        this.archivo = archivo;
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
        this.pacienteId = pacienteId;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public String toString() {
        return "Expediente{" + "archivo=" + archivo + ", tipoDocumento=" + tipoDocumento + ", descripcion=" + descripcion + ", pacienteId=" + pacienteId + '}';
    }
}
