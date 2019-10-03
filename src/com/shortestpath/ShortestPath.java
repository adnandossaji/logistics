package com.shortestpath;

//import com.graph.DijkstraAlgorithm;
//import com.graph.Edge;
//import com.graph.Vertex;
//import com.graph.Graph;
import com.graph.DijkstraAlgorithm;
import com.graph.Edge;
import com.graph.Graph;
import com.graph.Vertex;
import com.order.OrderImpl;
import com.travel.Time;
import com.facility.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class ShortestPath {
    private int sourceId, destinationId;
    private static List<Vertex> nodes;
    private static List<Edge> edges;

    public static int shortestPath(HashMap<String, FacilityImpl> facilities, String source, String destination) throws NullPointerException{
        int sourceId = 0;
        int destinationId = 0;

        Iterator entries = facilities.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            String key = (String) thisEntry.getKey();
            FacilityImpl value = (FacilityImpl) thisEntry.getValue();
            if (value.getName().equals(source)) {
                sourceId = value.getId();
            }
            if (value.getName().equals(destination)) {
                destinationId = value.getId();
            }
        }

        shortestPathHelper(facilities, sourceId, destinationId);

        return 0;
    }

    private static void shortestPathHelper(HashMap<String, FacilityImpl> facilities, int source, int destination) {
        int distance = 0;

        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 18; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        Iterator entries = facilities.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            String key = (String) thisEntry.getKey();
            FacilityImpl value = (FacilityImpl) thisEntry.getValue();

            Iterator<NeighborImpl> itr2 = value.getNeighbors().iterator();
            while (itr2.hasNext()) {
                Neighbor element2 = itr2.next();
                addLane(element2.getName(), value.getId(), element2.getId(), element2.getDistance());

            }
        }

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(source));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(destination));
        LinkedList<Integer> pathInt = new LinkedList<Integer>();

        for (Vertex vertex : path) {
            if (vertex != null){
                int vert = Integer.parseInt(vertex.toString().substring(5, vertex.toString().length()));
                pathInt.add(vert);
        }}

        distance = Time.calculateDistance(facilities, pathInt);

        System.out.println(Time.travelTime(distance) + " day(s)");
    }

    public static void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}
