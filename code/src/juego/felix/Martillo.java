package juego.felix;

import juego.niceland.secciones.Seccion;

/**
 * Representa al martillo que tiene Felix.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public interface Martillo {
	/**
	 * Este metodo se encarga de arreglar una ventana que se encuentra rota.
	 * @param seccionActual (Seccion donde se encuentra Felix en ese momento.)
	 * @see juego.felix.FelixJr (Para implementacion.)
	 */
	public void arreglar(Seccion seccionActual);

}
