import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Andres
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean salir =false;
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> dictArrayList = new ArrayList<String>();
		Dictionary dictionary = new Dictionary();
		try {
			FileReader r = new FileReader("diccionario.txt");
			BufferedReader br = new BufferedReader(r);
			String line;
			while((line=br.readLine())!=null){
				dictArrayList.add(line);
				String[] values = line.split(",");
				dictionary.insertWord(values[0], values[1], values[2]);
			}
			br.close();
		}catch(IOException e) {
			System.out.println("Ha ocurrido una excepcion de tipo IO: "+e);
		}
		while(!salir) {
			int opt =0;
			System.out.println("1. Mostrar Diccionario Ingles-Español");
			System.out.println("2. Mostrar Diccionario Frances-Español");
			System.out.println("3. Agregar palabra al diccionario");
			System.out.println("4. Borrar palabra del diccionario");
			System.out.println("5. Leer arhivo");
			System.out.println("6. Salir");
			opt = Integer.parseInt(scanner.nextLine());
			switch (opt) {
			case 1: 
				System.out.println("\n---**---");
				System.out.println(dictionary.showIngToSpan());
				System.out.println("---**---\n");
				break;
			case 2: 
				System.out.println("\n---**---");
				System.out.println(dictionary.showFrnToSpan());
				System.out.println("---**---\n");
				break;
			case 3: 
				System.out.println("\n---**---");
				System.out.println("Ingrese la palaba en el formato Ingles,Español,Frances");
				String wordString = scanner.nextLine();
				String[] validStrings = wordString.split(",");
				if(validStrings.length==3) {
					dictArrayList.add(wordString);
					dictionary.insertWord(validStrings[0], validStrings[1], validStrings[2]);
					System.out.println("Palabra agregada");
				}else {
					System.out.println("La palabra no esta en formato correcto");
				}
				System.out.println("\n---**---");
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				salir = true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}
		}
	}

}
