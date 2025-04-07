// Clase Terapeuta
package model;

public class Terapeuta {
    private int id;
    private String nombre;
    private String apellido;
    private String especialidad;
    
    public Terapeuta(int id, String nombre, String apellido, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }
    
    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEspecialidad() { return especialidad; }
}