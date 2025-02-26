import java.util.ArrayList;
import java.util.Scanner;

public class Mago extends Heroe{
    int mana;

    public Mago(String nombre, int nivel, int puntosVida, ArmaEspecial armaespecial, int mana) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.mana = mana;
    }

    public void generarMana(){
    Scanner scanner=new Scanner(System.in);
        System.out.println("Introduce el descanso que desee");
        int descanso=scanner.nextInt();
        if(descanso>=0){
            System.out.println("Produciendo maná...");
            int mana=20;
            int producirMana=(descanso*mana);
            System.out.println("Maná producida: "+producirMana);
        }else{
            System.out.println("No se puede producir maná");
        }
    }

    public void hechizar(){
        if(mana==0){
            System.out.println("Necesitas producir maná porque no te queda");
            generarMana();
        }else{
            System.out.println("Puedes hechizar");
            int dañoTotal=(mana* armaespecial.getDaño());
            System.out.println("El daño producido es: "+dañoTotal);
        }
    }

    @Override
    public String toString() {
        return "Mago{" +
                "mana=" + mana +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", armaespecial=" + armaespecial +
                ", arma=" + arma +
                '}';
    }
}
