import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Andres Montoya
 * Test para el BinarySearchTree
 */
class BinaryTreeSearchTest {

	@Test
	void InsertOneElementTest() {
        BinarySearchTree<String, String> tree = new BinarySearchTree<String, String>(new StringComparator());
        tree.insert("hola", "test");
        assertEquals(1, tree.count());
        assertEquals("test", tree.getElements().get(0));
	}
	
	@Test
	void InsertMultipleElementsTest() {
        BinarySearchTree<String, String> tree = new BinarySearchTree<String, String>(new StringComparator());
        tree.insert("d", "cincuenta");
        tree.insert("f", "ochenta");
        tree.insert("g", "noventa");
        tree.insert("e", "sesenta");
        tree.insert("b", "veinte");
        tree.insert("a", "diez");
        tree.insert("c", "treinta");
        
        assertEquals(7, tree.count());
        
        assertEquals("diez", tree.getElements().get(0));
        assertEquals("veinte", tree.getElements().get(1));
        assertEquals("treinta", tree.getElements().get(2));
        assertEquals("cincuenta", tree.getElements().get(3));
        assertEquals("sesenta", tree.getElements().get(4));
        assertEquals("ochenta", tree.getElements().get(5));
        assertEquals("noventa", tree.getElements().get(6));
	}
	
	@Test
	void InOrderWalkTest() {
        BinarySearchTree<String, String> tree = new BinarySearchTree<String, String>(new StringComparator());
        tree.insert("d", "cincuenta");
        tree.insert("f", "ochenta");
        tree.insert("g", "noventa");
        tree.insert("e", "sesenta");
        tree.insert("b", "veinte");
        tree.insert("a", "diez");
        tree.insert("c", "treinta");
        
        assertEquals(7, tree.count());
        
        Recorrido<String> recorrido = new Recorrido<String>();
        tree.inOrder(recorrido);
        
        assertEquals("diez", recorrido.miLista.get(0));
        assertEquals("veinte", recorrido.miLista.get(1));
        assertEquals("treinta", recorrido.miLista.get(2));
        assertEquals("cincuenta", recorrido.miLista.get(3));
        assertEquals("sesenta", recorrido.miLista.get(4));
        assertEquals("ochenta", recorrido.miLista.get(5));
        assertEquals("noventa", recorrido.miLista.get(6));
	}
	
	@Test
	void DeleteOneElementTest() {
        BinarySearchTree<String, String> tree = new BinarySearchTree<String, String>(new StringComparator());
        tree.insert("hola", "test");
        assertEquals(1, tree.count());
        assertEquals("test", tree.getElements().get(0));
        tree.delete("hola");
        assertEquals(0, tree.count());
	}
}
