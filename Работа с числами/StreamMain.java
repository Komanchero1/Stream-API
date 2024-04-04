import java.util.Comparator;
import java.util.List;

public class StreamMain {
    public void main(List<Integer> list) {
        list.stream()  //создаем "sttrem"
                .filter(x -> x > 0)  // выбираем положительные числа
                .filter(x -> x % 2 == 0) // выбираем четные числа
                .sorted(Comparator.naturalOrder()) // сортируем отобранные числа по возрастанию
                .forEach(x -> System.out.print(x + " : ")); // выводим результат
    }
}
