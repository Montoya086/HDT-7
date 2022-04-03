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
	Recorrido<String> recorrido = new Recorrido<>();
	public void insertWord(String Ing, String Span, String Frn) {
		IngToSpan.insert(Ing,Span);
		FrnToSpan.insert(Frn,Span);
		SpanToIng.insert(Span,Ing);
		SpanToFrn.insert(Span,Frn);
	}
	public String showIngToSpan() {
		IngToSpan.inOrder(recorrido);
		String str ="";
		for(int i=0;i<IngToSpan.count();i++) {
			str+="("+SpanToIng.find(recorrido.miLista.get(i))+","+recorrido.miLista.get(i)+")";
		}
		return str;
	}
	public String showFrnToSpan() {
		FrnToSpan.inOrder(recorrido);
		String str ="";
		for(int i=0;i<FrnToSpan.count();i++) {
			str+="("+SpanToFrn.find(recorrido.miLista.get(i))+","+recorrido.miLista.get(i)+")";
		}
		return str;
	}
}
