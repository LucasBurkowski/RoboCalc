import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVOut {
	
	public void printCSV(ArrayList<ArrayList<Operation>> output) throws FileNotFoundException{
		
		PrintWriter writer = new PrintWriter("RoboCalc.csv");
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i < output.size(); i++){
			int sum = 0;
			for(int j = 0; j < output.get(i).size(); j++){
				sum += output.get(i).get(j).pointVal;
				sb.append(output.get(i).get(j).name);
				sb.append(',');
			}
			sb.append(',');
			sb.append(sum);
			sb.append('\n');
		}
		
		writer.write(sb.toString());
		writer.close();
	}
}
