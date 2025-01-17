import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long countUnder18 = Person.countUnder18(persons);
        String youngMen = Person.getYoungMen(persons);
        List<String> potentialWorkers = Person.getPotentialWorkers(persons);
        System.out.println("количество несовершеннолетних : " + countUnder18);
        System.out.println("Список фамилий мужчин призывного возраста: " + youngMen);
        System.out.println("Список потенциальных работников с высшим образованием  : " + potentialWorkers);
    }
}
