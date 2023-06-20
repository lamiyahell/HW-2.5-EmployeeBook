package sky.pro.EmployeeBook.service;

import org.springframework.stereotype.Service;
import sky.pro.EmployeeBook.Employee;
import sky.pro.EmployeeBook.exception.EmployeeAlreadyAddedException;
import sky.pro.EmployeeBook.exception.EmployeeNotFoundException;
import sky.pro.EmployeeBook.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Petr", "Petrov"),
            new Employee("Anna", "Morozova"),
            new Employee("Max","Maximov"),
            new Employee("Jon", "Lenon")
    ));
    int maxCounts = 5;

//    public EmployeeServiceImpl(List<Employee> employeeList) {
//        this.employeeList = employeeList;
//    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else if (!employeeList.contains(employee) && employeeList.size() < maxCounts) {
            employeeList.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employeeList);
    }
}
