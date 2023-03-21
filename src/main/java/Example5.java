package main.java;

import java.util.*;

class Example5 {
       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfElements = scanner.nextInt();
        int[] inputArray = new int[countOfElements];
        for (int i = 0; i < countOfElements; i++) {
            inputArray[i] = scanner.nextInt();
        }
        scanner.close();
        
        int[][] sensibleSegments = findSensibleSegments(inputArray);
       
        
        System.out.println(countOfNormalSegments(inputArray, sensibleSegments));
       }
       
       // Находим разумные отрезки
       public static int[][] findSensibleSegments(int[] array) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        findAllSubsets(array, 0, new ArrayList<>(), subsets);
        
        List<List<Integer>> totalLists = new ArrayList<>();
        
        for (List<Integer> subset : subsets) {
            if (subset.isEmpty()) continue;
            int sum = 0;
            for (int num : subset) {
                sum += num;
            }
            if (sum == 0) {
                totalLists.add(subset);
            }
        }
        int[][] sensibleSegments = totalLists.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        
        return sensibleSegments;
    }



    // Находим все возможные подмассивы в массиве
    private static void findAllSubsets(int[] array, int i, List<Integer> currentSubset, List<List<Integer>> subsets) {
        if (i == array.length) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }
        findAllSubsets(array, i + 1, currentSubset, subsets); // исключить текущий элемент
        currentSubset.add(array[i]);
        findAllSubsets(array, i + 1, currentSubset, subsets); // включить текущий элемент
        currentSubset.remove(currentSubset.size() - 1);
    }

    //Находим нормальные отрезки
    public static List<List<Integer>> findNormalSegment(int[][] subArrays) {
        List<List<Integer>> allSubArrays = new ArrayList<>();
        for (int i = 0; i < subArrays.length; i++) {
            List<Integer> subArray = new ArrayList<>();
            for (int j = 0; j < subArrays[i].length; j++) {
                subArray.add(subArrays[i][j]);
            }
            allSubArrays.add(subArray);
        }
        return allSubArrays;
    }
    

    //Подсчет нормальных отрезков
    public static int countOfNormalSegments(int[] mainArray, int[][] subArrays) {
        List<List<Integer>> allSubArrays = findNormalSegment(subArrays);
        Set<List<Integer>> uniqueSubArrays = new HashSet<>(allSubArrays);

        int count = 0;
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = i + 1; j <= mainArray.length; j++) {
                int[] temp = new int[j - i];
                System.arraycopy(mainArray, i, temp, 0, j - i);
                List<Integer> tempList = new ArrayList<>();
                for (int k = 0; k < temp.length; k++) {
                    tempList.add(temp[k]);
                }
                for (List<Integer> subArray : uniqueSubArrays) {
                    if (tempList.containsAll(subArray)) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}