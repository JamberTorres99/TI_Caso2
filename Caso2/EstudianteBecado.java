public class EstudianteBecado extends Estudiante {

    private static final double COSTO_POR_CREDITO = 700.0 / 22.0;
    private double porcentajeBeca;

    public EstudianteBecado(String nombre, int edad, double porcentajeBeca) {
        super(nombre, edad);
        if (porcentajeBeca < 0.0 || porcentajeBeca > 1.0) {
            throw new IllegalArgumentException("El porcentaje de beca debe estar entre 0.0 y 1.0");
        }
        this.porcentajeBeca = porcentajeBeca;
    }

    @Override
    public double calcularMensualidad() {
        double total = 0;
        for (Curso c : getCursos()) {
            total += c.getCreditos() * COSTO_POR_CREDITO;
        }
        return total * (1.0 - porcentajeBeca);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Porcentaje de beca: " + (int)(porcentajeBeca * 100) + "%");
    }
}