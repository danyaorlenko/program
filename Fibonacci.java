import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите два числа: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int start = Math.min(num1, num2);
        int step = Math.abs(num1 - num2);

        for (int i = 0; i <= step; i++) {
            System.out.print(start * start + " ");
            start += 1;
        }
    }
}
