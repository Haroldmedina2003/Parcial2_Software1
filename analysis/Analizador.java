// Interfaz Analizador
package analysis;

import model.Sueño;

public interface Analizador {
    void analizar(Sueño sueño);
    String obtenerResultado();
}