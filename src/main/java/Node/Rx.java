package Node;
import java.util.*;
import Propagation.*;

public class Rx extends Node {
	

	public Rx(String type) {
		wall_idx = -10;
		this.type = type;
		size = 0.2;
		allInputLinks = new ArrayList<Integer>();
		rays = new ArrayList<Ray>();
		this.wall_idx = 100;
		
	}

}
