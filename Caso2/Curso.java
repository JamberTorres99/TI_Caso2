public class Curso {
    private String nombre;
    private int creditos;
    private String horario;
    private String modalidad;
    private String docente;

    public Curso(String nombre, int creditos, String horario, String modalidad, String docente) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.horario = horario;
        this.modalidad = modalidad;
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getHorario() {
        return horario;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getDocente() {
        return docente;
    }

    public void mostrarInfo() {
        System.out.println("Curso: " + nombre);
        System.out.println("Créditos: " + creditos);
        System.out.println("Horario: " + horario);
        System.out.println("Modalidad: " + modalidad);
        System.out.println("Docente: " + docente);
    }
}