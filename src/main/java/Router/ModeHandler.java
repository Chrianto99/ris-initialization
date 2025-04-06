package Router;


import java.util.*;

import Graph.*;
import Helpers.*;
import Node.*;

public class ModeHandler {

    Graph g;
    DistributionHandler distributionManager;
    static double DIFFUSION_CHANCE = 0.5;
    int rTableNodePosition = 0;


    public ModeHandler(Graph g) {

        this.g = g;
        distributionManager = new DistributionHandler(g);

    }

    public void initializeRoutingTables() {

        ArrayList<Tile> tiles = g.getTiles();
        rTableNodePosition = 0;
        for (Tile tile : tiles) {

            tile.setNumberOfModes(g.numberOfModes);
            tile.setrTableIndex(rTableNodePosition);
            generateThetaPhiArchive(tile);

            int edgePos = 0;
            for (Edge inputEdge : tile.getInputEdges()) {

                VectorOperator.reverseVector(inputEdge.getVector()); // Angles should be calculated from a common reference point

                inputEdge.setRTableKey(edgePos++);

                createModes(inputEdge, tile); // create all modes for one input link

                VectorOperator.reverseVector(inputEdge.getVector()); // restore original vector to avoid confusions

            }


        }


    }

    private void createModes(Edge inputEdge, Tile tile) {

        for (int i = 0; i < g.numberOfModes; i++) {
            if (g.rand.nextDouble() > DIFFUSION_CHANCE)
                distributionManager.steer(tile, inputEdge);
            else
                distributionManager.diffuse(tile, inputEdge);

            rTableNodePosition++;


        }


    }

    public void generateThetaPhiArchive(Tile tile) {

        for (Edge edge : tile.getInputEdges()) {
            double theta = VectorOperator.calculateAngle(edge.getVector(), tile.getN());
            double phi = VectorOperator.calculatePhiAngle(tile.getN(), tile.getV(), tile.getU(), edge.getVector());
            tile.getThetaPhiArchive().put(edge, new double[]{theta, phi});
        }

        for (Edge edge : tile.getOutputEdges()) {
            double theta = VectorOperator.calculateAngle(edge.getVector(), tile.getN());
            double phi = VectorOperator.calculatePhiAngle(tile.getN(), tile.getV(), tile.getU(), edge.getVector());
            tile.getThetaPhiArchive().put(edge, new double[]{theta, phi});
        }
    }


}




