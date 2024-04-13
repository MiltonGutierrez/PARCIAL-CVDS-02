package co.edu.escuelaing.cvds.lab7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployees(Model model){
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("list", employees);
        return "employees";
    }

    @GetMapping("/new")
    public String getNewEmployee(){
        return "create";
    }

    @PostMapping("/new/confirm")
    public String createEmployee(@RequestParam Integer employeeId, String firstName,String lastName, String role, String salary){
        employeeService.createEmployee(employeeId, firstName, lastName, role, salary);
        return "redirect:/employees";
    }

    @PostMapping("/update")
    public String updateEmployee(Model model, Integer employeeId){
        model.addAttribute("employeeId",employeeId);
        return "update";
    }

    @PostMapping("/update/confirm")
    public String updateEmployee(@RequestParam Integer employeeId, String firstName, String lastName){
        employeeService.updateEmployee(employeeId, firstName, lastName);
        return "redirect:/employees";
    }

    @PostMapping("/delete/confirm")
    public String deleteEmployee(@RequestParam Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees";
    }

    
}