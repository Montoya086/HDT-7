/**
 * 
 */

/**
 * @author Andres
 *
 */
public class Dictionary {
	BinarySearchTree<String, String> IngToSpan = new BinarySearchTree<String,String>(new StringComparator());
	BinarySearchTree<String, String> FrnToSpan = new BinarySearchTree<String,String>(new StringComparator());
	BinarySearchTree<String, String> SpanToIng = new BinarySearchTree<String,String>(new StringComparator());
	BinarySearchTree<String, String> SpanToFrn = new BinarySearchTree<String,String>(new StringComparator());
	
	public void insertWord(String Ing, String Span, String Frn) {
		IngToSpan.insert(Ing.toLowerCase(),Span.toLowerCase());
		FrnToSpan.insert(Frn.toLowerCase(),Span.toLowerCase());
		SpanToIng.insert(Span.toLowerCase(),Ing.toLowerCase());
		SpanToFrn.insert(Span.toLowerCase(),Frn.toLowerCase());
	}
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
	public String showFrnToSpan() {
		Recorrido<String> recorrido = new Recorrido<>();
		FrnToSpan.inOrder(recorrido);
		String str ="";
		for(int i=0;i<FrnToSpan.count();i++) {
			//if(SpanToFrn.find(recorrido.miLista.get(i))!=null) {
				str+="("+SpanToFrn.find(recorrido.miLista.get(i))+","+recorrido.miLista.get(i)+")";
			//}
		}
		return str;
	}
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
