package art.employees.service;

import art.employees.model.Employee;
import art.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listEmployees(){
        return this.employeeRepository.findAll();
    };

    @Override
    public Employee findEmployeeById(Integer idEmployee){
        return this.employeeRepository.findById(idEmployee).orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer idEmployee){
        this.employeeRepository.deleteById(idEmployee);
    }
}
