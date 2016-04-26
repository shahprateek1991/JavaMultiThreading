package com.semaphore;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		//Pass the size in the constructor of the blocking queue
		BlockingQueue<Integer> blockingQueue = new BlockingQueue<Integer>(5);
		Runnable producer = ()-> {
			int i=10;
			while(i>0) {
				try {
					blockingQueue.add(5);
					i--;
				} catch (InterruptedException e) {
					System.out.println("No Space available in the queue");
				}
			}
			
		};
		Thread tProducer = new Thread(producer);
		
		Runnable consumer = ()-> {
			int j=10;
			while(j>0) {
				Integer i = blockingQueue.remove();
				System.out.println("Element removed:"+i);
				j--;
		
			}
			
		};
		Thread tConsumer = new Thread(consumer);
		
		tProducer.start();
		Thread.sleep(3000);
		tConsumer.start();
		

	}

}
