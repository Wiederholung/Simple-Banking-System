package ANP.TB1_CodingExamples.Live1.creatingthreads;

/**
 * This class implements Runnable. As such, it "promises" the Java compiler that it will
 * contain a run() method. Try renaming the run() method to ran(). See what happens...an
 * error will occur because you will have broken your "promise" to implement run()
 * @author gareth
 *
 */
public class MyRunnable implements Runnable
{

	
	public void run()
	{
		System.out.println("Entering thread");
	
		System.out.println("Leaving thread");	
	}

}
