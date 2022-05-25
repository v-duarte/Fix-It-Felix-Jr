package juego.graficos;

import javax.swing.*;

import juego.niceland.secciones.Seccion;

public class SeccionG extends Seccion {

	JPanel panel;
	private ImageIcon img;
	
	public SeccionG(TipoSeccion TipoSeccion, ImageIcon img) {
		super(TipoSeccion);
		this.img=img;
		panel=new JPanel();
		panel.add(new JLabel(this.img));
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
