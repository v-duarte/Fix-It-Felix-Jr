package juego.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Reglas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String imgname="images/menus/instrucciones.png";
	private ImageIcon img=new ImageIcon("src/images/menus/instrucciones.png");
	
	public Reglas(){
		this.setLayout(new BorderLayout());
		JLabel background=(new JLabel(img));
		this.setContentPane(background);
		this.setLayout(new FlowLayout());
		this.setTitle("Reglas del Juego");
		this.setSize(600, 480);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
