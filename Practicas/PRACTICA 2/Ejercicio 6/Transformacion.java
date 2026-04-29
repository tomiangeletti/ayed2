package tp2.ejercicio1;

public class Transformacion {
	private BinaryTree<Integer> a;
	
	private int sumaA(BinaryTree<Integer> a) {
		int izq = 0;
		int der = 0;
		
		if (a.hasLeftChild()) {
			izq += sumaA(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			der += sumaA(a.getRightChild());	
		}
		int total = a.getData() + izq + der;
		a.setData(izq + der);
		return total;
	}
	
	public BinaryTree<Integer> suma(){
		sumaA(this.a);
		return this.a;
	}
}
