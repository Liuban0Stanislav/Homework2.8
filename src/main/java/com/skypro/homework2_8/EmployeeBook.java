package com.skypro.homework2_8;

import com.skypro.homework2_8.execptions.FullMapException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class EmployeeBook {

    private Map<String, Employee> employees = new HashMap<>(Map.of(
            "Попова Варвара Богдановна",
            new Employee("Попова Варвара Богдановна", 85_000, 5),
            "Петрова Елена Павловна",
            new Employee("Петрова Елена Павловна", 87_000, 2),
            "Васильев Денис Андреевич",
            new Employee("Васильев Денис Андреевич", 65_000, 1),
            "Лянге Александр Григорьевич",
            new Employee("Лянге Александр Григорьевич", 90_000, 3),
            "Кузнецов Александр Семенович",
            new Employee("Кузнцов Александр Семенович", 67_000, 4),
            "Скворцов Сергей Денисович",
            new Employee("Скворцов Сергей Денисович", 63_000, 4)
    ));


    public StringBuilder printEmployees() {
        StringBuilder rezString = new StringBuilder("");
        if (employees.isEmpty()) {
            return rezString.append("интерфейс Map не содержит ни одного сотрудника");
        }
        for (Employee employee : employees.values()) {
            rezString.append("- " + employee.getFullName() +
                    ", зарплата: " + employee.getSalary() +
                    ", отдел: " + employee.getDept() + "\n");
        }
        return rezString;
    }


    public void addEmployee(String fullName, int salary, int dept) {
        if (Employee.getIdCounter() > 6) {
            throw new FullMapException();
        }
        employees.put(fullName, new Employee(fullName, salary, dept));
    }

    public void removeEmployee(String fullName) {
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
        } else {
            throw new RuntimeException();
        }
    }


    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public void changeEmployee(String fullNameDeletingEmlpoyee,
                               String fullNameNewEmployee,
                               Integer newSalary,
                               Integer newDept) {
        if (employees.containsKey(fullNameDeletingEmlpoyee)) {
        removeEmployee(fullNameDeletingEmlpoyee);
        addEmployee(fullNameNewEmployee, newSalary, newDept);
        } else {
            throw new NullPointerException();
        }
    }

    public StringBuilder printEmployeesWithoutDept() {
        StringBuilder rezString = new StringBuilder("");
        if (employees.isEmpty()) {
            return rezString.append("интерфейс Map не содержит ни одного сотрудника");
        }
        for (Employee employee : employees.values()) {
            rezString.append("- " + employee.getFullName() +
                    ", зарплата: " + employee.getSalary() +
                    "\n");
        }
        return rezString;
    }


    public StringBuilder printEmployeesAccordingToDept() {
        int[] arrDept = new int[employees.size()];
        /**
         * Пытаюсь получить упорядоченный список существующих отделов, где отделы не повторяются.
         * Для этого:
         * Сохдаю массив arrDept и записываю в него номера существующих отделов в произвольном порядке.
         */
        int i = 0;
        for (Employee employee: employees.values()) {
            arrDept[i++] = employee.getDept();
        }
        System.out.println("Несортированный массив arrDept: " + Arrays.toString(arrDept));
        Arrays.sort(arrDept);
        System.out.println("Сортированный массив arrDept: " + Arrays.toString(arrDept));
        int arrElCounter = 1;
        /**
         * После сортировки массива в нем могут быть одинаковые отделы
         * Создаю переменную arrElCounter, которая просуммирует уникальные отделы, и станет количеством элементов
         * в массиве с сортированными неповторяющимися отделами.
         */
        for (i = 0; i < employees.size() - 1; i++) {
            if (arrDept[i] != arrDept[i + 1]) {
                arrElCounter++;
            }
        }
        /**
         * Переменная заполнилась и теперь можно создать итоговый массив с отделами arrDeptUnic.
         */
        int[] arrDeptUnic = new int[arrElCounter];
        /**
         * Теперь нужно пройтись циклом по сортированному массиву arrDept,
         * выбрать из него неповторяющиеся номера отделов, и записать их в массив arrDeptUnic
         * который имеет необходимое количество элементов.
         */
        arrElCounter = 0;
        System.out.println("Пустой массив arrDeptUnic: " + Arrays.toString(arrDeptUnic));
        for (i = 0; i < employees.size() - 1; i++) {
            if (arrDept[i] != arrDept[i + 1]) {
                arrDeptUnic[arrElCounter]=arrDept[i];
                System.arraycopy(arrDept, i, arrDeptUnic, arrElCounter, 1);
                arrElCounter++;
            }
        }
        arrDeptUnic[arrElCounter] = arrDept[arrDept.length - 1];
        System.out.println("Заполненный массив arrDeptUnic: " + Arrays.toString(arrDeptUnic));
        /**
         * Массив с существующими отделами получен, и теперь можно найти
         * каждого сотрудника принадлежащего своему отделу и вывести его в консоль.
         * Для этого создаю цикл в цикле. Внешний цикл - это перебор отделов. Внутренний
         * цикл это перебор сотрудников и отбор тех чей номер отдела совпадает с
         * номерм отдела во внешнем цикле.
         */
        StringBuilder sbRez = new StringBuilder("");
        for (i = 0; i < arrDeptUnic.length; i++) {
            sbRez.append("\nОтдел №" + arrDeptUnic[i] + "\n");
            for(Employee employee: employees.values()){
                if(employee.getDept() == arrDeptUnic[i]){
                    sbRez.append(employee.getFullName() + " \n");
                }
            }
        }
        return sbRez;
    }

    public void salaryIndexing(double percentOfIndexing) {
        for (Employee employee: employees.values()) {
            double increasedSalary = employee.getSalary() * (1 + percentOfIndexing / 100);
            employee.setSalary((int) increasedSalary);
        }
    }
    public StringBuilder salariesBILO() {
        Map<String , Employee> emloyeeSalaryesBILO = employees;
        StringBuilder rezString = new StringBuilder("");
        if (emloyeeSalaryesBILO.isEmpty()) {
            return rezString.append("интерфейс Map не содержит ни одного сотрудника");
        }
        for (Employee employee : emloyeeSalaryesBILO.values()) {
            rezString.append("- " + employee.getFullName() +
                    ", зарплата: " + employee.getSalary() +
                    ", отдел: " + employee.getDept() + "\n");
        }
        return rezString;
    }

    public static void printEmployeeInfo(Employee employee) {
        System.out.println("id: " + employee.getId() + ", полное имя: " +
                employee.getFullName() + ", зарплата: " +
                new DecimalFormat("###,###.##").format(employee.getSalary()) +
                " рублей, " + " отдел: " + employee.getDept());
    }

    public StringBuilder salaryLessThan(int lessThanThisNum) {
        int lessSalariesCounter = 0;
        StringBuilder rezString = new StringBuilder("");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < lessThanThisNum) {
                rezString.append("- " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() +
                        ", отдел: " + employee.getDept() + "\n");
                lessSalariesCounter++;
            }

        }
        if (lessSalariesCounter == 0) {
            return rezString.append("Сотрудников с зарплатой ниже " + lessThanThisNum + " рублей " + " - нет");
        }
        return rezString;
    }

    public StringBuilder salaryMoreThan(int moreThanThisNum) {
        int moreSalariesCounter = 0;
        StringBuilder rezString = new StringBuilder("");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() > moreThanThisNum) {
                rezString.append("- " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() +
                        ", отдел: " + employee.getDept() + "\n");
                moreSalariesCounter++;
            }

        }
        if (moreSalariesCounter == 0) {
           return rezString.append("Сотрудников с зарплатой выше " + moreThanThisNum + " рублей " + " - нет");
        }
        return rezString;
    }




//    public int findEmployeesIdMinimalSalary() throws Exception {
//        if (employees == null) {
//            throw new Exception ("В базе отсутствуют сотрудники");
//        }
//        int min = employees[0].getSalary();
//        int idEmployee = 0;
//        for (int i = 0; i < idCounter; i++) {
//            if (employees[i].getSalary() <= min) {
//                min = employees[i].getSalary();
//                idEmployee = employees[i].getId();
//            }
//        }
//        return idEmployee;
//    }
//
//    public int findEmployeesIdMaximalSalary() {
//        int max = employees[0].getSalary();
//        int idEmployee = 0;
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i].getSalary() > max) {
//                max = employees[i].getSalary();
//                idEmployee = employees[i].getId();
//            }
//        }
//        return idEmployee;
//    }
//
//    public void findAndPrintEmployeeById(int id) {
//        for (int i = 0; i < employees.length; i++) {
//            if (id == employees[i].getId()) {
//                printEmployeeInfo(employees[i]);
//            }
//        }
//    }
//
//    public int monthSumSalary() {
//        int sum = 0;
//        for (int i = 0; i < employees.length; i++) {
//            sum = employees[i].getSalary() + sum;
//        }
//        return sum;
//    }
//
//    public double monthMiddleSalary(int sum) {
//        return (double) sum / employees.length;
//    }
//
//    public double middleSalaryById(int idOfEmployee) {
//        int sumSalaries = 0;
//        int deptsCounter = 0;
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i].getDept() == idOfEmployee) {
//                sumSalaries = employees[i].getSalary() + sumSalaries;
//                deptsCounter++;
//            }
//            if (sumSalaries == 0) {
//                return -1;
//            }
//        }
//        return (double) sumSalaries / deptsCounter;
//    }
//
//    public static int getIdCounter() {
//        return idCounter;
//    }
//
//    public static void setIdCounter(int idCounter) {
//        EmployeeBook.idCounter = idCounter;
//    }
//

}
