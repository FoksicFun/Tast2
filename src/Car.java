import java.util.Objects;

public class Car implements Comparable<Car> {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;

    // Конструктор
    public Car(String vin, String model, String manufacturer, int year, int mileage, double price) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    // Геттеры (для вывода информации)
    public String getVin() { return vin; }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }

    // Переопределяем equals - машины одинаковы только если VIN совпадает
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Objects.equals(vin, car.vin);  // Сравниваем только по VIN
    }

    // Переопределяем hashCode - должен соответствовать equals
    @Override
    public int hashCode() {
        return Objects.hash(vin);  // Хэш только от VIN
    }

    // Реализуем Comparable для сортировки по году (от новых к старым)
    @Override
    public int compareTo(Car other) {
        return other.year - this.year;  // От большего года к меньшему (новые → старые)
    }

    // Метод для красивого вывода
    @Override
    public String toString() {
        return manufacturer + " " + model + " (" + year + "), VIN: " + vin +
                ", пробег: " + mileage + " км, цена: $" + price;
    }
}
