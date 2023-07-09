package sky.pro.EmployeeBook.service;

import org.springframework.stereotype.Service;
import sky.pro.EmployeeBook.Employee;
import sky.pro.EmployeeBook.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentID) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentID) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentID) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
    }
}
