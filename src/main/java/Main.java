import Graph.*;
import Node.Tile;
import Node.TileConfig;
import Node.TxConfig;
import RoomGeometry.Room;
import RoomGeometry.RoomHandler;
import Helpers.JsonFileManager;

import java.io.File;

public class Main {

    public static void main(String[] args) {


        double frequency = 30e9;
        double c = 299792458;
        double wavelength = c / frequency;
        double Pt = 1; // Transmitted power
        double Gt = 160; // Transmitter gain


        double[] roomDims = new double[]{15, 10, 5}; // Room dimensions x,y,z
        double pathLossExponent = 3;
        RoomHandler roomHandler = new RoomHandler(); // Handles room creation (walls and obstacles)
        roomHandler.createCuboidRoom(roomDims);
        roomHandler.addSpheres();
        Room cuboidRoom = roomHandler.getRoom(); // Final room object. Input for graphs creation


        //Initialize SDM Parameters
        int numElements = 20;
        double elementSpacing = wavelength / 2;
        double elementGain = 4;
        int numberOfModes = 20;
        TileConfig tileConfig = new TileConfig(numElements, elementSpacing, elementGain, wavelength);

        int[] numberOfTilesVector = {16, 32, 64};
        int[] numReceiversVector = {2, 4, 8};


        int numberOfGraphs = 100;
        String folderPath1 = "Graphs_" + (int) roomDims[0] + "x" + (int) roomDims[1] + "x" + (int) roomDims[2];
        File directory = new File(folderPath1);
        directory.mkdir();

        JsonFileManager jS = new JsonFileManager();
        for (int numberOfTiles : numberOfTilesVector) {

            for (int numReceivers : numReceiversVector) {

                cuboidRoom.setParameters(numberOfTiles, numReceivers, pathLossExponent); //Set parameters for room
                int numLobes = numReceivers;
                TxConfig txConfig = new TxConfig(Gt, Pt, numLobes, wavelength);

                System.out.println(numberOfTiles + " - " + numReceivers);
                String folderPath2 = folderPath1 + "/Rx_" + numReceivers;
                directory = new File(folderPath2);
                directory.mkdir();
                String folderPath3 = folderPath2 + "/Tiles_" + numberOfTiles;
                directory = new File(folderPath3);
                directory.mkdir();
                String folderPath4 = folderPath3 + "/Modes_" + numberOfModes;
                directory = new File(folderPath4);
                directory.mkdir();
                int i = 0;
                while (i < numberOfGraphs) {

                    System.out.print("Creating Graph " + i + "...");
                    Graph g = new Graph(cuboidRoom, txConfig, tileConfig); //Create Graph

                    if (g.graphCreationAborted) continue;

                    jS.writeGraphToJson(g, folderPath4 + "/Graph" + "_" + i);
                    i++;

                }

            }
        }
    }
}



