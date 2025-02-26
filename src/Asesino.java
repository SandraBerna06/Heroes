import java.util.ArrayList;

public class Asesino extends Heroe{
    int sigilo;

    public Asesino(String nombre, int nivel, int puntosVida, ArmaEspecial armaespecial, int sigilo) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.sigilo = sigilo;
    }

    public void asesinar(){
        if(puntosVida>0){
            System.out.println("Anda con sigilo en las sombras...");
            if (armaespecial != null) { // Verificar si el arma está asignada
                int dañoTotal = sigilo * armaespecial.getDaño();
                System.out.println("El daño producido es: " + dañoTotal);
            } else {
                System.out.println("No tienes un arma especial equipada para atacar.");
            }
        }else{
            System.out.println("No puedes andar con sigilo ya que no tienes vida");
        }
    }

    @Override
    public String toString() {
        return "Asesino{" +
                "arma=" + arma +
                ", armaespecial=" + armaespecial +
                ", puntosVida=" + puntosVida +
                ", nivel=" + nivel +
                ", nombre='" + nombre + '\'' +
                ", sigilo=" + sigilo +
                '}';
    }
}
