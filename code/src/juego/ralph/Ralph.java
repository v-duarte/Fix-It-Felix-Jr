package juego.ralph;

import javax.swing.ImageIcon;

import juego.ladrillo.Ladrillo;
import juego.mecanica.*;
import juego.niceland.secciones.Seccion;
import juego.felix.*;
import juego.graficos.CargaImagenes;

/**
 * Representa a Ralph
 * @author Victor Ariel Duarte Ocampo
 *
 */
public final class Ralph implements Direccion {
	
	//Atributos
	
	public enum ProximaAccion {DERECHA,IZQUIERDA,ROMPER}
	
	/**
	 * Es la posicion de Ralph.
	 */
	private static Posicion posicionActualRalph;
	private static ProximaAccion proxAccion;
	private static Ralph ralph;
	
	//Constructor
	/**
	 * Construye a Ralph con sus atributos con valores por defecto.
	 */
	private Ralph(){
		Ralph.posicionActualRalph=new Posicion();
	}
	
	//Metodos
	
	public static Ralph getRalph(){
		if(ralph==null)
			ralph=new Ralph();
		return ralph;
	}
	
	public void eliminar(){
		Ralph.ralph=null;
	}
	
	/**
	 * 
	 * @return Devuelve un objeto posicion que tiene las corrdenadas en el eje X e Y de Ralph. 
	 */
	public Posicion getPosicionRalph(){
		return Ralph.posicionActualRalph;
	}
	
	/**
	 * 
	 * @return Devuelve la posicion de Ralph en el eje X.
	 */
	public static int getPosicionRalphX(){
		return Ralph.posicionActualRalph.getX();
	}
	
	/**
	 * 
	 * @return Devuelve la posicion de Ralph en el eje Y.
	 */
	public static int getPosicionRalphY(){
		return Ralph.posicionActualRalph.getY();
	}
	
	/**
	 * @see juego.mecanica.Direccion#saltarArriba(Seccion)
	 * @deprecated
	 */
	@Override
	public boolean saltarArriba(Seccion seccionActual) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @see juego.mecanica.Direccion#saltarAbajo(Seccion)
	 * @deprecated
	 */
	@Override
	public boolean saltarAbajo(Seccion seccionActual) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @see juego.mecanica.Direccion#moverIzquierda(Seccion)
	 */
	@Override
	public boolean moverIzquierda(Seccion seccionActual) {
		// TODO Auto-generated method stub
		if(Ralph.posicionActualRalph.getX()>=1){
			Ralph.posicionActualRalph.setX(getPosicionRalphX()-1);
		}
		return true;
	}
	
	/**
	 * @see juego.mecanica.Direccion#moverDerecha(Seccion)
	 */
	@Override
	public boolean moverDerecha(Seccion seccionActual) {
		// TODO Auto-generated method stub
		if(Ralph.posicionActualRalph.getX()<4){
			Ralph.posicionActualRalph.setX(getPosicionRalphX()+1);
		}
		return true;
	}
	
	public boolean mover(Seccion seccionActual){
		switch(proxAccion){
		case DERECHA:
			return this.moverDerecha(seccionActual);
		case IZQUIERDA:
			return this.moverIzquierda(seccionActual);
		case ROMPER:
			return false;
		default:
			return false;
		}
	}
	
	/**
	 * 
	 * @return Devuelve el ladrillo que aparece cuando Ralph golpea el edificio.
	 */
	public Ladrillo romper(){
		
		Ralph.posicionActualRalph.setX(FelixJr.getPosicionFelixJrX());
		Ladrillo L=new Ladrillo();
		return L;
	}
	
	public ImageIcon getImagen(){
		ImageIcon i;
		i= new CargaImagenes("../../images/ralph/slice146_@.png").getImg();
		return i;
	}
	
}
