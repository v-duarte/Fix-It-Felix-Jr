package juego.graficos;

import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.*;

import juego.controlador.Controlador;
import juego.modelo.ModeloJuego;

public class VistaJuego extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -174725691882500118L;
	
	private JTable tabla= new JTable();
	private String[] titulos={"Puntaje", "Vidas"};
	@SuppressWarnings("unused")
	private DefaultTableModel modeloTabla=new DefaultTableModel(titulos,1);
	
	@SuppressWarnings("unused")
	private ModeloJuego modelo;
	private Controlador controlador;
	private PanelJuego panelJuego;

	public VistaJuego(ModeloJuego modelo){
		this.modelo=modelo;
		this.setLayout(null);
		panelJuego=PanelJuego.getPanel();
		this.add(panelJuego);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(315, 407);
		this.setVisible(true);
		this.addWindowListener(new VistaAdapter());
	}
	
	public PanelJuego getPanel(){
		return panelJuego;
	}
	
	public JTable getTabla(){
		return tabla;
	}
	
	public void addFelixListener(KeyAdapter a){
		this.addKeyListener(a);
	}
	
	public void addControlador(Controlador controlador){
		this.controlador=controlador;
	}
	
	public class VistaAdapter extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent arg0) {
			panelJuego.finJuego();
			controlador.seCerroVentana();
		}
		
	}

}
