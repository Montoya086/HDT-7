/**
 * 
 */
import java.util.ArrayList;
/**
 * Clase Recorrido
 * @author Andrés Montoya
 * @version 1.0    2/04/2022
 * Recuerado de: https://github.com/malonso-uvg/ADT_Ejemplos 
 */
public class Recorrido<V> implements ITreeTraversal<V> {

	public ArrayList<V> miLista = new ArrayList<V>();
	
	@Override
	public void Walk(V value) {
		miLista.add(value);
	}

}
