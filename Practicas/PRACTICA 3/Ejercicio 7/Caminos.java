package tp3;

import java.util.List;
import java.util.LinkedList;

public class Caminos {

    private GeneralTree<Integer> a = new GeneralTree<Integer>();

    public List<Integer> caminoAHojaMasLejana() {

        List<Integer> caminoActual = new LinkedList<Integer>();
        List<Integer> mejorCamino = new LinkedList<Integer>();

        if (a == null || a.isEmpty()) {
            return mejorCamino;
        }

        helper(a, caminoActual, mejorCamino);

        return mejorCamino;
    }

    private void helper(GeneralTree<Integer> a,
                        List<Integer> caminoActual,
                        List<Integer> mejorCamino) {

        caminoActual.add(a.getData());

        if (a.isLeaf()) {

            if (caminoActual.size() > mejorCamino.size()) {
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }

        } else {

            List<GeneralTree<Integer>> hijos = a.getChildren();

            for (GeneralTree<Integer> hijo : hijos) {
                helper(hijo, caminoActual, mejorCamino);
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
    }
}
