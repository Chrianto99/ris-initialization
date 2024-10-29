package Propagation;

import java.util.ArrayList;

public class Ray {
	
	public double power;
	public double length;
	public int edge;
	public int nodeIdx;
	public ArrayList<Integer> edges;
	
	
	public Ray(double total_power,double length,Integer edge_idx,int nodeIdx) {

		this.power = total_power;
		this.length = length;
		edge = edge_idx;
		this.nodeIdx = nodeIdx;
		edges = new ArrayList<>();
		edges.add(edge_idx);

		
	}
	

}
