// Clase AnalizadorPool
package pool;

import analysis.Analizador;
import factory.EnfoqueTerapeuticoFactory;
import singleton.ConfiguracionClinica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalizadorPool {
    private static AnalizadorPool instancia;
    private final Map<String, List<Analizador>> poolAnalizadores;
    private final Map<String, List<Analizador>> analizadoresEnUso;
    private final int MAX_INSTANCIAS_POR_TIPO = 5;
    private EnfoqueTerapeuticoFactory factory;
    
    private AnalizadorPool() {
        poolAnalizadores = new HashMap<>();
        analizadoresEnUso = new HashMap<>();
    }
    
    public static synchronized AnalizadorPool getInstance() {
        if (instancia == null) {
            instancia = new AnalizadorPool();
        }
        return instancia;
    }
    
    public void inicializarPool(EnfoqueTerapeuticoFactory factory) {
        this.factory = factory;
        
        // Inicializar pool para cada tipo de analizador
        poolAnalizadores.put("emocional", new ArrayList<>());
        poolAnalizadores.put("simbolico", new ArrayList<>());
        poolAnalizadores.put("cognitivo", new ArrayList<>());
        poolAnalizadores.put("estadistico", new ArrayList<>());
        
        analizadoresEnUso.put("emocional", new ArrayList<>());
        analizadoresEnUso.put("simbolico", new ArrayList<>());
        analizadoresEnUso.put("cognitivo", new ArrayList<>());
        analizadoresEnUso.put("estadistico", new ArrayList<>());
    }
    
    public synchronized Analizador obtenerAnalizador(String tipo) {
        List<Analizador> pool = poolAnalizadores.get(tipo.toLowerCase());
        List<Analizador> enUso = analizadoresEnUso.get(tipo.toLowerCase());
        
        if (pool == null) {
            throw new IllegalArgumentException("Tipo de analizador no soportado: " + tipo);
        }
        
        Analizador analizador;
        
        if (pool.isEmpty()) {
            // Si no hay analizadores disponibles, creamos uno nuevo si no excedemos el límite
            if (enUso.size() < MAX_INSTANCIAS_POR_TIPO) {
                analizador = crearAnalizador(tipo);
            } else {
                throw new RuntimeException("No hay analizadores disponibles para: " + tipo);
            }
        } else {
            // Tomamos un analizador del pool
            analizador = pool.remove(0);
        }
        
        enUso.add(analizador);
        return analizador;
    }
    
    public synchronized void liberarAnalizador(String tipo, Analizador analizador) {
        List<Analizador> pool = poolAnalizadores.get(tipo.toLowerCase());
        List<Analizador> enUso = analizadoresEnUso.get(tipo.toLowerCase());
        
        if (pool == null || enUso == null) {
            throw new IllegalArgumentException("Tipo de analizador no soportado: " + tipo);
        }
        
        if (enUso.remove(analizador)) {
            pool.add(analizador);
        } else {
            throw new IllegalArgumentException("El analizador no está en uso");
        }
    }
    
    private Analizador crearAnalizador(String tipo) {
        if (factory == null) {
            throw new IllegalStateException("El factory no ha sido inicializado");
        }
        
        switch (tipo.toLowerCase()) {
            case "emocional":
                return factory.crearAnalizadorEmocional();
            case "simbolico":
                return factory.crearAnalizadorSimbolico();
            case "cognitivo":
                return factory.crearAnalizadorCognitivo();
            case "estadistico":
                return factory.crearAnalizadorEstadistico();
            default:
                throw new IllegalArgumentException("Tipo de analizador no soportado: " + tipo);
        }
    }
}