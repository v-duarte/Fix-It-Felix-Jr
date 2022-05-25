package juego.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;*/
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

import juego.archivo.ArchivoRanking;
import juego.mvc.MVC;


public class VentanaPrincipal {
	String imgname="images/menus/principal.png";
	private JFrame frame= new JFrame("Fix It Felix Jr.");
	private ImageIcon img=new ImageIcon("src/images/menus/principal.png");
	private JButton reglas=new JButton("Reglas del juego");
	private JButton jugar=new JButton("¡Quiero jugar!");
	private JButton ranking= new JButton ("Top 5");
	private JComboBox<Integer> comboNivel;
	private int nivelSeleccionado=1;
	private JTable tabla;
	
	public VentanaPrincipal(){
		frame.setLayout(new BorderLayout());
		JLabel background=(new JLabel(img));
		frame.setContentPane(background);
		frame.setLayout(new FlowLayout());
		reglas.addMouseListener(new ReglasAdapter());
		frame.add(reglas);
		jugar.addMouseListener(new JugarAdapter());
		frame.add(jugar);
		ranking.addMouseListener(new RankingAdapter());
		frame.add(ranking);
		frame.addWindowListener(new VentanaAdapter());
		comboNivel= new JComboBox<Integer>();
		this.iniciarComboBox();
		//comboNivel.addItemListener(new ComboListener());
		comboNivel.addActionListener(new ComboListener());
		frame.add(comboNivel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,480);
		frame.setVisible(true);
		}
	
	private void iniciarComboBox(){
		comboNivel.addItem(1);
		comboNivel.addItem(2);
		comboNivel.addItem(3);
		comboNivel.addItem(4);
		comboNivel.addItem(5);
		comboNivel.addItem(6);
		comboNivel.addItem(7);
		comboNivel.addItem(8);
		comboNivel.addItem(9);
		comboNivel.addItem(10);
	}
	
	public class ReglasAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			@SuppressWarnings("unused")
			JFrame reglasJuego=new Reglas();
		}
		
	}
	
	public class RankingAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			@SuppressWarnings("unused")
			JFrame top=Top5.getRanking();
			tabla=Top5.getRanking().getTabla();
		}
		
	}
	
	public class JugarAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			MVC mvc= new MVC(nivelSeleccionado);
			@SuppressWarnings("unused")
			JFrame jugar=mvc.getVista();
		}
	}
	
	public class VentanaAdapter extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent arg0) {
			System.out.println("Se esta cerrando la ventana.");
			ArchivoRanking ar= new ArchivoRanking();
			try {
				ar.escribir(tabla);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error al guardar registro de los 5 mejores puntajes.");
			}
			System.out.println("Se cerro el juego.");
		}
	}
	
	public class ComboListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			nivelSeleccionado= (Integer) comboNivel.getSelectedItem();
			System.out.println("Se configuro el juego para iniciar en el nivel"+" "+nivelSeleccionado);
			
		}

		/*@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==comboNivel){
				nivelSeleccionado= (Integer) comboNivel.getSelectedItem();
			}
			System.out.println("Se configuro el juego para iniciar en el nivel"+" "+nivelSeleccionado);
		}*/
		
	}
	
}

