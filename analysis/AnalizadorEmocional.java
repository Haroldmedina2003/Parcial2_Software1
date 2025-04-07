// Implementaciones concretas de analizadores
package analysis;

import model.Sueño;

public class AnalizadorEmocional implements Analizador {
    private String enfoque;
    private String resultado;
    
    public AnalizadorEmocional(String enfoque) {
        this.enfoque = enfoque;
    }
    
    @Override
    public void analizar(Sueño sueño) {
        // Lógica de análisis emocional según el enfoque
        resultado = "Análisis emocional (" + enfoque + ") del sueño " + sueño.getId() + 
                    ": Intensidad emocional " + sueño.getIntensidadEmocional() + "/10";
    }
    
    @Override
    public String obtenerResultado() {
        return resultado;
    }
}