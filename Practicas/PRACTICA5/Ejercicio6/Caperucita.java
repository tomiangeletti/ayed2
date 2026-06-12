package Practicas.PRACTICA5.Ejercicio6;
import Practicas.PRACTICA5.Edge;
import Practicas.PRACTICA5.Graph;
import Practicas.PRACTICA5.Vertex;
import java.util.*;

public class Caperucita {
    private Graph<String> grafo;

    public List<List<String>> recorridosMasSeguro(){
        Vertex<String> origen = grafo.search("Casa Caperucita");
        Vertex<String> destino = grafo.search("Casa Abuelita");
        if (origen == null || destino == null){
            return new ArrayList<>();
        }

        boolean[] visitados = new boolean[grafo.getSize()];
        List<String> caminoActual = new LinkedList<>();
        List<List<String>> todosLosCaminos = new LinkedList<>();
        dfs(origen, destino, visitados, caminoActual, todosLosCaminos);
        return todosLosCaminos;
    }

    private void dfs(Vertex<String> actual, Vertex<String> destino, boolean[] visitados, List<String> caminoActual, List<List<String>> todosLosCaminios){
        visitados[actual.getPosition()] = true;
        caminoActual.add(actual.getData());

        if (actual.equals(destino)){
            todosLosCaminios.add(new LinkedList<>(caminoActual));
        } else{

            for (Edge<String> arista : grafo.getEdges(actual)){
                Vertex<String> vecino = arista.getTarget();
                if (!visitados[vecino.getPosition()] && arista.getWeight() < 5){
                    dfs(vecino, destino, visitados, caminoActual, todosLosCaminios);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
        visitados[actual.getPosition()] = false;
        return;
    }
}
