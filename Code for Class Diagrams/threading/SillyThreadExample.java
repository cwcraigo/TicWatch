package threading;



public class SillyThreadExample extends Thread{

	// Each of your objects that inherits from Thread must override the public void run method. 
	// The code in this method is what will execute when your custom thread object is started.
	public void run(){
		
		for (int i = 0; i < 3; i++) {
			
			System.out.println("SillyThreadExample [Thread id: "+Thread.currentThread().getName()+"]");
			
			try {
				
				Thread.currentThread().sleep(100);
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
    
	// To start a thread running in parallel you must instantiate the custom thread and call the 
	// public void start() method it inherited from the base Thread class
	public static void main(String[] args){
		
        	for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
        		
           		 SillyThreadExample aSillyThread =  new SillyThreadExample();
           		 
           		 // To start a thread running in parallel you must instantiate the custom thread and call the 
           		 // public void start() method it inherited from the base Thread class
           		 aSillyThread.start();
           		 
       		 }
	}
}