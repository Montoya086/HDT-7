/**
 * 
 */

/**
 * Clase Dictionary
 * @author Andrés Montoya
 * @version 1.0    2/04/2022
 * Clase diccionario que permite el uso de arboles de busqueda
 */
public class Dictionary {
	BinarySearchTree<String, String> IngToSpan = new BinarySearchTree<String,String>(new StringComparator());
	BinarySearchTree<String, String> FrnToSpan = new BinarySearchTree<String,String>(new StringComparator());
	BinarySearchTree<String, String> SpanToIng = new BinarySearchTree<String,String>(new StringComparator());
	BinarySearchTree<String, String> SpanToFrn = new BinarySearchTree<String,String>(new StringComparator());
	
	/**
	 * Metodo que permite el ingreso de nuevas palabras a los diccionarios
	 * @param Ing palabra en ingles
	 * @param Span palabra en español
	 * @param Frn palabra en frances
	 */
	public void insertWord(String Ing, String Span, String Frn) {
		IngToSpan.insert(Ing.toLowerCase(),Span.toLowerCase());
		FrnToSpan.insert(Frn.toLowerCase(),Span.toLowerCase());
		SpanToIng.insert(Span.toLowerCase(),Ing.toLowerCase());
		SpanToFrn.insert(Span.toLowerCase(),Frn.toLowerCase());
	}
	
	/**
	 * Metodo que muestra el diccionario de ingles-español en orden de ingles
	 * @return lista de palabras en ingles y español
	 */
	public String showIngToSpan() {
		Recorrido<String> recorrido = new Recorrido<>();
		IngToSpan.inOrder(recorrido);
		String str ="";
		for(int i=0;i<IngToSpan.count();i++) {
			//if(SpanToIng.find(recorrido.miLista.get(i))!=null) {
				str+="("+SpanToIng.find(recorrido.miLista.get(i))+","+recorrido.miLista.get(i)+")";
			//}
		}
		return str;
	}
	
	/**
	 * Metodo que muestra el diccionario de frances-español en orden de frances
	 * @return lista de palabras en frances y español
	 */
	public String showFrnToSpan() {
		Recorrido<String> recorrido = new Recorrido<>();
		FrnToSpan.inOrder(recorrido);
		String str ="";
		for(int i=0;i<FrnToSpan.count();i++) {
			str+="("+SpanToFrn.find(recorrido.miLista.get(i))+","+recorrido.miLista.get(i)+")";
		}
		return str;
	}
	/**
	 * Metodo que permite la eliminacion de una palabra del diccionario ingresada en cualquiera de los 3 idiomas
	 * @param word palabra a eliminar (en cualquiera de los 3 idiomas)
	 * @return palabra en ingles que fue eliminada
	 */
	public String deleteWord(String word) {
		String ingWord="";
		String spanWord="";
		String frnWord="";
		if(IngToSpan.find(word)!=null) {
			ingWord=word;
			spanWord=IngToSpan.find(word);
			frnWord=SpanToFrn.find(spanWord);
			IngToSpan.delete(ingWord);
			FrnToSpan.delete(frnWord);
			SpanToFrn.delete(spanWord);
			SpanToIng.delete(spanWord);
		}else if (FrnToSpan.find(word)!=null){
			frnWord=word;
			spanWord=FrnToSpan.find(word);
			ingWord=SpanToIng.find(spanWord);
			IngToSpan.delete(ingWord);
			FrnToSpan.delete(frnWord);
			SpanToFrn.delete(spanWord);
			SpanToIng.delete(spanWord);
		}else if(SpanToIng.find(word)!=null) {
			spanWord=word;
			frnWord=SpanToFrn.find(word);
			ingWord=SpanToIng.find(word);
			IngToSpan.delete(ingWord);
			FrnToSpan.delete(frnWord);
			SpanToFrn.delete(spanWord);
			SpanToIng.delete(spanWord);
		}else {
			ingWord=null;
		}
		return ingWord;
	}
	/**
	 * Metodo de busqueda de una palabra en cualquiera de los tres idiomas
	 * @param word palabra para ser buscada
	 * @return palabra en ingles
	 */
	public String searchWord(String word) {
		String ingWord="";
		String spanWord="";
		String frnWord="";
		if(IngToSpan.find(word)!=null) {
			ingWord=word;
			spanWord=IngToSpan.find(word);
			frnWord=SpanToFrn.find(spanWord);
		}else if (FrnToSpan.find(word)!=null){
			frnWord=word;
			spanWord=FrnToSpan.find(word);
			ingWord=SpanToIng.find(spanWord);
		}else if(SpanToIng.find(word)!=null) {
			spanWord=word;
			frnWord=SpanToFrn.find(word);
			ingWord=SpanToIng.find(word);
		}else {
			spanWord=null;
		}
		return spanWord;
	}
}
