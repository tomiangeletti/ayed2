package Parciales.Grafos2024;
import Practicas.PRACTICA5.Edge;
import Practicas.PRACTICA5.Graph;
import Practicas.PRACTICA5.Vertex;
import java.util.*;

public class Parcial {
    public boolean nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral){
        Vertex<String> origen = red.search(usuario);
        if (origen == null){
            return false;
        }
        Queue<Vertex<String>> cola = new LinkedList<>();
        boolean[] visitados = new boolean[red.getSize()];
        int[] vecDistancia = new int[red.getSize()];
        int contador = 0;

        // Inicializar estructuras.
        visitados[origen.getPosition()] = true;
        vecDistancia[origen.getPosition()] = 0;
        cola.enqueue(origen);

        while (!cola.isEmpty()){
            Vertex<String> actual = cola.dequeue();
            for (Edge<String> arista : red.getEdges(actual)){
                Vertex<String> vecino = arista.getTarget();
                if(!visitados[vecino.getPosition()]){
                    vecDistancia[vecino.getPosition()] = vecDistancia[actual.getPosition()] + 1;
                    visitados[vecino.getPosition()] = true;
                    cola.enqueue(vecino);
                }
            }
        }
        for (int num : vecDistancia){
            if (num == distancia){
                contador++;
            }
        }
        return contador >= umbral;
    }
}
