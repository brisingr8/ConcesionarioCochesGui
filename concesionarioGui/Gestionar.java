package concesionarioGui;

import java.io.File;

public class Gestionar {
	
	/**
	 * CONCESIONARIO
	 */
	private static Concesionario concesionario = new Concesionario();
	
	public static Concesionario getConcesionario() {
		return concesionario;
	}
	
	public static void setConcesionario(Concesionario concesionario) {
		Gestionar.concesionario = concesionario;
	}
	
	/**
	 * FICHERO
	 */
	private static File file = new File("Sin título");
	
	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		Gestionar.file = file;
	}
	
	/**
	 * MODIFICADO
	 */
	private static boolean modificado;
	
	public static boolean modificado() {
		return modificado;
	}

	public static void setModificado(boolean modificado) {
		Gestionar.modificado = modificado;
	}
}
