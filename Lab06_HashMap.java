import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Lab06_HashMap {

    public static void addAndSort(HashMap<Integer, Integer> hashMap, int value) {
        System.out.println("Old list before adding: " + hashMap);
        int i = 0;
        while (hashMap.get(i) < value) {
            i++;
        }
        int tempVal;
        HashMap<Integer, Integer> tempHashMap = new HashMap<>();
        for (int q = i + 1; q <= hashMap.size(); q++) {
            tempVal = hashMap.get(q - 1);
            tempHashMap.put(q, tempVal);
        }
        hashMap.put(i, value);
        i++;
        for (int element : tempHashMap.values()) {
            hashMap.put(i, element);
            i++;
        }
        System.out.println("New list after adding: " + hashMap);
    }

    public static void swapValues(HashMap<Integer, Integer> hashMap, int indexOne, int indexTwo) {
        System.out.println("Old list before swapping: " + hashMap);
        int indexOneVal = hashMap.get(indexOne);
        int indexTwoVal = hashMap.get(indexTwo);
        hashMap.put(indexOne, indexTwoVal);
        hashMap.put(indexTwo, indexOneVal);
        System.out.println("New list after swapping: " + hashMap);
    }

    public static <K, V> Integer findValue(HashMap<Integer, Integer> hashMap, Integer searchVal) {
        return hashMap.entrySet().stream()
                .filter(e -> e.getValue().equals(searchVal))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> randomHashMap = new HashMap<>();
        Random rn = new Random();
        int upper = 9999;
        int lower = 1000;
        int searchVal = rn.nextInt(upper - lower) + lower;
        for (int i = 1; i <= 500; i++) {
            randomHashMap.put(i, rn.nextInt(upper - lower) + lower);
        }
        hashMap.put(0, 1);
        hashMap.put(1, 3);
        hashMap.put(2, 5);
        hashMap.put(3, 7);
        hashMap.put(4, 9);
        hashMap.put(5, 11);
        addAndSort(hashMap, 4);
        swapValues(hashMap, 1, hashMap.size() - 1);
        int res = findValue(randomHashMap, searchVal);
        System.out.println("Do random integer exists in linked list?: " + res);
    }
}
