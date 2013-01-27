package my.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertex {

    private int number;

    private boolean visited = false;

    private int distance = Integer.MAX_VALUE;

    private int prev = -1;

    private List<VertexConnection> connections = new ArrayList<>();

    public Vertex(int number) {
        this.number = number;
    }

    @Override
    public java.lang.String toString() {
        return "{number=" + number + ", distance=" + distance + ", prev=" + prev + "}";
    }

    public List<VertexConnection> getConnections() {
        return connections;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNumber() {
        return number;
    }
}
