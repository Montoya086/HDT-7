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
	
	public void insertWord(String Ing, String Span, String Frn) {
		IngToSpan.insert(Ing,Span);
		IngToSpan.insert(Frn,Span);
	}
}
