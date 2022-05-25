package juego.nombre;

import javax.swing.*;

import java.awt.event.*;

import juego.controlador.Controlador;

public class IngresoNombre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textfield;
	private JLabel label;
	private JButton boton;
	private String nombre=null;
	private Controlador controlador;
	
	public IngresoNombre(){
		this.setLayout(null);
		controlador=null;
		label=new JLabel("Ingrese un nombre:");
		label.setBounds(10,10,130,30);
		this.add(label);
		textfield=new JTextField(20);
		textfield.setBounds(125, 10, 150, 20);
		this.add(textfield);
		boton= new JButton("Aceptar");
		boton.setBounds(10, 80, 100, 30);
		boton.addMouseListener(new BotonAdapter());
		this.add(boton);
		this.setSize(300, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public IngresoNombre(Controlador controlador) {
		this.setLayout(null);
		this.controlador=controlador;
		label=new JLabel("Ingrese un nombre:");
		label.setBounds(10,10,130,30);
		this.add(label);
		textfield=new JTextField(20);
		textfield.setBounds(125, 10, 150, 20);
		this.add(textfield);
		boton= new JButton("Aceptar");
		boton.setBounds(10, 80, 100, 30);
		boton.addMouseListener(new BotonAdapter());
		this.add(boton);
		this.setSize(300, 150);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public String getNombre(){
		return nombre;
	}
	
	public class BotonAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			if((textfield.getText().length()>2)&&(!textfield.getText().isEmpty())){
				nombre=textfield.getText();
				System.out.println("Se acepto el nombre:"+" "+nombre);
				if(controlador!=null)
					controlador.recibioNombre(nombre);
			}
			else
				new MensajeError();
		}
		
	}
	
	public class MensajeError extends JFrame implements MouseListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JLabel labelError;
		private JButton botonError;
		
		public MensajeError(){
			this.setLayout(null);
			labelError=new JLabel("No puede ingresar ese nombre. El nombre no debe estar vacio y debe tener mas de dos caracteres.");
			labelError.setBounds(10,10,600,30);
			this.add(labelError);
			botonError=new JButton("Aceptar");
			botonError.setBounds(240, 50, 90, 30);
			botonError.addMouseListener(this);
			this.add(botonError);
			this.setTitle("Error");
			this.setSize(600,120);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setVisible(true);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			this.dispose();
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
