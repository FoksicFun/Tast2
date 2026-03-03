import java.util.*;
import java.util.stream.Collectors;

public class CarParkAnalysis {
    public static void main(String[] args) {
        // Создаём список машин (как в предыдущем задании)
        List<Car> cars = Arrays.asList(
                new Car("VIN001", "Camry", "Toyota", 2020, 45000, 25000),
                new Car("VIN002", "X5", "BMW", 2022, 30000, 55000),
                new Car("VIN003", "Model 3", "Tesla", 2021, 60000, 45000),
                new Car("VIN004", "C-Class", "Mercedes", 2023, 10000, 60000),
                new Car("VIN005", "A4", "Audi", 2018, 70000, 30000),
                new Car("VIN006", "Corolla", "Toyota", 2019, 20000, 22000),
                new Car("VIN007", "Model S", "Tesla", 2022, 15000, 80000),
                new Car("VIN008", "E-Class", "Mercedes", 2021, 55000, 50000)
        );

        System.out.println("Исходный список машин:");
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();

        // Фильтруем машины с пробегом < 50.000 км
        System.out.println("1. Машины с пробегом < 50.000 км");
        List<Car> lowMileageCars = cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .collect(Collectors.toList());

        for (Car car : lowMileageCars) {
            System.out.println(car);
        }
        System.out.println();

        // Сортируем по цене (по убыванию)
        System.out.println("2. Отсортировано по цене (убывание)");
        List<Car> sortedByPrice = cars.stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .collect(Collectors.toList());

        for (Car car : sortedByPrice) {
            System.out.println(car);
        }
        System.out.println();

        // Топ-3 самые дорогие машины
        System.out.println("3. Топ-3 самые дорогие машины");
        List<Car> top3Expensive = cars.stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(3)
                .collect(Collectors.toList());

        for (Car car : top3Expensive) {
            System.out.println(car);
        }
        System.out.println();

        // Средний пробег всех машин
        System.out.println("4. Средний пробег всех машин");
        double averageMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0.0);

        System.out.println("Средний пробег: " + averageMileage + " км");
        System.out.println();

        // Группировка по производителю
        System.out.println("5. Группировка по производителю");
        Map<String, List<Car>> groupedByManufacturer = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        for (Map.Entry<String, List<Car>> entry : groupedByManufacturer.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Car car : entry.getValue()) {
                System.out.println("  - " + car.getModel() + " (" + car.getYear() + ")");
            }
        }
    }
}