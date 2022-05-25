package juego.niceland.ventanas;

import java.util.Random;

/**
 * Representa la situacion de las hojas de una ventana con hojas.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class EstadoHojas {
	
	//Atributos
	
	/**
	 * Determina si las hojas estan abiertas o no. "True" si lo estan, "false" en caso contrario.
	 */
	private boolean situacion; 
	
	/**
	 * Clase random usado en el constructor
	 */
	private static Random rnd = new Random();

	//Constructor
	
	/**
	 * Contruye esta clase, determinando si las hojas estaran abiertas o no de forma aleatoria.
	 */
	public EstadoHojas(){
		this.situacion=EstadoHojas.getRandomBoolean();
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve la situacion de las hojas en el momento en el que se invoco.
	 */
	public boolean getSituacion()
	{
		return this.situacion;
	}
	
	public void setSituacion(boolean situacion){
		this.situacion=situacion;
	}
	
	/**
	 * 
	 * @return Devuelve un valor boolean aleatorio.
	 */
	public static boolean getRandomBoolean() {
	       return rnd.nextBoolean();    
	   }
}
