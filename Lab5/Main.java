package Lab5;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("\nВведите номер задания (1-8) или 0 для выхода: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        exit = true;
                        System.out.println("\nВыход из программы");
                        break;

                    case 1:
                        Task1_1(scanner);
                        break;

                    case 2:
                        Task2_1(scanner);
                        break;

                    case 3:
                        Task3_1(scanner);
                        break;

                    case 4:
                        Task4_1(scanner);
                        break;

                    case 5:
                        Task5_1(scanner);
                        break;

                    case 6:
                        Task6_5(scanner);
                        break;

                    case 7:
                        Task7_1(scanner);
                        break;

                    case 8:
                        Task7_2(scanner);
                        break;

                    default:
                        System.out.println("Неверный выбор! Пожалуйста, введите число от 0 до 8.");
                }
            } else {
                System.out.println("Ошибка! Введите число.");
                scanner.nextLine();
            }
        }

        scanner.close();
        System.out.println("\nПрограмма завершена.");
    }

    private static void displayMenu() {
        System.out.println("\nГЛАВНОЕ МЕНЮ");
        System.out.println("1. Задание 1 - Дроби с кэшированием");
        System.out.println("2. Задание 2 - Коты и мяуканья");
        System.out.println("3. Задание 3 - Удаление элементов из списка");
        System.out.println("4. Задание 4 - Генерация логинов учеников");
        System.out.println("5. Задание 5 - Звонкие согласные буквы");
        System.out.println("6. Задание 6 - Обратный порядок очереди");
        System.out.println("7. Задание 7.1 - Обработка точек и создание ломаной");
        System.out.println("8. Задание 7.2 - Обработка файла с именами");
        System.out.println("0. Выход из программы");
    }

    // для получения положительных целых чисел
    private static int getPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= 0) return number;
                System.out.println("Число не может быть отрицательным!");
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }

    // для чисел с ограничениями по диапазону
    private static int getPositiveIntWithLimit(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) return number;
                System.out.println("Число должно быть в диапазоне от " + min + " до " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }

    // для любых целых чисел
    private static int getInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }

    // для текста только с буквами
    private static String getLettersInput(Scanner scanner, String prompt, boolean required) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!required && input.isEmpty()) return input;
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым!");
                continue;
            }
            if (input.matches("[a-zA-Zа-яА-ЯёЁ\\s-]+")) return input;
            System.out.println("Поле должно содержать только буквы, пробелы и дефисы!");
        }
    }

    // для непустого ввода
    private static String getNonEmptyInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым!");
            }
        } while (input.isEmpty());
        return input;
    }

    // для чисел с точкой
    private static double getDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
            }
        }
    }

    // для ответов да/нет
    private static boolean getYesNoInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("да") || input.equals("yes") || input.equals("д") || input.equals("y")) {
                return true;
            } else if (input.equals("нет") || input.equals("no") || input.equals("н") || input.equals("n")) {
                return false;
            } else {
                System.out.println("Введите 'да' или 'нет'!");
            }
        }
    }


    private static void Task1_1(Scanner scanner) {
        System.out.println("\nЗадание 1 - Дроби с кэшированием\n");

        try {
            System.out.println("Первая дробь:");
            int num1 = getInt(scanner, "Введите числитель: ");
            int den1;
            while (true) {
                den1 = getInt(scanner, "Введите знаменатель (не может быть 0): ");
                if (den1 != 0) break;
                System.out.println("Ошибка: знаменатель не может быть равен нулю!");
            }

            System.out.println("\nВторая дробь:");
            int num2 = getInt(scanner, "Введите числитель: ");
            int den2;
            while (true) {
                den2 = getInt(scanner, "Введите знаменатель (не может быть 0): ");
                if (den2 != 0) break;
                System.out.println("Ошибка: знаменатель не может быть равен нулю!");
            }

            Task1_1 fraction1 = new Task1_1(num1, den1);
            Task1_1 fraction2 = new Task1_1(num2, den2);

            System.out.println("\nРезультаты:");
            System.out.println("Дробь 1: " + fraction1 + " = " + fraction1.getRealValue());
            System.out.println("Дробь 2: " + fraction2 + " = " + fraction2.getRealValue());
            System.out.println("Дробь 1 равна Дроби 2? " + fraction1.equals(fraction2));

            double value1 = fraction1.getRealValue();
            double value2 = fraction1.getRealValue();
            System.out.println("Первое вычисление: " + value1);
            System.out.println("Второе вычисление (из кэша): " + value2);
            System.out.println("Значения совпадают? " + (value1 == value2));

            boolean changeFraction = getYesNoInput(scanner, "\nХотите изменить первую дробь? (да/нет): ");
            if (changeFraction) {
                System.out.println("\nИзменение первой дроби:");
                int newNum = getInt(scanner, "Введите новый числитель: ");
                int newDen;
                while (true) {
                    newDen = getInt(scanner, "Введите новый знаменатель (не может быть 0): ");
                    if (newDen != 0) break;
                    System.out.println("Ошибка: знаменатель не может быть равен нулю!");
                }

                fraction1.setNumerator(newNum);
                fraction1.setDenominator(newDen);

                System.out.println("\nОбновленные результаты:");
                System.out.println("Дробь 1: " + fraction1 + " = " + fraction1.getRealValue());
                System.out.println("Дробь 2: " + fraction2 + " = " + fraction2.getRealValue());
                System.out.println("Дробь 1 равна Дроби 2? " + fraction1.equals(fraction2));

                double value01 = fraction1.getRealValue();
                double value02 = fraction1.getRealValue();
                System.out.println("Первое вычисление: " + value01);
                System.out.println("Второе вычисление (из кэша): " + value02);
                System.out.println("Значения совпадают? " + (value01 == value02));
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }


    private static void Task2_1(Scanner scanner) {
        System.out.println("\nЗадание 2 - Коты и мяуканья\n");

        int catCount = getPositiveIntWithLimit(scanner, "Сколько котов создать? (от 1 до 100): ", 1, 100);

        List<Meowing> cats = new ArrayList<>();

        for (int i = 1; i <= catCount; i++) {
            System.out.println("\nКот " + i + ":");
            String name = getLettersInput(scanner, "Введите имя кота: ", true);

            Cat cat = new Cat(name);

            boolean meowNow = getYesNoInput(scanner, "Заставить кота " + name + " мяукнуть сейчас? (да/нет): ");
            if (meowNow) {
                Funs.meowsCare(cat);
            }
            cats.add(cat);
        }

        int meowTimes = getPositiveInt(scanner, "\nСколько раз заставить всех котов мяукнуть? (введите число): ");

        for (int i = 0; i < meowTimes; i++) {
            Task2_1.makeAllMeow(cats);
        }

        System.out.println("\nСтатистика мяуканий:");
        for (Meowing meower : cats) {
            if (meower instanceof Cat) {
                Cat cat = (Cat) meower;
                System.out.println(cat.getName() + " мяукал " + cat.getMeowCount() + " раз");
            }
        }
    }


    private static void Task3_1(Scanner scanner) {
        System.out.println("\nЗадание 3 - Удаление элементов из списка\n");

        System.out.print("\nВведите элементы через пробел: ");
        String wordsInput = scanner.nextLine();
        String[] wordsStr = wordsInput.split(" ");

        List<String> words = new ArrayList<>();
        for (String word : wordsStr) {
            if (!word.trim().isEmpty()) {
                words.add(word.trim());
            }
        }

        System.out.print("Какой элемент удалить из списка? ");
        String wordToRemove = scanner.nextLine();

        System.out.println("\nИсходный список: " + words);
        List<String> result = Task3_1.removeAllOccurrences(words, wordToRemove);
        System.out.println("После удаления всех \"" + wordToRemove + "\": " + result);
    }



    private static void Task4_1(Scanner scanner) {
        System.out.println("\nЗадание 4 - Генерация логинов учеников\n");

        int studentCount = getPositiveIntWithLimit(scanner, "Сколько учеников? (не более 100): ", 1, 100);

        // записываем данные в файл
        try (FileWriter writer = new FileWriter("students.txt")) {
            System.out.println("\nВведите данные учеников в формате 'Фамилия Имя':");
            for (int i = 1; i <= studentCount; i++) {
                String line;
                while (true) {
                    System.out.print("Ученик " + i + ": ");
                    line = scanner.nextLine().trim();
                    if (line.isEmpty()) {
                        System.out.println("Строка не может быть пустой!");
                        continue;
                    }
                    String[] parts = line.split(" ");
                    if (parts.length >= 2) {
                        // Проверяем, что фамилия и имя содержат только буквы
                        if (parts[0].matches("[a-zA-Zа-яА-ЯёЁ-]+") && parts[1].matches("[a-zA-Zа-яА-ЯёЁ-]+")) {
                            break;
                        } else {
                            System.out.println("Фамилия и имя должны содержать только буквы!");
                        }
                    } else {
                        System.out.println("Введите фамилию и имя через пробел!");
                    }
                }
                writer.write(line + "\n");
            }
            System.out.println("Данные успешно записаны в файл students.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        // читаем данные из файла
        List<String> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // игнорируем пустые строки
                    students.add(line);
                }
            }
            System.out.println("Прочитано строк из файла: " + students.size());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // генерируем логины
        List<String> logins = Task4_1.generateLogins(students);

        System.out.println("\nСгенерированные логины:");
        for (int i = 0; i < logins.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i) + " -> " + logins.get(i));
        }
    }


    private static void Task5_1(Scanner scanner) {
        System.out.println("\nЗадание 5 - Звонкие согласные буквы\n");

        // записываем данные в файл
        try (FileWriter writer = new FileWriter("text.txt")) {
            String text = getNonEmptyInput(scanner, "Введите текст на русском языке: ");
            writer.write(text);
            System.out.println("Текст успешно записан в файл text.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        // читаем данные из файла
        String fileContent = "";
        try {
            fileContent = Files.readString(Path.of("text.txt"));
            System.out.println("\nСодержимое файла целиком:");
            System.out.println(fileContent);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        Set<Character> consonants = Task5_1.findVoicedConsonants(fileContent);

        if (consonants.isEmpty()) {
            System.out.println("\nВ тексте не найдено звонких согласных букв.");
        } else {
            System.out.println("\nНайденные звонкие согласные буквы (в алфавитном порядке):");
            List<Character> sortedConsonants = new ArrayList<>(consonants);
            Collections.sort(sortedConsonants);
            for (char c : sortedConsonants) {
                System.out.print(c + " ");
            }
            System.out.println("\nВсего найдено: " + consonants.size() + " уникальных букв");
        }

        System.out.println("\nСписок всех звонких согласных в русском языке:");
        System.out.println("б, в, г, д, ж, з, й, л, м, н, р");
    }


    private static void Task6_5(Scanner scanner) {
        System.out.println("\nЗадание 6 - Обратный порядок очереди\n");

        int elementCount = getPositiveIntWithLimit(scanner, "Сколько элементов добавить в очередь? (от 1 до 100): ", 1, 100);

        Queue<Integer> queue1 = new LinkedList<>();

        System.out.println("Введите " + elementCount + " элементов:");
        for (int i = 1; i <= elementCount; i++) {
            int element = getInt(scanner, "Элемент " + i + ": ");
            queue1.offer(element);
        }

        System.out.println("\nИсходная очередь: " + queue1);

        Queue<Integer> queue2 = Task6_5.reverseQueue(new LinkedList<>(queue1));

        System.out.println("Результирующая очередь: " + queue2);

        System.out.println("\nИзвлечение элементов из исходной очереди:");
        while (!queue1.isEmpty()) {
            System.out.print(queue1.poll() + " ");
        }

        System.out.println("\nИзвлечение элементов из результирующей очереди:");
        while (!queue2.isEmpty()) {
            System.out.print(queue2.poll() + " ");
        }
        System.out.println();
    }


    private static void Task7_1(Scanner scanner) {
        System.out.println("\nЗадание 7.1 - Обработка точек и создание ломаной\n");

        int pointCount = getPositiveIntWithLimit(scanner, "Сколько точек создать? (от 1 до 50): ", 1, 50);

        List<Point> points = new ArrayList<>();

        System.out.println("Введите координаты точек (X Y через пробел):");
        for (int i = 1; i <= pointCount; i++) {
            System.out.println("Точка " + i + ":");
            double x = getDouble(scanner, "  X: ");
            double y = getDouble(scanner, "  Y: ");
            points.add(new Point(x, y));
        }

        System.out.println("\nИсходные точки:");
        for (int i = 0; i < points.size(); i++) {
            System.out.println((i + 1) + ". " + points.get(i));
        }

        try {
            Polyline polyline = Task7_1.processPoints(points);
            System.out.println("Ломаная линия: " + polyline);
        } catch (Exception e) {
            System.out.println("Ошибка при обработке точек: " + e.getMessage());
        }
    }


    private static void Task7_2(Scanner scanner) {
        System.out.println("\nЗадание 7.2 - Обработка файла с именами\n");

        try {
            int peopleCount = getPositiveIntWithLimit(scanner, "Сколько людей? (от 1 до 50): ", 1, 50);

            // записываем данные в файл
            try (FileWriter writer = new FileWriter("people.txt")) {
                System.out.println("\nВведите данные людей в формате 'Имя:Номер':");

                for (int i = 1; i <= peopleCount; i++) {
                    String line;
                    while (true) {
                        System.out.print("Человек " + i + ": ");
                        line = scanner.nextLine().trim();

                        if (line.isEmpty()) {
                            System.out.println("Строка не может быть пустой!");
                            continue;
                        }

                        // проверяем формат
                        if (line.contains(":")) {
                            String[] parts = line.split(":");
                            if (parts.length >= 1 && parts[0].matches("[a-zA-Zа-яА-ЯёЁ\\s-]+")) {
                                if (parts.length == 2) {
                                    try {
                                        Integer.parseInt(parts[1].trim());
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Номер должен быть целым числом!");
                                        continue;
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Имя должно содержать только буквы!");
                            }
                        } else {
                            // если нет номера, проверяем что это только буквы
                            if (line.matches("[a-zA-Zа-яА-ЯёЁ\\s-]+")) {
                                break;
                            } else {
                                System.out.println("Имя должно содержать только буквы!");
                            }
                        }
                    }
                    writer.write(line + "\n");
                }
                System.out.println("Данные успешно записаны в файл people.txt");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
                return;
            }

            Map<Integer, List<String>> result = Task7_2.processPeopleFile("people.txt");

            System.out.println("\nРезультат:");
            System.out.println("Группировка по номерам:");

            if (result.isEmpty()) {
                System.out.println("Нет людей с номерами.");
            } else {
                // сортируем по номерам
                List<Integer> sortedKeys = new ArrayList<>(result.keySet());
                Collections.sort(sortedKeys);

                for (Integer key : sortedKeys) {
                    System.out.println(key + ": " + result.get(key));
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}