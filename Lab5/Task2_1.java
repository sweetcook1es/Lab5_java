package Lab5;

import java.util.List;


interface Meowing {
    void meow();  // для мяуканья
}

class Cat implements Meowing {
    private String name;  // имя кота
    private int meowCount;  // счетчик мяуканий

    public Cat(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя кота не может быть пустым");
        }
        this.name = name;
        this.meowCount = 0;  // изначально кот не мяукал
    }

    public String getName() {
        return name;
    }

    public int getMeowCount() {
        return meowCount;
    }


    // метод мяуканья
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}

class Funs {
    public static void meowsCare(Meowing... meowables) {
        for (Meowing m : meowables) {
            m.meow();
        }
    }
}

public class Task2_1 {

    // принимает набор мяукающих объектов и вызывает мяуканье у каждого
    public static void makeAllMeow(List<Meowing> meowingObjects) {
        for (Meowing meower : meowingObjects) {
            meower.meow();
        }
    }
}