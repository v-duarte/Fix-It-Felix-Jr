package juego.mecanica;

/**
 * Representa a las vidas de Felix.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Vida {
	
	//Atributos
	
	/**
	 * Es la cantidad de vidas que tiene Felix.
	 */
	private int cantidad;
	
	//Constructor
	
	/**
	 * Crea la clase con sus valores por defecto.
	 */
	public Vida(){
		this.setCantidad(3);
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve la cantidad de vidas que Felix tiene en ese momento.
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * @see #agregarVida() y {@link #quitarVida()} para saber su uso
	 * @param cantidad (Sera la cantidad de vidas que Felix tendra.)
	 */
	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Agrega una vida a Felix.
	 */
	public void agregarVida(){
		this.setCantidad(this.getCantidad() + 1);
	}
	
	/**
	 * Quitara una vida a Felix.
	 */
	public void quitarVida(){
		this.setCantidad(this.getCantidad()-1);
	}
}
