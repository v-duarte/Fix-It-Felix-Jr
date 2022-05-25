package juego.niceland.ventanas;

/**
 * Representa el macetero de algunas ventanas.
 * Clase base: juego.niceland.ventanas.Obstaculo
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Macetero extends Obstaculo {
	
	//Constructor
	
	/**
	 * Construye el macetero con sus atributos correspondiente.
	 */
	public Macetero(){
		super(Obstaculos.MACETERO);
	}
	
	/**
	 * @see juego.niceland.ventanas.Obstaculo#getTipoObstaculo()
	 */
	@Override
	public Obstaculos getTipoObstaculo() {
		return super.getTipoObstaculo();
	}
	

}
