package com.springboot.gcplab.gcpcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.springboot.gcplab.gcpmodel.Employee;
import com.springboot.gcplab.repository.EmployeeRepo;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeData;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addEmployee(Model model) {
	Employee employee = new Employee();
	model.addAttribute("employee",employee);
	
	return "new_employee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeData.save(employee);
		
	    return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		List<Employee> listEmployee = employeeData.findAll();
		model.addAttribute("listEmployee", listEmployee);
		
		return "list_employee";
	}
}
