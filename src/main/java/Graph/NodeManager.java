package Graph;

import Node.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NodeManager {

    Graph g;
    int nodeIdx;

    public NodeManager(Graph g){
        this.g = g;
        nodeIdx = 0;
    }

    public void intiantiateSurfaces() {

        Surface sur;
        // Left wall (x = 0)
        sur = new Surface(0, new double[]{0}, new double[]{0, g.roomY}, new double[]{0, g.roomZ});
        sur.area = g.roomY * g.roomZ;
        sur.numberOfTiles = g.numberOfTiles / 8;  // Hardcoded as requested
        g.roomSurfaces.add(sur);

        // Right wall (x = roomX)
        sur = new Surface(1, new double[]{g.roomX}, new double[]{0, g.roomY}, new double[]{0, g.roomZ});

        sur.numberOfTiles = g.numberOfTiles / 8;
        g.roomSurfaces.add(sur);

        // Back wall (y = 0)
        sur = new Surface(2, new double[]{0, g.roomX}, new double[]{0}, new double[]{0, g.roomZ});

        sur.numberOfTiles = 2 * g.numberOfTiles / 8;
        g.roomSurfaces.add(sur);

        // Front wall (y = roomY)
        sur = new Surface(3, new double[]{0, g.roomX}, new double[]{g.roomY}, new double[]{0, g.roomZ});

        sur.numberOfTiles = 2 * g.numberOfTiles / 8;
        g.roomSurfaces.add(sur);

        // Ceiling (z = roomZ)
        sur = new Surface(4, new double[]{0, g.roomX}, new double[]{0, g.roomY}, new double[]{g.roomZ});
        sur.area = g.roomX * g.roomY;
        sur.numberOfTiles = 2 * g.numberOfTiles / 8;
        g.roomSurfaces.add(sur);
    }

    public void initializeNodes() {
        int nodeId = 0;
        List<Tile> tiles = new ArrayList<>();
        for (Surface sur : g.roomSurfaces) {
            double Vx = 0,Vy = 0,Vz = 0;
            int numberOfTilesCounter = 0;
            while (numberOfTilesCounter < sur.numberOfTiles){
                double tileX = 0, tileY = 0, tileZ = 0;
                // Based on which coordinate is fixed, randomly select the other two
                if (sur.x.length == 1) {
                    tileX = sur.x[0];
                    tileY = g.rand.nextDouble() * (sur.y[1] - sur.y[0]) + sur.y[0];
                    tileZ = g.rand.nextDouble() * (sur.z[1] - sur.z[0]) + sur.z[0];

                    Vy = tileY;
                    Vz = tileZ;
                    if (sur.x[0] == 0) {
                        Vx = 1;
                    }
                    else Vx = -1;

                } else if (sur.y.length == 1) {
                    tileY = sur.y[0];
                    tileX = g.rand.nextDouble() * (sur.x[1] - sur.x[0]) + sur.x[0];
                    tileZ = g.rand.nextDouble() * (sur.z[1] - sur.z[0]) + sur.z[0];

                    Vx = tileX;
                    Vz = tileZ;
                    if (sur.y[0] == 0) {
                        Vy = 1;
                    }
                    else Vy = -1;

                } else if (sur.z.length == 1) {
                    tileZ = sur.z[0];
                    tileY = g.rand.nextDouble() * (sur.y[1] - sur.y[0]) + sur.y[0];
                    tileX = g.rand.nextDouble() * (sur.x[1] - sur.x[0]) + sur.x[0];

                    Vx = tileX;
                    Vy = tileY;
                    if (sur.z[0] == 0) {
                        Vz = 1;
                    }
                    else Vz = -1;
                } else System.out.println("ERROR");

                // Create and add the tile
                Tile newTile = new Tile(nodeId,sur.id,"Tile");
                newTile.setPosition(tileX, tileY, tileZ);
                newTile.setNormalVector(Vx,Vy,Vz);

                if (!NodeIsFarEnough(newTile)) continue;

                g.allNodes.add(newTile);
                tiles.add(newTile);

                numberOfTilesCounter++;
                nodeId++;
                //System.out.println(nodeId);

            }
        }



        g.transmitter.setPosition(g.rand.nextDouble() * g.roomX, g.rand.nextDouble() * g.roomY, g.rand.nextDouble() * g.roomZ);
        while (!NodeIsFarEnough(g.transmitter)) g.transmitter.setPosition(g.rand.nextDouble() * g.roomX, g.rand.nextDouble() * g.roomY, g.rand.nextDouble() * g.roomZ);
        g.transmitter.idx = nodeId;
        g.allNodes.add(g.transmitter);
        nodeId++;

        int receiverCounter = 0;
        while (receiverCounter < g.numReceivers){

            Rx receiver = new Rx("Rx");
            receiver.setPosition(g.rand.nextDouble() * g.roomX, g.rand.nextDouble() * g.roomY, g.rand.nextDouble() * g.roomZ);
            if (!NodeIsFarEnough(receiver)) continue;

            if (EdgeManager.calculateDistance(receiver,g.transmitter) < g.roomX / 4) continue;

            receiver.idx = nodeId;
            g.allNodes.add(receiver);

            receiverCounter++;
            nodeId++;
            //System.out.println(nodeId);
        }



    }

    public boolean NodeIsFarEnough(Node newNode){

        for (Node node : g.allNodes){
            double length = EdgeManager.calculateDistance(node,newNode);
            double pathLoss;

            pathLoss = g.Gris / (Math.pow(4 * Math.PI / g.wavelength,2) * Math.pow(length,g.alpha));

            if (pathLoss > 1) {
                return false;
            }


        }
        return true;
    }

}
