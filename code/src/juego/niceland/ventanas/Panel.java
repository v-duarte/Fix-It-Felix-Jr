package juego.niceland.ventanas;

/**
 * Representa el vidrio o panel de la ventana.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Panel {
	
	//Atributos
	
	
	/**
	 * Muestra el estado del vidrio.
	 */
	private EstadoPanel estado;
	
	//Constructor
	
	/**
	 * Construye el panel con sus atributos correspondientes.
	 */
	public Panel(){
		this.estado=new EstadoPanel();
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve el estado del panel al momento de invocar al metodo.
	 */
	public EstadoPanel getEstado(){
		return estado;
	}

}
