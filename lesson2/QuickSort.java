package lesson2;

import java.util.Random;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }

        sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sort(int[] array, int startPosirion, int endPosition) {
        int leftPosition = startPosirion;
        int rightPosition = endPosition;
        int pivot = array[(startPosirion + endPosition) / 2];
        do {
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
            
        } while (leftPosition <= rightPosition);

        if (leftPosition < endPosition) {
            sort(array, leftPosition, endPosition);
        }
        if (startPosirion < rightPosition) {
            sort(array, startPosirion, rightPosition);
        }
    }
}