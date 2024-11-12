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

        int numberOfModes = 20;
        double roomX = 15;
        double roomY = 8;
        double roomZ = 6;
        double wavelength = 10e-2;
        double Pt = 1;
        double Gt = 160;
        int numberOfLobes = 4;

        double Gris = 16000;
        String folderPath1 = "GraphsMIMObigRoom_" + numberOfLobes;

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


                for (int i = 0; i < 100; i++) {
                    numberOfLobes = numberOfTiles;
                    Tx transmitter = new Tx("Tx", Pt, Gt, numberOfLobes);
                    double[] values = {3};
                    int randomIndex = rand.nextInt(values.length);
                    double alpha = values[randomIndex];
                    Graph g = new Graph(numberOfTiles, numberOfModes, roomX, roomY, roomZ, wavelength, transmitter, Gris, numReceivers, alpha, rand);

                    jS.writeGraphToJson(g, folderPath4 + "/Graph" + "_" + i);

                }
            }
        }


//
//        for (HashMap<String,double[][]> rT : g.routingTables.values()){
//
//            for (String key:rT.keySet()){
//                System.out.println();
//                System.out.print(key + " ");
//                double[][] dist = rT.get(key);
//                for (int i = 0; i < dist[0].length;i++){
//                    System.out.print(" | ");
//                    System.out.print(dist[0][i] + "--");
//                    System.out.print(dist[1][i]);
//                }
//            }
//
//        }


    }
}



