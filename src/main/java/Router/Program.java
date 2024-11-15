package Router;

import Graph.*;
import Node.Tx;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Program {

    public static void main(String[] args) {

        int[] numberOfTilesVector = {8, 16, 32};
        int[] numReceiversVector = {1};
        int numberOfLobes = 4;

        int numberOfModes = 20;
        int numberOfGraphs = 100;
        double roomX = 10;
        double roomY = 5;
        double roomZ = 4;
        double wavelength = 10e-2;
        double Pt = 1;
        double Gt = 160;

        double Gris = 16000;
        double alpha = 3; //path Loss Exponent
        String folderPath1 = "GraphsMIMO_" + numberOfLobes;

        File directory = new File(folderPath1);
        directory.mkdir();

        JsonFileManager jS = new JsonFileManager();
        Random rand = new Random();
        for (int numberOfTiles : numberOfTilesVector) {

            for (int numReceivers : numReceiversVector) {

                String folderPath2 = folderPath1 + "/Rx_" + numReceivers;
                directory = new File(folderPath2);
                directory.mkdir();
                String folderPath3 = folderPath2 + "/Tiles_" + numberOfTiles;
                directory = new File(folderPath3);
                directory.mkdir();
                String folderPath4 = folderPath3 + "/Modes_" + numberOfModes;
                directory = new File(folderPath4);
                directory.mkdir();


                for (int i = 0; i < numberOfGraphs; i++) {
                    Tx transmitter = new Tx("Tx", Pt, Gt, numberOfLobes);// Create transmitter

                    Graph g = new Graph(numberOfTiles, numberOfModes, roomX, roomY, roomZ, wavelength, transmitter, Gris, numReceivers, alpha, rand);//Create Graph

                    jS.writeGraphToJson(g, folderPath4 + "/Graph" + "_" + i);

                }
            }
        }
    }
}



