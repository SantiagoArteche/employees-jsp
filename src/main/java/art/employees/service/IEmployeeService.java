package art.employees.service;

import art.employees.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> listEmployees();
    Employee findEmployeeById(Integer idEmployee);
    void saveEmployee(Employee employee);
    void deleteEmployee(Integer idEmployee);
}
