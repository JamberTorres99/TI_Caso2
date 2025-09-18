import java.util.ArrayList;

public abstract class Estudiante implements Evaluable {
    private String nombre;
    private int edad;
    private ArrayList<Curso> cursos; // ahora es una lista de cursos

    public Estudiante(String nombre, int edad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El estudiante debe tener un nombre.");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public abstract double calcularMensualidad();

    @Override
    public void evaluar() {
        System.out.println(nombre + " está siendo evaluado en sus cursos registrados.");
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " - Edad: " + edad);
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }
}