package co.edu.escuelaing.cvds.lab7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Integer id, String firstName, String lastName, String role, String salary){
        Employee newEmployee = new Employee(id, firstName, lastName, role, Double.parseDouble(salary));
        employeeRepository.save(newEmployee);
    }

    public void updateEmployee(Integer id, String firstName, String lastName){
        Employee employee;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        
        if(optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employeeRepository.save(employee);
        }

    }

    public void deleteEmployee(Integer id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
        }
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

}
