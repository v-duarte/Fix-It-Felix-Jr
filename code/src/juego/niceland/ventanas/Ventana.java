package juego.niceland.ventanas;

import java.util.Random;

import javax.swing.*;

import juego.niceland.ventanas.EstadoPanel.estadosVidrios;

/**
 * Representa a una ventana del edificio.
 * @author Victor Ariel Duarte Ocampo
 *
 */
public class Ventana {
	
	//Atributos
	
	public enum tipoVentana {COMUN,SEMICIRCULAR,CON_HOJAS}
	
	/**
	 * Son los vidrios de la ventana.
	 */
	private Panel[] vidrios;
	
	/**
	 * Muestra que tipo de ventana es.
	 */
	private tipoVentana tipoVentana;
	
	/**
	 * Nuestra si tiene un obstaculo o no.
	 */
	private Obstaculo tipoObstaculo;
	
	/**
	 * Clase random usado en algunos metodos
	 */
	private static Random rnd = new Random();
	
	//Constructor
	
	/**
	 * Construye la ventana con los valores de entrada y sus otros atributos correspondientes.
	 * @param cantidadVidrios (Es la cantidad de vidrios que tendra la ventana.)
	 * @param tipoVentana (Es el tipo de ventana que sera.)
	 */
	@SuppressWarnings("static-access")
	public Ventana(int cantidadVidrios, tipoVentana tipoVentana){
		
		this.vidrios=new Panel[cantidadVidrios];
		for (int i=0;i<cantidadVidrios;i++)
			this.vidrios[i]=new Panel();
		this.tipoVentana=tipoVentana;
		if (this.tipoVentana==(tipoVentana.SEMICIRCULAR)){
			tipoObstaculo=null;
		}
		else
		{
			Obstaculo obs;
			if(Ventana.getRandomBoolean())
				if (Ventana.getRandomBoolean()){
					obs= new Macetero();
				}
				else{
					obs=new Moldura();
				}
			else
				obs=null;
			tipoObstaculo=obs;
		}
			
	}

	//Metodos
	
	/**
	 * 
	 * @return Devuelve el tipo de ventana.
	 */
	public tipoVentana getTipoVentana() {
		return tipoVentana;
	}
	
	/**
	 * 
	 * @param tipoVentana determina el tipo de ventana que sera.
	 */
	public void setTipoVentana(tipoVentana tipoVentana) {
		this.tipoVentana = tipoVentana;
	}
	
	/**
	 * 
	 * @return Devuelve un boolean aleatorio.
	 */
	public static boolean getRandomBoolean() {
	       return rnd.nextBoolean();    
	   }
	
	/**
	 * 
	 * @return Devuelve un boolean que muestra si tiene un obstaculo o no. Devuelve "true" en caso que sea asi,
	 * 			"false" en caso contrario.
	 */
	public boolean hayObstaculo(){
		if (tipoObstaculo!=null)
			return true;
		else 
			return false;
	}
	
	/**
	 * 
	 * @return Devuelve el obstaculo si lo tiene, null en caso contrario.
	 */
	public Obstaculo getObstaculo(){
		if(this.tipoObstaculo!=null)
			return this.tipoObstaculo;
		else
			return null;
	}
	
	public void setObstaculo(Obstaculo o){
		tipoObstaculo=o;
	}
	
	/**
	 * 
	 * @return Devuelve los vidrios de la ventana.
	 */
	public Panel[] getVidrios(){
		return vidrios;
	}
	
	public boolean puedePasarHorizontal(){
		return false;
	}
	
	public boolean puedePasarVertical(){
		return false;
	}
	
	public boolean debeArreglarse(){
		return false;
	}
	
	public ImageIcon getImagenVentana(){
		return null;
	}
	
	public estadosVidrios getEstadoGeneral() {
		estadosVidrios e=estadosVidrios.SANO;
		if(!this.debeArreglarse())
			return e;
		else{
			for(int i=0;i<this.getVidrios().length;i++){
				if(e!=estadosVidrios.ROTO)
					e=this.getVidrios()[i].getEstado().getCondicion();
			}
			return e;
		}
	}

}
