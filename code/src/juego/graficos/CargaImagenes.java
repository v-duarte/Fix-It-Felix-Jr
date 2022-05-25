package juego.graficos;

import javax.swing.*;

public class CargaImagenes extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon img;
	
	public CargaImagenes(String url){
		img=new ImageIcon(this.getClass().getResource(url));
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	
	
}
