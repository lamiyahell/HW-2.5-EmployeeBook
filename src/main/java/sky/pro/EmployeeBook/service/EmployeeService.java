package sky.pro.EmployeeBook.service;

import sky.pro.EmployeeBook.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    List<Employee> findAll();
}
