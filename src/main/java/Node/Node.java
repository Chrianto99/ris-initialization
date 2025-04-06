package Node;

import java.util.ArrayList;

import Graph.Edge;

public class Node {

    protected int id;
    protected String type;
    private double[] position;
    private int rTableIndex;
    private int numberOfModes;
    protected transient ArrayList<Edge> inputEdges;
    protected transient ArrayList<Edge> outputEdges;

    public Node() {

    }

    public Node(String type) {
        this.type = type;
        inputEdges = new ArrayList<>();
        outputEdges = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPosition(double[] position) {
        this.position = position;

    }

    public double[] getPosition() {
        return position;
    }

    public int getNumberOfModes() {
        return numberOfModes;
    }

    public void setNumberOfModes(int numberOfModes) {
        this.numberOfModes = numberOfModes;
    }

    public int getrTableIndex() {
        return rTableIndex;
    }

    public void setrTableIndex(int rTableIndex) {
        this.rTableIndex = rTableIndex;
    }



    public ArrayList<Edge> getInputEdges() {
        return inputEdges;
    }

    public void setInputEdges(ArrayList<Edge> inputEdges) {
        this.inputEdges = inputEdges;
    }

    public ArrayList<Edge> getOutputEdges() {
        return outputEdges;
    }

    public void setOutputEdges(ArrayList<Edge> outputEdges) {
        this.outputEdges = outputEdges;
    }
}



