package tp3;

import java.util.List;
import java.util.Queue;

public class AnalizadorArbol {
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		double promedio;
		double cant = 0;
		double max = -1;
		if (!arbol.isEmpty()) {
			cola.enqueue(arbol);
			cola.enqueue(null);
	
		int pasadas = 0;
		while(!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> a = cola.dequeue();
			if (a != null) {
				pasadas++;
				cant  += a.getData().getTardanza();
				List<GeneralTree<AreaEmpresa>> hijos = a.getChildren();
				for (GeneralTree<AreaEmpresa> hijo : hijos) {
					cola.enqueue(hijo);
					}
				}
			else {
				if (!cola.isEmpty()) {
					cola.enqueue(null);
					promedio = cant / pasadas;
					pasadas = 0;
					cant = 0;
					if (promedio > max) {
						max = promedio;
					}
				}
			}
			}
		}
		return max;
	}
}
