package juego.graficos;

import javax.swing.*;

public class RalphG {
	//En los array, el lugar 0 es Derecha y 1 es Izquierda.
	
	private ImageIcon ralphQuieto;
	private ImageIcon[] ralphSeMueve= new ImageIcon[4];
	private ImageIcon[] ralphRompe= new ImageIcon[6];
	
	private static RalphG g;
	
	private RalphG(){
		ralphQuieto= new CargaImagenes("../../images/ralph/slice146_@.png").getImg();
		
		ralphSeMueve[0]= new CargaImagenes("../../images/ralph/slice147_@.png").getImg();
		ralphSeMueve[1]= new CargaImagenes("../../images/ralph/slice148_@.png").getImg();
		ralphSeMueve[2]= new CargaImagenes("../../images/ralph/slice148_@.png").getImg();
		ralphSeMueve[3]= new CargaImagenes("../../images/ralph/slice148_@.png").getImg();
		
		ralphRompe[0]= new CargaImagenes("../../images/ralph/slice150_@.png").getImg();
		ralphRompe[1]= new CargaImagenes("../../images/ralph/slice151_@.png").getImg();
		ralphRompe[2]= new CargaImagenes("../../images/ralph/slice163_@.png").getImg();
		ralphRompe[3]= new CargaImagenes("../../images/ralph/slice164_@.png").getImg();
		ralphRompe[4]= new CargaImagenes("../../images/ralph/slice165_@.png").getImg();
		ralphRompe[5]= new CargaImagenes("../../images/ralph/slice166_@.png").getImg();
	}
	
	public static RalphG getGraficos(){
		if(g==null)
			g= new RalphG();
		return g;
	}
	
	public ImageIcon getRalphQuieto(){
		return ralphQuieto;
	}
	
	public ImageIcon[] getAnimacionMovimiento(){
		return ralphSeMueve;
	}
	
	public ImageIcon[] getAnimacionRomper(){
		return ralphRompe;
	}
	

}
