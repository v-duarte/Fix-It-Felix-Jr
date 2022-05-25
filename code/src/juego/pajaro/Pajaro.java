package juego.pajaro;

import java.util.Random;
import juego.mecanica.Posicion;

/**
 * Representa a un pajaro que aparece en las secciones media y superior del edificio.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Pajaro {
	
	//Atributos
	
	/**
	 * Es la posicion original en el eje X del pajaro. Sirve para determinar su comportamiento.
	 */
	private int posicionInicialX;
	/**
	 * Es la posicion del pajaro.
	 */
	private Posicion posicionActualPajaro;
	/**
	 * Clase random usado en la creacion de un pajarp.
	 */
	private static Random rnd = new Random();
	
	//Constructor
	
	/**
	 * Construye un pajaro que comenzara su recorrido desde la izquierda o derecha del edificio, a traves de una
	 * variable aleatoria.
	 */
	public Pajaro(){
		this.posicionActualPajaro=new Posicion();
		if(rnd.nextBoolean()){
			this.posicionInicialX=0;
			int y=rnd.nextInt(3);
			this.posicionActualPajaro.setX(0);
			this.posicionActualPajaro.setY(y);
		}
		else{
			this.posicionInicialX=4;
			int y=rnd.nextInt(3);;
			this.posicionActualPajaro.setX(4);
			this.posicionActualPajaro.setY(y);
		}
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve un valor boolean aleatorio.
	 */
	public static boolean getRandomBoolean() {
	       return rnd.nextBoolean();    
	   }
	
	/**
	 * 
	 * @return Devuelve un objeto Posicion que muestra la posicion del pajaro al momento de invocar al metodo.
	 */
	public Posicion getPosicionActual(){
		return this.posicionActualPajaro;
	}

	public int getPosicionInicialX() {
		return posicionInicialX;
	}

	public void setPosicionInicialX(int posicionInicialX) {
		this.posicionInicialX = posicionInicialX;
	}
}
