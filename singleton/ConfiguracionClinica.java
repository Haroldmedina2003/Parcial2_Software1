// Clase ConfiguracionClinica (Singleton)
package singleton;

import java.util.HashMap;
import java.util.Map;

public class ConfiguracionClinica {
    private static ConfiguracionClinica instancia;
    private Map<String, Object> configuraciones;
    
    private ConfiguracionClinica() {
        configuraciones = new HashMap<>();
        cargarConfiguracionesPorDefecto();
    }
    
    public static synchronized ConfiguracionClinica getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracionClinica();
        }
        return instancia;
    }
    
    private void cargarConfiguracionesPorDefecto() {
        // Reglas de validación
        configuraciones.put("minDuracionSueño", 1);
        configuraciones.put("maxDuracionSueño", 600);
        configuraciones.put("minIntensidadEmocional", 1);
        configuraciones.put("maxIntensidadEmocional", 10);
        configuraciones.put("minClaridadVisual", 1);
        configuraciones.put("maxClaridadVisual", 10);
        
        // Parámetros éticos
        configuraciones.put("requiereConsentimiento", true);
        configuraciones.put("permitirCompartirDatos", false);
        
        // Configuraciones de lenguaje
        configuraciones.put("idiomaPredeterminado", "es");
        configuraciones.put("detectarLenguajeExplicito", true);
    }
    
    public Object getConfiguracion(String clave) {
        return configuraciones.get(clave);
    }
    
    public void setConfiguracion(String clave, Object valor) {
        configuraciones.put(clave, valor);
    }
    
    public boolean validarDuracion(int duracion) {
        int min = (int) configuraciones.get("minDuracionSueño");
        int max = (int) configuraciones.get("maxDuracionSueño");
        return duracion >= min && duracion <= max;
    }
    
    public boolean validarIntensidadEmocional(int intensidad) {
        int min = (int) configuraciones.get("minIntensidadEmocional");
        int max = (int) configuraciones.get("maxIntensidadEmocional");
        return intensidad >= min && intensidad <= max;
    }
    
    public boolean validarClaridadVisual(int claridad) {
        int min = (int) configuraciones.get("minClaridadVisual");
        int max = (int) configuraciones.get("maxClaridadVisual");
        return claridad >= min && claridad <= max;
    }
}