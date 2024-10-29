package GraphGPU;

import java.util.ArrayList;
import java.util.List;

public class InputEdgeBlock {
    public List<double[]> distributions;


    public InputEdgeBlock(){
        distributions = new ArrayList<>();

    }

    public void printEdgeBlock(){
        for (double[] dist : distributions){
            System.out.println();
            for (int i = 0; i < dist.length ; i++){
                System.out.print(" " + dist[i] + ",");
            }
        }
    }
}
