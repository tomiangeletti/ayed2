package Practicas.PRACTICA5.Ejercicio4;
import Practicas.PRACTICA5.Edge;
import Practicas.PRACTICA5.Graph;
import Practicas.PRACTICA5.Vertex;
import java.util.*;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        Vertex<String> origen = lugares.search("Ayuntamiento");
        Vertex<String> fin = lugares.search(destino);
        int tiempo = 0;

        if (origen == null || fin == null){
            return new ArrayList<>();
        }
        boolean[] visitados = new boolean[lugares.getSize()];
        List<String> camino = new LinkedList<>();
        if (dfs(lugares, origen, fin, visitados, lugaresRestringidos, maxTiempo, camino, tiempo)){
            return camino;
        }
        return new ArrayList<>();
    }

    private boolean dfs(Graph<String> lugares, Vertex<String> actual, Vertex<String> destino, boolean[] visitados, List<String> lugaresRestringidos, int tiempoMax, List<String> camino, int tiempo){
        camino.add(actual.getData());
        visitados[actual.getPosition()] = true;
        if(actual.equals(destino)){
            return true;
        }
        for (Edge<String> arista : lugares.getEdges(actual)){
            Vertex<String> vecino = arista.getTarget();
            if (!visitados[vecino.getPosition()] && tiempo + arista.getWeight() <= tiempoMax && !lugaresRestringidos.contains(vecino.getData())){
                if (dfs(lugares, vecino, destino, visitados, lugaresRestringidos, tiempoMax, camino, tiempo + arista.getWeight())){
                    return true;
                }
            }
        }
        camino.remove(camino.size() - 1);
        return false;
    }
}
