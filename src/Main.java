import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    static LinkedList<Heroe> heroes=new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido a Héroes 1J");
        ArmaEspecial.inicializarArmas();
        play();

    }

    public static void printMenu() {
        System.out.println("Menú:\n " +
                "1. Añadir un nuevo héroe.\n" +
                "2. Añadir un arma nueva al arsenal.\n" +
                "3. Eliminar un héroe por su nombre.\n" +
                "4. Buscar un héroe y mostrar sus detalles.\n" +
                "5. Listar todos los héroes registrados en el gremio.\n" +
                "6. Salir del programa.\n" +
                "7. Añadir un arma adicional a un héroe\n");
    }

    public static void printHeroes(){
        System.out.println("Héroes:\n " +
                "1. Guerrero\n" +
                "2. Mago\n" +
                "3. Arquero\n" +
                "4. Asesino\n");
    }

    public static void printArma(){
        System.out.println("Armas:\n " +
                "1. Bastón Arcano (Daño: 50)\n" +
                "2. Orbe Místico (Daño: 60)\n");
    }

    public static void play() {

        heroes.add(new Guerrero("Super Man", 3, 5, new ArmaEspecial("Puño", 5), 2));
        heroes.add(new Mago("Harry Potter", 2, 0, new ArmaEspecial("Barita", 7), 5));
        heroes.add(new Arquero("Spider Man", 6, 2, new ArmaEspecial("Arco", 4), 3));
        heroes.add(new Asesino("Peter Pan", 7, 4, new ArmaEspecial("Pistola", 5), 2));
        heroes.add(new Heroe("Batman", 4, 5, new ArmaEspecial("Laser", 40)));

        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            printMenu();
            System.out.println("Elige una opción:");
            numero = scanner.nextInt();
            scanner.nextLine();
                switch (numero) {
                    case 1:
                        System.out.println("Añadiendo un nuevo héroe...");
                        if (Heroe.addNewHeroe(heroes)) {
                            ArmaEspecial armas = ArmaEspecial.eligeArma();
                            if (armas != null && !heroes.isEmpty()) {
                                heroes.getLast().setArmaespecial(armas);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Introduce el nombre del héroe al que quieres añadir un arma:");
                        String nombreHeroe = scanner.nextLine();
                        Heroe heroeEncontrado = Heroe.findHeroe(nombreHeroe, heroes);
                        ArmaEspecial.addNewArma();
                        break;

                    case 3:
                        System.out.println("Introduce el nombre del héroe a eliminar:");
                        String nombreEliminar = scanner.nextLine();
                        boolean eliminado = Heroe.removeHeroe(nombreEliminar, heroes);
                        if (eliminado) {
                            System.out.println("Héroe eliminado con éxito.");
                        } else {
                            System.out.println("No se encontró el héroe.");
                        }
                        break;

                    case 4:
                        System.out.println("Introduce el nombre del héroe a buscar:");
                        String heroeBuscar = scanner.nextLine();
                         Heroe heroeEncontrado2 = Heroe.findHeroe(heroeBuscar, heroes);

                        if (heroeEncontrado2 != null) {
                            System.out.println("Héroe encontrado:\n" +
                                    "Nombre: " + heroeEncontrado2.getNombre() + "\n" +
                                    "Nivel: " + heroeEncontrado2.getNivel() + "\n" +
                                    "Puntos de Vida: " + heroeEncontrado2.getPuntosVida() + "\n" +
                                    "Arma Especial: " + (heroeEncontrado2.getArmaespecial() != null ? heroeEncontrado2.getArmaespecial().getNombre() : "Ninguna"));
                        } else {
                            System.out.println("Héroe no encontrado.");
                        }
                        break;

                    case 5:
                        Heroe.listarHeroe(heroes);
                        break;

                    case 6:
                        Heroe.salir();
                        break;
                    case 7:
                        System.out.println("Introduce el nombre del héroe al que quieres añadir un arma:");
                        String nombreHeroe4 = scanner.nextLine();
                        Heroe heroeParaArma = Heroe.findHeroe(nombreHeroe4, heroes);

                        if (heroeParaArma != null) {
                            ArmaEspecial.añadirArmaAHeroe(heroeParaArma);
                            heroeParaArma.mostrarArmas();
                        } else {
                            System.out.println("Héroe no encontrado.");
                        }
                        break;

                    default:
                        System.out.println("Error");
                        break;
                }



        }while (numero != 6) ;
    }
}
