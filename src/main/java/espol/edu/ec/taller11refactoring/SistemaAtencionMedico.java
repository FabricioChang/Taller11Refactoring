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

    public void removePaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void removeMedico(Medico medico) {
        medicos.remove(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.add(servicioMedico);
    }

    public void removeServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.remove(servicioMedico);
    }

    public void agendarConsulta(Paciente paciente, Consulta consulta) {
        double costoConsulta = calcularValorFinalConsulta(consulta);
        System.out.println("Se han cobrado " + costoConsulta + " dolares de su tarjeta de credito");
        paciente.getHistorialMedico().getConsultas().add(consulta);
    }

    public double calcularValorFinalConsulta(Consulta consulta) {
        double costoConsulta = consulta.getServicioMedico().getCosto();
        int edadPaciente = consulta.getPaciente().getEdad();
        double valorARestar = 0;
        if (edadPaciente >= 65) {
            valorARestar = costoConsulta * 0.25; // 0.25 es el descuento para adultos mayores
        }
        return costoConsulta - valorARestar;
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
