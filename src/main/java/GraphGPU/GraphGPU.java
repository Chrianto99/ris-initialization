package GraphGPU;

import Graph.*;
import Node.Node;

import java.util.ArrayList;
import java.util.List;

public class GraphGPU {

    public List<Edge> allEdges;
    public List<Node> allNodes;
    public List<Node> inputNodesCopy;
    public List<RoutingTable> routingTables;
    public int numberOfModes;
    public int pher;
    double alpha;
    public double roomX;
    public double roomY;

    public transient Graph g;

    public GraphGPU(Graph g){
        this.g = g;
        numberOfModes = g.numberOfModes;
        alpha = g.alpha;
        roomX = g.roomX;
        roomY = g.roomY;
        allEdges = new ArrayList<Edge>();
        allNodes = new ArrayList<Node>();
        inputNodesCopy = new ArrayList<Node>();
        routingTables = new ArrayList<>();
        CPUtoGPUFormatter cTg = new CPUtoGPUFormatter(g,this);
        cTg.convertDataToGPUFormat();


    }

    public void printRoutingTables(){

        for (RoutingTable rT : routingTables){
            System.out.println();
            rT.printRoutingTable();
        }

    }

}
