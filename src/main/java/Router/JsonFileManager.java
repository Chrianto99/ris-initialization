package Router;

import java.io.FileWriter;
import java.io.IOException;

import GraphGPU.GraphGPU;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Graph.Graph;

public class JsonFileManager {


	
	public void writeGraphToJson(Graph g,String name) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = " ";
		
		json = gson.toJson(g);
		
		       
        // Write JSON to file
        try (FileWriter writer = new FileWriter( name +".json")) {
            writer.write(json);
            System.out.println("JSON written to output.json successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void writeGraphGPUToJson(GraphGPU graphGPU) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = " ";

		json = gson.toJson(graphGPU);


		// Write JSON to file
		try (FileWriter writer = new FileWriter("C:/Users/Chris/Documents/GraphGPU.json")) {
			writer.write(json);
			System.out.println("JSON written to output.json successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
