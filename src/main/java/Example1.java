package main.java;

import java.util.Scanner;

public class Example1 {
	public static void main(String args[]) {
		int[] myArray = new int[4];
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			myArray[i] = scanner.nextInt();
        }
		scanner.close();

		 boolean ascendingOrder = true;
	     boolean descendingOrder = true;

	     for (short i = 1; i < myArray.length; i++) {
	    	 if (myArray[i] > myArray[i-1]) {
	    		 descendingOrder = false;
	         } else if (myArray[i] < myArray[i-1]) {
	        	 	ascendingOrder = false;
	         }
	     }

	     if (ascendingOrder || descendingOrder) {
	    	 System.out.println("YES");
	     } else {
	    	 System.out.println("NO");
	     }
	}
}
