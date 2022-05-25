package juego.niceland.secciones;


import java.util.Random;

import juego.niceland.ventanas.*;
import juego.niceland.ventanas.VentanaSemicircular.tipoSemicircular;

/**
 * Representa a la seccion inferior del edificio.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class SeccionInferior extends Seccion {
	
	private boolean limiteObstaculos=true;
	private static Random rnd = new Random();

	//Constructor
	
	/**
	 * Construye la seccion interior con los atributos que corresponden.
	 */
	public SeccionInferior() {
		super(TipoSeccion.INFERIOR);
		VentanaSemicircular ventanaprincipal= new VentanaSemicircular(tipoSemicircular.ENTRADA);
		super.setVentanaSeccion(ventanaprincipal, 0, 2);
		VentanaSemicircular primerPiso= new VentanaSemicircular(tipoSemicircular.PRIMER_PISO);
		super.setVentanaSeccion(primerPiso, 1, 2);
		for (int f=0;f<3;f++)
		{
			for (int c=0; c<5;c++)
			{
				VentanaComun ventana= new VentanaComun();
				if (super.getVentanaSeccion(f, c)==null)
					super.setVentanaSeccion(ventana, f, c);
				if(limiteObstaculos&&ventana.hayObstaculo()){
					super.getVentanaSeccion(f, c).setObstaculo(null);
					limiteObstaculos=false;
				}
			}
			limiteObstaculos=true;
		}
	}
	
	/**
	 * 
	 * @return Devuelve un valor boolean aleatorio.
	 */
	public static boolean getRandomBoolean() {
	       return rnd.nextBoolean();    
	   }
}
