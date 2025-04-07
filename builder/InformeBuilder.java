// Interfaz InformeBuilder
package builder;

import model.Sueño;
import model.Paciente;
import model.Terapeuta;

public interface InformeBuilder {
    void reset();
    void setInformacionBasica(int id, Paciente paciente, Terapeuta terapeuta, Sueño sueño);
    void construirAnalisisTextual(String analisis);
    void construirAnalisisSimbolico(String analisis);
    void construirAnalisisEmocional(String analisis);
    void construirGraficosInterpretacion(String... graficos);
    void construirConclusiones(String conclusiones);
    void construirRecomendaciones(String recomendaciones);
    InformeTerapeutico obtenerInforme();
}