package ejercicio2;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;
import java.util.*;

public class Recorridos<T> {

    public List<T> dfs(Graph<T> grafo) {
        List<T> resultado = new ArrayList<>();
        boolean[] visitados = new boolean[grafo.getSize()];

        for (Vertex<T> v : grafo.getVertices()) {
            if (!visitados[v.getPosition()]) {
                dfsRecursivo(grafo, v, visitados, resultado);
            }
        }
        return resultado;
    }

    private void dfsRecursivo(Graph<T> grafo, Vertex<T> actual,
                               boolean[] visitados, List<T> resultado) {
        visitados[actual.getPosition()] = true;
        System.out.println("Visito: " + actual.getData());
        resultado.add(actual.getData());

        for (Edge<T> arista : grafo.getEdges(actual)) {
            Vertex<T> vecino = arista.target();
            if (!visitados[vecino.getPosition()]) {
                dfsRecursivo(grafo, vecino, visitados, resultado);
            }
        }
    }

    public List<T> bfs(Graph<T> grafo) {
        List<T> resultado = new ArrayList<>();
        boolean[] visitados = new boolean[grafo.getSize()];
        Queue<Vertex<T>> cola = new LinkedList<>();

        for (Vertex<T> v : grafo.getVertices()) {
            if (!visitados[v.getPosition()]) {
                cola.add(v);
                visitados[v.getPosition()] = true;

                while (!cola.isEmpty()) {
                    Vertex<T> actual = cola.poll();
                    System.out.println("Visito: " + actual.getData());
                    resultado.add(actual.getData());

                    for (Edge<T> arista : grafo.getEdges(actual)) {
                        Vertex<T> vecino = arista.target();
                        if (!visitados[vecino.getPosition()]) {
                            visitados[vecino.getPosition()] = true;
                            cola.add(vecino);
                        }
                    }
                }
            }
        }
        return resultado;
    }
}