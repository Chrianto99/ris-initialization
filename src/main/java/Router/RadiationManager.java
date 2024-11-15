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
                if (edge.end_idx > g.numberOfTiles) continue;
                whileCounter++;
                if (whileCounter > 20) break; // Makes sure loops ends of no new edges are found
                if (edge.blocked) continue; // Makes sure current edges is not blocked
                if (edgeIdPicked.contains(edgeId)) continue; //Makes sure edge is not picked twice
                edgeIdPicked.add(edgeId);

                Ray newRay = new Ray(edge.pathLoss, edge.length,edgeId, edge.end_idx);

                g.inputRays.add(newRay);
                i++;



        }
    }



}
