package com.zaurtregulov.spring.springboot.spring_course_springboot.dao;

import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Override
  public List<Employee> getAllEmployees() {

    Session session = entityManager.unwrap(Session.class);
    List<Employee> allEmployees = session.createQuery("from Employee ", Employee.class).getResultList();

    return allEmployees;
  }

  @Override
  public void saveEmployee(Employee employee) {

    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(employee);

  }


  @Override
  public Employee getEmployee(int id) {
    Session session = entityManager.unwrap(Session.class);
    return session.get(Employee.class, id);
  }


  @Override
  public void deleteEmployee(int id) {
//    sessionFactory.getCurrentSession().delete(getEmployeeById(id));

    Session session = entityManager.unwrap(Session.class);
    Query<?> query = session.createQuery("delete from Employee where id = :employeeID");
    query.setParameter("employeeID", id);

    query.executeUpdate();

  }



 }



