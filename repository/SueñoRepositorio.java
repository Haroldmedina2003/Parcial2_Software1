// Interfaz SueñoRepositorio
package repository;

import model.Sueño;
import model.Paciente;
import java.util.List;

public interface SueñoRepositorio {
    void guardarSueño(Sueño sueño);
    Sueño obtenerSueño(int id);
    List<Sueño> obtenerSueñosPorPaciente(Paciente paciente);
    void actualizarSueño(Sueño sueño);
    void eliminarSueño(int id);
}