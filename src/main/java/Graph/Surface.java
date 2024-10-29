package Graph;

import Node.Node;
import Node.Tile;
import Node.Tx;
import Node.Rx;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Surface {
    int id;
    double[] x, y, z;
    double area;
    int numberOfTiles;


    public Surface(int id, double[] x, double[] y, double[] z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }



}


