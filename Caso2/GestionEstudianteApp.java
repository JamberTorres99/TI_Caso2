import java.util.ArrayList;
import java.util.Scanner;

public class GestionEstudianteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        // --- Estudiantes fijos ---
        Estudiante est1 = new EstudianteRegular("Ana Torres", 20);
        est1.agregarCurso(new Curso("Programación Orientada a Objetos", 4, "Lun y Mié 8:00 - 10:00", "Presencial", "Ing. Ramírez"));
        est1.agregarCurso(new Curso("Matemática Discreta", 5, "Mar y Jue 9:00 - 11:00", "Presencial", "Lic. Castro"));
        est1.agregarCurso(new Curso("Estructura de Datos", 4, "Mar y Jue 14:00 - 16:00", "Remoto", "Lic. Hernández"));
        est1.agregarCurso(new Curso("Ingeniería de Software I", 5, "Vie 8:00 - 12:00", "Presencial", "Ing. Flores"));
        est1.agregarCurso(new Curso("Sistemas Operativos", 4, "Sáb 8:00 - 12:00", "Presencial", "Ing. Ruiz"));
        estudiantes.add(est1);

        Estudiante est2 = new EstudianteBecado("Luis Pérez", 22, 0.5);
        est2.agregarCurso(new Curso("Bases de Datos", 3, "Lun y Mié 11:00 - 13:00", "Remoto", "Lic. Fernández"));
        est2.agregarCurso(new Curso("Redes de Computadoras", 4, "Mar y Jue 8:00 - 10:00", "Presencial", "Ing. Salazar"));
        est2.agregarCurso(new Curso("Inteligencia Artificial", 5, "Mar y Jue 16:00 - 18:00", "Remoto", "Ing. Vargas"));
        est2.agregarCurso(new Curso("Seguridad Informática", 5, "Vie 14:00 - 18:00", "Presencial", "Lic. Torres"));
        est2.agregarCurso(new Curso("Arquitectura de Computadoras", 5, "Sáb 8:00 - 12:00", "Presencial", "Ing. Morales"));
        estudiantes.add(est2);

        // --- Menú principal ---
        System.out.println("¿Desea agregar más estudiantes?");
        System.out.println("1. No, mostrar solo los fijos");
        System.out.println("2. Sí, quiero registrar más estudiantes");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 2) {
            System.out.print("¿Cuántos estudiantes desea agregar? ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nRegistro del estudiante " + (i + 1));

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine();

                System.out.print("¿Es becado? (s/n): ");
                String tipo = sc.nextLine();

                Estudiante nuevoEstudiante;
                if (tipo.equalsIgnoreCase("s")) {
                    System.out.print("Ingrese porcentaje de beca (0-100): ");
                    double porc = sc.nextDouble();
                    sc.nextLine();
                    nuevoEstudiante = new EstudianteBecado(nombre, edad, porc / 100.0);
                } else {
                    nuevoEstudiante = new EstudianteRegular(nombre, edad);
                }

                System.out.print("¿Cuántos cursos registrará este estudiante? ");
                int cantCursos = sc.nextInt();
                sc.nextLine();

                for (int j = 0; j < cantCursos; j++) {
                    System.out.println("\nCurso " + (j + 1));

                    System.out.print("Nombre del curso: ");
                    String nombreCurso = sc.nextLine();

                    System.out.print("Créditos: ");
                    int creditos = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Horario: ");
                    String horario = sc.nextLine();

                    System.out.print("Modalidad (Presencial/Remoto): ");
                    String modalidad = sc.nextLine();

                    System.out.print("Docente: ");
                    String docente = sc.nextLine();

                    nuevoEstudiante.agregarCurso(new Curso(nombreCurso, creditos, horario, modalidad, docente));
                }

                estudiantes.add(nuevoEstudiante);
            }
        }

        // --- Mostrar todos los estudiantes ---
        System.out.println("\n===== LISTA DE ESTUDIANTES =====");
        for (Estudiante e : estudiantes) {
            e.mostrarInfo();
            System.out.println("Mensualidad: S/" + e.calcularMensualidad());
            e.evaluar();
            System.out.println("---------------------");
        }

        sc.close();
    }
}