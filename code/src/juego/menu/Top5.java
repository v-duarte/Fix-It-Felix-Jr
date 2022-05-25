package juego.menu;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import juego.mecanica.Puntaje;

public class Top5 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabla= new JTable();
	private String[] titulos={"Puesto", "Nombre", "Puntaje"};
	private DefaultTableModel modelo=new DefaultTableModel(titulos,5);
	
	private static Top5 ranking;
	
	private Top5(){
		this.setLayout(new BorderLayout());
		tabla.setModel(modelo);
		for(int i=0;i<5;i++){
			tabla.setValueAt(i+1, i, 0);
		}
		this.add(new JScrollPane(tabla), BorderLayout.CENTER);
		this.setTitle("Top 5");
		this.setSize(600, 480);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static Top5 getRanking(){
		if(ranking==null)
			ranking=new Top5();
		ranking.mostrar();
		return ranking;
	}
	
	public void mostrar(){
		this.setVisible(true);
		
	}
	
	public void ingresarEnRanking(int puesto, String nombre, Puntaje puntaje){
		tabla.setValueAt(puesto, puesto-1, 0);
		tabla.setValueAt(nombre, puesto-1, 1);
		tabla.setValueAt(puntaje.getPuntajeActual(), puesto-1, 2);
	}
	
	public JTable getTabla(){
		return tabla;
	}
}
