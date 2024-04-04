import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }

    // определяем количество несовершеннолетних
    public static long countUnder18(Collection<Person> persons) {
        return persons.stream()
                .filter(x -> x.getAge() < 18) // отфильтровываем всех кому 18 лет и больше
                .count();  // счетчик
    }

    // пофамильный список мужчин призывного возраста
    public static String getYoungMen(Collection<Person> persons) {
        return persons.stream()
                .filter(x -> x.getAge() > 17 && x.getAge() < 27) //отфильтровываем всех кому меньше 18 и больше 26
                .filter(x -> x.getSex().equals(Sex.MAN)) // отсеиваем женщин
                .map(x -> x.getFamily()) // получаем строку
                .collect(Collectors.joining(" : ")); // формируем список разделяем объекты двоеточием

    }

    // список людей имеющих высшее образование в возрасте от 18 до 65 лет
    public static List<String> getPotentialWorkers(Collection<Person> persons) {
        return persons.stream()
                .filter(x -> x.getEducation().equals(Education.HIGHER)) // отбираем людей с высшим образованием
                .filter(x -> x.getAge() > 17 &&
                        ((x.getSex() == Sex.WOMAN && x.getAge() < 60) ||     // отбираем женщин до 60 лет мужчин до 65 лет
                                (x.getSex() == Sex.MAN && x.getAge() < 65)))
                .sorted(Comparator.comparing(Person::getFamily))   // сортируем по фамилии
                .map(person -> "Фамилия: " + person.getFamily() + ", Имя: " + person.getName() + // получаем строку
                        ", Возраст: " + person.getAge())
                .collect(Collectors.toList()); //формируем список
    }
}