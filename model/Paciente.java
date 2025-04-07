// Clase Paciente
package model;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private List<Sueño> sueños;
    
    public Paciente(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueños = new ArrayList<>();
    }
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    
    public void agregarSueño(Sueño sueño) {
        sueños.add(sueño);
    }
    
    public List<Sueño> getSueños() {
        return new ArrayList<>(sueños);
    }
}