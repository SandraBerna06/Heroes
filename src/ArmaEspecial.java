import java.util.LinkedList;
import java.util.Scanner;

import java.util.LinkedList;
import java.util.Scanner;

public class ArmaEspecial {
    String nombre;
    int daño;
    ArmaEspecial armaespecial;
    static LinkedList<ArmaEspecial> armasDisponibles = new LinkedList<>();

    public ArmaEspecial(String nombre, int daño) {
        this.nombre = nombre;
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDaño() {
        return daño;
    }


    public static void inicializarArmas() {
        armasDisponibles.add(new ArmaEspecial("Bastón Arcano", 50));
        armasDisponibles.add(new ArmaEspecial("Orbe Místico", 60));
    }

    public static void addNewArma() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del arma:");
        String nombreArma = scanner.nextLine();


        for (ArmaEspecial armaExistente : armasDisponibles) {
            if (armaExistente.nombre.equalsIgnoreCase(nombreArma)) {
                System.out.println("El arma ya existe. No se puede añadir.");
                return;
            }
        }

        System.out.println("Introduce el daño del arma:");
        int daño = scanner.nextInt();
        scanner.nextLine();


        ArmaEspecial nuevaArma = new ArmaEspecial(nombreArma, daño);
        armasDisponibles.add(nuevaArma);
        System.out.println("Arma añadida con éxito: " + nuevaArma.getNombre());
    }

    public static ArmaEspecial eligeArma() {
        Scanner scanner = new Scanner(System.in);
        if (armasDisponibles.isEmpty()) {
            System.out.println("No hay armas disponibles.");
            return null;
        }

        System.out.println("Elige un arma:");
        for (int i = 0; i < armasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + armasDisponibles.get(i).getNombre() + " (Daño: " + armasDisponibles.get(i).getDaño() + ")");
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion < 1 || opcion > armasDisponibles.size()) {
            System.out.println("Opción inválida.");
            return null;
        }
        return armasDisponibles.get(opcion - 1);
    }
    public static ArmaEspecial crearArmaPersonalizada() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del arma:");
        String nombreArma = scanner.nextLine();

        System.out.println("Introduce el daño del arma:");
        int daño = scanner.nextInt();
        scanner.nextLine();

        return new ArmaEspecial(nombreArma, daño);
    }

    public static void añadirArmaAHeroe(Heroe heroe) {
        Scanner scanner = new Scanner(System.in);

        ArmaEspecial nuevaArma = ArmaEspecial.crearArmaPersonalizada();


        heroe.addArma(nuevaArma);

        System.out.println("El arma " + nuevaArma.getNombre() + " ha sido añadida a " + heroe.getNombre());
    }



    }

