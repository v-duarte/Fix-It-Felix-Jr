package juego.controlador;

import java.util.Timer;
import java.util.TimerTask;

import juego.felix.FelixJr;
import juego.graficos.VistaJuego;
import juego.modelo.ModeloJuego;
import juego.pajaro.Pajaro;
import juego.ralph.Ralph;

public class ComportamientoModelo extends TimerTask {
	
	private static final int tiempoAparicionLadrillo=10;
	private static final int tiempoAparicionPajaro=30;
	
	@SuppressWarnings("unused")
	private Timer timer;
	private ModeloJuego modelo;
	private VistaJuego vista;
	private int tiempoPajaro;
	private int tiempoLadrillo;
	ComportamientoRalph comportamiento;
	
	public ComportamientoModelo(Timer timer, ModeloJuego modelo, VistaJuego vista){
		this.timer=timer;
		this.modelo=modelo;
		this.vista=vista;
		tiempoPajaro=tiempoAparicionPajaro;
		tiempoLadrillo=tiempoAparicionLadrillo;
		Timer timerRalph= new Timer("Ralph se mueve.");
		comportamiento= new ComportamientoRalph(timerRalph,Ralph.getRalph(), vista);
		timer.schedule(comportamiento, 0, 5000);
	}

	@Override
	public void run() {
		tiempoLadrillo--;
		tiempoPajaro--;
		if(tiempoLadrillo==0){
			modelo.setLadrillo(Ralph.getRalph().romper());
			tiempoLadrillo=tiempoAparicionLadrillo;
		}
		if(modelo.getLadrillo()!=null){
			vista.getPanel().movimientoLadrillo();
			modelo.comportamientoLadrillo(modelo.getLadrillo(), modelo.getSeccionActual());
		}
		if(tiempoPajaro==0){
			modelo.setPajaro(new Pajaro());
			tiempoPajaro=tiempoAparicionPajaro;
		}
		if(modelo.getPajaro()!=null){
			vista.getPanel().movimientoPajaro();
			modelo.comportamientoPajaro(modelo.getPajaro());
		}
		vista.getPanel().repaint();
		if(this.terminoJuego())
			this.terminarEjecucion();
	}
	
	public void terminarEjecucion(){
		comportamiento.terminarEjecucion();
		this.cancel();
	}
	
	public boolean terminoJuego(){
		if(FelixJr.getFelix().getVidas().getCantidad()==0||modelo.getNivel()==10){
			return true;
		}
		return false;
	}

}
