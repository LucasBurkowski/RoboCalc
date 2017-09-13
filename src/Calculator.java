import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] Args) throws FileNotFoundException{
		TimeCalc calc = new TimeCalc();
		ArrayList<Operation> operations = new ArrayList<Operation>();
		ArrayList<ArrayList<Operation>> output = new ArrayList<ArrayList<Operation>>();
		ArrayList<Operation> current = new ArrayList<Operation>();
		int timeTele = 120;
		Scanner keys = new Scanner(System.in);
		
		boolean enterOps = true;
		
		
		while(enterOps){
			Operation newOp = new Operation();
			System.out.println("Enter the Scoring Oppurtunity Name: ");
			newOp.name = keys.nextLine();
			System.out.println("Enter the Scoring Oppurtunity Point Value: ");
			newOp.pointVal = keys.nextInt();
			System.out.println("Enter the Scoring Oppurtunity Time in Seconds: ");
			newOp.time = keys.nextInt();
			System.out.println("Does this Scoring Oppurtunity Repeat? (y or n)");
			if (keys.next().charAt(0) == 'y'){
				newOp.repeat = true;
			}else{
				newOp.repeat = false;
			}keys.nextLine();
			
			System.out.println("n for next, e for exit");
			operations.add(newOp);
			char next = keys.next(".").charAt(0);
			if(next == 'e')
				enterOps = false;
			else{
				enterOps = true;
			}keys.nextLine();
		}
		
		calc.calcTime(operations, 0, timeTele, current, output);
		for(int i = 0; i < output.size(); i++){
			for(int j = 0; j < output.get(i).size(); j++){
				System.out.print(output.get(i).get(j).name + " ");
			}
			System.out.println();
		}
		CSVOut finalOut = new CSVOut();
		finalOut.printCSV(output);
	}
}
