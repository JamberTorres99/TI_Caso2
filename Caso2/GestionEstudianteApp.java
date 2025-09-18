import java.util.ArrayList;
import java.util.Scanner;

public class GestionEstudianteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        // --- Estudiantes fijos ---
        Estudiante Juan = new EstudianteRegular("Juan Torres", 20);
        Juan.agregarCurso(new Curso("Programación Orientada a Objetos", 4, "Lunes y Miercoles 8:00 - 10:00", "Presencial", "Ing. Ramirez"));
        Juan.agregarCurso(new Curso("Matemática Discreta", 5, "Martes y Jueves 9:00 - 11:00", "Presencial", "Lic. Castro"));
        Juan.agregarCurso(new Curso("Estructura de Datos", 4, "Martes y Jueves 14:00 - 16:00", "Remoto", "Lic. Hernandez"));
        Juan.agregarCurso(new Curso("Ingeniería de Software I", 5, "Viernes 8:00 - 12:00", "Presencial", "Ing. Flores"));
        Juan.agregarCurso(new Curso("Sistemas Operativos", 4, "Sabados 8:00 - 12:00", "Presencial", "Ing. Ruiz"));
        estudiantes.add(Juan);

        Estudiante Diana = new EstudianteBecado("Diana Gonzales", 22, 0.5);
        Diana.agregarCurso(new Curso("Bases de Datos", 3, "Lun y Miercoles 11:00 - 13:00", "Remoto", "Lic. Fernandez"));
        Diana.agregarCurso(new Curso("Redes de Computadoras", 4, "Martes y Jue 8:00 - 10:00", "Presencial", "Ing. Salazar"));
        Diana.agregarCurso(new Curso("Inteligencia Artificial", 5, "Martes y Jue 16:00 - 18:00", "Remoto", "Ing. Vargas"));
        Diana.agregarCurso(new Curso("Seguridad Informática", 5, "Viernes 14:00 - 18:00", "Presencial", "Lic. Torres"));
        Diana.agregarCurso(new Curso("Arquitectura de Computadoras", 5, "Sabados 8:00 - 12:00", "Presencial", "Ing. Morales"));
        estudiantes.add(Diana);
        
        // Estudiante fijo nuevo (18 creditos, regular)
        Estudiante Carlos = new EstudianteRegular("Carlos Ramirez", 23);
        Carlos.agregarCurso(new Curso("Calculo II", 4, "Lun y Miercoles 9:00 - 11:00", "Presencial", "Lic. Paredes"));
        Carlos.agregarCurso(new Curso("Fisica I", 3, "Martes y Jueves 8:00 - 9:30", "Presencial", "Ing. Torres"));
        Carlos.agregarCurso(new Curso("Etica Profesional", 3, "Miercoles 14:00 - 16:00", "Remoto", "Lic. Castillo"));
        Carlos.agregarCurso(new Curso("Programacion II", 4, "Viernes 10:00 - 12:00", "Presencial", "Ing. Lopez"));
        Carlos.agregarCurso(new Curso("Algebra Lineal", 4, "Sabado 8:00 - 12:00", "Presencial", "Lic. Ramos"));
        estudiantes.add(Carlos);
        
        // Estudiante fijo nuevo (20 creditos, becado 50%)
        Estudiante Jose = new EstudianteBecado("Jose Castillo", 21, 0.5);
        Jose.agregarCurso(new Curso("Algoritmos", 4, "Lun y Miercoles 8:00 - 10:00", "Presencial", "Lic. Medina"));
        Jose.agregarCurso(new Curso("Base de Datos II", 4, "Martes y Jueves 10:00 - 12:00", "Remoto", "Ing. Rojas"));
        Jose.agregarCurso(new Curso("Sistemas Digitales", 4, "Miercoles 14:00 - 16:00", "Presencial", "Ing. Ortega"));
        Jose.agregarCurso(new Curso("Probabilidades", 4, "Viernes 8:00 - 10:00", "Presencial", "Lic. Vargas"));
        Jose.agregarCurso(new Curso("Programacion Web", 4, "Sabado 9:00 - 13:00", "Presencial", "Ing. Campos"));
        estudiantes.add(Jose);

        System.out.print("Desea registrar mas estudiantes? (s/n): ");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Cuantos estudiantes mas desea?: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nEstudiante " + (i + 1));
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine();

                System.out.print("Es becado? (s/n): ");
                String tipo = sc.nextLine();

                Estudiante nuevo;
                if (tipo.equalsIgnoreCase("s")) {
                    System.out.print("Porcentaje beca (0-100): ");
                    double porc = sc.nextDouble();
                    sc.nextLine();
                    nuevo = new EstudianteBecado(nombre, edad, porc / 100);
                } else {
                    nuevo = new EstudianteRegular(nombre, edad);
                }

                System.out.print("Cuantos cursos llevara?: ");
                int numCursos = sc.nextInt();
                sc.nextLine();

                for (int j = 0; j < numCursos; j++) {
                    System.out.println("Curso " + (j + 1));
                    System.out.print("Nombre del curso: ");
                    String nc = sc.nextLine();

                    System.out.print("Creditos: ");
                    int cr = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Horario: ");
                    String hor = sc.nextLine();

                    System.out.print("Modalidad: ");
                    String mod = sc.nextLine();

                    System.out.print("Docente: ");
                    String doc = sc.nextLine();

                    nuevo.agregarCurso(new Curso(nc, cr, hor, mod, doc));
                }

                estudiantes.add(nuevo);
            }
        }

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