package juego.controlador;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import juego.graficos.VistaJuego;
import juego.modelo.ModeloJuego;
import juego.ralph.Ralph;

public class ComportamientoRalph extends TimerTask {
	
	@SuppressWarnings("unused")
	private Timer timer;
	private Ralph ralph;
	
	
	private static  Random rnd = new Random();
	
	public ComportamientoRalph(Timer timer, Ralph ralph, VistaJuego vista){
		this.timer=timer;
		this.ralph=ralph;
	}
	
	public void terminarEjecucion(){
		this.cancel();
	}

	@Override
	public void run() {
		int cantidadPasos=0;
		int limite=rnd.nextInt(20);
		while (cantidadPasos<limite){
			if(Ralph.getPosicionRalphX()<4)
			{
				while(Ralph.getPosicionRalphX()<4){
					ralph.moverDerecha(ModeloJuego.getModelo().getSeccionActual());
					cantidadPasos++;
				}
			}
			else{
				if(Ralph.getPosicionRalphX()>0){
					while(Ralph.getPosicionRalphX()>0){
						ralph.moverIzquierda(ModeloJuego.getModelo().getSeccionActual());
						cantidadPasos++;
					}
				}
			}
		}
	}
	

}
