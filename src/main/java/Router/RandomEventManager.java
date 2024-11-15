package Router;

import Graph.*;
import Node.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

public class RandomEventManager {

    Graph g;
    int loss;
    double multiPathFactor;


    public RandomEventManager(Graph g, int routingLoss,double multiPathFactor) {
        this.g = g;
        this.loss = routingLoss;
        this.multiPathFactor = multiPathFactor;

    }

    public double[][] pickEdges(Node start, double[][] distribution, Integer inputLink) {



        Edge inputEdge = g.allEdges.get(inputLink);
        ArrayList<Integer> newEdges = new ArrayList<Integer>();

        int counter = 0;
        loss =  20 + g.rand.nextInt(80); //routing losses ranging from 50 to 100
        //** actual loss is the opposite (100 - loss)**
        int r;

        while (counter < distribution[1].length) {
            r = g.rand.nextInt(start.allOutputLinks.size());// pick random edge idx
            Integer edge_idx = start.allOutputLinks.get(r);

            if (newEdges.contains(edge_idx)) { // Ensure not to pick the same edge twice
                continue;
            }

            Edge e = g.allEdges.get(edge_idx);

            if (e.isParallel(inputEdge)) { // Ensure that the edge is not parallel
                continue;
            }

            distribution[0][counter] = edge_idx;
            newEdges.add(edge_idx);
            counter++;

        }



        return distribution;

    }

    public double[][] produceDist(int maxNumberOfOutputLinks) {
        Random rand = new Random();
        ArrayList<Integer> dist = new ArrayList<>();


        // Work with integers (e.g., if this.loss is 50%, we treat it as 50)
        int remainingStick = this.loss;  // Assuming 'loss' is already an integer (percentage)
        int numFractions = 0;

        // While there's remaining "stick" and we haven't reached the max number of fractions

        while (remainingStick > 0 && numFractions < maxNumberOfOutputLinks - 2 ) {
            // Break a random integer portion of the remaining stick
            int fraction = rand.nextInt(remainingStick + 1);  // Random integer between 0 and remainingStick


            if (fraction > 0) {  // Only add non-zero fractions
                dist.add(fraction);
                remainingStick -= fraction;
                numFractions++;
            }
        }

        // Add the last remaining portion of the stick
        if (remainingStick > 0) {
            dist.add(remainingStick);
        }

        // Create a 2D array for the output (divide by 100 to get fractions)
        double[][] out = new double[2][dist.size()];
        for (int i = 0; i < dist.size(); i++) {

            out[1][i] = dist.get(i) / 100.0; // Convert to fraction by dividing by 100
        }

        return out;
    }

    public double[] flattenArray(double[][] array) {
        int numCols = array[0].length;
        int numRows = array.length;
        int idx = 0;
        double[] flatennedArray = new double[numRows * numCols];

        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                flatennedArray[idx++] = array[row][col];
            }
        }

        return flatennedArray;

    }

}
