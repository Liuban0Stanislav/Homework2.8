package com.skypro.homework2_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static int manOrWomen = randomNumGenerator(2);
    static Map<String, Employee> employees;
    private static String fullNameKey =
            randomLastNameGeneration(manOrWomen) +
                    randomFirstNameGeneration(manOrWomen) +
                    randomLastNameGeneration(manOrWomen);
    public static void main(String[] args) {
        employees = new HashMap<>(10);
        for (int i = 0; i < employees.size() - 2; i++) {
            employees.put(
                    fullNameKey,
                    new Employee(fullNameKey, randomNumGenerator(100_000),
                            randomNumGenerator(5)));
        }
        System.out.println(employees);
    }
    public static int randomNumGenerator(int limitGeneration) {
        java.util.Random random = new java.util.Random();
        int randomNum = random.nextInt(limitGeneration);
        return randomNum;
    }

    public static String randomFirstNameGeneration(int manOrWomen) {
        String firstName = "";
        //Итоговая строка, куда будут записываться сгенерированные имена

        List<String> firstMaleName = new ArrayList(List.of(
                "Александр", "Вадим", "Геннадий", "Анаколий", "Дмитрий", "Егор", "Иван"));
        List<String> firstFemaleName = new ArrayList<>(List.of(
                "Анна", "Варвара", "Елена", "Елизавета", "Аэлита", "Элеонора", "Анжелика"));

        //листы с вариантами женских и мужских имен, фамилий и отчеств

        if (manOrWomen == 0) {                   //если 0 то имя мужское, если 1 то - женское
            firstName = firstMaleName.get(randomNumGenerator(firstMaleName.size()));
            //генерируем рандомные числа и подставляем их в элементы массивов, а затем "собираем" строку
        } else {
            firstName = firstFemaleName.get(randomNumGenerator(firstFemaleName.size()));
        }
        return firstName;
    }

    public static String randomMiddleNameGeneration(int manOrWomen) {
        String middleName = "";
        //Итоговая строка, куда будут записываться сгенерированные имена

        String[] middleMaleName = {"Матвеевич", "Иванович", "Павлович", "Романович", "Семенович", "Тимофеевич",
                "Богданович"};
        String[] middleFemaleName = {"Матвеевна", "Ивановна", "Павловна", "Романовна", "Семеновна", "Тимофеевна",
                "Богдановна"};

        //массивы с вариантами женских м мужских имен, фамилий и отчеств

        if (manOrWomen == 0) {                   //если 0 то имя мужское, если 1 то - женское
            middleName = middleMaleName[randomNumGenerator(middleMaleName.length)];
            //генерируем рандомные числа и подставляем их в элементы массивов, а затем "собираем" строку
        } else {
            middleName = middleFemaleName[randomNumGenerator(middleFemaleName.length)];
        }
        return middleName;
    }

    public static String randomLastNameGeneration(int manOrWomen) {
        String LastName = "";
        //Итоговая строка, куда будут записываться сгенерированные имена

        String[] lastMaleName = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов"};
        String[] lastFemaleName = {"Иванова", "Смирнова", "Кузнецова", "Попова", "Васильева", "Петрова", "Соколова"};
        //массивы с вариантами женских м мужских имен, фамилий и отчеств

        if (manOrWomen == 0) {                   //если 0 то имя мужское, если 1 то - женское
            LastName = lastMaleName[randomNumGenerator(lastMaleName.length)];
            //генерируем рандомные числа и подставляем их в элементы массивов, а затем "собираем" строку
        } else {
            LastName = lastFemaleName[randomNumGenerator(lastFemaleName.length)];
        }
        return LastName;
    }

    public int getManOrWomen() {
        return manOrWomen;
    }
}
