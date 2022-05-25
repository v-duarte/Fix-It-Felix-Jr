package juego.mecanica;

import juego.niceland.secciones.Seccion;

/**
 * Puede que el nombre preste a confusion. Para aclarar, esta interface contiene la declaracion de los
 * movimientos que pueden realizar los personajes.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public interface Direccion {
	
	//Metodos
	
	/**
	 * 
	 * @param seccionActual (Seccion del edificio donde se encuentra el personaje actualmente.)
	 * @return Devuelve un boolean que permite saber si el personaje pudo saltar hacia arriba o no. 
	 * 			Devuelve "true" si pudo hacerlo, false en caso contrario.
	 * @see juego.felix.FelixJr (Para implementacion.)
	 */
	public boolean saltarArriba(Seccion seccionActual);
	
	/**
	 * 
	 * @param seccionActual (Seccion del edificio donde se encuentra el personaje actualmente.)
	 * @return Devuelve un boolean que permite saber si el personaje pudo saltar hacia abajo o no. 
	 * 			Devuelve "true" si pudo hacerlo, false en caso contrario.
	 * @see juego.felix.FelixJr (Para implementacion.)
	 */
	public boolean saltarAbajo(Seccion seccionActual);
	
	/**
	 * 
	 * @param seccionActual (Seccion del edificio donde se encuentra el personaje actualmente.)
	 * @return Devuelve un boolean que permite saber si el personaje pudo desplazarse hacia la izquierda o no. 
	 * 			Devuelve "true" si pudo hacerlo, "false" en caso contrario.
	 * @see juego.felix.FelixJr (Para implementacion.)
	 * @see juego.ralph.Ralph (Para implementacion.)
	 */
	public boolean moverIzquierda(Seccion seccionActual);
	
	/**
	 * 
	 * @param seccionActual (Seccion del edificio donde se encuentra el personaje actualmente.)
	 * @return Devuelve un boolean que permite saber si el personaje pudo desplazarse hacia la derecha o no. 
	 * 			Devuelve "true" si pudo hacerlo, "false" en caso contrario.
	 * @see juego.felix.FelixJr (Para implementacion.)
	 * @see juego.ralph.Ralph (Para implementacion.)
	 */
	public boolean moverDerecha(Seccion seccionActual);
}
