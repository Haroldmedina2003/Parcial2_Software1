// Implementación InformeDetalladoBuilder
package builder;

import model.Sueño;
import model.Paciente;
import model.Terapeuta;

public class InformeDetalladoBuilder implements InformeBuilder {
    private InformeTerapeutico informe;
    
    public InformeDetalladoBuilder() {
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
        informe.setAnalisisTextual(analisis);
    }
    
    @Override
    public void construirAnalisisSimbolico(String analisis) {
        informe.setAnalisisSimbolico(analisis);
    }
    
    @Override
    public void construirAnalisisEmocional(String analisis) {
        informe.setAnalisisEmocional(analisis);
    }
    
    @Override
    public void construirGraficosInterpretacion(String... graficos) {
        for (String grafico : graficos) {
            informe.agregarGraficoInterpretacion(grafico);
        }
    }
    
    @Override
    public void construirConclusiones(String conclusiones) {
        informe.setConclusiones(conclusiones);
    }
    
    @Override
    public void construirRecomendaciones(String recomendaciones) {
        informe.setRecomendaciones(recomendaciones);
    }
    
    @Override
    public InformeTerapeutico obtenerInforme() {
        return informe;
    }
}