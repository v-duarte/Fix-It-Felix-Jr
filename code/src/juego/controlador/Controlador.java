package juego.controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import juego.felix.FelixJr;
import juego.felix.FelixJr.ProximaAccion;
import juego.graficos.VistaJuego;
import juego.mecanica.Record;
import juego.menu.Top5;
import juego.modelo.ModeloJuego;
import juego.nombre.IngresoNombre;
import juego.ralph.Ralph;

public class Controlador {
	public enum EventoModelo {SECCION_COMPLETA,FELIX_MURIO,PASO_NIVEL,NADA};
	
	private EventoModelo evento;
	private VistaJuego vista;
	private ModeloJuego modelo;
	private ComportamientoModelo comportamiento;
	private FelixAdapter teclado;
	
	public Controlador(VistaJuego vista, ModeloJuego modelo){
		this.evento=EventoModelo.NADA;
		this.vista=vista;
		this.modelo=modelo;
		teclado=new FelixAdapter();
		this.vista.addFelixListener(teclado);
		this.vista.addControlador(this);
		Timer timer= new Timer("Juego");
		comportamiento= new ComportamientoModelo(timer,modelo,vista);
		timer.schedule(comportamiento, 0, 1000);
	}
	
	public EventoModelo ocurrioAlgo(){
		if(modelo.getPajaro()!=null||modelo.getLadrillo()!=null){
			if(modelo.getPajaro()!=null){
				if(FelixJr.getFelix().muerte(modelo.getPajaro()))
					evento=EventoModelo.FELIX_MURIO;
			}
			else
				if(FelixJr.getFelix().muerte(modelo.getLadrillo()))
					evento=EventoModelo.FELIX_MURIO;
		}
		else
			if(modelo.seccionCompleta()){
				evento=EventoModelo.SECCION_COMPLETA;
				modelo.ganarJuego(FelixJr.getFelix(), Ralph.getRalph());
			}
			else
				evento=EventoModelo.NADA;
		return evento;
	}
	
	@SuppressWarnings("unused")
	public void finJuego(){
		this.vista.removeKeyListener(teclado);
		IngresoNombre ingreso= new IngresoNombre(this);
	}
	
	public void recibioNombre(String nombre){
		Record record=Record.getRecord();
		if(record.reemplazar(FelixJr.getFelix().getPuntaje())){
			int puesto=record.buscar(FelixJr.getFelix().getPuntaje());
			Top5.getRanking().ingresarEnRanking(puesto, nombre, FelixJr.getFelix().getPuntaje());
		}
		vista.dispose();
		this.seCerroVentana();
	}
	
	public void seCerroVentana(){
		comportamiento.terminarEjecucion();
		ModeloJuego.getModelo().finJuego(FelixJr.getFelix());
	}
	
	
	public class FelixAdapter extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()){
			case(KeyEvent.VK_UP):
				FelixJr.getFelix().setProxima(ProximaAccion.ARRIBA);
				break;
			case(KeyEvent.VK_DOWN):
				FelixJr.getFelix().setProxima(ProximaAccion.ABAJO);
				break;
			case(KeyEvent.VK_LEFT):
				FelixJr.getFelix().setProxima(ProximaAccion.IZQUIERDA);
				break;
			case(KeyEvent.VK_RIGHT):
				FelixJr.getFelix().setProxima(ProximaAccion.DERECHA);
				break;
			case(KeyEvent.VK_SPACE):
				FelixJr.getFelix().setProxima(ProximaAccion.ARREGLAR);	
				}
			evento=ocurrioAlgo();
			if(evento!=EventoModelo.NADA)
				vista.getPanel().evento(evento);
			if(comportamiento.terminoJuego())
				finJuego();
			if(!FelixJr.getFelix().mover(modelo.getSeccionActual())){
				FelixJr.getFelix().arreglar(modelo.getSeccionActual());
				vista.getPanel().arreglar();
			}
			else
				vista.getPanel().mover();
			evento=EventoModelo.NADA;
		}
	}
}


/*
 * @Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()){
			case(KeyEvent.VK_UP):
				if(FelixJr.getFelix().saltarArriba(ModeloJuego.getModelo().getSeccionActual()))
					vista.getPanel().movimientoFelixArriba();
				break;
			case(KeyEvent.VK_DOWN):
				if(FelixJr.getFelix().saltarAbajo(ModeloJuego.getModelo().getSeccionActual()))
					vista.getPanel().movimientoFelixAbajo();
				break;
			case(KeyEvent.VK_LEFT):
				if(FelixJr.getFelix().moverIzquierda(ModeloJuego.getModelo().getSeccionActual()))
					vista.getPanel().movimientoFelixIzquierda();
				break;
			case(KeyEvent.VK_RIGHT):
				if(FelixJr.getFelix().moverDerecha(ModeloJuego.getModelo().getSeccionActual()))
					vista.getPanel().movimientoFelixDerecha();
				break;
			case(KeyEvent.VK_SPACE):
				//System.out.println("Apretaste la tecla espacio");
				FelixJr.getFelix().arreglar(ModeloJuego.getModelo().getSeccionActual());
				vista.getPanel().arreglar();		
				}
		}*/
