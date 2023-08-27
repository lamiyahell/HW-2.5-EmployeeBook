package sky.pro.EmployeeBook.service.impl;

import sky.pro.EmployeeBook.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeTestConstants {
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";

    public static final String FIRST_NAME2 = "Petr";
    public static final String LAST_NAME2 = "Petrov";

    public static final String FIRST_NAME3 = "Semen";
    public static final String LAST_NAME3 = "Semenov";

    public static final Integer SALARY = 100;
    public static final Integer SALARY2 = 200;

    public static final Integer DEPARTMENT_ID = 1;
    public static final Integer DEPARTMENT_ID2 = 2;

    public static final Employee employeeWithMaxSalary = new Employee(FIRST_NAME, LAST_NAME, SALARY2, DEPARTMENT_ID);
    public static final Employee employeeWithMinSalary = new Employee(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID);
    public static final Employee otherDepartmentEmployee = new Employee(FIRST_NAME3, LAST_NAME3, SALARY, DEPARTMENT_ID2);

    public static final List<Employee> EMPLOYEES = List.of(employeeWithMaxSalary, employeeWithMinSalary);
    public static final List<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES =
            List.of(employeeWithMaxSalary, employeeWithMinSalary, otherDepartmentEmployee);

    public static final int EMPLOYEES_TOTAL_SALARY = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();
    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENT_MAP =
            DIFFERENT_DEPARTMENT_EMPLOYEES.stream().collect(Collectors.groupingBy(Employee::getDepartmentID));
}
