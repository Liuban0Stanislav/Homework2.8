package com.skypro.homework2_8;

import java.util.Objects;

public class Employee {
    private String fullName;
    private int salary;
    private int dept;
    private int id;
    private static int idCounter = 0;

    public Employee(String fullName, int salary, int dept) {
        this.fullName = fullName;
        this.salary = salary;
        this.dept = dept;
        this.id = idCounter++;
    }

    public String getFirstName() {
        return fullName;
    }

    public int getDept() {
        return dept;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.fullName = firstName;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + fullName.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", dept=" + dept +
                ", id=" + id +
                '}';
    }
}
