/**
 * 
 */
import java.util.ArrayList;
/**
 * @author Andres
 *
 */
public class Recorrido<V> implements ITreeTraversal<V> {

	public ArrayList<V> miLista = new ArrayList<V>();
	
	@Override
	public void Walk(V value) {
		miLista.add(value);
	}

}
