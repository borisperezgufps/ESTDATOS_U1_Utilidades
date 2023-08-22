package ufps.estados.prueba;

import ufps.estdatos.HandlingFile;

public class Test {

	public static void main(String[] args)  {
		try {
			String contenidoArchivo = HandlingFile.readFile("Clientes.txt");
			
			System.out.println("*** Uso 1. Impresión de todo el contenido del archivo\n");
			System.out.println(contenidoArchivo);
			
			System.out.println("*** Uso 2. Impresión del contenido por lineas\n");
			// Use el método String.split() para separar las cadenas de texto que vienen con separadores.
			// Por ejemplo:
			String[] lineasContenido = contenidoArchivo.split("\\n");
			for(String linea : lineasContenido) {
				// Se esta manera se puede procesar cada linea del archivo.
				System.out.println(linea);
			}
			
			// Supongo ahora que quiere llenar un arreglo de objetos con los datos de cada linea.
			// Asuma que cada linea tiene el nombre, apellido y saldo bancario de un cliente.
			// Se usará el arreglo lineasContenido creado en el Uso 2.
			
			
			System.out.println("\n*** Uso 3. Conversión de contenido a objetos.\n");
			
			ClienteBanco[] clientes = new ClienteBanco[lineasContenido.length]; // Se crea del mismo tamaño
			
			// Se usará como contador para guardar las posiciones en clientes.
			int i = 0; 
			
			// Se recorre el arreglo lineasContenido
			for(String linea : lineasContenido) {
				// Se valida que la linea no esté vacía. Puede pasar que la última línea se deja en blanco, y
				// se lee y se agrega. 
				if(!linea.isEmpty()) {
					// Se toma cada linea, cuyos datos están separados por una barra vertical
					// y se divide usando split. Como parámetro se pasa el caracter por el cual
					// se separan los datos.
					String[] detalleLinea = linea.split("\\|");
					// Si todo salió bien, en la posición 0 del arreglo detalleLinea irá el primer valor.
					// En la posición 1 del arreglo detalleLinea irá el segundo valor.
					// De acuerdo con el archivo Clientes.txt, en la posición 0 irá Carlos, en la posición 1 irá Ramirez
					// y en la posición 2 irá 25000.
					
					// La idea es tomar cada posición del arreglo y enviarlo a un atributo del objeto clientes,
					// que es el arreglo de objetos ClienteBanco.
					
					ClienteBanco cb = new ClienteBanco();
					cb.setNombre(detalleLinea[0]);
					cb.setApellido(detalleLinea[1]);
					// Como todo se retorna en String, se debe convertir a Double.
					cb.setSaldo(Double.parseDouble(detalleLinea[2])); 
					
					clientes[i] = cb;
					i++;
					
				}
			}
			
			// A continuación se imprimirán solo los nombres de los clientes y su saldo.
			for(ClienteBanco cli : clientes) {
				System.out.println(cli.getNombre() + " - " + cli.getSaldo());
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
