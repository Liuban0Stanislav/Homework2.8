package com.skypro.homework2_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    private EmployeeBook employeeBook;

    public Controller(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }

    @GetMapping("/")
    public String getEmployees(){
        return "Список всех сотрудников: " + getEmployees();
    }
}
