package Node;

import java.util.ArrayList;

import Propagation.*;

public class Tile extends Node {
	

	
	public Tile(Integer idx,int wall_idx,String type) {
		
		this.wall_idx = wall_idx;
		this.idx = idx;
		this.type = type;

		this.activeMode = 0;
		this.isActive = false;
		
		allInputLinks = new ArrayList<Integer>();
		allOutputLinks = new ArrayList<Integer>();
		cumulativeDistribution = new ArrayList<>();
		rays = new ArrayList<Ray>();
	
		
		
	}
	
	public void setActiveMode(int mode) {
		this.activeMode = mode;
	}

	public void setNormalVector(double Vx, double Vy, double Vz) {
		normalVector[0] = Vx;
		normalVector[1] = Vy;
		normalVector[2] = Vz;


	}
}
