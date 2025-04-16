package Enum_FinoATot;

import java.util.Random;
import java.util.Scanner;

public class GiocoDelQuindici {
	// Creo la griglia 4x4 del gioco
	private final int[][] griglia = new int[4][4];
	// Creo un array con i numeri da 0 a 15, che userò per mescolare
	private final int[] numeri = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private final Random rand = new Random(); // Per generare numeri casuali
	private final Scanner input = new Scanner(System.in); // Per leggere input da tastiera
	
	
	public GiocoDelQuindici() {
		// Inizializzo la griglia ordinata da 1 a 15 (lo 0 rappresenta la casella vuota)
		int valore = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (valore < 16) {
					griglia[i][j] = valore;
					valore++;
				}
			}
		}
	}
	
	// Stampo la griglia in modo formattato, con righe e colonne separate visivamente
	public void stampaGriglia() {
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            System.out.printf(" %2d ", griglia[i][j]); // Allineo i numeri
	            if (j < 3) System.out.print("|");
	        }
	        System.out.println();
	        if (i < 3) System.out.println("----+----+----+----");
	    }
	}
	
	// Mescolo casualmente i numeri da inserire nella griglia
	public void mescola() {
		int n = 0;
		
		// Uso l'algoritmo di Fisher-Yates per mescolare l'array
		for (int i = numeri.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			int temp = numeri[i];
			numeri[i] = numeri[j];
			numeri[j] = temp;
		}
		
		// Inserisco i numeri mescolati nella griglia
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j< 4; j++) {
				griglia[i][j] = numeri[n];
				n++;
			}
		}
	} 
	
	// Chiedo all'utente quale numero vuole spostare e provo a spostarlo
	public void scorri() {
		System.out.println("Inserisci il numero della casella da spostare (1-15): ");
		int numeroDaSpostare = input.nextInt();
		
		int[] trovaCasella = trovaCasella(numeroDaSpostare);
		int[] casellaVuota = trovaCasella(0);
		
		if (trovaCasella != null && casellaVuota != null) {
			int xCasella = trovaCasella[0];
			int yCasella = trovaCasella[1];
			int xVuota = casellaVuota[0];
			int yVuota = casellaVuota[1];
			
	        // Controllo se le due caselle sono adiacenti (non diagonali)
	        if (Math.abs(xCasella - xVuota) + Math.abs(yCasella - yVuota) == 1) {
	            // Eseguo lo scambio
	            griglia[xVuota][yVuota] = griglia[xCasella][yCasella];
	            griglia[xCasella][yCasella] = 0;
	        } else {
	            System.out.println("Mossa non valida: la casella non è adiacente alla vuota.");
	        }
	    } else {
	        System.out.println("Numero non trovato sulla griglia.");
		}
	}
	
	// Cerco la posizione di un numero nella griglia e la restituisco come coordinate [riga, colonna]
	public int[] trovaCasella(int num) {
		for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	        	if ( num == griglia[i][j]) return new int[] {i, j};
	        }
		}
		return null;
	}
	
	// Controllo se la griglia è ordinata correttamente (da 1 a 15 e 0 in fondo)
	public boolean vinto() {
		int expected = 1;
		for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	        	// L'ultima casella deve essere vuota
	        	if (i == 3 && j == 3) return griglia[i][j] == 0;
	        	if (griglia[i][j] != expected) return false;
	        	expected++;
	        }
		}
		return true;
	}
	
	// Metodo principale per giocare: mescolo la griglia e continuo finché il puzzle non è risolto
	public void gioca() {
	    mescola();
	    while (!vinto()) {
	        stampaGriglia();
	        scorri(); // Potrei anche passare il numero come parametro
	    }
	    stampaGriglia();
	    System.out.println("Complimenti! Hai vinto!");
	}
}
