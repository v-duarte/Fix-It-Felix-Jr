package juego.mecanica;

/**
 * 
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Puntaje {
	
	//Atributos
	
	/**
	 * Representa al puntaje.
	 */
	private int puntajeActual;
	
	//Constructor
	
	/**
	 * Crea a una clase puntaje con su valor por defecto.
	 */
	public Puntaje(){
		this.setPuntajeActual(0);
	}

	/**
	 * 
	 * @return Devuelve el valor de la variable puntajeActual
	 */
	public int getPuntajeActual() {
		return puntajeActual;
	}

	/**
	 * 
	 * @param puntajeActual (Sera el valor del puntaje.)
	 */
	void setPuntajeActual(int puntajeActual) {
		this.puntajeActual = puntajeActual;
	}
	
	/**
	 * 
	 * @param p (Suma al puntaje del momento en el que se invoco el valor de p.)
	 */
	public void sumar(int p) {
		this.setPuntajeActual(this.getPuntajeActual()+p);
	}
	
	/**
	 * @deprecated Se remplazo por {@link #getPuntajeActual()}
	 * @return Devuelve el puntaje actual al momento de invocacion. 
	 */
	public int mostrar(){
		return this.getPuntajeActual();
	}
}


