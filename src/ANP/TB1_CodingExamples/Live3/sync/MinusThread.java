package ANP.TB1_CodingExamples.Live3.sync;


/**
 * This thread calls the manipulateMinus method on the shared Data Structure
 * @author gareth
 *
 */
public class MinusThread implements Runnable
{

	// A shared data structure
	public DataStructure structure = null;
	
	public MinusThread(DataStructure structure)
	{
		this.structure = structure;
	}
	
	
	public void run()
	{
		structure.manipulateMinus(1); //minus 1 from the data structure
	}
}
