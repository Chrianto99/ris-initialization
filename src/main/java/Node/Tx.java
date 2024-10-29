package Node;
import org.apache.commons.math3.analysis.integration.gauss.GaussIntegrator;

import java.util.*;
public class Tx extends Node {

	public double gain;
	public double power;
	public int numberOfLobes;
	
	
	
	
	
	public Tx(String type,double power,double gain,int numberOfLobes) {
		wall_idx = 10000;
		this.type = type;
		this.gain = gain;
		this.power = power;
		this.numberOfLobes = numberOfLobes;

		allOutputLinks = new ArrayList<Integer>();
		size = 0.15;
		
	
		
	
	}
	
	

}
