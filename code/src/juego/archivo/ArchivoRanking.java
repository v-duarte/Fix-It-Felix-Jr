package juego.archivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;

public class ArchivoRanking {
	private FileWriter archivo; //new FileWriter("..\\..\\Ranking.txt");
	private BufferedWriter bw;
	
	public void escribir(JTable tabla) throws IOException{
		archivo= new FileWriter("Ranking.txt");
		bw= new BufferedWriter(archivo);
		String linea;
		linea= new String("Puesto"+" "+"Nombre"+"               "+"Puntaje");
		bw.write(linea);
		bw.newLine();
		if(tabla!=null)
			for(int i=0;i<5;i++){
				linea= new String(tabla.getValueAt(i, 0)+"      "+tabla.getValueAt(i, 1)+"                 "+tabla.getValueAt(i, 2));
				bw.write(linea);
				bw.newLine();
			}
		bw.close();
	}
}
