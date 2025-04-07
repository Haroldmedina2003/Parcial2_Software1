// Clase RepositorioFactory
package repository;

public class RepositorioFactory {
    public static SueñoRepositorio crearRepositorio(String tipo) {
        if ("historico".equals(tipo.toLowerCase())) {
            return new RepositorioHistorico();
        } else if ("temporal".equals(tipo.toLowerCase())) {
            return new RepositorioTemporal();
        } else {
            throw new IllegalArgumentException("Tipo de repositorio no soportado: " + tipo);
        }
    }
}