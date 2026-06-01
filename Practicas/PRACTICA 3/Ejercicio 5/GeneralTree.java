package tp3;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
			
		return 0;
	}
	
	public int nivel(T dato){
		return 0;
	  }

	public int ancho(){
		
		return 0;
	}
	public boolean esAncestro(T a, T b) {
		if (this == null || this.isEmpty()) {
			return false;
		}
		return helper(a,b,this);
	}
	
	private boolean helper(T a, T b, GeneralTree<T> arbol) {

	    // Si encontré el nodo "a"
	    if (arbol.getData().equals(a)) {
	        return buscarDescendiente(b, arbol);
	    }

	    // Seguir buscando "a" en los hijos
	    for (GeneralTree<T> hijo : arbol.getChildren()) {
	        if (helper(a, b, hijo)) {
	            return true;
	        }
	    }

	    return false;
	}
	
	private boolean buscarDescendiente(T b, GeneralTree<T> arbol) {
		if (arbol.getData() == b) {
			return true;
		}
		for (GeneralTree<T> hijo : arbol.getChildren()) {
	        if (buscarDescendiente(b, hijo)) {
	            return true;
	   }
	   return false;
	}
}