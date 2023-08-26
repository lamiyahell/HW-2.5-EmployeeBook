package sky.pro.EmployeeBook.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.EmployeeBook.exception.EmployeeNotFoundException;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static sky.pro.EmployeeBook.service.impl.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnDepartmentSalarySum() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEES_TOTAL_SALARY, departmentService.getDepartmentSalarySum(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnDepartmentIdWithMaxEmployee() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(employeeWithMaxSalary, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnDepartmentIdWithMinEmployee() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(employeeWithMinSalary, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFindExceptionWhenFindEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFindExceptionWhenFindEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeesByDepartmentId() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(EMPLOYEES, departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(otherDepartmentEmployee), departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void shouldReturnAllEmployees() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES_BY_DEPARTMENT_MAP, departmentService.findEmployeesByDepartment());
    }
}