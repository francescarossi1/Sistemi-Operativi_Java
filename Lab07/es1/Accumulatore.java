package es1;

public class Accumulatore {
	
	// Attenzione: 
	// questa soluzione NON è thread-safe

	private double accumulatore;
	public Accumulatore(double value) {
		accumulatore = value;
	}

	public void addValue(double value) {
		double temp = accumulatore;
		temp += value;
		try {
			// Questa sleep blocca i thread dopo la somma ma prima dell'assegnazione.
			// Altri thread concorrenti vedono il valore iniziale (prima della somma).
			// Senza synchronzied in questo esercizio il valore finale corrisponde all'ultimo aggiunto,
			// non alla somma di tutti i valori aggiunti.
			Thread.sleep(200);
		} catch(InterruptedException e) {}
		accumulatore = temp;
	}

	public double getValue() {
		return accumulatore;
	}
  
}
