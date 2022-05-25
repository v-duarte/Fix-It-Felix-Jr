package juego.niceland.ventanas;

import juego.felix.FelixJr;
import juego.felix.FelixJr.ProximaAccion;
import juego.niceland.ventanas.EstadoPanel.estadosVidrios;
import juego.niceland.ventanas.Obstaculo.Obstaculos;

/**
 * Representa una ventana con hojas que aparecen en las secciones media y superior del edificio.
 * Clase base: juego.niceland.ventanas.Ventana
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class VentanaConHojas extends Ventana {
	
	//Atributos
	
	/**
	 * Es la hoja de la ventana.
	 */
	private Hoja hoja;
	
	//Constructor
	
	/**
	 * Construye la ventana con sus atributos correspondientes,
	 */
	public VentanaConHojas() {
		super(2, tipoVentana.CON_HOJAS);
		Hoja h= new Hoja();
		this.hoja=h;
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve la hoja de la ventana.
	 */
	public Hoja getHoja(){
		return this.hoja;
	}

	@Override
	public boolean puedePasarHorizontal() {
		if(!this.getHoja().getEstadoHoja())
			return true;
		else{
			if(FelixJr.getProxima()==ProximaAccion.DERECHA)
				return true;
			else return false;
		}
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
		if(this.hoja.getEstadoHoja()){
			while((!tmp)&&(i<super.getVidrios().length)){
				if(super.getVidrios()[i].getEstado().getCondicion()!=estadosVidrios.SANO)
					tmp=true;
				i++;
			}
		}
		return tmp;
	}
	
}
