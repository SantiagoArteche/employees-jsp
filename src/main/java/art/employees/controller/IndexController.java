package art.employees.controller;


import art.employees.model.Employee;
import art.employees.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(ModelMap model){
        List<Employee> employees = employeeService.listEmployees();
        employees.forEach(employee -> logger.info(employee.toString()));
        model.put("employees", employees);
        return "index";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd(){
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("employeeForm") Employee employee, HttpServletRequest request){
        logger.info("Employee to add: " + employee);
        this.employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEdit(@RequestParam int id, ModelMap model){
        Employee employee = this.employeeService.findEmployeeById(id);
        logger.info("Employee to update: " + employee);
        model.put("employee", employee);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("employeeUpdate") Employee employee, HttpServletRequest request){
        logger.info("Employee to update: " + employee);
        this.employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id){
        this.employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
