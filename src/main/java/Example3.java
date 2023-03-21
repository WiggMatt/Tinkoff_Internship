package main.java;

import java.util.Scanner;

public class Example3 {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        String s = scanner.next();
	        scanner.close();
	        
	        int[] count = new int[4]; // массив для хранения количества встреч каждого символа
	        
	        int left = 0; // левая граница отрезка
	        int minLen = Integer.MAX_VALUE; // минимальная длина хорошей подстроки
	        
	        for (int right = 0; right < n; right++) {
	            char c = s.charAt(right);
	            if (c == 'a') count[0]++;
	            else if (c == 'b') count[1]++;
	            else if (c == 'c') count[2]++;
	            else if (c == 'd') count[3]++;
	            
	            while (count[0] > 0 && count[1] > 0 && count[2] > 0 && count[3] > 0) {
	                // если встретили каждый из символов, то обновляем минимальную длину подстроки
	                minLen = Math.min(minLen, right - left + 1);
	                
	                // сдвигаем левую границу отрезка, уменьшая количество встреч символа на этой позиции
	                char leftChar = s.charAt(left);
	                if (leftChar == 'a') count[0]--;
	                else if (leftChar == 'b') count[1]--;
	                else if (leftChar == 'c') count[2]--;
	                else if (leftChar == 'd') count[3]--;
	                left++;
	            }
	        }
	        
	        System.out.println(minLen == Integer.MAX_VALUE ? -1 : minLen);
	    }
}
