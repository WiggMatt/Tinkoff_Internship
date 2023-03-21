package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Example4 {
    public static void main(String[] args)
    {
    	Scanner scanner = new Scanner(System.in);
    	int countOfElements = scanner.nextInt();
        int array[] = new int[countOfElements];
    	for (int i = 0; i < array.length; i++) {
    		array[i] = scanner.nextInt();
        }
    	scanner.close();
        
        for(int i = array.length; i > 0; i--){
            int arrayCopy[] = Arrays.copyOfRange(array, 0, i);
            Map<Integer, Integer> map = convertToMap(arrayCopy);
            Set<Integer> repeats= new HashSet<Integer>(map.values());
            List<Integer> list = new ArrayList<Integer>(repeats);
            Collections.sort(list);
            if(repeats.size() == 1 || (repeats.size() == 2 && list.get(1) - list.get(0) == 1 && countItem(map))) {
                    System.out.println(i);
                    return;
            }
        }
    }
    
    public static Map<Integer, Integer> convertToMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }
    
    public static boolean countItem (Map<Integer, Integer> maps)
    {
        // Создаем HashMap для подсчета количества ключей с одинаковыми значениями
        Map<Integer, Integer> countMap = new HashMap<>();
        // Итерируем по значениям в map и увеличиваем счетчик для каждого значения в countMap
        for (Integer value : maps.values()) {
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                countMap.put(value, 1);
            }
        }
        Collection<Integer> array = countMap.values();
        Integer value = 1;
        return array.contains(value);
    }
}
