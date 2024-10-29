package Router;


import java.util.*;

import Graph.*;
import GraphGPU.GraphGPU;
import GraphGPU.InputEdgeBlock;
import GraphGPU.RoutingTable;
import Node.*;

public class Router {

	Graph g;
	GraphGPU graphGPU;

	RandomEventManager rEM;
	boolean flag = true;


	public Router(Graph g, RandomEventManager rEM) {

		this.g = g;
		this.rEM = rEM;

	}

	public void initializeRoutingTables() {

		ArrayList<Node> nodes = g.getNodes("Tile");
		RadiationManager rM = new RadiationManager(g);

		rM.radiate();

		//int numOutputLinks = g.transmitter.allOutputLinks.size();
		//for (int i = 0; i < g.numberOfModes;i++){
		//	int[] mode = new int[Math.min(g.transmitter.numberOfLobes,numOutputLinks)];
		//	for (int j = 0; j < mode.length; j++){
		//		int edgeId = g.transmitter.allOutputLinks.get(g.rand.nextInt(numOutputLinks));
		//		mode[j] = edgeId;
		//	}
		//	g.transmitterModes.add(mode);
		//}

		for (Node n : nodes) {

			HashMap<String, double[][]> rT = new HashMap<>();
			//RoutingTable rTgpu = new RoutingTable();

			for (Integer inputLink : n.allInputLinks) {

				//InputEdgeBlock block = new InputEdgeBlock();
				createModes(inputLink, n, rT); //create all modes for one input link

			}

			g.routingTables.put(n.idx, rT);
			//graphGPU.routingTables.add(rTgpu);

		}



	}

	private void createModes(Integer inputLink, Node n, HashMap<String, double[][]> rT) {

		double[][] distribution;
		Integer i = 0;

		while (i < g.numberOfModes) { // for every mode
			flag = false;
			distribution = rEM.produceDist(n.allOutputLinks.size()); //produce random distribution

			distribution = rEM.pickEdges(n, distribution, inputLink);

			//block.distributions.add(rEM.flattenArray(distribution));

			String Key = String.valueOf(inputLink) + " " + String.valueOf(i);

			rT.put(Key, distribution);

			i++;

		}

		String Key = String.valueOf(inputLink) + " " + String.valueOf(i);

		rT.put(Key, new double[][]{});


		//rTgpu.inputEdgeBlocks.add(block);
		//Edge e = g.allEdges.get(inputLink);
		//e.blockPosition = rTgpu.inputEdgeBlocks.size();

	}



	public void createPherormoneDistributions(Node n) {

		for (int i = 0; i < g.numberOfModes; i++) {

			n.cumulativeDistribution.add((double)i);

		}
	}



}