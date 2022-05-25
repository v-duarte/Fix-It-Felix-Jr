package juego.niceland.secciones;


import juego.niceland.ventanas.*;

/**
 * Representa a una seccion del edificio Niceland.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Seccion {
	
	//Atributos
	
	public enum TipoSeccion {INFERIOR,MEDIA,SUPERIOR}
	
	/**
	 * Es el tipo de seccion que es (puede ser Seccion Inferior, Seccion Media o Seccion Inferior).
	 */
	private TipoSeccion TipoSeccion;
	/**
	 * Esta matriz son las ventanas que tiene la seccion.
	 */
	private Ventana[][] ventanas;
	
	//Constructor
	
	/**
	 * Crea una clase seccion, con el tipo de seccion que sera y sus ventanas con sus valores por defecto.
	 * @param TipoSeccion (Determinara el tipo de seccion que sera.)
	 */
	public Seccion(TipoSeccion TipoSeccion){
		this.TipoSeccion=TipoSeccion;
		ventanas=new Ventana[3][5];
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve el tipo de seccion de la seccion que invoco este metodo.
	 */
	public TipoSeccion getTipoSeccion() {
		return TipoSeccion;
	}
	
	/**
	 * 
	 * @param TipoSeccion (Este determinara el tipo de seccion.)
	 */
	public void setTipoSeccion(TipoSeccion TipoSeccion) {
		this.TipoSeccion = TipoSeccion;
	}
	
	/**
	 * 
	 * @param f Es la coordenada en el eje Y(Fila)
	 * @param c Es la coordenada en el eje X(Columna)
	 * @return Devuelve la ventana de la seccion en la fila(eje Y) f y en la columna (eje X) c
	 */
	public Ventana getVentanaSeccion(int f, int c) {
		return ventanas[f][c];
	}

	/**
	 *  
	 * @param ventana (Sera la ventana que ira en la seccion en las coordenadas f(ejeY) y c(Eje X)
	 * @param f (Coordenada en el Eje Y)
	 * @param c (Coordenada en el Eje X)
	 */
	public void setVentanaSeccion(Ventana ventana, int f, int c) {
		this.ventanas[f][c] = ventana;
	}
}
