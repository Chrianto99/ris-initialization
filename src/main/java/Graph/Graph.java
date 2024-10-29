package Graph;
import java.util.*;

import Node.*;
import Propagation.Ray;
import Router.*;

public class Graph {
	
	public List<Edge> allEdges = new ArrayList<>();
	public List<Node> allNodes = new ArrayList<>();
	public List<Ray> inputRays = new ArrayList<>();
	public List<int[]> transmitterModes = new ArrayList<>();
	public HashMap<Integer,HashMap<String,double[][]>> routingTables = new HashMap<>();
	public int numberOfModes;
	public int numberOfTiles;
	public double wavelength,Gris,alpha;
	public Tx transmitter;
	public int numReceivers;

	transient public double roomX;
	transient public double roomY;
	transient public double roomZ;
	transient public Random rand;
	transient public List<Surface> roomSurfaces = new ArrayList<>();



	public Graph(int numberOfTiles,int numberOfModes,double roomX,double roomY,double roomZ,double wavelength,Tx transmitter,double Gris,int numReceivers,double alpha,Random rand) {

		this.alpha = alpha;
		this.wavelength = wavelength;
		this.Gris = Gris;
		this.transmitter = transmitter;
		this.numReceivers = numReceivers;

		this.roomX = roomX;
		this.roomY = roomY;
		this.roomZ = roomZ;
		this.numberOfTiles = numberOfTiles;
		this.numberOfModes = numberOfModes;
		this.rand = rand;


		EdgeManager edgeManager = new EdgeManager(this);
		NodeManager nodeManager = new NodeManager(this);
		nodeManager.intiantiateSurfaces();
		nodeManager.initializeNodes();
		edgeManager.initializeEdges();
		int loss = 90;
		double multipathFactor = rand.nextDouble();
		RandomEventManager rEM = new RandomEventManager(this,loss,multipathFactor);
		Router router = new Router(this,rEM);
		router.initializeRoutingTables();

		
	}
	
	public ArrayList<Node> getNodes(String type){
		ArrayList<Node> list = new ArrayList<>();
		for (Node node : allNodes){
			if (node.type.equals(type)){
				list.add(node);
			}
		}
		return list;
	}



	
}
	


	
			
	



		
	
	





