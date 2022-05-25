package juego.niceland.ventanas;

import juego.felix.FelixJr;
import juego.felix.FelixJr.ProximaAccion;
import juego.niceland.nicelander.Nicelander;
import juego.niceland.ventanas.EstadoPanel.estadosVidrios;
import juego.niceland.ventanas.Obstaculo.Obstaculos;

/**
 * Representa una ventana comun del edificio.
 * Clase base: juego.niceland.ventanas.Ventana
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class VentanaComun extends Ventana implements Nicelander {
	
	//Atributos
	

	/**
	 * Muestra si tiene un pastel o no.
	 */
	private boolean tienePastel;
	
	
	//Constructor
	
	/**
	 * Construye una ventana comun con sus atributos correspondientes.
	 */
	public VentanaComun(){
		super(2, tipoVentana.COMUN);
		this.setTienePastel(false);
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve un boolean dependiendo si hay pastel o no. Devuelve "true" en caso de que sea asi,
	 * 			"false" en caso contrario.
	 * @see juego.niceland.nicelander.Nicelander#isTienePastel()
	 */
	public boolean isTienePastel() {
		return tienePastel;
	}
	
	/**
	 * 
	 * @param tienePastel (Sera el valor booleano que determinara si la ventana tiene o no un pastel)
	 * @see juego.niceland.nicelander.Nicelander#setTienePastel(boolean)
	 */
	public void setTienePastel(boolean tienePastel) {
		this.tienePastel = tienePastel;
	}

	@Override
	public boolean puedePasarHorizontal() {
		return true;
	}

	@Override
	public boolean puedePasarVertical() {
		if(!this.hayObstaculo())
			return true;
		else{
			if(FelixJr.getProxima()==ProximaAccion.ABAJO){
					if(this.getObstaculo().getTipoObstaculo()==Obstaculos.MACETERO)
						return false;
					else
						return true;
			}
			else{
					if(this.getObstaculo().getTipoObstaculo()==Obstaculos.MOLDURA)
						return false;
					else
						return true;
			}
		}	
	}

	@Override
	public boolean debeArreglarse() {
		boolean tmp=false;
		int i=0;
		while((!tmp)&&(i<super.getVidrios().length)){
			if(super.getVidrios()[i].getEstado().getCondicion()!=estadosVidrios.SANO)
				tmp=true;
			i++;
		}
		return tmp;
	}
}