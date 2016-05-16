package concesionarioGui;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * No pueden existir dos coches con la misma matr�cula en el almac�n del concesinario
 * no puede a�adirse un coche al concecionario con alguno de sus atributos inv�lidos. Han de conocerse todas sus caracter�sticas 
 * Ninguno de los valores puede ser por defecto
 */
/**
 * Representa un concesionario de coches.
 * 
 * L�gicamente, no podr� a�adirse un coche inv�lido almac�n del concesinario)
 * 
 * Han de conocerse todas sus caracter�sticas Ninguno de los valores puede ser
 * por defecto
 * 
 * @author Mar�aLourdes
 * 
 */
public class Concesionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Almac�n de los coches del concesionario
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capit�n";

	// P:Por qu� no se necesita que annadir devuelva boolean??????
	// P:Por qu� no se especifican todas las excepciones de forma
	// expl�cita??????
	/**
	 * A�ade un coche al concesinario
	 * 
	 * @param matricula
	 *            Matr�cula del coche a a�adir
	 * @param color
	 *            Color del coche a a�adir
	 * @param modelo
	 *            Modelo del coche a a�adir
	 * @throws Exception
	 *             Si no se ha podido a�adir el coche al concesionario, porque
	 *             ya hay otro con la misma matr�cula o porque faltan datos
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
	 * Devuelve el n�mero de coches en el almac�n del concesionario
	 * 
	 * @return N�mero de coches en el almac�n del concesionario
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
		// P: qu� sucede si el coche no est� en el concesionario?

		try {
			return almacen.get(almacen.indexOf(new Coche(matricula)));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CocheNoExisteException("El coche no est� en el concesionario.");
		}

		// }
		// return null;
	}

	/**
	 * Devuelve el coche indicado por el �ndice
	 * 
	 * @param index
	 *            Representa el �ndice a buscar
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
