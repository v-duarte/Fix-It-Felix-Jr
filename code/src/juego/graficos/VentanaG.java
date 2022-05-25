package juego.graficos;

import javax.swing.*;

import juego.niceland.ventanas.*;

public class VentanaG extends Ventana {
	private ImageIcon img;
	private  JPanel panel;

	public VentanaG(int cantidadVidrios, tipoVentana tipoVentana, ImageIcon img) {
		super(cantidadVidrios, tipoVentana);
		this.img=img;
		this.panel= new JPanel();
		panel.add(new JLabel(this.img));	
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
