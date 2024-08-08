package espol.edu.ec.taller11refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SistemaAtencionMedico {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<ServicioMedico> serviciosMedicos;
    private static final double descuento_de_adultos_mayores = 0.25;
    private static final int edad_de_tercera_edad = 65;

    public SistemaAtencionMedico() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.serviciosMedicos = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.add(servicioMedico);
    }

    public void agendarConsulta(Paciente paciente, Consulta consulta){
        double costoConsulta = consulta.getServicioMedico().getCosto();
        int edadPaciente = paciente.getEdad();
        costoConsulta = calcularValorFinalConsulta(costoConsulta,edadPaciente);
        System.out.println("Se han cobrado "+ costoConsulta+ " dolares de su tarjeta de credito");
        paciente.historialMedico.getConsultas().add(consulta);
    }

    public double calcularValorFinalConsulta(double costoConsulta, int edadPaciente){
        double valorARestar = 0;
        
        if(edadPaciente>=edad_de_tercera_edad){
            valorARestar = costoConsulta*descuento_de_adultos_mayores;
        }
        return costoConsulta-valorARestar;
    }

    public <T> T obtenerElemento(List<T> elementos, Predicate<T> criterio) {
        for (T elemento : elementos) {
            if (criterio.test(elemento)) {
                return elemento;
            }
        }
        return null;
    }

    public Paciente obtenerPaciente(String nombrePaciente) {
        return obtenerElemento(pacientes, p -> p.getNombre().equals(nombrePaciente));
    }

    public ServicioMedico obtenerServicioMedico(String nombreServicio) {
        return obtenerElemento(serviciosMedicos, s -> s.getNombre().equals(nombreServicio));
    }

    public Medico obtenerMedico(String nombreMedico) {
        return obtenerElemento(medicos, m -> m.getNombre().equals(nombreMedico));
    }
}
