import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StreamMain streamMain = new StreamMain();

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4); // создаем коллекцию чисел

        List<Integer> result = new ArrayList<>();

        for (Integer num : intList) {
            if (num > 0 && num % 2 == 0) { // выбираем числа положительные и четные
                result.add(num); // сохраняем их  в другую коллекцию
            }
        }

        Collections.sort(result); // сортируем по возрастанию

        streamMain.main(intList); // результат работы метода " main "класса "StreamMain"

        System.out.println("");
        for (Integer a : result) { // выводим результат в консоль
            System.out.print(a + " : ");
        }
    }
}

