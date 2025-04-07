// Interfaz EnfoqueTerapeuticoFactory
package factory;

import analysis.Analizador;

public interface EnfoqueTerapeuticoFactory {
    Analizador crearAnalizadorEmocional();
    Analizador crearAnalizadorSimbolico();
    Analizador crearAnalizadorCognitivo();
    Analizador crearAnalizadorEstadistico();
}