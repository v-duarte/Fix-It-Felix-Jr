package juego.graficos;

import java.awt.Image;

import javax.swing.*;

public class LadrilloG {
	ImageIcon ladrillo;
	
	private static LadrilloG g;
	
	private LadrilloG(){
		ladrillo=new CargaImagenes("../../images/rocas/slice10_10.png").getImg();
	}
	
	public static LadrilloG getGraficos(){
		if(g==null)
			g=new LadrilloG();
		return g;
	}
	
	public Image getImagenLadrillo(){
		return ladrillo.getImage();
	}

}
