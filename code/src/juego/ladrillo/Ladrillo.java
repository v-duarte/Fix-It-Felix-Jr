package juego.ladrillo;

import juego.mecanica.Posicion;
import juego.ralph.Ralph;

/**
 * Representa al ladrillo que aparece cuando Ralph golpea al edificio.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Ladrillo {
	
	//Atributos
	
	/**
	 * La posicion del ladrillo.
	 */
	private Posicion posicionLadrillo;
	
	//Constructor
	
	/**
	 * Crea un ladrillo con la posicion actual de Ralph al momento de crearse el ladrillo.
	 */
	public Ladrillo(){
		this.posicionLadrillo=new Posicion();
		this.posicionLadrillo.setX(Ralph.getPosicionRalphX());
		this.posicionLadrillo.setY(Ralph.getPosicionRalphY());
	}

	/**
	 * 
	 * @return Devuelve la posicion del ladrillo en el eje X.  
	 */
	public int getPosicionLadrilloX() {
		return posicionLadrillo.getX();
	}

	/**
	 * 
	 * @param posicionLadrilloX (Sera la coordenada en el eje X del ladrillo.)
	 */
	public void setPosicionLadrilloX(int posicionLadrilloX) {
		this.posicionLadrillo.setX(posicionLadrilloX); 
	}
	
	/**
	 * 
	 * @return Devuelve la posicion del ladrillo en el eje Y.
	 */
	public int getPosicionLadrilloY() {
		return posicionLadrillo.getY();
	}

	/**
	 * 
	 * @param posicionLadrilloY (Sera la coordenada en el eje Y del ladrillo.)
	 */
	public void setPosicionLadrilloY(int posicionLadrilloY) {
		this.posicionLadrillo.setY(posicionLadrilloY); 
	}
}
