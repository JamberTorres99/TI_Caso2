public class EstudianteBecado extends Estudiante {

    private static final double COSTO_POR_CREDITO = 700.0 / 22.0;
    private double beca; // 0.0 a 1.0

    public EstudianteBecado(String nombre, int edad, double beca) {
        super(nombre, edad);
        this.beca = beca;
    }

    @Override
    public double calcularMensualidad() {
        double suma = 0;
        for (Curso c : getCursos()) {
            suma += c.getCreditos() * COSTO_POR_CREDITO;
        }
        return suma * (1 - beca);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Beca aplicada: " + (int)(beca * 100) + "%");
    }
}