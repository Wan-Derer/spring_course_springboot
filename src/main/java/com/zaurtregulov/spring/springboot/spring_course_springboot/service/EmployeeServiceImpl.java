package com.zaurtregulov.spring.springboot.spring_course_springboot.service;

import com.zaurtregulov.spring.springboot.spring_course_springboot.dao.EmployeeDAO;
import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

  private EmployeeDAO employeeDAO;

  @Override
  @Transactional
  public List<Employee> getAllEmployees() {
    return employeeDAO.getAllEmployees();
  }

  @Override
  @Transactional
  public void saveEmployee(Employee employee) {
    employeeDAO.saveEmployee(employee);
  }

  @Transactional
  @Override
  public Employee getEmployee(int id) {
    return employeeDAO.getEmployee(id);
  }

  @Transactional
  @Override
  public void deleteEmployee(int id) {
    employeeDAO.deleteEmployee(id);
  }


}
