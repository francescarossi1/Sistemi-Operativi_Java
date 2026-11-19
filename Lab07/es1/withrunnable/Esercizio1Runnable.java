package es1.withrunnable;

import es1.Accumulatore;

public class Esercizio1Runnable {
  
	// massimo numero di Thread
	final static int N = 25;

    @SuppressWarnings("CallToPrintStackTrace")
	public static void main(String args[]) {
		System.out.println("Esercizio1Runnable");

		Accumulatore acc = new Accumulatore(0.0);
		
		// TODO: chiedere all'utente il numero di thread da creare
   
		Thread ct[] = new Thread[N];
		for (int i = 0; i < N; i++) {
			ct[i] = new Thread(new CounterThread(acc));
			ct[i].start();
		}
 
		for(int i=0; i < N; i++) {
			try {
				ct[i].join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			} 
		}
	
		System.out.println("Esercizio1Runnable: accumulatore vale " + acc.getValue());
	}
  
}