package sky.pro.EmployeeBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam int departmentID) {
        return departmentService.findEmployeeWithMaxSalary(departmentID);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam int departmentID) {
        return departmentService.findEmployeeWithMinSalary(departmentID);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployeeByDepartment() {
        return departmentService.findEmployeesByDepartment();
    }

    @GetMapping(value = "/all", params = {"departmentID"})
    public Collection<Employee> findEmployeeByDepartment(@RequestParam int departmentID) {
        return departmentService.findEmployeesByDepartment(departmentID);
    }
}
