package juego.graficos;

import javax.swing.ImageIcon;

public class SeccionMediaG  {
	
	String imgname="images/edificio/edificio_150_seccion2.png";
	private ImageIcon img;
	
	private static SeccionMediaG g;

	private SeccionMediaG() {
		img=new CargaImagenes("../../images/edificio/edificio_150_seccion2.png").getImg();
	}
	
	public static SeccionMediaG getGraficos(){
		if(g==null)
			g= new SeccionMediaG();
		return g;
	}
	
	public ImageIcon getImagenSeccion(){
		return img;
	}

}
