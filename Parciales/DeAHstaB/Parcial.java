package Parciales.DeAHstaB;
import Practicas.PRACTICA5.Edge;
import Practicas.PRACTICA5.Graph;
import Practicas.PRACTICA5.Vertex;
import java.util.*;

public class Parcial {
    public List<List<String>> devolverCaminos(Graph<String> grafo, String a, String b) {
    Vertex<String> origen = grafo.search(a);
    Vertex<String> destino = grafo.search(b);

    if (origen == null || destino == null) {
        return new ArrayList<>();
    }

    boolean[] visitados = new boolean[grafo.getSize()];
    List<String> camino = new LinkedList<>();
    List<List<String>> todosLosCaminos = new LinkedList<>();

    dfs(grafo, origen, destino, visitados, camino, todosLosCaminos);

    return todosLosCaminos;
}

    private void dfs(Graph<String> grafo, Vertex<String> actual, Vertex<String> destino, boolean[] visitados, List<String> camino,List<List<String>> todosLosCaminos) {

        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());

        if (actual.equals(destino)) {
            todosLosCaminos.add(new LinkedList<>(camino));
        } else {
            for (Edge<String> arista : grafo.getEdges(actual)) {
                Vertex<String> vecino = arista.getTarget();

                if (!visitados[vecino.getPosition()]) {
                    dfs(grafo, vecino, destino, visitados, camino, todosLosCaminos);
                }
            }
        }

        camino.remove(camino.size() - 1);
        visitados[actual.getPosition()] = false;
    }
}
