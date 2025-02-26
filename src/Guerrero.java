import java.util.ArrayList;

public class Guerrero extends Heroe {
    int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida, ArmaEspecial armaespecial, int fuerza) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.fuerza = fuerza;
    }

    public void atacar(){
        if (puntosVida>0){
            System.out.println("Puedes atacar");
           int dañoTotal=(fuerza*armaespecial.getDaño());
            System.out.println("El daño total que has hecho es: " +dañoTotal);
        }else{
            System.out.println("No puedes atacar ya que no tienes puntos de vida");
        }
    }

    @Override
    public String toString() {
        return "Guerrero{" +
                "fuerza=" + fuerza +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", armaespecial=" + armaespecial +
                ", arma=" + arma +
                '}';
    }
}
