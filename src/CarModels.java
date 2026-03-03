import java.util.*;

public class CarModels {
    public static void main(String[] args) {
        // Список с названиями моделей
        List<String> models = new ArrayList<>();
        models.add("Toyota Camry");
        models.add("BMW X5");
        models.add("Tesla Model 3");
        models.add("Toyota Camry");      // дубликат
        models.add("Mercedes C-Class");
        models.add("BMW X5");            // дубликат
        models.add("Tesla Model S");
        models.add("Audi A4");
        models.add("Tesla Model 3");     // дубликат

        System.out.println("Исходный список:");
        System.out.println(models);
        System.out.println();

        // Удаление дубликатов и сортировка в обратном порядке
        Set<String> uniqueModels = new HashSet<>(models);  // удаляем дубликаты

        List<String> sortedList = new ArrayList<>(uniqueModels);
        Collections.sort(sortedList, Collections.reverseOrder());  // обратный порядок

        System.out.println("После удаления дубликатов и сортировки:");
        System.out.println(sortedList);
        System.out.println();

        // Сохраняем в Set (уже сделали выше - uniqueModels)
        System.out.println("Сохранено в Set:");
        System.out.println(uniqueModels);
        System.out.println();

        // Замена Tesla на ELECTRO_CAR
        List<String> finalList = new ArrayList<>(uniqueModels);

        for (int i = 0; i < finalList.size(); i++) {
            if (finalList.get(i).contains("Tesla")) {
                finalList.set(i, "ELECTRO_CAR");
            }
        }

        System.out.println("После замены Tesla на ELECTRO_CAR:");
        System.out.println(finalList);
    }
}
