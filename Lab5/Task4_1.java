package Lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Task4_1 {

    // генерирует логины для списка учеников
    public static List<String> generateLogins(List<String> students) {
        List<String> logins = new ArrayList<>();  // список логинов
        Map<String, Integer> surnameCount = new HashMap<>();  // Мап для подсчета повторений фамилий

        // обрабатываем каждого ученика
        for (String student : students) {
            String[] parts = student.split(" ");

            // пропускаем некорректные строки (без фамилии и имени)
            if (parts.length < 2) {
                continue;
            }

            // извлекаем фамилию (первое слово)
            String surname = parts[0].trim();

            // текущее количество повторений фамилии и увеличиваем на 1
            int count = surnameCount.getOrDefault(surname, 0) + 1;
            surnameCount.put(surname, count);

            // формируем логин: если фамилия встречается в первый раз - просто фамилия,
            // иначе - фамилия + номер повторения
            String login = (count == 1) ? surname : surname + count;
            logins.add(login);
        }

        return logins;
    }
}