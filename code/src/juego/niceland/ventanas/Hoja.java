package juego.niceland.ventanas;

/**
 * Es la hoja de una ventana con hojas.
 * Clase base: juego.niceland.ventanas.EstadoHojas
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Hoja  {
	
	//Atributos
	
	private EstadoHojas estado;
	
	//Constructor
	
	/**
	 * Construye esta clase con sus hojas cerradas o abiertas determinada de forma aleatoria
	 */
	public Hoja(){
		estado=new EstadoHojas();
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve si las hojas se encuentran abiertas o no. Devuelve "true" si estan abiertas, "false" 
	 *			si se encuentran cerradas.
	 */
	public boolean getEstadoHoja(){
		if (estado.getSituacion()){
			System.out.println("Las hojas de la ventana se encuentran abiertas");
			return true;
		}
			
		else{
			System.out.println("Las hojas de la ventana se encuentran cerradas");
			return false;
		}
	}
	
	public void setEstadoHoja(boolean estado){
		this.estado.setSituacion(estado);
	}
}
