package seminar1;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        // long startTime = System.nanoTime();
        // System.out.println(sumNumbers(15));
        // System.out.println(simpleNumbers(100));
        // System.out.println(numberOfConbination(3, 6));
        // long endTime = System.nanoTime();
        // System.out.println(endTime - startTime);
        test();
    }

    public static int sumNumbers(int number) {
        int sum = 0;
        for(int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public static List<Integer> simpleNumbers(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) simple = false;
            }
            if (simple) result.add(i);
        }
        return result;
    }

    public static int numberOfConbination(int k, int num) {
        k--;
        int count = 0;
        if (k > 0) {
            for (int i = 1; i <= num; i++) {
                count++;
            }
            return count * numberOfConbination(k, num);
        }
        else {
            return 6;
        }
    }

    public static int fibRecursion(int number) {
        if (number == 1 || number == 2) return 1;
        return fibRecursion(number - 1) + fibRecursion(number - 2);
    }

    public static List<Integer> fib(int number) {
        List<Integer> result = new ArrayList<>();
        int a = 1;
        int b = 1;
        result.add(a);
        result.add(b);
        int count = 0;
        while (result.size() < number) {
            count ++;
            if (a > b) {
                b += a;
                result.add(b);
            }
            else {
                a += b;
                result.add(a);
            }
        }
        result.add(count);
        return result;
    }

    public static void test() {
        for (int i = 10; i <= 60; i += 10) {
            Date start = new Date();
            fib(i);
            Date end = new Date();
            long line = end.getTime() - start.getTime();
            start = new Date();
            fibRecursion(i);
            end = new Date();
            long rec = end.getTime() - start.getTime();
            System.out.printf("line: %s rec: %s%n", line, rec);
        }
    }
}
