package juego.niceland.ventanas;

/**
 * Representa el estado de los vidrios de la ventana
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class EstadoPanel {
	
	//Atributos
	public enum estadosVidrios {SANO,MEDIOROTO,ROTO}
	
	/**
	 * Muestra el estado del vidrio. Posibles valores: Sano, MedioRoto o Roto.
	 */
	private estadosVidrios condicion;
	
	//Constructor
	
	/**
	 * Construye esta clase con la condicion "Sano".
	 */
	public EstadoPanel(){
		this.setCondicion(estadosVidrios.SANO);
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve la condicion del vidrio.
	 */
	public estadosVidrios getCondicion() {
		return condicion;
	}

	/**
	 * 
	 * @param condicion (Sera la condicion del vidrio.)
	 */
	public void setCondicion(estadosVidrios condicion) {
		this.condicion = condicion;
	}
	
	/**
	 * Cambia el estado del vidrio dependiendo de su estado al momento de invocar a este metodo.
	 */
	public void romper(){
		if(this.getCondicion()==estadosVidrios.SANO)
			this.setCondicion(estadosVidrios.MEDIOROTO);
		else
			if (this.getCondicion()==estadosVidrios.MEDIOROTO)
				this.setCondicion(estadosVidrios.ROTO);
	}
	
	public boolean arreglar(){
		if(this.getCondicion()==estadosVidrios.ROTO){
			this.setCondicion(estadosVidrios.MEDIOROTO);
			return true;
		}
		else
			if (this.getCondicion()==estadosVidrios.MEDIOROTO){
				this.setCondicion(estadosVidrios.SANO);
				return true;
			}
		return false;
	}
	
	

}
