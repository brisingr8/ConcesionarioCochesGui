package concesionarioGui;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * No pueden existir dos coches con la misma matrícula en el almacén del concesinario
 * no puede añadirse un coche al concecionario con alguno de sus atributos inválidos. Han de conocerse todas sus características 
 * Ninguno de los valores puede ser por defecto
 */
/**
 * Representa un concesionario de coches.
 * 
 * Lógicamente, no podrá añadirse un coche inválido almacén del concesinario)
 * 
 * Han de conocerse todas sus características Ninguno de los valores puede ser
 * por defecto
 * 
 * @author MaríaLourdes
 * 
 */
public class Concesionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Almacén de los coches del concesionario
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capitán";

	// P:Por qué no se necesita que annadir devuelva boolean??????
	// P:Por qué no se especifican todas las excepciones de forma
	// explícita??????
	/**
	 * Añade un coche al concesinario
	 * 
	 * @param matricula
	 *            Matrícula del coche a añadir
	 * @param color
	 *            Color del coche a añadir
	 * @param modelo
	 *            Modelo del coche a añadir
	 * @throws Exception
	 *             Si no se ha podido añadir el coche al concesionario, porque
	 *             ya hay otro con la misma matrícula o porque faltan datos
	 */
	public void annadir(String matricula, Color color, Modelo modelo) throws Exception {
		// Coche coche = Coche.instanciarCoche(matricula, color, modelo);

		// if (coche == null || almacen.contains(coche))
		// return false;
		// return almacen.add(coche);
		Coche coche = new Coche(matricula, color, modelo);
		if (!almacen.contains(coche))
			almacen.add(coche);
		else
			throw new CocheYaExisteException("El coche ya existe en el concesionario. ");
	}
	
	/**
	 * elimina coche
	 * 
	 * @param matricula matricula
	 * @return booleano
	 * @throws MatriculaNoValidaException excepcion
	 * @throws CocheNoExisteException excepcion
	 */
	public boolean eliminar(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		Coche coche = new Coche(matricula);
		if (!almacen.contains(coche))
			throw new CocheNoExisteException("El coche no existe.");
		return almacen.remove(coche);
	}

	/**
	 * modifica coche del concesionario
	 * 
	 * @param coche coche
	 * @param color color
	 * @return coche modificado
	 * @throws Exception excepcion
	 */

	// boolean modificar(String matricula, Color color) throws
	// MatriculaNoValidaException, CocheNoExisteException {
	// boolean flag=false;
	// String auxMatricula = null;
	// Color auxColor = null;
	// Modelo auxModelo = null;
	//
	// Coche coche = new Coche(matricula);
	// if (!almacen.contains(coche))
	// throw new CocheNoExisteException("El coche no existe.");
	// try{
	// for(int i=0; i<almacen.size(); i++){
	// if(almacen.get(i).getMatricula().equals(matricula)){
	// auxMatricula=almacen.get(i).getMatricula();
	// auxColor=color;
	// auxModelo=almacen.get(i).getModelo();
	// almacen.se
	// }
	// }
	//
	// eliminar(matricula);
	//
	// annadir(auxMatricula, auxColor, auxModelo);
	//
	// flag = true;
	// }catch(Exception e){
	// System.out.println("No se ha podido cambiar el color.");
	// }
	// return flag;
	// }

//	public boolean modificar1(String matricula, Color color) throws Exception {
//		try {
//			int index = almacen.indexOf(new Coche(matricula));
//			System.out.println(almacen.get(index));
//			Coche cocheModificado = new Coche(matricula, color, almacen.get(index).getModelo());
//			almacen.set(index, cocheModificado);
//			//System.out.println(almacen.get(index));
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
	public boolean modificar(Coche coche, Color color) throws Exception {
		try {
			coche.setColor(color);
		//	int index = almacen.indexOf(coche);
			almacen.set(almacen.indexOf(coche), coche);
			//System.out.println(almacen.get(index));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int index(Coche coche){
		return almacen.indexOf(coche);
		//return index;
	}
	
	public Coche anterior(int index)throws Exception{
		return almacen.get(index-1);
	}
	
	public Coche posterior(int index)throws Exception{
		return almacen.get(index+1);
	}

	/**
	 * Devuelve el número de coches en el almacén del concesionario
	 * 
	 * @return Número de coches en el almacén del concesionario
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * devuelve coche del almacen
	 * 
	 * @param matricula matricula
	 * @return coche
	 * @throws MatriculaNoValidaException excepcion
	 * @throws CocheNoExisteException excepcion
	 */
	public Coche get(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		// Coche coche = Coche.instanciarCoche(matricula);
		// int index = almacen.indexOf(new Coche(matricula));
		// if (index != -1) {
		// P: qué sucede si el coche no está en el concesionario?

		try {
			return almacen.get(almacen.indexOf(new Coche(matricula)));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CocheNoExisteException("El coche no está en el concesionario.");
		}

		// }
		// return null;
	}

	/**
	 * Devuelve el coche indicado por el índice
	 * 
	 * @param index
	 *            Representa el índice a buscar
	 * @return Coche contenido en el almacen. null si no existe
	 */
	public Coche get(int index) {
		if (almacen.isEmpty())
			return null;
		if (index < 0 | index > almacen.size() - 1)
			return null;
		return almacen.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}
}
