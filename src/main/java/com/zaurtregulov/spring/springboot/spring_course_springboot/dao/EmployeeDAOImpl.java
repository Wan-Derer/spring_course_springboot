package com.zaurtregulov.spring.springboot.spring_course_springboot.dao;

import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Override
  public List<Employee> getAllEmployees() {

//    Session session = entityManager.unwrap(Session.class);
//    List<Employee> allEmployees = session.createQuery("from Employee ", Employee.class).getResultList();

    Query query = entityManager.createQuery("from Employee ");
    List<Employee> allEmployees = query.getResultList();

    return allEmployees;
  }

  @Override
  public void saveEmployee(Employee employee) {

//    Session session = entityManager.unwrap(Session.class);
//    session.saveOrUpdate(employee);

    Employee newEmp = entityManager.merge(employee);
    employee.setId(newEmp.getId());

  }


  @Override
  public Employee getEmployee(int id) {
//    Session session = entityManager.unwrap(Session.class);
//    return session.get(Employee.class, id);

    return entityManager.find(Employee.class, id);

  }


  @Override
  public void deleteEmployee(int id) {

//    Session session = entityManager.unwrap(Session.class);
//    Query<?> query = session.createQuery("delete from Employee where id = :employeeID");
//    query.setParameter("employeeID", id);
//
//    query.executeUpdate();

    entityManager.remove(getEmployee(id));

  }



 }



