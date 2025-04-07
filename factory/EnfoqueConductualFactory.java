package factory;

import analysis.*;

public class EnfoqueConductualFactory implements EnfoqueTerapeuticoFactory {
    @Override
    public Analizador crearAnalizadorEmocional() {
        return new AnalizadorEmocional("Conductual");
    }
    
    @Override
    public Analizador crearAnalizadorSimbolico() {
        return new AnalizadorSimbolico("Conductual");
    }
    
    @Override
    public Analizador crearAnalizadorCognitivo() {
        return new AnalizadorCognitivo("Conductual");
    }
    
    @Override
    public Analizador crearAnalizadorEstadistico() {
        return new AnalizadorEstadistico("Conductual");
    }
}