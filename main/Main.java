// Clase Main para demostrar el funcionamiento del sistema
package main;

import java.util.ArrayList;
import java.util.List;

import analysis.Analizador;
import builder.DirectorInforme;
import builder.InformeBuilder;
import builder.InformeDetalladoBuilder;
import builder.InformeResumidoBuilder;
import builder.InformeTerapeutico;
import factory.EnfoqueConductualFactory;
import factory.EnfoqueJungianoFactory;
import factory.EnfoqueTerapeuticoFactory;
import model.Paciente;
import model.Sueño;
import model.Terapeuta;
import pool.AnalizadorPool;
import repository.RepositorioFactory;
import repository.SueñoRepositorio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Configuración clínica cargada."); // Corregido

        // 2. Creación de pacientes y terapeutas
        Paciente paciente = new Paciente(1, "Juan", "Pérez");
        Terapeuta terapeuta = new Terapeuta(101, "María", "González", "Psicología Junguiana");

        System.out.println("Paciente creado: " + paciente.getNombre() + " " + paciente.getApellido());
        System.out.println("Terapeuta creado: " + terapeuta.getNombre() + " " + terapeuta.getApellido());

        // 3. Uso del Factory Method para crear repositorios
        SueñoRepositorio repositorioHistorico = RepositorioFactory.crearRepositorio("historico");
        SueñoRepositorio repositorioTemporal = RepositorioFactory.crearRepositorio("temporal");

        // 4. Crear y registrar un sueño
        Sueño sueño = new Sueño(1,
                "Soñé que volaba sobre el océano. Luego, encontré una isla con una montaña muy alta.",
                paciente); // Se agrega el paciente como tercer parámetro
        sueño.setDuracion(45);
        sueño.setIntensidadEmocional(8);
        sueño.setClaridadVisual(9);
        sueño.agregarCaracteristica("personasPresentes", 0); // Cambiado a Integer
        sueño.agregarCaracteristica("sensacionDeControl", true); // Cambiado a Boolean

        // Validación del sueño (simulación de configuración)
        if (sueño.getDuracion() > 0 && sueño.getIntensidadEmocional() > 0) {
            System.out.println("Sueño validado correctamente.");
        } else {
            System.out.println("Error en la validación del sueño.");
            return;
        }

        // Guardamos el sueño en el repositorio histórico
        repositorioHistorico.guardarSueño(sueño);

        // 5. Uso del Prototype para clonar el sueño para análisis alternativos
        Sueño sueñoClonado = sueño.clone();
        System.out.println("Sueño clonado con ID: " + sueñoClonado.getId());

        // Guardamos el clon en el repositorio temporal
        repositorioTemporal.guardarSueño(sueñoClonado);

        // 6. Uso de Abstract Factory para crear analizadores según el enfoque
        // terapéutico
        EnfoqueTerapeuticoFactory enfoqueJungiano = new EnfoqueJungianoFactory();
        EnfoqueTerapeuticoFactory enfoqueConductual = new EnfoqueConductualFactory();

        // 7. Inicializar el pool de analizadores
        AnalizadorPool pool = AnalizadorPool.getInstance();
        pool.inicializarPool(enfoqueJungiano);

        try {
            // 8. Obtener analizadores del pool
            Analizador analizadorEmocional = pool.obtenerAnalizador("emocional");
            Analizador analizadorSimbolico = pool.obtenerAnalizador("simbolico");
            Analizador analizadorCognitivo = pool.obtenerAnalizador("cognitivo");

            System.out.println("\nRealizando análisis con enfoque Jungiano...");
            analizadorEmocional.analizar(sueño);
            analizadorSimbolico.analizar(sueño);
            analizadorCognitivo.analizar(sueño);

            System.out.println(analizadorEmocional.obtenerResultado());
            System.out.println(analizadorSimbolico.obtenerResultado());
            System.out.println(analizadorCognitivo.obtenerResultado());

            // 10. Uso del Builder para crear informes
            InformeBuilder informeDetalladoBuilder = new InformeDetalladoBuilder();
            DirectorInforme director = new DirectorInforme(informeDetalladoBuilder);

            List<String> graficos = new ArrayList<>();
            graficos.add("Gráfico 1: Tendencia emocional durante el sueño");
            graficos.add("Gráfico 2: Símbolos y arquetipos identificados");

            String conclusiones = "El sueño refleja un proceso típico en personas que están superando una situación estresante. "
                    +
                    "Los símbolos del océano y la montaña sugieren un proceso de autodescubrimiento.";
            String recomendaciones = "Se sugiere explorar actividades relacionadas con el ascenso y la superación.";

            // Construir informe detallado
            InformeTerapeutico informeDetallado = director.construirInformeCompleto(
                    1, paciente, terapeuta, sueño, analizadorEmocional, analizadorSimbolico, analizadorCognitivo,
                    graficos, conclusiones, recomendaciones);

            // Cambiar a informe resumido
            InformeBuilder informeResumidoBuilder = new InformeResumidoBuilder();
            director.cambiarBuilder(informeResumidoBuilder);
            InformeTerapeutico informeResumido = director.construirInformeBasico(
                    2, paciente, terapeuta, sueño, analizadorEmocional, conclusiones);

            // 11. Mostrar los informes
            System.out.println("\n=== INFORME DETALLADO ===");
            System.out.println(informeDetallado);

            System.out.println("\n=== INFORME RESUMIDO ===");
            System.out.println(informeResumido);

            // 12. Liberar los analizadores al pool
            pool.liberarAnalizador("emocional", analizadorEmocional);
            pool.liberarAnalizador("simbolico", analizadorSimbolico);
            pool.liberarAnalizador("cognitivo", analizadorCognitivo);

            System.out.println("\nCambiando a enfoque conductual...");
            pool.inicializarPool(enfoqueConductual);

            Analizador analizadorConductual = pool.obtenerAnalizador("emocional");
            analizadorConductual.analizar(sueñoClonado);
            System.out.println(analizadorConductual.obtenerResultado());

            pool.liberarAnalizador("emocional", analizadorConductual);

        } catch (Exception e) {
            System.err.println("Error durante el análisis: " + e.getMessage());
            e.printStackTrace();
        }
    }
}