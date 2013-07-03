package threading;
// RUN THE RUNNABLE
public class SimpleRunnableStarter{
	
    public static void main(String[] args){
    	
		for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
			
			SillyRunnableExample aSillyRunnable = new SillyRunnableExample();
			
			Thread aSillyThread = new Thread(aSillyRunnable);
			
			aSillyThread.start();
		}
	}
}