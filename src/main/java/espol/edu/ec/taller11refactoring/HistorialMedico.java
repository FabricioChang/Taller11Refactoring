package espol.edu.ec.taller11refactoring;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<Consulta> consultas;
    private List<RecetaMedica> recetasMedicas;

    public HistorialMedico() {
        this.consultas = new ArrayList<>();
        this.recetasMedicas = new ArrayList<>();
    }

    public List<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }

    public void addConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void removeConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    public List<RecetaMedica> getRecetasMedicas() {
        return new ArrayList<>(recetasMedicas);
    }

    public void addRecetaMedica(RecetaMedica recetaMedica) {
        recetasMedicas.add(recetaMedica);
    }

    public void removeRecetaMedica(RecetaMedica recetaMedica) {
        recetasMedicas.remove(recetaMedica);
    }
}
