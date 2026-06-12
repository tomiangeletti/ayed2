package Practicas.PRACTICA5.Ejercicio3;
import Practicas.PRACTICA5.Edge;
import Practicas.PRACTICA5.Graph;
import Practicas.PRACTICA5.Vertex;
import java.util.*;

public class caminos {
    private Graph<String> grafo;

    public caminos(Graph<String> grafo){
        this.grafo = grafo;
    }

    // Ejercicio 3.1
    public List<String> devolverCamino(String ciudad1, String ciudad2){
        // Cargamos los vertices a visitar.
        Vertex<String> origen = grafo.search(ciudad1);
        Vertex<String> destino = grafo.search(ciudad2);

        // Si no existen devolver una lista vacia.
        if (origen == null || destino == null) return new ArrayList<>();

        // Creamos la lista de visitados y del camino.
        boolean[] visitados = new boolean[grafo.getSize()];
        List<String> camino = new ArrayList<>();

        // Llamamos al metodo recursivo para recorrer el grafo en profundidad.
        if (dfsConCamino(origen, destino, visitados, camino)){
            return camino;
        }
        return new ArrayList<>();
    }

    private boolean dfsConCamino(Vertex<String> actual, Vertex<String> destino, boolean[] visitados, List<String> camino){
        // Ponemos en los visitados el nodo actual y en caminos la ciudad actual.
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());

        if (actual.equals(destino)) return true;

        // Recorremos los vertices adyacentes.
        for (Edge<String> arista: grafo.getEdges(actual)){
            Vertex<String> vecino = arista.getTarget();
            if (!visitados[vecino.getPosition()]){
                if (dfsConCamino(vecino, destino, visitados, camino)){
                    return true;
                }
            }
        }
        // Como por este camino no se llego al destino, se borra de la lista.
        camino.remove(camino.size() - 1);
        return false;
    }

    // Ejercicio 3.2

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> exceptuadas){
        Vertex<String> origen = grafo.search(ciudad1);
        Vertex<String> destino = grafo.search(ciudad2);

        if (origen == null || destino == null){
            return new ArrayList<>();
        }

        boolean[] visitados = new boolean[grafo.getSize()];
        List<String> camino = new ArrayList<>();

        if (dfsExceptuando(origen, destino, visitados, camino, exceptuadas)){
            return camino;
        }
        return new ArrayList<>();
    }

    private boolean dfsExceptuando(Vertex<String> actual, Vertex<String> destino, boolean[] visitados, List<String> camino, List<String> exceptuadas){
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());
        if (actual.equals(destino)){
            return true;
        }

        for (Edge<String> arista : grafo.getEdges(actual)){
            Vertex<String> vecino = arista.getTarget();
            if (!visitados[vecino.getPosition()] && !exceptuadas.contains(vecino.getData())){
                if (dfsExceptuando(vecino, destino, visitados, camino, exceptuadas)){
                    return true;
                }
            }
        }
        camino.remove(camino.size() - 1);
        return false;
    }

    // Ejercicio 3.3
    public boolean existeCamino(String ciudad1, String ciudad2){
        Vertex<String> origen = grafo.search(ciudad1);
        Vertex<String> destino = grafo.search(ciudad2);

        if (origen == null || destino == null){
            return false;
        }
        boolean[] visitados = new boolean[grafo.getSize()];
        if (dfs(origen, destino, visitados)){
            return true;
        }
        return false;
    }

    private boolean dfs(Vertex<String> actual, Vertex<String> destino, boolean[] visitados){
        visitados[actual.getPosition()] = true;
        if (actual.equals(destino)){
            return true;
        }

        for (Edge<String> arista : grafo.getEdges(actual)){
            Vertex<String> vecino = arista.getTarget();
            if (!visitados[vecino.getPosition()]){
                if(dfs(vecino, destino, visitados)){
                    return true;
                }
            }
        }
        return false;
    }

    // Ejercicio 3.4
    public List<String> devolverCaminoMasCorto(String ciudad1, String ciudad2){
        Vertex<String> origen = grafo.search(ciudad1);
        Vertex<String> destino = grafo.search(ciudad2);
        
        if (origen == null || destino == null){
            return new ArrayList<>();
        }
        boolean[] visitados = new boolean[grafo.getSize()];

        return bfs(origen, destino, visitados);
    }

    private List<String> bfs(Vertex<String> origen, Vertex<String> destino, boolean[] visitados) {
    Queue<List<String>> cola = new LinkedList<>();

    List<String> caminoInicial = new ArrayList<>();
    caminoInicial.add(origen.getData());
    cola.add(caminoInicial);
    visitados[origen.getPosition()] = true;

    while (!cola.isEmpty()) {
        List<String> caminoActual = cola.poll();
        String ultimaCiudad = caminoActual.get(caminoActual.size() - 1);
        Vertex<String> actual = grafo.search(ultimaCiudad);

        if (actual.equals(destino)) {
            return caminoActual;
        }

        for (Edge<String> arista : grafo.getEdges(actual)) {
            Vertex<String> vecino = arista.getTarget();
            if (!visitados[vecino.getPosition()]) {
                visitados[vecino.getPosition()] = true;
                List<String> nuevoCamino = new ArrayList<>(caminoActual);
                nuevoCamino.add(vecino.getData());
                cola.add(nuevoCamino);
            }
        }
    }
    return new ArrayList<>();
}
}
