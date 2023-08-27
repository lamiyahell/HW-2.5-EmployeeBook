package sky.pro.EmployeeBook.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.EmployeeBook.Employee;
import sky.pro.EmployeeBook.exception.EmployeeAlreadyAddedException;
import sky.pro.EmployeeBook.exception.EmployeeNotFoundException;
import sky.pro.EmployeeBook.exception.EmployeeStorageIsFullException;
import sky.pro.EmployeeBook.service.EmployeeService;
import sky.pro.EmployeeBook.service.EmployeeValidationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private final EmployeeValidationService validationService;
    int maxCounts = 30;

    public EmployeeServiceImpl(EmployeeValidationService validationService) {
        this.validationService = validationService;
        this.employees = new HashMap<>();
    }

    public Employee add(String firstName, String lastName) {
        validationService.validate(firstName,lastName);
        Employee employee = new Employee(capitalize(firstName), capitalize(lastName));
        return add(employee);
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentID) {
        validationService.validate(firstName,lastName);
        Employee employee = new Employee(capitalize(firstName), capitalize(lastName), salary, departmentID);
        return add(employee);
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    private Employee add(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } else if (!employees.containsKey(employee.getFullName()) && employees.size() < maxCounts) {
            employees.put(employee.getFullName(), employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }
}
