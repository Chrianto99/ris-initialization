package Propagation;

import java.util.*;

import Node.*;
import Graph.*;

public class RadiationHandler {

    private Graph g;

    public RadiationHandler(Graph g) {
        this.g = g;
    }

    public boolean createInputRays() { // Handles Transmitter Radiation. Creates Input Rays by picking edges that
        boolean transmitterBlocked = true;

        Node transmitter = g.getTx();
        List<Edge> outputEdges = new ArrayList<>(transmitter.getOutputEdges());

        int numLobesCreated = 0;

        while (numLobesCreated < g.txConfig.getNumLobes() && !outputEdges.isEmpty()) {

            Edge edgePicked = g.allEdges.get(g.rand.nextInt(outputEdges.size()));

            outputEdges.remove(edgePicked);

            Ray newRay = new Ray(edgePicked.getPathLoss(), edgePicked.getLength(), edgePicked.getId(), edgePicked.getDestNode_id());
            g.inputRays.add(newRay);
            numLobesCreated++;

        }

        // Removing edges that will not be used in the simulation significantly reduces exported data size
        removeUnusedEdges(outputEdges);

        // If the desired number of lobes cannot be created due to Tx blockage abort process and
        // proceed to create another graph

        if (numLobesCreated < g.txConfig.getNumLobes()) return transmitterBlocked;


        return !transmitterBlocked;

    }


    public void removeUnusedEdges(List<Edge> outputEdges) {

        List<Tile> tiles = g.getTiles();

        for (Tile tile : tiles) {
            List<Edge> inputEdges = tile.getInputEdges();
            for (Edge outputEdge : outputEdges)
                inputEdges.removeIf(edge -> inputEdges.contains(outputEdge));
        }

    }


}
