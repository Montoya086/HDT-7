/**
 * 
 */
import java.util.ArrayList;
/**
 * interface Binary Search Tree
 * @author Andrés Montoya
 * @version 1.0    2/04/2022
 * Interfaz de los arboles de busqueda
 * Recuerado de: https://github.com/malonso-uvg/ADT_Ejemplos 
 */
public interface IBinarySearchTree<K,V> {
	/**
	 * Metodo para insertar valores al arbol
	 * @param id key
	 * @param value valor
	 */
	void insert(K id, V value);
	
	/**
	 * Metodo para borrar un valor del arbol
	 * @param id key del valor a eliminar
	 * @return valor borrado
	 */
	V delete(K id);
	
	/**
	 * Metodo que permite buscar un valor por medio de su key
	 * @param id key que se desea buscar
	 * @return valor
	 */
	V find(K id);
	
	/**
	 * Metodo que permite dar la cantidad de objetos que hay en el arbol
	 * @return tamaño del arbol
	 */
	int count();
	
	/**
	 * 
	 * @return True si esta vacio y false en caso contrario
	 */
	boolean isEmpty();
	
	/**
	 * Metodo que regresa un listado de los elementos
	 * @return listado de elementos
	 */
	ArrayList<V> getElements();
	
	/**
	 * Regresa valores en orden
	 * @param traversal
	 */
	void inOrder(ITreeTraversal<V> traversal);
	
	/**
	 * Regresa valores pre orden
	 * @param traversal
	 */
	void preOrder(ITreeTraversal<V> traversal);
	
	/**
	 * Regresa valores post orden
	 * @param traversal
	 */
	void postOrder(ITreeTraversal<V> traversal);
}
