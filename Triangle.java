import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты первой вершины (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("Введите координаты второй вершины (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.print("Введите координаты третьей вершины (x3 y3): ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        // Находим координаты середин каждой стороны треугольника
        double xab = (x1 + x2) / 2;
        double yab = (y1 + y2) / 2;
        double xac = (x1 + x3) / 2;
        double yac = (y1 + y3) / 2;
        double xbc = (x2 + x3) / 2;
        double ybc = (y2 + y3) / 2;

        // Находим координаты точек пересечения медиан
        double xma = (xbc + xac) / 2;
        double yma = (ybc + yac) / 2;
        double xmb = (xac + xab) / 2;
        double ymb = (yac + yab) / 2;
        double xmc = (xab + xbc) / 2;
        double ymc = (yab + ybc) / 2;

        // Находим среднее значение координат каждой точки пересечения по каждой оси X и Y
        double x = (xma + xmb + xmc) / 3;
        double y = (yma + ymb + ymc) / 3;

        System.out.printf("Координаты барицентра треугольника: (%.4f, %.4f)", x, y);
    }
}
