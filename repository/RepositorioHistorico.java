// Implementación RepositorioHistorico
package repository;

import model.Sueño;
import model.Paciente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioHistorico implements SueñoRepositorio {
    private Map<Integer, Sueño> sueños = new HashMap<>();
    
    @Override
    public void guardarSueño(Sueño sueño) {
        sueños.put(sueño.getId(), sueño);
        System.out.println("Sueño guardado en repositorio histórico: " + sueño.getId());
    }
    
    @Override
    public Sueño obtenerSueño(int id) {
        return sueños.get(id);
    }
    
    @Override
    public List<Sueño> obtenerSueñosPorPaciente(Paciente paciente) {
        return sueños.values().stream()
                .filter(s -> s.getPaciente().getId() == paciente.getId())
                .collect(Collectors.toList());
    }
    
    @Override
    public void actualizarSueño(Sueño sueño) {
        sueños.put(sueño.getId(), sueño);
        System.out.println("Sueño actualizado en repositorio histórico: " + sueño.getId());
    }
    
    @Override
    public void eliminarSueño(int id) {
        sueños.remove(id);
        System.out.println("Sueño eliminado del repositorio histórico: " + id);
    }
}