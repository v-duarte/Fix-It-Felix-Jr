package juego.niceland.ventanas;

/**
 * Representa la moldura de algunas ventanas.
 * Clase base: juego.niceland.ventanas.Obstaculo
 * @author Victor Ariel Duarte Ocampo
 * 
 */
public class Moldura extends Obstaculo {
	
	//Constructor
	
	/**
	 * Construye la moldura con sus atributos correspondientes.
	 */
	public Moldura(){
		super(Obstaculos.MOLDURA);
	}

	//Metodos
	
	/**
	 * @see juego.niceland.ventanas.Obstaculo#getTipoObstaculo()
	 */
	@Override
	public Obstaculos getTipoObstaculo() {
		return super.getTipoObstaculo();
	}
}
