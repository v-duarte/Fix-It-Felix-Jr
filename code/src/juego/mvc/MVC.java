package juego.mvc;


import juego.controlador.Controlador;
import juego.felix.FelixJr;
import juego.graficos.VistaJuego;
import juego.modelo.ModeloJuego;
import juego.ralph.Ralph;

public class MVC {
	private ModeloJuego modelo;
	private VistaJuego vista;
	@SuppressWarnings("unused")
	private Controlador controlador;
	
	
	public MVC(){
		modelo= ModeloJuego.getModelo();
		modelo.comenzarJuego(FelixJr.getFelix(), Ralph.getRalph());
		vista= new VistaJuego(modelo);
		controlador= new Controlador(vista, modelo);
	}
	
	public MVC(int nivel){
		modelo= ModeloJuego.getModelo(nivel);
		modelo.comenzarJuego(FelixJr.getFelix(), Ralph.getRalph());
		vista= new VistaJuego(modelo);
		controlador= new Controlador(vista, modelo);
	}
	
	public VistaJuego getVista(){
		return vista;
	}

}
