package juego.mecanica;

/**
 * Representa a un record o ranking, que muestra los mejores cinco puntajes guardados.
 * @author Victor Ariel Daurte Ocampo
 *
 */
public class Record {
	//Atributos
	
	/**
	 *  Este arreglo guarda los mejores 5 puntajes.
	 */
	private Puntaje[] record=new Puntaje[5];
	private static Record miRecord;
	
	//Constructor
	
	/**
	 *  Construye el record con valores por defecto.
	 */
	private Record(){
		for (int i=0;i<5;i++)
			record[i]=new Puntaje();
	}
	
	public static Record getRecord(){
		if(miRecord==null)
			miRecord=new Record();
		return miRecord;
	}
	
	//Metodos
	
	/**
	 * Este metodo se usa cuando al menos uno de las posiciones del record tiene el valor por defecto. 
	 * En caso de que ya todos las posiciones tengan otro valor que no sea el que viene por defecto, usar
	 * {@link #reemplazar(Puntaje)}
	 * @param p (Esta variable representa un nuevo puntaje que quedara guardado en el record. 
	 * @return Devuelve un boolean que dice si pudo guardar el puntaje o no. Devuelve "true" si es el caso,
	 * 			"false" en caso contrario.
	 */
	public boolean agregarNuevoPuntaje(Puntaje p){
		int i=0;
		while ((i<5)&&(this.record[i].getPuntajeActual()>0)){
			i++;
		}
		if (i<5){
			record[i].setPuntajeActual(p.getPuntajeActual());
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Comparara cada valor guardado en el record con el que entro, se lo reemplazara si el que entro es mas
	 * grande.
	 * @param p (El puntaje que sera coomparado con los que ya estan guardados.)
	 * @return Devuelve un boolean si se reemplazo alguna posicion del record con el puntaje p. Devuelve "true"
	 * 			si fue asi, "false" en caso contrario.
	 */
	public boolean reemplazar(Puntaje p) {
		int i=4;
		while ((i>0)&&(this.record[i].getPuntajeActual()<=p.getPuntajeActual())){
			i--;
		}
		if ((i==0)&&(this.record[0].getPuntajeActual()<p.getPuntajeActual())){
			this.record[i]=p;
			System.out.println("¡Felicidades! Consiguio el"+" "+(i+1)+" "+"lugar con su puntaje.");
				return true;
			}
			else
				if(i<4){
					this.record[i+1]=p;
					System.out.println("¡Felicidades! Consiguio el"+" "+(i+1)+" "+"lugar con su puntaje.");
					return true;
				}
				else
					return false;
		}
	
	public int buscar(Puntaje p){
		int puesto=0;
		while ((puesto<5)&&(this.record[puesto].getPuntajeActual()!=p.getPuntajeActual())){
			puesto++;
		}
		return (puesto+1);
	}

}
