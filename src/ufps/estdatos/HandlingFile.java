package ufps.estdatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HandlingFile {

	/**
	 * Este metodo se encarga de abrir un archivo de texto
	 * y leer el contenido. Use este metodo mediante la invocacion:
	 * HandlingFile.readFile("archivo.txt");
	 * @param filePath ruta completa del archivo de texto, incluida la extension del archivo.
	 * @return String contenido del archivo incluyendo saltos de linea.
	 */
	public static String readFile(String filePath) throws Exception {
		String fileContent = "";
		
		// Se busca el archivo para abrirlo
		File file = new File(filePath);
		
		// Se valida que el archivo exista, y que en efecto sea un archivo.
		if(file.exists() && file.isFile()) {
		
			// Se crea el objeto de la clase BufferedReader.
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String st = br.readLine();
			
			while (st != null) {
				// Se concatena el contenido
				fileContent += st;
				// Se concatena el salto de linea
				fileContent += "\n";
				// Se lee la siguiente linea
				st = br.readLine();
			}
			
		}
		
		return fileContent;
	}
	
	public static void writeFile(String filePath, String content) {
		
	}
	
}
