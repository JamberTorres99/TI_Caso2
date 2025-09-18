import java.util.ArrayList;

public abstract class Estudiante implements Evaluable {
    private String nombre;
    private int edad;
    private ArrayList<Curso> cursos;

    public Estudiante(String nombre, int edad) {
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

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public abstract double calcularMensualidad();

    @Override
    public void evaluar() {
        System.out.println(nombre + " esta rindiendo evaluacion en sus cursos.");
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " - Edad: " + edad);
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }
}