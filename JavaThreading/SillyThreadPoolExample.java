package threading;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SillyThreadPoolExample {
    
	public static void main(String[] args) {
		
//		Use the Executor and its pool if there are a lot of times 
//		you need to use threads for short periods.
		
//		Create and use an Executor that contains a CachedTreadPool. 
//		This means that each time the execute method of the Executor is called 
//		it runs a SillyRunnable in an available thread from the pool. 
//		A thread is available if it is not currently running a Runnable.
		
		Executor anExecutor = Executors.newCachedThreadPool();
		
		for(int threadCnt = 0; threadCnt < 3; threadCnt++){
			
			SillyRunnableExample aSillyRunnable = new SillyRunnableExample();
			
			anExecutor.execute(aSillyRunnable);
		}
		
		try {
			
			Thread.sleep(5000);
			
			System.out.println("Done Sleeping");
			
			for(int threadCnt = 0; threadCnt < 3; threadCnt++){
				
				SillyRunnableExample aSillyRunnable = new SillyRunnableExample();
				
				anExecutor.execute(aSillyRunnable);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
	}
}