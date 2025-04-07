package analysis;

import model.Sueño;

public class AnalizadorSimbolico implements Analizador {
    private String enfoque;
    private String resultado;
    
    public AnalizadorSimbolico(String enfoque) {
        this.enfoque = enfoque;
    }
    
    @Override
    public void analizar(Sueño sueño) {
        // Lógica de análisis simbólico según el enfoque
        resultado = "Análisis simbólico (" + enfoque + ") del sueño " + sueño.getId() + 
                    ": Identificados patrones arquetípicos en la descripción";
    }
    
    @Override
    public String obtenerResultado() {
        return resultado;
    }
}
