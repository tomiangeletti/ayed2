package Practicas.PRACTICA5.Ejercicio5;
import Practicas.PRACTICA5.Edge;
import Practicas.PRACTICA5.Graph;
import Practicas.PRACTICA5.Vertex;
import java.util.*;

public class Banco {

    public List<Persona> retornarJubilados(Graph<Persona> grafo, Persona empleado, int distancia){
        Vertex<Persona> casaEmpleado = grafo.search(empleado);
        Queue<Vertex<Persona>> cola = new LinkedList<>();
        Queue<Integer> distancias = new LinkedList<>();
        List<Persona> jubilados = new LinkedList<>();
        int distAct;

        boolean[] visitados = new boolean[grafo.getSize()];
        cola.add(casaEmpleado);
        distancias.add(0);
        visitados[casaEmpleado.getPosition()] = true;

        while(!cola.isEmpty()){
            Vertex<Persona> actual = cola.poll();
            distAct = distancias.poll();
            if (distAct > distancia){
                break;
            }
            if (actual.getData().esJubilado() && actual.getData().percibioPago() && jubilados.size() < 40){
                jubilados.add(actual.getData());
            }
            for (Edge<Persona> arista : grafo.getEdges(actual)) {
                Vertex<Persona> vecino = arista.getTarget();
                if (!visitados[vecino.getPosition()]) {
                    visitados[vecino.getPosition()] = true;
                    cola.add(vecino);
                    distancias.add(distAct + 1);
                }
            }       
        }
        return jubilados;
    }
}
