package analysis;

import model.Sueño;

public class AnalizadorEstadistico implements Analizador {
    private String enfoque;
    private String resultado;
    
    public AnalizadorEstadistico(String enfoque) {
        this.enfoque = enfoque;
    }
    
    @Override
    public void analizar(Sueño sueño) {
        // Lógica de análisis estadístico según el enfoque
        resultado = "Análisis estadístico (" + enfoque + ") del sueño " + sueño.getId() + 
                    ": Comparación con patrones históricos del paciente";
    }
    
    @Override
    public String obtenerResultado() {
        return resultado;
    }
}