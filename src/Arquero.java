import java.util.ArrayList;

public class Arquero extends Heroe{
    int precision;

    public Arquero(String nombre, int nivel, int puntosVida, ArmaEspecial armaespecial, int precision) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.precision = precision;
    }

    public void disparar(){
        if(puntosVida>0){
            System.out.println("Dispara con el arco");
            int dañoTotal=(precision*armaespecial.getDaño());
            System.out.println("El daño producido es: " +dañoTotal);
        }else{
            System.out.println("No puedes disparar con el arco ya que no tienes vida");
        }
    }

    @Override
    public String toString() {
        return "Arquero{" +
                "precision=" + precision +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", armaespecial=" + armaespecial +
                ", arma=" + arma +
                '}';
    }
}
