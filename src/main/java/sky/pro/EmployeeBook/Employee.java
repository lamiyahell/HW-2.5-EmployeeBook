package sky.pro.EmployeeBook;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int salary;
    private int departmentID;

    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = random.nextInt(10000) + 1000;
        this.departmentID = random.nextInt(5) + 1;
    }

    public Employee(String firstName, String lastName, int salary, int departmentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentID = departmentID;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departmentID == employee.departmentID && Objects.equals(firstName,
                employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departmentID);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentID=" + departmentID +
                '}';
    }
}
