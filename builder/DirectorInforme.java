// Clase DirectorInforme
package builder;

import model.Sueño;
import model.Paciente;
import model.Terapeuta;
import analysis.Analizador;

import java.util.List;

public class DirectorInforme {
    private InformeBuilder builder;
    
    public DirectorInforme(InformeBuilder builder) {
        this.builder = builder;
    }
    
    public void cambiarBuilder(InformeBuilder builder) {
        this.builder = builder;
    }
    
    public InformeTerapeutico construirInformeCompleto(
            int id,
            Paciente paciente,
            Terapeuta terapeuta,
            Sueño sueño,
            Analizador analizadorTextual,
            Analizador analizadorSimbolico,
            Analizador analizadorEmocional,
            List<String> graficos,
            String conclusiones,
            String recomendaciones) {
        
        builder.reset();
        builder.setInformacionBasica(id, paciente, terapeuta, sueño);
        
        // Realizamos los análisis si no se han hecho todavía
        analizadorTextual.analizar(sueño);
        analizadorSimbolico.analizar(sueño);
        analizadorEmocional.analizar(sueño);
        
        // Construimos las secciones del informe
        builder.construirAnalisisTextual(analizadorTextual.obtenerResultado());
        builder.construirAnalisisSimbolico(analizadorSimbolico.obtenerResultado());
        builder.construirAnalisisEmocional(analizadorEmocional.obtenerResultado());
        
        if (graficos != null && !graficos.isEmpty()) {
            builder.construirGraficosInterpretacion(graficos.toArray(new String[0]));
        }
        
        builder.construirConclusiones(conclusiones);
        builder.construirRecomendaciones(recomendaciones);
        
        return builder.obtenerInforme();
    }
    
    public InformeTerapeutico construirInformeBasico(
            int id, 
            Paciente paciente, 
            Terapeuta terapeuta, 
            Sueño sueño, 
            Analizador analizadorPrincipal,
            String conclusiones) {
        
        builder.reset();
        builder.setInformacionBasica(id, paciente, terapeuta, sueño);
        
        // Solo realizamos el análisis principal
        analizadorPrincipal.analizar(sueño);
        
        // Construimos solo las secciones esenciales
        builder.construirAnalisisTextual(analizadorPrincipal.obtenerResultado());
        builder.construirConclusiones(conclusiones);
        
        return builder.obtenerInforme();
    }
}