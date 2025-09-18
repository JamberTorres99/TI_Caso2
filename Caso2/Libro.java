public class Libro {
    private String titulo;
    private Autor autor;
    private int anio;
    private String isbn;

    // Método de validación centralizado
    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El libro debe tener un título.");
        }
    }

    // Constructor SIN ISBN
    public Libro(String titulo, Autor autor, int anio) {
        validarTitulo(titulo);
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    // Constructor CON ISBN
    public Libro(String titulo, Autor autor, int anio, String isbn) {
        validarTitulo(titulo);
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Anio: " + anio);
        if (isbn != null) {
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("ISBN: No registrado");
        }
    }
}