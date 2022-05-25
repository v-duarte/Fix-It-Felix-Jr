package juego.graficos;

import javax.swing.*;

public class SeccionSuperiorG {
	String imgname="images/edificio/edificio_150_seccion3.png";
	private ImageIcon img;
	private static SeccionSuperiorG g;

	private SeccionSuperiorG() {
		img=new CargaImagenes("../../images/edificio/edificio_150_seccion3.png").getImg();
	}
	
	public static SeccionSuperiorG getGraficos(){
		if(g==null)
			g=new SeccionSuperiorG();
		return g;
	}
	
	public ImageIcon getImagenSeccion(){
		return img;
	}

}
