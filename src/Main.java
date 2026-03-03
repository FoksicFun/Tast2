import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаём несколько машин
        Car car1 = new Car("VIN001", "Camry", "Toyota", 2020, 50000, 25000);
        Car car2 = new Car("VIN002", "X5", "BMW", 2022, 30000, 55000);
        Car car3 = new Car("VIN003", "Model 3", "Tesla", 2021, 20000, 45000);

        // Дубликат по VIN (должен считаться таким же как car1)
        Car car1Duplicate = new Car("VIN001", "Corolla", "Toyota", 2019, 80000, 20000);

        Car car4 = new Car("VIN004", "C-Class", "Mercedes", 2023, 10000, 60000);
        Car car5 = new Car("VIN005", "A4", "Audi", 2018, 70000, 30000);

        System.out.println("=== Проверка equals ===");
        System.out.println("car1.equals(car1Duplicate): " + car1.equals(car1Duplicate));
        System.out.println("car1.hashCode(): " + car1.hashCode());
        System.out.println("car1Duplicate.hashCode(): " + car1Duplicate.hashCode());
        System.out.println();

        //  Добавляем в HashSet (дубликаты не должны добавиться)
        System.out.println("=== Работа с HashSet ===");
        Set<Car> carSet = new HashSet<>();

        System.out.println("Добавляем car1: " + carSet.add(car1));           // true
        System.out.println("Добавляем car2: " + carSet.add(car2));           // true
        System.out.println("Добавляем car3: " + carSet.add(car3));           // true
        System.out.println("Добавляем car1Duplicate (дубликат): " +
                carSet.add(car1Duplicate));                        // false
        System.out.println("Добавляем car4: " + carSet.add(car4));           // true
        System.out.println("Добавляем car5: " + carSet.add(car5));           // true

        System.out.println("\nРазмер набора: " + carSet.size());
        System.out.println("Набор машин:");
        for (Car car : carSet) {
            System.out.println(car);
        }
        System.out.println();

        //  Сортировка по году выпуска (от новых к старым)
        System.out.println("=== Сортировка по году (новые → старые) ===");
        List<Car> carList = new ArrayList<>(carSet);

        System.out.println("До сортировки:");
        for (Car car : carList) {
            System.out.println(car.getYear() + " - " + car.getModel());
        }

        Collections.sort(carList);  // Используем наш compareTo

        System.out.println("\nПосле сортировки:");
        for (Car car : carList) {
            System.out.println(car.getYear() + " - " + car.getModel());
        }
    }
}