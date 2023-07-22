import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> availableDivider = findSimpleNumbers(100);
        for (Integer integer : availableDivider) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findAvailableDivided(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) result.add(i);
        }
        System.out.println(counter);
        return result;
    }

    public static int fib(int position) {
        if (position == 1 || position ==2) {
            return 1;
        }
        return fib(position - 1) + fib(position - 2);
    }
    
}