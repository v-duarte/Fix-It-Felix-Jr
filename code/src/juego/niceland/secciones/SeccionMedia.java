package juego.niceland.secciones;

import java.util.Random;

import juego.niceland.ventanas.*;

/**
 * 
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class SeccionMedia extends Seccion {
	
	//Atributos
	
	private boolean limiteObstaculos=true;
	/**
	 * Clase Random que se usa en la creacion de la seccion
	 */
	private static Random rnd = new Random();
	
	//Constructor
	
	/**
	 * Constructor con los atributos que corresponden.
	 */
	public SeccionMedia() {
		super(TipoSeccion.MEDIA);
		for (int f=0;f<3;f++)
		{
			int limiteVentanasCerradas=2;
			for (int c=0; c<5;c++)
			{
				Ventana ventana;
				if (SeccionMedia.getRandomBoolean()){ //Con esto se creara una ventana comun si el resultado es "false", o una con hojas en caso de que devuelva "true"
					ventana= new VentanaConHojas();
					VentanaConHojas ventanat=(VentanaConHojas) ventana;
					if(ventanat.getHoja().getEstadoHoja()&&(limiteVentanasCerradas>0)){
						ventanat.getHoja().setEstadoHoja(false);
						limiteVentanasCerradas--;
					}
				}
				else
					ventana= new VentanaComun();
				super.setVentanaSeccion(ventana, f, c);
				if(limiteObstaculos&&ventana.hayObstaculo()){
					super.getVentanaSeccion(f, c).setObstaculo(null);
					limiteObstaculos=false;
				}
			}
			limiteObstaculos=true;	
		}
	}
	
	//Metodos
	
	/**
	 * 
	 * @return Devuelve un valor boolean aleatorio.
	 */
	public static boolean getRandomBoolean() {
	       return rnd.nextBoolean();    
	   }
}
