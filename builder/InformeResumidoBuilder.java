// Implementación InformeResumidoBuilder
package builder;

import model.Sueño;
import model.Paciente;
import model.Terapeuta;

public class InformeResumidoBuilder implements InformeBuilder {
    private InformeTerapeutico informe;
    
    public InformeResumidoBuilder() {
        reset();
    }
    
    @Override
    public void reset() {
        informe = new InformeTerapeutico();
    }
    
    @Override
    public void setInformacionBasica(int id, Paciente paciente, Terapeuta terapeuta, Sueño sueño) {
        informe.setId(id);
        informe.setPaciente(paciente);
        informe.setTerapeuta(terapeuta);
        informe.setSueño(sueño);
    }
    
    @Override
    public void construirAnalisisTextual(String analisis) {
        // En el informe resumido, condensamos el análisis textual
        if (analisis != null && analisis.length() > 200) {
            informe.setAnalisisTextual(analisis.substring(0, 200) + "...");
        } else {
            informe.setAnalisisTextual(analisis);
        }
    }
    
    @Override
    public void construirAnalisisSimbolico(String analisis) {
        // En el informe resumido, ignoramos el análisis simbólico detallado
        // Solo incluimos una nota breve si existe información
        if (analisis != null && !analisis.isEmpty()) {
            informe.setAnalisisSimbolico("Análisis simbólico disponible - Ver informe completo");
        }
    }
    
    @Override
    public void construirAnalisisEmocional(String analisis) {
        // En el informe resumido, simplificamos el análisis emocional
        if (analisis != null && !analisis.isEmpty()) {
            informe.setAnalisisEmocional("Resumen emocional: " + extraerResumenEmocional(analisis));
        }
    }
    
    @Override
    public void construirGraficosInterpretacion(String... graficos) {
        // En el informe resumido, solo incluimos el primer gráfico si existe
        if (graficos != null && graficos.length > 0) {
            informe.agregarGraficoInterpretacion(graficos[0]);
        }
    }
    
    @Override
    public void construirConclusiones(String conclusiones) {
        informe.setConclusiones(conclusiones);
    }
    
    @Override
    public void construirRecomendaciones(String recomendaciones) {
        // En el informe resumido, condensamos las recomendaciones
        if (recomendaciones != null && recomendaciones.length() > 100) {
            informe.setRecomendaciones(recomendaciones.substring(0, 100) + "...");
        } else {
            informe.setRecomendaciones(recomendaciones);
        }
    }
    
    @Override
    public InformeTerapeutico obtenerInforme() {
        return informe;
    }
    
    // Método auxiliar para extraer las emociones principales de un análisis
    private String extraerResumenEmocional(String analisisCompleto) {
        // En una implementación real, aquí habría lógica para extraer emociones clave
        // Para este ejemplo, simplemente devolvemos un texto genérico
        return "Principales emociones detectadas (resumen)";
    }
}