package com.skypro.homework2_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<String, Employee> employees;

    public static void main(String[] args) {
        employees = new HashMap<>(Map.of());
//                "Попова Варвара Богдановна",
//                new Employee("Попова Варвара Богдановна", 85_000,5),
//                "Петрова Елена Павловна",
//                new Employee("Петрова Елена Павловна", 87_000, 2),
//                "Васильев Денис Андреевич",
//                new Employee("Васильев Денис Андреевич", 65_000, 1),
//                "Лянге Александр Григорьевич",
//                new Employee("Лянге Александр Григорьевич", 90_000, 3)));
        System.out.println(getEmployees());
        if (employees.isEmpty() ){
            System.out.println("ybxtuj");
        };
    }

    public static StringBuilder getEmployees() {
        StringBuilder rezString = new StringBuilder("");
        for (Employee employee: employees.values()) {
            rezString.append(employee.getFullName() + " " + employee.getSalary() + " " + employee.getId() + "\n");
        }
        return rezString;
    }

//    public static Map<String, Employee> getEmployees() {
//        return employees;
//    }

}
