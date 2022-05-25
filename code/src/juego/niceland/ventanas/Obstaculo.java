package juego.niceland.ventanas;

/**
 * Representa a un obstaculo que poseen algunas ventanas.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Obstaculo {
	
	
	//Atributos
	public enum Obstaculos {MACETERO,MOLDURA}
	/**
	 * Muestra que tipo de obstaculo es.
	 */
	private Obstaculos tipoObstaculo;
	
	//Constructor
	
	/**
	 * 
	 * @param tipoObstaculo Es el tipo de obstaculo que sera.
	 */
	public Obstaculo(Obstaculos tipoObstaculo){
		this.tipoObstaculo=tipoObstaculo;
	}
	
	//Metodos
	
	/**
	 * 
	 * @return el tipo de obstaculo que es
	 */
	public Obstaculos getTipoObstaculo() {
		return tipoObstaculo;
	}
	
	/**
	 * 
	 * @param tipoObstaculo (el tipo de obstaculo que sera.)
	 */
	public void setTipoObstaculo(Obstaculos tipoObstaculo) {
		this.tipoObstaculo = tipoObstaculo;
	}

}
