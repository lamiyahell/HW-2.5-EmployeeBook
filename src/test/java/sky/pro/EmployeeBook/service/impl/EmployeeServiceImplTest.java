package sky.pro.EmployeeBook.service.impl;

import org.junit.jupiter.api.Test;
import sky.pro.EmployeeBook.Employee;
import sky.pro.EmployeeBook.exception.EmployeeAlreadyAddedException;
import sky.pro.EmployeeBook.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.EmployeeBook.service.impl.EmployeeTestConstants.*;

class EmployeeServiceImplTest {
    private final EmployeeValidationServiceImpl employeeValidationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeValidationService);

    @Test
    public void shouldAllEmployee() {
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertFalse(employeeService.findAll().contains(employee));

        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(addedEmployee, employee);
        assertTrue(employeeService.findAll().contains(employee));
        assertEquals(1, employeeService.findAll().size());
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        Employee addedEmployee = employeeService.add(FIRST_NAME3, LAST_NAME3, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FIRST_NAME3, LAST_NAME3, SALARY, DEPARTMENT_ID));
        }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME3, LAST_NAME3, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertEquals(1, employeeService.findAll().size());

        Employee removeEmployee = employeeService.remove(FIRST_NAME3, LAST_NAME3);
        assertEquals(addedEmployee, removeEmployee);
        assertFalse(employeeService.findAll().contains(addedEmployee));
        assertEquals(0, employeeService.findAll().size());
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME3, LAST_NAME3, SALARY, DEPARTMENT_ID);
        assertEquals(addedEmployee, employeeService.find(FIRST_NAME3, LAST_NAME3));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(FIRST_NAME3, LAST_NAME3));
    }

    @Test
    public void shouldFindAllEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME3, LAST_NAME3, SALARY, DEPARTMENT_ID);
        Employee addedEmployee2 = employeeService.add(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID);

        assertIterableEquals(List.of(addedEmployee,addedEmployee2), employeeService.findAll());
    }
}