// Clase InformeTerapeutico
package builder;

import model.Sueño;
import model.Paciente;
import model.Terapeuta;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class InformeTerapeutico {
    private int id;
    private Date fechaCreacion;
    private Paciente paciente;
    private Terapeuta terapeuta;
    private Sueño sueño;
    private String analisisTextual;
    private String analisisSimbolico;
    private String analisisEmocional;
    private List<String> graficosInterpretacion;
    private String conclusiones;
    private String recomendaciones;
    
    public InformeTerapeutico() {
        this.fechaCreacion = new Date();
        this.graficosInterpretacion = new ArrayList<>();
    }
    
    // Getters
    public int getId() { return id; }
    public Date getFechaCreacion() { return fechaCreacion; }
    public Paciente getPaciente() { return paciente; }
    public Terapeuta getTerapeuta() { return terapeuta; }
    public Sueño getSueño() { return sueño; }
    public String getAnalisisTextual() { return analisisTextual; }
    public String getAnalisisSimbolico() { return analisisSimbolico; }
    public String getAnalisisEmocional() { return analisisEmocional; }
    public List<String> getGraficosInterpretacion() { return graficosInterpretacion; }
    public String getConclusiones() { return conclusiones; }
    public String getRecomendaciones() { return recomendaciones; }
    
    // Setters
    public void setId(int id) { this.id = id; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public void setTerapeuta(Terapeuta terapeuta) { this.terapeuta = terapeuta; }
    public void setSueño(Sueño sueño) { this.sueño = sueño; }
    public void setAnalisisTextual(String analisisTextual) { this.analisisTextual = analisisTextual; }
    public void setAnalisisSimbolico(String analisisSimbolico) { this.analisisSimbolico = analisisSimbolico; }
    public void setAnalisisEmocional(String analisisEmocional) { this.analisisEmocional = analisisEmocional; }
    public void agregarGraficoInterpretacion(String grafico) { this.graficosInterpretacion.add(grafico); }
    public void setConclusiones(String conclusiones) { this.conclusiones = conclusiones; }
    public void setRecomendaciones(String recomendaciones) { this.recomendaciones = recomendaciones; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INFORME TERAPÉUTICO ===\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Fecha: ").append(fechaCreacion).append("\n");
        sb.append("Paciente: ").append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n");
        sb.append("Terapeuta: ").append(terapeuta.getNombre()).append(" ").append(terapeuta.getApellido()).append("\n\n");
        
        sb.append("--- SUEÑO ANALIZADO ---\n");
        sb.append("ID: ").append(sueño.getId()).append("\n");
        sb.append("Descripción: ").append(sueño.getDescripcion()).append("\n\n");
        
        if (analisisTextual != null && !analisisTextual.isEmpty()) {
            sb.append("--- ANÁLISIS TEXTUAL ---\n").append(analisisTextual).append("\n\n");
        }
        
        if (analisisSimbolico != null && !analisisSimbolico.isEmpty()) {
            sb.append("--- ANÁLISIS SIMBÓLICO ---\n").append(analisisSimbolico).append("\n\n");
        }
        
        if (analisisEmocional != null && !analisisEmocional.isEmpty()) {
            sb.append("--- ANÁLISIS EMOCIONAL ---\n").append(analisisEmocional).append("\n\n");
        }
        
        if (!graficosInterpretacion.isEmpty()) {
            sb.append("--- GRÁFICOS DE INTERPRETACIÓN ---\n");
            for (String grafico : graficosInterpretacion) {
                sb.append("* ").append(grafico).append("\n");
            }
            sb.append("\n");
        }
        
        if (conclusiones != null && !conclusiones.isEmpty()) {
            sb.append("--- CONCLUSIONES ---\n").append(conclusiones).append("\n\n");
        }
        
        if (recomendaciones != null && !recomendaciones.isEmpty()) {
            sb.append("--- RECOMENDACIONES ---\n").append(recomendaciones).append("\n\n");
        }
        
        return sb.toString();
    }
}