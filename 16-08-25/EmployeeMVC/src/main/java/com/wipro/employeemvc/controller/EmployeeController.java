package com.wipro.employeemvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.employeemvc.entity.Employee;
import com.wipro.employeemvc.exception.ResourceNotFoundException;
import com.wipro.employeemvc.service.DepartmentService;
import com.wipro.employeemvc.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;
	@Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // --- ADD EMPLOYEE ---
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.findAll()); // department dropdown
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/";
    }

    // --- SHOW EMPLOYEES ---
    @GetMapping("/show")
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "show-employees";
    }

    // --- UPDATE EMPLOYEE ---
    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        return "update-ask-id";
    }

    @PostMapping("/update")
    public String updateEmployee(@RequestParam Long id, Model model) {
        Employee emp = employeeService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
        
        model.addAttribute("employee", emp);
        model.addAttribute("departments", departmentService.findAll());
        return "update-employee";
    }

    @PostMapping("/update/save")
    public String saveUpdatedEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/";
    }

    // --- DELETE EMPLOYEE ---
    @GetMapping("/delete")
    public String deleteAskId() {
        return "delete-ask-id";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Long id, Model model) {
        Employee emp = employeeService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
        
        employeeService.deleteById(id);
        model.addAttribute("message", "Employee deleted successfully!");
        return "delete-ask-id";
    }

}
