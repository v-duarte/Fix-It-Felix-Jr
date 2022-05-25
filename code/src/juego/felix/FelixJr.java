package juego.felix;

import juego.ladrillo.Ladrillo;
import juego.mecanica.*;
import juego.niceland.secciones.*;
import juego.niceland.ventanas.*;
import juego.niceland.ventanas.Ventana.tipoVentana;
import juego.pajaro.Pajaro;
import juego.ralph.Ralph;

/**
 * Representa a Felix Jr.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class FelixJr implements Martillo, Direccion {
	
	//Atributos.
	
	public enum ProximaAccion {ARRIBA,ABAJO,DERECHA,IZQUIERDA,ARREGLAR}
	
	private static FelixJr felix;
	
	private static ProximaAccion proxima;
	
	
	/**
	 *  La cantidad de vidas que Felix posee.
	 */
	private static Vida vidas;
	
	/**
	 * El puntaje que tiene Felix. Usado durante la ejecucion.
	 */
	private static Puntaje puntajeActual;
	
	/**
	 * La posicion de Felix. Usado durante la ejecucion. 
	 */
	private static Posicion posicionActualFelix;
	
	/**
	 * En caso de comer un pastel durante el juego. El valor de esta variable representa el tiempo en el que
	 * Felix es inmune.
	 */
	private static int inmunidad;
	
	//Constructor
	
	/**
	 * Crea a Felix con valores con defecto.
	 */
	private FelixJr(){
		FelixJr.vidas=new Vida();
		FelixJr.puntajeActual=new Puntaje();
		FelixJr.posicionActualFelix=new Posicion();
		FelixJr.setInmunidad(0);
	}
	
	//Metodos
	
	public static FelixJr getFelix(){
		if(felix==null)
			felix=new FelixJr();
		return felix;
	}
	
	public void eliminar(){
		FelixJr.felix=null;
	}
	
	/**
	 * @see juego.felix.Martillo#arreglar(Seccion)
	 */
	@Override
	public void arreglar(Seccion seccionActual) {
		// TODO Auto-generated method stub
		int vidriosArreglados=0;
		int i=0;
		Ventana ventanaActual=seccionActual.getVentanaSeccion(FelixJr.posicionActualFelix.getY(), FelixJr.posicionActualFelix.getX());
		if(ventanaActual.debeArreglarse()){
			while ((i<ventanaActual.getVidrios().length)){
				if(ventanaActual.getVidrios()[i].getEstado().arreglar())
					vidriosArreglados++;
				i++;
				}
			}
		if(vidriosArreglados!=0)
			System.out.println("Felix arreglo una ventana.");
		FelixJr.puntajeActual.sumar((vidriosArreglados)*100);
	}
	
	public boolean mover(Seccion seccionActual){
		switch(proxima){
		case ARRIBA:
			return this.saltarArriba(seccionActual);
		case ABAJO:
			return this.saltarAbajo(seccionActual);
		case IZQUIERDA:
			return this.moverIzquierda(seccionActual);
		case DERECHA:
			return this.moverDerecha(seccionActual);
		case ARREGLAR:
			break;
		default:
			break;
		}
		return false;
	}
	
	/**
	 * @see juego.mecanica.Direccion#saltarArriba(Seccion)
	 */
	@Override
	public boolean saltarArriba(Seccion seccionActual) {
		try{
			proxima=ProximaAccion.ARRIBA;
			Ventana ventanaProxima= seccionActual.getVentanaSeccion(FelixJr.posicionActualFelix.getY()+1, FelixJr.posicionActualFelix.getX());
			if(ventanaProxima.puedePasarVertical()&&(FelixJr.getPosicionFelixJrY()+1!=Ralph.getPosicionRalphY())){
				FelixJr.posicionActualFelix.setY(FelixJr.posicionActualFelix.getY()+1);
				return true;
			}
			else
				return false;
		}
		catch(RuntimeException e){
			System.out.println("No puede saltar hacia arriba en este momento.");
			return false;
		}
			
	}
	
	
	/**
	 * @see juego.mecanica.Direccion#saltarAbajo(Seccion)
	 */
	@Override
	public boolean saltarAbajo(Seccion seccionActual) {
		try{
			proxima=ProximaAccion.ABAJO;
			Ventana ventanaActual= seccionActual.getVentanaSeccion(FelixJr.posicionActualFelix.getY(), FelixJr.posicionActualFelix.getX());
			if(ventanaActual.puedePasarVertical()&&(FelixJr.getPosicionFelixJrY()>0)){
				FelixJr.posicionActualFelix.setY(FelixJr.posicionActualFelix.getY()-1);
				return true;
			}
			else
				return false;
		}
		catch(RuntimeException e){
			System.out.println("No puede bajar mas.");
			return false;
		}
	}
	
	/**
	 * @see juego.mecanica.Direccion#moverIzquierda(Seccion)
	 */
	@Override
	public boolean moverIzquierda(Seccion seccionActual) {
		try{
			proxima=ProximaAccion.IZQUIERDA;
			Ventana ventanaProxima= seccionActual.getVentanaSeccion(FelixJr.posicionActualFelix.getY(), FelixJr.posicionActualFelix.getX()-1);
			if(ventanaProxima.puedePasarHorizontal()&&(FelixJr.getPosicionFelixJrX()>0)){
				FelixJr.posicionActualFelix.setX(FelixJr.posicionActualFelix.getX()-1);
				return true;
			}
			else
				return false;
		}
		catch(RuntimeException e){
			System.out.println("No puede ir mas hacia la izquierda.");
			return false;
		}
	}


	/**
	 * @see juego.mecanica.Direccion#moverDerecha(Seccion)
	 */
	@Override
	public boolean moverDerecha(Seccion seccionActual) {
		try{
			proxima=ProximaAccion.DERECHA;
			Ventana ventanaProxima= seccionActual.getVentanaSeccion(FelixJr.posicionActualFelix.getY(), FelixJr.posicionActualFelix.getX()+1);
			if(ventanaProxima.puedePasarHorizontal()&&(FelixJr.getPosicionFelixJrX()<4)){
				FelixJr.posicionActualFelix.setX(FelixJr.posicionActualFelix.getX()+1);
				return true;
			}
			else
				return false;
		}
		catch(RuntimeException e){
			System.out.println("No puede ir mas a la derecha.");
			return false;
		}
	}
	
	/**
	 * Determina si algun ladrillo llego a tocar a Felix. En caso de que sea asi, Felix
	 * pierde una vida.
	 * @param l (Si existe,un ladrillo)
	 */
	public boolean muerte(Ladrillo l){
		if(FelixJr.inmunidad==0){
				if((l.getPosicionLadrilloX()==FelixJr.posicionActualFelix.getX())&&(l.getPosicionLadrilloY()==FelixJr.posicionActualFelix.getY()))
						{
							System.out.println("¡Un ladrillo impacto a Felix!");
							FelixJr.vidas.quitarVida();
							this.getPosicionFelix().setX(0);
							this.getPosicionFelix().setY(0);
							System.out.println("Felix perdio una vida, le quedan"+" "+FelixJr.vidas.getCantidad()+" "+"vidas.");
							l=null;
							return true;
						}
				else return false;
			}
		return false;
	}
	
	/**
	 * Determina si algun pajaro (un ladrillo o un pajaro) llego a tocar a Felix. En caso de que sea asi, Felix
	 * pierde una vida.
	 * @param p ((Si existe,un pajaro))
	 */
	public boolean muerte (Pajaro p){
		if(FelixJr.inmunidad==0){
			if((p.getPosicionActual().getX()==FelixJr.posicionActualFelix.getX())&&(p.getPosicionActual().getY()==FelixJr.posicionActualFelix.getY()))
			{
				System.out.println("¡Un pajaro impacto a Felix!");
				FelixJr.vidas.quitarVida();
				this.getPosicionFelix().setX(0);
				this.getPosicionFelix().setY(0);
				System.out.println("Felix perdio una vida, le quedan"+" "+FelixJr.vidas.getCantidad()+" "+"vidas.");
				p=null;
				return true;
			}
			else return false;
		}
		return false;
	}
	
	/**
	 * 
	 * @return Devuelve las vidas que Felix posee en el momento de invocar a este metodo.
	 */
	public Vida getVidas(){
		return FelixJr.vidas;
	}
	
	/**
	 * 
	 * @return Devuelve el puntaja que Felix posee al momento de invocar a este metodo.
	 */
	public Puntaje getPuntaje(){
		return FelixJr.puntajeActual;
	}
	
	/**
	 * 
	 * @return Devuelve una clase Posicion que posee las cordenadas de Felix (En el eje x e y) al momento de
	 * 			invocar al metodo.
	 */
	public Posicion getPosicionFelix()
	{
		return FelixJr.posicionActualFelix;
	}
	
	/**
	 * 
	 * @return Devuelve la coordenada en el eje X de Felix al momento de invocar al metodo.
	 */
	public static int getPosicionFelixJrX(){
		return FelixJr.posicionActualFelix.getX();
	}
	
	/**
	 * 
	 * @return Devuelve la coordenada en el eje Y de Felix al momento de invocar al metodo.
	 */
	public static int getPosicionFelixJrY(){
		return FelixJr.posicionActualFelix.getY();
	}

	/**
	 * 
	 * @return Devuelve el tiempo que le resta de inmunidad a Felix al momento de invocar al metodo.
	 */
	public static int getInmunidad() {
		return inmunidad;
	}

	/**
	 * 
	 * @param inmunidad (Sera el tiempo que le queda a Felix de inmunidad.)
	 */
	public static void setInmunidad(int inmunidad) {
		FelixJr.inmunidad = inmunidad;
	}
	
	public static ProximaAccion getProxima() {
		return proxima;
	}

	@SuppressWarnings("static-access")
	public void setProxima(ProximaAccion proxima) {
		this.proxima = proxima;
	}

	/**
	 * En caso de que Felix "encuentre un pastel" durante su recorrido, este metodo hara que Felix "coma" el
	 * pastel y le "otorgara" inmunidad durante un tiempo limitado.
	 * @param seccionActual (Esto sera la seccion donde encontro el pastel.)
	 */
	public void comerPastel(Seccion seccionActual){
		VentanaComun ventanaActual;
		if(seccionActual.getVentanaSeccion(getPosicionFelixJrY(), getPosicionFelixJrX()).getTipoVentana()==tipoVentana.COMUN){
			ventanaActual=(VentanaComun) seccionActual.getVentanaSeccion(getPosicionFelixJrY(), getPosicionFelixJrX());
			FelixJr.setInmunidad(10);
			ventanaActual.setTienePastel(false);
			System.out.println("Felix comio un pastel.");
		}
	}
	
}