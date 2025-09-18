public class EstudianteRegular extends Estudiante {

    private static final double COSTO_POR_CREDITO = 700.0 / 22.0;

    public EstudianteRegular(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public double calcularMensualidad() {
        double suma = 0;
        for (Curso c : getCursos()) {
            suma += c.getCreditos() * COSTO_POR_CREDITO;
        }
        return suma;
    }
}