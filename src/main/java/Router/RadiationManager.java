package Router;

import java.util.*;

import Node.Node;
import Propagation.Ray;
import Graph.*;

public class RadiationManager {

    Graph g;
    ArrayList<Ray> rays = new ArrayList<Ray>();
    Random rand = new Random();


    public RadiationManager(Graph g) {
        this.g = g;
    }

    public void radiate() {

        int numOutputLinks = g.transmitter.allOutputLinks.size();
        int numberOfLobes =  g.transmitter.numberOfLobes;

        int i = 0;
        List<Integer> edgeIdPicked = new ArrayList<>();
        int whileCounter = 0;
        while (i < Math.min(numberOfLobes, numOutputLinks)) {

                int edgeId = g.transmitter.allOutputLinks.get(g.rand.nextInt(numOutputLinks));

                Edge edge = g.allEdges.get(edgeId);
                whileCounter++;
                if (whileCounter > 20) break;

                if (edge.blocked) continue;
                if (edgeIdPicked.contains(edgeId)) continue;
                edgeIdPicked.add(edgeId);

                Ray newRay = new Ray(edge.pathLoss, edge.length,edgeId, edge.end_idx);

                g.inputRays.add(newRay);
                i++;



        }
    }




private double[][] pickEdgesTx(Node start, double[][] distribution) {

    Random rand = new Random();
    ArrayList<Integer> newEdges = new ArrayList<Integer>();
    int counter = 0;
    int r;

    while (counter < distribution[1].length) {

        r = rand.nextInt(start.allOutputLinks.size());// pick random edge idx
        Integer edge_idx = start.allOutputLinks.get(r);


        if (newEdges.contains(edge_idx)) { // Ensure not to pick the same edge twice
            continue;
        }


        distribution[0][counter] = edge_idx;
        newEdges.add(edge_idx);
        Edge e = g.allEdges.get(edge_idx);
        Node end = e.end;


        Ray newRay = new Ray(distribution[1][counter] * e.pathLoss, e.length, edge_idx, end.idx);
        end.rays.add(newRay);

        g.inputRays.add(newRay);
        counter++;


    }

    return distribution;

}

private double[][] produceDist() {

    Random rand = new Random();
    int rand_int;
    ArrayList<Double> dist = new ArrayList<>();

    int bound = 100;

    while (bound != 0) {
        rand_int = rand.nextInt(bound + 1);
        if (rand_int == 0) continue;

        bound = bound - rand_int;
        dist.add((double) rand_int / 100);


    }
    double[][] out = new double[2][dist.size()];
    int i = 0;
    for (Double d : dist) {
        out[1][i] = (double) d;
        i++;

    }

    return out;

}

}
