import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Heroe {
    String nombre;
    int nivel;
    int puntosVida;
    ArmaEspecial armaespecial;
    ArrayList<ArmaEspecial> arma;

    public Heroe(String nombre, int nivel, int puntosVida, ArmaEspecial armaespecial) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.armaespecial = armaespecial;
        this.arma = new ArrayList<>();
    }

    public ArmaEspecial getArmaespecial() {
        return armaespecial;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setArmaespecial(ArmaEspecial armaespecial) {
        this.armaespecial = armaespecial;
    }
    public void addArma(ArmaEspecial arma) {
        this.arma.add(arma); // Añade el arma a la lista de armas del héroe
    }
    public void mostrarArmas() {
        System.out.println("Armas de " + nombre + ":");


        if (armaespecial != null) {
            System.out.println(" - Principal: " + armaespecial.getNombre() + " (Daño: " + armaespecial.getDaño() + ")");
        }


        if (arma.isEmpty()) {
            System.out.println("No tiene armas adicionales.");
        } else {
            for (ArmaEspecial a : arma) {
                System.out.println(" - " + a.getNombre() + " (Daño: " + a.getDaño() + ")");
            }
        }
    }

    public static boolean addNewHeroe(LinkedList<Heroe> heroes) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué tipo de héroe deseas añadir?");
        Main.printHeroes();
        System.out.println("Elige una subopción");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce el nombre del héroe:");
        String nombre = scanner.nextLine();
        if (findHeroe(nombre, heroes) == null) {
            System.out.println("Introduce el nivel del héroe:");
            int nivel = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduce los puntos de vida del héroe:");
            int puntosVida = scanner.nextInt();


            switch (opcion) {
                case 1:
                    System.out.println("Has elegido el Guerrero");
                    System.out.println("Introduce la fuerza del guerrero:");
                    int fuerza = scanner.nextInt();
                    scanner.nextLine();
                     heroes.add(new Guerrero(nombre, nivel, puntosVida, null, fuerza));

                    break;
                case 2:
                    System.out.println("Has elegido el mago");
                    System.out.println("Introduce el maná del mago:");
                    int mana = scanner.nextInt();
                    heroes.add(new Mago(nombre, nivel, puntosVida, null, mana));
                    System.out.println("El héroe se ha añadido exitosamente");

                    break;
                case 3:
                    System.out.println("Has elegido el arquero");
                    System.out.println("Introduce la precisión del arquero:");
                    int precision = scanner.nextInt();
                    heroes.add(new Arquero(nombre, nivel, puntosVida, null, precision));
                    System.out.println("El héroe se ha añadido exitosamente");
                    break;
                case 4:
                    System.out.println("Has elegido el asesino");
                    System.out.println("Introduce el sigilo del asesino:");
                    int sigilo = scanner.nextInt();
                    heroes.add(new Asesino(nombre, nivel, puntosVida, null, sigilo));
                    System.out.println("El héroe se ha añadido exitosamente");
                    break;
            }

            return true;
        } else {
            System.out.println("El héroe existe y no se puede añadir");

        }


        return false;
    }


    public static boolean removeHeroe(String nombre, LinkedList<Heroe> listaHeroes) {
        Iterator<Heroe> iterator = listaHeroes.iterator();


        while (iterator.hasNext()) {
            Heroe heroe = iterator.next();
            if (heroe.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                System.out.println("El héroe '" + nombre + "' ha sido eliminado.");
                return true;

            }
        }
        return false;
        }


    public static Heroe findHeroe(String nombre, LinkedList<Heroe> listaHeroes) {
        for (Heroe h : listaHeroes) {
            if (h.getNombre().equalsIgnoreCase(nombre)) {
                return h;
            }
        }
        return null;
    }

    public static void listarHeroe(LinkedList<Heroe> listaHeroes) {
        if (listaHeroes.isEmpty()) {
            System.out.println("No se pueden listar los héroes al estar vacío");
        } else {
            System.out.println("Lista de héroes registrados en el gremio");
            for (Heroe heroes : listaHeroes) {
                System.out.println("- " + heroes.getNombre());

            }
        }
    }

    public static void salir() {
        System.out.println("Saliendo del programa... ¡Hasta la próxima!");

    }
}




