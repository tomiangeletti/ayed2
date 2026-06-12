package Parciales.Grafos2024v2;
import Practicas.PRACTICA5.Edge;
import Practicas.PRACTICA5.Graph;
import Practicas.PRACTICA5.Vertex;
import java.util.*;

public class Parcial {
    public String resolver(Graph<Sitio> sitios, int tiempo){
        Vertex<Sitio> origen = null;

        for (Vertex<Sitio> v : sitios.getVertices()) {
            if (v.getData().getNombre().equals("Entrada")) {
                origen = v;
                break;
            }
        }
        if (origen == null){
            return "No alcanzable";
        }
        int visitadosCont = 0;
        int tiempoCont = 0;
        boolean[] visitados = new boolean[sitios.getSize()];
        if (dfs(sitios, origen, tiempo, visitados, visitadosCont, tiempoCont)){
            return "Alcanzable";
        } else{
            return "No alcanzable";
        }
    }

    private boolean dfs(Graph<Sitio> sitios, Vertex<Sitio> actual, int tiempo, boolean[] visitados, int visitadosCont, int tiempoCont){
        visitados[actual.getPosition()] = true;
        visitadosCont++;
        tiempoCont += actual.getData().getTiempo();
        if (visitadosCont == sitios.getSize() && tiempoCont < tiempo){
            return true;
        }

        for (Edge<Sitio> arista : sitios.getEdges(actual)){
            Vertex<Sitio> vecino = arista.getTarget();
            // Sumo el tiempo del camino
            int nuevoTiempo = tiempoCont + arista.getWeight();
            if (!visitados[vecino.getPosition()] && nuevoTiempo < tiempo){
                if (dfs(sitios, vecino, tiempo, visitados, visitadosCont, nuevoTiempo)){
                    return true;
                }
            }
        }
        visitados[actual.getPosition()] = false;
        return false;
    }
}
