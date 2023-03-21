package main.java;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        double[] staff = new double[3];
        
        Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < staff.length; i++) {
			staff[i] = scanner.nextInt();
        }
		scanner.close();
		
        int timeToTask = (int) Math.ceil((staff[0]*staff[2])/staff[1]);
        System.out.println(timeToTask);
    }
}
