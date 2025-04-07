// Implementaciones concretas de fábricas
package factory;

import analysis.*;

public class EnfoqueJungianoFactory implements EnfoqueTerapeuticoFactory {
    @Override
    public Analizador crearAnalizadorEmocional() {
        return new AnalizadorEmocional("Jungiano");
    }
    
    @Override
    public Analizador crearAnalizadorSimbolico() {
        return new AnalizadorSimbolico("Jungiano");
    }
    
    @Override
    public Analizador crearAnalizadorCognitivo() {
        return new AnalizadorCognitivo("Jungiano");
    }
    
    @Override
    public Analizador crearAnalizadorEstadistico() {
        return new AnalizadorEstadistico("Jungiano");
    }
}