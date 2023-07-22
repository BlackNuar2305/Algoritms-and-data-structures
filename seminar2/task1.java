package seminar2;

import java.util.Random;
import java.util.Date;
/**
 * task1
 */
public class task1 {

    public static void main(String[] args) {
        // int[] array = new int[10];
        // Random rnd = new Random();
        // for (int i = 0; i < array.length; i++) {
        //     array[i] = rnd.nextInt(1000);
        // }
        // HW.sort(array);
        // for (int i = 0; i < array.length; i++) {
        //     System.out.println(array[i]);
        // }
        test();

    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(leftPosition + rightPosition) / 2];
        
        while (leftPosition <= rightPosition) {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }

            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }

        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }

    public static int bynarySearch(int[] array, int value) {
        return bynarySearch(array, value, 0, array.length - 1);
    }

    public static int bynarySearch(int[] array, int value, int min, int max) {
        int midPoint = ((max - min) / 2) + min;
        if (max < min) return -1;
        if (array[midPoint] < value) {
            return bynarySearch(array, value, midPoint, max);
        }
        else {
            if (array[midPoint] > value) {
                return bynarySearch(array, value, min, midPoint);
            }
            else {
                return midPoint;
            }
        }
        
    }

    public static void test() {
        for (int i = 10000; i < 100000; i += 10000) {
            int[] array = new int[i];
            Random rnd = new Random();
            Date start = new Date();
            for (int j = 0; j < array.length; j++) {
                array[j] = rnd.nextInt(1000);
            }
            Date end = new Date();
            start = new Date();
            bubbleSort(array);
            end = new Date();
            long bubble = end.getTime() - start.getTime();
            start = new Date();
            quickSort(array, 0, array.length - 1);
            end = new Date();
            long quick = end.getTime() - start.getTime();
            start = new Date();
            HW.sort(array);
            end = new Date();
            long heap = end.getTime() - start.getTime();
            System.out.printf("heap: %s, bubble: %s, quick: %s%n", heap, bubble, quick);
        }
    }
}