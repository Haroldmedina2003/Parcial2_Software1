// Clase SesionAnalisis
package model;

import analysis.Analizador;
import java.util.Date;

public class SesionAnalisis {
    private int id;
    private Sueño sueño;
    private Terapeuta terapeuta;
    private Date fechaSesion;
    private Analizador analizador;
    
    public SesionAnalisis(int id, Sueño sueño, Terapeuta terapeuta, Analizador analizador) {
        this.id = id;
        this.sueño = sueño;
        this.terapeuta = terapeuta;
        this.fechaSesion = new Date();
        this.analizador = analizador;
    }
    
    public void realizarAnalisis() {
        analizador.analizar(sueño);
    }
    
    // Getters
    public int getId() { return id; }
    public Sueño getSueño() { return sueño; }
    public Terapeuta getTerapeuta() { return terapeuta; }
    public Date getFechaSesion() { return fechaSesion; }
}