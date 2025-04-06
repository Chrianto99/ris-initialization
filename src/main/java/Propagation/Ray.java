package Propagation;

import java.util.ArrayList;

public class Ray {

    private double power;
    private double length;
    private int currentNode_id;
    private ArrayList<Integer> edges;


    public Ray(double total_power, double length, Integer edge_id, int nodeIdx) {

        this.power = total_power;
        this.length = length;
        this.currentNode_id = nodeIdx;
        edges = new ArrayList<>();
        edges.add(edge_id);


    }


}
