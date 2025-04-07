package analysis;

import model.Sueño;

public class AnalizadorCognitivo implements Analizador {
    private String enfoque;
    private String resultado;
    
    public AnalizadorCognitivo(String enfoque) {
        this.enfoque = enfoque;
    }
    
    @Override
    public void analizar(Sueño sueño) {
        // Lógica de análisis cognitivo según el enfoque
        resultado = "Análisis cognitivo (" + enfoque + ") del sueño " + sueño.getId() + 
                    ": Evaluación de patrones de pensamiento durante el sueño";
    }
    
    @Override
    public String obtenerResultado() {
        return resultado;
    }
}