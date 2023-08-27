package sky.pro.EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.EmployeeBook.Employee;
import sky.pro.EmployeeBook.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @GetMapping("/add")
        public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.add(firstName, lastName);
        }

        @GetMapping("/add-full")
        public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                    @RequestParam Integer salary, @RequestParam Integer departmentID) {
            return employeeService.add(firstName, lastName);
        }

        @GetMapping("/remove")
        public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.remove(firstName,lastName);
        }

        @GetMapping("/find")
        public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.find(firstName, lastName);
        }

        @GetMapping
        public List<Employee> findAll() {
            return employeeService.findAll();
        }
}
