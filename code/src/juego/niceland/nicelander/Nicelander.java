package juego.niceland.nicelander;

/**
 * Representa a un Nicelander.
 * @author Victor Ariel Duarte Ocampo
 *
 */

public interface Nicelander {

	/**
	 * 
	 * @return Devuelve un boolean dependiendo si hay pastel o no. Devuelve "true" en caso de que sea asi,
	 * 			"false" en caso contrario.
	 * @see juego.niceland.ventanas.VentanaComun (Para implementacion.)
	 */
	public boolean isTienePastel();

	/**
	 * 
	 * @param tienePastel (Sera el valor booleano que determinara si la ventana tiene o no un pastel)
	 * @see juego.niceland.ventanas.VentanaComun (Para implementacion.)
	 */
	public void setTienePastel(boolean tienePastel);
}
