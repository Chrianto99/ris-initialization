package Graph;

import Node.*;

public class Edge {

    private int id;
    private int startNode_id;
    private int destNode_id;
    private double length;
    private double pathLoss;
    transient private int rTableKey;
    private double[] vector;
    private transient Node startNode;
    private transient Node destNode;


    public Edge(Node start, Node end, int idx, double length) {
        this.startNode = start;
        this.destNode = end;
        this.id = idx;
        this.length = length;
        this.startNode_id = start.getId();
        this.destNode_id = end.getId();
        vector = new double[3];


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartNode_id() {
        return startNode_id;
    }

    public void setStartNode_id(int startNode_id) {
        this.startNode_id = startNode_id;
    }

    public int getDestNode_id() {
        return destNode_id;
    }

    public void setDestNode_id(int destNode_id) {
        this.destNode_id = destNode_id;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPathLoss() {
        return pathLoss;
    }

    public void setPathLoss(double pathLoss) {
        this.pathLoss = pathLoss;
    }

    public int getRTableKey() {
        return rTableKey;
    }

    public void setRTableKey(int rTableKey) {
        this.rTableKey = rTableKey;
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getDestNode() {
        return destNode;
    }

    public void setDestNode(Node destNode) {
        this.destNode = destNode;
    }


}
