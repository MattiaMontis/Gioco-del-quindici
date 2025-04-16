package Enum_FinoATot;

import java.util.Random;
import java.util.Scanner;

public class GiocoDelQuindici {
	private final int[][] griglia = new int[4][4];
	private final int[] numeri = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private final Random rand = new Random();
	private final Scanner input = new Scanner(System.in);
	
	
	public GiocoDelQuindici() {
		int valore = 1;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				
				if (valore < 16) {griglia[i][j] = valore; valore++; }
			}
		}
	}
	
	
	
	public void stampaGriglia() {
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            System.out.printf(" %2d ", griglia[i][j]); // numeri allineati (es. "  1", " 10")
	            if (j < 3) System.out.print("|");
	        }
	        System.out.println();
	        if (i < 3) System.out.println("----+----+----+----");
	    }
	}
	
	
	
	public void mescola() {
		int n = 0;
		
		for (int i = numeri.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			int temp = numeri[i];
			numeri[i] = numeri[j];
			numeri[j] = temp;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j< 4; j++) {
				griglia[i][j] = numeri[n];
				n++;
			}
		}
	} 
	
	
	
	
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
			
			 // Verifica se sono adiacenti (solo sopra/sotto/destra/sinistra)
	        if (Math.abs(xCasella - xVuota) + Math.abs(yCasella - yVuota) == 1) {
	            // Scambia
	            griglia[xVuota][yVuota] = griglia[xCasella][yCasella];
	            griglia[xCasella][yCasella] = 0;
	        } else {
	            System.out.println("Mossa non valida: la casella non è adiacente alla vuota.");
	        }
	    } else {
	        System.out.println("Numero non trovato sulla griglia.");
		}
	}
	
	
	public int[] trovaCasella(int num) {
		
		for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	        	if ( num == griglia[i][j]) return new int[] {i, j};
	        }
		} return null;
	}
	
	
	
	public boolean vinto() {
		int expected = 1;
		
		for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	        	
	        	if (i == 3 && j == 3) return griglia[i][j] == 0;
	        	if (griglia[i][j] != expected) return false;
	        	expected++;
	        }
		} return true;
	}
	
	
	
	public void gioca() {
	    mescola();
	    while (!vinto()) {
	        stampaGriglia();
	        scorri(); // oppure scorri(numero) se passi il numero come parametro
	    }
	    stampaGriglia();
	    System.out.println("Complimenti! Hai vinto!");
	}
}
