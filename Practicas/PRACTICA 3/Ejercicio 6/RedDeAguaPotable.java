package tp3;

import java.util.List;

public class RedDeAguaPotable {
	private GeneralTree<Character> a = new GeneralTree<Character>();
	
	public double minimoCaudal(double caudal) {
		if (a == null || a.isEmpty()) {
			return 0;
		}
		return helper(a,caudal,caudal);
	}
	
	public double helper(GeneralTree<Character> a, double min, double act) {
		if (a.isLeaf()) {
			if (act < min) {
				min = act;
			}
		}
		else {
			List<GeneralTree<Character>> hijos = a.getChildren();
			act = act / hijos.size();
			
			for(GeneralTree<Character> hijo : hijos) {
				min = helper(hijo, min, act);
			}
		}
		return min;
	}
}
