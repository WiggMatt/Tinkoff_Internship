package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class Example6 {
	static int n, s;
    static int[] l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        l = new int[n];
        r = new int[n];

        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
        }

        int sumTotal = 0;
        int sum = 0;

        while (sumTotal < s) {
            sum = 0;
            
            // Ищем сумму значений нижней границы баллов
            for(int item: l){
                sum += item;
            }
            
            // Если сумма не превышает допустимого суммарного балла для всех учеников,
            // то добавляем к каждому значению нижней границы баллов по единице и снова сверяем с максимальным значением
            if(sum < s){
                for (int i = 0; i < l.length; i++){
                    if(l[i] < r[i]){
                        l[i]++;
                    }
                }
            }
            sumTotal = sum;
        }
        
        Arrays.sort(l);
        
        int[] result = Arrays.stream(l).distinct().toArray();
        System.out.println(result[result.length/2]);
    }
}
