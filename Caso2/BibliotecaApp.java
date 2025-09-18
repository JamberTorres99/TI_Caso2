public class BibliotecaApp {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");

        try {
            Libro libro1 = new Libro("Cien Años de Soledad", autor1, 1967);
            libro1.mostrarInfo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar libro1: " + e.getMessage());
        }

        System.out.println("---------------------");

        try {
            Libro libro2 = new Libro("La ciudad perdida", autor1, 1975, "978-84-376-0494-7");
            libro2.mostrarInfo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar libro2: " + e.getMessage());
        }

        System.out.println("---------------------");

        try {
            Libro libroError = new Libro("", autor1, 2023);
            libroError.mostrarInfo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar libroError: " + e.getMessage());
        }
    }
}