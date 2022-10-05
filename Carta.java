/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raguex
 */
public class Carta {
    public static enum Palo { PICA, TREBOL, DIAMANTE, CORAZON};
 private static String[] nombreCarta = {"AS", "2", "3", "4",
                                               "5", "6", "7", "8",
                                               "9", "10", "J", "Q",
                                               "K"};
 
 private int valor;
 private Palo palo;
 
 public Carta(int v, Palo p){
  valor = v;
  palo = p;
 }
 public int valor() {return valor;}
 public Palo palo() {return palo;}
 public String toString() {
  return nombreCarta[valor-1] + " de " + palo;
 }
 
}
Vamos ahora con la clase Mazo ;)
import java.util.Random;
public class Mazo {
 private static Random alea = new Random();
 private Carta[] mazo;
 private int numCartas;
 
 public Mazo() {
  mazo = new Carta[52]; //Creo el array de cartas.
  for(int n = 1; n < 13; n++) {
   for(Carta.Palo p: Carta.Palo.values()) {
    mazo[numCartas] = new Carta(n, p);
    numCartas++;
   }
  }
 }

 public void baraja() {
  for(int i = 0; i< numCartas; i++) {
   int r = alea.nextInt(numCartas);
   Carta c = mazo[i];
   mazo[i] = mazo[r];
   mazo[r] = c;
  }
 }

 public int numeroDeCartas() {
  return numCartas;
 }
 
 public Carta daCarta(){ 
  if (this.numeroDeCartas()==0) 
                   throw new RuntimeException("No quedan cartas.");
  numCartas--;
  return mazo[this.numeroDeCartas()];
 }
}

Y ya por último con la clase ManoSieteYMedia:
public class ManoSieteyMedia extends Mano{
 public double cuentaPuntos() {
  double puntos = 0;
  for(int i = 0; i<numCartas; i++) {
   puntos += cartas[i].valor();
  }
  return puntos;
 }

}
