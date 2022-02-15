import java.util.LinkedList;
import java.util.Random;

public class Lab06 {

    public static void addAndSort(LinkedList<Integer> list, int value) {
        System.out.println("Old list before adding: " + list);
        int i = 0;
        while (list.get(i) < value) {
            i++;
        }
        list.add(i, value);
        System.out.println("New list after adding: " + list);
    }

    public static void swapValues(LinkedList<Integer> list, int indexOne, int indexTwo) {
        System.out.println("Old list before swapping: " + list);
        int indexOneVal = list.get(indexOne);
        int indexTwoVal = list.get(indexTwo);
        list.set(indexOne, indexTwoVal);
        list.set(indexTwo, indexOneVal);
        System.out.println("New list after swapping: " + list);
    }

    public static int findValue(LinkedList<Integer> list, int searchVal) {
        int res = list.indexOf(searchVal);
        return res;
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> randomList = new LinkedList<Integer>();
        Random rn = new Random();
        int upper = 9999;
        int lower = 1000;
        int searchVal = rn.nextInt(upper - lower) + lower;
        for (int i = 1; i <= 500; i++) {
            randomList.add(rn.nextInt(upper - lower) + lower);
        }
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        addAndSort(list, 4);
        swapValues(list, 1, list.size() - 1);
        int res = findValue(randomList, searchVal);
        System.out.println("Do random integer exists in linked list?: " + res);
    }
}
