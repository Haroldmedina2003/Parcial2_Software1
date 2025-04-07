// Implementación RepositorioTemporal
package repository;

import model.Sueño;
import model.Paciente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioTemporal implements SueñoRepositorio {
    private Map<Integer, Sueño> sueñosTemporales = new HashMap<>();
    
    @Override
    public void guardarSueño(Sueño sueño) {
        sueñosTemporales.put(sueño.getId(), sueño);
        System.out.println("Sueño guardado temporalmente: " + sueño.getId());
    }
    
    @Override
    public Sueño obtenerSueño(int id) {
        return sueñosTemporales.get(id);
    }
    
    @Override
    public List<Sueño> obtenerSueñosPorPaciente(Paciente paciente) {
        return sueñosTemporales.values().stream()
                .filter(s -> s.getPaciente().getId() == paciente.getId())
                .collect(Collectors.toList());
    }
    
    @Override
    public void actualizarSueño(Sueño sueño) {
        sueñosTemporales.put(sueño.getId(), sueño);
        System.out.println("Sueño temporal actualizado: " + sueño.getId());
    }
    
    @Override
    public void eliminarSueño(int id) {
        sueñosTemporales.remove(id);
        System.out.println("Sueño temporal eliminado: " + id);
    }
}
