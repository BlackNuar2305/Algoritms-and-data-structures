package lesson2;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 1, 9, 3, 7, 6, 8, 5};

        insertSort(array);
        System.out.println(find(array, 5));
        System.out.println(binarySearch(array, 5));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
    }

    }

    
    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                finish = false;
            }
        }
        } while (!finish);
    }

    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int value, int min, int max) {
        int midpoint;

        if (max < min) {
            return -1;
        }
        else {
            midpoint  = (max - min) / 2 + min;
        }

        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        }
        else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, min, midpoint - 1);
            }
            else {
                return midpoint;
            }
        }
    }
}
