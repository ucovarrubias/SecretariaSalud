/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.InputStream;

/**
 *
 * @author ucova
 */
public class Expediente {
    private Integer expedienteId;
    private String nombre;
    private InputStream archivo;
    private String tipoDocumento;
    private String fecha;
    private String descripcion;
    private Integer pacienteId;

    public Expediente() {
    }

    public Expediente(String nombre, InputStream archivo, String tipoDocumento, String descripcion, Integer pacienteId) {
        this.nombre = nombre;
        this.archivo = archivo;
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
        this.pacienteId = pacienteId;
    }

    public Expediente(Integer expedienteId, String nombre, InputStream archivo, String tipoDocumento, String fecha, String descripcion, Integer pacienteId) {
        this.expedienteId = expedienteId;
        this.nombre = nombre;
        this.archivo = archivo;
        this.tipoDocumento = tipoDocumento;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pacienteId = pacienteId;
    }

    public Integer getExpedienteId() {
        return expedienteId;
    }

    public void setExpedienteId(Integer expedienteId) {
        this.expedienteId = expedienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public InputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(InputStream archivo) {
        this.archivo = archivo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        return "Expediente{" + "nombre=" + nombre + ", archivo=" + archivo + ", tipoDocumento=" + tipoDocumento + ", descripcion=" + descripcion + ", pacienteId=" + pacienteId + '}';
    }
}
