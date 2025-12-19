package Lab5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Person {
    private String name;  // имя
    private Integer number;  // номер

    public Person(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + ":" + (number != null ? number : "нет номера");
    }
}


public class Task7_2 {

    // обрабатывает файл с данными людей
    public static Map<Integer, List<String>> processPeopleFile(String filename) throws IOException {
        return Files.lines(Paths.get(filename))  // читаем все строки из файла
                .map(line -> {
                    String[] parts = line.split(":");  // разделяем строку по двоеточию

                    // если строка не содержит двоеточия, создаем человека без номера
                    if (parts.length < 2) {
                        return new Person(parts[0].trim(), null);
                    }

                    String name = parts[0].trim();  // извлекаем имя
                    Integer number = null;

                    try {
                        // пытаемся преобразовать номер в число
                        number = Integer.parseInt(parts[1].trim());
                    } catch (NumberFormatException e) {
                        // если номер не число, оставляем null
                    }

                    return new Person(name, number);
                })
                .filter(person -> person.getNumber() != null)  // убираем людей без номеров
                .collect(Collectors.groupingBy(
                        Person::getNumber,  // группируем по номеру
                        Collectors.mapping(
                                person -> {
                                    String name = person.getName().toLowerCase();
                                    if (!name.isEmpty()) {
                                        // Делаем первую букву заглавной
                                        name = name.substring(0, 1).toUpperCase() + name.substring(1);
                                    }
                                    return name;
                                },
                                Collectors.toList()  // Собираем имена в список
                        )
                ));
    }
}