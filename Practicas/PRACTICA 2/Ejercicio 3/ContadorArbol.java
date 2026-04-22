package tp2.ejercicio1;
import java.util.*;


public class ContadorArbol {
	private BinaryTree<Integer> arbol;   
	
	public ContadorArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public List<Integer> numerosParesInOrden() {
	    List<Integer> lista = new LinkedList<>();
	    inOrden(arbol, lista);
	    return lista;
	}
	
	private void inOrden(BinaryTree<Integer> a, List<Integer> lista) {
		if (a != null) {
			if (a.hasLeftChild()) {
				inOrden(a.getLeftChild(),lista);
			}
			if (a.getData() % 2 == 0) {
				lista.add(a.getData());
			}
			if (a.hasRightChild()) {
				inOrden(a.getRightChild(), lista);
			}
		}
	}
	
	public List<Integer> numerosParesPostOrden() {
	    List<Integer> lista = new LinkedList<>();
	    postOrden(arbol, lista);
	    return lista;
	}
	
	private void postOrden(BinaryTree<Integer> a, List<Integer> lista) {
		if (a != null) {
			if (a.hasLeftChild()) {
				postOrden(a.getLeftChild(), lista);
			}
			if (a.hasRightChild()) {
				postOrden(a.getRightChild(), lista);
			}
			if (a.getData() % 2 == 0) {
				lista.add(a.getData());
			}
		}
	}
	
}
