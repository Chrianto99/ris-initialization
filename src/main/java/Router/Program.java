package Router;

import Graph.*;
import Node.Tx;

import java.util.Random;

public class Program {

    public static void main(String[] args) {

        int[] numberOfTilesVector = {32};

        int numberOfModes = 20;
        double roomX = 15;
        double roomY = 8;
        double roomZ = 6;
        double wavelength = 10e-2;
        double Pt = 1;
        double Gt = 160;
        int numberOfLobes = 8;
        Tx transmitter = new Tx("Tx",Pt,Gt,numberOfLobes);
        int numReceivers = 8;
        double Gris = 16000;


        JsonFileManager jS = new JsonFileManager();
        Random rand = new Random();
        for (int numberOfTiles : numberOfTilesVector)
            for (int i = 0; i < 100; i++) {
                double[] values = {2.0,2.5,3};
                int randomIndex = rand.nextInt(values.length);
                double alpha = values[randomIndex];
                Graph g = new Graph(numberOfTiles, numberOfModes, roomX, roomY, roomZ,wavelength,transmitter,Gris,numReceivers, alpha, rand);
                jS.writeGraphToJson(g, "Graph" + g.numberOfTiles + "_" + g.numberOfModes + "_"  + numberOfLobes + "_" + numReceivers + "_" + i);

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



