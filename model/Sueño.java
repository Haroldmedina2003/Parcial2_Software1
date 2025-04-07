// Clase Sueño (implementa Prototype)
package model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Sueño implements Cloneable {
    private int id;
    private String descripcion;
    private Date fecha;
    private int duracion; // en minutos
    private int intensidadEmocional; // escala 1-10
    private int claridadVisual; // escala 1-10
    private Map<String, Object> caracteristicas;
    private Paciente paciente;
    
    public Sueño(int id, String descripcion, Paciente paciente) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = new Date();
        this.paciente = paciente;
        this.caracteristicas = new HashMap<>();
    }
    
    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    
    public int getIntensidadEmocional() { return intensidadEmocional; }
    public void setIntensidadEmocional(int intensidadEmocional) { 
        this.intensidadEmocional = intensidadEmocional; 
    }
    
    public int getClaridadVisual() { return claridadVisual; }
    public void setClaridadVisual(int claridadVisual) { this.claridadVisual = claridadVisual; }
    
    public Paciente getPaciente() { return paciente; }
    
    public void agregarCaracteristica(String nombre, Object valor) {
        caracteristicas.put(nombre, valor);
    }
    
    public Object getCaracteristica(String nombre) {
        return caracteristicas.get(nombre);
    }
    
    // Implementación de Prototype
    @Override
    public Sueño clone() {
        try {
            Sueño clon = (Sueño) super.clone();
            clon.caracteristicas = new HashMap<>(this.caracteristicas);
            return clon;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}