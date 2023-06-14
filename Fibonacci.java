import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите i: ");
        int i = sc.nextInt();
        sc.close();
        if (i < 10 || i > 100000) {
            System.out.println("Ошибка: i должно быть в диапазоне от 10 до 100000");
            return;
        }
        int fib = fibonacci(i);
        int[] mostFrequentDigit = findMostFrequentDigit(fib);
        System.out.printf("Fibonacci(%d) = %d # вернет [(%d, %d)]", i, fib, mostFrequentDigit[0], mostFrequentDigit[1]);
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int[][] matrix = {{1, 1}, {1, 0}};
        matrix = power(matrix, n-1);
        return matrix[0][0];
    }

    public static int[][] power(int[][] matrix, int n) {
        if (n <= 1) return matrix;
        matrix = power(matrix, n/2);
        matrix = multiply(matrix, matrix);
        if (n % 2 == 1) {
            int[][] base = {{1, 1}, {1, 0}};
            matrix = multiply(matrix, base);
        }
        return matrix;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        c[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
        c[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
        c[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
        c[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];
        return c;
    }

    public static int[] findMostFrequentDigit(int n) {
        int[] count = new int[10];
        while (n > 0) {
            int digit = n % 10;
            count[digit]++;
            n /= 10;
        }
        int maxCount = 0;
        int maxDigit = -1;
        for (int i = 0; i < 10; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxDigit = i;
            } else if (count[i] == maxCount) {
                maxDigit = Math.max(maxDigit, i);
            }
        }
        return new int[]{maxDigit, maxCount};
    }
}
