package sky.pro.EmployeeBook.controller;

import org.springframework.web.bind.annotation.*;
import sky.pro.EmployeeBook.Employee;
import sky.pro.EmployeeBook.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentID}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable int departmentID) {
        return departmentService.getDepartmentSalarySum(departmentID);
    }

    @GetMapping("/{departmentID}/salary/max")
    public Employee findEmployeeWithMaxSalary(@PathVariable int departmentID) {
        return departmentService.findEmployeeWithMaxSalary(departmentID);
    }

    @GetMapping("/{departmentID}/salary/min")
    public Employee findEmployeeWithMinSalary(@PathVariable int departmentID) {
        return departmentService.findEmployeeWithMinSalary(departmentID);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> findEmployeeByDepartment() {
        return departmentService.findEmployeesByDepartment();
    }

    @GetMapping(value = "/{departmentID}/employees")
    public Collection<Employee> findEmployeeByDepartment(@PathVariable int departmentID) {
        return departmentService.findEmployeesByDepartment(departmentID);
    }
}
