import java.util.ArrayList;
import java.util.Arrays;

public class TimeCalc {
	public void calcTime(ArrayList<Operation> operations, int n, int time, ArrayList<Operation> current, ArrayList<ArrayList<Operation>> out){
		if (time == 0){
			ArrayList<Operation> temp = new ArrayList<Operation>(current);
			out.add(temp);
            return;
		}
        for(int i = n; i < operations.size(); i++){
        	if(time < operations.get(i).time){
        		return;
        	}
        	if (operations.get(i).count == 1 && operations.get(i).repeat == false)
    		{
        		return;
    		}else{
    			operations.get(i).count += 1;
            	current.add(operations.get(i));
            	calcTime(operations, i, time - operations.get(i).time, current, out);
            	current.remove(current.size()-1);
    		}
    		
        }
    }
}
