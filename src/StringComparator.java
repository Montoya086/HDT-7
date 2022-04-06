/**
 * 
 */
import java.util.Comparator;
/**
 * Clase String comparator
 * @author Andrés Montoya
 * @version 1.0    2/04/2022
 * Clase encargada de comparar strings
 */
public class StringComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

	
}
