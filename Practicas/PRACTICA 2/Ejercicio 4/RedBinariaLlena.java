package tp2.ejercicio1;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;

	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		return retardoMaximo(arbol);
	}
	

	private int retardoMaximo(BinaryTree<Integer> a) {
	    // Un poco de ayuda de chat pero mi idea al principio era buena :)
	    // Caso base:
	    // Si el nodo es null, no hay camino → el aporte a la suma es 0
	    if (a == null) {
	        return 0;
	    }

	    // Llamada recursiva al subárbol izquierdo:
	    // Calcula el mayor retardo posible desde el hijo izquierdo hasta alguna hoja
	    int izq = retardoMaximo(a.getLeftChild());

	    // Llamada recursiva al subárbol derecho:
	    // Calcula el mayor retardo posible desde el hijo derecho hasta alguna hoja
	    int der = retardoMaximo(a.getRightChild());

	    // Comparación de los dos caminos posibles:
	    // Elegimos el subárbol que tenga mayor suma total de retardos
	    if (izq > der) {
	        // Si el camino izquierdo es mejor,
	        // sumamos el valor del nodo actual + lo mejor del izquierdo
	        return a.getData() + izq;
	    } else {
	        // Si el derecho es mejor (o igual),
	        // sumamos el valor del nodo actual + lo mejor del derecho
	        return a.getData() + der;
	    }
	}
}
