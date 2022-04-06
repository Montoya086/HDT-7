import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Clase Main
 * @author Andrés Montoya
 * @version 1.0    2/04/2022
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
			System.out.println("5. Leer y traducir arhivo");
			System.out.println("6. Salir");
			opt = Integer.parseInt(scanner.nextLine());
			switch (opt) {
			case 1: //mostrar diccionario ingles-español
				System.out.println("\n---**---");
				System.out.println(dictionary.showIngToSpan());
				System.out.println("---**---\n");
				break;
			case 2: //mostrar diccionario frances-español
				System.out.println("\n---**---");
				System.out.println(dictionary.showFrnToSpan());
				System.out.println("---**---\n");
				break;
			case 3: //agregar palabra al diccionario
				System.out.println("\n---**---");
				System.out.println("Ingrese la palaba en el formato Ingles,Español,Frances");
				String wordString = scanner.nextLine();
				String[] validStrings = wordString.split(",");
				if(validStrings.length==3) {
					dictArrayList.add(wordString);
					dictionary.insertWord(validStrings[0], validStrings[1], validStrings[2]);
					saveFile(dictArrayList);
					System.out.println("Palabra agregada");
				}else {
					System.out.println("La palabra no esta en formato correcto");
				}
				System.out.println("---**---\n");
				break;
			case 4: //eliminar palabra del diccionario
				System.out.println("\n---**---");
				System.out.println("Ingrese la palaba que desea borrar");
				String word_delete = scanner.nextLine().toLowerCase();
				String ing_word_delete=dictionary.deleteWord(word_delete);
				if(ing_word_delete==null) {
					System.out.println("La palabra no existe");
				}else {
					for(int i=0;i<dictArrayList.size();i++) {
						String[] tempStrings = dictArrayList.get(i).split(",");
						if(tempStrings[0].equals(ing_word_delete)) {
							dictArrayList.remove(i);
						}
					}
					saveFile(dictArrayList);
					System.out.println("Palabra borrada");	
				}
				System.out.println("---**---\n");
				break;
			case 5: //leer y traducir archivo 
				try {
					FileReader r = new FileReader("texto.txt");
					BufferedReader br = new BufferedReader(r);
					String line;
					while((line=br.readLine())!=null){
						String prntString ="";
						line=line.replace(".", "");
						line=line.replace(",", "");
						line=line.replace(";", "");
						line=line.replace(":", "");
						String[] wordStrings = line.split(" ");
						for(int i =0;i<wordStrings.length;i++) {
							if(dictionary.searchWord(wordStrings[i])!=null) {
								wordStrings[i]=dictionary.searchWord(wordStrings[i]);
							}else {
								wordStrings[i]="*"+wordStrings[i]+"*";
							}
							prntString+=wordStrings[i]+" ";
						}
						System.out.println(prntString);
					}
					br.close();
				}catch(IOException e) {
					System.out.println("Ha ocurrido una excepcion de tipo IO: "+e);
				}
				break;
			case 6: //salir
				salir = true;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}
		}
	}
	/**
	 * Metodo que permite sobreescribir un archivo
	 * @param words lineas del archivo
	 */
	private static void saveFile(ArrayList<String> words) {
		try {
			//Sobreescribe el archivo
			BufferedWriter bw = new BufferedWriter(new FileWriter("diccionario.txt"));
			for(int i=0;i<words.size();i++) {
				bw.write(words.get(i)+"\n");
			}
				bw.close();
		}catch (Exception e) {
			System.out.println("Ha ocurrido un error de tipo: "+e);
		}
	}


}
