package juego.niceland.ventanas;

import juego.niceland.ventanas.EstadoPanel.estadosVidrios;

/**
 * Representa la ventana semicircular que aparece en la seccion inferior del edificio.
 * Clase base: juego.niceland.ventanas.Ventana
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class VentanaSemicircular extends Ventana {
	
	//Atributos
	public enum tipoSemicircular {ENTRADA,PRIMER_PISO}
	private tipoSemicircular claseSemicircular;
		
	//Constructor
		
		/**
		 * Construye la ventana semicircular con sus atributos correspondientes.
		 */
		public VentanaSemicircular(tipoSemicircular clase){
			super(16,tipoVentana.SEMICIRCULAR);
			claseSemicircular=clase;
			if(super.getObstaculo()!=null)
				super.getObstaculo().setTipoObstaculo(null);
			
		}
	//Metodos

		public tipoSemicircular getClaseSemicircular() {
			return claseSemicircular;
		}

		public void setClaseSemicircular(tipoSemicircular claseSemicircular) {
			this.claseSemicircular = claseSemicircular;
		}

		@Override
		public boolean puedePasarHorizontal() {
			return true;
		}

		@Override
		public boolean puedePasarVertical() {
			return true;
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

