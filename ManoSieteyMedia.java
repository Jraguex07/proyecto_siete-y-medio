/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raguex
 */
public class  ManoSieteyMedia extends Mano {
    
    public double cuentaPuntos() {
  double puntos = 0;
  for(int i = 0; i<numCartas; i++) {
   puntos += cartas[i].valor();
  }
  return puntos;
 }
}
    
 
