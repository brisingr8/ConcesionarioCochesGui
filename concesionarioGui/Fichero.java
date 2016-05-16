package concesionarioGui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author alvaro
 *
 */
public class Fichero {

	/**
	 * METODO QUE ABRE UN CONCESIONARIO A PARTIR DE UN FICHERO
	 * 
	 * @param file archivo
	 * @return concesionario
	 * @throws ClassNotFoundException excepcion
	 * @throws IOException excepcion
	 */
	public static Concesionario abrir(File file) throws ClassNotFoundException, IOException {
		file = comprobarExtension(file);
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			return (Concesionario) in.readObject();
		}
	}

	/**
	 * METODO QUE GUARDA EL CONCESIONARIO EN UN FICHERO
	 * 
	 * @param file archivo
	 * @param concesionario concesionario
	 * @throws IOException excepcion
	 */
	public static void guardar(File file, Concesionario concesionario) throws IOException {
		file = comprobarExtension(file);
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			out.writeObject(concesionario);
		}
	}

	/**
	 * METODO QUE COMPRUEBA SI EXISTE EL FICHERO
	 * 
	 * @param file archivo
	 * @return archivo
	 */
	public static boolean existe(File file) {
		file = comprobarExtension(file);
		return file.exists();
	}

	/**
	 * METODO PARA COMPROBAR LA EXTENSION DEL FICHERO
	 * 
	 * @param file archivo
	 * @return archivo
	 */
	static File comprobarExtension(File file) {
		String path = file.getPath();
		if (!path.endsWith(".obj"))
			return new File(path + ".obj");
		return file;
	}

}
