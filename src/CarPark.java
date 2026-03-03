import java.util.Random;

public class CarPark {
    public static void main(String[] args) {
        Random random = new Random();

        // 1. Создаём массив из 50 случайных годов (от 2000 до 2025)
        int[] cars = new int[50];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = random.nextInt(26) + 2000; // 2000-2025
        }

        // 2. Выводим машины после 2015 года
        System.out.println("Машины после 2015 года:");
        for (int year : cars) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
        }
        System.out.println("\n");

        // 3. Считаем средний возраст
        int currentYear = 2026;
        int totalAge = 0;

        for (int year : cars) {
            totalAge += currentYear - year;
        }

        double averageAge = (double) totalAge / cars.length;
        System.out.println("Средний возраст авто: " + averageAge);
    }
}
