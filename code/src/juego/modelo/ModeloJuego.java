package juego.modelo;

import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import juego.felix.FelixJr;
import juego.ladrillo.Ladrillo;
import juego.mecanica.Record;
import juego.niceland.secciones.*;
import juego.niceland.secciones.Seccion.TipoSeccion;
import juego.niceland.ventanas.*;
import juego.niceland.ventanas.EstadoPanel.estadosVidrios;
import juego.niceland.ventanas.Ventana.tipoVentana;
import juego.pajaro.Pajaro;
import juego.ralph.Ralph;

/**
 *Clase Juego
 *
 *Esta clase se encarga de ejecutar el juego.
 *
 * @author Victor Ariel Duarte Ocampo.
 *
 */

@SuppressWarnings("unused")
public class ModeloJuego {
	
	//Atributos
	
	/**
	 * Esta variable boolean determinara si el juego seguira ejecutandose o no.  
	 */
	private boolean condicionJuego;
	
	/**
	 * Esta variable es el tiempo que tardara Ralph en golpear el edificio. Este valor solo se modifica
	 * cuando se pasa de nivel, reduciendo por 1. 
	 */
	private int tiempoInicial=10;
	
	/**
	 * Es el tiempo que falta hasta que Ralph golpee el edificio. Pensarlo como un temporizador. El valor 
	 * inicial de esta variable depende del tiempoInicial y se modifica durante todo el transcurso del
	 * juego.
	 */
	private int tiempo;
	
	/**
	 * Tiempo limite del juego. Si este tiempo llega a 0 y no se arreglaron todas las ventanas, es un
	 * Game Over.
	 */
	private int tiempoFinalJuegoInicial=120;
	
	/**
	 * Tiempo limite del juego. Si este tiempo llega a 0 y no se arreglaron todas las ventanas, es un
	 * Game Over. Depende de tiempoFinalJuegoInicial.
	 */
	private int tiempoFinalJuego=120;
	
	
	/**
	 * Si este tiempo es 0, entonces aparecera un pajaro. Depende de tiempoAparicionPajaroInicial.
	 * 
	 */
	private int tiempoAparicionPajaro=30;
	
	
	/**
	 * Tiempo que tardara en que un Nicelander deje un Pastel.
	 */
	private int tiempoPastel=20;
	
	/**
	 * Nivel en el que se encuentra el juego actualmente. El juego comienza en el nivel 1 
	 * y termina en el nivel 10.
	 */
	private int nivel=0;
	
	/**
	 * determina en que parte de Niceland (Seccion Inferior, Seccion Media o Seccion Superior)
	 * 	se encuentran Felix y Ralph actualmente en el juego).
	 */
	private Seccion seccionActual;
	
	/**
	 * Su uso es para algunos metodos del juego. Devuelve un valor aleatorio. El valor que devuelve
	 *  depende del metodo a usar.
	 */
	
	private Ladrillo ladrillo=null;
	
	private Pajaro pajaro=null;
	
	private static  Random rnd = new Random();
	
	private static ModeloJuego miModelo;
	
	
	//Metodos
	
	
	/**
	 * 
	 * @return Devuelve un valor boolean aleatorio.
	 */
	public static boolean getRandomBoolean() {
	       return rnd.nextBoolean();    
	   }
	
	private ModeloJuego(){
		if(seccionActual==null)
			this.seccionActual=new SeccionInferior();
		this.prepararSeccion();
	}
	
	private ModeloJuego(int nivel){
		this.nivel=nivel;
		if(seccionActual==null)
			this.seccionActual=new SeccionInferior();
		this.prepararSeccion();
	}
	
	
	public static ModeloJuego getModelo(){
		if(miModelo==null)
			miModelo=new ModeloJuego();
		return miModelo;
	}
	
	public static ModeloJuego getModelo(int nivel){
		if(miModelo==null)
			miModelo=new ModeloJuego(nivel);
		return miModelo;
	}
	
	
	private void prepararSeccion(){
		Panel[] paneltemp;
		VentanaConHojas ventanaTemp;
		for(int n=0;n<2;n++){
			for(int f=0;f<3;f++){
				for (int c=0;c<5;c++)
				{
					if(this.seccionActual.getVentanaSeccion(f, c).getTipoVentana()!=tipoVentana.CON_HOJAS){
						if(getRandomBoolean()){
							paneltemp=this.seccionActual.getVentanaSeccion(f, c).getVidrios();
							for (int i=0;i<paneltemp.length;i++)
								paneltemp[i].getEstado().romper();
						}
					}
						else{
							ventanaTemp=(VentanaConHojas) this.seccionActual.getVentanaSeccion(f, c);
							if(ventanaTemp.getHoja().getEstadoHoja())
							{
								if(getRandomBoolean()){
									paneltemp=this.seccionActual.getVentanaSeccion(f, c).getVidrios();
									for (int i=0;i<paneltemp.length;i++)
										paneltemp[i].getEstado().romper();
								}
							}
						}
				}
			}
		}
	}
		
	/**
	 *  Determina el comportamiento de Ralph durante el transcurso del juego.
	 * @param ralph Representa a Ralph.
	 * @return Si la variable tiempo es 0, Ralph comienza a golpear el edificio lo cual hace que un ladrillo
	 * 			se suelte y caiga. En caso contrario, devuelve "null".
	 */
	public Ladrillo comportamientoRalph(Ralph ralph)
	{
		int suma=0;
		int cantidadPasos=0;
		while (cantidadPasos<rnd.nextInt(20)){
			if(Ralph.getPosicionRalphX()<4)
			{
				while(Ralph.getPosicionRalphX()<4){
					ralph.moverDerecha(this.seccionActual);
					cantidadPasos++;
				}
			}
			else{
				if(Ralph.getPosicionRalphX()>0){
					while(Ralph.getPosicionRalphX()>0){
						ralph.moverIzquierda(this.seccionActual);
						cantidadPasos++;
					}
				}
			}
		}
		System.out.println("La posicion actual de Ralph es:"+(ralph.getPosicionRalph().getX())+","+(ralph.getPosicionRalph().getY()+suma));
		if(this.tiempo==0)
			return ralph.romper();
		else
			return null;
	}
	
	/**
	 * En caso de que aparezca un ladrillo, este metodo determina su comportamiento.
	 * @param ladrillo (El ladrillo que aparecio).
	 * @param seccionActual (Seccion donde transcurre el juego en ese momento).
	 */
	public void comportamientoLadrillo(Ladrillo ladrillo, Seccion seccionActual){
		if(ladrillo.getPosicionLadrilloY()>0){
			ladrillo.setPosicionLadrilloY(ladrillo.getPosicionLadrilloY()-1);
			System.out.println("La posicion actual del ladrillo es:"+ladrillo.getPosicionLadrilloX()+","+ladrillo.getPosicionLadrilloY());
		}
		else
			this.setLadrillo(null);
	}
	
	/**
	 * En caso de que aparezca un pajaro, este metodo determina su comportamiento.
	 * @param pajaro (Es el pajaro en cuestion.)
	 */
	public void comportamientoPajaro(Pajaro pajaro){
		if((pajaro.getPosicionActual().getX()>=0)&&(pajaro.getPosicionActual().getX()<5)){
			if(pajaro.getPosicionInicialX()==0){
				pajaro.getPosicionActual().setX(pajaro.getPosicionActual().getX()+1);
				//System.out.println("La posicion actual del pajaro es:"+pajaro.getPosicionActual().getX()+","+pajaro.getPosicionActual().getY());
			}
			else{
				pajaro.getPosicionActual().setX(pajaro.getPosicionActual().getX()-1);
				//System.out.println("La posicion actual del pajaro es:"+pajaro.getPosicionActual().getX()+","+pajaro.getPosicionActual().getY());
			}
		}
		else{
			this.setPajaro(null);
			this.setTiempoAparicionPajaro(30);
		}
	}
	
	/**
	 * Puede que el nombre sea preste a confuciones. Para aclarar, este metodo cambia la seccion donde 
	 * transcurre el juego en caso de que Felix arregle todas las ventanas y no haya perdido todas sus vidas
	 * o incrementa el nivel y vuelve a colocar a Felix y a Ralph en la seccion inferior para continuar con el
	 * juego en caso de arreglar todas las ventanas de la Seccion Superior. 
	 * @param felix Representa a Felix.
	 * @param ralph Representa a Ralph.
	 */
	public void ganarJuego(FelixJr felix, Ralph ralph){
		Seccion seccionNueva;
		System.out.println("¡Completo la"+" "+this.seccionActual.getTipoSeccion()+"!"+"Pasando al siguiente seccion." );
		switch(this.seccionActual.getTipoSeccion()){
		case INFERIOR:
			seccionNueva=new SeccionMedia();
			this.tiempo=this.tiempoInicial;
			this.seccionActual=seccionNueva;
			this.prepararSeccion();
			this.comenzarJuego(felix, ralph);
			break;
		case MEDIA:
			seccionNueva=new SeccionSuperior();
			this.tiempo=this.tiempoInicial;
			this.seccionActual=seccionNueva;
			this.prepararSeccion();
			this.comenzarJuego(felix, ralph);
			break;
		case SUPERIOR:
			seccionNueva=new SeccionInferior();
			this.tiempoInicial=this.tiempoInicial-((this.tiempoInicial*15)/100);
			this.tiempo=this.tiempoInicial;
			int t=this.getTiempoFinalJuegoInicial()-((this.getTiempoFinalJuegoInicial()*15)/100);
			this.setTiempoFinalJuegoInicial(t);
			this.setTiempoFinalJuego(t);
			this.seccionActual=seccionNueva;
			this.prepararSeccion();
			this.comenzarJuego(felix, ralph);
			this.nivel++;
			System.out.println("¡Felicidades, ha pasado de nivel! Pasando al nivel"+" "+this.nivel);
			break;
		}
		felix.getPuntaje().sumar(400);
	}
	
	/**
	 * Determina si Felix arreglo todas las ventanas de la seccion donde se encuentra actualmente.
	 * @return Devuelve "true" en caso de que arregle todas las ventanas, devuelve "false en caso contrario".
	 */
	public boolean seccionCompleta(){
		boolean condicion=true;
		int vidriosSinArreglar=0;
		Panel[] panelTemp;
		for(int f=0;f<3;f++){
			for (int c=0;c<5;c++){
				panelTemp=this.seccionActual.getVentanaSeccion(f, c).getVidrios();
				for(int i=0;i<panelTemp.length;i++)
					if(panelTemp[i].getEstado().getCondicion()!=estadosVidrios.SANO){
						condicion=false;
						vidriosSinArreglar++;
					}
			}
		}
		if (condicion)
			System.out.println("Todas las ventanas de la seccion han sido arregladas.");
		else
			System.out.println("Quedan"+" "+vidriosSinArreglar+" "+"vidrios que no han sido arreglados.");
		return condicion;
	}
	
	/**
	 * Se encarga de comenzar el juego en caso de que no haya iniciado, o de poner en posicion a Felix y 
	 * a Ralph en caso de que ya haya comenzado el juego.
	 * @param felix Representa a Felix.
	 * @param ralph Representa a Ralph.
	 */
	public void comenzarJuego(FelixJr felix, Ralph ralph){
		if (this.nivel==0){
			this.nivel=1;
			this.tiempo=this.tiempoInicial;
		}
		felix.getPosicionFelix().setX(0);
		felix.getPosicionFelix().setY(0);
		int x=rnd.nextInt(5);
		ralph.getPosicionRalph().setX(x);
		ralph.getPosicionRalph().setY(3);
		System.out.println("¡El juego ha comenzado!");
	}
	
	/**
	 * Cuando el juego termina (condicionJuego=false), determina las razones por las que termino el juego.
	 * Sirve mas bien para saber si el juego se ejecuto correctamente hasta el final.
	 * @param felix (Para revisar las vidas de Felix al final del juego).
	 */
	public void finJuego(FelixJr felix){
		if (felix.getVidas().getCantidad()==0)
			System.out.println("Felix perdio todas sus vidas. Gave Over.");
		else
			if (this.tiempoFinalJuego==0)
				System.out.println("El juego termino debido a que se acabo el tiempo.");
			else
				if(this.nivel==10)
					System.out.println("El juego termino ya que Felix supero los 10 niveles");
				else
					System.out.println("El juego fue forzado a cerrarse.");
		felix.eliminar();
		Ralph.getRalph().eliminar();
		ModeloJuego.miModelo=null;
						
	}
	
	/**
	 * @return Devuelve el valor actual de la variable condicionJuego.
	 */
	public boolean isCondicionJuego() {
		return condicionJuego;
	}
	
	/**
	 * 
	 * @param condicionJuego (Sera el nuevo valor de la variable condicionJuego).
	 */
	public void setCondicionJuego(boolean condicionJuego) {
		this.condicionJuego = condicionJuego;
	}
	
	/**
	 * 
	 * @return Devuelve el tiempo que le queda a Felix para arreglar el edificio.
	 */
	public int getTiempoFinalJuego() {
		return tiempoFinalJuego;
	}
	
	/**
	 * 
	 * @param tiempoFinalJuego (Sera el timpo que le quedara a Felix para arreglar el 
	 * 							edificio.)
	 */
	public void setTiempoFinalJuego(int tiempoFinalJuego) {
		this.tiempoFinalJuego = tiempoFinalJuego;
	}
	
	/**
	 * 
	 * @return Devuelve el tiempo limite para que Felix arregle el edificio en cada nivel.
	 */
	public int getTiempoFinalJuegoInicial() {
		return tiempoFinalJuegoInicial;
	}
	
	/**
	 * 
	 * @param tiempoFinalJuegoInicial (Sera el tiempo que tendra Felix para arreglar el
	 * 									edificio, cambia al pasar de nivel.)
	 */
	public void setTiempoFinalJuegoInicial(int tiempoFinalJuegoInicial) {
		this.tiempoFinalJuegoInicial = tiempoFinalJuegoInicial;
	}
	
	/**
	 * 
	 * @return Devuelve el tiempo que falta para que aparezca un pajaro.
	 */
	public int getTiempoAparicionPajaro() {
		return tiempoAparicionPajaro;
	}
	
	/**
	 * 
	 * @param tiempoAparicionPajaro (Sera el tiempo que falta para que aparezca un pajaro.)
	 */
	public void setTiempoAparicionPajaro(int tiempoAparicionPajaro) {
		this.tiempoAparicionPajaro = tiempoAparicionPajaro;
	}
	
	/**
	 * 
	 * @return Devuelve el tiempo que falta para que un Niclelander intente dejar un
	 * 			pastel para Felix.
	 */
	public int getTiempoPastel() {
		return tiempoPastel;
	}

	/**
	 * 
	 * @param tiempoPastel (Sera el tiempo que falta para que un Nicelander intente dejar
	 * 						un pastel.)
	 */
	public void setTiempoPastel(int tiempoPastel) {
		this.tiempoPastel = tiempoPastel;
	}

	/**
	 * Durante el transcurso del juego, este metodo "dejara un pastel" en alguna ventana que cumpla los
	 * requisitos.
	 */
	public void dejarPastel(){
		boolean dejoPastel=false;
		int f=0;
		int c=0;
		Ventana ventanaActual=null;
		while((dejoPastel==false) && (f<3)){
			ventanaActual=this.seccionActual.getVentanaSeccion(f, c);
			if(ventanaActual.getTipoVentana()==tipoVentana.COMUN){
					if(ventanaActual.getVidrios()[1].getEstado().getCondicion()==estadosVidrios.ROTO)
						dejoPastel=true;
			}
			if(c<4)
				c++;
			else{
				f++;
				c=0;
			}	
		}
		if(dejoPastel){
			((VentanaComun) ventanaActual).setTienePastel(true);
			System.out.println("Un Nicelander dejo un pastel.");
		}
	}

	public Seccion getSeccionActual() {
		return seccionActual;
	}

	public void setSeccionActual(Seccion seccionActual) {
		this.seccionActual = seccionActual;
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Ladrillo getLadrillo() {
		return ladrillo;
	}

	public void setLadrillo(Ladrillo ladrillo) {
		this.ladrillo = ladrillo;
	}

	public Pajaro getPajaro() {
		return pajaro;
	}

	public void setPajaro(Pajaro pajaro) {
		this.pajaro = pajaro;
	}

	/**
	 * Este metodo main es el que se encarga de ejecutar el juego.
	 * @param args (Esto no es de importancia.)
	 */
	public static void main(String[] args) {
		ModeloJuego juego=new ModeloJuego();
		juego.setCondicionJuego(true);
		Record record=Record.getRecord();
		FelixJr felix=FelixJr.getFelix();
		Ralph ralph= Ralph.getRalph();
		Ladrillo ladrillo=juego.getLadrillo();
		Pajaro pajaro=juego.getPajaro();
		juego.comenzarJuego(felix, ralph);
		/*Timer timer= new Timer("Ralph se mueve.");
		ComportamientoRalph comportamiento= new ComportamientoRalph(timer,Ralph.getRalph());
		timer.schedule(comportamiento, 0, TimeUnit.SECONDS.toSeconds(30));*/
		while(juego.isCondicionJuego()){
			juego.tiempo--;
			if(juego.getTiempoPastel()==0){
				juego.dejarPastel();
				juego.setTiempoPastel(20);
			}
			else{
				juego.setTiempoPastel(juego.getTiempoPastel()-1);
			}
			if(FelixJr.getInmunidad()>0)
				FelixJr.setInmunidad(FelixJr.getInmunidad()-1);
			if(ladrillo==null)
				ladrillo=juego.comportamientoRalph(ralph);
			else{
				juego.comportamientoRalph(ralph);
				System.out.println("¡Un ladrillo ha aparecido!");
				juego.comportamientoLadrillo(ladrillo, juego.seccionActual);
				felix.muerte(ladrillo);
			}
			if(juego.getTiempoAparicionPajaro()==0)
				pajaro=new Pajaro();
			else
				juego.setTiempoAparicionPajaro(juego.getTiempoAparicionPajaro()-1);
			if(pajaro!=null){
				System.out.println("¡Un pajaro ha aparecido!");
				juego.comportamientoPajaro(pajaro);
				felix.muerte(pajaro);
			}
			juego.setTiempoFinalJuego(juego.getTiempoFinalJuego()-1);
			if((felix.getVidas().getCantidad()==0)||juego.nivel==10||juego.getTiempoFinalJuego()==0)
				juego.setCondicionJuego(false);
			else
				if(juego.seccionCompleta()&&(felix.getVidas().getCantidad()>0))
					juego.ganarJuego(felix,ralph);
		}
		juego.finJuego(felix);
		record.reemplazar(felix.getPuntaje());
	}
}
