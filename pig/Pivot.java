package myudfs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;



public class Pivot extends EvalFunc<DataBag>
{
    public DataBag exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0)
            return null;
			
		String str = (String)input.get(0);
	 	String[] numbers = str.split(" ");
		
		List <Tuple> tuples = new ArrayList <Tuple>();
		Tuple tuple = null;
		
		TupleFactory tupleFactory=TupleFactory.getInstance();
		
		for (String number: numbers){
		
			tuple = tupleFactory.newTuple();
		
			tuple.append(number);
		
			tuples.add(tuple);
		
		}
		
		BagFactory bagFactory=BagFactory.getInstance();
		
		DataBag bag = bagFactory.newDefaultBag(tuples);
		
		//Tuple result = tupleFactory.newTuple(bag);
		
		return bag;
            
    }
}