package com.zaurtregulov.spring.springboot.spring_course_springboot.controller;

import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_course_springboot.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MyController {

  final private EmployeeService employeeService;

  @GetMapping("/ok")
  public String printOk() {

    return ">>>>>>>>>>> OK (всё хорошо!)";
  }

  @GetMapping("/employees")
  public List<Employee> showAllEmployees() {

    List<Employee> allEployees = employeeService.getAllEmployees();

    return allEployees;
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable int id) {

    Employee emp = employeeService.getEmployee(id);

//    if (emp == null) throw new NoSuchEmployeeException("Нет сотрудника с ID = " + id);

    return emp;
  }

  @PostMapping("/employees")
  public Employee addNewEmployee(@RequestBody Employee employee){

    employeeService.saveEmployee(employee);
    System.out.println(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee){

    employeeService.saveEmployee(employee);

    return employee;
  }

  @DeleteMapping(value = "/employees/{id}", produces = "text/html; charset=utf-8")
  public String deleteEmployee(@PathVariable int id) {

    Employee emp = employeeService.getEmployee(id);

   // if (emp == null) throw new NoSuchEmployeeException("Нет сотрудника с ID = " + id);

    employeeService.deleteEmployee(id);

    return "Сотрудник " + emp.getSurname() + " погорел";
  }




}
