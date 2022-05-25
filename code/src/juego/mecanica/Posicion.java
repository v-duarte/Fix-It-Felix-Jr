package juego.mecanica;

/**
 * Representa a la posicion. Usada por los personajes.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Posicion {
	
	//Atributos
	
	/**
	 * Es la coordenada en el eje X.
	 */
	private int x;
	
	/**
	 * Es la coordenada en el eje Y.
	 */
	private int y;
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve la coordenada en X.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @param x (Sera la coordenada en el eje X.)
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return Devuelve la coordenada en Y.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * 
	 * @param y (Sera la coordenada en el eje Y.)
	 */
	public void setY(int y) {
		this.y = y;
	}
}
