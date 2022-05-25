package juego.graficos;

import java.awt.*;

import javax.swing.*;

import juego.controlador.Controlador.EventoModelo;
import juego.felix.FelixJr;
import juego.felix.FelixJr.ProximaAccion;
import juego.modelo.ModeloJuego;
import juego.niceland.secciones.Seccion.TipoSeccion;
import juego.ralph.Ralph;

public class PanelJuego extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int desplazamientoHorizontal=62;
	private static final int desplazamientoVertical=60;
	private static final int desplazamientoVentanaHorizontal=58;
	private static final int desplazamientoVentanaVertical=65;
	private static final int origenHorizontal=22;
	private static final int origenVertical=265;
	
	private Image imgFelixActual;
	private int posFelixX=origenHorizontal;
	private int posFelixY=origenVertical;
	private Image imgRalphActual;
	private int posRalphX=origenHorizontal;
	private int posRalphY=40;
	private int posVentanaC=origenHorizontal;
	private int posVentanaF=origenVertical;
	private Image imgLadrillo;
	private int posLadrilloX;
	private int posLadrilloY=0;
	private Image imgPajaro;
	private int posPajaroX=0;
	private int posPajaroY;
	private Font fuente;
	
	private static PanelJuego miPanel;
	
	private PanelJuego(){
		imgFelixActual= FelixJrG.getGraficos().getFelixParado().getImage();
		imgRalphActual= RalphG.getGraficos().getRalphQuieto().getImage();
		imgLadrillo= LadrilloG.getGraficos().getImagenLadrillo();
		fuente= new Font("Impact", Font.BOLD, 12);
		this.setSize(315, 407);
	}
	
	public static PanelJuego getPanel(){
		if(miPanel==null)
			miPanel=new PanelJuego();
		return miPanel;
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		GraficadorSeccion gfs= new GraficadorSeccion();
		g.drawImage(gfs.graficar(ModeloJuego.getModelo().getSeccionActual()),0, 30, Color.BLACK, null);
		for (int f=0; f<3;f++)
		{
			for(int c=0;c<5;c++){
				GraficadorVentana gfv= new GraficadorVentana();
				g.drawImage(gfv.graficar(ModeloJuego.getModelo().getSeccionActual().getVentanaSeccion(f, c)), posVentanaC+desplazamientoVentanaHorizontal*c, posVentanaF-desplazamientoVentanaVertical*f, null);
			}
		}
		if(ModeloJuego.getModelo().getSeccionActual().getTipoSeccion()==TipoSeccion.INFERIOR){
			if(FelixJr.getPosicionFelixJrX()==2&&FelixJr.getPosicionFelixJrY()==0)
				g.drawImage(imgFelixActual, posFelixX, posFelixY+35, null);
			else
				g.drawImage(imgFelixActual, posFelixX, posFelixY, null);
		}
		else
			g.drawImage(imgFelixActual, posFelixX, posFelixY, null);
		posRalphX=origenHorizontal+55*Ralph.getPosicionRalphX();
		g.drawImage(imgRalphActual, posRalphX, posRalphY, null);
		if(ModeloJuego.getModelo().getLadrillo()!=null){
			g.drawImage(imgLadrillo, posLadrilloX, posLadrilloY, null);
			this.movimientoLadrillo();
		}
		if(ModeloJuego.getModelo().getPajaro()!=null){
			g.drawImage(imgPajaro, posPajaroX, posPajaroY, null);
			this.movimientoPajaro();
		}
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 315, 30);
		g.fillRect(0, 0, 315, 30);
		g.setColor(Color.YELLOW);
		g.drawLine(0, 15, 315, 15);
		g.drawLine(0, 31, 315, 31);
		g.setFont(fuente);
		g.drawString("Puntaje:", 0, 12);
		g.drawString("Vidas restantes:", 0, 27);
		g.setColor(Color.RED);
		g.drawString(Integer.toString(FelixJr.getFelix().getPuntaje().getPuntajeActual()), 55, 12);
		g.drawString(Integer.toString(FelixJr.getFelix().getVidas().getCantidad()), 100, 27);
		
	}
	
	
	public void movimientoFelixArriba(){
		posFelixY=posFelixY-desplazamientoVertical;
		this.repaint();
	}
	
	public void movimientoFelixAbajo(){
		posFelixY=posFelixY+desplazamientoVertical;
		this.repaint();
	}
	
	public void movimientoFelixDerecha(){
		posFelixX=posFelixX+desplazamientoHorizontal;
		imgFelixActual= FelixJrG.getGraficos().getFelixMoviendose().getImage();
		this.repaint();
		imgFelixActual= FelixJrG.getGraficos().getFelixParado().getImage();
		this.repaint();
	}
	
	public void movimientoFelixIzquierda(){
		posFelixX=posFelixX-desplazamientoHorizontal;
		imgFelixActual= FelixJrG.getGraficos().getFelixMoviendose().getImage();
		this.repaint();
		imgFelixActual= FelixJrG.getGraficos().getFelixParado().getImage();
		this.repaint();
	}
	
	public void mover(){
		switch(FelixJr.getProxima()){
		case ARRIBA:
			this.movimientoFelixArriba();
			break;
		case ABAJO:
			this.movimientoFelixAbajo();
			break;
		case IZQUIERDA:
			this.movimientoFelixIzquierda();
			break;
		case DERECHA:
			this.movimientoFelixDerecha();
			break;
		case ARREGLAR:
			break;
		default:
			break;
		}
	}
	
	@SuppressWarnings("static-access")
	public void arreglar(){
		ImageIcon[] animacion= FelixJrG.getGraficos().getAnimacionArreglar();
		if(FelixJr.getFelix().getProxima()==ProximaAccion.DERECHA){
			for(int i=0;i<2;i++){
				imgFelixActual=animacion[i].getImage();
				this.repaint();
			}
		}
		else{
			for(int i=2;i<4;i++){
				imgFelixActual=animacion[i].getImage();
				this.repaint();
			}
		}
	}
	
	public void movimientoPajaro(){
		ImageIcon[] animacion=PajaroG.getGraficos().getImagenPajaro();
		posPajaroY=216+60*ModeloJuego.getModelo().getPajaro().getPosicionActual().getY();
		if(ModeloJuego.getModelo().getPajaro().getPosicionInicialX()==0){
			if(posPajaroX==0)
				posPajaroX=origenHorizontal;
			posPajaroX=posPajaroX+desplazamientoHorizontal;
			if(ModeloJuego.getModelo().getPajaro().getPosicionActual().getX()%2==0)
				imgPajaro=animacion[0].getImage();
			else
				imgPajaro=animacion[1].getImage();
		}
		else{
			if(posPajaroX==0)
				posPajaroX=270;
			posPajaroX=posPajaroX-desplazamientoHorizontal;
			if(ModeloJuego.getModelo().getPajaro().getPosicionActual().getX()%2==0)
				imgPajaro=animacion[2].getImage();
			else
				imgPajaro=animacion[3].getImage();
		}
		if(ModeloJuego.getModelo().getPajaro().getPosicionActual().getX()==0||ModeloJuego.getModelo().getPajaro().getPosicionActual().getX()==4)
			posPajaroX=0;
	}
	
	public void muerte(){
		ImageIcon[] animacion= FelixJrG.getGraficos().getAnimacionFelixMuere();
		for(int i=0;i<animacion.length;i++){
			imgFelixActual=animacion[i].getImage();
			this.repaint();
		}
		posFelixX=origenHorizontal;
		posFelixY=origenVertical;
		imgFelixActual=FelixJrG.getGraficos().getFelixParado().getImage();
	}
	
	public void movimientoLadrillo(){
		posLadrilloX=22+desplazamientoHorizontal*ModeloJuego.getModelo().getLadrillo().getPosicionLadrilloX();
		posLadrilloY=posRalphY+desplazamientoVertical;
		if(ModeloJuego.getModelo().getLadrillo().getPosicionLadrilloY()!=0)
			posLadrilloY=posLadrilloY+desplazamientoVertical;
		else
			posLadrilloY=0;
	}
	
	public void seccionCompleta(){
		posFelixX=origenHorizontal;
		posFelixY=origenVertical;
		posRalphX=origenHorizontal;
		posRalphY=40;
		this.repaint();
	}
	
	public void pasarNivel(){
		this.seccionCompleta();
	}
	
	public void evento(EventoModelo evento){
		switch(evento){
		case FELIX_MURIO:
			this.muerte();
			break;
		case SECCION_COMPLETA:
			this.seccionCompleta();
		case PASO_NIVEL:
			this.pasarNivel();
		case NADA:
			this.repaint();
			
		}
	}
	
	public void finJuego(){
		PanelJuego.miPanel=null;
	}

}
